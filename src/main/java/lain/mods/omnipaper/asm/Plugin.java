package lain.mods.omnipaper.asm;

import java.util.Map;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;

@IFMLLoadingPlugin.Name("OmniPaper")
@IFMLLoadingPlugin.MCVersion("")
@IFMLLoadingPlugin.TransformerExclusions("lain.mods.omnipaper.asm.")
public class Plugin implements IFMLLoadingPlugin
{

    @Override
    public String getAccessTransformerClass()
    {
        return null;
    }

    @Override
    public String[] getASMTransformerClass()
    {
        return new String[] { "lain.mods.omnipaper.asm.ASMTransformer" };
    }

    @Override
    public String getModContainerClass()
    {
        return "lain.mods.omnipaper.OmniPaper";
    }

    @Override
    public String getSetupClass()
    {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> arg0)
    {
    }

}
