package algorithm.sorts;

import java.util.Arrays;

public class QuickSort {
    public static void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    public static int pivot(int[] array, int pivotIndex, int endIndex) {
        int swapIndex = pivotIndex;
        for (int i = pivotIndex + 1; i <= endIndex; i++) {
            if (array[i] < array[pivotIndex]) {
                System.out.println("현재 swapIndex : " + swapIndex);
                swapIndex++;
                System.out.println("교체되는 swapIndex : " + swapIndex);
                System.out.println("교체되는 i : " + i);

                swap(array, swapIndex, i);
            }
        }
        swap(array, pivotIndex, swapIndex);
        return swapIndex;
    }

    public static void quickSortHelper(int[] array, int left, int right) {
        if (left < right) {
            int pivot = pivot(array, left, right);
            quickSortHelper(array, left, pivot-1);
            quickSortHelper(array, pivot+1, right);
        }
    }

    public static void quickSort(int[] array) {
        quickSortHelper(array, 0, array.length-1);
    }

    public static void main(String[] args) {
        int[] array = {4,6,1,7,3,2,5};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
