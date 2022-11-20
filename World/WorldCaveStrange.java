import greenfoot.*;
public class WorldCaveStrange extends World
{
    static int originalX = 300, originalY = 350;
    
    static boolean[] itemTaken = {false}, npcDone = {};
    
    Scroller scroller;
    Player scrollActor;
    
    static final int WIDE = 500, HIGH = 400;
    
    public WorldCaveStrange()
    {
        super(WIDE, HIGH, 1, false);
        setPaintOrder
        (
            Transition.class, OverlayTextTriangle.class, OverlayText.class, OverlayChoiceTriangle.class, OverlayOption.class, Warp.class, Event.class, ObjectZone.class, 
            CaveOverlay.class, ObjectBasicOver.class, DustCloud.class, Player.class, Objects.class
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
        GreenfootImage bg = new GreenfootImage("BackCave.png");
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
        //put a space of 31 instead of 32 when door is there for CaveBigWallDown, and put 10 instead of 11
        for(int i = 0; i < 11; i++)
            for(int j = 0; j < 2; j++)
                addObject(new ObjectSimple("CaveBigWallDown"), 11 + 32 * i, -2 + j * 32);
        for(int i = 0; i < 11; i++)
            for(int j = 0; j < 2; j++)
                addObject(new ObjectSimple("CaveBigWallDown"), 360 + 31 * i, -2 + j * 32);
        for(int i = 0; i < 9; i++)
            addObject(new ObjectSimple("CaveWallLeft"), 12, 336 + i * 32);
        addObject(new ObjectSimple("CaveWallTurnUpLeft"), 12, 312);
        for(int i = 0; i < 7; i++)
            addObject(new ObjectSimple("CaveWallDown"), 36 + 32 * i, 312);
        addObject(new ObjectSimple("CaveWallCornerRight"), 258, 304);
        for(int i = 0; i < 8; i++)
            addObject(new ObjectSimple("CaveWallLeft"), 267, 55 + i * 31);
        for(int i = 0; i < 8; i++)
            addObject(new ObjectSimple("CaveWallRight"), 387, 55 + i * 31);
        addObject(new ObjectSimple("CaveWallCornerLeft"), 396, 304);
        for(int i = 0; i < 6; i++)
            addObject(new ObjectSimple("CaveWallDown"), 426 + 32 * i, 312);
        addObject(new ObjectSimple("CaveWallTurnUpRight"), 610, 314);
        for(int i = 0; i < 4; i++)
            addObject(new ObjectSimple("CaveWallRight"), 610, 337 + i * 32);
        addObject(new ObjectSimple("CaveWallTurnRight"), 610, 440);
        for(int i = 0; i < 17; i++)
            addObject(new ObjectSimple("CaveWallUp"), 144 + i * 28, 450);
        addObject(new ObjectSimple("CaveWallCornerUpRight"), 120, 464);
        for(int i = 0; i < 8; i++)
            addObject(new ObjectSimple("CaveWallRight"), 120, 495 + i * 32);
        
        addObject(new ObjectSimple("Rock"), 94, 500);
        addObject(new ObjectSimple("Rock"), 200, 400);
        addObject(new ObjectSimple("Rock"), 548, 428);
        addObject(new ObjectSimple("Rock"), 359, 225);
        addObject(new ObjectSimple("Rock"), 200, 120);
        addObject(new ObjectSimple("Rock"), 100, 210);
        addObject(new ObjectSimple("Rock"), 450, 190);
        addObject(new ObjectSimple("Rock"), 350, 500);
        addObject(new ObjectSimple("Rock"), 550, 250);
        addObject(new ObjectSimple("RockBig"), 140, 150);
        addObject(new ObjectSimple("RockBig"), 140, 322);
        addObject(new ObjectSimple("RockBig"), 245, 522);
        addObject(new ObjectBasicOver("CaveExitUp"), 325, -5);
        
        addObject(new ObjectSpecialDoor("CaveExit"), 325, 26);
        addObject(new ObjectSimple("CaveExitBlocked"), 325, 30);
        
        addObject(new ObjectText("SignWood", new String[] {"The exit is blocked.", "A group of workers will arrive soon, ", "and they will unblock the exit."}), 290, 42);
        
        addObject(new ObjectNPC
        (
            "BlackBelt",    
            new String[] {"This cave is pretty small.", "It's because the game developper is lazy."}, 
            null, 
            false, true, "turn", null, 0, 0, 0
        ), 108, 320);
        
        addObject(new CaveOverlay("Basic"), originalX, originalY);
        
        if(!itemTaken[0])
            addObject(new ObjectItem("SuperPotion", 1, 0), 582, 431);
        
        addObject(new ObjectZone("Strange Cave"), 250, 200);
        
        addObject(new Warp("WorldRoute113", 137, 100, 70, 10, 1), 65, 590);
        addObject(new Warp("WorldRoute113", 137, 100, 40, 10, 2), 329, -10);
    }
}
