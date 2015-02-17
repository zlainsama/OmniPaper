package lain.mods.omnipaper.asm;

import lain.mods.omnipaper.OmniPaper;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Hooks
{

    public static double getDurabilityForDisplay(Item item, ItemStack stack, double result)
    {
        if (item == Items.paper)
            return OmniPaper.getDurabilityForDisplay(stack, result);
        return result;
    }

    public static int getMetadata(Item item, ItemStack stack, int result)
    {
        if (item == Items.paper)
            return OmniPaper.getMetadata(stack, result);
        return result;
    }

    public static String getUnlocalizedName(Item item, ItemStack stack, String result)
    {
        if (item == Items.paper)
            return OmniPaper.getUnlocalizedName(stack, result);
        return result;
    }

    public static boolean showDurabilityBar(Item item, ItemStack stack, boolean result)
    {
        if (item == Items.paper)
            return OmniPaper.showDurabilityBar(stack, result);
        return result;
    }

}
