package lain.mods.omnipaper;

import java.util.List;
import java.util.Map;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class Test
{

    public static void main(String[] args)
    {
        Map<String, List<String>> a = Maps.newHashMap();
        a.put(null, Lists.newArrayList("dd", "cc"));
        for (String b : a.keySet())
        {
            System.out.println(b);
            for (String c : a.get(b))
                System.out.println("  " + c);
        }
        System.out.println(a.containsKey(null));
        System.out.println(Double.parseDouble("22"));
    }

}
