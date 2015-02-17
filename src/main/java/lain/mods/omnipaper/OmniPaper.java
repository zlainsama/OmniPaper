package lain.mods.omnipaper;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import com.google.common.collect.Lists;

@Mod(modid = "OmniPaper", useMetadata = true)
public class OmniPaper
{

    public static class ItemOmniPaper extends Item
    {

        @Override
        public double getDurabilityForDisplay(ItemStack stack)
        {
            // TODO insert code to calculate durability bar
            return super.getDurabilityForDisplay(stack);
        }

        @Override
        public String getUnlocalizedName(ItemStack stack)
        {
            // TODO insert code to transform to SPECIAL item
            return super.getUnlocalizedName(stack);
        }

        @Override
        public boolean showDurabilityBar(ItemStack stack)
        {
            // TODO insert code to show durability bar
            return super.showDurabilityBar(stack);
        }

    }

    private static List<String> getData(ItemStack stack)
    {
        return getData(stack.getDisplayName());
    }

    private static List<String> getData(String string)
    {
        Matcher matcher = dataPattern.matcher(unhideString(string));
        List<String> result = Lists.newLinkedList();
        while (matcher.find())
        {
            String data = matcher.group();
            data.substring(6, data.length() - 1);
            if (!data.isEmpty())
                result.add(data);
        }
        return result;
    }

    private static String unhideString(String string)
    {
        return string.replace("\u00a7", "");
    }

    private static Pattern dataPattern = Pattern.compile("(\\[DATA=.*\\])");

    @Mod.EventHandler
    public void init(FMLPreInitializationEvent event)
    {
        Item.itemRegistry.register(339, new ResourceLocation("paper"), new ItemOmniPaper().setUnlocalizedName("paper").setCreativeTab(CreativeTabs.tabMisc));
    }

}
