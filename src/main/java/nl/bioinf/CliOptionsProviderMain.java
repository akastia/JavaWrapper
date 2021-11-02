package nl.bioinf;


import java.util.Arrays;

public class CliOptionsProviderMain {
    public static void main(String[] args) {
        System.out.println("Arrays.toString(args)" + Arrays.toString(args));
        OptionsProvider optionsProvider = new CliOptionsProvider(args);
        AlgoritmeEngine algoritmeEngine = new AlgoritmeEngine();
        algoritmeEngine.start(optionsProvider);
    }
}
