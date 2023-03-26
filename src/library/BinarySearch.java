package library;

public class BinarySearch {
    public static int binarySearch(int[] arr, int first, int last, int key){
        int mid = (first + last)/2;
        while( first <= last ){
            if ( arr[mid] < key ){
                first = mid + 1;
            }else if ( arr[mid] == key ){
                System.out.println("Element is found at index: " + mid);
                break;
            }else{
                last = mid - 1;
            }
            mid = (first + last)/2;
        }
        if ( first > last ){
            System.out.println("Element is not found!");
        }
        return mid;
    }
    public static void main(String args[]){
        int arr[] = {10,20,30,40,50};
        int key = 30;
        int last=arr.length-1;
        long start_time =System.nanoTime();
     int index=   binarySearch(arr,0,last,key);
        long end_time=System.nanoTime();

        long duration = end_time - start_time;

        System.out.println("Elapsed time = " + duration + " ms");
        // printing result

        if (index == -1)
            System.out.println("Sorry, element not found");
        else
            System.out.println("The element is present at index " + index);

    }
}
