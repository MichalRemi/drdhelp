/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package drdhelp.model.logika;

import drdhelp.model.Odkaz;
import drdhelp.model.Postava;
import drdhelp.model.TabulkaDB;
import drdhelp.model.Vlastnost;
import drdhelp.model.io.DataIn;
import drdhelp.model.io.DataOut;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;





/*******************************************************************************
 * Instance třídy {@code PostavaLogika} představují logiku formuláře Postava.fxml.
 *
 * @author  Michal Remišovský
 * @version 0.01.0000 — 2017-04-15
 */
public class PostavaLogika extends Logika {

//== CONSTANT CLASS ATTRIBUTES =================================================

//== VARIABLE CLASS ATTRIBUTES =================================================

    private static Postava novaPostava = null;
    private static Postava aktualniPostava = null;

    private static boolean postavaKouzli = false;

    private final static String STYL_CHYBA = "-fx-effect: dropshadow(three-pass-box," +
            " red, 2, 1, 0, 0)";

    private static ArrayList<Odkaz> polozkyPostavy = new ArrayList<>();
    private static ArrayList<Odkaz> seznamPolozek = new ArrayList<>();

    private static FormularPridej textyFormulare;

    private static ObservableList<Odkaz> pridanyObservableList =
            FXCollections.observableArrayList();



//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CLASS GETTERS AND SETTERS =================================================


    public static Postava getNovaPostava() {
        return novaPostava;
    }

    public static void setNovaPostava(Postava novaPostava) {
        PostavaLogika.novaPostava = novaPostava;
    }

    public static ArrayList<Odkaz> getPolozkyPostavy() {
        return polozkyPostavy;
    }

    public static void setPolozkyPostavy(ArrayList<Odkaz> list) {
        PostavaLogika.polozkyPostavy.clear();
        PostavaLogika.polozkyPostavy.addAll(list);
    }

    public static ArrayList<Odkaz> getSeznamPolozek() {
        return seznamPolozek;
    }

    public static boolean getPostavaKouzli() {
        return postavaKouzli;
    }

    public static ObservableList<Odkaz> getPridanyObservableList() {
        return pridanyObservableList;
    }

    protected static void setPridanyObservableList(ObservableList<Odkaz>
                                                   pridanyList) {
        pridanyObservableList.setAll(pridanyList);
    }

