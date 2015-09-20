/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;



public class AutoCompleteBean {
      
        private Player selectedPlayer1;
   

        private List<Player> players;



               public AutoCompleteBean() {
                 players = new ArrayList<Player>();
        players.add(new Player("Messi", "messi.jpg"));
        players.add(new Player("Tony", "bojan.jpg"));
        players.add(new Player("Iniesta","iniesta.jpg"));
        players.add(new Player("Villa", "villa.jpg"));
        players.add(new Player("Xavi","xavi.jpg"));
        players.add(new Player("Puyol","puyol.jpg"));
        players.add(new Player("Afellay", "afellay.jpg"));
        players.add(new Player("Abidal", "abidal.jpg"));
        players.add(new Player("Alves", "alves.jpg"));
        players.add(new Player("Pique", "pique.jpg"));
        players.add(new Player("Keita", "keita.jpg"));
        players.add(new Player("Adriano",  "adriano.jpg"));
        players.add(new Player("ValdesSSSSS", "valdes.jpg"));               
        
        }

    public Player getSelectedPlayer1() {
        return selectedPlayer1;
    }

    public void setSelectedPlayer1(Player selectedPlayer1) {
        this.selectedPlayer1 = selectedPlayer1;
    }

      
   

    public List<Player> getPlayers() {
        return players;
    }

   

}

