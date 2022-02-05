package mainTask.console;

import java.io.IOException;
import java.util.Scanner;

import mainTask.fileActions.*;

public class ConsoleInput {
    public void newInput() {
        Scanner in = new Scanner(System.in);
        String inputString = in.nextLine();

        FileActions fileActions = null;
        try {
            fileActions = new FileActions(inputString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert fileActions != null;

        if (fileActions.checkingFolderOrFile(inputString) == "file") {
            fileActions.findCountFoldersAndFiles();
        } else if (fileActions.checkingFolderOrFile(inputString) == "directory") {
            fileActions.creatingTheStructureOfFilesAndFolders(inputString);
            fileActions.closeWriter();
        }
    }
}
