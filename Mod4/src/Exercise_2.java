import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Exercise_2 {
    static final String path = "C:\\Users\\guds\\Desktop\\MSWE\\CourseWork\\241\\";

    public static void main(String[] args) {
        try {
            File sortFile = new File(path + "pride-and-prejudice.txt");
            FileWriter sortTime = new FileWriter(path + "insertion-sort.csv", true);

            SelectionSort selection = new SelectionSort();
            InsertionSort insertion = new InsertionSort();
            HeapSort heapSort = new HeapSort();
            MergeSort mergeSort = new MergeSort();
            QuickSort quickSort = new QuickSort();

            File file = new File("C:\\Users\\guds\\Desktop\\MSWE\\CourseWork\\241\\pride-and-prejudice.txt");
            Scanner input = new Scanner(file);
            List<String> words = new ArrayList<String>();
            while (input.hasNext()) {
                String s = input.next();
                s = s.replaceAll("[^A-Za-z0-9]", " ");
                s = s.trim();
                String[] split = s.split(" ");
                words.addAll(Arrays.asList(split));
            }

            System.out.println("Size: " + words.size());
            String[] items = words.toArray(new String[0]);
            long startTime = System.nanoTime();
//            insertion.insertionSort(items);
//            selection.selectionSort(items);
//            heapSort.heapSort(items);
//            mergeSort.mergeSort(items, 0, items.length - 1);
            quickSort.quickSort(items, 0, items.length-1);
            Long endTime = System.nanoTime() - startTime;
            System.out.println("Time Taken: " + (endTime));
            System.out.println("After Sorting: ");
            for (int i = 0; i < items.length; i++) {
                System.out.println(items[i] + " ");
            }

        } catch (Exception ex) {
            System.out.println("Exception found: " + ex.getMessage());
        }
    }

    private static void fileWriter(FileWriter file, String x, String y) throws IOException {
        try {
            System.out.println("x: " + x + " y: " + y);
            file.append(x);
            file.append(",");
            file.append(y);
            file.append("\n");
        } catch (IOException e) {
            System.out.println("Could not append to the file");
            e.printStackTrace();
        }


    }
}
