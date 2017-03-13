/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package drdhelp.model.logika;

import drdhelp.model.ZbranTVT;
import drdhelp.model.io.DataOut;
import drdhelp.model.io.DataIn;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;





/*******************************************************************************
 * Instance třídy {@code HlavniLogika} představují ...
 *
 * @author  Michal Remišovský
 * @version 0.03.0000 — 2016-12-02
 */
public class ZbranTVTLogika extends VybaveniLogika
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

    private final StringProperty nazevProperty = new SimpleStringProperty();

    private final ObjectProperty<Druh> druhObjectProperty =
            new SimpleObjectProperty<>();

    private final ObjectProperty<Drzeni> drzeniObjectProperty =
            new SimpleObjectProperty<>();

    private final StringProperty silaProperty = new SimpleStringProperty();

    private final StringProperty utocnostProperty = new SimpleStringProperty();

    private final StringProperty obranaProperty = new SimpleStringProperty();

    private final ObjectProperty<Delka> delkaObjectProperty =
            new SimpleObjectProperty<>();

    private final StringProperty vahaProperty = new SimpleStringProperty();

    private final StringProperty zlatakyProperty = new SimpleStringProperty();

    private final StringProperty stribrnakyProperty = new SimpleStringProperty();

    private final StringProperty medakyProperty = new SimpleStringProperty();

    private final StringProperty popisProperty = new SimpleStringProperty();


    private final BooleanProperty nazevChybaVisibleProperty =
    new SimpleBooleanProperty();

    private final BooleanProperty silaChybaVisibleProperty =
    new SimpleBooleanProperty();

    private final BooleanProperty utocnostChybaVisibleProperty =
    new SimpleBooleanProperty();

    private final BooleanProperty obranaChybaVisibleProperty =
    new SimpleBooleanProperty();

    private final BooleanProperty vahaChybaVisibleProperty =
    new SimpleBooleanProperty();

    private final BooleanProperty zlatakyChybaVisibleProperty =
    new SimpleBooleanProperty();

    private final BooleanProperty stribrnakyChybaVisibleProperty =
    new SimpleBooleanProperty();

    private final BooleanProperty medakyChybaVisibleProperty =
    new SimpleBooleanProperty();

    private final BooleanProperty valid = new SimpleBooleanProperty(false);

//== VARIABLE INSTANCE ATTRIBUTES ==============================================

    DataOut dataOut = new DataOut();
    DataIn dataIn = new DataIn();



