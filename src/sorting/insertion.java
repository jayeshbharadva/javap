package sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class insertion {
    public static void main(String[] args) {
        int arr[] = {5,4,3,2,1};
        //ArrayList<Integer> arr4 = misssingelementarray(arr);
        //int n = duplicate(arr);
        //System.out.println(arr4);
        //System.out.println(n);
//        ArrayList<Integer> arr3 = allduplicate(arr);
//        System.out.println(arr3);
//        ArrayList<Integer> arr4 = findDisappearedNumbers(arr);
//        int n = cyclic(arr);
//        System.out.println(n);
        QuickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void QuickSort(int arr[], int l, int h)
    {
        if(l>=h)
        {
            return;
        }
        int s = l; int e = h;
        int m = (s + e)/2;
        int pivot = arr[m];
        while(s<e)
        {
            while(arr[s]<pivot)
            {
                s++;
            }
            while(arr[e]>pivot)
            {
                e--;
            }
            if(s<e) {
                swap(arr, s, e);
            }
        }

        QuickSort(arr,l,pivot-1);
        QuickSort(arr,pivot+1,h);
    }

    public static int[] MergeSort(int arr[],int s,int e)
    {
        if(s == e)
        {
            return Arrays.copyOfRange(arr,s,s+1);
        }
        int mid = (s + e)/2;
        int left[] = MergeSort(arr,s,mid);
        int right[] = MergeSort(arr,mid+1,e);
        return Sort(left,right);
    }

    public static int[] Sort(int a1[], int a2[])
    {
        int i=0,j=0,k=0;
        int a3[] = new int[a1.length+a2.length];
        while(i<a1.length && j<a2.length)
        {
            if(a1[i]<a2[j])
            {
                a3[k] = a1[i];
                ++i;
                ++k;
            }
            else
            {
                a3[k] = a2[j];
                ++j;
                ++k;
            }
        }
        while(i< a1.length)
        {
            a3[k] = a1[i];
            ++i;
            ++k;
        }
        while(j<a2.length)
        {
            a3[k] = a2[j];
            ++j;
            ++k;
        }
        return a3;
    }


    public static int duplicate(int arr[])
    {
        int i = 0;
        while(i < arr.length)
        {
            int correct = arr[i] - 1;
            if(correct<arr.length && arr[correct] != arr[i])
            {
                swap(arr, correct, i);
            }
            else
            {
                i++;
            }
        }
        return arr[arr.length-1];
//        int j=0;
//        ArrayList<Integer> ls = new ArrayList<>(10);
//        while (j<arr.length)
//        {
//            if(j+1 != arr[j])
//            {
//                ls.add(j + 1);
//            }
//            j++;
//        }
//        return ls;
    }

    public static ArrayList<Integer> allduplicate(int arr[])
    {
        int i =0;
        while(i<arr.length)
        {
            int correct = arr[i] - 1;
            if(arr[correct] != arr[i])
            {
                swap(arr, correct, i);
            }
            else
            {
                i++;
            }
        }
        int j=0;
        ArrayList<Integer> ls = new ArrayList<>(10);
        while (j<arr.length)
        {
            if(j+1 != arr[j])
            {
                ls.add(arr[j]);
            }
            j++;
        }
        return ls;
    }


    public static ArrayList<Integer> misssingelementarray(int arr[])
    {
        int i =0;
        while(i<arr.length)
        {
            int correct = arr[i] - 1;
            if(correct<arr.length && arr[correct] != arr[i])
            {
                swap(arr, correct, i);
            }
            else
            {
                i++;
            }
        }
        int j=0;
        ArrayList<Integer> ls = new ArrayList<>(10);
        while (j<arr.length)
        {
            if(j+1 != arr[j])
            {
                ls.add(j + 1);
            }
            j++;
        }
        return ls;
    }

    public static int cyclic(int arr[]) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i] - 1;
            if (arr[i] > 0 && correct < arr.length && arr[correct] != arr[i]) {
                swap(arr, correct, i);
            }
            else {
                i++;
            }
        }

        for(int j = 0; j< arr.length; j++)
            {
                if(arr[j] - 1 != j)
                {
                    return j + 1;
                }
            }
            return arr.length + 1;
    }

    public static void swap(int arr[], int f, int s)
    {
        int temp = arr[f];
        arr[f] = arr[s];
        arr[s] = temp;
    }

    public static void insertion(int arr[])
    {
        for (int i = 0; i < arr.length - 1; i++)
        {
            for (int j = i+1; j > 0; --j)
            {
                if (arr[j] < arr[j - 1])
                {
                    swap(arr, j, j-1);
                }
                else
                {
                    break;
                }
            }
        }
    }
}
