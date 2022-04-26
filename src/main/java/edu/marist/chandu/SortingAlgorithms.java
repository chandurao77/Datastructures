package edu.marist.chandu;

import java.util.Arrays;

/**
 * This is the Sorting algorithms class.
 */
public class SortingAlgorithms {

    /**
     * Below is the heap sort implementation.
     * @param array
     */
    public void heapSort(String[] array){
        int n = array.length;
        for (int i = (n/2) - 1; i >=0; i--) {
            heapify(array,n,i);
        }

        for (int i = n-1; i >= 0; i--) {
            String temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array,i,0);
        }
    }

    /**
     * Below is the heapify method.
     * @param stringArray
     * @param n
     * @param i
     */
    private void heapify(String[] stringArray, int n, int i){
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        if (left<n && stringArray[left].compareTo(stringArray[largest])>0){
            largest = left;
        }
        if(right<n && stringArray[right].compareTo(stringArray[largest])>0){
            largest = right;
        }
        if (largest != i){
            String swap = stringArray[i];
            stringArray[i] = stringArray[largest];
            stringArray[largest] = swap;
            heapify(stringArray,n,largest);
        }
    }

    /**
     * Below is the bubble sort implementation.
     * @param fileArray
     */
    public void bubbleSort(String[] fileArray){
        String temp = "";
        for (int j = 0; j < fileArray.length; j++) {
            for (int i = j+1; i < fileArray.length; i++) {

                if (fileArray[i].compareTo(fileArray[j])<0){
                    temp = fileArray[j];
                    fileArray[j] = fileArray[i];
                    fileArray[i] = temp;
                }
            }
            System.out.println(fileArray[j]);
        }
    }

    /**
     * Below is the insertion sort implementation.
     * @param fileArray
     */
    public void insertionSort(String[] fileArray){
        int i;
        String key;
        for (int j = 0; j < fileArray.length; j++) {
            key = fileArray[j];
            i = j-1;
            while (i >= 0){
                if (key.compareTo(fileArray[i]) >0){
                    break;
                }
                fileArray[i+1] = fileArray[i];
                i--;
            }
            fileArray[i+1] = key;
        }
        for (int j = 0; j < fileArray.length; j++) {
            System.out.println(fileArray[j]);
        }
    }

    /**
     * Below is the merge sort implementation.
     * @param array
     */
    public void mergeSort(String[] array){
        mergeSorting(array,0,array.length-1);
    }

    /**
     * Below is the merge sorting implementation.
     * @param arr
     * @param left
     * @param right
     */
    private void mergeSorting(String[] arr, int left, int right){
        if (left < right){
            int m = left + (right-left)/2;
            mergeSorting(arr,left,m);
            mergeSorting(arr,m+1,right);
            merge(arr,left,m,right);
        }
    }

    /**
     * Below is the merge method.
     * @param arr
     * @param l
     * @param middle
     * @param r
     */
    private void merge(String arr[], int l, int middle, int r){
        int n1 = middle - l + 1;
        int n2 = r - middle;
        String left[] = new String[n1];
        String right[] = new String[n2];
        for (int i = 0;i<n1;i++){
            left[i] = arr[l+i];
        }
        for (int j = 0;j<n2;j++){
            right[j] = arr[middle+1+j];
        }
        int i=0;
        int j=0;
        int k = l;
        while (i<n1 && j<n2){
            if (left[i].compareTo(right[j])<=0){
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while (i<n1){
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j<n2){
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    /**
     * Below is the quick sort implementation.
     * @param array
     */
    public void quickSort(String[] array){
        quickSortMethod(array,0, array.length-1);
    }

    /**
     * Below is the quick sort method.
     * @param array
     * @param low
     * @param high
     */
    private void quickSortMethod(String[] array, int low, int high){
        if (low<high){
            int pi = partition(array, low,high);
            quickSortMethod(array,low,pi-1);
            quickSortMethod(array,pi+1,high);
        }
    }

    /**
     * Below is the partition method.
     * @param array
     * @param low
     * @param high
     * @return
     */
    private int partition(String[] array, int low, int high){
        String pivot = array[high];
        int i = low-1;
        for (int j = low; j < high; j++) {
            if (array[j].compareTo(pivot)<0){
                i++;
                String swap = array[i];
                array[i] = array[j];
                array[j] = swap;
            }
        }
        String temp = array[i+1];
        array[i+1] = array[high];
        array[high] = temp;
        return i+1;
    }
}