//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     *
     */
    public ZbranTVTLogika() {
        init();
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    public StringProperty nazevProperty() {
        return nazevProperty;
    }
    public ObjectProperty<Druh> druhObjectProperty() {
        return druhObjectProperty;
    }
    public ObjectProperty<Drzeni> drzeniObjectProperty() {
        return drzeniObjectProperty;
    }
    public StringProperty silaProperty() {
        return silaProperty;
    }
    public StringProperty utocnostProperty() {
        return utocnostProperty;
    }
    public StringProperty obranaProperty() {
        return obranaProperty;
    }
    public ObjectProperty<Delka> delkaObjectProperty() {
        return delkaObjectProperty;
    }
    public StringProperty vahaProperty() {
        return vahaProperty;
    }
    public StringProperty zlatakyProperty() {
        return zlatakyProperty;
    }
    public StringProperty stribrnakyProperty() {
        return stribrnakyProperty;
    }
    public StringProperty medakyProperty() {
        return medakyProperty;
    }
    public StringProperty popisProperty() {
        return popisProperty;
    }

    public BooleanProperty nazevChybaVisibleProperty() {
        return nazevChybaVisibleProperty;
    }
    public BooleanProperty silaChybaVisibleProperty() {
        return silaChybaVisibleProperty;
    }
    public BooleanProperty utocnostChybaVisibleProperty() {
        return utocnostChybaVisibleProperty;
    }
        public BooleanProperty obranaChybaVisibleProperty() {
        return obranaChybaVisibleProperty;
    }
    public BooleanProperty vahaChybaVisibleProperty() {
        return vahaChybaVisibleProperty;
    }
    public BooleanProperty zlatakyChybaVisibleProperty() {
        return zlatakyChybaVisibleProperty;
    }
    public BooleanProperty stribrnakyChybaVisibleProperty() {
        return stribrnakyChybaVisibleProperty;
    }
    public BooleanProperty medakyChybaVisibleProperty() {
        return medakyChybaVisibleProperty;
    }
    public BooleanProperty validProperty() {
        return valid;
    }



//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /** Jsou všechny položky formuláře validní? */
    public boolean jeFormularValidni() {
        return jeNazevValidni() && jeDruhValidni() && jeDrzeniValidni()
               && jeSilaValidni() && jeUtocnostValidni() && jeObranaValidni()
               && jeDelkaValidni() && jeVahaValidni() && jeCenaValidni();
    }

    /**
     * Dotáže se, zda se položka upravuje, nebo vkládá nová a podle toho buď nechá
     * formulář prázdný, nebo se dotáže na příslušnou položku z databáze a vloží
     * ji do formuláře
     */
    public void naplnFormular() {
        ZbranTVT zbranTVT = pridatNeboUpravit();
        if (zbranTVT != null) {
            nazevProperty.set(zbranTVT.getNazev());
            nastavDruh(zbranTVT);
            nastavDrzeni(zbranTVT);
            silaProperty.set(String.valueOf(zbranTVT.getSila()));
            utocnostProperty.set(String.valueOf(zbranTVT.getUtocnost()));
            obranaProperty.set(String.valueOf(zbranTVT.getObrana()));
            nastavDelku(zbranTVT);
            vahaProperty.set(String.valueOf(zbranTVT.getVaha()));
            zlatakyProperty.set(String.valueOf(zbranTVT.getZlataky()));
            stribrnakyProperty.set(String.valueOf(zbranTVT.getStribrnaky()));
            medakyProperty.set(String.valueOf(zbranTVT.getMedaky()));
            popisProperty.set(zbranTVT.getPopis());
        }
    }

    /**
     * Logika tlačítka Vložit. Podle odkazu ve statické proměnné SeznamOdkazu.upravit
     * určí, zda se vkládá nová položka (null), nebo upravuje (odkaz je na ní).
     * Zalová příslušnou metodu a předá ji obsah formuláře.
     */
    public void pridejZbranTVT() {
        Integer id = vratIdOdkazu();
        if (id != null) {
            dataIn.zmenZbranTVT(nactiZFormulare(id));
        } else {
            dataIn.vlozZbranTVT(nactiZFormulare(0));
        }
    }


//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================

    /**
     * Nastaví druh předané zbraně TvT v druhCombobox, pokud hodnota odpovídá
     * enum Druh
     */
    private void nastavDruh(ZbranTVT zbranTVT) {
        String druh = zbranTVT.getDruh();
        if (druh != null) {
            for (Druh d : Druh.values()) {
                if (druh.equals(d.toString())) {
                    druhObjectProperty.set(d);
                }
            }
        }
    }

    /**
     * Nastaví drzeni předané zbraně TvT v typCombobox, pokud hodnota odpovídá
     * enum Drzeni.
     */
    private void nastavDrzeni(ZbranTVT zbranTVT) {
        String typ = zbranTVT.getDrzeni();
        if (typ != null) {
            for (Drzeni d : Drzeni.values()) {
                if (typ.equals(d.toString())) {
                    drzeniObjectProperty.set(d);
                }
            }
        }
    }

    /**
     * Nastaví delku předané zbraně TvT v delkaCombobox, pokud hodnota odpovídá
     * enum Delka.
     */
    private void nastavDelku(ZbranTVT zbranTVT) {
        String typ = zbranTVT.getDelka();
        if (typ != null) {
            for (Delka t : Delka.values()) {
                if (typ.equals(t.toString())) {
                    delkaObjectProperty.set(t);
                }
            }
        }
    }

    private void init() {

        // nastaví validitu fornuláře
        validProperty().set(jeFormularValidni());

        // listenery pro název, druh, váhu, zlaťáky, stříbrňáky a zlaťáky
        nazevProperty.addListener((observable, oldValue, newValue) -> {
            nazevChybaVisibleProperty.set(!jeNazevValidni(newValue));
            validProperty().set(jeFormularValidni());
        });

        druhObjectProperty.addListener((observable, oldValue, newValue) -> {
            if (newValue != null)
            validProperty().set(jeFormularValidni());
        });

        drzeniObjectProperty.addListener((observable, oldValue, newValue) -> {
            if (newValue != null)
            validProperty().set(jeFormularValidni());
        });

        silaProperty.addListener((observable, oldValue, newValue) -> {
            silaChybaVisibleProperty.set(!jeSilaValidni(newValue));
            validProperty().set(jeFormularValidni());
        });

        utocnostProperty.addListener((observable, oldValue, newValue) -> {
            utocnostChybaVisibleProperty.set(!jeUtocnostValidni(newValue));
            validProperty().set(jeFormularValidni());
        });

        obranaProperty.addListener((observable, oldValue, newValue) -> {
            obranaChybaVisibleProperty.set(!jeObranaValidni(newValue));
            validProperty().set(jeFormularValidni());
        });

        delkaObjectProperty.addListener((observable, oldValue, newValue) -> {
            if (newValue != null)
            validProperty().set(jeFormularValidni());
        });

        vahaProperty.addListener((observable, oldValue, newValue) -> {
            vahaChybaVisibleProperty.set(!jeVahaValidni(newValue));
            validProperty().set(jeFormularValidni());
        });

        zlatakyProperty.addListener((observable, oldValue, newValue) -> {
            zlatakyChybaVisibleProperty.set(!jeZlatakyValidni(newValue));
            validProperty().set(jeFormularValidni());
        });

        stribrnakyProperty.addListener((observable, oldValue, newValue) -> {
            stribrnakyChybaVisibleProperty.set(!jeStribrnakyValidni(newValue));
            validProperty().set(jeFormularValidni());
        });

        medakyProperty.addListener((observable, oldValue, newValue) -> {
            medakyChybaVisibleProperty.set(!jeMedakyValidni(newValue));
            validProperty().set(jeFormularValidni());
        });

        zlatakyProperty.setValue("0");
        stribrnakyProperty.setValue("0");
        medakyProperty.setValue("0");

    }

    /** Načte hodnoty z formuláře a vrátí je v instanci ZbranTVT */
    private ZbranTVT nactiZFormulare(int id) {
        String popis = popisProperty.get();
        if (popis == null) popis = "";
        return new ZbranTVT(id,
            nazevProperty.get(),
            druhObjectProperty.get().toString(),
            drzeniObjectProperty.get().toString(),
            Integer.parseInt(silaProperty.get()),
            Integer.parseInt(utocnostProperty.get()),
            Integer.parseInt(obranaProperty.get()),
            delkaObjectProperty.get().toString(),
            Integer.parseInt(vahaProperty.get()),
            Integer.parseInt(zlatakyProperty.get()),
            Integer.parseInt(stribrnakyProperty.get()),
            Integer.parseInt(medakyProperty.get()),
            popis);
    }

        /** Vrátí instanci upravované výbavy, v případě přidání nové vrátí null */
    private ZbranTVT pridatNeboUpravit() {
        Integer id = vratIdOdkazu();
        if (id != null) {
            ZbranTVT zbranTVT = dataOut.getZbranTVT(id);
            return zbranTVT;
        } else return null;
    }

    /** Předá obsah nazevTextField metodě, která ověří platnost názvu
        (je vložen text od 1 do 50 znaků) */
    private boolean jeNazevValidni() {
        return jeStringValidni(nazevProperty.get(), 1, 50);
    }

    /** Ověří platnost druhu (zda je nějaký vybraný) */
    private boolean jeDruhValidni() {
        return druhObjectProperty.isNotNull().get();
    }

    /** Ověří platnost drzeni (zda je nějaké vybrané) */
    private boolean jeDrzeniValidni() {
        return drzeniObjectProperty.isNotNull().get();
    }

    /** Ověří platnost síly, zda je to číslo v rozsahu -200 - 200 */
    private boolean jeSilaValidni(String sila) {
        return zvalidujStringCislo(sila, -200, 200);
    }

    /** Předá obsah silaTextField stejnojmené metodě, která ověří jeho platnost,
        tj. zda je to číslo v rozsahu -200 do 200 */
    private boolean jeSilaValidni() {
        return jeSilaValidni(silaProperty.get());
    }

    /** Ověří platnost útočnosti, zda je to číslo v rozsahu -200 - 200 */
    private boolean jeUtocnostValidni(String utocnost) {
        return zvalidujStringCislo(utocnost, -200, 200);
    }

    /** Předá obsah utocnostTextField stejnojmené metodě, která ověří jeho platnost,
        tj. zda je to číslo v rozsahu -200 do 200 */
    private boolean jeUtocnostValidni() {
        return jeUtocnostValidni(utocnostProperty.get());
    }

    /** Ověří platnost obrany zbraně, zda je to číslo v rozsahu -200 - 200 */
    private boolean jeObranaValidni(String obrana) {
        return zvalidujStringCislo(obrana, -200, 200);
    }

    /** Předá obsah obranaTextField stejnojmené metodě, která ověří jeho platnost,
        tj. zda je to číslo v rozsahu -200 do 200 */
    private boolean jeObranaValidni() {
        return jeObranaValidni(obranaProperty().get());
    }

    /** Ověří platnost drzeni (zda je nějaké vybrané) */
    private boolean jeDelkaValidni() {
        return delkaObjectProperty.isNotNull().get();
    }

    /** Předá obsah vahaTextField stejnojmené metodě, která ověří platnost váhy,
        tj. zda je to číslo v rozsahu 0 - 90 000 */
    private boolean jeVahaValidni() {
        return jeVahaValidni(vahaProperty.get());
    }

    /** Vrátí true, pokud jsou správně zadané zlaťáky, stříbrňáky nebo měďáky */
    private boolean jeCenaValidni() {
        return (jeZlatakyValidni() || jeStribrnakyValidni() || jeMedakyValidni());
    }

     /** Předá obsah zlatakyTextField stejnojmené metodě, která ověří, zda je to
         číslo v rozsahu 0 - 1 000 000 */
    private boolean jeZlatakyValidni() {
        return jeZlatakyValidni(zlatakyProperty.get());
    }

        /** Předá obsah stribrnakyTextField stejnojmené metodě, která ověří, zda je
        to číslo v rozsahu 0 - 9 */
    private boolean jeStribrnakyValidni() {
        return jeStribrnakyValidni(stribrnakyProperty.get());
    }

    /** Předá obsah medakyTextField stejnojmené metodě, která ověří, zda je to
        číslo v rozsahu 0 - 9 */
    private boolean jeMedakyValidni() {
        return jeMedakyValidni(medakyProperty.get());
    }


//##############################################################################
//== NESTED DATA TYPES =========================================================

    public enum Druh {
        LEHKA("lehká"),
        STREDNI("střední"),
        TEZKA("těžká");

        private final String nazev;

        Druh(String nazev) {
            this.nazev = nazev;
        }

        @Override
        public String toString() {
            return nazev;
        }

    }

    public enum Drzeni {
        JEDNORUCNI("jednoruční"),
        OBOURUCNI("obouruční");

        private final String nazev;

        Drzeni(String nazev) {
            this.nazev = nazev;
        }

        @Override
        public String toString() {
            return nazev;
        }

    }

    public enum Delka {
        JEDNA("1"),
        JEDNA_A_DVA("1-2"),
        DVA("2"),
        DVA_A_TRI("2-3"),
        TRI("3");


        private final String nazev;

        Delka(String nazev) {
            this.nazev = nazev;
        }

        @Override
        public String toString() {
            return nazev;
        }

    }

}
