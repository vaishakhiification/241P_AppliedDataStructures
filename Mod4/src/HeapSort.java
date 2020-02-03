public class HeapSort {
    public static void heapSort(String items[]) {
        int n = items.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(items, n, i);

        for (int i = n - 1; i >= 0; i--) {
            String temp = items[0];
            items[0] = items[i];
            items[i] = temp;

            heapify(items, i, 0);
        }
    }

    public static void heapify(String items[], int n, int i) {
        int largest = i; // initialise largest as root
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && items[l].compareTo(items[largest]) > 0)
            largest = l;
        if (r < n && items[r].compareTo(items[largest]) > 0)
            largest = r;
        if (largest != i) {
            String swap = items[i];
            items[i] = items[largest];
            items[largest] = swap;

            heapify(items, n, largest);
        }
    }
}
