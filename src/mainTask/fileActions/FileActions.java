package mainTask.fileActions;

import mainTask.console.ConsoleOutput;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileActions {
    String path;
    int spaceCount = 0;

    ConsoleOutput consoleOutput = new ConsoleOutput();

    File resultFile = new File("src/mainTask/storage/ResultTextFile.txt");
    FileWriter writer = new FileWriter(resultFile, false);

    File fileForTest = new File("src/mainTask/storage/FileForTask.txt");
    FileReader reader = new FileReader(fileForTest);
    BufferedReader bufferedReader = new BufferedReader(reader);

    public FileActions(String inputPath) throws IOException {
        path = inputPath;
    }

    public String checkingFolderOrFile(String pathForCheck) {
        File file = new File(pathForCheck);
        String result = "";
        if (file.isFile()) {
            result = "file";
        } else if (file.isDirectory()) {
            result = "directory";
        }
        return result;
    }

    public void creatingTheStructureOfFilesAndFolders(String path) {
        try {
            File file = new File(path);
            String[] resultArrDir = file.list();

            String tempPath;

            writer.write(tabSpaceCreator() + "[]" + file.getName() + "/..\n");
            spaceCount += 1;

            for (int i = 0; i < resultArrDir.length; i++) {
                tempPath = path + "\\" + resultArrDir[i];
                if (checkingFolderOrFile(tempPath) == "file") {
                    writer.write(tabSpaceCreator() + resultArrDir[i] + "\n");
                } else if (checkingFolderOrFile(tempPath) == "directory") {
                    creatingTheStructureOfFilesAndFolders(tempPath);
                    spaceCount += 1;
                }
            }
            spaceCount -= 2;

            consoleOutput.printEndOfFileTreeCreation();
        }  catch (IOException e) {
            System.err.println("File exists, but there was IOException");
        }
    }

    public void closeWriter() {
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String tabSpaceCreator() {
        return "--".repeat(Math.max(0, spaceCount));
    }

    public void findCountFoldersAndFiles() {
        int countFolders = 0;
        int countFiles = 0;
        int filesNameLength = 0;

        String line = null;
        Pattern pattern = Pattern.compile("/..");

        try {
            line = bufferedReader.readLine();
            while (line != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    countFolders++;
                } else {
                    countFiles++;
                    String replacedLine = line.replaceAll("-{2}", "");
                    filesNameLength += replacedLine.length();
                }
                line = bufferedReader.readLine();
            }
            consoleOutput.printFoldersCount(countFolders, countFiles, filesNameLength/countFiles);
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
