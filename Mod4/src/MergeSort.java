public class MergeSort {
    public static void mergeSort(String[] items, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2; // Same as (l+r)/2, but avoids overflow for

            mergeSort(items, l, m);
            mergeSort(items, m + 1, r);

            merge(items, l, m, r);
        }
    }

    public static void merge(String items[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        String left[] = new String[n1];
        String right[] = new String[n2];

        for (int i = 0; i < n1; i++)
            left[i] = items[l + i];
        for (int i = 0; i < n2; i++)
            right[i] = items[m + 1 + i];

        int i = 0, j = 0, k = 0;
        while (i < n1 && j < n2) {
            if (left[i].compareTo(right[j]) <= 0) {
                items[k] = left[i];
                i++;
            } else {
                items[k] = right[j];
                j++;
            }
        }

        while (i < n1) {
            items[k] = left[i];
            i++;
            k++;
        }
        while (j < n2) {
            items[k] = right[j];
            j++;
            k++;
        }

    }
}
