package lain.mods.omnipaper;

import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.google.common.collect.Lists;

@Mod(modid = "OmniPaper", useMetadata = true)
public class OmniPaper
{

    private static List<String> getData(ItemStack stack)
    {
        NBTTagCompound tmp = stack.getTagCompound();
        if (tmp != null && tmp.hasKey("display", 10))
        {
            tmp = tmp.getCompoundTag("display");
            if (tmp.hasKey("Name", 8))
                return getData(tmp.getString("Name"));
        }
        return Collections.emptyList();
    }

    private static List<String> getData(String string)
    {
        Matcher matcher = dataPattern.matcher(unhideString(string));
        List<String> result = null;
        while (matcher.find())
        {
            if (result == null)
                result = Lists.newLinkedList();
            String data = matcher.group();
            data = data.substring(6, data.length() - 1);
            if (!data.isEmpty())
                result.add(data);
        }
        if (result != null)
            return result;
        return Collections.emptyList();
    }

    public static double getDurabilityForDisplay(ItemStack stack, double result)
    {
        // TODO finalize protocol
        List<String> data = getData(stack);
        if (!data.isEmpty())
        {
            int meta = Integer.parseInt(data.get(0));
            return (double) meta / 10D;
        }
        return result;
    }

    public static int getMetadata(ItemStack stack, int result)
    {
        // TODO finalize protocol
        List<String> data = getData(stack);
        if (!data.isEmpty())
            return 1;
        return result;
    }

    public static String getUnlocalizedName(ItemStack stack, String result)
    {
        // TODO finalize protocol
        List<String> data = getData(stack);
        if (!data.isEmpty())
            return "item.omnipaper";
        return result;
    }

    public static boolean showDurabilityBar(ItemStack stack, boolean result)
    {
        // TODO finalize protocol
        List<String> data = getData(stack);
        if (!data.isEmpty())
        {
            int meta = Integer.parseInt(data.get(0));
            return meta > 0;
        }
        return result;
    }

    private static String unhideString(String string)
    {
        return string.replace("\u00a7", "");
    }

    private static Pattern dataPattern = Pattern.compile("(\\[DATA=(.(?!\\[))*\\])");

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Items.paper, 1, new ModelResourceLocation("omnipaper:omnipaper", "inventory"));
        ModelLoader.addVariantName(Items.paper, "paper", "omnipaper:omnipaper");
    }

}
