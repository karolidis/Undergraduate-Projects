/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buzz;

/**
 *
 * @author Κωνσταντινος
 */
public class Player {
    
    private String onoma,pontoi,nikes;
    
    Player(String o,String p,String n)            
    {
        onoma = o;
        pontoi = p;
        nikes = n;
    }
    
    public String getOnoma() {
        return onoma;
    }
    
    public String getPontoi() {
        return pontoi;
    }
    
    public String getNikes() {
        return nikes;
    }
    
}
