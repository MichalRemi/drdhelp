/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package drdhelp.model;

import java.util.Random;



/*******************************************************************************
 * Instance třídy {@code Kostka} představují hrací kostky z deskových her. Kostky
 * mají různý počet stěn.
 *
 * @author  Michal Remišovský
 * @version 0.01.0000 — 2016-09-18
 */
public class Kostka {

//== CONSTANT CLASS ATTRIBUTES =================================================
//== VARIABLE CLASS ATTRIBUTES =================================================



//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================



//##############################################################################
//== CONSTANT INSTANCE ATTRIBUTES ==============================================

    private final Random RANDOM;

    private final int POCET_STEN;

//== VARIABLE INSTANCE ATTRIBUTES ==============================================



//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /**
     * Konstruktor pro kostku s libovolným počtem stěn
     *
     * @param PocetSten
     */
    public Kostka(int PocetSten) {
        this.POCET_STEN = PocetSten;
        RANDOM = new Random();
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    /**
    * Vrátí počet stěn hrací kostky
    * @return počet stěn hrací kostky
    */
    public int getPocetSten()
    {
        return POCET_STEN;
    }

//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /**
    * Vykoná hod kostkou
    * @return Číslo od 1 do počtu stěn
    */
    public int hod() {
        return RANDOM.nextInt(POCET_STEN) + 1;
    }

    /**
    * Vrací textovou reprezentaci kostky - vypíše kolik má stěn
    * @return Textová reprezentace kostky
    */
    @Override
    public String toString() {
        return String.format("Kostka s/se %s stěnami", POCET_STEN);
    }

//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
