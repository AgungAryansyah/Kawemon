/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Kawemon.GUI;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 *
 * @author Uer
 */
public class BattleMenu extends javax.swing.JFrame{

    JPopupMenu attackMenu;
    JPopupMenu itemMenu;
    JPopupMenu changeMosnterMenu;
    /**
     * Creates new form MainMenu
     */
    public BattleMenu() {
        initComponents();
        writtenComponents();
    }

    private void writtenComponents(){
        ImageIcon dungeonBackround = new ImageIcon("DungeonBackround.jpeg");
        ImageIcon scaledDungeonBackroun = new ImageIcon(dungeonBackround.getImage().getScaledInstance(backround.getWidth(), backround.getHeight(), Image.SCALE_FAST));
        backround.setIcon(scaledDungeonBackroun);

        ImageIcon playerMonsterImage = new ImageIcon("eeveeBack.gif");
        ImageIcon scaledPlayerMonsterImage = new ImageIcon(playerMonsterImage.getImage().getScaledInstance(playerMonster.getWidth(), playerMonster.getHeight(), Image.SCALE_FAST));
        playerMonster.setIcon(scaledPlayerMonsterImage);

        ImageIcon enemyMonsterImage = new ImageIcon("eeveeFront.gif");
        ImageIcon scaledEnemyMonsterImage = new ImageIcon(enemyMonsterImage.getImage().getScaledInstance(enemyMonster.getWidth(), enemyMonster.getHeight(), Image.SCALE_FAST));
        enemyMonster.setIcon(scaledEnemyMonsterImage);

        attackMenu = new JPopupMenu();
        attackMenu.setBounds(200, 100, 400, 700);
        JMenuItem basicAttack = new JMenuItem(    "Basic Attack                 ");
        JMenuItem specialAttack = new JMenuItem(  "Special Attack               ");
        JMenuItem elementalAttack = new JMenuItem("Elemental Attack             ");
        basicAttack.setBounds(0, 0, 160, 50);
        specialAttack.setBounds(161, 0, 160, 50);
        elementalAttack.setBounds(322, 0, 160, 50);
        attackMenu.add(basicAttack);
        attackMenu.add(specialAttack);
        attackMenu.add(elementalAttack);
        this.add(attackMenu);

        itemMenu = new JPopupMenu();
        itemMenu.setBounds(200, 100, 400, 700);
        JMenuItem monsterBall = new JMenuItem(         "Monster Ball                   ");
        JMenuItem healthPotion = new JMenuItem(        "Health Potion                  ");
        JMenuItem elementalEsPotion = new JMenuItem(   "Potion Es                      ");
        JMenuItem elementalAnginPotion = new JMenuItem("Potion Angin                   ");
        JMenuItem elementalAirPotion = new JMenuItem(  "Potion Air                     ");
        JMenuItem elementalApiPotion = new JMenuItem(  "Potion Api                     ");
        JMenuItem elementalTanahPotion = new JMenuItem("Potion Tanah                   ");
        monsterBall.setBounds(0, 0, 160, 50);
        healthPotion.setBounds(161, 0, 160, 50);
        elementalEsPotion.setBounds(322, 0, 160, 50);
        elementalAnginPotion.setBounds(483, 0, 160, 50);
        elementalAirPotion.setBounds(644, 0, 160, 50);
        elementalApiPotion.setBounds(805, 0, 160, 50);
        elementalTanahPotion.setBounds(966, 0, 160, 50);
        itemMenu.add(monsterBall);
        itemMenu.add(healthPotion);
        itemMenu.add(elementalEsPotion);
        itemMenu.add(elementalAnginPotion);
        itemMenu.add(elementalAirPotion);
        itemMenu.add(elementalApiPotion);
        itemMenu.add(elementalTanahPotion);
        this.add(itemMenu);

        changeMosnterMenu = new JPopupMenu();
        changeMosnterMenu.setBounds(200, 100, 400, 700);
        JMenuItem changeToMonster1 = new JMenuItem("Change to Monster 1       ");
        JMenuItem changeToMonster2 = new JMenuItem("Change to Monster 2       ");
        changeMosnterMenu.add(changeToMonster1);
        changeMosnterMenu.add(changeToMonster2);
        this.add(itemMenu);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        TombolKabur = new javax.swing.JButton();
        TombolgantiMonster = new javax.swing.JButton();
        TombolItem = new javax.swing.JButton();
        TombolSerang = new javax.swing.JButton();
        BattleScreen = new javax.swing.JLayeredPane();
        enemyMonster = new javax.swing.JLabel();
        playerMonster = new javax.swing.JLabel();
        backround = new javax.swing.JLabel();
        infoAndButtons = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(24, 35, 28));
        setMinimumSize(new java.awt.Dimension(730, 500));
        setResizable(false);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setMaximumSize(new java.awt.Dimension(232, 84));
        jTextArea1.setMinimumSize(new java.awt.Dimension(232, 84));
        jScrollPane1.setViewportView(jTextArea1);

