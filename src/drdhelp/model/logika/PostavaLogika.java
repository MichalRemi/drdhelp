/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package drdhelp.model.logika;

import drdhelp.model.Odkaz;
import drdhelp.model.Postava;
import drdhelp.model.Vlastnost;
import drdhelp.model.io.GetData;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;




/*******************************************************************************
 * Instance třídy {@code PostavaLogika} představují ...
 *
 * @author  Michal Remišovský
 * @version 0.01.0000 — 2017-02-03
 */
public class PostavaLogika extends Logika {

//== CONSTANT CLASS ATTRIBUTES =================================================

//== VARIABLE CLASS ATTRIBUTES =================================================

    private static Postava novaPostava = null;



//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CLASS GETTERS AND SETTERS =================================================


    public static Postava getNovaPostava() {
        return novaPostava;
    }

    public static void setNovaPostava(Postava novaPostava) {
        PostavaLogika.novaPostava = novaPostava;
    }


//== OTHER NON-PRIVATE CLASS METHODS ===========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================



//##############################################################################
//== CONSTANT INSTANCE ATTRIBUTES ==============================================

    // hlavička
    private final StringProperty nazevProperty = new SimpleStringProperty();

    private final StringProperty rasaProperty = new SimpleStringProperty();

    private final StringProperty povolaniProperty = new SimpleStringProperty();

    private final ObjectProperty<Integer> urovenProperty = new SimpleObjectProperty<>();

    private final StringProperty zkusenostiProperty = new SimpleStringProperty();

    private final StringProperty zkusenostiNaDalsiUrovenProperty =
            new SimpleStringProperty();

    private final StringProperty zivotyProperty = new SimpleStringProperty();

    private final StringProperty magyProperty = new SimpleStringProperty();

    private final StringProperty vyskaProperty = new SimpleStringProperty();

    private final StringProperty vahaProperty = new SimpleStringProperty();

    // vlastnosti
    private final StringProperty silaProperty = new SimpleStringProperty();

    private final StringProperty silaBonusProperty = new SimpleStringProperty();

    private final StringProperty obratnostProperty = new SimpleStringProperty();

    private final StringProperty obratnostBonusProperty = new SimpleStringProperty();

    private final StringProperty odolnostProperty = new SimpleStringProperty();

    private final StringProperty odolnostBonusProperty = new SimpleStringProperty();

    private final StringProperty inteligenceProperty = new SimpleStringProperty();

    private final StringProperty inteligenceBonusProperty = new SimpleStringProperty();

    private final StringProperty charismaProperty = new SimpleStringProperty();

    private final StringProperty charismaBonusProperty = new SimpleStringProperty();

    private final StringProperty pohyblivostProperty = new SimpleStringProperty();

    private final StringProperty pohyblivostBonusProperty = new SimpleStringProperty();

    private final StringProperty velikostProperty = new SimpleStringProperty();

    // výzbroj
    private final ObjectProperty<ObservableList<Odkaz>> zbranTVTProperty = new SimpleObjectProperty<>();

    private final ObjectProperty<Odkaz> zbranSAVProperty = new SimpleObjectProperty<>();

    private final ObjectProperty<Odkaz> zbrojProperty = new SimpleObjectProperty<>();

    // zvláštní schopnosti, kouzla, výbava, poznámka
    // private final ObjectProperty<Odkaz> zvlProperty = new SimpleObjectProperty<>();

    private final ObservableList<Odkaz> zvlProperty =
            FXCollections.observableArrayList();

    private final ObjectProperty<Odkaz> kouzlaProperty = new SimpleObjectProperty<>();

    private final ObjectProperty<Odkaz> vybavaProperty = new SimpleObjectProperty<>();

    private final StringProperty popisProperty = new SimpleStringProperty();


//== VARIABLE INSTANCE ATTRIBUTES ==============================================

    // hodnoty v Comboboxu úroveň
    private final ObservableList<Integer> urovenObservableList =
    FXCollections.observableArrayList();

    private final ObservableList<Odkaz> zbranTVTObservableList =
    FXCollections.observableArrayList();

    private final ObservableList<Odkaz> zbranSAVObservableList =
    FXCollections.observableArrayList();

    private final ObservableList<Odkaz> zbrojObservableList =
    FXCollections.observableArrayList();

