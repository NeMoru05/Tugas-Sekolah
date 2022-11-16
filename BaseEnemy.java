public class BaseEnemy extends Battle
{
    public BaseEnemy(String type)
    {
        setImage("Battle/BaseEnemy" + type + ".png");
    }
    
    public void act()
    {
        if(getY() < 188)
            setLocation(getX(), getY() + 3);
    }
}
