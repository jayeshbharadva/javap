package backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class maze {
    public static void main(String[] args) {
        int n =count(3,3,0);
        //System.out.println(n);
        ArrayList<Integer> ls = new ArrayList<>(10);
        boolean[][] arr = {
                {true,true,true},
                {true,true,true},
                {true,true,true},
        };
        int[][] a = new int[3][3];
        alldirectionwithcount("",arr,0,0,a,1);
        //System.out.println(ls);
    }

    public static int count(int r, int c,int cnt)
    {
        if(r==1 || c == 1)
        {
            cnt++;
            return cnt;
        }
        cnt = count(r-1,c,cnt);
        cnt = count(r,c-1,cnt);
        return cnt;
    }

    public static ArrayList<String> path(String p, int r, int c)
    {
        if(r==1 && c == 1)
        {
            ArrayList<String> list = new ArrayList<>(10);
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>(10);
        if (r>1) {
            list.addAll(path(p + "d", r - 1, c));
        }
        if (c>1){
        list.addAll(path(p + "r",r,c-1));
        }
        return list;
    }

    public static ArrayList<String> pathdiagonal(String p, int r, int c)
    {
        if(r==1 && c == 1)
        {
            ArrayList<String> list = new ArrayList<>(10);
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>(10);
        if (r>1) {
            list.addAll(pathdiagonal(p + "d", r - 1, c));
        }
        if (c>1){
            list.addAll(pathdiagonal(p + "r",r,c-1));
        }
        if (r>1 && c>1) {
            list.addAll(pathdiagonal(p + "D", r - 1, c - 1));
        }
        return list;
    }

    public static void pathwithobstecle(String p,boolean[][] maje, int r, int c)
    {
        if(r== maje.length-1 && c == maje[0].length-1)
        {
            System.out.println(p);
            return;
        }
        if (!maje[r][c])
        {
            return;
        }
        if (r<maje.length-1) {
            pathwithobstecle(p + "d", maje,r + 1, c);
        }
        if (c<maje[0].length-1) {
            pathwithobstecle(p + "r", maje, r, c + 1);
        }
    }

    public static void alldirection(String p,boolean[][] maje, int r, int c)
    {
        if(r== maje.length-1 && c == maje[0].length-1)
        {
            System.out.println(p);
            return;
        }
        if (!maje[r][c])
        {
            return;
        }
        maje[r][c] = false;
        if (r<maje.length-1) {
            alldirection(p + "d", maje,r + 1, c);
        }
        if (c<maje[0].length-1) {
            alldirection(p + "r", maje, r, c + 1);
        }
        if (c>0)
        {
            alldirection(p + "L",maje,r,c-1);
        }
        if(r>0)
        {
            alldirection(p + "U",maje,r-1,c);
        }
        maje[r][c] = true;
    }

    public static void alldirectionwithcount(String p,boolean[][] maje, int r, int c,int[][] a,int cnt)
    {
        if(r== maje.length-1 && c == maje[0].length-1)
        {
            a[r][c] = cnt;
            for (int i =0; i<3; i++) {
                System.out.println(Arrays.toString(a[i]));
            }
            System.out.println(p);
            return;
        }
        if (!maje[r][c])
        {
            return;
        }
        maje[r][c] = false;
        a[r][c] = cnt;
        if (r<maje.length-1) {
            alldirectionwithcount(p + "d", maje,r + 1, c, a,cnt + 1);
        }
        if (c<maje[0].length-1) {
            alldirectionwithcount(p + "r", maje, r, c + 1,a,cnt + 1);
        }
        if (c>0)
        {
            alldirectionwithcount(p + "L",maje,r,c-1,a,cnt + 1);
        }
        if(r>0)
        {
            alldirectionwithcount(p + "U",maje,r-1,c,a,cnt + 1);
        }
        maje[r][c] = true;
        a[r][c] = 0;
    }
}
