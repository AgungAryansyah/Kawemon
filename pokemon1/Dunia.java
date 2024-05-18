/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemon1;

/**
 *
 * @author Aurelia
 */
import java.util.ArrayList;
import java.util.List;

public class Dunia {
    private static Dunia instance;
    private DuniaHomeBase duniaHomeBase;
    private DuniaDungeon duniaDungeon;
    private DuniaArena duniaArena;
    private List<Monster> monsterList;
    private List<Item> itemList;

    public Dunia(DuniaHomeBase duniaHomeBase, DuniaDungeon duniaDungeon, DuniaArena duniaArena) {
        this.duniaHomeBase = duniaHomeBase;
        this.duniaDungeon = duniaDungeon;
        this.duniaArena = duniaArena;
        this.monsterList = new ArrayList<>();
        this.itemList = new ArrayList<>();
        instance = this;
    }

    public static Dunia getInstance() {
        return instance;
    }

    public void addMonster(Monster monster) {
        monsterList.add(monster);
    }

    public void addItem(Item item) {
        itemList.add(item);
    }

    public void toDunia() {
        System.out.println("Welcome to " + duniaDungeon.getName());
        System.out.println("Available monsters:");
        for (Monster monster : monsterList) {
            System.out.println("- " + monster.getNama());
        }
        System.out.println("Available items:");
        for (Item item : itemList) {
            System.out.println("- " + item.getNama());
        }
    }

    public DuniaHomeBase getDuniaHomeBase() {
        return duniaHomeBase;
    }

    public DuniaDungeon getDuniaDungeon() {
        return duniaDungeon;
    }

    public DuniaArena getDuniaArena() {
        return duniaArena;
    }

    public List<Monster> getMonsterList() {
        return monsterList;
    }

    public List<Item> getItemList() {
        return itemList;
    }
}
