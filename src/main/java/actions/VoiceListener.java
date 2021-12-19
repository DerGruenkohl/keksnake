package actions;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;


import java.io.IOException;

public class VoiceListener {
    public String Voice(){
        Configuration config = new Configuration();
        config.setAcousticModelPath("");config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        config.setDictionaryPath("src\\main\\resources\\dic.dic");
        config.setLanguageModelPath("src\\main\\resources\\lm.lm");
        config.setSampleRate(8000);

        try {
            LiveSpeechRecognizer speech = new LiveSpeechRecognizer(config);
            speech.startRecognition(true);
            SpeechResult speechResult;

            while ((speechResult = speech.getResult()) != null){
                String voiceCommand = speechResult.getHypothesis();
                System.out.println(voiceCommand);
                return voiceCommand;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
