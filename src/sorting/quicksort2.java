package sorting;

import java.util.Arrays;

public class quicksort2 {
    public static void main(String[] args) {
        int arr[] = {20,2,8,3,1};
        quicksort(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static int Partition(int arr[], int l, int h)
    {
        int pivot = l;
        int s = l;
        int e = h;

        for(int j = l + 1; j<=h; j++)
        {
            if(arr[j] < arr[pivot])
            {
                s = s + 1;
                swap(arr,j,s);
            }
        }
        swap(arr,l,s);
        return s;
    }

    public static void quicksort(int arr[], int low, int high)
    {
        if(low<high)
        {
            int pivot = Partition(arr,low,high);
            quicksort(arr,low,pivot - 1);
            quicksort(arr,pivot + 1, high);
        }
    }

    public static void swap(int arr[], int f, int s)
    {
        int temp = arr[f];
        arr[f] = arr[s];
        arr[s] = temp;
    }
}
