package util;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import game.Dir;
import game.Snake;

import java.io.IOException;

public class StartVoiceAPI {
    public void start(){
        Configuration config = new Configuration();
        config.setAcousticModelPath("");config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        config.setDictionaryPath("dic2.dic");
        config.setLanguageModelPath("lm2.lm");
        try {
            LiveSpeechRecognizer speech = new LiveSpeechRecognizer(config);
            speech.startRecognition(true);
            SpeechResult speechResult;

            while (((speechResult = speech.getResult()) != null)){
                String voiceCommand = speechResult.getHypothesis();
                System.out.println(voiceCommand);
                if (voiceCommand.equalsIgnoreCase("UP")) {
                    if (!(Snake.head.getDir() == Dir.DOWN) && !Snake.waitToMove) {
                        Snake.head.setDir(Dir.UP);
                        Snake.waitToMove = true;
                    }
                } else if (voiceCommand.equalsIgnoreCase("LEFT")) {
                    if (!(Snake.head.getDir() == Dir.RIGHT) && !Snake.waitToMove) {
                        Snake.head.setDir(Dir.LEFT);
                        Snake.waitToMove = true;
                    }
                } else if (voiceCommand.equalsIgnoreCase("DOWN")) {
                    if (!(Snake.head.getDir() == Dir.UP) && !Snake.waitToMove) {
                        Snake.head.setDir(Dir.DOWN);
                        Snake.waitToMove = true;
                    }
                } else if ( voiceCommand.equalsIgnoreCase("RIGHT")) {
                    if (!(Snake.head.getDir() == Dir.LEFT) && !Snake.waitToMove) {
                        Snake.head.setDir(Dir.RIGHT);
                        Snake.waitToMove = true;
                    }
                }


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
