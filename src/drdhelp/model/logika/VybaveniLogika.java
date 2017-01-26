/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package drdhelp.model.logika;





/*******************************************************************************
 * Instance třídy {@code VybaveniLogika} představují
 *
 * @author  Michal Remišovský
 * @version 0.00.0000 — 2017-01-17
 */
public abstract class VybaveniLogika extends Logika
{
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
    public VybaveniLogika() {
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================



//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /** Ověří platnost váhy, zda je to číslo v rozsahu 0 - 90 000 */
    protected boolean jeVahaValidni(String vaha) {
        return zvalidujStringCislo(vaha, 0, 90000);
    }

    /** Ověří platnost zlaťáků, zda je to číslo v rozsahu 0 - 1 000 000 */
    protected boolean jeZlatakyValidni(String zlataky) {
        return zvalidujStringCislo(zlataky, 0, 1000000);
    }

    /** Ověří platnost stříbrňáků, zda je to číslo v rozsahu 0 - 9 */
    protected boolean jeStribrnakyValidni(String stribrnaky) {
        return zvalidujStringCislo(stribrnaky, 0, 9);
    }

    /** Ověří platnost měďáků, zda je to číslo v rozsahu 0 - 9 */
    protected boolean jeMedakyValidni(String medaky) {
        return zvalidujStringCislo(medaky, 0, 9);
    }


//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
