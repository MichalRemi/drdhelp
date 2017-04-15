/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package drdhelp.model.logika;

import drdhelp.model.Odkaz;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;





/*******************************************************************************
 * Instance třídy {@code PridejLogika} představují logiku formuláře Pridej.fxml.
 *
 * @author  Michal Remišovský
 * @version 0.01.0000 — 2017-04-15
 */
public class PridejLogika
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

    private final ObservableList<Odkaz> seznamPolozekObservableList =
    FXCollections.observableArrayList();

    private final ObservableList<Odkaz> polozkyPostavyObservableList =
    FXCollections.observableArrayList();


//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    public PridejLogika() {
        init();
    }


//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    public ObservableList<Odkaz> polozkyPostavyList() {
        return polozkyPostavyObservableList;
    }

    public ObservableList<Odkaz> seznamPolozekList() {
        return seznamPolozekObservableList;
    }


//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /** Přesune položku z položek postavy do seznamu položek. */
    public void vlozDoPolozkyPostavy(Odkaz polozka) {
        polozkyPostavyObservableList.add(polozka);
        seznamPolozekObservableList.remove(polozka);
    }

    /** Přesune položku ze seznamu položek do položek postavy. */
    public void vlozDoSeznamPolozek(Odkaz polozka) {
        seznamPolozekObservableList.add(polozka);
        polozkyPostavyObservableList.remove(polozka);
    }

    /** Předá upravené hodnoty do PostavaLogika.polozkyPostavy - ArrayList. */
    public void vlozPolozkyPostavy() {
        PostavaLogika.setPridanyObservableList(polozkyPostavyObservableList);
    }

//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================

    private void init() {

        // nastavení hodnot seznam položek a položky postavy
        seznamPolozekObservableList.setAll(PostavaLogika.getSeznamPolozek());
        polozkyPostavyObservableList.setAll(PostavaLogika.getPolozkyPostavy());
        zredukujOPolozkyPostavy();
    }

    /**
     * Ze Seznamu položek v listView odstraní Položky postavy, aby nebyli duplicitní.
     * Metoda iteruje pomocný seznamPolozekArrayList (kopie seznamPolozekObservableList),
     * kde je vnožená iterace pomocného polozkyPostavyArrayList (kopie
     * polozkyPostavyObservableList), kde u každé porovná id Odkazů. Pokud jsou shodné,
     * odebere ho ze seznamPolozekObservableList, tj. ze seznamPolozekListView,
     * uloží index Odkazu z polozkyPostavyArrayList a přeruší vnořenou iteraci,
     * aby se neporovnovávali zbytečně další Odkazy, které již shodné být nemohou.
     * Tato položka se odebere i z polozkyPostavyArrayList a následně otestuje,
     * zda není prázdný. Pokud ano, ukončí iteraci seznamPolozekArrayList, všechny
     * Odkazy z polozkyPostavaArrayList jsou již ze seznamPolozekObservableList
     * odebrány.
     */
    private void zredukujOPolozkyPostavy() {
        // pomocná pole
        ArrayList<Odkaz> seznamPolozekArrayList = PostavaLogika.getSeznamPolozek();
        ArrayList<Odkaz> polozkyPostavyArrayList = PostavaLogika.getPolozkyPostavy();
        // index položky postavy, který po nalezení a odebrání ze seznamu položek
        // slouží k odebrání z položek postavy
        int indexPolozkyPostavy;
        for (Odkaz polozkaSeznamu : seznamPolozekArrayList) {
            // hodnota -1 znamená, že není shoda
            indexPolozkyPostavy = -1;
            for (Odkaz polozkaPostavy : polozkyPostavyArrayList) {
                if (polozkaPostavy.getId() == polozkaSeznamu.getId()) {
                    seznamPolozekObservableList.remove(polozkaSeznamu);
                    indexPolozkyPostavy = polozkyPostavyArrayList.indexOf(polozkaPostavy);
                    break;
                }
            }
            if (indexPolozkyPostavy != -1) polozkyPostavyArrayList.remove(indexPolozkyPostavy);
            if (polozkyPostavyArrayList.isEmpty()) break;
        }
    }


//##############################################################################
//== NESTED DATA TYPES =========================================================
}
