/*
 * Copyright (c) 2022. Akastia Christo
 *
 */

package nl.bioinf.wrapper;

import org.apache.commons.cli.*;

/**
 * This class adds the options which needed to be collected from the command line.
 * Collects for the command line and checks if the options are provided.
 */

public class OptionsGetter implements OptionProvider {
    private Options options;
    private CommandLine cmd;
    private String arffFile;
    private String unknownFile;

    /**
     * Creates and parses the arguments.
     * @param args from the command line
     */
    public OptionsGetter(String [] args) {
        createOptions();
        parseCommandArgs(args);
    }

    /**
     * It is private and doesn't return anything.
     * Creates the options to obtain the arff file containing the known classes,
     * and to get the file containing the unknown classes.
     * Additionally, a help option is also created.
     */
    private void createOptions() {
        try {
            this.options = new Options();
            options.addOption(new Option("f",
                    "file",
                    true,
                    "The input file with the known classes of the instances"));
            options.addOption(new Option("u",
                    "unknown",
                    true,
                    "The input file of the unknown classes of the instances"));
            options.addOption(new Option("h",
                    "help",
                    false,
                    "Displays the help for the command line arguments"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Obtains the arguments from the command line and in the absence of it, prints help.
     * @param args command line args
     */
    private void parseCommandArgs(String[] args) {
        CommandLineParser parser = new DefaultParser();
        try {
            this.cmd = parser.parse(options, args);
            if (cmd.hasOption('h')) {
                printHelp();
            }
            checkOptions();
        } catch (ParseException exp) {
            System.err.println("Parsing failed! As a result of an error: " +
                    exp.getMessage());
            printHelp();
        }
    }

    /**
     * Checks if the options are provided.
     * @throws ParseException if there are no files provided
     */
    private void checkOptions() throws ParseException {
        if (cmd.hasOption('f')) {
            this.arffFile = cmd.getOptionValue('f');
        } else {
            throw new ParseException("No arff file is provided");
        }
        if (cmd.hasOption('u')) {
            this.unknownFile = cmd.getOptionValue('u');
        } else {
            throw new ParseException("No arff file is provided with unknown instances");
        }
    }

    /**
     * Creates the help if prints it is necessary in the parseCommandArgs.
     */
    private void printHelp() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("java -jar JavaWrapper-1.0-SNAPSHOT-all.jar [options]", options);
    }

    /**
     * Override method for getFileName.
     * @return arffFile
     */
    @Override
    public String getFileName() {
        return arffFile;
    }

    /**
     * Override method for getUnknownFile
     * @return unknownFile
     */
    @Override
    public String getUnknownFile() {
        return unknownFile;
    }
}