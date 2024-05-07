package algorithm.sorts;

import java.util.Arrays;

public class MergeSort {

    public static int[] mergeSort(int[] array) {
        if (array.length == 1) return array;

        int[] left = mergeSort(Arrays.copyOfRange(array, 0, array.length/2));
        int[] right = mergeSort(Arrays.copyOfRange(array, array.length/2, array.length));

        return merge(left, right);
    }

    //파라미터로 들어오는 배열은 정렬이 된 배열이어야한다.
    public static int[] merge(int[] array1, int[] array2) {
        int[] combined = new int[array1.length + array2.length];
        int index = 0;
        int i = 0; // array1
        int j = 0; // array2

        while (array1.length != i && array2.length != j) {
            if (array1[i] < array2[j]) {
                combined[index] = array1[i];
                i++;
            } else {
                combined[index] = array2[j];
                j++;
            }
            index++;
        }

        while (array1.length > i) {
            combined[index] = array1[i];
            i++;
            index++;
        }
        while (array2.length > j) {
            combined[index] = array2[j];
            j++;
            index++;
        }

        return combined;
    }

    public static void main(String[] args) {
        int[] a1 = {1,3,7,8};
        int[] a2 = {2,4,5,6};
        System.out.println(Arrays.toString(merge(a1, a2)));

        int[] a = {1,3,8,7,2,4,5,6};
        System.out.println(Arrays.toString(mergeSort(a)));

    }
}
