/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package drdhelp.model.logika;

import drdhelp.model.Odkaz;
import drdhelp.model.Postava;
import drdhelp.model.Postava.MagickaPovolani;
import drdhelp.model.Povolani;
import drdhelp.model.Rasa;
import drdhelp.model.Vlastnost;
import drdhelp.model.io.DataIn;
import drdhelp.model.io.DataOut;
import java.util.ArrayList;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



/*******************************************************************************
 * Instance třídy {@code NovaPostavaLogika} představují logiku formuláře
 * NovaPostava.
 *
 * @author  Michal Remišovský
 * @version 0.00.0000 — 2017-02-03
 */
public class NovaPostavaLogika extends Logika {

//== CONSTANT CLASS ATTRIBUTES =================================================
//== VARIABLE CLASS ATTRIBUTES =================================================



//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CLASS TERS AND SETTERS ====================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================



//##############################################################################
//== CONSTANT INSTANCE ATTRIBUTES ==============================================

    private final StringProperty nazevProperty = new SimpleStringProperty();

    private final BooleanProperty nazevChybaVisibleProperty =
            new SimpleBooleanProperty();

    private final ObjectProperty<Odkaz> rasaProperty = new SimpleObjectProperty<>();

    private final StringProperty velikostProperty = new SimpleStringProperty();

    private final StringProperty rodovaZbranProperty = new SimpleStringProperty();

    private final ObjectProperty<Odkaz> povolaniProperty =
            new SimpleObjectProperty<>();

    private final StringProperty vyskaProperty = new SimpleStringProperty();

    private final SimpleStringProperty vyskaChybaProperty =
    new SimpleStringProperty();

    private final BooleanProperty vyskaChybaVisibleProperty =
    new SimpleBooleanProperty();

    private final StringProperty vahaProperty = new SimpleStringProperty();

    private final SimpleStringProperty vahaChybaProperty =
    new SimpleStringProperty();

    private final BooleanProperty vahaChybaVisibleProperty =
    new SimpleBooleanProperty();

    private final ObjectProperty<Integer> silaProperty =
    new SimpleObjectProperty<>();

    private final StringProperty silaBonusProperty = new SimpleStringProperty();

    private final ObjectProperty<Integer> obratnostProperty =
            new SimpleObjectProperty<>();

    private final StringProperty obratnostBonusProperty = new SimpleStringProperty();

    private final ObjectProperty<Integer> odolnostProperty =
            new SimpleObjectProperty<>();

    private final StringProperty odolnostBonusProperty = new SimpleStringProperty();

    private final ObjectProperty<Integer> inteligenceProperty =
            new SimpleObjectProperty<>();

    private final StringProperty inteligenceBonusProperty =
    new SimpleStringProperty();

    private final ObjectProperty<Integer> charismaProperty =
            new SimpleObjectProperty<>();

    private final StringProperty charismaBonusProperty = new SimpleStringProperty();

    private final StringProperty pohyblivostProperty = new SimpleStringProperty();

    private final StringProperty pohyblivostBonusProperty =
    new SimpleStringProperty();

    private final BooleanProperty jeVybranaRasaAPovolani =
    new SimpleBooleanProperty(false);

    private final BooleanProperty validProperty = new SimpleBooleanProperty(false);



//== VARIABLE INSTANCE ATTRIBUTES ==============================================

    // rasa nové postavy
    private Rasa rasa;

    // povolání nové postavy
    private Povolani povolani;

    // meze výšky nové postavy
    private int vyskaPostavyMin;
    private int vyskaPostavyMax;

    // meze váhy nové postavy
    private int vahaPostavyMin;
    private int vahaPostavyMax;

    // intervaly vlastností ve tvaru int[2][5] - počet k6(int[0]) + konstanta(int[1])
    private int[][] vlastnostiVPoliMinAMax;

    // hodnoty vlastností v Comboxech
    private final ObservableList<Integer> sila = FXCollections.observableArrayList();
    private final ObservableList<Integer> obratnost = FXCollections.observableArrayList();
    private final ObservableList<Integer> odolnost = FXCollections.observableArrayList();
    private final ObservableList<Integer> inteligence = FXCollections.observableArrayList();
    private final ObservableList<Integer> charisma = FXCollections.observableArrayList();

