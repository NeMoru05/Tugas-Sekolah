import greenfoot.*;
public class WorldRoute113 extends World
{
    static int originalX = 200, originalY = 150;
    
    static boolean[] itemTaken = {false,}, npcDone = {false,};
    
    Scroller scroller;
    Player scrollActor;
    
    static final int WIDE = 500, HIGH = 400;
    
    public WorldRoute113()
    {
        super(WIDE, HIGH, 1, false);
        setPaintOrder
        (
            Transition.class, OverlayTextTriangle.class, OverlayText.class, OverlayChoiceTriangle.class, OverlayOption.class, Warp.class, Event.class, ObjectZone.class, 
            ObjectBasicOver.class, DustCloud.class, Player.class, Objects.class
        );
        setActOrder(Player.class, OverlayOption.class);
        addData();
        addObjects();
        addPlayer();
    }
    
    public void act()
    {
        scroll();
    }
    
    public void scroll()
    {
        if(scrollActor != null)
        {
            int dsX = scrollActor.getX() - WIDE / 2;
            int dsY = scrollActor.getY() - HIGH / 2;
            scroller.scroll(dsX, dsY);
        }
    }
    
    public void addData()
    {
        addObject(new DataSound(), 0, 0);
        addObject(new DataPokemon(), 0, 0);
        addObject(new DataWildPokemon(this.getClass().getName()), 0, 0);
        addObject(new DataPlayer(), 0, 0);
        addObject(new DataInventory(), 0, 0);
    }
    
    public void addPlayer()
    {
        GreenfootImage bg = new GreenfootImage("BackOverworldGrass.png");
        scroller = new Scroller(this, bg, 621, 590);
        scrollActor = new Player();
        addObject(scrollActor, originalX, originalY);
        Player.originalX = originalX;
        Player.originalY = originalY;
        Player.worldX = originalX;
        Player.worldY = originalY;
        Player.speed = 2;
        scroll();
    }
    
    public void addObjects()
    {
        for(int i = 0; i < 4; i++)
        {
            addObject(new ObjectBasicOver("TreeTop"), 92 + 86 * i, 538);
            addObject(new ObjectSimple("TreeBottom"), 92 + 86 * i, 597);
        }
        for(int i = 0; i < 4; i++)
        {
            addObject(new ObjectBasicOver("TreeTop"), 92 + 86 * i, 226);
            addObject(new ObjectSimple("TreeBottom"), 92 + 86 * i, 285);
        }
        addObject(new ObjectBasicOver("TreeTop"), 529, 538);
        addObject(new ObjectSimple("TreeBottom"), 529, 597);
        addObject(new ObjectSimple("Tree"), 7, 30);
        for(int i = 0; i < 5; i++)
            addObject(new ObjectSimple("Tree"), 267 + 87 * i, -27);
        for(int i = 0; i < 5; i++)
            addObject(new ObjectSimple("Tree"), 267 + 87 * i, 30);
        for(int j = 0; j < 2; j++)
            for(int i = 0; i < 8; i++)
                addObject(new ObjectSimple("Tree"), 6 + 609 * j, 30 + 78 * i);
        
        for(int i = 0; i < 24; i++)
            addObject(new ObjectSimple("BarrierStartHorizontal"), 185 + 16 * i, 420);
        addObject(new ObjectSimple("BarrierEndHorizontal"), 569, 420);
        addObject(new ObjectSimple("CaveEntranceLeft"), 89, 60);
        addObject(new ObjectSimple("CaveEntranceRight"), 187, 60);
        addObject(new ObjectBasicOver("CaveEntranceUp"), 137, 8);
        addObject(new ObjectText("SignWood", new String[] {"Strange Cave"}), 90, 95);
        
        addObject(new ObjectNPC
        (
            "AdventureMan",
            new String[] {"Wild Pokémons are dangerous. Take this."},
            new String[] {"Don't forget to use them when your", "Pokémon's hp are low."}, 
            npcDone[0], true, "turn", "Potion", 3, 2, 0
        ), 560, 387);
        
        for(int i = 0; i < 6; i++)
            for(int j = 0; j < 3; j++)
                addObject(new ObjectSpecialGrass("Basic"), 62 + i * 28, 335 + j * 28);
        for(int i = 0; i < 6; i++)
            for(int j = 0; j < 2; j++)
                addObject(new ObjectSpecialGrass("Basic"), 242 + i * 28, 105 + j * 28);
        
        addObject(new ObjectSpecialDoor("CaveEntrance"), 137, 52);
        
        for(int i = 0; i < 8; i++)
            addObject(new ObjectSpecialFlower("Red"), 560, 125 + 32 * i);
        
        if(!itemTaken[0])
            addObject(new ObjectItem("SuperPotion", 1, 0), 558, 95);
        
        addObject(new ObjectZone("Route 113"), 250, 200);
        
        addObject(new Warp("WorldTownTrash", 613, 25, 80, 10, 1), 440, 590);
        addObject(new Warp("WorldCaveStrange", 65, 555, 40, 10, 2), 137, 10);
    }
}
