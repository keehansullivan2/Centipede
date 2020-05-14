import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */

    int w;
    int h;

    public MyWorld(int w, int h)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        //super(26*20, 700, 1, false); //Question: Is this hardcoded? is there a more
        //more general way?
        //GameState gameState = new GameState(this);
        //setState(gameState);
        this.w = w;
        this.h = h;
        for (int i = 0; i < 3; i++){
            Centipede ant = new Centipede();
            ant.scale(20,20);
            addObject(ant, i*ant.getWidth(), 0);

        }

        for (int i = 0; i < 35; i++){
            Mushroom mush = new Mushroom();
            mush.scale(20,20);
            int mushw = (int) 20;
            int mushH = (int) 20;
            int y = (int) h/mushH;
            int x = (int) w/mushw;


            int xcoord = (int) (Math.random() * x);
            int ycoord = (int) (Math.random() * y);


            List list = getObjectsAt(xcoord,ycoord, null);
            while (list.size() != 0) {
                xcoord = (int) (Math.random() * x);
                ycoord = (int) (Math.random() * y);
                list = getObjectsAt(mushw/2+xcoord*mushw,mushw/2+ycoord*mushH, null);
            }
            addObject(mush, xcoord*mushw, ycoord*mushH);

        }
        //Player player = new Player();
        //getWorld().addObject(player, getWorld().getWidth()/2 + (getWorld().getWidth()/2%2), getWorld().getHeight() - player.getImage().getHeight()/2- ((getWorld().getHeight() - player.getImage().getHeight()/2) %2) );

    }



    public void newWorld(){
        actors= new ArrayList<Actor>();
        getChildren().clear();

        for (int i = 0; i < 3; i++){
            Centipede ant = new Centipede();
            ant.scale(20,20);
            addObject(ant, i*ant.getWidth(), 0);

        }

        for (int i = 0; i < 35; i++){
            Mushroom mush = new Mushroom();
            mush.scale(20,20);
            int mushw =  20;
            int mushH = (int) 20;
            int y = (int) h/mushH;
            int x = (int) w/mushw;


            int xcoord = (int) (Math.random() * x);
            int ycoord = (int) (Math.random() * y);


            List list = getObjectsAt(xcoord,ycoord, null);
            while (list.size() != 0) {
                xcoord = (int) (Math.random() * x);
                ycoord = (int) (Math.random() * y);
                list = getObjectsAt(mushw/2+xcoord*mushw,mushw/2+ycoord*mushH, null);
            }
            addObject(mush, xcoord*mushw, ycoord*mushH);
            System.out.println(w);
        }

    }

}
   
        

