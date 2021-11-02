package nl.bioinf;

import org.apache.commons.cli.*;

public class CliOptionsProvider implements OptionsProvider {
    private Options options;
    private CommandLine cmd;
    private int number;
    private String file;

    public CliOptionsProvider(String[] args) {
        init();
        parseArgs(args);
    }

    private void parseArgs(String[] args) {
        CommandLineParser parser = new DefaultParser();
        try {
            this.cmd = parser.parse(options, args);
            if (cmd.hasOption('h')) {
                printHelp();
            }
            verify();
        } catch (ParseException e) {
            System.err.println("Something went wrong while parsing, cause : " + e.getCause());
            printHelp();

        }
    }

    private void printHelp() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("java -jar [options]", options);
    }

    void init() {
        this.options = new Options();
        final Options options = new Options();
        options.addOption(new Option("n",
                "number",
                true,
                "The number - a positive number"));
        options.addOption(new Option("f",
                "file",
                true,
                "The input file - expects three numeric columns"));
    }


    private void verify() throws ParseException {
        if (cmd.hasOption('f')) {
            throw new ParseException("no file has been provided");
        } else {
            this.file = cmd.getOptionValue('f');
        }
        if (cmd.hasOption('n')) {
            throw new ParseException("no number has been provided");
        } else {
            try {
                final String numberStr = cmd.getOptionValue("n");
                int number = Integer.parseInt(numberStr);
                if (number < 0) {
                    throw new ParseException("Number is below zero: " + number);
                }
                this.number = number;
            } catch (NumberFormatException nfe) {
                throw new ParseException("Number can not be parsed: " + cmd.getOptionValue("n"));
            }
        }

    }

    @Override
    public int getNumber(){
        return number;
    }
    @Override
    public String getFileName(){
        return file;
    }
}