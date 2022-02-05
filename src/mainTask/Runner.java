package mainTask;

import mainTask.console.*;
import optionalTask.firstTask.FirstTask;
import optionalTask.fourthTask.FourthTask;
import optionalTask.secondTask.SecondTask;
import optionalTask.thirdTask.ThirdTask;

public class Runner {
    public static void main(String[] args) {
        new FirstTask();
        new SecondTask();
        new ThirdTask();
        new FourthTask();

        ConsoleOutput consoleOutput = new ConsoleOutput();
        consoleOutput.printGreetings();

        ConsoleInput consoleInput = new ConsoleInput();
        consoleInput.newInput();
    }
}
