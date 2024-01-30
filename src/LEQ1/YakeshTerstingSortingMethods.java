package LEQ1;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import static java.util.Collections.swap;

public class YakeshTerstingSortingMethods {

    public static void main(String[]  args){
        myHeader(6,1);
        System.out.print("Testing execution time of different sorting methods for sorting 50000 random numbers:\n\n");
        int sz = 50000;//variables
        Integer[] array = new Integer[sz];
        Integer[] backUp = new Integer[sz];
        for(int i = 0; i < sz; i++){//creating random values from 13 to 93
            array[i] = (int)((Math.random()*81)+13);
        }
        System.arraycopy(array,0,backUp, 0, sz);
        List<Integer> listArray = Arrays.asList(array);

        //Printing all sorting methods with time taken

       // System.out.printf("Unsorted List: %s\n", listArray.toString());
        long startTime = System.nanoTime();
        Collections.sort(listArray);
        System.out.printf("Collections-Sorting Time: %.2f milliseconds\n", ((System.nanoTime() - startTime)/1000000.00));
        //System.out.printf("The sorted list using the Collection's Sort method: %s\n\n", listArray.toString());

        System.arraycopy(backUp,0,array, 0, sz);
        //System.out.printf("The unsorted List: %s\n",listArray.toString());
        System.out.printf("Selection-Sort Time: %.2f milliseconds\n",(selectionSort(array)/1000000.00));
        //System.out.printf("The sorted list using the Selection-Sort Method: %s\n\n",listArray.toString());

        System.arraycopy(backUp,0,array, 0, sz);
        //System.out.printf("The unsorted List: %s\n",listArray.toString());
        System.out.printf("Bubble-Sort Time: %.2f milliseconds\n",(bubbleSort(array)/1000000.00));
        //System.out.printf("The sorted list using the Bubble-Sort Method: %s\n\n",listArray.toString());

        System.arraycopy(backUp,0,array, 0, sz);
        //System.out.printf("The unsorted List: %s\n",listArray.toString());
        System.out.printf("Insertion-Sort Time: %.2f milliseconds\n",(insertionSort(array)/1000000.00));
        //System.out.printf("The sorted list using the Insertion-Sort Method: %s\n\n",listArray.toString());

        System.arraycopy(backUp,0,array, 0, sz);
        //System.out.printf("The unsorted List: %s\n",listArray.toString());
        System.out.printf("Merge-Sort Time: %.2f milliseconds\n",(mergeSort(array)/1000000.00));
        //System.out.printf("The sorted list using the Merge-Sort Method: %s\n\n",listArray.toString());

        System.arraycopy(backUp,0,array, 0, sz);
        //System.out.printf("The unsorted List: %s\n",listArray.toString());
        System.out.printf("Quick-Sort Time: %.2f milliseconds\n",(quickSort(array)/1000000.00));
        //System.out.printf("The sorted list using the Quick-Sort Method: %s\n\n",listArray.toString());

        System.arraycopy(backUp,0,array, 0, sz);
        //System.out.printf("The unsorted List: %s\n",listArray.toString());
        System.out.printf("Bucket-Sort Time: %.2f milliseconds\n",(bucketSort(array,0,sz-1,2)/1000000.00));
        //System.out.printf("The sorted list using the Bucket-Sort Method: %s\n\n",listArray.toString());

        myFooter(6,1);
    }

    public static <T extends Comparable <? super T>>long selectionSort (T[] a){//repeatedly goes through array finding min and putting it in front each time
        long startTime = System.nanoTime();
        int x = -1;
        for(int i = 0; i < a.length; i++){//first loop goes through all elements
            x = x +1;
            T min = a[x];
            int temp = x;
            for(int j = x; j < a.length; j++){//goes through remaining elements and find min
                if( a[j].compareTo(min) < 0){
                    min = a[j];
                    temp = j;
                }
            }
            a[temp] = a[x];//swaps min in subset with first elements of subset
            a[x] = min;
        }
        return System.nanoTime() - startTime;
    }

