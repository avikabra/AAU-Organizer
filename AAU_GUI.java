/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package aau_freeflow;
import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;
/**
 *
 * @author home
 */
public class AAU_GUI extends javax.swing.JFrame {

    private BSTobject<Team> bst;
    private BSTobject<Team> bst_alpha;
    private boolean bst_displayed = false;
    private String[] gameWinners;
    private String[] gameLosers;
    /**
     * Creates new form AAU_GUI
     */
    public AAU_GUI() {
        initComponents();
        
        // load the data from the txt file
        Scanner sc = null;
        bst = new BSTobject<Team>();
        bst_alpha = new BSTobject<Team>();
        try{
            sc = new Scanner (new FileReader("/Users/home/NetBeansProjects/AAU_FreeFlow/src/aau_freeflow/teams.txt"));

            while (sc.hasNextLine()){
                String data = sc.nextLine();
                System.out.println(data);
                String[] team_data = data.split(",");
               
                String name = team_data[0].trim();
                String win_loss = team_data[1].trim();
                String[] win_and_loss = win_loss.split("-");
                
                int wins = Integer.parseInt(win_and_loss[0]);
                int games_played = wins + Integer.parseInt(win_and_loss[1]);
               
                Team newTeam = new Team(name);
                newTeam.setWins(wins);
                newTeam.setGamesPlayed(games_played);
                bst.addBalanced(newTeam);
                
                Team newAlpha = new Team(name, true);
                newAlpha.setWins(wins);
                newAlpha.setGamesPlayed(games_played);
                bst_alpha.addBalanced(newAlpha);
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Error reading a file");
            e.printStackTrace();
        } 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textField = new javax.swing.JTextArea();
        addTeam = new javax.swing.JButton();
        displayBST = new javax.swing.JButton();
        displayList = new javax.swing.JButton();
        simulateWeek = new javax.swing.JButton();
        removeTeam = new javax.swing.JButton();
        editTeam = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Bebas Neue", 0, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("AAU TEAM SIMULATION");

        textField.setColumns(20);
        textField.setRows(5);
        jScrollPane1.setViewportView(textField);

        addTeam.setText("Add Team");
        addTeam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTeamActionPerformed(evt);
            }
        });

        displayBST.setText("Display BST");
        displayBST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayBSTActionPerformed(evt);
            }
        });

        displayList.setText("Display List Ranking");
        displayList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayListActionPerformed(evt);
            }
        });

        simulateWeek.setText("Simulate Week");
        simulateWeek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simulateWeekActionPerformed(evt);
            }
        });

        removeTeam.setText("Remove Team");
        removeTeam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeTeamActionPerformed(evt);
            }
        });

        editTeam.setText("Edit Team");
        editTeam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editTeamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(addTeam)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(displayBST)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(displayList)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(simulateWeek)
                            .addGap(12, 12, 12)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(removeTeam)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editTeam)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(displayBST)
                        .addComponent(displayList)
                        .addComponent(simulateWeek))
                    .addComponent(addTeam))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeTeam)
                    .addComponent(editTeam))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void displayBSTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayBSTActionPerformed
        // TODO add your handling code here:
        textField.setText(bst.display());
        bst_displayed = true;
    }//GEN-LAST:event_displayBSTActionPerformed

    private void displayListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayListActionPerformed
        // TODO add your handling code here:
        // right to left traversal, recursively call method below
        textField.setText("");
        
        List<Team> list = bst.toList();
        int i = 1;
        for (Team t : list) {
            textField.append(i + " - " + t + ", Win-Loss: " + t.getWins() + "-" + (t.getGamesPlayed()-t.getWins()) + "\n");
            i++;
        }
        bst_displayed = false;
    }//GEN-LAST:event_displayListActionPerformed

    private void addTeamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTeamActionPerformed
        // TODO add your handling code here:
        String name = JOptionPane.showInputDialog(null, "What is the team name?", null);
        //System.out.println(bst.contains(new Team(name)));
        while (bst_alpha.contains(new Team(name, true))) {
            name = JOptionPane.showInputDialog(null, "What is the team name? The team must not already be in the league.", null);
        }
        if (name == null) return;
        //System.out.println(bst.size());
        bst.addBalanced(new Team(name));
        bst_alpha.addBalanced(new Team(name));
        //System.out.println(bst.size());
        if (bst_displayed) displayBSTActionPerformed(evt);
        else displayListActionPerformed(evt);
    }//GEN-LAST:event_addTeamActionPerformed

    private void removeTeamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeTeamActionPerformed
        // TODO add your handling code here:
        String name = JOptionPane.showInputDialog(null, "What is the team name?", null);
        //System.out.println(bst.contains(new Team(name)));
        while (!bst.contains(new Team(name))) {
            name = JOptionPane.showInputDialog(null, "What is the team name? The team must already be in the league.", null);
        }
        if (name == null) return;
        
        String wins = JOptionPane.showInputDialog(null, "How many wins does the team have?", null);
        while (wins.matches(".*[a-zA-Z]+.*")) {
            wins = JOptionPane.showInputDialog(null, "How many wins? The number of wins must be an integer.", null);
        }
        if (wins == null) return;
        int wins_search = Integer.parseInt(wins);
        
        String games_played = JOptionPane.showInputDialog(null, "How many games played does the team have?", null);
        while (games_played.matches(".*[a-zA-Z]+.*")) {
            games_played = JOptionPane.showInputDialog(null, "How many games played? The number of games_played must be an integer.", null);
        }
        if (games_played == null) return;
        int gp_search = Integer.parseInt(games_played);
        
        Team search = new Team(name);
        search.setWins(wins_search);
        search.setGamesPlayed(gp_search);
        bst.delete(search);
        //System.out.println(bst.size());
        if (bst_displayed) displayBSTActionPerformed(evt);
        else displayListActionPerformed(evt);
    }//GEN-LAST:event_removeTeamActionPerformed

    private void simulateWeekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simulateWeekActionPerformed
        // TODO add your handling code here:
        int size = bst.size();
        int games = size/2;
        gameWinners = new String[games];
        gameLosers = new String[games];
        List<Team> worst = bst.limited_minorder(games);
        List<Team> best = bst.limited_maxorder(games);
        for (Team t : worst) t.addLoss();
        for (Team t : best) t.addWin();
        if (bst_displayed) displayBSTActionPerformed(evt);
        else displayListActionPerformed(evt);
    }//GEN-LAST:event_simulateWeekActionPerformed

    private void editTeamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editTeamActionPerformed
        // TODO add your handling code here:
        String name = JOptionPane.showInputDialog(null, "What is the team name?", null);
        //System.out.println(bst.contains(new Team(name)));
        while (!bst.contains(new Team(name))) {
            name = JOptionPane.showInputDialog(null, "What is the team name? The team must already be in the league.", null);
        }
        if (name == null) return;
        
        String old_wins = JOptionPane.showInputDialog(null, "What is the old number of wins that the team had?", null);
        while (old_wins.matches(".*[a-zA-Z]+.*")) {
            old_wins = JOptionPane.showInputDialog(null, "What is the old number of wins that the team had?", null);
        }
        int wins = Integer.parseInt(old_wins);
        
        String old_gp = JOptionPane.showInputDialog(null, "What is the old number of games played that the team had?", null);
        while (old_gp.matches(".*[a-zA-Z]+.*")) {
            old_gp = JOptionPane.showInputDialog(null, "What is the old number of games played that the team had?", null);
        }
        int games_played = Integer.parseInt(old_gp);
        
        Team ot = new Team(name);
        ot.setWins(wins);
        ot.setGamesPlayed(games_played);
        
        String new_wins = JOptionPane.showInputDialog(null, "What is the new number of wins that you'd like?", null);
        while (new_wins.matches(".*[a-zA-Z]+.*")) {
            new_wins = JOptionPane.showInputDialog(null, "What is the new number of wins that you'd like?", null);
        }
        wins = Integer.parseInt(new_wins);
        
        String new_games_played = JOptionPane.showInputDialog(null, "What is the new number of games played that you'd like?", null);
        while (new_games_played.matches(".*[a-zA-Z]+.*")) {
            new_games_played = JOptionPane.showInputDialog(null, "What is the new number of games played that you'd like?", null);
        }
        games_played = Integer.parseInt(new_games_played);
        
        // traverse alphabetical looking for node
        Team new_team = new Team(name);
        new_team.setWins(wins);
        new_team.setGamesPlayed(games_played);
        
        bst.edit(ot, new_team);
        if (bst_displayed) displayBSTActionPerformed(evt);
        else displayListActionPerformed(evt);
    }//GEN-LAST:event_editTeamActionPerformed

    
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
            java.util.logging.Logger.getLogger(AAU_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AAU_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AAU_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AAU_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AAU_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addTeam;
    private javax.swing.JButton displayBST;
    private javax.swing.JButton displayList;
    private javax.swing.JButton editTeam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton removeTeam;
    private javax.swing.JButton simulateWeek;
    private javax.swing.JTextArea textField;
    // End of variables declaration//GEN-END:variables
}
