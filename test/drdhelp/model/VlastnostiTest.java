/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package drdhelp.model;


import java.util.ArrayList;
import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import org.junit.rules.TestName;

import static org.junit.Assert.*;



/*******************************************************************************
 * Testovací třída {@code VlastnostiTest}
 * definuje sadu jednotkových testů prověřujících definici třídy
 * {@link VlastnostiTest}.
 * The test class {@code VlastnostiTest}
 * defines a set of unit tests verifying the definition of the class
 * {@link VlastnostiTest}.
 *
 * @author  Michal Remišovský
 * @version 0.01.0000 — 2017-04-15
 */
public class VlastnostiTest
{
//== CONSTANT CLASS ATTRIBUTES =================================================

    Integer[] HODNOTY = {13, 15, 10, 12, 16};
    Vlastnosti VLASTNOSTI = new Vlastnosti(HODNOTY);


//== VARIABLE CLASS ATTRIBUTES =================================================



//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================



//##############################################################################
//== PREPARATION AND CLEAN UP OF THE TEST FIXTURE ==============================

    /***************************************************************************
     * Provede akce, které je třeba vykonat před spuštěním bloku testů
     * definovaných v této třídě.
     * Perform the actions, which should be performed
     * before the first test in this class.
     */
    @BeforeClass
    public static void setUpClass() {
    }


    /***************************************************************************
     * Provede akce, které je třeba vykonat po ukončení bloku testů
     * definovaných v této třídě.
     * Perform the action, which should be performed
     * after all test in this class.
     */
    @AfterClass
    public static void tearDownClass() {
    }


    /***************************************************************************
     * Inicializace předcházející spuštění každého testu a připravující tzv.
     * přípravek (fixture), což je sada objektů, s nimiž budou testy pracovat.
     * Prepare the tested instances and perform the actions,
     * which should be performed before each test in this class.
     */
    @Before
    public void setUp() {
    }


    /***************************************************************************
     * Provede akce, které je třeba vykonat po ukončení každého testu
     * definovaného v této třídě.
     * Cleans up and perform the actions,
     * which should be performed after each test in this class.
     */
    @After
    public void tearDown() {
    }




//##############################################################################
//== CONSTANT INSTANCE ATTRIBUTES ==============================================

    /** Objekt uchovávající některé informace o testovací metodě.
     *  Musí být deklarován jako public s anotací {@link Rule @Rule}. */
    @Rule
    public final TestName testName = new TestName();



//== VARIABLE INSTANCE ATTRIBUTES ==============================================



//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================
//-- Test class manages with empty default constructor -------------------------

//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================



//##############################################################################
//== TESTS PROPER ==============================================================


    /**
     * Test of getVlastnostiArrayList method, of class Vlastnosti.
     */
    @Test
    public void testGetVlastnostiArrayList() {
        System.out.println("getVlastnostiArrayList");
        String[] pole = {"Síla:   13 +1",
                         "Obratnost:   15 +2",
                         "Odolnost:   10 +0",
                         "Inteligence:   12 +0",
                         "Charisma:   16 +2"};
        ArrayList<String> expResult = new ArrayList<>();
        expResult.addAll(Arrays.asList(pole));
        ArrayList<String> result = VLASTNOSTI.getVlastnostiArrayList();
        assertEquals(expResult, result);
    }
}
