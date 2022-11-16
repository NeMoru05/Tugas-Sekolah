import greenfoot.*;
public class DataInventory extends Datas
{
    static int numberOfItems;
    static String[] items = new String[4];
    static String[] names = new String[4];
    static int[] itemsNumber = new int[4];
    
    static boolean isPresent;
    
    /**
    * Adds an item to the player in the items array
    * Increase the itemsNumber count for the item
    * Increments the numberOfItems if the player doesn't already have this item
    * Renames some items in the names array
    */
    public static void addItem(String name, int number)
    {
        //if the player already has at least one item
        if(numberOfItems > 0)
        {
            //check all the items the player has
            for(int i = 0; i < numberOfItems; i++)
            {
                isPresent = false;
                //if the player already has this item, increase the item count by the number
                if(items[i].equals(name))
                {
                    itemsNumber[i] += number;
                    isPresent = true;
                    break;
                }
            }
            //if the player doesn't have this item, add it to the list and set the item count by the number and increment the numberOfItems variable
            if(!isPresent)
            {
                items[numberOfItems] = name;
                itemsNumber[numberOfItems] = number;
                numberOfItems++;
            }
        }
        //if the player doesn't have any item, add it to the list as number 0 and set the item count by the number
        else
        {
            items[numberOfItems] = name;
            itemsNumber[numberOfItems] = number;
            numberOfItems++;
        }
        
        //renames all items of the player
        renameItems();
    }
    
    /**
    * Removes an item to the player in the items array if the player has only one instance of this item
    * Decreases the itemsNumber count for the item
    * Decreases the numberOfItems if the player has only one instance of this item
    * Renames some items in the names array
    */
    public static void removeItem(String name, int number)
    {
        //check all the items the player has
        for(int i = 0; i < numberOfItems; i++)
        {
            isPresent = true;
            //if the player already has this item, decrease the item count by the number
            if(items[i].equals(name))
            {
                itemsNumber[i] -= number;
                if(itemsNumber[i] == 0)
                    isPresent = false;
            }
            //if the player doesn't have this item anymore, remove it from the items and names array
            if(!isPresent)
            {
                numberOfItems--;
                items[i] = null;
                names[i] = null;
                //make all items that are after this one in the array go once place back
                for(int j = i; j < (3 - i); j++)
                {
                    itemsNumber[j] = itemsNumber[j + 1];
                    items[j] = items[j + 1];
                    items[j + 1] = null;
                    names[j + 1] = null;
                    itemsNumber[j + 1] = 0;
                }
            }
        }
        
        //renames all items of the player
        renameItems();
    }
    
    /**
    * Renames all items in the names array so they are readable an can be used in texts
    */
    public static void renameItems()
    {
        //check all the items the player has
        for(int i = 0; i < items.length; i++)
        {
            //if he has none, break the method
            if(items[i] == null)
                break;
            //change the name of the items in the names array so they are readable and can be used in texts
            switch(items[i])
            {
                case "SuperPotion" : names[i] = "Super Potion";
                    break;
                default : names[i] = items[i];
                    break;
            }
        }
    }
}
