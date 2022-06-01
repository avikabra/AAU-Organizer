/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aau_freeflow;
import java.util.*;
/**
 *
 * @author home
 */
public class Team implements Comparable<Team> {
    private String name; 
    private int games_played, wins;
    private double win_percentage;
    public boolean alphabetical = false;
    
    public Team(String name) {
        this.name = name;
        games_played = 0;
        wins = 0;
        win_percentage = 0;
    }
    
    public Team(String name, boolean alphabetical) {
        this.name = name;
        games_played = 0;
        wins = 0;
        win_percentage = 0;
        alphabetical = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGamesPlayed() {
        return games_played;
    }
    
    public void setGamesPlayed(int gp) {
        this.games_played = gp;
        updateWinPercentage();
    }

    public void addLoss() {
        games_played += 1;
        updateWinPercentage();
    }

    public int getWins() {
        return wins;
    }
    
    public void setWins(int w) {
        this.wins = w;
        this.games_played += w;
        updateWinPercentage();
    }

    public void addWin() {
        wins += 1;
        games_played += 1;
        updateWinPercentage();
    }

    private void updateWinPercentage() {
        win_percentage = 1.0*wins/games_played;
    }
    
    public double getWinPercentage() {
        if (games_played == 0) return 0.0;
        return (double) Math.round(win_percentage * 1000) / 10;
    }
    
    public String toString() {
        //return "Team: " + name + ", Wins: " + wins + ", Win %: " + getWinPercentage();
        return name + ", Win %: " + getWinPercentage();
    }
    
    public boolean equals(Object a) {
        //System.out.println(a.getName());
        System.out.println(name);
        //System.out.println(a.getName().contains(name));
        return name.compareTo(((Team)a).getName()) == 0;
    }
    
    public int compareTo(Team a) {
        if (!alphabetical)
            return (int) ((getWinPercentage() - ((Team)a).getWinPercentage()));
        else return (name.compareTo(((Team)a).getName()));
    }
}
