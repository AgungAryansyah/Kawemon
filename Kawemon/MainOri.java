import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainOri {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SplashScreen(() -> SwingUtilities.invokeLater(MainMenu::new));
        });
    }
}

class SplashScreen extends JWindow {
    public SplashScreen(Runnable onClose) {
        getContentPane().setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel mainLabel = new JLabel("<html><div style='text-align: center;'>Welcome to Pokemon Game<br>AJA Version<br><br></div></html>", SwingConstants.CENTER);
        mainLabel.setFont(new Font("Sans Fira", Font.BOLD, 40));
        getContentPane().add(mainLabel, gbc);

        JLabel secondaryLabel = new JLabel("<html><div style='text-align: center;'>Developed by Agung, Julia, Aurel <br><br>loading...</div></html>", SwingConstants.CENTER);
        secondaryLabel.setFont(new Font("Consolas", Font.BOLD, 20));
        getContentPane().add(secondaryLabel, gbc);

        Dimension screenSize = new Dimension(1920, 1080);
        setSize(screenSize);
        setLocationRelativeTo(null);

        Timer timer = new Timer(3000, (ActionEvent e) -> {
            dispose();
            onClose.run();
        });
        timer.setRepeats(false);
        timer.start();

        setVisible(true);
    }
}

class MainMenu extends JFrame {
    public MainMenu() {
        setTitle("Monster Battle Game - Main Menu");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));

        JButton homebaseButton = new JButton("Homebase");
        homebaseButton.addActionListener(e -> new Homebase());
        add(homebaseButton);

        JButton newGameButton = new JButton("New Game");
        newGameButton.addActionListener(e -> new Game());
        add(newGameButton);

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> System.exit(0));
        add(exitButton);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}

class Homebase extends JFrame {
    private MonsterRepository repository;
    private List<Monster> chosenMonsters;
    private List<Item> items;
    private JTextArea homebaseLog;
    private JComboBox<Monster> monsterComboBox;
    private int coins;

    public Homebase() {
        repository = new MonsterRepository();
        chosenMonsters = new ArrayList<>();
        items = new ArrayList<>();
        items.add(new MonsterBall());
        items.add(new HealthPotion());
        items.add(new ElementalPotion(new ElementFire(), 50));
        coins = 100;

        setTitle("Pokemon AJA Version");
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        homebaseLog = new JTextArea();
        homebaseLog.setEditable(false);
        add(new JScrollPane(homebaseLog), BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        monsterComboBox = new JComboBox<>();
        for (Monster monster : repository.getMonsters()) {
            monsterComboBox.addItem(monster);
        }
        controlPanel.add(monsterComboBox);

        JButton healMonsterButton = new JButton("Heal Monster");
        healMonsterButton.addActionListener(e -> healMonster());
        controlPanel.add(healMonsterButton);

        JButton evolveMonsterButton = new JButton("Evolve Monster");
        evolveMonsterButton.addActionListener(e -> evolveMonster());
        controlPanel.add(evolveMonsterButton);

        JButton buyAttributesButton = new JButton("Buy Attributes");
        buyAttributesButton.addActionListener(e -> buyAttributes());
        controlPanel.add(buyAttributesButton);

        add(controlPanel, BorderLayout.NORTH);

        setVisible(true);
    }

    private void healMonster() {
        Monster selectedMonster = (Monster) monsterComboBox.getSelectedItem();
        if (selectedMonster != null) {
            selectedMonster.heal();
            homebaseLog.append("Healed Monster: " + selectedMonster.getName() + "\n");
        }
    }

    private void evolveMonster() {
        Monster selectedMonster = (Monster) monsterComboBox.getSelectedItem();
        if (selectedMonster != null) {
            Object[] elements = {new ElementFire(), new ElementWind(), new ElementWater(), new ElementIce(), new ElementEarth()};
            Element newElement = (Element) JOptionPane.showInputDialog(
                this,
                "Choose new element for evolution",
                "Evolve Monster",
                JOptionPane.QUESTION_MESSAGE,
                null,
                elements,
                elements[0]
            );
            if (newElement != null) {
                selectedMonster.setElement(newElement);
                homebaseLog.append(selectedMonster.getName() + " evolved into " + newElement.name + " element!\n");
            }
        }
    }

    private void buyAttributes() {
        if (coins >= 50) {
            Monster selectedMonster = (Monster) monsterComboBox.getSelectedItem();
            if (selectedMonster != null) {
                selectedMonster.gainXp(50);
                coins -= 50;
                homebaseLog.append("Bought attributes for " + selectedMonster.getName() + ". Remaining coins: " + coins + "\n");
            }
        } else {
            homebaseLog.append("Not enough coins to buy attributes. Current coins: " + coins + "\n");
        }
    }
}

class Game extends JFrame {
    private MonsterRepository repository;
    private List<Monster> chosenMonsters;
    private List<Item> items;
    private JTextArea gameLog;
    private JComboBox<Monster> monsterComboBox;
    private JButton battleButton;
    private JButton viewLogButton;
    private int coins;
    private BufferedWriter logWriter;

