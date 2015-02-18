package lain.mods.omnipaper.asm;

import lain.mods.omnipaper.OmniPaper;
import net.minecraft.item.ItemEditableBook;
import net.minecraft.item.ItemStack;

public class Hooks
{

    public static double getDurabilityForDisplay(ItemEditableBook item, ItemStack stack, double result)
    {
        return OmniPaper.getDurabilityForDisplay(stack, result);
    }

    public static int getItemStackLimit(ItemEditableBook item, ItemStack stack, int result)
    {
        return OmniPaper.getItemStackLimit(stack, result);
    }

    public static int getMetadata(ItemEditableBook item, ItemStack stack, int result)
    {
        return OmniPaper.getMetadata(stack, result);
    }

    public static String getUnlocalizedName(ItemEditableBook item, ItemStack stack, String result)
    {
        return OmniPaper.getUnlocalizedName(stack, result);
    }

    public static boolean hasEffect(ItemEditableBook item, ItemStack stack, boolean result)
    {
        return OmniPaper.hasEffect(stack, result);
    }

    public static boolean showDurabilityBar(ItemEditableBook item, ItemStack stack, boolean result)
    {
        return OmniPaper.showDurabilityBar(stack, result);
    }

}
