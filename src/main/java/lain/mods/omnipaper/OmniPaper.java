package lain.mods.omnipaper;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.DummyModContainer;
import net.minecraftforge.fml.common.LoadController;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import com.google.common.collect.Lists;
import com.google.common.eventbus.EventBus;

public class OmniPaper extends DummyModContainer
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
            return 1D - ((double) meta / 10D);
        }
        return result;
    }

    public static int getMetadata(ItemStack stack, int result)
    {
        // TODO finalize protocol
        List<String> data = getData(stack);
        if (!data.isEmpty())
            return 0;
        return result;
    }

    public static String getUnlocalizedName(ItemStack stack, String result)
    {
        // TODO finalize protocol
        List<String> data = getData(stack);
        if (!data.isEmpty())
            return result + ".special";
        return result;
    }

    public static boolean showDurabilityBar(ItemStack stack, boolean result)
    {
        // TODO finalize protocol
        List<String> data = getData(stack);
        if (!data.isEmpty())
            return true;
        return result;
    }

    private static String unhideString(String string)
    {
        return string.replace("\u00a7", "");
    }

    private static Pattern dataPattern = Pattern.compile("(\\[DATA=.*\\])");

    public OmniPaper()
    {
        super(new ModMetadata());
        ModMetadata meta = getMetadata();
        meta.modId = "OmniPaper";
        meta.name = "OmniPaper";
        meta.version = "1.8-v0";
        meta.authorList = Arrays.asList("zlainsama");
        meta.description = "";
        meta.credits = "";
        meta.url = "https://github.com/zlainsama/omnipaper";
        meta.updateUrl = "";
    }

    @SubscribeEvent
    public void init(FMLPreInitializationEvent event)
    {

    }

    @Override
    public boolean registerBus(EventBus bus, LoadController controller)
    {
        bus.register(this);
        return true;
    }

}
