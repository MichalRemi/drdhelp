/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package drdhelp.model.logika;

import drdhelp.model.ZbranSAV;
import drdhelp.model.io.DataOut;
import drdhelp.model.io.DataIn;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;





/*******************************************************************************
 * Instance třídy {@code HlavniLogika} představují logiku formuláře ZbranSAV.fxml.
 *
 * @author  Michal Remišovský
 * @version 0.01.0000 — 2017-04-15
 */
public class ZbranSAVLogika extends VybaveniLogika {

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
    private final ObjectProperty<Typ> typObjectProperty =
            new SimpleObjectProperty<>();
    private final StringProperty silaProperty = new SimpleStringProperty();
    private final StringProperty utocnostProperty = new SimpleStringProperty();
    private final StringProperty malyDostrelProperty = new SimpleStringProperty();
    private final StringProperty stredniDostrelProperty = new SimpleStringProperty();
    private final StringProperty velkyDostrelProperty = new SimpleStringProperty();
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
    private final BooleanProperty malyDostrelChybaVisibleProperty =
            new SimpleBooleanProperty();
    private final BooleanProperty stredniDostrelChybaVisibleProperty =
            new SimpleBooleanProperty();
    private final BooleanProperty velkyostrelChybaVisibleProperty =
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
    // aktuální pozice kurzoru
    int poziceKurzoru;


//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     *
     */
    public ZbranSAVLogika() {
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
    public ObjectProperty<Typ> typObjectProperty() {
        return typObjectProperty;
    }
    public StringProperty silaProperty() {
        return silaProperty;
    }
    public StringProperty utocnostProperty() {
        return utocnostProperty;
    }
    public StringProperty malyDostrelProperty() {
        return malyDostrelProperty;
    }
    public StringProperty stredniDostrelProperty() {
        return stredniDostrelProperty;
    }
    public StringProperty velkyDostrelProperty() {
        return velkyDostrelProperty;
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
    public BooleanProperty SilaChybaVisibleProperty() {
        return silaChybaVisibleProperty;
    }
    public BooleanProperty UtocnostChybaVisibleProperty() {
        return utocnostChybaVisibleProperty;
    }
        public BooleanProperty MalyDostrelChybaVisibleProperty() {
        return malyDostrelChybaVisibleProperty;
    }
    public BooleanProperty StredniDostrelChybaVisibleProperty() {
        return stredniDostrelChybaVisibleProperty;
    }
    public BooleanProperty VelkyDostrelChybaVisibleProperty() {
        return velkyostrelChybaVisibleProperty;
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
        return jeNazevValidni() && jeDruhValidni() && jeTypValidni()
               && jeSilaValidni() && jeUtocnostValidni() && jeMalyDostrelValidni()
               && jeStredniDostrelValidni() && jeVelkyDostrelValidni()
               && jeVahaValidni() &&jeZlatakyValidni() && jeStribrnakyValidni()
               && jeMedakyValidni();
    }

    /**
     * Dotáže se, zda se položka upravuje, nebo vkládá nová a podle toho buď nechá
     * formulář prázdný, nebo se dotáže na příslušnou položku z databáze a vloží
     * ji do formuláře
     */
    public void naplnFormular() {
        ZbranSAV zbranSAV = pridatNeboUpravit();
        if (zbranSAV != null) {
            nazevProperty.set(zbranSAV.getNazev());
            nastavDruh(zbranSAV);
            nastavTyp(zbranSAV);
            silaProperty.set(String.valueOf(zbranSAV.getSila()));
            utocnostProperty.set(String.valueOf(zbranSAV.getUtocnost()));
            malyDostrelProperty.set(String.valueOf(zbranSAV.getMalyDostrel()));
            stredniDostrelProperty.set(String.valueOf(zbranSAV.getStredniDostrel()));
            velkyDostrelProperty.set(String.valueOf(zbranSAV.getVelkyDostrel()));
            vahaProperty.set(String.valueOf(zbranSAV.getVaha()));
            zlatakyProperty.set(String.valueOf(zbranSAV.getZlataky()));
            stribrnakyProperty.set(String.valueOf(zbranSAV.getStribrnaky()));
            medakyProperty.set(String.valueOf(zbranSAV.getMedaky()));
            popisProperty.set(zbranSAV.getPopis());
        }
    }

    /**
     * Logika tlačítka Vložit. Podle odkazu ve statické proměnné SeznamOdkazu.upravit určí, zda se vkládá
     * nová položka (null), nebo upravuje (odkaz je na ní). Zalová příslušnou
     * metodu a předá ji obsah formuláře.
     */
    public void pridejZbranSAV() {
        Integer id = vratIdOdkazu();
        if (id != null) {
            dataIn.zmenZbranSAV(nactiZFormulare(id));
        } else {
            dataIn.vlozZbranSAV(nactiZFormulare(0));
        }
    }


//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================


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

        typObjectProperty.addListener((observable, oldValue, newValue) -> {
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

        malyDostrelProperty.addListener((observable, oldValue, newValue) -> {
            malyDostrelChybaVisibleProperty.set(!jeMalyDostrelValidni(newValue));
            validProperty().set(jeFormularValidni());
        });

        stredniDostrelProperty.addListener((observable, oldValue, newValue) -> {
            stredniDostrelChybaVisibleProperty.set(!jeStredniDostrelValidni(newValue));
            validProperty().set(jeFormularValidni());
        });

        velkyDostrelProperty.addListener((observable, oldValue, newValue) -> {
            velkyostrelChybaVisibleProperty.set(!jeVelkyDostrelValidni(newValue));
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

    /** Načte hodnoty z formuláře a vrátí je v instanci ZbranSAV */
    private ZbranSAV nactiZFormulare(int id) {
        String popis = popisProperty.get();
        if (popis == null) popis = "";
        return new ZbranSAV(id,
            nazevProperty.get(),
            druhObjectProperty.get().toString(),
            typObjectProperty.get().toString(),
            Integer.parseInt(silaProperty.get()),
            Integer.parseInt(utocnostProperty.get()),
            Integer.parseInt(malyDostrelProperty.get()),
            Integer.parseInt(stredniDostrelProperty.get()),
            Integer.parseInt(velkyDostrelProperty.get()),
            Integer.parseInt(vahaProperty.get()),
            Integer.parseInt(zlatakyProperty.get()),
            Integer.parseInt(stribrnakyProperty.get()),
            Integer.parseInt(medakyProperty.get()),
            popis);
    }

    /** Nastaví druh předané zbraně SaV v druhCombobox, pokud hodnota odpovídá enum Druh */
    private void nastavDruh(ZbranSAV zbranSAV) {
        String druh = zbranSAV.getDruh();
        if (druh != null) {
            for (Druh d : Druh.values()) {
                if (druh.equals(d.toString())) {
                    druhObjectProperty.set(d);
                }
            }
        }
    }

    /** Nastaví druh předané zbraně SaV v typCombobox, pokud hodnota odpovídá enum Druh */
    private void nastavTyp(ZbranSAV zbranSAV) {
        String typ = zbranSAV.getTyp();
        if (typ != null) {
            for (Typ t : Typ.values()) {
                if (typ.equals(t.toString())) {
                    typObjectProperty.set(t);
                }
            }
        }
    }

    /** Vrátí instanci upravované výbavy, v případě přidání nové vrátí null */
    private ZbranSAV pridatNeboUpravit() {
        Integer id = vratIdOdkazu();
        if (id != null) {
            ZbranSAV zbranSAV = dataOut.getZbranSAV(id);
            return zbranSAV;
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

    /** Ověří platnost typu (zda je nějaký vybraný) */
    private boolean jeTypValidni() {
        return typObjectProperty.isNotNull().get();
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

    /** Ověří platnost malého dostřelu, zda je to číslo v rozsahu 0 až 1 000 */
    private boolean jeMalyDostrelValidni(String malyDostrel) {
        return zvalidujStringCislo(malyDostrel, 0, 1000);
    }

    /** Předá obsah malyDostrelTextField stejnojmené metodě, která ověří jeho platnost,
        tj. zda je to číslo v rozsahu 0 až 1 000 */
    private boolean jeMalyDostrelValidni() {
        return jeMalyDostrelValidni(malyDostrelProperty.get());
    }

    /** Ověří platnost středního dostřelu, zda je to číslo v rozsahu 0 až 1 000 */
    private boolean jeStredniDostrelValidni(String stredniDostrel) {
        return zvalidujStringCislo(stredniDostrel, 0, 1000);
    }

    /** Předá obsah stredniDostrelTextField stejnojmené metodě, která ověří jeho platnost,
        tj. zda je to číslo v rozsahu 0 až 1 000 */
    private boolean jeStredniDostrelValidni() {
        return jeStredniDostrelValidni(stredniDostrelProperty.get());
    }

    /** Ověří platnost velkého dostřelu, zda je to číslo v rozsahu 0 až 1 000 */
    private boolean jeVelkyDostrelValidni(String velkyDostrel) {
        return zvalidujStringCislo(velkyDostrel, 0, 1000);
    }

    /** Předá obsah velkyDostrelTextField stejnojmené metodě, která ověří jeho platnost,
        tj. zda je to číslo v rozsahu 0 až 1 000 */
    private boolean jeVelkyDostrelValidni() {
        return jeVelkyDostrelValidni(velkyDostrelProperty.get());
    }

    /** Předá obsah vahaTextField stejnojmené metodě, která ověří platnost váhy,
        tj. zda je to číslo v rozsahu 0 - 90 000 */
    private boolean jeVahaValidni() {
        return jeVahaValidni(vahaProperty.get());
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

    public enum Typ {
        STRELNA("střelná"),
        VRHACI("vrhací");

        private final String nazev;

        Typ(String nazev) {
            this.nazev = nazev;
        }

        @Override
        public String toString() {
            return nazev;
        }
    }

}
