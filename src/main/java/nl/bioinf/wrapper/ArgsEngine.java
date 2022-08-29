/*
 * Copyright (c) 2022. Akastia Christo
 *
 */

package nl.bioinf.wrapper;

/**
 * This class implements the OptionsProvider interface,
 * which allows it to obtain the file names and prints them.
 */

public class ArgsEngine {
    /**
     * Implements the interface.
     * Gets the file names and prints it.
     * @param optionProvider the interface
     */
    void activation(OptionProvider optionProvider) {
        String dataFile = optionProvider.getFileName();
        System.out.println("InputFile = " + dataFile);
        String unknownFile = optionProvider.getUnknownFile();
        System.out.println("UnknownInputFile = " + unknownFile);
    }
}