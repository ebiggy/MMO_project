import java.util.Scanner;

/**
 * Write a description of class temp here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class temp
{
    // instance variables - replace the example below with your own
    /** Character Name */
    String charName;
        
    /** Overall Combat Level */
    int combatLvl;
        
    /** Attack Level */
    int attLvl = 1;
    
    int attExp = 0;
        
    /** Strength Level */
    int strLvl = 1;
    
    int strExp = 0;
        
    /** Defense Level */
    int defLvl = 1;
    
    int defExp = 0;
        
    /** Endurance Level - Rate at which run energy decreases */
    int endLvl;
        
    /** Run Energy */
    int runEnergy = 100;
        
    /** Gold/Currency */
    int gold = 100;
    
    /** Selection of Current Attack Style */
    int attackStyle;
    
    int styleAtt = 1, styleStr = 2, styleDef = 3;
      
    /** Location */
    String loc;
        
    String town = "Town", woods = "Woods", wilderness = "Wilderness";
    
    /**
     * Constructor for objects of class temp
     */
    public temp()
    {
        attLvl = 1;
        strLvl = 1;
        defLvl = 1;
        combatLvl = attLvl + strLvl + defLvl;
        loc = town;
        attackStyle = styleAtt;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String checkLocation(){
        return loc;
    }
    
    public void calcCombatLvl(){
        combatLvl = (attLvl + strLvl + defLvl) / 3;
    }
    
    public int checkCombatLvl(){
        return combatLvl;
    }
    
    public int checkAttLvl(){
        return attLvl;
    }
    
    public int checkAttExp(){
        return attExp;
    }
    
    public int checkStrLvl(){
        return strLvl;
    }
    
    public int checkStrExp(){
        return strExp;
    }
    
    public int checkDefLvl(){
        return strLvl;
    }
    
    public int checkDefExp(){
        return defExp;
    }
    
    public void checkLvlUp(){
        if (attExp >= 100){
            levelUpAtt();
            attExp = 0;
        } else if (strExp >= 100){
            levelUpStr();
            strExp = 0;
        } else if (defExp >= 100){
            levelUpDef();
            defExp = 0;
        }
    }
    public void gainExp(int exp){
        if (attackStyle == styleAtt){
            attExp = attExp + exp;
        } else if (attackStyle == styleStr){
            strExp =+ exp;
        } else if (attackStyle == styleDef){
            defExp =+ exp;
        }
    }
    
    public void setName(){
        System.out.println("Enter username: ");
        Scanner sc = new Scanner(System.in);
        charName = sc.nextLine();
        System.out.println("Username: " + charName);
    }
    
    public void display(){
        System.out.println("Name: " + charName);
        System.out.println("Combat Level: " + combatLvl);
        System.out.println("Total Gold: " + gold);
        System.out.println("Current Location: " + loc);
        System.out.println("Current Attack Style: " + attackStyle);
        System.out.println("");
    }
    
    public void levelUpAtt(){
        attLvl++;
        calcCombatLvl();
    }
    
    public void levelUpStr(){
        strLvl++;
        calcCombatLvl();
    }
    
    public void levelUpDef(){
        defLvl++;
        calcCombatLvl();
    }
    
    public void drive(){
        display();
        System.out.println("Town");
        System.out.println("Woods");
        System.out.println("Wilderness");
        Scanner sc = new Scanner(System.in);
        String location = sc.nextLine();
        if (location == "Town"){
            loc = town;
        }
        if (location == "Woods"){
            loc = woods;
        }
        if (location == "Wilderness"){
            loc = wilderness;
        }
    }
    
    public void battle(){
        enemy number1 = new enemy("name", 10, 10);
        String enemyName = number1.genEnemyName();
        number1.setName(enemyName);
        int enemyHealth = 15;
        System.out.println("A " + number1.getName() + " has appeared and has " + number1.getHitpoints() + " hitpoints!");
        while (number1.getHitpoints() > 0){
            int prevHP = number1.getHitpoints();
            number1.hit();
            int damageDealt = prevHP - number1.getHitpoints();
            System.out.println("You hit a " + damageDealt + "!");
            if (number1.getHitpoints() < 0){
                number1.setHitpoints(0);
            }
            System.out.println(number1.getName() + " hitpoints: " + number1.getHitpoints());
        }
        number1.drop();
        System.out.println("You found " + number1.getGoldPieces() + " gold pieces!");
        gold = gold + number1.getGoldPieces();
        System.out.println("Total Gold: " + gold);
        gainExp(number1.getExperience());
        System.out.println("You have gained " + number1.getExperience() + " " + attackStyle + " experience!");
    }
    
    public static void main(String[] args){

    }
}
