/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package drdhelp.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import org.junit.rules.TestName;



import static org.junit.Assert.*;



/*******************************************************************************
 * Testovací třída {@code VlastnostTest}
 * definuje sadu jednotkových testů prověřujících definici třídy
 * {@link VlastnostTest}.
 * The test class {@code VlastnostTest}
 * defines a set of unit tests verifying the definition of the class
 * {@link VlastnostTest}.
 *
 * @author  Michal Remišovský
 * @version 0.01.0000 — 2017-04-15
 */
public class VlastnostTest
{
//== CONSTANT CLASS ATTRIBUTES =================================================

    Vlastnost VLASTNOST = new Vlastnost("Testovaci", 16);

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
     * Test of getBonus method, of class Vlastnost.
     */
    @Test
    public void testGetBonus_Integer() {
        System.out.println("getBonus");
        String expResult = "+0";
        String result = Vlastnost.getBonus(10);
        assertEquals(expResult, result);
    }

    /**
     * Test of generujVlastnost method, of class Vlastnost.
     */
    @Test
    public void testGenerujVlastnost() {
        System.out.println("generujVlastnost");
        boolean testOk = false;
        int pocetKostek = 3;
        int konstanta = 3;
        for (int i = 0; i < 1000; i++) {
            int result = Vlastnost.generujVlastnost(pocetKostek, konstanta);
            if (result < 6 || result > 21) {
                fail("Chyba: Vlastnost.generujVlastnost(3, 3)");
            }
        }
    }

    /**
     * Test of getBonusString method, of class Vlastnost.
     */
    @Test
    public void testGetBonusString() {
        System.out.println("getBonusString");
        Vlastnost instance = new Vlastnost("Síla", 16);
        String expResult = "+2";
        String result = instance.getBonusString();
        assertEquals(expResult, result);
    }

    /**
     * Test of deleniNahoru method, of class Vlastnost.
     */
    @Test
    public void testDeleniNahoru() {
        System.out.println("deleniNahoru");
        int expResult = 3;
        int result = VLASTNOST.deleniNahoru(13, 6);
        assertEquals(expResult, result);
    }

}