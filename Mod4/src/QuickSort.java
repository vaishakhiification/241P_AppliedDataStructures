public class QuickSort {
    public static void quickSort(String[] items, int l, int h) {
        if (l < h) {
            int p = partition(items, l, h);
            quickSort(items, l, p - 1);
            quickSort(items, p + 1, h);
        }
    }

    public static int partition(String[] items, int l, int h) {
        String pivot = items[h];
        int i = (l - 1);
        for (int j = l; j < h; j++) {
            if (items[j].compareTo(pivot) < 0) {
                i++;
                String temp = items[i];
                items[i] = items[j];
                items[j] = temp;

            }
        }
        String temp = items[i + 1];
        items[i + 1] = items[h];
        items[h] = temp;

        return i + 1;
    }

}
