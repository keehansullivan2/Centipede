/**
 * Created by seankeehansullivan on 5/3/20.
 */
public class Hittable extends Actor{

    public void onhit(){
        destroy();
    }

    public void destroy(){
        getWorld().removeObject(this);

    }

}
