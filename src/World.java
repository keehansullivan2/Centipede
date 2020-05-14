import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import java.util.ArrayList;

/**
 * Created by seankeehansullivan on 5/2/20.
 */
public  class  World extends Pane {
    ArrayList<Actor> actors = new ArrayList<Actor>();


    public World() {
        super();
        Actor mushroom = new Actor();
        mushroom.setImage(new Image("file:images/Arcade - Centipede - General Sprites_0008.png"));
        mushroom.setPreserveRatio(true);

        addObject(mushroom, (int) 200, (int) 200);
        mushroom.scale(20,20);
    }


    public ArrayList<Actor> getObjectsAt(int x, int y, Class clas) {
        ArrayList<Actor> returnlist = new ArrayList<Actor>();
        for (Actor a: actors) {
            if (clas == null && a.contains(x, y)) {
                returnlist.add(a);
            }
            else if (a.getClass() == clas && a.contains(x, y)) {
                returnlist.add(a);
            }
        }
        return returnlist;


    }




    public void act(){
        for (Actor a:actors){

            a.act();

        }


    }

    public ArrayList<Actor> getObjects(Class clas){
        ArrayList<Actor> returnlist = new ArrayList<Actor>();
        if (clas == null) {
            return actors;
        } else {
            for (Actor a: actors) {
                if (a.getClass() == clas){
                    returnlist.add(a);
                }
            }
            return returnlist;
        }

    }
    public ArrayList<Actor> getActors(){
        return actors;
    }

    public void addObject(Actor actor){
        actor.setWorld(this);

    }
    public void removeObject(Actor actor) {
        getChildren().remove(actor);
        getActors().remove(actor);
    }
    public void addObject(Actor a, int x, int y){
        getChildren().add(a);
        actors.add(a);
        a.setLocation(x, y);
        a.setWorld(this);

    }



}
