package Substring;

import java.util.ArrayList;

public class lettercombination {
    public static void main(String[] args) {
        ArrayList<String> B = new ArrayList<String>(10);
        B = recwitharraylist("","12");
        System.out.println(B);

        ArrayList<Integer> arr = new ArrayList<>(10);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        System.out.println(arr);
        arr.remove(arr.size()-1);
        System.out.println(arr);
    }

    public static void rec(String p, String up)
    {
        if (up.isEmpty())
        {
            System.out.println(p);
            return;
        }
        int digit = up.charAt(0) - '0';
        for (int i=(digit-1)*3; i<digit*3;i++)
        {
            char ch = (char)('a' + i);
            rec(p + ch, up.substring(1));
        }
    }

    public static ArrayList<String> recwitharraylist(String p, String up)
    {
        if (up.isEmpty())
        {
            ArrayList<String> a = new ArrayList<>(10);
            a.add(p);
            return a;
        }
        int digit = up.charAt(0) - '0';

        ArrayList<String> a = new ArrayList<>(10);
        for (int i=(digit-1)*3; i<digit*3;i++)
        {
            char ch = (char)('a' + i);
            a.addAll(recwitharraylist(p + ch, up.substring(1)));
        }
        return a;
    }
}
