package lain.mods.omnipaper;

public class SafeParse
{

    public static double parseDouble(String s)
    {
        try
        {
            return Double.parseDouble(s);
        }
        catch (NullPointerException e)
        {
            return 0D;
        }
        catch (NumberFormatException e)
        {
            return 0D;
        }
    }

    public static int parseInteger(String s)
    {
        try
        {
            return Integer.parseInt(s);
        }
        catch (NullPointerException e)
        {
            return 0;
        }
        catch (NumberFormatException e)
        {
            return 0;
        }
    }

}
