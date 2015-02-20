package lain.mods.omnipaper;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

@Mod(modid = "OmniPaper", useMetadata = true)
public class OmniPaper
{

    private static Map<String, List<String>> getData(ItemStack stack)
    {
        if (cachedData.containsKey(stack))
            return cachedData.get(stack);
        if (stack.hasTagCompound() && stack.getTagCompound().hasKey("pages", 9))
        {
            Map<String, List<String>> result = null;
            NBTTagList pages = stack.getTagCompound().getTagList("pages", 8);
            for (int i = 0; i < pages.tagCount(); i++)
            {
                String page = pages.getStringTagAt(i);
                if (page == null || page.length() > 32767)
                {
                    if (result != null)
                        result = null;
                    break;
                }
                Matcher matcher = dataPattern.matcher(page);
                while (matcher.find())
                {
                    String data = matcher.group();
                    data = data.substring(1, data.length() - 1).replace("\\u003d", "=");
                    if (!data.isEmpty())
                    {
                        if (result == null)
                            result = Maps.newHashMap();
                        String key, value;
                        int index = data.indexOf("=");
                        if (index != -1)
                        {
                            key = data.substring(0, index);
                            value = data.substring(index + 1, data.length());
                        }
                        else
                        {
                            key = null;
                            value = data;
                        }
                        List<String> values = result.get(key);
                        if (values == null)
                        {
                            values = Lists.newArrayList();
                            result.put(key, values);
                        }
                        // System.out.println(String.format("[%s=%s]", key, value));
                        values.add(value);
                    }
                }
            }
            if (result == null)
                result = Collections.emptyMap();
            cachedData.put(stack, result);
            return result;
        }
        return Collections.emptyMap();
    }

    public static double getDurabilityForDisplay(ItemStack stack, double result)
    {
        if (stack.getItemDamage() > 0)
        {
            Map<String, List<String>> data = getData(stack);
            if (data.containsKey("Damage") && data.containsKey("MaxDamage"))
            {
                double durability = SafeParse.parseDouble(data.get("Damage").get(0));
                double maxdurability = SafeParse.parseDouble(data.get("MaxDamage").get(0));
                return durability / maxdurability;
            }
        }
        return result;
    }

    public static int getItemStackLimit(ItemStack stack, int result)
    {
        if (stack.getItemDamage() > 0)
        {
            Map<String, List<String>> data = getData(stack);
            if (data.containsKey("MaxStackSize"))
                return SafeParse.parseInteger(data.get("MaxStackSize").get(0));
        }
        return result;
    }

    public static int getMetadata(ItemStack stack, int result)
    {
        if (stack.getItemDamage() > 0)
        {
            Map<String, List<String>> data = getData(stack);
            if (data.containsKey("ItemId"))
                return SafeParse.parseInteger(data.get("ItemId").get(0));
        }
        return result;
    }

    public static String getUnlocalizedName(ItemStack stack, String result)
    {
        if (stack.getItemDamage() > 0)
        {
            Map<String, List<String>> data = getData(stack);
            if (data.containsKey("Name"))
                return "item." + data.get("Name").get(0);
        }
        return result;
    }

    public static boolean hasEffect(ItemStack stack, boolean result)
    {
        if (stack.getItemDamage() > 0)
        {
            Map<String, List<String>> data = getData(stack);
            if (data.containsKey("ForceEffect"))
                return Boolean.parseBoolean(data.get("ForceEffect").get(0));
            return !EnchantmentHelper.getEnchantments(stack).isEmpty();
        }
        return result;
    }

    public static boolean showDurabilityBar(ItemStack stack, boolean result)
    {
        if (stack.getItemDamage() > 0)
        {
            Map<String, List<String>> data = getData(stack);
            if (data.containsKey("DoRenderDurability"))
            {
                boolean flag = Boolean.parseBoolean(data.get("DoRenderDurability").get(0));
                if (flag && data.containsKey("Damage") && SafeParse.parseDouble(data.get("Damage").get(0)) <= 0D)
                    flag = false;
                return flag;
            }
        }
        return result;
    }

    private static final Map<ItemStack, Map<String, List<String>>> cachedData = new MapMaker().weakKeys().makeMap();
    private static final Pattern dataPattern = Pattern.compile("\\[.*?\\]");
    private static final Set<String> addedModel = Sets.newHashSet();

    @SubscribeEvent
    public void handleEvent(ItemTooltipEvent event)
    {
        if (event.itemStack.getItem() == Items.written_book)
        {
            ItemStack stack = event.itemStack;
            if (stack.getItemDamage() > 0)
            {
                Map<String, List<String>> data = getData(stack);
                String author = Strings.emptyToNull(stack.getTagCompound().getString("author"));
                if (author != null)
                    author = EnumChatFormatting.GRAY + StatCollector.translateToLocalFormatted("book.byAuthor", author);
                String generation = EnumChatFormatting.GRAY + StatCollector.translateToLocal(new StringBuilder().append("book.generation.").append(stack.getTagCompound().getInteger("generation")).toString());
                if (author != null && !data.containsKey("ShowAuthor") || !Boolean.parseBoolean(data.get("ShowAuthor").get(0)))
                    event.toolTip.remove(author);
                if (!data.containsKey("ShowGeneration") || !Boolean.parseBoolean(data.get("ShowGeneration").get(0)))
                    event.toolTip.remove(generation);
                if (data.containsKey("Tooltip"))
                {
                    for (String str : data.get("Tooltip"))
                        event.toolTip.add(str);
                }
            }
        }
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(this);

        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Items.written_book, new ItemMeshDefinition()
        {

            @Override
            public ModelResourceLocation getModelLocation(ItemStack stack)
            {
                if (stack.getItemDamage() > 0)
                {
                    Map<String, List<String>> data = getData(stack);
                    String model = "written_book";
                    if (data.containsKey("Model"))
                        model = data.get("Model").get(0);
                    if (!addedModel.contains(model))
                    {
                        ModelBakery.addVariantName(Items.written_book, model);
                        addedModel.add(model);
                    }
                    return new ModelResourceLocation(model, "inventory");
                }
                return null;
            }

        });
    }
}
