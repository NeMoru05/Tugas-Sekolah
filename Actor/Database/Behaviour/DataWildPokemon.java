import greenfoot.*;
public class DataWildPokemon extends Datas
{
    static int pokemonNumber;
    static int pokemonSelected;
    static String[] pokemons = new String[3];
    static String[] pokemonMoves1 = new String[3];
    static String[] pokemonMoves2 = new String[3];
    static String[] pokemonMoves3 = new String[3];
    static String[] pokemonMoves4 = new String[3];
    static int[] numberOfMoves = new int[3];
    static String[] pokemonTypes1 = new String[3];
    static String[] pokemonTypes2 = new String[3];
    static int pokemonLevels;
    static int[] hpStats = new int[3];
    static int[] attackStats = new int[3];
    static int[] defenseStats = new int[3];
    static int[] specialAttackStats = new int[3];
    static int[] specialDefenseStats = new int[3];
    static int[] speedStats = new int[3];
    static int[] hpStatsCurrent = new int[3];
    static int[] attackStatsCurrent = new int[3];
    static int[] defenseStatsCurrent = new int[3];
    static int[] specialAttackStatsCurrent = new int[3];
    static int[] specialDefenseStatsCurrent = new int[3];
    static int[] speedStatsCurrent = new int[3];
    
    public DataWildPokemon(String world)
    {
        //Created a random wild pokemon based on the world
        switch(world)
        {
            case "WorldRoute113" : pokemonNumber = 2; 
                pokemons[0] = "Caterpie"; pokemons[1] = "Pidgey"; 
                pokemonLevels = 3 + Greenfoot.getRandomNumber(2) - 1;
                pokemonMoves1[0] = "Tackle"; pokemonMoves1[1] = "Gust"; 
                numberOfMoves[0] = 1; numberOfMoves[1] = 1;
                pokemonTypes1[0] = "Bug"; pokemonTypes1[1] = "Normal";
                pokemonTypes2[0] = null; pokemonTypes2[1] = "Flying"; 
                pokemonSelected = Greenfoot.getRandomNumber(pokemonNumber);
                break;
            case "WorldCaveStrange" : pokemonNumber = 2; 
                pokemons[0] = "Geodude"; pokemons[1] = "Roggenrola"; 
                pokemonLevels = 4 + Greenfoot.getRandomNumber(2) - 1;
                pokemonMoves1[0] = "RockTomb"; pokemonMoves1[1] = "RockTomb";
                pokemonMoves2[0] = "Tackle"; pokemonMoves2[1] = "Tackle";
                numberOfMoves[0] = 2; numberOfMoves[1] = 2;
                pokemonTypes1[0] = "Rock";  pokemonTypes1[1] = "Rock";
                pokemonTypes2[0] = "Ground"; pokemonTypes2[1] = null;
                pokemonSelected = Greenfoot.getRandomNumber(pokemonNumber);
                break;
            case "WorldWildBattle" :
                break;
            default : pokemonNumber = 0;
                break;
        }
        int i = pokemonSelected;
        //sets base stats for the wild pokemon
        if(pokemonNumber > 0)
        {
            switch(pokemons[i])
            {
                case "Caterpie" : hpStats[i] = (int)(12 + 2.03 * pokemonLevels); speedStats[i] = (int)(6 + 1.04 * pokemonLevels);
                    attackStats[i] = (int)(5 + 0.75 * pokemonLevels); defenseStats[i] = (int)(5 + 0.85 * pokemonLevels);
                    specialAttackStats[i] = (int)(5 + 0.55 * pokemonLevels); specialDefenseStats[i] = (int)(5 + 0.55 * pokemonLevels);
                    break;
                case "Pidgey" : hpStats[i] = (int)(12 + 2.09 * pokemonLevels); speedStats[i] = (int)(6 + 1.42 * pokemonLevels);
                    attackStats[i] = (int)(6 + 1.2 * pokemonLevels); defenseStats[i] = (int)(6 + 1.1 * pokemonLevels);
                    specialAttackStats[i] = (int)(6 + 1 * pokemonLevels); specialDefenseStats[i] = (int)(6 + 1 * pokemonLevels);
                    break;
                case "Geodude" : hpStats[i] = (int)(11 + 1.97 * pokemonLevels); speedStats[i] = (int)(5 + 0.55 * pokemonLevels);
                    attackStats[i] = (int)(6 + 1.74 * pokemonLevels); defenseStats[i] = (int)(7 + 2.13 * pokemonLevels);
                    specialAttackStats[i] = (int)(5 + 0.75 * pokemonLevels); specialDefenseStats[i] = (int)(5 + 0.75 * pokemonLevels);
                    break;
                case "Roggenrola" : hpStats[i] = (int)(12 + 2.23 * pokemonLevels); speedStats[i] = (int)(5 + 0.45 * pokemonLevels);
                    attackStats[i] = (int)(6 + 1.64 * pokemonLevels); defenseStats[i] = (int)(6 + 1.84 * pokemonLevels);
                    specialAttackStats[i] = (int)(5 + 0.65 * pokemonLevels); specialDefenseStats[i] = (int)(5 + 0.65 * pokemonLevels);
                    break;
            }
            attackStatsCurrent[i] = attackStats[i];
            defenseStatsCurrent[i] = defenseStats[i];
            specialAttackStatsCurrent[i] = specialAttackStats[i];
            specialDefenseStatsCurrent[i] = specialDefenseStats[i];
            speedStatsCurrent[i] = speedStats[i];
            hpStatsCurrent[i] = hpStats[i];
        }
    }
}
