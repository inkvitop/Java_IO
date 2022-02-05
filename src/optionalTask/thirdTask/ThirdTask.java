package optionalTask.thirdTask;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThirdTask {
    File fileInput = new File("c:\\AutoTests\\Java_Error&Exceptions\\src\\console\\ConsoleOutput.java");
    File fileOutput = new File("src/optionalTask/thirdTask/File.txt");
    ArrayList<ArrayList<String>> resultFileText = new ArrayList<ArrayList<String>>();

    public ThirdTask() {
        readFile();
        writeFile(resultFileText);
        System.out.println("The third optional task is completed.");
        System.out.println("******************************************");
    }

    private void readFile() {
        FileReader reader = null;
        try {
            reader = new FileReader(fileInput);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = bufferedReader.readLine();

            while (line != null) {
                ArrayList<String> arrayStringToChar = new ArrayList<String>(List.of(line.split("")));
                Collections.reverse(arrayStringToChar);
                resultFileText.add(arrayStringToChar);
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeFile(ArrayList arrayList) {
        try {
            FileWriter writer = new FileWriter(fileOutput, false);
            for (int i = 0; i < arrayList.size(); i++) {
                ArrayList<String> tempLine = (ArrayList<String>) arrayList.get(i);
                for (int j = 0; j < tempLine.size(); j++) {
                    writer.write(tempLine.get(j));
                }
                writer.write("\n");
            }
            writer.close();
        } catch (IOException e) {
            System.err.println("File exists, but there was IOException");
        }
    }
}
