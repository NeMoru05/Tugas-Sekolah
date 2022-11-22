import greenfoot.*;
    public class ObjectSimple extends Objects
    {
        public ObjectSimple(String name)
        {
            setImage("Objects/Simple/" + name + ".png");
            switch(name)
            {
                case "CenterLeft" :
                case "CenterRight" :
                case "HouseRedLeft" :
                case "HouseRedRight" :
                    center = 72;
                    break;
                case "Tree" :
                    center = 52;
                    break;
                case "TreeBottom" :
                case "TableHouse" :
                    center = 28;
                    break;
                case "Bookshelf" : 
                case "PotPlant" : 
                    center = 25;
                    break;
                case "TableCenter" : 
                    center = 23;
                    break;
                case "SinkHouse" :
                case "WallBackCenter" :
                case "WallBackHouseRed" :
                case "CaveEntranceRight" :
                case "RockBig" :
                    center = 20;
                    break;
                case "CaveEntranceLeft" :
                case "CaveBigWallDown" :
                case "Rock" :
                case "CaveExitBlocked" :
                    center = 15;
                    break;
                case "CaveWallCornerLeft" :
                case "CaveWallCornerRight" :
                    center = 13;
                    break;
                case "WallBackLeftCenter" :
                case "WallBackRightCenter" :
                case "BarrierEndVertical" :
                    center = 10;
                    break;
                case "BarrierStartHorizontal" :
                case "BarrierEndHorizontal" :
                case "CaveWallDown" :
                    center = 5;
                    break;
        }
    }
    
    public void act()
    {
        checkPlayer();
    }
}
