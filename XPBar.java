import greenfoot.*;
public class XPBar extends Battle
{
    GreenfootImage image = new GreenfootImage("Battle/XPBar.png");
    
    int xp = DataPokemon.neededXP[DataPokemon.pokemonSelected];
    int xpCurrent = DataPokemon.currentXP[DataPokemon.pokemonSelected];
    int xpPercentage;
    
    boolean stopShowing;
    
    public XPBar()
    {
        setImage(image);
        xp = DataPokemon.neededXP[DataPokemon.pokemonSelected];
        xpCurrent = DataPokemon.currentXP[DataPokemon.pokemonSelected];
        xpPercentage = (xpCurrent * 100) / xp;
        animate();
    }
    
    public void act()
    {
        xpPercentage = (xpCurrent * 100) / xp;
        if(getY() > 336)
            setLocation(getX(), getY() - 3);
        else if(!stopShowing)
        {
            animate();
        }
    }
    
    public void animate()
    {
        if(xpPercentage > 99)
        {
            xp = DataPokemon.neededXP[DataPokemon.pokemonSelected];
            xpCurrent = 0;
            getWorld().getObjects(DataWildBattle.class).get(0).xpTime = DataPokemon.currentXP[DataPokemon.pokemonSelected] * 2;
        }
        
        if(xpPercentage > 0)
            image.scale(xpPercentage * 2, 2);
        else
            image.scale(1, 2);
        setLocation((470 + (xpPercentage * 2 - 200) / 2), 334);
    }
}
