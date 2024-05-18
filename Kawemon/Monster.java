package Kawemon;

import java.util.Random;

abstract class Monster {
    final String name;
    private int baseAttack;
    private int levelState;
    private int currentHealthPoint;
    private int maxHealthPoint;
    private Element element;

    public Monster(String name, int levelState, int currentHealthPoint, int maxHealthPoint, Element element) {
        this.name = name;
        this.levelState = levelState;
        this.currentHealthPoint = currentHealthPoint;
        this.maxHealthPoint = maxHealthPoint;
        this.element = element;
    }

    public void basicAttack(Monster enemyMonster){
        enemyMonster.setCurrentHealthPoint(enemyMonster.getCurrentHealthPoint() - getBaseAttack());
        System.out.println(name + "Melakukan basic attack");
    }

    public void specialAttack(Monster enemyMonster){
        Random rng = new Random();
        int num = rng.nextInt(100);
        if (num < 10){
            System.out.println("Serangan Meleset");
        } else {
            enemyMonster.setCurrentHealthPoint((int) (enemyMonster.getCurrentHealthPoint() - (getBaseAttack() * 1.3f)));
            setCurrentHealthPoint((int) (getCurrentHealthPoint() - (0.3f * getCurrentHealthPoint())));
            System.out.println(name + " Melakukan special attack, dan terkena damage karena seranganynya sendiri");
        }
    }

    public void elementalAttack(Monster enemyMonster){
        int efektifitas = element.cekEfektifitasSerangan(enemyMonster.getElement());
        if (efektifitas == 1){
            enemyMonster.setCurrentHealthPoint((int) (enemyMonster.getCurrentHealthPoint() - (getBaseAttack() * 1.3f)));
            System.out.println(name + "Melakukan elemental attack, serangannya sangat efektif!");
        } else if (efektifitas == 0) {
            enemyMonster.setCurrentHealthPoint(enemyMonster.getCurrentHealthPoint() - getBaseAttack());
            System.out.println(name + "Melakukan elemental attack");
        } else if (efektifitas == -1){
            enemyMonster.setCurrentHealthPoint((int) (enemyMonster.getCurrentHealthPoint() - (getBaseAttack() * 0.5f)));
            System.out.println(name + "Melakukan elemental attack, serangannya tidak efektif!");
        }
    }
    
    public String getNama() {
        return name;
    }

    public int getBaseAttack() {
        return baseAttack;
    }

    public int getLevelState() {
        return levelState;
    }

    public int getCurrentHealthPoint() {
        return currentHealthPoint;
    }

    public int getMaxHealthPoint() {
        return maxHealthPoint;
    }

    public Element getElement() {
        return element;
    }

    public void setBaseAttack(int baseAttack) {
        this.baseAttack = baseAttack;
    }

    public void setLevelState(int levelState) {
        this.levelState = levelState;
    }

    public void setCurrentHealthPoint(int currentHealthPoint) {
        if (currentHealthPoint <= 0){
            this.currentHealthPoint = 0;
            System.out.println("Monster pingsan");
        } else {
            this.currentHealthPoint = currentHealthPoint;
        }

    }

    public void setMaxHealthPoint(int maxHealthPoint) {
        this.maxHealthPoint = maxHealthPoint;
    }

    public void setElement(Element element) {
        this.element = element;
    }
}

class MonsterJinak extends Monster{
    int currentExperiencePoint;
    int maxExperiencePoint;
    boolean bisaEvolusi;

    public MonsterJinak(String name, int levelState, int currentHealthPoint, int maxHealthPoint, Element element) {
        super(name, levelState, currentHealthPoint, maxHealthPoint, element);
        this.currentExperiencePoint = 0;
        maxExperiencePoint = (100 + (levelState * 5));
        bisaEvolusi = false;
    }



    public void setCurrentExperiencePoint(int currentExperiencePoint) {
        if (currentExperiencePoint >= maxExperiencePoint){
            setLevelState(getLevelState() + 1);
            bisaEvolusi = true;
        } else {
            this.currentExperiencePoint = currentExperiencePoint;
        }
    }
}

class MonsterLiar extends Monster{

    public MonsterLiar(String name, int levelState, int currentHealthPoint, int maxHealthPoint, Element element) {
        super(name, levelState, currentHealthPoint, maxHealthPoint, element);
    }
}