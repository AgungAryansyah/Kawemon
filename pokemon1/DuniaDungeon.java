/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemon1;

/**
 *
 * @author Aurelia
 */
import java.util.Random;

public class DuniaDungeon {
    private String name;
    private Monster monsterLawan;
    private Monster monsterDigunakan;

    public DuniaDungeon(String name, Monster monsterLawan, Monster monsterDigunakan) {
        this.name = name;
        this.monsterLawan = monsterLawan;
        this.monsterDigunakan = monsterDigunakan;
    }

    public void tarung() {
        System.out.println("A wild " + monsterLawan.getNama() + " appeared!");
        System.out.println("Your " + monsterDigunakan.getNama() + " is ready for battle!");

        while (monsterLawan.getCurrentHealthPoint() > 0 && monsterDigunakan.getCurrentHealthPoint() > 0) {
            int attack = new Random().nextInt(monsterDigunakan.getBaseAttack()) + 1;
            monsterLawan.setCurrentHealthPoint(monsterLawan.getCurrentHealthPoint() - attack);

            if (monsterLawan.getCurrentHealthPoint() <= 0) {
                System.out.println("Your " + monsterDigunakan.getNama() + " defeated the " + monsterLawan.getNama() + "!");
                break;
            }

            attack = new Random().nextInt(monsterLawan.getBaseAttack()) + 1;
            monsterDigunakan.setCurrentHealthPoint(monsterDigunakan.getCurrentHealthPoint() - attack);

            if (monsterDigunakan.getCurrentHealthPoint() <= 0) {
                System.out.println("Your " + monsterDigunakan.getNama() + " was defeated by the " + monsterLawan.getNama() + "!");
                break;
            }
        }
    }

    public String getName() {
        return name;
    }

    public Monster getMonsterLawan() {
        return monsterLawan;
    }

    public Monster getMonsterDigunakan() {
        return monsterDigunakan;
    }
}