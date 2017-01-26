/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package UnitTest;



import drdhelp.model.Postava;
import drdhelp.model.ZbranSAV;
import drdhelp.model.io.GetData;
import drdhelp.model.Odkaz;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import org.junit.rules.TestName;




/*******************************************************************************
 * Testovací třída {@code NewEmptyJUnitTest}
 * definuje sadu jednotkových testů prověřujících definici třídy
 * {@link NewEmptyJUnitTest}.
 * The test class {@code NewEmptyJUnitTest}
 * defines a set of unit tests verifying the definition of the class
 * {@link NewEmptyJUnitTest}.
 *
 * @author  Michal Remišovský
 * @version 0.00.0000 — 20yy-mm-dd
 */
public class NewEmptyJUnitTest {

//== CONSTANT CLASS ATTRIBUTES =================================================
//== VARIABLE CLASS ATTRIBUTES =================================================

    /** Zpravodaj zprostředkující odsazovaný tisk na standardní výstup. */



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
    public static void setUpClass()
    {

    }


    /***************************************************************************
     * Provede akce, které je třeba vykonat po ukončení bloku testů
     * definovaných v této třídě.
     * Perform the action, which should be performed
     * after all test in this class.
     */
    @AfterClass
    public static void tearDownClass()
    {

    }


    /***************************************************************************
     * Inicializace předcházející spuštění každého testu a připravující tzv.
     * přípravek (fixture), což je sada objektů, s nimiž budou testy pracovat.
     * Prepare the tested instances and perform the actions,
     * which should be performed before each test in this class.
     */
    @Before
    public void setUp()
    {

    }


    /***************************************************************************
     * Provede akce, které je třeba vykonat po ukončení každého testu
     * definovaného v této třídě.
     * Cleans up and perform the actions,
     * which should be performed after each test in this class.
     */
    @After
    public void tearDown()
    {

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

    /***************************************************************************
     * Test metody {@link #setUp()} vytvářející testovací přípravek.
     * Test of the {@link #setUp()} method preparing the test fixture.
     */
    @Test
    public void testSetUp() {



    }

//    @Test
//    public void testPostavaList() {
//        GetData data = new GetData();
//        ArrayList<String> postavy = new ArrayList<>();
//        postavy = data.getNazvyAID("postava");
//        for (String s : postavy) System.out.println(s);
//    }

        @Test
    public void testGetNazvyAId() {
        GetData data = new GetData();
        ArrayList<Odkaz> postavy = new ArrayList<>();
        postavy = data.nactiOdkazy("postava");
        for (Odkaz n : postavy) System.out.println(n.toString());
    }


    @Test
    public void testGetPostava() {
        GetData data = new GetData();
        Postava postava = data.getPostava(1);
        System.out.println(postava);
        ArrayList<String> seznam = postava.getVlastnosti().getVlastnostiArrayList();
        for (String s : seznam) System.out.println(s);

    }
    @Test
    public void TestVypisVlastnosti() {

    }

    @Test
    public void TestCteniId() {
        GetData id = new GetData();
        System.out.println(id.getIdPosledniPostavy());
    }

    @Test
    public void TestVypis() {
        GetData data = new GetData();
        ZbranSAV z = data.getZbranSAV(1);
        System.out.println(z.toString());
    }







//    @Test
//    public void testKostka() {
//
//        System.out.println("Test třídy Kostka");
//        Kostka kostka = new Kostka(6);
//        int[] hody = new int[6];
//        for (int j = 0; j < 6; j++) hody[j] = 0;
//        for (int i = 0; i < 10000; i++) {
//            switch (String.valueOf(kostka.hod())) {
//                case "1": { ++hody[0]; break; }
//                case "2": { ++hody[1]; break; }
//                case "3": { ++hody[2]; break; }
//                case "4": { ++hody[3]; break; }
//                case "5": { ++hody[4]; break; }
//                case "6": { ++hody[5]; break; }
//                default : System.out.println("Chyba hodu kostky, hodnoty k6 není" +
//                        "v intervalu 1-6");
//            }
//        }
//        for (int k : hody) System.out.print(k + " ");
//    }

}
