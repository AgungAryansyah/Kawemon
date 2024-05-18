package Kawemon;

abstract class Item {
    String nama;

    public Item(String name) {
        this.nama = name;
    }

    public String getNama() {
        return nama;
    }
}

class HealthPotion extends Item{
    final double totalHealthGain;

    public HealthPotion(String name, int totalHealthGain) {
        super("Health Potion");
        this.totalHealthGain = 0.5;
    }

    void useItem(Monster currentMonster) {
        currentMonster.setCurrentHealthPoint((int) (currentMonster.getMaxHealthPoint() * totalHealthGain));
        //tambah health point dari monster
    }
}

class MonsterBall extends Item{
    public MonsterBall() {
        super("Monster Ball");
    }

    void useItem() {
        //manangkap monster liar
    }
}

class elementalPotion extends Item{
    final Element element;
    final int damage;

    public elementalPotion(String name, Element element, int damage) {
        super(name);
        this.element = element;
        this.damage = damage;
    }

    void useItem(Monster enemyMonster) {
        int efektifitas = element.cekEfektifitasSerangan(enemyMonster.getElement());
        if (efektifitas == 1){
            enemyMonster.setCurrentHealthPoint((int) (enemyMonster.getCurrentHealthPoint() - (damage * 1.2f)));
            System.out.println(nama + "Melakukan elemental attack, serangannya sangat efektif!");
        } else if (efektifitas == 0) {
            enemyMonster.setCurrentHealthPoint(enemyMonster.getCurrentHealthPoint() - damage);
            System.out.println(nama + "Melakukan elemental attack");
        } else if (efektifitas == -1){
            enemyMonster.setCurrentHealthPoint((int) (enemyMonster.getCurrentHealthPoint() - (damage * 0.3f)));
            System.out.println(nama + "Melakukan elemental attack, serangannya tidak efektif!");
        }
        //memberikan damage kepada monster lawan
    }
}
