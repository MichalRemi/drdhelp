/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package drdhelp.model.logika;

import drdhelp.model.Zbroj;
import drdhelp.model.io.GetData;
import drdhelp.model.io.SetData;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;





/*******************************************************************************
 * Instance třídy {@code ZbrojLogika} představují
 *
 * @author  Michal Remišovský
 * @version 0.00.0000 — 2017-01-17
 */
public class ZbrojLogika extends VybaveniLogika
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
    private final ObjectProperty<Typ> druhObjectProperty = new SimpleObjectProperty<>();
    private final StringProperty kvalitaProperty = new SimpleStringProperty();
    private final StringProperty vahaAProperty = new SimpleStringProperty();
    private final StringProperty vahaBProperty = new SimpleStringProperty();
    private final StringProperty vahaCProperty = new SimpleStringProperty();
    private final StringProperty cenaAProperty = new SimpleStringProperty();
    private final StringProperty cenaBProperty = new SimpleStringProperty();
    private final StringProperty cenaCProperty = new SimpleStringProperty();
    private final StringProperty popisProperty = new SimpleStringProperty();

    private final BooleanProperty nazevChybaVisibleProperty = new SimpleBooleanProperty();
    private final BooleanProperty kvalitaChybaVisibleProperty = new SimpleBooleanProperty();
    private final BooleanProperty vahaAChybaVisibleProperty = new SimpleBooleanProperty();
    private final BooleanProperty vahaBChybaVisibleProperty = new SimpleBooleanProperty();
    private final BooleanProperty vahaCChybaVisibleProperty = new SimpleBooleanProperty();
    private final BooleanProperty cenaAChybaVisibleProperty = new SimpleBooleanProperty();
    private final BooleanProperty cenaBChybaVisibleProperty = new SimpleBooleanProperty();
    private final BooleanProperty cenaCChybaVisibleProperty = new SimpleBooleanProperty();
    private final BooleanProperty valid = new SimpleBooleanProperty(false);


//== VARIABLE INSTANCE ATTRIBUTES ==============================================

    GetData getData = new GetData();
    SetData setData = new SetData();


//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     *
     */
    public ZbrojLogika() {
        init();
    }


//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    public StringProperty nazevProperty() {
        return nazevProperty;
    }
    public ObjectProperty<Typ> druhObjectProperty() {
        return druhObjectProperty;
    }
    public StringProperty kvalitaProperty() {
        return kvalitaProperty;
    }
    public StringProperty vahaAProperty() {
        return vahaAProperty;
    }
    public StringProperty vahaBProperty() {
        return vahaBProperty;
    }
    public StringProperty vahaCProperty() {
        return vahaCProperty;
    }
    public StringProperty cenaAProperty() {
        return cenaAProperty;
    }
    public StringProperty cenaBProperty() {
        return cenaBProperty;
    }
    public StringProperty cenaCProperty() {
        return cenaCProperty;
    }
    public StringProperty popisProperty() {
        return popisProperty;
    }

    public BooleanProperty nazevChybaVisibleProperty() {
        return nazevChybaVisibleProperty;
    }
    public BooleanProperty kvalitaChybaVisibleProperty() {
        return kvalitaChybaVisibleProperty;
    }
    public BooleanProperty vahaAChybaVisibleProperty() {
        return vahaAChybaVisibleProperty;
    }
    public BooleanProperty vahaBChybaVisibleProperty() {
        return vahaBChybaVisibleProperty;
    }
    public BooleanProperty vahaCChybaVisibleProperty() {
        return vahaCChybaVisibleProperty;
    }
    public BooleanProperty cenaAChybaVisibleProperty() {
        return cenaAChybaVisibleProperty;
    }
    public BooleanProperty cenaBChybaVisibleProperty() {
        return cenaBChybaVisibleProperty;
    }
    public BooleanProperty cenaCChybaVisibleProperty() {
        return cenaCChybaVisibleProperty;
    }
    public BooleanProperty validProperty() {
        return valid;
    }

