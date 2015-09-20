/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Player implements Serializable {

        private String name;      
        private String photo;
    private List<Stats> stats = new ArrayList<Stats>();
       
        public Player() {}
       
        public Player(String name) {
                this.name = name;
        }

    
    public Player(String name, String photo) {
                this.name = name;        
                this.photo = photo;
        
        }
    
        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getPhoto() {
                return photo;
        }

        public void setPhoto(String photo) {
                this.photo = photo;
        }
       
        

    
    public List<Stats> getStats() {
        return stats;
    }

    public void setStats(List<Stats> stats) {
        this.stats = stats;
    }
   
    
    
}







