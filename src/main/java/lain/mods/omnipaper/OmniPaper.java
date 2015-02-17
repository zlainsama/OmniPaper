package lain.mods.omnipaper;

import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ExistingSubstitutionException;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.Level;
import com.google.common.collect.Lists;

@Mod(modid = "OmniPaper", useMetadata = true)
public class OmniPaper
{

    public static class ItemOmniPaper extends Item
    {

        @Override
        public double getDurabilityForDisplay(ItemStack stack)
        {
            // TODO finalize protocol
            List<String> data = getData(stack);
            if (!data.isEmpty())
            {
                int meta = Integer.parseInt(data.get(0));
                return 1D - ((double) meta / 10D);
            }
            return super.getDurabilityForDisplay(stack);
        }

        @Override
        public String getUnlocalizedName(ItemStack stack)
        {
            // TODO finalize protocol
            List<String> data = getData(stack);
            if (!data.isEmpty())
                return super.getUnlocalizedName(stack) + ".special";
            return super.getUnlocalizedName(stack);
        }

        @Override
        public boolean showDurabilityBar(ItemStack stack)
        {
            // TODO finalize protocol
            List<String> data = getData(stack);
            if (!data.isEmpty())
                return true;
            return super.showDurabilityBar(stack);
        }

    }

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

    private static String unhideString(String string)
    {
        return string.replace("\u00a7", "");
    }

    private static Pattern dataPattern = Pattern.compile("(\\[DATA=.*\\])");

    @Mod.EventHandler
    public void init(FMLPreInitializationEvent event)
    {
        try
        {
            GameRegistry.addSubstitutionAlias("minecraft:paper", GameRegistry.Type.ITEM, new ItemOmniPaper().setUnlocalizedName("paper").setCreativeTab(CreativeTabs.tabMisc));
        }
        catch (ExistingSubstitutionException e)
        {
            event.getModLog().throwing(Level.FATAL, e);
        }
    }

}
