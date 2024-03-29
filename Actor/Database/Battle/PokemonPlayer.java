import greenfoot.*;
public class PokemonPlayer extends Battle
{
    GreenfootImage[] sprites;
    int currentImage;
    
    int time;
    int secondTime;
    
    boolean pokemonDead;
    
    public PokemonPlayer()
    {
        switch(DataPokemon.pokemons[DataPokemon.pokemonSelected])
        {
            case "Tepig" : sprites = new GreenfootImage[25];
                break;
            case "Mudkip" : sprites = new GreenfootImage[29];
                break;
            case "Turtwig" : sprites = new GreenfootImage[33];
                break;
        }
        
        for(int i = 0; i < sprites.length; i++)
            sprites[i] = new GreenfootImage("Pokemons/" + DataPokemon.pokemons[DataPokemon.pokemonSelected] + "Back/" + i + ".png");
    }
    
    public void act()
    {
        if(DataPokemon.hpStatsCurrent[DataPokemon.pokemonSelected] > 0)
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
