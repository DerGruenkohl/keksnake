package actions;

import clocks.GameClock;
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import game.Snake;
import gui.Gui;
import util.VoiceListener;

import java.io.*;

import static java.lang.Integer.parseInt;
public class Main {

    public static String directory(){
        return System.getProperty("user.dir");

    }
    public static int scoreread;
    public static void main(String[] args) {
        System.out.println(directory());
        String absolutePath = directory() + "bestscore.txt";

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

        Gui g = new Gui();
        GameClock gc = new GameClock();

        g.create();
        gc.start();


    }
}
