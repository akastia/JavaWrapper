/*
 * Copyright (c) 2021. Rose Hazenberg
 * Licensed under GPLv3. See gpl.md
 *
 *
 */

package nl.bioinf;

/**
 * This class implements the interface GiveOptions where it gets the file names and prints it.
 */

public class ArgsEngine {
    /**
     * Implements the interface.
     * Get the names and prints it.
     * @param giveOptions the interface
     */
    void activation(OptionProvider giveOptions) {
        String dataFile = giveOptions.getFileName();
        System.out.println("InputFile = " + dataFile);
        String unknownFile = giveOptions.getUnknownFile();
        System.out.println("UnknownInputFile = " + unknownFile);
    }
}