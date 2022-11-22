import greenfoot.*;
public class ObjectSpecialGrass extends Objects
{
    public ObjectSpecialGrass(String name)
    {
        setImage("Objects/Special/Grass/" + name + ".png");
        switch(name)
        {
            case "Basic" : center = 5;
                break;
        }
    }
    
    public void act()
    {
        checkPlayer();
    }
    
    @Override
    public void checkPlayer()
    {
        Player player = (Player)getWorld().getObjects(Player.class).get(0);
        playerX = player.getX();
        playerY = player.getY();
        if(isTouching(Player.class) && playerY < getY() + center && player.isMoving)
        {
            if(Greenfoot.getRandomNumber(5) == 0)
                getWorld().addObject(new DustCloud(), player.getX(), player.getY() + 7);
            Player.isInGrass = true;
        }
    }
}
