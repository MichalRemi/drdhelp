/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package drdhelp.model;

import drdhelp.model.Nestvura.Pohyblivost;
import drdhelp.model.Nestvura.VelikostNestvura;
import drdhelp.model.Nestvura.Zranitelnost;
import drdhelp.model.Tvor.Presvedceni;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import org.junit.rules.TestName;

import static org.junit.Assert.*;



/*******************************************************************************
 * Testovací třída {@code NestvuraTest}
 * definuje sadu jednotkových testů prověřujících definici třídy
 * {@link NestvuraTest}.
*
 * @author  Michal Remišovský
 * @version 0.00.0000 — 2017-03-02
 */
public class NestvuraTest
{
//== CONSTANT CLASS ATTRIBUTES =================================================

    private static final Nestvura SKRET7 = new Nestvura(
            7,
            "Skřet",
            1,
            null,
            "-1 + síla zbraně",
            -2,
            new Integer[] { 9, 9, 8, 4, 3},
            VelikostNestvura.A.toString(),
            null,
            Zranitelnost.HUMANOID.toString(),
            Zranitelnost.HUMANOID.getSkupinyZranitelnost(),
            new Vlastnost("Pohyblivost", 7),
            Pohyblivost.HUMANOID.toString(),
            null,
            null,
            null,
            null,
            Presvedceni.ZMZ.toString(),
            "5/0, 2500/10 sídlo",
            10,
            null,
            "skřetoidní nestvůra");

    private static final Nestvura DIKOBRAZ3 = new Nestvura(
            3,
            "Dikobraz obří",
            2,
            2,
            "5/-1",
            7,
            new Integer[] { 13, 17, 12, 1, null},
            VelikostNestvura.B.toString(),
            6,
            Zranitelnost.ZVIRE.toString(),
            Zranitelnost.ZVIRE.getSkupinyZranitelnost(),
            new Vlastnost("Pohyblivost", 15),
            Pohyblivost.SELMA.toString(),
            new Vlastnost("Vytrvalost", 13),
            Pohyblivost.SELMA.toString(),
            null,
            null,
            null,
            "nic",
            30,
            null,
            "přerostlý dikobraz");

    private static final Nestvura DRAK11 = new Nestvura(
            11,
            "Modrý drak",
            16,
            null,
            "18/+2 + 14/+2 + 14/+2",
            14,
            new Integer[] { 29, 17, 25, 14, 20},
            VelikostNestvura.E.toString(),
            null,
            null,
            "B,C,D,G0,H¼,I,J,K0,P+",
            new Vlastnost("Pohyblivost", 16),
            Pohyblivost.DRAK.toString(),
            null,
            null,
            18,
            127,
            Presvedceni.ZMD.toString(),
            "80000/200",
            6000,
            null,
            "pozor, pohybuje se i ve vodě");

    private static final Nestvura PLOSTICE19 = new Nestvura(
            19,
            "Ploštice zelená",
            -1,
            null,
            "1",
            3,
            new Integer[] { 9, 13, 9, 0, null},
            VelikostNestvura.A.toString(),
            12,
            Zranitelnost.ZVIRE.toString(),
            Zranitelnost.ZVIRE.getSkupinyZranitelnost(),
            new Vlastnost("Pohyblivost", 7),
            Pohyblivost.PLAZ.toString(),
            new Vlastnost("Vytrvalost", 18),
            Pohyblivost.HMYZ.toString(),
            5,
            null,
            null,
            "nic",
            5,
            null,
            "ochromuje kousnutím");

private static final Nestvura KUN13 = new Nestvura(
            13,
            "Kůň",
            3,
            null,
            "4",
            3,
            new Integer[] { 19, 13, 10, 1, null},
            VelikostNestvura.C.toString(),
            3,
            Zranitelnost.ZVIRE.toString(),
            Zranitelnost.ZVIRE.getSkupinyZranitelnost(),
            new Vlastnost("Pohyblivost", 18),
            Pohyblivost.ZVIRE.toString(),
            new Vlastnost("Vytrvalost", 14),
            Pohyblivost.ZVIRE.toString(),
            null,
            null,
            null,
            "nic",
            30,
            7,
            "může být jezdecký, tažný, válečný, ...");

public static final Nestvura[] NESTVURY = {SKRET7, DIKOBRAZ3, DRAK11, PLOSTICE19,
                                           KUN13};




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
     * Test of getObranaString method, of class Nestvura.
     */
    @Test
    public void testGetObranaString() {
        System.out.println("getObranaString");
        for (Nestvura nestvura : NESTVURY) {
            String result = nestvura.getObranaString();
            if (result == null) {
                fail("Obrana u nestvůry " + nestvura.getNazev() + " je null!");
            }
        }
    }

    /**
     * Test of getZivotaschopnostString method, of class Nestvura.
     */
    @Test
    public void testGetZivotaschopnostString() {
        System.out.println("getZivotaschopnostString");
        for (Nestvura nestvura : NESTVURY) {
            boolean shoda = false;
            String result = nestvura.getZivotaschopnostString();
            // hledá shodu meni žvt a prvky pole hodnotyZvtArray
            for (String s : Nestvura.hodnotyZvtArray) {
                if (s.equals(result)) {
                    shoda = true;
                    break;
                }
            }
            // pokud žvt není shodná s některým prvkem z hodnotyZvtArray, chyba
            if (!shoda) fail("Nestvůra " + nestvura.getNazev() + " nemá platnou žvt.");
        }
    }

    /**
     * Test of urciZranitelnost method, of class Nestvura.
     */
    @Test
    public void testUrciZranitelnost() {
        System.out.println("urciZranitelnost");
        for (Nestvura nestvura : NESTVURY) {
            boolean shoda = false;
            Zranitelnost result = nestvura.urciZranitelnost();
            if (result != null) {
                // hledá shodu mezi zranitelností a prvky enum Zranitelnost
                for (Zranitelnost z : Zranitelnost.values()) {
                    if (z.equals(result)) {
                        shoda = true;
                        break;
                    }
                }
                // pokud žvt není shodná s některým prvkem z hodnotyZvtArray, chyba
                if (!shoda) fail("Nestvůra " + nestvura.getNazev() + " nemá platnou zranitelnost.");
            }
        }
    }
}
