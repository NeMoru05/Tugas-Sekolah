import greenfoot.*;
public class DataSound extends Datas
{
    static GreenfootSound[] musics = 
    {
        new GreenfootSound("Music/WorldPokemonCenter.mp3"),     //0
        new GreenfootSound("Music/WorldRoute113.mp3"),          //1
        new GreenfootSound("Music/TitleScreen.mp3"),            //2
        new GreenfootSound("Music/WorldTownTrash.mp3"),         //3
        new GreenfootSound("Music/WorldWildBattle.mp3"),        //4
        new GreenfootSound("Music/Blank.mp3"),                  //5
        new GreenfootSound("Music/WorldCaveStrange.mp3"),       //6
    };
    static GreenfootSound[] sounds =
    {
        new GreenfootSound("MenuChoose.mp3"),                   //0
        new GreenfootSound("PokeballLaunch.mp3"),               //1
        new GreenfootSound("BattleRun.mp3"),                    //2
        new GreenfootSound("CursorMove.mp3"),                   //3
        new GreenfootSound("Hits/Weak.mp3"),                    //4
        new GreenfootSound("Hits/Normal.mp3"),                  //5
        new GreenfootSound("Hits/Super.mp3"),                   //6
    };
    static GreenfootSound[] attacks =
    {
        new GreenfootSound("Attacks/Potion.mp3"),               //0
        new GreenfootSound("Attacks/Tackle.mp3"),               //1
        new GreenfootSound("Attacks/Flamethrower.mp3"),         //2
        new GreenfootSound("Attacks/Ember.mp3"),                //3
        new GreenfootSound("Attacks/Low Sweep.mp3"),            //4
        new GreenfootSound("Attacks/Rock Tomb.mp3"),            //5
        new GreenfootSound("Attacks/Razor Leaf.mp3"),           //6
        new GreenfootSound("Attacks/Water Gun.mp3"),            //7
        new GreenfootSound("Attacks/Gust.mp3"),                 //8
    };
    
    static GreenfootSound music;
    
    static int musicVolume = 40;
    static int soundVolume = 40;
    
    public void act()
    {
        for(int i = 0; i < musics.length; i++)
            musics[i].setVolume(musicVolume);
        for(int i = 0; i < sounds.length; i++)
            sounds[i].setVolume(soundVolume);
        for(int i = 0; i < attacks.length; i++)
            attacks[i].setVolume(soundVolume);
        if(music != null)
            music.setVolume(musicVolume);
        playMusic();
    }
    
    /**
    * Plays a music depending on the world name
    */
    public void playMusic()
    {
        String world = getWorld().getClass().getName();
        switch(world)
        {
            case "WorldCenterTownTrash" : music = musics[0];
                break;
            case "WorldRoute113" : music = musics[1];
                break;
            case "WorldMenuScreen" : music = musics[2];
                break;
            case "WorldTownTrash" : music = musics[3];
                break;
            case "WorldWildBattle" : music = musics[4];
                break;
            case "WorldMenuMain" : music = musics[5];
                break;
            case "WorldCaveStrange" : music = musics[6];
                break;
            default : music = null;
                break;
        }
        //if no music is playing and no transition object is in the world, play the music
        if(music != null && !music.isPlaying() && getWorld().getObjects(Transition.class).isEmpty())
        {
            stopMusics();
            music.play();
        }
    }
    
    /**
    * Stops the music
    */
    public void stopMusics()
    {
        for(int i = 0; i < musics.length; i++)
            musics[i].stop();
    }
}
