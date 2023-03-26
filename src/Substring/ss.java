package Substring;

import java.util.Arrays;

public class ss {
    public static void main(String[] args) {
//        String s = new String("baccab");
//        removea("", s);
//        String j = new String("abc");
//        subsetofstring("", j);
        String a = "abc";
        String b = "def";
        System.out.println(a.charAt(0) + b.charAt(0));
    }

//    public static void subset(int up[], int p[])
//    {
//        if(up.length==0)
//        {
//            System.out.println(Arrays.toString(p));
//            return;
//        }
//        subset(up, up.);
//    }

    public static void subsetofstring(String p, String up)
    {
        if(up.isEmpty())
        {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        subsetofstring(p,up.substring(1));
        subsetofstring(p + ch, up.substring(1));
    }

    public static void removea(String p,String up)
    {
        if(up.isEmpty())
        {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        if(ch == 'a')
        {

        }
        else {
            p = p + ch;
        }
        removea(p,up.substring(1));
    }
}