        TombolKabur.setText("Kabur");
        TombolKabur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TombolKaburActionPerformed(evt);
            }
        });

        TombolgantiMonster.setText("GantiMonster");
        TombolgantiMonster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TombolgantiMonsterActionPerformed(evt);
            }
        });

        TombolItem.setText("Item");
        TombolItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TombolItemActionPerformed(evt);
            }
        });

        TombolSerang.setText("Serang");
        TombolSerang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TombolSerangActionPerformed(evt);
            }
        });

        BattleScreen.add(enemyMonster);
        enemyMonster.setBounds(440, 20, 120, 120);
        BattleScreen.add(playerMonster);
        playerMonster.setBounds(20, 210, 120, 120);
        BattleScreen.add(backround);
        backround.setBounds(0, 0, 611, 376);

        javax.swing.GroupLayout infoAndButtonsLayout = new javax.swing.GroupLayout(infoAndButtons);
        infoAndButtons.setLayout(infoAndButtonsLayout);
        infoAndButtonsLayout.setHorizontalGroup(
            infoAndButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );
        infoAndButtonsLayout.setVerticalGroup(
            infoAndButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 264, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
                    .addComponent(BattleScreen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TombolItem, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(TombolSerang, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(TombolgantiMonster, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(TombolKabur, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(infoAndButtons))
                .addGap(7, 7, 7))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(infoAndButtons)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TombolSerang, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TombolItem, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BattleScreen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TombolgantiMonster, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TombolKabur, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TombolKaburActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TombolKaburActionPerformed
        // TODO add your handling code here:
        Random rand = new Random();
        int chance = rand.nextInt(99);
        if (chance > 10){
            HomeBase homeBase = new HomeBase();
            homeBase.setVisible(true);
            dispose();
        } else {
            //tidak dapat kabur
        }
    }//GEN-LAST:event_TombolKaburActionPerformed

    private void TombolItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TombolItemActionPerformed
        // TODO add your handling code here:
        itemMenu.show(this, infoAndButtons.getX() + 10, infoAndButtons.getY() + 30);
    }//GEN-LAST:event_TombolItemActionPerformed

    private void TombolgantiMonsterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TombolgantiMonsterActionPerformed
        // TODO add your handling code here:
        changeMosnterMenu.show(this, infoAndButtons.getX() + 10, infoAndButtons.getY() + 30);
    }//GEN-LAST:event_TombolgantiMonsterActionPerformed

    private void TombolSerangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TombolSerangActionPerformed
        // TODO add your handling code here:
        attackMenu.show(this, infoAndButtons.getX() + 10, infoAndButtons.getY() + 30);
    }//GEN-LAST:event_TombolSerangActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BattleMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BattleMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BattleMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BattleMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BattleMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane BattleScreen;
    private javax.swing.JButton TombolItem;
    private javax.swing.JButton TombolKabur;
    private javax.swing.JButton TombolSerang;
    private javax.swing.JButton TombolgantiMonster;
    private javax.swing.JLabel backround;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel enemyMonster;
    private javax.swing.JLayeredPane infoAndButtons;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel playerMonster;
    // End of variables declaration//GEN-END:variables
}