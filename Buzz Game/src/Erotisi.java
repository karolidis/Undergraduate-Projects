/**
 *  PANAGIOTATOS GEORGIOS AEM 2627
 *  KAROLIDIS THEODOROS AEM 2572
 */
package buzz;

import java.util.ArrayList;

/**
 *
 * @author Karol
 */
public class Erotisi {

    private String TitlosErotisis;
    ArrayList<String> Apantiseis = new ArrayList<>();
    private String ApantisiA;
    private String ApantisiB;
    private String ApantisiC;
    private String ApantisiD;
    private String SostiApantisi;
    private String Katigoria;
    private String photo;

    /**
     *
     * in the constructor we initialize our variables and we add all answers to
     * an ArrayList.
     */
    public Erotisi(String te, String aA, String aB, String aC, String aD, String sa, String k,String ph) {

        TitlosErotisis = te;
        ApantisiA = aA;
        ApantisiB = aB;
        ApantisiC = aC;
        ApantisiD = aD;
        SostiApantisi = sa;
        Katigoria = k;
        photo = ph;
        Apantiseis.add(ApantisiA);
        Apantiseis.add(ApantisiB);
        Apantiseis.add(ApantisiC);
        Apantiseis.add(ApantisiD);
    }

    /**
     *
     * @return this function returns the question.
     */
    public String getTitlosErotisis() {
        return TitlosErotisis;
    }

    /**
     *
     * @return this function returns the correct answer.
     */
    public String getSostiApantisi() {
        return SostiApantisi;
    }

    /**
     *
     * @return this function returns the question's category.
     */
    public String getKatigoria() {
        return Katigoria;
    }

    /**
     *
     * @param k show us which is the requested answer.
     * @return this function returns the requested answer.
     */
    public String returnAp(int k) {
        return Apantiseis.get(k);
    }
    
 public String getPhoto(int k) {
        return photo;
    }
}
