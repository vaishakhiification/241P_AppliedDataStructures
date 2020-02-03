import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Exercise_1 {
    static final String path = "C:\\Users\\guds\\Desktop\\MSWE\\CourseWork\\241\\";

    public static void main(String args[]) throws IOException {
        SetImplementation binaryTree = new BinaryTree();
        SetImplementation hashTable = new HashTable(12007);
        SetImplementation linkedList = new LinkedList();
        FileWriter insertionTime = null;
        FileWriter searchTime = null;
        try {
            File insertFile = new File(path + "pride-and-prejudice.txt");
            insertionTime = new FileWriter(path + "linkedList_insertionTime.csv", true);

            Scanner insertIp = new Scanner(insertFile);
            while (insertIp.hasNext()) {
                String s = insertIp.next();
                s = s.replaceAll("[^A-Za-z0-9]", " ");
                s = s.trim();
                String[] split = s.split(" ");

                for (String word : split) {
                    if (!word.isEmpty()) {
//                        Integer count = binaryTree.size();
//                        Integer count = hashTable.size();
//                        Integer count = linkedList.size();
                        long startTime = System.nanoTime();
                        binaryTree.add(word);
                        hashTable.add(word);
                        linkedList.add(word);
                        Long endTime = System.nanoTime() - startTime;
                        // System.out.println("Count: "+count);
//                        if (count % 100 == 0) {
//                            fileWriter(insertionTime, count.toString(), endTime.toString());
//                        }

                    }
                }
            }
            System.out.println("Binary Tree Size: " + binaryTree.size());
            System.out.println("HashTable Size: " + hashTable.size());
            System.out.println("Linked List Size: " + linkedList.size());

            File searchFile = new File("C:\\Users\\guds\\Desktop\\MSWE\\CourseWork\\241\\words-shuffled.txt");
            searchTime = new FileWriter(path + "linkedList_searchTime.csv", true);
            Scanner searchIp = new Scanner(searchFile);
            int count1 = 0;
            int count2 = 0;
            int count3 = 0;
            while (searchIp.hasNext()) {
                String s = searchIp.next();
                s = s.replaceAll("[^A-Za-z0-9]", " ");
                s = s.trim();
                String[] split = s.split(" ");
                Integer count = 0;
                for (String word : split) {
                    if (!word.isEmpty()) {
                        if (!binaryTree.contains(s)) {
                            count1++;
                        }
                        if (!hashTable.contains(s)) {
                            count2++;
                        }
                        if (!linkedList.contains(s)) {
                            count3++;
                        }
                    }
                }
            }
            System.out.println("Binary Tree Count: " + count1);
            System.out.println("HashTable Count: " + count2);
            System.out.println("LinkedList Count: " + count3);

        } catch (Exception ex) {
            System.out.println("Exception found: " + ex.getMessage() + " " + ex.toString() + " " + ex.getLocalizedMessage());
        } finally {
            insertionTime.flush();
            insertionTime.close();
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
