import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class FinalGirl

{

    public int health, strength;
    public String name;
    public HashMap backpack = new HashMap();

    public FinalGirl() {
        this.name = name;

    }


    public void setName() {
        System.out.println("Enter a name for your player:");
        Scanner keyboard = new Scanner(System.in);
        name = keyboard.nextLine();
        this.name = name;
        System.out.println("Your player's name is now " + name);

    }

    public HashMap getBackpack() {
        return backpack;
    }

    public String getName() {
        return name;

    }

    public void setHealth(int health) {
        this.health = health;

    }

    public void setStrength(int strength) {
            this.strength = strength;
    }

    public int getHealth() {
        return health;

    }

    public int getStrength() {
            return strength;
        }


    public static void main(String [] args) {
        FinalGirl player = new FinalGirl();
        player.setName();


        Weapon slingshot = new Weapon(), knife = new Weapon();
        knife.setName("knife");
        knife.setWeight(5);
        slingshot.setName("slingshot");
        slingshot.setWeight(10);
        player.backpack.put(slingshot, slingshot.getWeight());
        player.backpack.put(knife, knife.getWeight());
        System.out.println(player.backpack);




        }
}
