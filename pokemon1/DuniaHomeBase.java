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

public class DuniaHomeBase {
    private String name;
    private Monster monsterDigunakan;
    private int totalMonster;

    public DuniaHomeBase(String name, Monster monsterDigunakan, int totalMonster) {
        this.name = name;
        this.monsterDigunakan = monsterDigunakan;
        this.totalMonster = totalMonster;
    }

    public void improveHealth() {
        monsterDigunakan.setCurrentHealthPoint(monsterDigunakan.getCurrentHealthPoint() + 10);
    }

    public void changeLevelElement() {
        Random random = new Random();
        int newLevel = random.nextInt(5) + 1;
        monsterDigunakan.setLevelState(newLevel);

        String[] elements = {"Fire", "Water", "Earth", "Air", "Electric"};
        monsterDigunakan.setElement(elements[newLevel - 1]);
    }

    public void evolusiElement() {
        // Implementation for evolving element
    }

    public void pilihMonster() {
        this.monsterDigunakan = getDunia().getMonsterList().get(new Random().nextInt(getDunia().getMonsterList().size()));
    }

    public String getName() {
        return name;
    }

    public Monster getMonsterDigunakan() {
        return monsterDigunakan;
    }

    public int getTotalMonster() {
        return totalMonster;
    }

    private Dunia getDunia() {
        return Dunia.getInstance();
    }
}
