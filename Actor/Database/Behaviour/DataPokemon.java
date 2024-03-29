import greenfoot.*;
public class DataPokemon extends Datas
{
    static int pokemonNumber = 0;
    static int pokemonSelected = 0;
    static String[] pokemons = new String[6];
    static String[] pokemonMoves1 = new String[6];
    static String[] pokemonMoves2 = new String[6];
    static String[] pokemonMoves3 = new String[6];
    static String[] pokemonMoves4 = new String[6];
    static String[] pokemonTypes1 = new String[6];
    static String[] pokemonTypes2 = new String[6];
    static int[] currentXP = new int[6];
    static int[] neededXP = new int[6];
    static int[] pokemonLevels = new int[6];
    static int[] hpStats = new int[6];
    static int[] attackStats = new int[6];
    static int[] defenseStats = new int[6];
    static int[] specialAttackStats = new int[6];
    static int[] specialDefenseStats = new int[6];
    static int[] speedStats = new int[6];
    static int[] hpStatsCurrent = {-1, -1, -1, -1, -1, -1};
    static int[] attackStatsCurrent = new int[6];
    static int[] defenseStatsCurrent = new int[6];
    static int[] specialAttackStatsCurrent = new int[6];
    static int[] specialDefenseStatsCurrent = new int[6];
    static int[] speedStatsCurrent = new int[6];
    
    public DataPokemon()
    {
        //Sets the base stats for all pokemons
        for(int i = 0; i < pokemonNumber; i++)
        {
            switch(pokemons[i])
            {
                case "Tepig" : 
                    hpStats[i] = (int)(12 + 2.43 * pokemonLevels[i]); speedStats[i] = (int)(6 + 1.4 * pokemonLevels[i]);
                    attackStats[i] = (int)(6 + 1.4 * pokemonLevels[i]); defenseStats[i] = (int)(6 + 1.04 * pokemonLevels[i]);
                    specialAttackStats[i] = (int)(6 + 1.04 * pokemonLevels[i]); specialDefenseStats[i] = (int)(6 + 1.04 * pokemonLevels[i]);
                    break;
                case "Mudkip" : 
                    hpStats[i] = (int)(12 + 2.13 * pokemonLevels[i]); speedStats[i] = (int)(5 + 0.95 * pokemonLevels[i]);
                    attackStats[i] = (int)(6 + 1.54 * pokemonLevels[i]); defenseStats[i] = (int)(6 + 1.14 * pokemonLevels[i]);
                    specialAttackStats[i] = (int)(6 + 1.14 * pokemonLevels[i]); specialDefenseStats[i] = (int)(6 + 1.14 * pokemonLevels[i]);
                    break;
                case "Turtwig" : 
                    hpStats[i] = (int)(12 + 2.223 * pokemonLevels[i]); speedStats[i] = (int)(5 + 0.77 * pokemonLevels[i]);
                    attackStats[i] = (int)(6 + 1.5 * pokemonLevels[i]); defenseStats[i] = (int)(6 + 1.42 * pokemonLevels[i]);
                    specialAttackStats[i] = (int)(6 + 1.04 * pokemonLevels[i]); specialDefenseStats[i] = (int)(6 + 1.24 * pokemonLevels[i]);
                    break;
            }
            neededXP[i] = pokemonLevels[i] * 3 / 2;
            attackStatsCurrent[i] = attackStats[i];
            defenseStatsCurrent[i] = defenseStats[i];
            specialAttackStatsCurrent[i] = specialAttackStats[i];
            specialDefenseStatsCurrent[i] = specialDefenseStats[i];
            speedStatsCurrent[i] = speedStats[i];
            //if the pokemon has less than 0 hp, then its current HP return to its base HP to prevent pokemons from being healed without going to the center
            if(hpStatsCurrent[i] < 0)
                hpStatsCurrent[i] = hpStats[i];
        }
    }
    /**
    * Returns the number of alive pokemons the player has
    */
    public static int numberOfAlivePokemons()
    {
        int numberOfAlivePokemons = 0;
        for(int i = 0; i < pokemonNumber; i++)
        {
            //if a pokemon has more than 0 HP, it increments the numberOfAlivePokemons by 1
            if(hpStatsCurrent[i] > 0)
                numberOfAlivePokemons++;
        }
        return numberOfAlivePokemons;
    }
    
    public void changePokemon(int index)
    {
        //changes the selected pokemon a new one specified in the index variable 
        pokemonSelected = index;
    }
    
    public void pokemonCenterHeal()
    {
        //sets the pokemons current HP to their base one
        for(int i = 0; i < pokemonNumber; i++)
            hpStatsCurrent[i] = hpStats[i];
    }
}