    public static FormularPridej getTextyFormulare() {
        return textyFormulare;
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

    private final StringProperty zkusenostiStyleProperty = new SimpleStringProperty();

    private final StringProperty zkusenostiNaDalsiUrovenProperty =
            new SimpleStringProperty();

    private final StringProperty zivotyProperty = new SimpleStringProperty();

    private final StringProperty zivotyStyleProperty = new SimpleStringProperty();

    private final StringProperty magyProperty = new SimpleStringProperty();

    private final StringProperty magyStyleProperty = new SimpleStringProperty();

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
    private final ObjectProperty<ObservableList<Odkaz>> zbranTVTProperty =
            new SimpleObjectProperty<>();

    private final ObjectProperty<Odkaz> zbranSAVProperty =
            new SimpleObjectProperty<>();

    private final ObjectProperty<Odkaz> zbrojProperty = new SimpleObjectProperty<>();

    // zvláštní schopnosti, kouzla, výbava, poznámka
    private final ObservableList<String> zvlProperty =
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


    DataOut dataOut = new DataOut();
    DataIn dataIn = new DataIn();



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

    public StringProperty zkusenostiStyleProperty() {
        return zkusenostiStyleProperty;
    }

    public StringProperty zkusenostiNaDalsiUrovenProperty() {
        return zkusenostiNaDalsiUrovenProperty;
    }

    public StringProperty zivotyProperty() {
        return zivotyProperty;
    }

    public StringProperty zivotyStyleProperty() {
        return zivotyStyleProperty;
    }

    public StringProperty magyProperty() {
        return magyProperty;
    }

    public StringProperty magyStyleProperty() {
        return magyStyleProperty;
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

    public StringProperty popisProperty() {
        return popisProperty;
    }


//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    public boolean jeFormularValidni() {
        return jeZkusenostiValidni() && jeZivotyValidni() && jeMagyValidni();
    }

    /**
     * Dotáže se, zda se položka upravuje, nebo vkládá nová a podle toho buď nechá
     * formulář prázdný, nebo se dotáže na příslušnou položku z databáze a vloží
     * ji do formuláře
     */
    public void naplnFormular() {
        Postava postava = aktualniPostava;
        if (postava != null) {
            String povolani = postava.getPovolani();
            int uroven = postava.getUroven();
            nazevProperty.set(postava.getNazev());
            rasaProperty.set(postava.getRasa());
            povolaniProperty.set(postava.getPovolani());
            urovenProperty.set(postava.getUroven());
            zkusenostiProperty.set(postava.getZkusenostiString());
            zkusenostiNaDalsiUrovenProperty.set(postava.urciZkusenostiNaDalsiUroven());
            zivotyProperty.set(postava.getZivotyString());
            magyProperty.set(postava.getMagyString());
            vyskaProperty.set(postava.getVyskaString());
            vahaProperty.set(postava.getVahaString());
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
            velikostProperty.set(postava.getVelikost());

            if (postava.getZbranTVT() != null) {
                zbranTVTObservableList.setAll(postava.getZbranTVT());
            }

            if (postava.getZbranSAV() != null) {
                zbranSAVObservableList.setAll(postava.getZbranSAV());
            }

            if (postava.getZbroj() != null) {
                zbrojObservableList.setAll(postava.getZbroj());
            }

            if (postava.getZvlastniSchopnosti() != null) {
                zvlSchObservableList.setAll(postava.getZvlastniSchopnosti());
            }

            if (postava.getKouzla() != null) {
                kouzlaObservableList.setAll(postava.getKouzla());
            }

            if (postava.getKouzla() != null) {
                kouzlaObservableList.setAll(postava.getPrirodniKouzla());
            }

            if (postava.getVybava() != null) {
                vybavaObservableList.setAll(postava.getVybava());
            }

            popisProperty.set(postava.getPoznamka());
        }
    }

    private void nastavPridejVybaveni(ObservableList<Odkaz> vybaveniList, String tabulka) {
        // Nastaví se upravovaný ObservableList vybavení postavy do obecného
        // ObservableListu, který se po vložení aktualizuje.
        pridanyObservableList = vybaveniList;
        polozkyPostavy.clear();
        polozkyPostavy.addAll(vybaveniList);
        seznamPolozek.clear();
        ArrayList<Odkaz> list = dataOut.nactiOdkazy(tabulka);
        if (list != null) {
            seznamPolozek.addAll(dataOut.nactiOdkazy(tabulka));
        }
    }

    public void nastavPridejZbranTVT() {
        nastavPridejVybaveni(zbranTVTObservableList, TabulkaDB.ZBRAN_TVT.getTabNazev());
        textyFormulare = FormularPridej.ZBRAN_TVT;
    }

    public void nastavPridejZbranSAV() {
        nastavPridejVybaveni(zbranSAVObservableList, TabulkaDB.ZBRAN_SAV.getTabNazev());
        textyFormulare = FormularPridej.ZBRAN_SAV;
    }

    public void nastavPridejZbroj() {
        nastavPridejVybaveni(zbrojObservableList, TabulkaDB.ZBROJ.getTabNazev());
        textyFormulare = FormularPridej.ZBROJ;
    }

    public void nastavPridejZvlSchopnost() {
        // Nastaví se upravovaný ObservableList zvláštních schopností postavy do
        // obecného ObservableListu, který se po vložení aktualizuje.
        pridanyObservableList = zvlSchObservableList;

        // seznam položek pro přidání postavě
        String povolani = povolaniProperty.get();
        String rasa = rasaProperty.get();
        seznamPolozek.clear();
        seznamPolozek.addAll(dataOut.getZvlSchopnostiRasaAPovolani(rasa, povolani));

        // seznam zvláštních schopností postavy
        polozkyPostavy.clear();
        polozkyPostavy.addAll(zvlSchObservableList);

        textyFormulare = FormularPridej.ZVL_SCHOPNOSTI;
    }

    public void nastavPridejKouzlo() {
        // Nastaví se upravovaný ObservableList kouzel postavy do obecného
        // ObservableListu, který se po vložení aktualizuje.
        pridanyObservableList = kouzlaObservableList;
        seznamPolozek.clear();
        String povolani = povolaniProperty.get();
        String tabulka = null;
        if (povolani.equals("kouzelník")) tabulka = TabulkaDB.KOUZLO.getTabNazev();
        if (povolani.equals("hraničář")) tabulka = TabulkaDB.PRIRODNI_KOUZLO.getTabNazev();
        ArrayList<Odkaz> list = dataOut.nactiOdkazy(tabulka);
        if (list != null) {
            seznamPolozek.addAll(dataOut.nactiOdkazy(tabulka));
        }
        // seznam kouzel postavy
        polozkyPostavy.clear();
        polozkyPostavy.addAll(kouzlaObservableList);

        textyFormulare = FormularPridej.KOUZLA;
    }

    public void nastavPridejVybava() {
        nastavPridejVybaveni(vybavaObservableList, TabulkaDB.VYBAVA.getTabNazev());
        textyFormulare = FormularPridej.VYBAVA;
    }

    public void smazZbranTVT(Odkaz zbranTVT) {
        zbranTVTObservableList.remove(zbranTVT);
    }

    public void smazZbranSAV(Odkaz zbranSAV) {
        zbranSAVObservableList.remove(zbranSAV);
    }

    public void smazZbroj(Odkaz zbroj) {
        zbrojObservableList.remove(zbroj);
    }

    public void smazZvlSchopnost(Odkaz zvlSchopnost) {
        zvlSchObservableList.remove(zvlSchopnost);
    }

    public void smazKouzlo(Odkaz kouzlo) {
        kouzlaObservableList.remove(kouzlo);
    }

    public void smazVybava(Odkaz vybava) {
        vybavaObservableList.remove(vybava);
    }

    /**
     * Vyhodnotí, zda byly položky postavy vloženy, pokud ano, uloží změny
     * do příslušného ObservableListu.
     */
    public void zrusOdkazNaObservableList() {
        pridanyObservableList = null;
    }

    public void vlozUpraveneZbraneTVT() {
        zbranTVTObservableList.clear();
    }

    /** Logika tlačítka Odejít - nastaví statickou proměnnou nová postava na null. */
    public void odejitLogika() {
        PostavaLogika.setNovaPostava(null);
    }

    /**
     * Logika tlačítka Vložit. Podle odkazu ve statické proměnné SeznamOdkazu.upravit
     * určí, zda se vkládá nová položka (null), nebo upravuje (odkaz je na ní).
     * Zalová příslušnou metodu a předá ji obsah formuláře.
     */
    public void pridejPostavu() {
        Integer id = vratIdOdkazu();
        if (id != null) {
            dataIn.zmenPostava(nactiZFormulare(id));
        } else {
            dataIn.vlozPostava(nactiZFormulare(0));
        }
    }


//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================

    private void init() {

        // do proměnné aktualniPostava uloží novou nebo uprovavanou postavu,
        // podle toho, co uživatel zvolil
        novaNeboUpravitPostavu();

        // uloží se, zda postava kouzlí - kouzlící true, ostatví false
        PostavaLogika.postavaKouzli = aktualniPostava.isKouzli();

        // uloží hodnoty úrovní do ObservableList uroven -> urovenComboBox
        urovenObservableList.clear();
        for (int i : Postava.UROVEN) urovenObservableList.add(i);

        // nastaví zkušenosti na další úroveň -> uroveň, povolání
        urovenProperty.addListener((ObservableValue<? extends Integer>
                observable, Integer oldValue, Integer newValue) -> {
            String zkusenostiNaDalsi = getZkusenostiNaDalsiUroven(newValue,
                    povolaniProperty.get());
            zkusenostiNaDalsiUrovenProperty.set(zkusenostiNaDalsi);
            // zvaliduje zkušenosti na základě nové úrovně
            nastavZkusenosti();
        });

        // kontrola validitu zkušeností, životů a magů
        zkusenostiProperty.addListener((ObservableValue<? extends String>
                odservable, String oldValue, String newValue) -> {
            nastavZkusenosti();
        });

        zivotyProperty.addListener((ObservableValue<? extends String>
                odservable, String oldValue, String newValue) -> {
            nastavZivoty();
        });

        if (postavaKouzli) {
            magyProperty.addListener((ObservableValue<? extends String>
                    odservable, String oldValue, String newValue) -> {
                nastavMagy();
            });

        }
    }

    private String getZkusenostiNaDalsiUroven(Integer uroven, String povolani) {
        if (uroven != null) {
            if (uroven >= 1 && uroven <= 35) {
                int zkusenostiNaDalsi = dataOut.getZkusenosti(povolani, uroven + 1);
                return String.valueOf(zkusenostiNaDalsi);
            }
        }
        return "N/A";
    }

    /** Vrátí bonus včetně znaménka pro hodnoty 1-50, jinak vrátí null. */
    private String urciBonus(Integer vlastnost) {
        return Vlastnost.getBonus(vlastnost);
    }

    /** Uloží do aktualniPostava Postavu, buď novou, nebo upravovanou */
    private void novaNeboUpravitPostavu() {
        if (novaPostava != null) {
            aktualniPostava = novaPostava;
        }
        Integer id = vratIdOdkazu();
        if (id != null) {
            aktualniPostava = dataOut.getPostava(id);
        }
    }

    private void nastavZkusenosti() {
        if (!jeZkusenostiValidni()) {
            zkusenostiStyleProperty.set(STYL_CHYBA);
        } else zkusenostiStyleProperty.set(null);
    }

    private void nastavZivoty() {
        if (!jeZivotyValidni()) {
            zivotyStyleProperty.set(STYL_CHYBA);
        } else zivotyStyleProperty.set(null);
    }

    private void nastavMagy() {
        if (!jeMagyValidni()) {
            magyStyleProperty.set(STYL_CHYBA);
        } else magyStyleProperty.set(null);
    }

    public boolean jeZkusenostiValidni() {
        Integer uroven = urovenProperty.get();
        String povolani = povolaniProperty.get();
        if (uroven != 0 && povolani != null) {
            int zkusenosti = dataOut.getZkusenosti(povolani, uroven);
            int zkusenostiNaDalsi = dataOut.getZkusenosti(povolani, uroven + 1);
            String zkusenostiText = zkusenostiProperty.get();
            if (zkusenosti != -1 && zkusenostiNaDalsi != -1
                    && zkusenostiText != null) {
                return zvalidujStringCislo(zkusenostiText, zkusenosti,
                                                           zkusenostiNaDalsi);
            }
        }
        return false;
    }

    private boolean jeZivotyValidni() {
        String zivoty = zivotyProperty.get();
        return zvalidujStringCislo(zivoty, 0, 1000);
    }

    private boolean jeMagyValidni() {
        String magy = magyProperty.get();
        return zvalidujStringCislo(magy, 0, 1000);
    }

    private Postava nactiZFormulare(int id) {

        String povolani = povolaniProperty.get();

        // načtení magických atributů z formuláře
        Integer magy = 0;
        ArrayList<Odkaz> kouzla = new ArrayList<>();
        ArrayList<Odkaz> prirodniKouzla = new ArrayList<>();
        if (postavaKouzli) {
            magy = Integer.parseInt(magyProperty.get());
            // načtení kouzelnických kouzel z formuláře
            if (povolani.equals(Postava.MagickaPovolani.KOUZELNIK.getNazev())) {
                kouzla.addAll(kouzlaObservableList);
            } else {
                // načtení hranicarskych kouzel z formuláře
                if (povolani.equals(Postava.MagickaPovolani.HRANICAR.getNazev())) {
                prirodniKouzla.addAll(kouzlaObservableList);
                }
            }
        }

        Integer[] hodnotyVlastnosti = {vyhodnotAVratInt(silaProperty.get()),
                                    vyhodnotAVratInt(obratnostProperty.get()),
                                    vyhodnotAVratInt(odolnostProperty.get()),
                                    vyhodnotAVratInt(inteligenceProperty.get()),
                                    vyhodnotAVratInt(charismaProperty.get())};

        Vlastnost pohyblivost = new Vlastnost("Pohyblivost"
                ,vyhodnotAVratInt(pohyblivostProperty.get()));

        int intMagy;

        Postava postava = new Postava(
                id,
                nazevProperty.get(),
                rasaProperty.get(),
                povolaniProperty.get(),
                postavaKouzli,
                Integer.parseInt(zivotyProperty.get()),
                magy,
                urovenProperty.get(),
                Integer.parseInt(zkusenostiProperty.get()),
                hodnotyVlastnosti,
                pohyblivost,
                Integer.parseInt(vyskaProperty.get()),
                Integer.parseInt(vahaProperty.get()),
                observableListToArrayList(zbranTVTObservableList),
                observableListToArrayList(zbranSAVObservableList),
                observableListToArrayList(zbrojObservableList),
                observableListToArrayList(vybavaObservableList),
                aktualniPostava.getRodovaZbran(),
                aktualniPostava.getVelikost(),
                observableListToArrayList(zvlSchObservableList),
                kouzla,
                prirodniKouzla,
                popisProperty.get());

        return postava;

        }

    private ArrayList<Odkaz> observableListToArrayList(ObservableList<Odkaz> oList) {
        ArrayList<Odkaz> arrayList = new ArrayList<>();
        if (!oList.isEmpty()) {
            if (oList.get(0) instanceof Odkaz) {
                List<Odkaz> list = oList.stream().collect(Collectors.toList());
                arrayList.addAll(list);
            } else {
                System.err.println("PostavaLogika.observableListToArrayList():");
                System.err.println("Chybný argument, není ObservableList<Odkaz>/n");
            }
        }
        return arrayList;
    }


//##############################################################################
//== NESTED DATA TYPES =========================================================

    /** Slouží k určení labelů ve formuláři Pridej.fxml. */
    public enum FormularPridej {
        ZBRAN_TVT("Zbraně tváří v tvář", "seznam zbraní", "zbraně postavy"),
        ZBRAN_SAV("Zbraně střelná a vrhací", "seznam zbraní", "zbraně postavy"),
        ZBROJ("Zbroje a štíty", "seznam zbrojí a štítů", "zbroje a štíty postavy"),
        ZVL_SCHOPNOSTI("Zvláštní schopnosti", "dostupné zvl. schopnosti",
            "zvl. schopnosti postavy"),
        KOUZLA("Kouzla", "seznam dostupných kouzel", "kouzla postavy"),
        VYBAVA("Výbava", "seznam výbavy", "výbava postavy");

        private final String nazev;
        private final String seznamPolozek;
        private final String polozkyPostavy;

        // konstruktor
        FormularPridej(String nazev, String seznamPolozek, String polozkyPostavy ) {
            this.nazev = nazev;
            this.seznamPolozek = seznamPolozek;
            this.polozkyPostavy = polozkyPostavy;
        }

        // gettery a settery
        public String getPolozkyPostavy() {
            return polozkyPostavy;
        }

        public String getSeznamPolozek() {
            return seznamPolozek;
        }

        // public metody
        @Override
        public String toString() {
            return nazev;
        }
    }

}
