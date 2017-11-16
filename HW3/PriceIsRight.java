
import java.io.*;
import java.util.*;
public class PriceIsRight{
   public static void main(String[] args)throws Exception{
       start();
   }
   
    public static void start()throws Exception{
        Scanner kb = new Scanner(System.in);
        description();
        System.out.println("\n\nWait let me choose the players\n\nHere is the list of players:");
        String[] names = new String[20];
        fillArrayNames(names);
        String[] list = new String[4];
        for(int i = 0; i < 4; i++){
            String s = ChoosePlayers(names);
            list[i] = s;
            System.out.print(s + " ");
       }
       System.out.print("\n\nItem:        ");
       String[] items = new String[20];
       fillArrayItems(items);
       String[] itemList = new String[1];
       for(int i = 0; i < 1; i++){
            String s = fillArrayItems(items);
            itemList[i] = s;
            System.out.println(s + " ");
       }
       
       double[] bids = new double[4];
       for(int i = 0; i < 4; i++){
            System.out.print(list[i] + ", enter your bid: ");
            while(!kb.hasNextDouble()){  
                System.out.print("Enter your bid: ");
                kb.next();
            }
            bids[i] = kb.nextDouble();
       }
       
       System.out.print("\n\n\n\n\n\n");
       System.out.println("\t\t\t\t\tName\t\t\tBid\n"
                         +"-------------------------------");
       for(int i = 0; i < 4; i++){
           System.out.println("\t\t\t\t\t" + list[i] + "\t\t\t" + bids[i]);
       }
       System.out.println("The actual price of the item is : ");
   }
   
   public static void fillArrayNames(String[] names)throws Exception{
       File nameList = new File("Names.txt");
       Scanner kb = new Scanner(nameList);
       int index = 0;
       while(kb.hasNextLine()){
           names[index] = kb.nextLine();
           index++;
      }
   }
   
    public static String ChoosePlayers(String[] names){
        Random rand = new Random();
        int index = rand.nextInt(9);
        while(names[index].equals("")){
            index = rand.nextInt(9);
        }
        String name = names[index];
        names[index] = "";
        return name;
    }
       
    public static String fillArrayItems(String[] items)throws Exception{
        File itemsList = new File("Items.txt");
        Scanner kb = new Scanner(itemsList);
        int index = 0;
        while(kb.hasNextLine()){
            items[index] = kb.nextLine();
            index++;
        }
        int idx = new Random().nextInt(items.length);
        String random = (items[idx]);
        return random;
    }
    
    public static void description(){
        System.out.println("You are about the play price is right the game.\n"
                           +"An item will be displayed on the screen\n"
                           +"The players will enter their bids, whoever has the"
                           +"closest bid to the actual price will win.");
    }
}
   
   