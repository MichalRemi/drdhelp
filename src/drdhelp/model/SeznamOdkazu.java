/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package drdhelp.model;

import drdhelp.model.io.GetData;
import java.util.ArrayList;
import java.util.Collections;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



/*******************************************************************************
 * Instance třídy {@code SeznamOdkazu} představují FXCollections ObservableList
 * pro bindování s ListView ve formuláři
 *
 * @author  Michal Remišovský
 * @version 0.01.0000 — 2016-12-22
 */
public class SeznamOdkazu {

//== CONSTANT CLASS ATTRIBUTES =================================================
//== VARIABLE CLASS ATTRIBUTES =================================================

    private static Odkaz upravit = null;

    private final GetData getData = new GetData();



//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CLASS GETTERS AND SETTERS =================================================

    /**
     * Načte Odkaz ze statické proměnné. Ten slouží k načtení upravované položky
     * do přislušného formuláře (vyskakovací okna). Pokud se jedná o přidání
     * nové položky, má hodnotu null.
     */
    public static Odkaz getUpravit() {
        return upravit;
    }

    /**
     * Uloží Odkaz do statické proměnné. Ten slouží k načtení upravované položky
     * do přislušného formuláře (vyskakovací okna). Pokud se jedná o přidání
     * nové položky, má hodnotu null.
     */
    public static void setUpravit(Odkaz odkaz) {
        upravit = odkaz;
    }

//== OTHER NON-PRIVATE CLASS METHODS ===========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================



//##############################################################################
//== CONSTANT INSTANCE ATTRIBUTES ==============================================
//== VARIABLE INSTANCE ATTRIBUTES ==============================================

    // Odkazy nabindované do seznamListView
    private final ObservableList<Odkaz> odkazy = FXCollections.observableArrayList();

    // Poslední načtený seznam Odkazů
    private ArrayList<Odkaz> puvodniOdkazy = new ArrayList<Odkaz>();



//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    public ObservableList<Odkaz> getOdkazy() {
        return odkazy;
    }

//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /** přidá odkaz do kolekce odkazy(nabindovaná se seznamlistView v main.fxml) */
    public void pridej(Odkaz odkaz) {
        odkazy.add(odkaz);
    }

    /** smaže odkaz z kolekce odkazy(nabindovaná se seznamlistView v main.fxml) */
    public void odeber(Odkaz odkaz) {
        odkazy.remove(odkaz);
    }

    /** seřadí kolekci odkazy(nabindovaná se seznamlistView v main.fxml) */
    public void serad(ArrayList<Odkaz> listOdkazu) {
        Collections.sort(listOdkazu);
    }

    /** načte odkazy do kolekce odkazy(nabindovaná se seznamlistView v main.fxml) */
    public void nactiOdkazy(String nazevTlacitka){
        if (nazevTlacitka != null) {
            puvodniOdkazy = getData.nactiOdkazy(getTabName(nazevTlacitka));
            serad(puvodniOdkazy);
            odkazy.clear();
            if (!odkazy.addAll(puvodniOdkazy))
                System.err.println("SeznamOdkazu.nactiOdkazy: Nezdařilo se přidání" +
                                                                "ArrayList<Odkaz>");
        } else {
            System.err.println("SeznamOdkazu.nactiOdkazy: Parametr nazevTlacitka je null");
        }
    }

    /**
     * hledání v kolekci odkazy(nabindovaná se seznamlistView v main.fxml)
     * zredukuje kolekci na položky začínající předaným řetězcem
     */
    public void vyberPodleZacinajicihoRetezce(String retezec) {
        ArrayList<Odkaz> hledane = new ArrayList<>();
        if (!"".equals(retezec)) {
            for (Odkaz o : puvodniOdkazy) {
                if (o.getNazev().toLowerCase().startsWith(retezec.toLowerCase())) {
                    hledane.add(o);
                }
                odkazy.setAll(hledane);
            }
        } else odkazy.setAll(puvodniOdkazy);
    }

    /**
     * Vrátí název tabulky odpovídající názvu tlačítka - předanému parametru
     * @param buttonName Tlačítko z ToggleGroup menu z formuláře Main
     */
    public String getTabName(String buttonName) {
        try {
            for (TabulkaDB t : TabulkaDB.values()) {
            if (t.getNazev().equals(buttonName)) return t.getTabNazev();
            }
        } catch (Exception e) {
        System.out.println("Chybné jméno tlačítka!\n" + e);
        }
        return null;
    }



//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}