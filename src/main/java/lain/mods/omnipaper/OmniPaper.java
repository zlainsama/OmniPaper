package lain.mods.omnipaper;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

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

    @Mod.EventHandler
    public void init(FMLPreInitializationEvent event)
    {
        Item.itemRegistry.register(339, new ResourceLocation("paper"), new ItemOmniPaper().setUnlocalizedName("paper").setCreativeTab(CreativeTabs.tabMisc));
    }

}
