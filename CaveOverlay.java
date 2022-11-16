import greenfoot.*;
public class CaveOverlay extends Actor
{
    public CaveOverlay(String type)
    {
        switch(type)
        {
            case "Basic" : setImage("Wall.png");
                getImage().scale(1002, 802);
                getImage().setTransparency(80);
                break;
            case "Dark" : setImage("CaveOverlay.png");
                break;
        }
    }
    
    public void act()
    {
        setLocation(Player.originalX, Player.originalY);
    }
}