    public Game() {
        repository = new MonsterRepository();
        chosenMonsters = new ArrayList<>();
        items = new ArrayList<>();
        items.add(new MonsterBall());
        items.add(new HealthPotion());
        items.add(new ElementalPotion(new ElementFire(), 50));
        coins = 100;

        try {
            logWriter = new BufferedWriter(new FileWriter("battle_log.txt", true));
        } catch (IOException e) {
            e.printStackTrace();
        }

        setTitle("Monster Battle Game");
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        gameLog = new JTextArea();
        gameLog.setEditable(false);
        add(new JScrollPane(gameLog), BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        monsterComboBox = new JComboBox<>();
        for (Monster monster : repository.getMonsters()) {
            monsterComboBox.addItem(monster);
        }
        controlPanel.add(monsterComboBox);

        JButton chooseMonsterButton = new JButton("Choose Monster");
        chooseMonsterButton.addActionListener(e -> chooseMonster());
        controlPanel.add(chooseMonsterButton);

        battleButton = new JButton("Start Battle");
        battleButton.addActionListener(e -> startBattle());
        battleButton.setEnabled(false);
        controlPanel.add(battleButton);

        // Add button to view log
        viewLogButton = new JButton("View Battle Log");
        viewLogButton.addActionListener(e -> viewLog());
        controlPanel.add(viewLogButton);

        add(controlPanel, BorderLayout.NORTH);

        setVisible(true);
    }

    private void chooseMonster() {
        Monster selectedMonster = (Monster) monsterComboBox.getSelectedItem();
        if (selectedMonster != null && chosenMonsters.size() < 3 && !chosenMonsters.contains(selectedMonster)) {
            chosenMonsters.add(selectedMonster);
            log("You choose " + selectedMonster.getName());
            if (chosenMonsters.size() == 3) {
                battleButton.setEnabled(true);
            }
        } else if (chosenMonsters.contains(selectedMonster)) {
            log("Monster already chosen: " + selectedMonster.getName());
        }
    }

    private void startBattle() {
        if (chosenMonsters.size() == 3) {
            Monster wildMonster = generateWildMonster();
            log("A wild " + wildMonster.getName() + " appeared!");

            Monster playerMonster = chooseMonsterForBattle();

            if (playerMonster != null) {
                log("You chose " + playerMonster.getName() + " to battle!");
                log("Battle Start!");
                battle(playerMonster, wildMonster);
                log("Battle End!");
            } else {
                log("Battle was cancelled.");
            }
        }
    }

    private Monster chooseMonsterForBattle() {
        Monster selectedMonster = (Monster) JOptionPane.showInputDialog(
            this,
            "Choose a monster to fight the wild monster",
            "Choose Monster",
            JOptionPane.QUESTION_MESSAGE,
            null,
            chosenMonsters.toArray(),
            chosenMonsters.get(0)
        );
        return selectedMonster;
    }

    private Monster generateWildMonster() {
        List<Monster> wildMonsters = repository.getMonsters();
        Random random = new Random();
        return wildMonsters.get(random.nextInt(wildMonsters.size()));
    }

    private void battle(Monster playerMonster, Monster wildMonster) {
        Object[] options = {"Basic Attack", "Elemental Attack", "Special Attack", "Use Item", "Run"};
        while (!playerMonster.isFainted() && !wildMonster.isFainted()) {
            int action = JOptionPane.showOptionDialog(this, "Choose your action:", "Battle",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            switch (action) {
                case 0 -> {
                    playerMonster.basicAttack(wildMonster);
                    log(playerMonster.getName() + " used Basic Attack on " + wildMonster.getName());
                }
                case 1 -> {
                    playerMonster.elementalAttack(wildMonster);
                    log(playerMonster.getName() + " used Elemental Attack on " + wildMonster.getName());
                }
                case 2 -> {
                    playerMonster.specialAttack(wildMonster);
                    log(playerMonster.getName() + " used Special Attack on " + wildMonster.getName());
                }
                case 3 -> useItem(playerMonster, wildMonster);
                case 4 -> {
                    log(playerMonster.getName() + " ran away from " + wildMonster.getName());
                    return;
                }
            }

            if (wildMonster.isFainted()) {
                log(wildMonster.getName() + " fainted! You won!");
                break;
            } else {
                wildMonster.basicAttack(playerMonster);
                log(wildMonster.getName() + " attacked " + playerMonster.getName());
            }

            if (playerMonster.isFainted()) {
                log(playerMonster.getName() + " fainted! You lost!");
                break;
            }
        }
    }

    private void useItem(Monster playerMonster, Monster wildMonster) {
        Object[] itemsArray = items.toArray();
        Item selectedItem = (Item) JOptionPane.showInputDialog(
            this,
            "Choose an item to use",
            "Use Item",
            JOptionPane.QUESTION_MESSAGE,
            null,
            itemsArray,
            itemsArray[0]
        );
        if (selectedItem != null) {
            selectedItem.use(playerMonster, wildMonster);
            log("Used " + selectedItem.getName());
            items.remove(selectedItem);
        }
    }

    private void log(String message) {
        gameLog.append(message + "\n");
        try {
            logWriter.write(message + "\n");
            logWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void viewLog() {
        try {
            JTextArea logArea = new JTextArea();
            logArea.setEditable(false);
            BufferedReader logReader = new BufferedReader(new FileReader("battle_history.txt"));
            String line;
            while ((line = logReader.readLine()) != null) {
                logArea.append(line + "\n");
            }
            logReader.close();

            JScrollPane scrollPane = new JScrollPane(logArea);
            scrollPane.setPreferredSize(new Dimension(800, 600));

            JOptionPane.showMessageDialog(this, scrollPane, "Battle History", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        try {
            logWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class MonsterRepository {
    private List<Monster> monsters;

    public MonsterRepository() {
        monsters = new ArrayList<>();
        monsters.add(new Monster("Mercury", new ElementFire(), 100, 100));
        monsters.add(new Monster("Venus", new ElementEarth(), 120, 80));
        monsters.add(new Monster("Earth", new ElementWater(), 90, 110));
        monsters.add(new Monster("Mars", new ElementFire(), 100, 100));
        monsters.add(new Monster("Jupiter", new ElementEarth(), 120, 80));
        monsters.add(new Monster("Saturn", new ElementWater(), 20, 110));
        monsters.add(new Monster("Uranus", new ElementFire(), 100, 200));
        monsters.add(new Monster("Neptune", new ElementEarth(), 50, 80));
        monsters.add(new Monster("Pluto", new ElementWater(), 90, 110));
        monsters.add(new Monster("Andromeda", new ElementFire(), 100, 150));
        monsters.add(new Monster("Oregon", new ElementEarth(), 120, 80));
        monsters.add(new Monster("Acturus", new ElementWater(), 120, 110));
        monsters.add(new Monster("Regulus", new ElementFire(), 100, 120));
        monsters.add(new Monster("Nebula", new ElementEarth(), 120, 80));
        monsters.add(new Monster("Aldebaran", new ElementWater(), 190, 140));
    }

    public List<Monster> getMonsters() {
        return monsters;
    }
}

class Monster {
    private String name;
    private Element element;
    private int health;
    private int maxHealth;
    private boolean fainted;

    public Monster(String name, Element element, int health, int maxHealth) {
        this.name = name;
        this.element = element;
        this.health = health;
        this.maxHealth = maxHealth;
        this.fainted = false;
    }

    public String getName() {
        return name;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public void basicAttack(Monster target) {
        target.takeDamage(10);
    }

    public void elementalAttack(Monster target) {
        target.takeDamage(20);
    }

    public void specialAttack(Monster target) {
        target.takeDamage(30);
    }

    public void heal() {
        this.health = this.maxHealth;
        this.fainted = false;
    }

    public void gainXp(int xp) {
        // Implement experience gain logic
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health <= 0) {
            this.health = 0;
            this.fainted = true;
        }
    }

    public boolean isFainted() {
        return fainted;
    }

    @Override
    public String toString() {
        return name;
    }
}

abstract class Element {
    protected String name;
}

class ElementFire extends Element {
    public ElementFire() {
        this.name = "Fire";
    }
}

class ElementWater extends Element {
    public ElementWater() {
        this.name = "Water";
    }
}

class ElementEarth extends Element {
    public ElementEarth() {
        this.name = "Earth";
    }
}

class ElementWind extends Element {
    public ElementWind() {
        this.name = "Wind";
    }
}

class ElementIce extends Element {
    public ElementIce() {
        this.name = "Ice";
    }
}

abstract class Item {
    protected String name;

    public String getName() {
        return name;
    }

    public abstract void use(Monster playerMonster, Monster wildMonster);
}

class MonsterBall extends Item {
    public MonsterBall() {
        this.name = "Monster Ball";
    }

    @Override
    public void use(Monster playerMonster, Monster wildMonster) {
        // Implement the logic to catch a wild monster
    }
}

class HealthPotion extends Item {
    public HealthPotion() {
        this.name = "Health Potion";
    }

    @Override
    public void use(Monster playerMonster, Monster wildMonster) {
        playerMonster.heal();
    }
}

class ElementalPotion extends Item {
    private Element element;
    private int effectStrength;

    public ElementalPotion(Element element, int effectStrength) {
        this.element = element;
        this.effectStrength = effectStrength;
        this.name = element.name + " Potion";
    }

    @Override
    public void use(Monster playerMonster, Monster wildMonster) {
        // Implement the logic to apply elemental effect
    }
}
