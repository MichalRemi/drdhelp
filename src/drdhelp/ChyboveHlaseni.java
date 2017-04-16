/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package drdhelp;

<<<<<<< HEAD
=======
import drdhelp.model.logika.MainLogika;
import javafx.stage.Window;

>>>>>>> origin/master




/*******************************************************************************
 * Instance třídy {@code ChyboveHlaseni} zajišťují chybová hlášení.
 *
 * @author  Michal Remišovský
<<<<<<< HEAD
 * @version 0.01.0000 — 2017-04-15
=======
 * @version 0.00.0000 — 20yy-mm-dd
>>>>>>> origin/master
 */
public class ChyboveHlaseni {

//== CONSTANT CLASS ATTRIBUTES =================================================
//== VARIABLE CLASS ATTRIBUTES =================================================



//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================



//##############################################################################
//== CONSTANT INSTANCE ATTRIBUTES ==============================================
//== VARIABLE INSTANCE ATTRIBUTES ==============================================



//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     *
     */
    public ChyboveHlaseni() {
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    public void chybaSpojeniDatabaze() {
        Okno okno = new Okno("Chybová hláška",
                "CHYBA!: Nepodařilo se navázat spojení s databází!\n" +
                "Aplikace bude ukončena.");
    }

//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
