public class InsertionSort {
    public static void insertionSort(String[] items) {
        for (int i = 0; i < items.length; i++) {
            int j = i - 1;
            String key = items[i];
            while (j >= 0 && items[j].compareTo(key) > 0) {
                items[j + 1] = items[j];
                j--;
            }
            items[j + 1] = key;
        }
    }

    public static void insertionSort(int[] items) {
        for (int i = 0; i < items.length; i++) {
            int j = i - 1;
            int key = items[i];
            while (j >= 0 && items[j] > key) {
                items[j + 1] = items[j];
                j--;
            }
            items[j + 1] = key;
        }
    }

}
