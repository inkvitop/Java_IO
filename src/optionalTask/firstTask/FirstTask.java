package optionalTask.firstTask;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;


public class FirstTask {
    File file = new File("src/optionalTask/firstTask/File.txt");
    ArrayList<Integer> randomIntegerArr = createRandomIntegerArray();

    public FirstTask() {
        writeFile(randomIntegerArr);
        sortMinMaxInt();
        System.out.println("The first optional task is completed.");
        System.out.println("******************************************");
    }

    private void writeFile(ArrayList arrayList) {
        try {
            FileWriter writer = new FileWriter(file, false);
            for (int i = 0; i < arrayList.size(); i++) {
                writer.write(arrayList.get(i) + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.err.println("File exists, but there was IOException");
        }
    }

    private void sortMinMaxInt() {
        try {
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = bufferedReader.readLine();
            ArrayList<Integer> integerArray = new ArrayList<>();

            while (line != null) {
                integerArray.add(Integer.valueOf(line));
                line = bufferedReader.readLine();
            }
            System.out.println(integerArray);
            Collections.sort(integerArray);
            System.out.println(integerArray);
            writeFile(integerArray);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int generateRandomInteger() {
        int minInteger = 0;
        int maxInteger = 1000;
        return (int) ((Math.random() * (maxInteger - minInteger)) + minInteger);
    }

    private ArrayList createRandomIntegerArray() {
        ArrayList randomInteger = new ArrayList();
        for (int i = 0; i < 10; i++) {
            randomInteger.add(generateRandomInteger());
        }
        return randomInteger;
    }
}
