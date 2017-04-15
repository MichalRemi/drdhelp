/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package drdhelp.model;


import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import org.junit.rules.TestName;

import static org.junit.Assert.*;



/*******************************************************************************
 * Testovací třída {@code PostavaTest}
 * definuje sadu jednotkových testů prověřujících definici třídy
 * {@link PostavaTest} a rodičovské třídy Tvor.
 *
 * @author  Michal Remišovský
 * @version 0.01.0000 — 2017-04-15
 */
public class PostavaTest
{
//== CONSTANT CLASS ATTRIBUTES =================================================

    private final static Postava POSTAVA5 = new Postava(5, "Jáchym", "člověk",
            "hraničář", true, 10, 3, 1, 0, new Integer[] { 15, 13, 12, 15, 10} ,
            new Vlastnost ("Pohyblivost", 16), 165, 1500, null, null, null, null,
            null, "B", null, null, null, "poznamka");

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
     * Test of urciZkusenostiNaDalsiUroven method, of class Postava.
     */
    @Test
    public void testUrciZkusenostiNaDalsiUroven() {
        System.out.println("urciZkusenostiNaDalsiUroven");
        String result = POSTAVA5.urciZkusenostiNaDalsiUroven();
        assertNotNull(result);
    }



    //##########################################################################
    //== TESTS CLASS TVOR=======================================================

    /**
     * Test of arrayListdoRadku method, of class Tvor.
     */
    @Test
    public void testArrayListdoRadku() {
        System.out.println("arrayListdoRadku");
        ArrayList<String> list = new ArrayList<>();
        list.add("Test");
        list.add("je");
        list.add("ok");
        String expResult = "Test\nje\nok\n";
        String result = POSTAVA5.arrayListdoRadku(list);
        assertEquals(expResult, result);
    }

    /**
     * Test of stringToArrayList method, of class Tvor.
     */
    @Test
    public void testStringToArrayList() {
        System.out.println("stringToArrayList");
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("Test");
        expResult.add("je");
        expResult.add("ok");
        String text = "Test,je,ok";
        ArrayList<String> result = POSTAVA5.stringToArrayList(text);
        assertEquals(expResult, result);
    }

}