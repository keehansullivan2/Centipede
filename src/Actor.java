import javafx.scene.image.ImageView;
import java.lang.Math;
import java.util.ArrayList;

/**
 * Created by seankeehansullivan on 5/2/20.
 */

public class Actor extends ImageView {

    private World world;

    private int w=20;
    private int h= 20;

    public Actor(){
        this.setPreserveRatio(true);
    }

    public void move(int distance) {
        setY(getY() - (int) distance*Math.sin((double) getRotation()));
        setX(getX() + (int) distance*Math.cos((double) getRotation()));
    }

    public void setLocation(int x, int y){
        setX(x);
        setY(y);
    }

    public void setRotation(double x) {
        setRotate(x);
    }

    public void onHit(){

    }


    public boolean isAtEdge(){
        return getX() < getImage().getWidth() || getY() < getImage().getHeight()||
                getX() > getWorld().getWidth() - getImage().getWidth() ||
                getY() > getWorld().getHeight() - getImage().getHeight();
    }


    public double getRotation(){
        return getRotate();
    }



    public void act(){



    }
    public World getWorld() {
        return world;
    }
    public void setWorld(World world){
        this.world = world;
    }

    public Actor getOneObjectAtOffset(int dx, int dy, Class c) {
        if (getWorld() == null) {
            return null;
        } else {
            ArrayList<Actor> actors = new ArrayList<Actor>(getWorld().getActors());
            for (Actor a: actors) {
                if (a.getClass().equals(c)) {
                    if (a.contains(getX() + dx, getY() + dy)){

                        return a;
                    }
                }
            }
            return null;
        }
    }
    public void scale(int w, int h) {
        setFitHeight(h);
        setFitHeight(w);
        this.w = w;
        this.h = h;

    }

    public Actor getOneIntersectingObject(){
        for (Actor a: getWorld().getActors()){
            if (a.contains(getX(), getY())){
                return a;
            }
        }
        return null;
    }

    public Actor getOneIntersectingObject(Class clas){
        for (Actor a: getWorld().getActors()){
            if (a.getClass() == clas) {
                if (a.contains(getX(), getY())) {
                    return a;
                }
            }
        }
        return null;
    }

    public void turn(double rotation) {
        setRotate(( rotation)+ getRotation());
        getImage();

    }

    public int getWidth(){
        return w;
    }
    public int getHeight(){
        return h;
    }
}
