package sorting;

import java.util.Arrays;

public class merge {
    public static void main(String[] args) {
        int arr[] = {50,2,8,10,20,-1};
        MergeSort(arr,0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void Sort(int arr[], int start, int mid, int end)
    {
        int a[] = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;

        while(i<=mid && j<=end)
        {
            if(arr[i]<arr[j])
            {
                a[k] = arr[i];
                i++;
                k++;
            }
            else
            {
                a[k] = arr[j];
                j++;
                k++;
            }
        }
        while(i<=mid){
            a[k] = arr[i];
            i++;
            k++;
        }
        while(j<=end)
        {
            a[k] = arr[j];
            j++;
            k++;
        }

        for(int l =0; l<(end-start + 1);l++)
        {
            arr[start+l] = a[l];
        }
    }

    public static void MergeSort(int arr[], int low, int high)
    {
        if(low == high)
        {
            return;
        }
        int mid = (low + high)/2;
        MergeSort(arr,low,mid);
        MergeSort(arr,mid + 1,high);
        Sort(arr,low,mid,high);
    }

}
