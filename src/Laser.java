
public class Laser extends Actor {
    
    // make a private instance variable that stores the speed as an int
    int speed;
    
    // make a default constructor that initializes speed to 5
    // and points the laser up
    public Laser(){
        speed = 5;
        scale(16,4);
        setRotation(-90);
    }
    
    
    // Make constructor that takes speed
    // and points the laser up
    public Laser(int sped) {
        speed = sped;
        setRotation(270);
    }
 
    
    // make constructor that takes speed and rotation
    public Laser(int sped, int rotation){
        speed = sped;
        setRotation(rotation);
    }

    // Every frame the laser should:
    // 1. move()
    // 2. if it is still in the world, it should
    //    a. get a hittable actor and:
    //       i.     call on hit() on the hittable
    //       ii.    Call onHitTarget() on itself
    //    b. if the actor is still in the world and shouldBeRemoved()
    //       then call remove()
    public void act() {
        move();
        Hittable h = (Hittable) getOneIntersectingObject(Hittable.class);
        
        if (h != null) {
            h.onHit();
            onHitTarget();
        }
        if (getWorld() != null && shouldBeRemoved()){
            remove();
        }
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    // make a shouldBeRemoved() method
    // returns true if the laser should be removed and false otherwise
    // (i.e. if it is past a world edge)
    public boolean shouldBeRemoved(){
        
        if (isAtEdge()){
            return true;
        } else {
            return false;
        }
    }
    
    // Make an onHitTarget() method that calls remove()
    
    public void onHitTarget() {
        remove();
    }
    // Make a remove() method that removes this laser
    public void remove() {
        getWorld().removeObject(this);
        
    }
    
    // make a move() method that moves the laser by speed
    public void move(){
        move(speed);
    }
    
    // make getter and setter for speed
    public int getSpeed(){
        return speed;
    }
    
    public void setSpeed(int newSpeed){
        speed = newSpeed;
    }
    
    

}