    // datový model pro čtení z databáze
    DataOut dataOut = new DataOut();
    DataIn dataIn = new DataIn();


//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     *
     */
    public NovaPostavaLogika() {
        init();
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    public StringProperty nazevProperty() {
        return nazevProperty;
    }

    public BooleanProperty nazevChybaVisibleProperty() {
        return nazevChybaVisibleProperty;
    }

    public ObjectProperty<Odkaz> rasaProperty() {
        return rasaProperty;
    }

    public StringProperty velikostProperty() {
        return velikostProperty;
    }

    public StringProperty rodovaZbranProperty() {
        return rodovaZbranProperty;
    }

    public ObjectProperty<Odkaz> povolaniProperty() {
        return povolaniProperty;
    }

    public StringProperty vyskaProperty() {
        return vyskaProperty;
    }

    public SimpleStringProperty vyskaChybaProperty() {
        return vyskaChybaProperty;
    }

    public BooleanProperty vyskaChybaVisibleProperty() {
        return vyskaChybaVisibleProperty;
    }

    public StringProperty vahaProperty() {
        return vahaProperty;
    }

    public SimpleStringProperty vahaChybaProperty() {
        return vahaChybaProperty;
    }

    public BooleanProperty vahaChybaVisibleProperty() {
        return vahaChybaVisibleProperty;
    }

    public ObjectProperty<Integer> silaProperty() {
        return silaProperty;
    }

    public StringProperty silaBonusProperty() {
        return silaBonusProperty;
    }

    public ObjectProperty<Integer> obratnostProperty() {
        return obratnostProperty;
    }

    public StringProperty obratnostBonusProperty() {
        return obratnostBonusProperty;
    }

    public ObjectProperty<Integer> odolnostProperty() {
        return odolnostProperty;
    }

    public StringProperty odolnostBonusProperty() {
        return odolnostBonusProperty;
    }

    public ObjectProperty<Integer> inteligenceProperty() {
        return inteligenceProperty;
    }

    public StringProperty inteligenceBonusProperty() {
        return inteligenceBonusProperty;
    }

    public ObjectProperty<Integer> charismaProperty() {
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

    public BooleanProperty jeVybranaRasaAPovolani() {
        return jeVybranaRasaAPovolani;
    }

    public BooleanProperty validProperty() {
        return validProperty;
    }

    public ObservableList<Integer> getSila() {
        return sila;
    }

    public ObservableList<Integer> getObratnost() {
        return obratnost;
    }

    public ObservableList<Integer> getOdolnost() {
        return odolnost;
    }

    public ObservableList<Integer> getInteligence() {
        return inteligence;
    }

    public ObservableList<Integer> getCharisma() {
        return charisma;
    }

    public int getSilaMin() {
        return vlastnostiVPoliMinAMax[0][0];
    }

    public int getSilaMax() {
        return vlastnostiVPoliMinAMax[1][0];
    }

    public int getObratnostMin() {
        return vlastnostiVPoliMinAMax[0][1];
    }

    public int getObratnostMax() {
        return vlastnostiVPoliMinAMax[1][1];
    }
    public int getOdolnostMin() {
        return vlastnostiVPoliMinAMax[0][2];
    }

    public int getOdolnostMax() {
        return vlastnostiVPoliMinAMax[1][2];
    }
    public int getInteligenceMin() {
        return vlastnostiVPoliMinAMax[0][3];
    }

    public int getInteligenceMax() {
        return vlastnostiVPoliMinAMax[1][3];
    }
    public int getCharismaMin() {
        return vlastnostiVPoliMinAMax[0][4];
    }

    public int getCharismaMax() {
        return vlastnostiVPoliMinAMax[1][4];
    }


//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    public boolean jeFormularValidni() {
        return jeNazevValidni() && jeRasaValidni() && jePovolaniValidni()
               && jeVlastnostiValidni() && jeVyskaValidni() && jeVahaValidni();
    }

    public void nastavNahodneVlastnosti() {
        Integer[] nahodneVlastnosti = generujNahodneVlastnosti(
                vlastnostiKostkyAKonstanty());

        nastavVlastnosti(nahodneVlastnosti);
    }

    /** Logika tlačítka Poklačuj. */
    public void pokracujLogika() {
        PostavaLogika.setNovaPostava(nactiZFormulare());
    }

    /** Logika tlačítka Odejít - nastaví statickou proměnnou nová postava na null. */
    public void odejitLogika() {
        PostavaLogika.setNovaPostava(null);
    }

//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================

    /**
     * Vrátí vlastnosti podle rasy a povolání ve formě intervalu - dolní
     * až horní mez pro každou vlastnost
     *
     * @param rasa Rasa
     * @param povolani Povolání
     * @param opravy Opravy vlastností podle rasy.
     * @return 2D Pole int, v prvním rozmětu minimum, ve druhém maximum.
     */
    private int[][] vlastnostiVPoliMinAMax(Rasa rasa, Povolani povolani) {
        int[] opravy = rasa.getOpravy();
        int[][] vlastnostiRasy = rasa.getVlastnosti();
        int delka = vlastnostiRasy[0].length;
        int[][] vlastnostiPovolani = povolani.getVlastnosti();
        int[][] vlastnostiNovePostavy = new int[2][5];

        // Výběr vlastností. Pokud se jedná o základní vlastnost povolání,
        // je zvolena ta. V opčaném případě je použita vlastnost rasy.
        // U vlastnosti povolání se ke konstantě přičte oprava za rasu.
        for (int i = 0; i < delka; i++) {
            if (vlastnostiPovolani[0][i] > 0) {
                vlastnostiNovePostavy[0][i] = vlastnostiPovolani[0][i] + opravy[i];
                vlastnostiNovePostavy[1][i] = vlastnostiPovolani[1][i] + opravy[i];
            }
            else {
                vlastnostiNovePostavy[0][i] = vlastnostiRasy[0][i];
                vlastnostiNovePostavy[1][i] = vlastnostiRasy[1][i];
            }
        }
        return vlastnostiNovePostavy;
    }

    /** vrátí ArrayList s čísly od minima do maxima. */
    private ArrayList<Integer> vratArrayListPodleMezi(int minimum, int maximum) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i =  minimum; i <= maximum; i++) {
            list.add(i);
        }
        return list;
    }

    /**
     * Vygeneruje náhodně hodnoty vlastností Integer[].
     *
     * @param vlastnostiKostkyAKonstanty interval 2D pole vlastností int[][], první
     * rozměr udává počet k6, druhý konstantu.
     * @return Pole hodnot vlastností - výsledek "hodů" xk6 + konstanta.
     */
    private Integer[] generujNahodneVlastnosti(int[][] vlastnostiKostkyAKonstanty) {
        Integer[] pomocne = new Integer[vlastnostiKostkyAKonstanty[0].length];
        for (int i = 0; i < vlastnostiKostkyAKonstanty[0].length; i++) {
            pomocne[i] = Vlastnost.generujVlastnost(vlastnostiKostkyAKonstanty[0][i],
                    vlastnostiKostkyAKonstanty[1][i]);
        }
        return pomocne;
    }

        /**
         * Vrátí 2D pole 2x5 pro vlastnosti ve tvaru počet kostek, konstanta.
         * K určaní použije atribut instance int[][] vlastnostiVPolyMinAMax.
         */
    private int[][] vlastnostiKostkyAKonstanty() {
        int[][] vlastnostiList = new int[2][5];

        for (int i = 0; i <= 4; i++) {
            // minimum a maximum příslušné vlastnosti
            int minimum = vlastnostiVPoliMinAMax[0][i];
            int maximum = vlastnostiVPoliMinAMax[1][i];
            // určení počtu kostek a konstanty opravující hodnotu vlastnosti
            int pocetKostek = (maximum - minimum) / 5;
            int konstanta = minimum - pocetKostek;

            vlastnostiList[0][i] = pocetKostek;
            vlastnostiList[1][i] = konstanta;
        }
        return vlastnostiList;
    }

    private void init() {

        // rasa listener
        rasaProperty.addListener((ObservableValue<? extends Odkaz> observable,
                Odkaz oldValue, Odkaz newValue) -> {

            boolean validitaRasaAPovolani = nastavValidituRasaAPovolani();
            rasa = dataOut.getRasa(newValue.getId());

            nastavVyskuAVahu();

            if (rasa != null) {
                velikostProperty.set(rasa.getVelikost());
                rodovaZbranProperty.set(rasa.getRodovaZbran());
            }
            if (validitaRasaAPovolani) {
                nastavHodnotyVlastnosti();
                vynulujVlastnosti();
            }
            validProperty().set(jeFormularValidni());
        });

        // povolání listener
        povolaniProperty.addListener((ObservableValue<? extends Odkaz> observable,
                Odkaz oldValue, Odkaz newValue) -> {

            boolean validitaRasaAPovolani = nastavValidituRasaAPovolani();

            povolani = dataOut.getPovolani(newValue.getId());

            if (validitaRasaAPovolani) {
                nastavHodnotyVlastnosti();
                vynulujVlastnosti();
            }
            validProperty().set(jeFormularValidni());
        });

        // síla listener
        silaProperty.addListener((ObservableValue<? extends Integer> observable,
                Integer oldValue, Integer newValue) -> {

            silaBonusProperty.setValue(Vlastnost.getBonus(newValue));

            if (newValue != null && obratnostProperty.isNotNull().get()) {
                nastavPohyblivost();
            }
            validProperty().set(jeFormularValidni());
        });

        // obratnost listener
        obratnostProperty.addListener((ObservableValue<? extends Integer> observable,
                Integer oldValue, Integer newValue) -> {

            obratnostBonusProperty.setValue(Vlastnost.getBonus(newValue));

            if (newValue != null && silaProperty.isNotNull().get()) {
                nastavPohyblivost();
            }
            validProperty().set(jeFormularValidni());
        });

        // odolnost listener
        odolnostProperty.addListener((ObservableValue<? extends Integer> observable,
                Integer oldValue, Integer newValue) -> {

            odolnostBonusProperty.setValue(Vlastnost.getBonus(newValue));
            validProperty().set(jeFormularValidni());
        });

        // inteligence listener
        inteligenceProperty.addListener((ObservableValue<? extends Integer> observable,
                Integer oldValue, Integer newValue) -> {

            inteligenceBonusProperty.setValue(Vlastnost.getBonus(newValue));
            validProperty().set(jeFormularValidni());
        });

        // charisma listener
        charismaProperty.addListener((ObservableValue<? extends Integer> observable,
                Integer oldValue, Integer newValue) -> {

            charismaBonusProperty.setValue(Vlastnost.getBonus(newValue));
            validProperty().set(jeFormularValidni());
        });

        // listenery pro testování validity vstupů od uživatele
        nazevProperty.addListener((ObservableValue<? extends String> observable,
                String oldValue, String newValue) -> {
            nazevChybaVisibleProperty.set(!jeNazevValidni(newValue));
            validProperty().set(jeFormularValidni());
        });

        vyskaProperty.addListener((ObservableValue<? extends String> observable,
                String oldValue, String newValue) -> {
            vyskaChybaVisibleProperty.set(!jeVyskaValidni(newValue));
            validProperty().set(jeFormularValidni());
        });

        vahaProperty.addListener((ObservableValue<? extends String> observable,
                String oldValue, String newValue) -> {
            vahaChybaVisibleProperty.set(!jeVahaValidni(newValue));
            validProperty().set(jeFormularValidni());
        });
    }

    /** určí a vloží pohyblivost do příslušných Property -> TextFieldů */
    private void nastavPohyblivost() {
        Integer silaBonus = Integer.parseInt(silaBonusProperty.get());
        Integer obratnostBonus = Integer.parseInt(obratnostBonusProperty.get());

        Integer pohyblivost = rasa.getPohyblivost() + obratnostBonus + 2 * silaBonus;

        pohyblivostProperty.set(String.valueOf(pohyblivost));
        pohyblivostBonusProperty.setValue(Vlastnost.getBonus(pohyblivost));
    }

