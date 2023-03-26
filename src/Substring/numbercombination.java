package Substring;

import java.util.ArrayList;

public class numbercombination {
    public static void main(String[] args) {
        ArrayList<String> b = new ArrayList<String>(20);
                b = rec("",4);
        System.out.println(b);
    }

    public static ArrayList<String> rec(String p, int target)
    {
        if(target == 0)
        {
            ArrayList<String> a = new ArrayList<String>(10);
            a.add(p);
            return a;
        }
        ArrayList<String> a = new ArrayList<String>(10);
        for(int i =1; i<=target; i++)
        {
            a.addAll(rec(p + i, target - i));
        }
        return a;
    }
}
