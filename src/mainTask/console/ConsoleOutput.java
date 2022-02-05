package mainTask.console;

public class ConsoleOutput {
    public void printGreetings() {
        System.out.println("******************************************");
        System.out.println("Enter the absolute path to a folder or file on your computer.");
        System.out.println("Test path: <c:\\AutoTests\\Java_IO\\src\\mainTask\\storage\\FileForTask.txt>");
        System.out.println("or");
        System.out.println("path to any folder. Test path: <c:\\AutoTests\\Java_IO\\src\\mainTask\\storage\\>");
        System.out.println("******************************************");
    }

    public void printFoldersCount(int countFolder, int countFiles, int averageFileNameLength) {
        System.out.println("The text file contains " + countFolder + " folders.");
        System.out.println("The text file contains " + countFiles + " files.");
        System.out.println("Average number of files per folder = " + countFiles/countFolder + ".");
        System.out.println("Average file name length = " + averageFileNameLength + ".");
    }

    public void printEndOfFileTreeCreation() {
        System.out.println("The creation of the file tree is complete. The result is written to the storage directory. File name ResultTextFile.");
    }
}