    private final ObservableList<Odkaz> zvlSchObservableList =
    FXCollections.observableArrayList();

    private final ObservableList<Odkaz> kouzlaObservableList =
    FXCollections.observableArrayList();

    private final ObservableList<Odkaz> vybavaObservableList =
    FXCollections.observableArrayList();







    GetData getData = new GetData();



//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================
    /***************************************************************************
     *
     */
    public PostavaLogika() {
        init();
    }

//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    public StringProperty nazevProperty() {
        return nazevProperty;
    }

    public StringProperty rasaProperty()  {
        return rasaProperty;
    }

    public StringProperty povolaniProperty() {
        return povolaniProperty;
    }

    public ObjectProperty<Integer> urovenProperty() {
        return urovenProperty;
    }

    public StringProperty zkusenostiProperty() {
        return zkusenostiProperty;
    }

    public StringProperty zkusenostiNaDalsiUrovenProperty() {
        return zkusenostiNaDalsiUrovenProperty;
    }

    public StringProperty zivotyProperty() {
        return zivotyProperty;
    }

    public StringProperty magyProperty() {
        return magyProperty;
    }

    public StringProperty vyskaProperty() {
        return vyskaProperty;
    }

    public StringProperty vahaProperty() {
        return vahaProperty;
    }

    public StringProperty silaProperty() {
        return silaProperty;
    }

    public StringProperty silaBonusProperty() {
        return silaBonusProperty;
    }

    public StringProperty obratnostProperty() {
        return obratnostProperty;
    }

    public StringProperty obratnostBonusProperty() {
        return obratnostBonusProperty;
    }

    public StringProperty odolnostProperty() {
        return odolnostProperty;
    }

    public StringProperty odolnostBonusProperty() {
        return odolnostBonusProperty;
    }

    public StringProperty inteligenceProperty() {
        return inteligenceProperty;
    }

    public StringProperty inteligenceBonusProperty() {
        return inteligenceBonusProperty;
    }

    public StringProperty charismaProperty() {
        return charismaProperty;
    }

    public StringProperty charismaBonusProperty() {
        return charismaBonusProperty;
    }

    public StringProperty pohyblivostProperty() {
        return pohyblivostProperty;
    }

    public StringProperty pohyblivostBonusProperty() {
        return pohyblivostBonusProperty;
    }

    public StringProperty velikostProperty() {
        return velikostProperty;
    }

//    public ObjectProperty<ObservableList<Odkaz>> zbranTVTProperty() {
//        return zbranTVTProperty;
//    }
//
//    public ObjectProperty<Odkaz> zbranSAVProperty() {
//        return zbranSAVProperty;
//    }
//
//    public ObjectProperty<Odkaz> zbrojProperty() {
//        return zbrojProperty;
//    }
//
//    public ObservableList<Odkaz> zvlProperty() {
//        return zvlProperty;
//    }
//
//    public ObjectProperty<String> kouzlaProperty() {
//        return kouzlaProperty;
//    }
//
//    public ObjectProperty<Odkaz> vybavaProperty() {
//        return vybavaProperty;
//    }

    public StringProperty popisProperty() {
        return popisProperty;
    }

    public ObservableList<Integer> getUrovenList() {
        return urovenObservableList;
    }

    public ObservableList<Odkaz> getZbranTVTList() {
        return zbranTVTObservableList;
    }

    public ObservableList<Odkaz> getZbranSAVList() {
        return zbranSAVObservableList;
    }

    public ObservableList<Odkaz> getZbrojList() {
        return zbrojObservableList;
    }

    public ObservableList<Odkaz> getZvlSchList() {
        return zvlSchObservableList;
    }

    public ObservableList<Odkaz> getKouzlaList() {
        return kouzlaObservableList;
    }

    public ObservableList<Odkaz> getVybavaList() {
        return vybavaObservableList;
    }








