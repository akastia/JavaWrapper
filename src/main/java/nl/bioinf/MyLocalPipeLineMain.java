package nl.bioinf;

public class MyLocalPipeLineMain {
    public static void main(String[] args){
        AlgoritmeEngine engine = new AlgoritmeEngine();
        engine.start(new PipeLineOptionsProvider());
    }
}
