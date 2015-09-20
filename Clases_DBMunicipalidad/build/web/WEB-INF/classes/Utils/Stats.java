/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.io.Serializable;

public class Stats implements Serializable {
   
    private String season;
   
    private int goals;
   
    private int assists;

    public Stats() {}

    public Stats(String season, int goals, int assists) {
        this.season = season;
        this.goals = goals;
        this.assists = assists;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }
}
