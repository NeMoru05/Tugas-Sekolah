import greenfoot.*;
public class PokemonEnemy extends Battle
{
    GreenfootImage[] sprites;
    int currentImage;
    
    int time;
    int secondTime;
    
    boolean pokemonDead;
    
    public PokemonEnemy()
    {
        switch(DataWildPokemon.pokemons[DataWildPokemon.pokemonSelected])
        {
            case "Caterpie" : sprites = new GreenfootImage[16];
                break;
            case "Pidgey" : sprites = new GreenfootImage[21];
                break;
            case "Geodude" : sprites = new GreenfootImage[10];
                break;
            case "Roggenrola" : sprites = new GreenfootImage[33];
                break;
        }
        
        for(int i = 0; i < sprites.length; i++)
            sprites[i] = new GreenfootImage("Pokemons/" + DataWildPokemon.pokemons[DataWildPokemon.pokemonSelected] + "Front/" + i + ".png");
    }
    
    public void act()
    {
        if(getY() < 120)
            setLocation(getX(), getY() + 3);
        if(DataWildPokemon.hpStatsCurrent[DataWildPokemon.pokemonSelected] > 0)
        {
            secondTime++;
            if(secondTime % 2 == 0)
                time++;
            if(time == sprites.length * 3 - 4)
            {
                currentImage = 0;
                time = 0;
            }
            
            if(secondTime % 6 == 0)
                currentImage++;
            setImage(sprites[currentImage]);
        }
        else
            pokemonDead = true;
        if(pokemonDead)
            setImage((GreenfootImage)null);
    }
}
