package optionalTask.secondTask;

import java.io.*;
import java.util.ArrayList;

public class SecondTask {
    File fileInput = new File("c:\\AutoTests\\Java_Error&Exceptions\\src\\console\\ConsoleOutput.java");
    File fileOutput = new File("src/optionalTask/secondTask/File.txt");
    ArrayList<String> resultFileText = new ArrayList<>();

    public SecondTask() {
        readFile();
        writeFile(resultFileText);
        System.out.println("The second optional task is completed.");
        System.out.println("******************************************");
    }

    private void readFile() {
        FileReader reader = null;
        try {
            reader = new FileReader(fileInput);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = bufferedReader.readLine();

            while (line != null) {
                resultFileText.add(line.replaceAll("public", "private"));
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
                writer.write(arrayList.get(i) + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.err.println("File exists, but there was IOException");
        }
    }
}
