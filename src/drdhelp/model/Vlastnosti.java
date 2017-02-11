package drdhelp.model;

import java.util.ArrayList;



/*******************************************************************************
 * Instance třídy {@code Vlastnosti} představují pole vlastností pro daného
 * tvora. Skládá se z Vlastnost[] - obsahuje názv, hodnotu a bonus.
 *
 * @author  Michal Remišovský
 * @version 0.01.0000 — 2016-09-18
 */
public class Vlastnosti
{
//== CONSTANT CLASS ATTRIBUTES =================================================

    public final String[] nazvyVlastnostiArray = {"Síla", "Obratnost", "Odolnost",
                                               "Inteligence", "Charisma"};

//== VARIABLE CLASS ATTRIBUTES =================================================



//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================


//== PRIVATE AND AUXILIARY CLASS METHODS =======================================



//##############################################################################
//== CONSTANT INSTANCE ATTRIBUTES ==============================================
//== VARIABLE INSTANCE ATTRIBUTES ==============================================

    /***************************************************************************
     * Pole o velikosti 5 prvků, obsahuje vlastnosti tvora.
     */
    Vlastnost[] vlastnosti = new Vlastnost[5];


//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /**
     * Konstruktor
     *
     * @param hodnotyVlastnosti
     */
    public Vlastnosti(Integer[] hodnotyVlastnosti) {
        int delkaPole = hodnotyVlastnosti.length;
        if (delkaPole == 5) {
            for (int i = 0; i < 5; i++) {
                this.vlastnosti[i] =
                        new Vlastnost(nazvyVlastnostiArray[i], hodnotyVlastnosti[i]);
            }
        } else {
            System.err.println("Chyba parametru konstruktoru: pole musí mít 5 prvků!");
        }
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    /**
     * @param i Číslo pořadí vlastnosti od 0 do 4 pro Sílu až Charisma.
     * @return vlastnost
     */
    public Vlastnost getVlastnost(int i) {
        return vlastnosti[i];
    }

    public Integer getSila() {
        return getVlastnost(0).getHodnota();
    }

    public Integer getObratnost() {
        return getVlastnost(1).getHodnota();
    }

    public Integer getOdolnost() {
        return getVlastnost(2).getHodnota();
    }

    public Integer getInteligence() {
        return getVlastnost(3).getHodnota();
    }

    public Integer getCharisma() {
        return getVlastnost(4).getHodnota();
    }

    /**
     * @param i Číslo pořadí vlastnosti od 0 do 4 pro Sílu až Charisma.
     * @return bonus
     */
    public String getBonus(int i) {
        return vlastnosti[i].getBonusString();
    }





//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /**
     * Vrátí vlastnosti (název, hodnota, bonus)  v pořadí Síla,
     * Obratnost, Odolnost, Inteligence, Charisma.
     *
     * @return Seznam vlastností.
     */
    public ArrayList<String> getVlastnostiArrayList() {
        ArrayList<String> seznamVlastnosti = new ArrayList<>();
        for (Vlastnost v : vlastnosti) {
            if (v.getHodnota() != null) {
                seznamVlastnosti.add(v.toString());
            }
        }
        return seznamVlastnosti;
    }

//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}