package actions;

import clocks.GameClock;
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import game.Dir;
import game.Snake;
import gui.Gui;

import java.io.*;

import static java.lang.Integer.parseInt;
public class Main {

    public static String directory(){
        return System.getProperty("user.dir");

    }
    public static int scoreread;
    public static void main(String[] args) {
        boolean f = false;
        System.out.println(directory());
        String absolutePath = directory() + "bestscore.txt";
        // Hier erstelle ich das dictionary für die Voice API
        try {
            File myObj = new File("dic2.dic");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
                try {
                    FileWriter myWriter = new FileWriter( "dic2.dic");
                    myWriter.write("DOWN\tD AW N\n" +
                            "LEFT\tL EH F T\n" +
                            "RIGHT\tR AY T\n" +
                            "UP\t    AH P");
                    myWriter.close();
                    System.out.println("Successfully wrote to the file.");
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        // Hier erstelle ich das Language model für die Voice API
        try {
            File myObj = new File("lm2.lm");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
                try {
                    FileWriter myWriter = new FileWriter("lm2.lm");
                    myWriter.write("Language model created by QuickLM on Fri Dec 10 14:20:28 EST 2021\n" +
                            "Copyright (c) 1996-2010 Carnegie Mellon University and Alexander I. Rudnicky\n" +
                            "\n" +
                            "The model is in standard ARPA format, designed by Doug Paul while he was at MITRE.\n" +
                            "\n" +
                            "The code that was used to produce this language model is available in Open Source.\n" +
                            "Please visit http://www.speech.cs.cmu.edu/tools/ for more information\n" +
                            "\n" +
                            "The (fixed) discount mass is 0.5. The backoffs are computed using the ratio method.\n" +
                            "This model based on a corpus of 4 sentences and 6 words\n" +
                            "\n" +
                            "\\data\\\n" +
                            "ngram 1=6\n" +
                            "ngram 2=8\n" +
                            "ngram 3=4\n" +
                            "\n" +
                            "\\1-grams:\n" +
                            "-0.7782 </s> -0.3010\n" +
                            "-0.7782 <s> -0.2218\n" +
                            "-1.3802 DOWN -0.2218\n" +
                            "-1.3802 LEFT -0.2218\n" +
                            "-1.3802 RIGHT -0.2218\n" +
                            "-1.3802 UP -0.2218\n" +
                            "\n" +
                            "\\2-grams:\n" +
                            "-0.9031 <s> DOWN 0.0000\n" +
                            "-0.9031 <s> LEFT 0.0000\n" +
                            "-0.9031 <s> RIGHT 0.0000\n" +
                            "-0.9031 <s> UP 0.0000\n" +
                            "-0.3010 DOWN </s> -0.3010\n" +
                            "-0.3010 LEFT </s> -0.3010\n" +
                            "-0.3010 RIGHT </s> -0.3010\n" +
                            "-0.3010 UP </s> -0.3010\n" +
                            "\n" +
                            "\\3-grams:\n" +
                            "-0.3010 <s> DOWN </s>\n" +
                            "-0.3010 <s> LEFT </s>\n" +
                            "-0.3010 <s> RIGHT </s>\n" +
                            "-0.3010 <s> UP </s>\n" +
                            "\n" +
                            "\\end\\");
                    myWriter.close();
                    System.out.println("Successfully wrote to the file.");
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        //Highscore auslesen
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(absolutePath))) {
            String line = bufferedReader.readLine();
            if(line != null) {
                line = bufferedReader.readLine();
                Snake.bestscore = line;

            }
        } catch (FileNotFoundException e) {
            // Exception handling
            System.out.println("no file");
        } catch (IOException e) {
            // Exception handling
            System.out.println("failed tp read");
        }
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(absolutePath))) {
            String line = bufferedReader.readLine();
            if(line != null) {
                scoreread = parseInt(line);
                System.out.println(scoreread);
            }
        } catch (FileNotFoundException e) {
            // Exception handling
            System.out.println("no file");
        } catch (IOException e) {
            // Exception handling
            System.out.println("failed to read");
        }
        //Gui Erstellen
        Gui g = new Gui();
        GameClock gc = new GameClock();

        g.create();
        gc.start();
        //Die Voice API aufrufen und verarbeiten
        Configuration config = new Configuration();
        config.setAcousticModelPath("");config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        config.setDictionaryPath("dic2.dic");
        config.setLanguageModelPath("lm2.lm");

        try {
            LiveSpeechRecognizer speech = new LiveSpeechRecognizer(config);
            speech.startRecognition(true);
            SpeechResult speechResult;

            while (((speechResult = speech.getResult()) != null)){
                f = true;
                String voiceCommand = speechResult.getHypothesis();
                System.out.println(voiceCommand);
                if (voiceCommand.equalsIgnoreCase("UP")) {
                    if (!(Snake.head.getDir() == Dir.DOWN) && !Snake.waitToMove) {
                        Snake.head.setDir(Dir.UP);
                        Snake.waitToMove = true;
                    }
                    f = false;
                } else if (voiceCommand.equalsIgnoreCase("LEFT")) {
                    if (!(Snake.head.getDir() == Dir.RIGHT) && !Snake.waitToMove) {
                        Snake.head.setDir(Dir.LEFT);
                        Snake.waitToMove = true;
                    }
                    f = false;
                } else if (voiceCommand.equalsIgnoreCase("DOWN")) {
                    if (!(Snake.head.getDir() == Dir.UP) && !Snake.waitToMove) {
                        Snake.head.setDir(Dir.DOWN);
                        Snake.waitToMove = true;
                    }
                    f = false;
                } else if ( voiceCommand.equalsIgnoreCase("RIGHT")) {
                    if (!(Snake.head.getDir() == Dir.LEFT) && !Snake.waitToMove) {
                        Snake.head.setDir(Dir.RIGHT);
                        Snake.waitToMove = true;
                    }
                    f = false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
