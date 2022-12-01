package com.github.gambusio;

import java.awt.*;
import java.io.File;
import java.util.concurrent.TimeUnit;

/***
 * DelayPrinter - Makes a certain number of print copies of a file with a
 *                programmable pause in seconds between each copy
 */
public class DelayPrinter {
    private final File fileForPrint;
    private final int iNumCopies;
    private final int iDelaySeconds;

    public DelayPrinter(File fileForPrint, int iNumCopies, int iDelaySeconds) {
        this.fileForPrint = fileForPrint;
        this.iNumCopies = iNumCopies;
        this.iDelaySeconds = iDelaySeconds;
    }
    public void print() {
        for(int i = 0; i < iNumCopies; i++) {
            try {
                Desktop.getDesktop().print(fileForPrint);
                TimeUnit.SECONDS.sleep(iDelaySeconds);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }
}
