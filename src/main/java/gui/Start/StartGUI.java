package gui.Start;

import clocks.GameClock;
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import game.Dir;
import game.Snake;
import gui.Game.Gui;
import util.OpenTheGui;
import util.StartVoiceAPI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static java.lang.Thread.sleep;

public class StartGUI extends JFrame {
    OpenTheGui gui = new OpenTheGui();
    StartVoiceAPI voiceAPI = new StartVoiceAPI();
    public boolean b = false;
    private JButton ja;
    private JButton nein;
    private JTextField Voice;
    public StartGUI(){
        setLayout(new FlowLayout());
        ja = new JButton("Ja");
        nein = new JButton("Nein");
        Voice = new JTextField("Willst du die Voice API aktivieren?");
        Voice.setEditable(false);
        add(Voice);
        add(ja);
        add(nein);
        DerHandler handler = new DerHandler();
        ja.addActionListener(handler);
        nein.addActionListener(handler);
        setVisible(true);
        setSize(200, 200);
        setLocation(500, 500);
        while (!b){
            try {
                sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        setVisible(false);
    }
    private class DerHandler implements ActionListener {
        boolean f = false;

        @Override
        public void actionPerformed(ActionEvent event) {
            boolean s = false;

            if(event.getSource() == ja){
                gui.Open();
                voiceAPI.start();


              /*  Configuration config = new Configuration();
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
                }*/

            }else if (event.getSource() == nein){
                OpenTheGui g = new OpenTheGui();
                g.Open();
            }
        }

    }
}
