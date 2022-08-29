/*
 * Copyright (c) 2022. Akastia Christo
 *
 */

package nl.bioinf.wrapper;

import weka.classifiers.trees.RandomForest;
import weka.core.Instances;

/**
 * This class is the main which gets the arguments and categorise the new instances.
 * Sets up every file to let it work.
 */

public class RunnerMain {
    /**
     * @param args from the command line
     */
    public static void main(String[] args) {
        OptionProvider optionProvider = new OptionsGetter(args);
        ArgsEngine argsEngine = new ArgsEngine();
        argsEngine.activation(optionProvider);
        CategoriseInstances categoriseInstances = new CategoriseInstances();
        GetData getData = new GetData();
        try {
            Instances train = getData.loadFromArffFile(optionProvider.getFileName());
            RandomForest randomForest = categoriseInstances.buildTree(train);
            categoriseInstances.saveClassifier(randomForest);
            RandomForest fromFile = categoriseInstances.loadClassifier();
            Instances test = getData.loadFromArffFile(optionProvider.getUnknownFile());
            Instances removedAttribute = getData.removeAttribute(test);
            categoriseInstances.CategoriseUnknownInstances(fromFile, removedAttribute);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}