//== OTHER NON-PRIVATE INSTANCE METHODS ========================================


    /** Jsou všechny položky formuláře validní? */
    public boolean jeFormularValidni() {
        return jeNazevValidni() && jeDruhValidni() && jeCenaAValidni()
               && jeCenaBValidni() && jeCenaCValidni() && jeVahaAValidni()
               && jeVahaBValidni()&& jeVahaCValidni();
    }

    /**
     * Dotáže se, zda se položka upravuje, nebo vkládá nová a podle toho buď nechá
     * formulář prázdný, nebo se dotáže na příslušnou položku z databáze a vloží
     * ji do formuláře
     */
    public void naplnFormular() {
        Zbroj zbroj = pridatNeboUpravit();
        if (zbroj != null) {
            nazevProperty.set(zbroj.getNazev());
            nastavDruh(zbroj);
            kvalitaProperty.set(String.valueOf(zbroj.getKvalita()));
            cenaAProperty.set(String.valueOf(zbroj.getCenaA()));
            cenaBProperty.set(String.valueOf(zbroj.getCenaB()));
            cenaCProperty.set(String.valueOf(zbroj.getCenaC()));
            vahaAProperty.set(String.valueOf(zbroj.getVahaA()));
            vahaBProperty.set(String.valueOf(zbroj.getVahaB()));
            vahaCProperty.set(String.valueOf(zbroj.getVahaC()));
            popisProperty.set(zbroj.getPopis());
        }
    }

    /**
     * Logika tlačítka Vložit. Podle odkazu ve statické proměnné SeznamOdkazu.upravit určí, zda se vkládá
     * nová položka (null), nebo upravuje (odkaz je na ní). Zalová příslušnou
     * metodu a předá ji obsah formuláře.
     */
    public void pridejZbroj() {
        Integer id = vratIdOdkazu();
        if (id != null) {
            setData.zmenZbroj(nactiZFormulare(id));
        } else {
            setData.vlozZbroj(nactiZFormulare(0));
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

        kvalitaProperty.addListener((observable, oldValue, newValue) -> {
            kvalitaChybaVisibleProperty.set(!jeKvalitaValidni(newValue));
            validProperty().set(jeFormularValidni());
        });

        vahaAProperty.addListener((observable, oldValue, newValue) -> {
            vahaAChybaVisibleProperty.set(!jeVahaValidni(newValue));
            validProperty().set(jeFormularValidni());
        });

        vahaBProperty.addListener((observable, oldValue, newValue) -> {
            vahaBChybaVisibleProperty.set(!jeVahaValidni(newValue));
            validProperty().set(jeFormularValidni());
        });

        vahaCProperty.addListener((observable, oldValue, newValue) -> {
            vahaCChybaVisibleProperty.set(!jeVahaValidni(newValue));
            validProperty().set(jeFormularValidni());
        });

        cenaAProperty.addListener((observable, oldValue, newValue) -> {
            cenaAChybaVisibleProperty.set(!jeCenaValidni(newValue));
            validProperty().set(jeFormularValidni());
        });

        cenaBProperty.addListener((observable, oldValue, newValue) -> {
            cenaBChybaVisibleProperty.set(!jeCenaValidni(newValue));
            validProperty().set(jeFormularValidni());
        });

        cenaCProperty.addListener((observable, oldValue, newValue) -> {
            cenaCChybaVisibleProperty.set(!jeCenaValidni(newValue));
            validProperty().set(jeFormularValidni());
        });
    }

    private Zbroj nactiZFormulare(int id) {
        String popis = popisProperty.get();
        if (popis == null) popis = "";
        return new Zbroj(id,
            nazevProperty.get(),
            Integer.parseInt(kvalitaProperty.get()),
            druhObjectProperty.get().toString(),
            Integer.parseInt(vahaAProperty.get()),
            Integer.parseInt(vahaBProperty.get()),
            Integer.parseInt(vahaCProperty.get()),
            Integer.parseInt(cenaAProperty.get()),
            Integer.parseInt(cenaBProperty.get()),
            Integer.parseInt(cenaCProperty.get()),
            popis);
    }

    /** Nastaví druh předané zbroje v druhCombobox, pokud hodnota odpovídá enum Druh */
    private void nastavDruh(Zbroj zbroj) {
        String druh = zbroj.getDruh();
        if (druh != null) {
            for (Typ t : Typ.values()) {
                if (druh.equals(t.toString())) {
                    druhObjectProperty.set(t);
                }
            }
        }
    }

    /** Vrátí instanci upravované zbroje, v případě přidání nové vrátí null */
    private Zbroj pridatNeboUpravit() {
        Integer id = vratIdOdkazu();
        if (id != null) {
            Zbroj zbroj = getData.getZbroj(id);
            return zbroj;
        } else return null;
    }

    /** Předá obsah nazevTextField stejnojmené metodě, která ověří platnost názvu
        (je vložen text od 1 do 50 znaků) */
    private boolean jeNazevValidni() {
        return jeStringValidni(nazevProperty.get(), 1, 50);
    }

    /** Ověří platnost druhu (zda je nějaký vybraný) */
    private boolean jeDruhValidni() {
        return druhObjectProperty.isNotNull().get();
    }

    /** Ověří platnost kvality, zda je to číslo v rozsahu -200 až 200 */
    protected boolean jeKvalitaValidni(String kvalita) {
        return zvalidujStringCislo(kvalita, -200, 200);
    }

    /** Předá obsah kvalitaTextField stejnojmené metodě, která ověří platnost
        kvality zbroje, tj. zda je to číslo v rozsahu -200 až 200 */
    private boolean jeKvalitaValidni() {
        return jeKvalitaValidni(kvalitaProperty.get());
    }

    /** Ověří platnost vahy, zda je to číslo v rozsahu -200 až 200 */
    @Override
    protected boolean jeVahaValidni(String vaha) {
        return zvalidujStringCislo(vaha, 0, 90000);
    }

    /** Předá obsah vahaATextField metodě jeVahaValidni(), která ověří platnost
        vahy zbroje, tj. zda je to číslo v rozsahu 0 až 90 000 */
    private boolean jeVahaAValidni() {
        return jeVahaValidni(vahaAProperty.get());
    }

    /** Předá obsah vahaBTextField metodě jeVahaValidni(), která ověří platnost
        vahy zbroje, tj. zda je to číslo v rozsahu 0 až 90 000 */
    private boolean jeVahaBValidni() {
        return jeVahaValidni(vahaAProperty.get());
    }

    /** Předá obsah vahaCTextField metodě jeVahaValidni(), která ověří platnost
        vahy zbroje, tj. zda je to číslo v rozsahu 0 až 90 000 */
    private boolean jeVahaCValidni() {
        return jeVahaValidni(vahaAProperty.get());
    }

    /** Ověří platnost ceny, zda je to číslo v rozsahu 0 až 1 000 000 */
    protected boolean jeCenaValidni(String cena) {
        return zvalidujStringCislo(cena, 0, 1000000);
    }

    /** Předá obsah cenaATextField metodě jeCenaValidni(), která ověří platnost
        ceny zbroje, tj. zda je to číslo v rozsahu 0 až 1 000 000 */
    private boolean jeCenaAValidni() {
        return jeVahaValidni(cenaAProperty.get());
    }

    /** Předá obsah cenaBTextField metodě jeCenaValidni(), která ověří platnost
        ceny zbroje, tj. zda je to číslo v rozsahu 0 až 1 000 000 */
    private boolean jeCenaBValidni() {
        return jeVahaValidni(cenaBProperty.get());
    }

    /** Předá obsah cenaCTextField metodě jeCenaValidni(), která ověří platnost
        ceny zbroje, tj. zda je to číslo v rozsahu 0 až 1 000 000 */
    private boolean jeCenaCValidni() {
        return jeVahaValidni(cenaCProperty.get());
    }


//##############################################################################
//== NESTED DATA TYPES =========================================================

    public enum Typ {
        BEZNA("běžná"),
        MAGICKA("magická");

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
