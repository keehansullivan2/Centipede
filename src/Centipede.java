import javafx.scene.image.Image;
import java.lang.Math;
/**
 * Write a description of class Centipede here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Centipede extends Actor {


    int count = 0;
    boolean bool = true;
    boolean movingEast = true;
    boolean movingDown = true;
    /**
     * Act - do whatever the Centipede wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public Centipede(){
        Image img = new Image("file:images/Centipede_0000-flipped.png");
        setImage(img);
        scale((int) img.getWidth(),(int) img.getHeight());
        setRotate(0);
    }

    public int dx = 2;



    public void act(){
    /*
         World world = getWorld();
         int w = (int) world.getWidth();
         int h = (int)world.getHeight();
         int unitx = 2;
         int unity = getHeight();
         if (count > 0){
            moveDown();
         }else if (mushroomCheck()||(w - getX()-6  <= getWidth()*1/2 && getRotation() == 0) || (getRotation() == 180 && getX() - getWidth()/2-6 <=0)){
            count = 10;
            move(unitx);
            if(getRotation() == 0){
                turn(180/4);
                setLocation((int) getX(), (int) getY() + unity); //why minus 1 looks better?
             }else{
                setRotation(0);
                setLocation((int)getX(), (int) getY() + unity); // same as above but plus.
              }
        } else {
             move(unitx);
         }
         */

        int unitx = 2;
        if (getY() >= getWorld().getHeight() - getHeight()){
            movingDown = false;
        }
        if (movingDown) {
            if (getX()+getWidth()> getWorld().getWidth() && Math.abs(getRotation() % (2*Math.PI) )< .1){
                setLocation((int) getX(), (int) getY() + getHeight());
                setRotate(Math.PI);

                Image img = new Image("file:images/Arcade - Centipede - General Sprites_0000.png");
                setImage(img);
                scale((int) img.getWidth(),(int) img.getHeight());
            } else if (getX() < 0 && Math.abs((getRotation() % (2*Math.PI)) - Math.PI) < .1){
                setLocation((int) getX(), (int) getY() + getHeight());
                setRotate(0);

                Image img = new Image("file:images/Centipede_0000-flipped.png");
                setImage(img);
                scale((int) img.getWidth(),(int) img.getHeight());

            } else if (getOneObjectAtOffset(getWidth(), 0, Mushroom.class)!=null && Math.abs(getRotation() % (2*Math.PI) )< .1){
                Image img = new Image("file:images/Arcade - Centipede - General Sprites_0000.png");
                setImage(img);
                scale((int) img.getWidth(),(int) img.getHeight());
                setLocation((int) getX(), (int) getY() + getHeight());
                setRotate(Math.PI);

            }else if (getOneObjectAtOffset(0, 0, Mushroom.class)!=null &&Math.abs((getRotation() % (2*Math.PI)) - Math.PI) < .1){
                setLocation((int) getX(), (int) getY() + getHeight());
                setRotate(0);

                Image img = new Image("file:images/Centipede_0000-flipped.png");
                setImage(img);
                scale((int) img.getWidth(),(int) img.getHeight());
            } else {
                move(unitx);


            }
        } else {
            if (getY() <= getWorld().getHeight() *.8){
                movingDown = true;
            }
            if (getX()+getImage().getWidth()> getWorld().getWidth() && Math.abs(getRotation() % (2*Math.PI) )< .1){
                setRotate(Math.PI);
                move(getHeight());

                Image img = new Image("file:images/Arcade - Centipede - General Sprites_0000.png");
                setImage(img);
                scale((int) img.getWidth(),(int) img.getHeight());
            } else if (getX()/2< 0 && Math.abs((getRotation() % (2*Math.PI)) - Math.PI) < .1){
                setRotate(0);

                move(getHeight());

                Image img = new Image("file:images/Centipede_0000-flipped.png");
                setImage(img);
                scale((int) img.getWidth(),(int) img.getHeight());
            } else if (getOneObjectAtOffset(getWidth(), 0, Mushroom.class)!=null && Math.abs(getRotation() % (2*Math.PI) )< .1){
                setRotate(Math.PI);

                move(getHeight());

                Image img = new Image("file:images/Arcade - Centipede - General Sprites_0000.png");
                setImage(img);
                scale((int) img.getWidth(),(int) img.getHeight());

            }else if (getOneObjectAtOffset(0, 0, Mushroom.class)!=null && Math.abs((getRotation() % (2*Math.PI)) - Math.PI) < .1){
                setRotate(0);

                move(getHeight());

                Image img = new Image("file:images/Centipede_0000-flipped.png");
                setImage(img);
                scale((int) img.getWidth(),(int) img.getHeight());
            } else {
                move(unitx);
            }

        }

        scale(20,20);

    }
    public boolean mushroomCheck() {
        int unitx = (int) getWidth();
        int unity = (int) getHeight();
        if (getRotation() == 0) {
            if (getOneObjectAtOffset(unitx, 0, Mushroom.class) != null) {
                return true;
            }
        } else {
            if (getOneObjectAtOffset(-unitx, 0, Mushroom.class) != null) {
                return true;
            }

        }
        return false;
    }

    public int stepsToMushroom() {
        int steps = 0;


        return steps;
    }

    public void moveDown() {
        if (movingEast) {
            if (count >= 5) {
                setLocation((int) getX() + 1, (int) (getY() + getHeight() / 10));
            } else {
                setLocation((int) getX() - 1, (int) (getY() + getHeight() / 10));
            }
        } else {
            if (count >= 5) {
                setLocation((int) getX() - 1, (int) (getY() + getHeight() / 10));
            } else {
                setLocation((int) getX() + 1, (int) (getY() + getHeight() / 10));
            }
        }
        if (getRotation() == 0) {
            bool = true;
        }
        if (getRotation() == 180) {
            bool = false;
        }
        if (bool) {
            turn(180 / 10);
        } else {
            turn(-180 / 10);
        }
        count--;
        if (count == 0) {
            if (movingEast) {
                movingEast = false;
            } else {
                movingEast = true;
            }
        }
    }

    @Override
    public void onHit(){
        Mushroom mush = new Mushroom();
        mush.scale(20,20);
        getWorld().addObject(mush,(int) getX(), (int) getY());
        mush.alignAll();
        getWorld().removeObject(this);
    }
    @Override
    public int getHeight(){
        return 20;
    }
    @Override
    public int getWidth(){
        return 20;
    }
}


