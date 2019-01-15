import java.util.Random;
import java.util.ArrayList;
/**
 * Write a description of class enemy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class enemy
{
    // instance variables - replace the example below with your own
    String name;
    static int hitpoints;
    static int maxhit = 5;
    static int goldPieces;
    static int experience;
    

    /**
     * Constructor for objects of class enemy
     */
    public enemy(String name, int hitpoints, int experience)
    {
        this.name = name;
        this.hitpoints = hitpoints;
        this.experience = experience;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getName(){
        return name;
    }
    
    public void setName(String name1){
        name = name1;
    }
    
    public static int getExperience(){
        return experience;
    }
    
    /** Hitpoints */
    public static int getHitpoints(){
        return hitpoints;
    }
    
    public static void setHitpoints(int hp){
        hitpoints = hp;
    }
    
    /** Gold Pieces */
    public static int getGoldPieces(){
        return goldPieces;
    }
    
    public static void setGoldPieces(int gp){
        goldPieces = gp;
    }
    
    public void drop(){
        Random rand = new Random();
        int num = rand.nextInt(4);
        if (num == 0){
            goldPieces = 0;
        } else {
            goldPieces = (goldPieces + num) + (getHitpoints() / 2);
        }
    }
    
    public void hit(){
        Random rand = new Random();
        int damage = rand.nextInt(maxhit);
        hitpoints = hitpoints - damage;
    }
    
    public static String genEnemyName(){
        String enemy = "";
        ArrayList<String> townEnemy = new ArrayList<String>();
        townEnemy.add(0, "Deer");
        townEnemy.add(1, "Bear");
        townEnemy.add(2, "Guard");
        Random rand = new Random();
        int num = rand.nextInt(3);
        enemy = townEnemy.get(num);
        return enemy;
    }
    
    public static int random(int ceiling){
        int num = 0;
        Random rand = new Random();
        num = rand.nextInt(ceiling);
        return num;
    }
    
}
