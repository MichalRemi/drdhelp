/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package drdhelp.model.logika;

import drdhelp.model.Vybava;
import drdhelp.model.io.DataOut;
import drdhelp.model.io.DataIn;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;





/*******************************************************************************
 * Instance třídy {@code HlavniLogika} představují logiku formuláře Vybava.fxml
 *
 * @author  Michal Remišovský
 * @version 0.01.0000 — 2017-04-15
 */
public class VybavaLogika extends VybaveniLogika {

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
    private final StringProperty vahaProperty = new SimpleStringProperty();
    private final StringProperty zlatakyProperty = new SimpleStringProperty();
    private final StringProperty stribrnakyProperty = new SimpleStringProperty();
    private final StringProperty medakyProperty = new SimpleStringProperty();
    private final StringProperty popisProperty = new SimpleStringProperty();

    private final BooleanProperty nazevChybaVisibleProperty =
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

    private final ReadOnlyBooleanProperty zlatakyFocusProperty =
            new SimpleBooleanProperty();


//== VARIABLE INSTANCE ATTRIBUTES ==============================================

    DataOut dataOut = new DataOut();
    DataIn dataIn = new DataIn();



//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     *
     */
    public VybavaLogika() {
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
    public ReadOnlyBooleanProperty zlatakyFocusProperty() {
        return zlatakyFocusProperty;
    }



//== OTHER NON-PRIVATE INSTANCE METHODS ========================================


    /** Jsou všechny položky formuláře validní? */
    public boolean jeFormularValidni() {
        return jeNazevValidni() && jeDruhValidni() && jeVahaValidni()
                && jeZlatakyValidni() && jeStribrnakyValidni() && jeMedakyValidni();
    }

    /**
     * Dotáže se, zda se položka upravuje, nebo vkládá nová a podle toho buď nechá
     * formulář prázdný, nebo se dotáže na příslušnou položku z databáze a vloží
     * ji do formuláře
     */
    public void naplnFormular() {
        Vybava vybava = pridatNeboUpravit();
        if (vybava != null) {
            nazevProperty.set(vybava.getNazev());
            nastavDruh(vybava);
            vahaProperty.set(String.valueOf(vybava.getVaha()));
            zlatakyProperty.set(String.valueOf(vybava.getZlataky()));
            stribrnakyProperty.set(String.valueOf(vybava.getStribrnaky()));
            medakyProperty.set(String.valueOf(vybava.getMedaky()));
            popisProperty.set(vybava.getPopis());
        }
    }

    /**
     * Logika tlačítka Vložit. Podle odkazu ve statické proměnné
     * SeznamOdkazu.upravit určí, zda se vkládá nová položka (null), nebo upravuje
     * (odkaz je na ní). Zalová příslušnou metodu a předá ji obsah formuláře.
     */
    public void pridejVybavu() {
        Integer id = vratIdOdkazu();
        if (id != null) {
            dataIn.zmenVybava(nactiZFormulare(id));
        } else {
            dataIn.vlozVybava(nactiZFormulare(0));
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

    /** Načte hodnoty z formuláře a vrátí je v instanci Vybava */
    private Vybava nactiZFormulare(int id) {
        String popis = popisProperty.get();
        if (popis == null) popis = "";
        return new Vybava(
            id,
            nazevProperty.get(),
            druhObjectProperty.get().toString(),
            Integer.parseInt(vahaProperty.get()),
            Integer.parseInt(zlatakyProperty.get()),
            Integer.parseInt(stribrnakyProperty.get()),
            Integer.parseInt(medakyProperty.get()),
            popis);
    }

    /** Nastaví druh předané výbavy v druhCombobox, pokud hodnota odpovídá enum Druh */
    private void nastavDruh(Vybava vybava) {
        String druh = vybava.getDruh();
        if (druh != null) {
            for (Druh d : Druh.values()) {
                if (druh.equals(d.toString())) {
                    druhObjectProperty.set(d);
                }
            }
        }
    }

    /** Vrátí instanci upravované výbavy, v případě přidání nové vrátí null */
    private Vybava pridatNeboUpravit() {
        Integer id = vratIdOdkazu();
        if (id != null) {
            Vybava vybava = dataOut.getVybava(id);
            return vybava;
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
        BEZNA("běžná"),
        MAGICKA("magická"),
        LEKTVAR("lektvar");

        private final String nazev;

        Druh(String nazev) {
            this.nazev = nazev;
        }

        @Override
        public String toString() {
            return nazev;
        }

    }
}
