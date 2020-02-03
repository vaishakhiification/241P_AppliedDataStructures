// Problem Definition
// The mode of a set of numbers is the number that occurs most frequently in the set.
// The set (4,6,2,4,3,1) has a mode of 4. Give an efficient and correct algorithm to compute the mode of a set of n numbers.

import java.util.Arrays;

public class Practice_M4_5 {
    public static void merge(int arr[], int l, int m, int r) {
        // Find sizes of two subarray to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
        }

        /* Merge the temp arrays */
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(int arr[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    public static void main(String[] args) {

        int arr[] = {4, 6, 2, 4, 3, 1};
        mergeSort(arr, 0, arr.length - 1);

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        int previous = arr[0];
        int max = 0;
        int count = 1;
        int mode = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == previous) {
                count++;
                if (count > max) {
                    max = count;
                    mode = previous;
                } else {
                    count = 1;
                }
            } else {
                count = 1;
            }
            previous = arr[i];
        }

        System.out.println("\nMode: " + mode + " with " + max + " count.");

    }
}