    public static< T extends Comparable<? super T>> long bubbleSort(T[] a){//goes through array and swap index with index+1 if index>index+1
        long startTime = System.nanoTime();
        for (int i= 1; i<a.length; i++){
            for (int j = 0; j <a.length-i; j++){//last index will be sorted so don't check it
                if (a[j].compareTo(a[j+1]) > 0){
                    //swap list[j] and list[j+1]
                    T temp = a[j];
                    a[j] = a [j+1];
                    a[j+1] = temp;
                }
            }
        }
        return System.nanoTime() - startTime;
    }

public static <T extends Comparable<? super T>> long insertionSort(T[] a){//pulls each integer and compares with all elements to left of it
   long startTime = System.nanoTime();
    int i = 0, j = 0;
    for( i = 1; i < a.length; i++){
        T key = a[i];//element going to be compared with
        for(j=i-1; j>=0 && a[j].compareTo(key) > 0;j--){//comparing all elements to lower indexes
            a[j+1] = a[j];//swapping if lower number is found
        }
        a[j+1] = key;
    }
    return System.nanoTime() - startTime;
}
    //cant put timer in main function as it needs to return different value for recursive call
    //so create another function to start and stop timer
public static<T extends Comparable<? super T>> long mergeSort(T[] S){
        long startTime = System.nanoTime();
        merger(S);
        return System.nanoTime() - startTime;
}
    public static <T extends Comparable<? super T>> void merger(T[] S) {
        int n = S.length;
        if (n < 2) return; // array is trivially sorted
        // divide
        int mid = n/2;
        T[] S1 = Arrays.copyOfRange(S, 0, mid); // copy of first half
        T[] S2 = Arrays.copyOfRange(S, mid, n); // copy of second half
        // conquer (with recursion)
        merger(S1); // sort copy of first half
        merger(S2); // sort copy of second half
        // merge sorted halves back into original
        int i = 0, j = 0;
        while (i + j < S.length) {
            if (j == S2.length || (i < S1.length && S1[i].compareTo(S2[j]) < 0)) {
                S[i + j] = S1[i++]; // copy ith element of S1 and increment i
            }
            else {
                S[i + j] = S2[j++]; // copy jth element of S2 and increment j
            }
        }
    }
    //cant put timer in main function as it needs to return different value for recursive call
    //so create another function to start and stop timer
    public static <T extends Comparable<? super T>> long quickSort(T[] array) {
       long startTime = System.nanoTime();
        quickSort(array, 0, array.length - 1);
        return System.nanoTime() - startTime;
    }
//recursive method to perform quick sort
    private static <T extends Comparable<? super T>> void quickSort(T[] array, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(array, low, high);
            quickSort(array, low, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, high);
        }
    }
//method determines the next pivot
    private static <T extends Comparable<? super T>> int partition(T[] array, int low, int high) {
        T pivot = array[high];
        int i = low - 1;
        //iterate through array
        for (int j = low; j < high; j++) {
            //if the current element is less than or equal to the pivot, swap it
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                swap(array, i, j);
            }
        }
        //swap the pivot element to its correct posistion
        swap(array, i + 1, high);
        return i + 1;
    }
    //swaps elements
    private static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static long bucketSort(Integer[] a, int first, int last, int maxDigits) {
        long startTime = System.nanoTime();
        //since the radix is 10, creating 10 buckets using Vector. Assumption:
        // positive numbers only
        Vector<Integer>[] bucket = new Vector[10];
        //instantiate each bucket;
        for (int i = 0; i < 10; i++)
            bucket[i] = new Vector<>();
        for (int i = 0; i < maxDigits; i++) {
            //clear the Vector buckets
            for (int j = 0; j < 10; j++) {
                bucket[j].removeAllElements();
            }
            //Placing a[index] at end of bucket[digit]
            for (int index = first; index <= last; index++) {
                Integer digit = findDigit(a[index], i);
                bucket[digit].add(a[index]);
            }
            //placing all the buckets back into the array
            int index = 0;
            for (int m = 0; m < 10; m++) {
                for (int n = 0; n < bucket[m].size(); n++) {
                    a[index++] = bucket[m].get(n);
                }
            }
        }
        return System.nanoTime() - startTime;
    }
    //The following method extracts the ith digit from a decimal number
    public static Integer findDigit(int number, int i) {
        int target = 0;
        for (int k = 0; k <= i; k++) {
            target = number % 10;
            number = number / 10;
        }
        return target;
    }

    public static void myHeader(int lab_number, int q_number){//Header method
        System.out.printf("=======================================================\n" +
                "Lab Exercise %d-Q%d\n" +
                "Name: Yakesh Umachandran\n" +
                "Student Number: 251303571\n" +
                "Goal of this Exercise: Timing different sorting algorithms\n" +
                "=======================================================\n",lab_number, q_number);
    }
    public static void myFooter(int lab_number, int q_number){//Footer Method
        System.out.printf("\n=======================================================\n" +
                "Completion of Lab Exercise %d-Q%d is successful!\n" +
                "Signing off - Yakesh\n" +
                "=======================================================", lab_number,q_number);
    }
}