//    private void vypisPole(int[][] pole) {
//        int sirka = pole.length;
//        int delka = pole[0].length;
//        for (int i = 0; i < sirka; i++) {
//            for (int j = 0; j < delka; j++) {
//                System.out.print(pole[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }

    private boolean nastavValidituRasaAPovolani() {
        boolean validitaRasaAPovolani = jeRasaValidni() && jePovolaniValidni();
        jeVybranaRasaAPovolani.set(validitaRasaAPovolani);
        return validitaRasaAPovolani;
    }

    private boolean jeNazevValidni() {
        return jeStringValidni(nazevProperty.get(), 1, 50);
    }

    private boolean jeRasaValidni() {
        return rasaProperty.isNotNull().get();
    }

    private boolean jePovolaniValidni() {
        return povolaniProperty.isNotNull().get();
    }

    private boolean jeVlastnostiValidni() {
        return     silaProperty.isNotNull().get()
                && obratnostProperty.isNotNull().get()
                && odolnostProperty.isNotNull().get()
                && inteligenceProperty.isNotNull().get()
                && charismaProperty.isNotNull().get();
    }

    private boolean jeVyskaValidni() {
        return jeVyskaValidni(vyskaProperty.get());
    }

    private boolean jeVyskaValidni(String vyska) {
        return zvalidujStringCislo(vyska, vyskaPostavyMin, vyskaPostavyMax);
    }

    private boolean jeVahaValidni() {
        return jeVahaValidni(vahaProperty.get());
    }

    private boolean jeVahaValidni(String vaha) {
        return zvalidujStringCislo(vaha, vahaPostavyMin, vahaPostavyMax);
    }

    private void nastavVyskuAVahu() {
        int[] vyska = rasa.getVyska();
        vyskaPostavyMin = vyska[0];
        vyskaPostavyMax = vyska[1];

        int[] vaha = rasa.getVaha();
        vahaPostavyMin = vaha[0];
        vahaPostavyMax = vaha[1];

        vyskaChybaProperty().set("Zadejte číslo " + vyskaPostavyMin + " až "
         + vyskaPostavyMax + "!");

        vahaChybaProperty().set("Zadejte číslo " + vahaPostavyMin + " až "
         + vahaPostavyMax + "!");
    }

        /** Kouzlí postava? ano/ne - true/false. */
    private boolean postavaKouzli(String povolani) {
        for (MagickaPovolani m : MagickaPovolani.values()) {
            if (povolani.equals(m.toString())) {
                return true;
            }
        }
        return false;
    }



    /** Nastaví vlastnosti do příslušných ObservableListů -> ComboBoxů. */
    private void nastavHodnotyVlastnosti() {
        vlastnostiVPoliMinAMax = vlastnostiVPoliMinAMax(rasa, povolani);
        sila.setAll(vratArrayListPodleMezi(getSilaMin(), getSilaMax()));
        obratnost.setAll(vratArrayListPodleMezi(getObratnostMin(), getObratnostMax()));
        odolnost.setAll(vratArrayListPodleMezi(getOdolnostMin(), getOdolnostMax()));
        inteligence.setAll(vratArrayListPodleMezi(getInteligenceMin(), getInteligenceMax()));
        charisma.setAll(vratArrayListPodleMezi(getCharismaMin(), getCharismaMax()));
    }

    /** Nastaví vlastnosti pomocí propherty do příslušných Comboboxů s vlastnostmi */
    private void nastavVlastnosti(Integer[] vlastnosti) {
        silaProperty.setValue(vlastnosti[0]);
        obratnostProperty.setValue(vlastnosti[1]);
        odolnostProperty.setValue(vlastnosti[2]);
        inteligenceProperty.setValue(vlastnosti[3]);
        charismaProperty.setValue(vlastnosti[4]);
    }

    /** Vynuluje ve formuláři vlastnosti a pohyblivost */
    private void vynulujVlastnosti() {
        silaProperty.setValue(null);
        obratnostProperty.setValue(null);
        odolnostProperty.setValue(null);
        inteligenceProperty.setValue(null);
        charismaProperty.setValue(null);
        pohyblivostProperty.setValue(null);
        pohyblivostBonusProperty.setValue(null);
    }


    private Postava nactiZFormulare() {

        String povolani = povolaniProperty.get().getNazev();
        System.out.println("NovaPostavaLogika.nactiZFormulare(): povolani:" + povolani + ".");

        Integer[] hodnotyVlastnosti = {silaProperty.get(),
                                   obratnostProperty.get(),
                                   odolnostProperty.get(),
                                   inteligenceProperty.get(),
                                   charismaProperty.get()};

        Vlastnost pohyblivost = new Vlastnost("Pohyblivost",
                Integer.parseInt(pohyblivostProperty.get()));

        Postava novaPostava = new Postava(nazevProperty.get(),
                                        rasa.getNazev(),
                                        povolani,
                                        postavaKouzli(povolani),
                                        Integer.parseInt(vyskaProperty.get()),
                                        Integer.parseInt(vahaProperty.get()),
                                        hodnotyVlastnosti,
                                        pohyblivost,
                                        velikostProperty.get(),
                                        rodovaZbranProperty.get());
        return novaPostava;
    }


//##############################################################################
//== NESTED DATA TYPES =========================================================

}