//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /**
     * Dotáže se, zda se položka upravuje, nebo vkládá nová a podle toho buď nechá
     * formulář prázdný, nebo se dotáže na příslušnou položku z databáze a vloží
     * ji do formuláře
     */
    public void naplnFormular() {
        Postava postava = pridatNeboUpravit();
        if (postava != null) {

            nazevProperty.set(postava.getNazev());
            rasaProperty.set(postava.getRasa());
            povolaniProperty.set(postava.getPovolani());
            urovenProperty.set(postava.getUroven());
            zkusenostiProperty.set(postava.getZkusenostiString());
            // TODO zkusenostiNaDalsiUrovenProperty.set(value);
            zivotyProperty.set(postava.getZivotyString());
            magyProperty.set(postava.getMagyString());
            // TODO vyskaProperty.set(postava.getVyskaString());
            // TODO vahaProperty.set(postava.getVahaString());
            silaProperty.set(postava.getSilaString());
            silaBonusProperty.set(urciBonus(postava.getSila()));
            obratnostProperty.set(postava.getObratnostString());
            obratnostBonusProperty.set(urciBonus(postava.getObratnost()));
            odolnostProperty.set(postava.getOdolnostString());
            odolnostBonusProperty.set(urciBonus(postava.getOdolnost()));
            inteligenceProperty.set(postava.getInteligenceString());
            inteligenceBonusProperty.set(urciBonus(postava.getInteligence()));
            charismaProperty.set(postava.getCharismaString());
            charismaBonusProperty.set(urciBonus(postava.getCharisma()));
            pohyblivostProperty.set(postava.getPohyblivost().getHodnotaString());
            pohyblivostBonusProperty.set(postava.getPohyblivost().getBonusString());




//            Vlastnosti vlastnosti = nestvura.getVlastnosti();
//            nazevProperty.set(nestvura.getNazev());
//            zivotaschopnostProperty.set(nestvura.getZivotaschopnostString());
//            konstantaZvtProperty.set(vyhodnotAVratString(nestvura.getKonstantaZvt()));
//            utokProperty.set(nestvura.getUtok());
//            obranaProperty.set(nestvura.getObranaString());
//            silaProperty.set(vyhodnotAVratString(nestvura.getSila()));
//            obratnostProperty.set(vyhodnotAVratString(nestvura.getObratnost()));
//            odolnostProperty.set(vyhodnotAVratString(nestvura.getOdolnost()));
//            inteligenceProperty.set(vyhodnotAVratString(nestvura.getInteligence()));
//            charismaProperty.set(vyhodnotAVratString(nestvura.getCharisma()));
//            nastavVelikost(nestvura);
//            bojovnostObjectProperty.set(urciBojovnost(nestvura));
//            nastavZranitelnost(nestvura);
//            skupinyZranitelnostProperty.set(nestvura.getSkupinaZranitelnost());
//            hodnotyPohyblivostObjectProperty.set(vyhodnotAVratString(nestvura
//                                                .getPohyblivost().getHodnota()));
//            nastavSkupinuPohyblivost(nestvura);
//            hodnotyVytrvalostObjectProperty.set(vyhodnotAVratString(nestvura
//                                                .getVytrvalost().getHodnota()));
//            nastavSkupinuVytrvalost(nestvura);
//            manevrSchopnostProperty.set(vyhodnotAVratString(nestvura.getManevrSchopnost()));
//            zaklSilaMysliProperty.set(urciZaklSiluMysli(nestvura));
//            ochoceniProperty.set(vyhodnotAVratString(nestvura.getOchoceni()));
//            nastavPresvedceni(nestvura);
//            pokladyProperty.set(urciPoklady(nestvura.getPoklady()));
//            zkusenostiProperty.set(String.valueOf(nestvura.getZkusenost()));
//            popisProperty.set(nestvura.getPoznamka());
        }
    }


//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================

    private void init() {

        // uloží hodnoty úrovní do ObservableList uroven -> urovenComboBox
        urovenObservableList.clear();
        for (int i : Postava.UROVEN) urovenObservableList.add(i);

    }

    /** Vrátí bonus včetně znaménka pro hodnoty 1-50, jinak vrátí null. */
    private String urciBonus(Integer vlastnost) {
        return Vlastnost.getBonus(vlastnost);
    }

    /** Vrátí instanci upravované postavy, v případě přidání nové vrátí novaPostava */
    private Postava pridatNeboUpravit() {
        if (novaPostava != null) return novaPostava;
        Integer id = vratIdOdkazu();
        if (id != null) {
            return getData.getPostava(id);
        } else return null;
    }


//##############################################################################
//== NESTED DATA TYPES =========================================================
}
