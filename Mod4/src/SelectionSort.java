public class SelectionSort {
    public static void selectionSort(String[] items) {
        for (int i = 0; i < items.length; i++) {
            int min = i;
            for (int j = i; j < items.length; j++) {
                if (items[j].compareTo(items[min]) < 0) {
                    min = j;
                }
            }
            String temp = items[min];
            items[min] = items[i];
            items[i] = temp;
        }
    }

    public static void selectionSort(int[] items) {
        for (int i = 0; i < items.length; i++) {
            int min = i;
            for (int j = i; j < items.length; j++) {
                if (items[min] > items[j]) {
                    min = j;
                }
            }
            int temp = items[min];
            items[min] = items[i];
            items[i] = temp;
        }
    }
}
