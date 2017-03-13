/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package drdhelp.model.logika;


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
 * Testovací třída {@code LogikaTest}
 * definuje sadu jednotkových testů prověřujících definici třídy
 * {@link LogikaTest}.
 * The test class {@code LogikaTest}
 * defines a set of unit tests verifying the definition of the class
 * {@link LogikaTest}.
 *
 * @author  Michal Remišovský
 * @version 0.00.0000 — 20yy-mm-dd
 */
public class LogikaTest
{
//== CONSTANT CLASS ATTRIBUTES =================================================
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
     * Test of jeStringValidni method, of class Logika.
     */
    @Test
    public void testJeStringValidni() {
        System.out.println("jeStringValidni");
        String text = "text";
        Logika instance = new LogikaImpl();
        boolean result1 = instance.jeStringValidni(text, 1, 5);
        boolean result2 = instance.jeStringValidni(text, 1, 2);
        boolean result3 = instance.jeStringValidni(text, -1, -5);
        assertTrue(result1);
        assertFalse(result2);
        assertFalse(result3);
    }

    /**
     * Test of zvalidujStringCislo method, of class Logika.
     */
    @Test
    public void testZvalidujStringCislo()
    {
        System.out.println("zvalidujStringCislo");
        int dolniMez = 0;
        int horniMez = 10;
        Logika instance = new LogikaImpl();
        assertTrue(instance.zvalidujStringCislo("9", dolniMez, horniMez));
        assertFalse(instance.zvalidujStringCislo("11", dolniMez, horniMez));
        assertFalse(instance.zvalidujStringCislo("-1", dolniMez, horniMez));
        assertFalse(instance.zvalidujStringCislo("a", dolniMez, horniMez));
    }

    /**
     * Test of stringToArrayList method, of class Logika.
     */
    @Test
    public void testStringToArrayList() {
        System.out.println("stringToArrayList");
        String text = "Test,je,ok";
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("Test");
        expResult.add("je");
        expResult.add("ok");
        Logika instance = new LogikaImpl();
        ArrayList<String> result = instance.stringToArrayList(text);
        assertEquals(expResult, result);
    }

    /**
     * Test of vyhodnotAVratInt method, of class Logika.
     */
    @Test
    public void testVyhodnotAVratInt() {
        System.out.println("vyhodnotAVratInt");
        // Tvor.hodnotyArray je pole {"1", ... , "40"}
        String[] poleString = {"0", "1", "12", "35", "41", null};
        Integer[] poleInteger = {null, 1, 12, 35, null, null};
        Logika instance = new LogikaImpl();
        int i = 0;
        for (String s : poleString) {
            Integer result = instance.vyhodnotAVratInt(s);
            if (result == null || poleInteger[i] == null) {
                if (result != null && poleInteger[i] != null) {
                    fail("Pro String \"" + s + "\" vrátila metoda hodnotu: " + result +
                     ", očekánavý výsledek má být: " + poleInteger[i]);
                }
            } else {
                if (!result.equals(poleInteger[i])) {
                fail("Pro String \"" + s + "\" vrátila metoda hodnotu: " + result +
                     ", očekánavý výsledek má být: " + poleInteger[i]);
                }
            }
            i++;
        }
    }

    /**
     * Test of vyhodnotAVratString method, of class Logika.
     */
    @Test
    public void testVyhodnotAVratString() {
        System.out.println("vyhodnotAVratString");
        String[] poleStrings = {"0", "1", "11"};
        Integer[] poleIntegers = {null, 0, 1};
        String[] expResult = {"N/A", "N/A", "1"};
        Logika instance = new LogikaImpl();
        int i = 0;
        String result;
        for (String s : poleStrings) {
            result = instance.vyhodnotAVratString(poleIntegers[i], poleStrings);
            if (!result.equals(expResult[i])) {
                fail("Pro hodnotu " + poleIntegers[i] + " je očekávaný výsledek: " +
                     expResult[i] + " skutečný je ale: " + result);
            }
            i++;
        }
    }

    public class LogikaImpl extends Logika {
    }
}
