package actions;

import game.Snake;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static actions.Main.directory;
import static java.lang.Integer.parseInt;

public class Collision {
    public void CreateFile(){
        File file = new File(directory() + "bestscore.txt");
        boolean result;
        try {
            result = file.createNewFile();
            if(result)      // test if successfully created a new file
            {
                System.out.println("file created "+file.getCanonicalPath()); //returns the path string
            }
            else
            {
                System.out.println("File already exist at location: "+file.getCanonicalPath());
            }
        }catch (IOException e)
        {
            e.printStackTrace();    //prints exception if any
        }
    }

    public static boolean collideSelf() {
        for(int i = 0; i<Snake.tails.size(); i++){
            if(Snake.head.getX() == Snake.tails.get(i).getX() && Snake.head.getY() == Snake.tails.get(i).getY()
                    && !Snake.tails.get(i).isWait()){
                return true;
            }

        }

        return false;
    }

    public static boolean collideWall() {

        return (Snake.head.getX() < 0 || Snake.head.getX() > 15 || Snake.head.getY() < 0 || Snake.head.getY() > 15);
    }
    public static int sce;
    public static void collidePickUp() {
        String absolutePath = directory() + "bestscore.txt";
        if (Snake.head.getX() == Snake.pickup.getX() && Snake.head.getY() == Snake.pickup.getY()) {
            Snake.pickup.reset();
            Snake.addTail();
            Snake.score +=1;
            if(Snake.bestscore == null){
                Snake.bestscore = Integer.toString(Main.scoreread);
            }
            if(Snake.score > Main.scoreread){ sce = Snake.score;
                Snake.bestscore = Integer.toString(sce);
                try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(absolutePath))) {
                    String fileContent = Integer.toString(sce);
                    bufferedWriter.write(fileContent);
                } catch (IOException e) {
                    // Exception handling
                    System.out.println("failed to write");
                }
            }
        }
    }

}
