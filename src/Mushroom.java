import java.util.List;
import javafx.scene.image.Image;

/**
 * Write a description of class Mushroom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mushroom extends Actor
{
    /**
     * Act - do whatever the Mushroom wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int hitCount = 0;
    public void act() 
    {
        // Add your action code here.
    }

    public Mushroom(){
        Image img = new Image("file:images/Arcade - Centipede - General Sprites_0008.png");
        setImage(img);
        scale((int) img.getWidth(), (int) img.getHeight());
    }
    
    public void align(){
        
        int x = (int) ((getX() +getImage().getWidth()/2) - getX()%getImage().getWidth());
        int y = (int) ((getY() + getImage().getHeight()/2) - getY()%getImage().getHeight());
        
        setLocation(x, y);
        
    }
    public void alignAll(){
        World w = getWorld();
        List list = w.getObjects(Mushroom.class);
        for (int i = 0; i < list.size(); i++){
            Mushroom mush = (Mushroom) list.get(i);
            mush.align();
        }
    }
    
    
    @Override
    public void onHit(){
        hitCount++;
        if (hitCount == 4){
            getWorld().removeObject(this);
        }else if (hitCount == 1){
            setImage(new Image("images/Arcade - Centipede - General Sprites_0009.png"));
            scale(20,20);
        } else if (hitCount == 2){
            
            setImage(new Image("file:images/Arcade - Centipede - General Sprites_0010.png"));
            scale(20,20);

        } else if (hitCount == 3){
            setImage(new Image("file:images/Arcade - Centipede - General Sprites_0011.png"));
            scale(20,20);

        }
        
    }
}
