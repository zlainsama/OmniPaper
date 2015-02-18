package lain.mods.omnipaper.asm;

public class ObfHelper
{

    public static String newName(String obfName, String deobfName)
    {
        return Plugin.runtimeDeobfuscationEnabled ? obfName : deobfName;
    }

}
