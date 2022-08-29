# JavaWrapper
This is the repository that contains the Java Wrapper for Theme 9.
The Java Wrapper categorise new instances based on Myocardial infraction features and patients information whether an instance is unknown or a lethal cause as;
pulmonary edema, ventricular fibrillation, progress of congestive heart failure, cardiogenic shock, thromboembolism, asystole, myocardial rupture.

### What is this repository for?
* This repository contains the classes of the Java Wrapper with corresponding data.
* © Copyright Mary Akastia Christo, Hanze University of Applied Sciences. Bio-informatics, Life Science and Technology.

### Contents
* The folder **src/main/java/nl/bioinf/wrapper** contains the classes that classify a new instance.
* The folder **data** contains three files, one file with the RandomForest model ***RandomForest.model***, 
* one file, ***Myocardial Infraction.arff***, where the class of the myocardial infraction data is known, and another file, ***unknown.arff***, 
which gives the new instances, where the class of the myocardial infraction data is unknown.

### Installation
* **Fork** this repository into your own account.
* **Clone** the repository to your local computer.
* Open this project in [IntelliJ IDEA](https://www.jetbrains.com/idea/download/) to set up and run.
* IntelliJ needs [java version 17.0.1](https://www.java.com/nl/download/) and [Java SE 17.0.1](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
* The version can be specified in **File/Project Structure**
* For support about IntelliJ IDEA you can visit https://www.jetbrains.com/idea/features/

### Usage
To run the program you need to build a jar and shadowJar file by in the right corner **Gradle/build/jar** or **Gradle/build/shadowJar**.
The program needs two arguments which are two **.arff** files and are provided in the data folder. ***Myocardial_Infraction.arff*** and ***unknown.arff***.

The command line is:   
java -jar .\build\libs\JavaWrapper-1.0-SNAPSHOT-all.jar -f .\data\Myocardial_Infraction.arff -u .\data\unknown.arff


If one of the arguments is missing it gives you the next outcome:  
Parsing failed! As a result of an error: No arff file is provided with unknown instances  
usage: java -jar JavaWrapper-1.0-SNAPSHOT-all.jar [options]  
-f,--file <arg>      The input file with the known classes of the instances    
-h,--help            Displays the help for the command line arguments   
-u,--unknown <arg>   The input file of the unknown classes of the instances  
inputFile: .\data\Myocardial_Infraction.arff  
unknownInputFile = null

When the program works it should give the next example:  
AGE: 85.0, SEX: Male, predicted: asystole  
AGE: 54.0, SEX: Female, predicted: asystole  
AGE: 77.0, SEX: Male, predicted: progress of congestive heart failure  
AGE: 53.0, SEX: Male, predicted: unknown  
AGE: 77.0, SEX: Male, predicted: myocardial rupture  
AGE: 62.0, SEX: Male, predicted: myocardial rupture  
AGE: 71.0, SEX: Female, predicted: myocardial rupture  

Another options to run the ***RunnerMain.java*** is with the Edit Configuration, program arguments:  
-f data/Myocardial_infraction.arff -u data/unknown.arff  
This provides the same outcome as shown in the example above.

### Support
For more information about the set-up please visit   
https://www.jetbrains.com/help/idea/compiling-applications.html#compile_module

For support please contact Mary Akastia Christo.
E-mail: m.a.christo@st.hanze.nl