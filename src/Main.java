import com.github.gambusio.DelayPrinter;

import java.awt.*;
import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int numCopies;
        int delaySeconds;

        Frame yourJFrame = new Frame();
        FileDialog fd = new FileDialog(yourJFrame, "Choose a file", FileDialog.LOAD);
        fd.setDirectory("C:\\");
        fd.setFile("*.*");
        fd.setVisible(true);
        String filename = fd.getFile();
        if (filename == null) {
            System.out.println("You cancelled the choice");
            yourJFrame.dispose();
            return;
        } else {
            System.out.println("You chose " + filename);
        }
        Scanner in = new Scanner(System.in);
        System.out.print("Number of copies: ");
        numCopies = in.nextInt();
        System.out.println("Delay in seconds: ");
        delaySeconds = in.nextInt();
        File fileForPrint = fd.getFiles()[0];

        DelayPrinter delayPrinter = new DelayPrinter(fileForPrint, numCopies, delaySeconds);
        delayPrinter.print();
        yourJFrame.dispose();

    }
}