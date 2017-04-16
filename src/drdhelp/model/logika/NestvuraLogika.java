/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package drdhelp.model.logika;

import drdhelp.model.Nestvura;
import drdhelp.model.Nestvura.Pohyblivost;
import drdhelp.model.Nestvura.Zranitelnost;
import drdhelp.model.Tvor;
import drdhelp.model.Tvor.Presvedceni;
import drdhelp.model.Vlastnost;
import drdhelp.model.Vlastnosti;
import drdhelp.model.io.DataOut;
import drdhelp.model.io.DataIn;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import static drdhelp.model.Nestvura.*;





/*******************************************************************************
 * Instance třídy {@code NestvuraLogika} představují logiku formuláře
 * Nestvura.fxml.
 *
 * @author  Michal Remišovský
 * @version 0.01.0000 — 2017-04-15
 */
public class NestvuraLogika extends Logika {


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

    private final ObjectProperty<String> zivotaschopnostProperty =
            new SimpleObjectProperty<>();

    private final ObjectProperty<String> konstantaZvtProperty =
            new SimpleObjectProperty<>();

    private final StringProperty utokProperty = new SimpleStringProperty();

    private final StringProperty obranaProperty = new SimpleStringProperty();

    private final ObjectProperty<String> silaProperty = new SimpleObjectProperty<>();

    private final ObjectProperty<String> obratnostProperty =
            new SimpleObjectProperty<>();

    private final ObjectProperty<String> odolnostProperty =
            new SimpleObjectProperty<>();

    private final ObjectProperty<String> inteligenceProperty =
            new SimpleObjectProperty<>();

    private final ObjectProperty<String> charismaProperty =
            new SimpleObjectProperty<>();

    private final ObjectProperty<Nestvura.VelikostNestvura> velikostProperty =
            new SimpleObjectProperty<>();

    private final ObjectProperty<String> bojovnostObjectProperty =
            new SimpleObjectProperty<>();

    private final ObjectProperty<Nestvura.Zranitelnost> zranitelnostObjectProperty =
            new SimpleObjectProperty<>();

    private final StringProperty skupinyZranitelnostProperty =
            new SimpleStringProperty();

    private final ObjectProperty<String> hodnotyPohyblivostObjectProperty =
            new SimpleObjectProperty<>();

    private final ObjectProperty<Nestvura.Pohyblivost> pohyblivostObjectProperty =
            new SimpleObjectProperty<>();

    private final ObjectProperty<String> hodnotyVytrvalostObjectProperty =
            new SimpleObjectProperty<>();

    private final ObjectProperty<Nestvura.Pohyblivost> vytrvalostObjectProperty =
            new SimpleObjectProperty<>();

    private final ObjectProperty<String> manevrSchopnostProperty =
            new SimpleObjectProperty<>();

    private final StringProperty zaklSilaMysliProperty =  new SimpleStringProperty();

    private final ObjectProperty<String> ochoceniProperty = new SimpleObjectProperty<>();

    private final ObjectProperty<Tvor.Presvedceni> presvedceniObjectProperty =
            new SimpleObjectProperty<>();

    private final StringProperty pokladyProperty = new SimpleStringProperty();

    private final StringProperty zkusenostiProperty = new SimpleStringProperty();

    private final StringProperty popisProperty = new SimpleStringProperty();


    private final BooleanProperty nazevChybaVisibleProperty =
            new SimpleBooleanProperty();

    private final BooleanProperty zivotaschopnostChybaVisibleProperty =
            new SimpleBooleanProperty();

    private final BooleanProperty utokChybaVisibleProperty =
            new SimpleBooleanProperty();

    private final BooleanProperty obranaChybaVisibleProperty =
            new SimpleBooleanProperty();

    private final BooleanProperty skupinyZranitelnostChybaVisibleProperty =
            new SimpleBooleanProperty();

    private final BooleanProperty zaklSilaMysliChybaVisibleProperty =
            new SimpleBooleanProperty();

    private final BooleanProperty zkusenostiChybaVisibleProperty =
            new SimpleBooleanProperty();

    private final BooleanProperty valid = new SimpleBooleanProperty(false);


//== VARIABLE INSTANCE ATTRIBUTES ==============================================

    private int poziceKurzoru;

    DataOut dataOut = new DataOut();

    DataIn dataIn = new DataIn();

//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     *
     */
    public NestvuraLogika() {
        init();
    }


//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    public ObjectProperty<String> bojovnostObjectProperty() {
        return bojovnostObjectProperty;
    }

    public ObjectProperty<String> charismaProperty() {
        return charismaProperty;
    }

    public ObjectProperty<String> inteligenceProperty() {
        return inteligenceProperty;
    }

    public BooleanProperty obranaChybaVisibleProperty() {
        return obranaChybaVisibleProperty;
    }

    public ObjectProperty<String> obratnostProperty() {
        return obratnostProperty;
    }

    public ObjectProperty<String> ochoceniProperty() {
        return ochoceniProperty;
    }

    public ObjectProperty<String> odolnostProperty() {
        return odolnostProperty;
    }

    public ObjectProperty<String> silaProperty() {
        return silaProperty;
    }

    public BooleanProperty skupinyZranitelnostChybaVisibleProperty() {
        return skupinyZranitelnostChybaVisibleProperty;
    }

    public BooleanProperty utokChybaVisibleProperty() {
        return utokChybaVisibleProperty;
    }

    public StringProperty utokProperty() {
        return utokProperty;
    }

    public ObjectProperty<Nestvura.VelikostNestvura> velikostProperty() {
        return velikostProperty;
    }

    public StringProperty zaklSilaMysliProperty() {
        return zaklSilaMysliProperty;
    }

    public BooleanProperty zaklSilaMysliChybaVisibleProperty() {
        return zaklSilaMysliChybaVisibleProperty;
    }

    public BooleanProperty zivotaschopnostChybaVisibleProperty() {
        return zivotaschopnostChybaVisibleProperty;
    }

    public BooleanProperty zkusenostiChybaVisibleProperty() {
        return zkusenostiChybaVisibleProperty;
    }

    public ObjectProperty<String> hodnotyPohyblivostObjectProperty() {
        return hodnotyPohyblivostObjectProperty;
    }

    public ObjectProperty<String> hodnotyVytrvalostObjectProperty() {
        return hodnotyVytrvalostObjectProperty;
    }

    public ObjectProperty<String> manevrSchopnostProperty() {
        return manevrSchopnostProperty;
    }

    public BooleanProperty nazevChybaVisibleProperty() {
        return nazevChybaVisibleProperty;
    }

    public StringProperty nazevProperty() {
        return nazevProperty;
    }

    public StringProperty obranaProperty() {
        return obranaProperty;
    }

    public ObjectProperty<Nestvura.Pohyblivost> pohyblivostObjectProperty() {
        return pohyblivostObjectProperty;
    }

    public StringProperty pokladyProperty() {
        return pokladyProperty;
    }

    public ObjectProperty<Tvor.Presvedceni> presvedceniObjectProperty() {
        return presvedceniObjectProperty;
    }

    public StringProperty skupinyZranitelnostProperty() {
        return skupinyZranitelnostProperty;
    }

    public ObjectProperty<Nestvura.Pohyblivost> VytrvalostObjectProperty() {
        return vytrvalostObjectProperty;
    }

    public ObjectProperty<String> zivotaschopnostProperty() {
        return zivotaschopnostProperty;
    }

    public ObjectProperty<String> konstantaZvtProperty() {
        return konstantaZvtProperty;
    }

    public StringProperty zkusenostiProperty() {
        return zkusenostiProperty;
    }

    public StringProperty popisProperty() {
        return popisProperty;
    }

    public ObjectProperty<Nestvura.Zranitelnost> zranitelnostObjectProperty() {
        return zranitelnostObjectProperty;
    }

    public BooleanProperty validProperty() {
        return valid;
    }


    public int getPoziceKurzoru() {
        return poziceKurzoru;
    }

    public void setPoziceKurzoru(int poziceKurzoru) {
        this.poziceKurzoru = poziceKurzoru;
    }



//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /** Jsou všechny položky formuláře validní? */
    public boolean jeFormularValidni() {
        System.out.println(jeSkupinyZranitelnostValidni());
        return jeNazevValidni() && jeZivotaschopnostValidni() && jeUtokValidni()
                && jeObranaValidni() && jeVelikostValidni()
                && jeSkupinyZranitelnostValidni() && jeHodnotaPohyblivostValidni()
                && jePohyblivostValidni() && jeHodnotaVytrvalostValidni()
                && jeVytrvalostValidni() && jeZkusenostiValidni();
    }

    /**
     * Dotáže se, zda se položka upravuje, nebo vkládá nová a podle toho buď nechá
     * formulář prázdný, nebo se dotáže na příslušnou položku z databáze a vloží
     * ji do formuláře
     */
    public void naplnFormular() {
        Nestvura nestvura = pridatNeboUpravit();
        if (nestvura != null) {
            Vlastnosti vlastnosti = nestvura.getVlastnosti();
            nazevProperty.set(nestvura.getNazev());
            zivotaschopnostProperty.set(nestvura.getZivotaschopnostString());
            konstantaZvtProperty.set(vyhodnotAVratString(nestvura.getKonstantaZvt()));
            utokProperty.set(nestvura.getUtok());
            obranaProperty.set(nestvura.getObranaString());
            silaProperty.set(vyhodnotAVratString(nestvura.getSila()));
            obratnostProperty.set(vyhodnotAVratString(nestvura.getObratnost()));
            odolnostProperty.set(vyhodnotAVratString(nestvura.getOdolnost()));
            inteligenceProperty.set(vyhodnotAVratString(nestvura.getInteligence()));
            charismaProperty.set(vyhodnotAVratString(nestvura.getCharisma()));
            nastavVelikost(nestvura);
            bojovnostObjectProperty.set(urciBojovnost(nestvura));
            nastavZranitelnost(nestvura);
            skupinyZranitelnostProperty.set(nestvura.getSkupinaZranitelnost());
            hodnotyPohyblivostObjectProperty.set(vyhodnotAVratString(nestvura
                                                .getPohyblivost().getHodnota()));
            nastavSkupinuPohyblivost(nestvura);
            hodnotyVytrvalostObjectProperty.set(vyhodnotAVratString(nestvura
                                                .getVytrvalost().getHodnota()));
            nastavSkupinuVytrvalost(nestvura);
            manevrSchopnostProperty.set(vyhodnotAVratString(nestvura.getManevrSchopnost()));
            zaklSilaMysliProperty.set(urciZaklSiluMysli(nestvura));
            ochoceniProperty.set(vyhodnotAVratString(nestvura.getOchoceni()));
            nastavPresvedceni(nestvura);
            pokladyProperty.set(urciPoklady(nestvura.getPoklady()));
            zkusenostiProperty.set(String.valueOf(nestvura.getZkusenost()));
            popisProperty.set(nestvura.getPoznamka());
        }
    }

    /**
     * Logika tlačítka Vložit. Podle odkazu ve statické proměnné SeznamOdkazu.upravit
     * určí, zda se vkládá nová položka (null), nebo upravuje (odkaz je na ní).
     * Zalová příslušnou metodu a předá ji obsah formuláře.
     */
    public void pridejNestvuru() {
        Integer id = vratIdOdkazu();
        if (id != null) {
            dataIn.zmenNestvura(nactiZFormulare(id));
        } else {
            dataIn.vlozNestvura(nactiZFormulare(0));
        }
    }


//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================

//************* logika pro vložení upravované nestvůry do formuláře ************

    /**
     * V případě, že je hodnota v nestvura.velikost z enum VelikostNestvura,
     * nastaví ji v velikostComboBox, jinak neudělá nic.
     */
    private void nastavVelikost(Nestvura nestvura) {
        VelikostNestvura velikost = nestvura.urciVelikost();
        if (velikost != null) velikostProperty.set(velikost);
    }

    /**
     * Vrátí bojovnost nestvůry, pokud odpovídá enum Bojovnost, jinak vrátí "N/A"
     * @param nestvura
     * @return
     */
    public String urciBojovnost(Nestvura nestvura) {
        return vyhodnotAVratString(nestvura.getBojovnost(), bojovnostArray);
    }

    /**
     * V případě, že je hodnota v nestvura.zranitelnost z enum Zranitelnost,
     * nastaví ji v zranitelnostComboBox, jinak neudělá nic.
     */
    private void nastavZranitelnost(Nestvura nestvura) {
        Zranitelnost zranitelnost = nestvura.urciZranitelnost();
        if (zranitelnost != null) zranitelnostObjectProperty.set(zranitelnost);
        else zranitelnostObjectProperty.set(Nestvura.Zranitelnost.values()[0]);
    }

    /**
     * Nastaví skupinu pohyblivosti předané nestvůry v příslušném Comboboxu,
     * pokud hodnota odpovídá enum Pohyblivost
     */
    private void nastavSkupinuPohyblivost(Nestvura nestvura) {
        Pohyblivost skupinaPohyblivost = nestvura.urciSkupinaPohyblivost();
        if (skupinaPohyblivost != null) pohyblivostObjectProperty.set(skupinaPohyblivost);
    }

    /**
     * Nastaví skupinu vytrvalosti předané nestvůry v příslušném Comboboxu,
     * pokud hodnota odpovídá enum Pohyblivost(je stejné i pro vytrvalost)
     */
    private void nastavSkupinuVytrvalost(Nestvura nestvura) {
        Pohyblivost skupinaVytrvalost = nestvura.urciSkupinaVytrvalost();
        if (skupinaVytrvalost != null) vytrvalostObjectProperty.set(skupinaVytrvalost);
    }

    /** Vrátí hodnotu základní sílu mysli, pro 0 vrátí "" */
    private String urciZaklSiluMysli(Nestvura nestvura) {
        String zaklSilaMysli = vyhodnotAVratString(nestvura.getZaklSilaMysli());
        if (zaklSilaMysli.equals("0")) zaklSilaMysli = "";
        return zaklSilaMysli;
    }

    /**
     * Nastaví přesvědčení předané nestvůry v příslušném Comboboxu, pokud hodnota
     * odpovídá enum Presvedceni
     */
    private void nastavPresvedceni(Nestvura nestvura) {
        Presvedceni presvedceni = nestvura.urciPresvedceni();
        if (presvedceni != null) presvedceniObjectProperty.set(presvedceni);
    }

    /** Určí životaschopnost. Ve zvláštním případě čísel -2 a -1, vrátí příslušné
        životaschopnosti, a to "½ (1-4 životy)" a "1-2 životy". */
    private String urciZvt(Integer zivotaschopnost) {
        if (zivotaschopnost != null) {
            String zvt = String.valueOf(zivotaschopnost);
            // zvláštní případ - hodnota -2 odpovídá "½ (1-4 životy)"
            if (zvt.equals("-2")) return Nestvura.hodnotyZvtArray[0];
            // zvláštní případ - hodnota -1 odpovídá "1-2 životy"
            if (zvt.equals("-1")) return Nestvura.hodnotyZvtArray[1];
            // ostatní platné hodnoty z Nestvura.hodnotyZvtArray
            for (String s : Nestvura.hodnotyZvtArray) {
                if (s.equals(zvt)) return zvt;
            }
        }
        return null;
    }

//******* konec logiky pro vložení upravované nestvůry do formuláře ************


    private void init() {
        // nastaví validitu fornuláře

        System.out.println("Nastavení počáteční validity formuláře");
        validProperty().set(jeFormularValidni());
<<<<<<< HEAD
=======
        System.out.println("");

>>>>>>> origin/master
        // listenery pro název, druh, váhu, zlaťáky, stříbrňáky a zlaťáky
        nazevProperty.addListener((observable, oldValue, newValue) -> {
            nazevChybaVisibleProperty.set(!jeNazevValidni(newValue));
            System.out.println("název");
            validProperty().set(jeFormularValidni());
            System.out.println("");
        });

        zivotaschopnostProperty.addListener((observable, oldValue, newValue) -> {
            zivotaschopnostChybaVisibleProperty.set(!jeZivotaschopnostValidni(newValue));
            System.out.println("životaschopnost");
            validProperty().set(jeFormularValidni());
            System.out.println("");
        });

        utokProperty.addListener((observable, oldValue, newValue) -> {
            utokChybaVisibleProperty.set(!jeNazevValidni(newValue));
            System.out.println("útok");
            validProperty().set(jeFormularValidni());
            System.out.println("");
        });

        obranaProperty.addListener((observable, oldValue, newValue) -> {
            obranaChybaVisibleProperty.set(!jeObranaValidni(newValue));
            System.out.println("obrana");
            validProperty().set(jeFormularValidni());
            System.out.println("");
        });

        velikostProperty.addListener((observable, oldValue, newValue) -> {
<<<<<<< HEAD
            if (newValue != null) {
                validProperty().set(jeFormularValidni());
            }
=======
            System.out.println("velikost");
            if (newValue != null) {
                validProperty().set(jeFormularValidni());
            }
            System.out.println("");
>>>>>>> origin/master
        });

        zranitelnostObjectProperty.addListener((observable, oldValue, newValue) -> {
            System.out.println("zranitelnost");
            System.out.println("OldValue: " + oldValue);
            System.out.println("NewValue: " + newValue);

            if (newValue != null) {
                // po vybrání zranitelnosti v comboboxu naplní pole výpis
                // skupin(zranitelnost) z enum Zranitelnost.skupinaZranitelnost
                String skupinaZranitelnost = newValue.getSkupinyZranitelnost();
                if (skupinaZranitelnost != null) {
                    skupinyZranitelnostProperty.set(skupinaZranitelnost);
                }
            }
                System.out.println("");
        });

        skupinyZranitelnostProperty.addListener((observable, oldValue, newValue) -> {
            System.out.println("skupinyZranitelnost");
            // pokud se změní skupiny zranitelnosti (A, B, C, ...), tak
            // vyhodnotí, zda odpovídají nějaké zranitelnosti (zvíře, humanoid, ...).
            // Pokud ne, nastaví pole na hodnotu "N/A".
            zranitelnostPodleSkupinZranitelnost(newValue);
            skupinyZranitelnostChybaVisibleProperty.set(!jeSkupinyZranitelnostValidni(newValue));

            System.out.println("OldValue: " + oldValue);
            System.out.println("NewValue: " + newValue);

            boolean vali = jeFormularValidni();
            System.out.println(vali);

            validProperty().set(vali);
            System.out.println("");

            // validProperty().set(jeFormularValidni());

        });

        hodnotyPohyblivostObjectProperty.addListener((observable, oldValue, newValue) -> {
            System.out.println("hodnotyPohyblivost");
            if (newValue != null)
            validProperty().set(jeFormularValidni());
            System.out.println("");
        });

        pohyblivostObjectProperty.addListener((observable, oldValue, newValue) -> {
            System.out.println("pohyblivost");
            if (newValue != null)
            validProperty().set(jeFormularValidni());
            System.out.println("");
        });

        hodnotyVytrvalostObjectProperty.addListener((observable, oldValue, newValue) -> {
            System.out.println("hodnotyVytrvalost");
            if (newValue != null)
            validProperty().set(jeFormularValidni());
            System.out.println("");
        });

        vytrvalostObjectProperty.addListener((observable, oldValue, newValue) -> {
            System.out.println("vytrvalost");
            if (newValue != null)
            validProperty().set(jeFormularValidni());
            System.out.println("");
        });

        zaklSilaMysliProperty.addListener((observable, oldValue, newValue) -> {
            zaklSilaMysliChybaVisibleProperty.set(!jeZaklSilaMysliValidni(newValue));
        });

        presvedceniObjectProperty.addListener((observable, oldValue, newValue) -> {
            System.out.println("přesvědčení");
            if (newValue != null)
            validProperty().set(jeFormularValidni());
            System.out.println("");
        });

        zkusenostiProperty.addListener((observable, oldValue, newValue) -> {
            System.out.println("zkušenosti");
            zkusenostiChybaVisibleProperty.set(!jeZkusenostiValidni(newValue));
            validProperty().set(jeFormularValidni());
            System.out.println("");
        });
    }

    /** Pokud parametr skupinyZranitelnost odpovídá zranitelnosti, nastaví
     * jí v zranitelnostCombobox, jinak nastaví "N/A"*/
    private boolean zranitelnostPodleSkupinZranitelnost(String skupinyZranitelnost) {
        Zranitelnost[] skupinyZranitelnostArray = Nestvura.Zranitelnost.values();
        for (int i = 1; i < skupinyZranitelnostArray.length; i++) {
            if (skupinyZranitelnostArray[i].getSkupinyZranitelnost()
                        .equals(skupinyZranitelnost)) {
                zranitelnostObjectProperty.set(skupinyZranitelnostArray[i]);
                return true;
            }
        }
        zranitelnostObjectProperty.set(skupinyZranitelnostArray[0]);
        return false;
    }


    /** Načte hodnoty z formuláře a vrátí je v instanci Nestvura */
    private Nestvura nactiZFormulare(int id) {

        Integer[] hodnotyVlastnosti = {vyhodnotAVratInt(silaProperty.get()),
                                    vyhodnotAVratInt(obratnostProperty.get()),
                                    vyhodnotAVratInt(odolnostProperty.get()),
                                    vyhodnotAVratInt(inteligenceProperty.get()),
                                    vyhodnotAVratInt(charismaProperty.get())};

        Vlastnost pohyblivost = new Vlastnost("Pohyblivost"
                ,vyhodnotAVratInt(hodnotyPohyblivostObjectProperty.get()));

        Vlastnost vytrvalost = new Vlastnost("Vytrvalost"
                ,vyhodnotAVratInt(hodnotyVytrvalostObjectProperty.get()));

        String zkusenost = zkusenostiProperty.get();
        int zkusenostInt = 0;
        if (zvalidujStringCislo(zkusenost, 0, 900000)) {
            zkusenostInt = Integer.parseInt(zkusenost);
        }

        return new Nestvura(id,
                nazevProperty.get(),
                vyhodnotZvtAVratInteger(zivotaschopnostProperty.get()),
                vyhodnotAVratInt(konstantaZvtProperty.get()),
                utokProperty.get(),
                nactiObranu(),
                hodnotyVlastnosti,
                velikostProperty.get().toString(),
                vyhodnotAVratInt(bojovnostObjectProperty.get()),
                nactiZranitelnost(),
                skupinyZranitelnostProperty.get(),
                pohyblivost,
                pohyblivostObjectProperty.get().toString(),
                vytrvalost,
                vytrvalostObjectProperty.get().toString(),
                vyhodnotAVratInt(manevrSchopnostProperty.get()),
                vyhodnotAVratInt(zaklSilaMysliProperty.get()),
                vratPresvedceni(),
                vyhodnotAVratString(pokladyProperty.get()),
                zkusenostInt,
                // vyhodnotAVratInt(zkusenostiProperty.get()),
                vyhodnotAVratInt(ochoceniProperty.get()),
                popisProperty.get());
    }

    /**
     * Vyhodnotí, zda je hodnota v poli. Pokud ano, vrátí ho
     * v int. Pokud ne, vrátí 0.
     * @param hodnota libovolný String
     * @return String
     */
    private Integer vyhodnotZvtAVratInteger(String hodnota) {
        if (hodnota != null) {
            for (String s : Nestvura.hodnotyZvtArray) {
                if (hodnota.equals(s)) {
                    if (s.equals(Nestvura.hodnotyZvtArray[0])) return -2;
                    if (s.equals(Nestvura.hodnotyZvtArray[1])) return -1;
                    else return Integer.parseInt(s);
                }
            }
        }
        return null;
    }

    /**
     * Vrátí název zranitelnosti z Enum Zranitelnost, pokud je nějaká vybraná
     * v zranitelnostCombobox, jinak vrátí null.
     */
    private String nactiZranitelnost() {
        Zranitelnost zranitelnost = zranitelnostObjectProperty.get();
        if (zranitelnost != null)
            if (!zranitelnost.equals(Nestvura.Zranitelnost.NA)) {
            return zranitelnost.toString();
        }
        return null;
    }

    /**
     * Vrátí obranu z formuláře, u humanoidů je obrana tvořená bonusem
     * za Obratnost + kvalita zbroje, případně ještě + štít. Pro Obr
     * + kvalita zbroje zrátí -1, pro Obr + kvalita zbroje + štít vrátí -2
     */
    private Integer nactiObranu() {
        String obrana = obranaProperty.get();
        if (obrana.contains("kvalita zbroje")) {
            if (obrana.contains("štít")) {
                return -2;
            } else return -1;
        } else return Integer.parseInt(obrana);
    }

    /** Vrátí instanci upravované nestvůry, v případě přidání nové vrátí null */
    private Nestvura pridatNeboUpravit() {
        Integer id = vratIdOdkazu();
        if (id != null) {
            return dataOut.getNestvura(id);
        } else return null;
    }

    /** Vrátí přesvědčení zvolené ve formuláři. Pokud žádné není, vrátí null */
    private String vratPresvedceni() {
        if (presvedceniObjectProperty.isNotNull().get()) {
            Presvedceni presvedceni = presvedceniObjectProperty.get();
            if (!presvedceni.equals(Tvor.Presvedceni.values()[0])) {
                return presvedceni.toString();
            }
        }
        return null;
    }

    /** Ošetřuje situaci při nezadání pokladu (null), vrátí "nic" */
    private String urciPoklady(String text) {
        if (text == null) return "nic";
        return text;
    }


    /** Předá obsah nazevTextField metodě, která ověří platnost názvu
        (je vložen text od 1 do 50 znaků) */
    private boolean jeNazevValidni() {
        return jeStringValidni(nazevProperty.get(), 1, 50);
    }

    /**
     * Předá k validaci hodnotu životaschopnosti a konstavty životaschopnosti
     * z formuláře.
     */
    private boolean jeZivotaschopnostValidni() {
        return (zivotaschopnostProperty.isNotNull().get());
    }

    /** Ověří platnost životaschopnosti, zda je to číslo v rozsahu 1 - 100 */
    private boolean jeZivotaschopnostValidni(String zivotaschopnost) {
        if (zivotaschopnost.equals("1-2 životy")) zivotaschopnost = "-2";
        if (zivotaschopnost.equals("½ (1-4 životy)")) zivotaschopnost = "-1";
        return zvalidujStringCislo(zivotaschopnost, -2, 100);
    }

    /** Předá obsah utokTextField metodě, která ověří platnost útoku
        (je vložen text od 1 do 50 znaků) */
    private boolean jeUtokValidni() {
        return jeNazevValidni(utokProperty.get());
    }

    /** Předá obsah obranaTextField metodě, která ověří platnost
        tj. zda je to číslo v rozsahu 0 - 100  */
    private boolean jeObranaValidni() {
        return jeObranaValidni(obranaProperty.get());
    }

    /** Ověří platnost obrany, zda je to číslo v rozsahu -1 - 100 */
    private boolean jeObranaValidni(String obrana) {
        if (obrana != null) {
            if (obrana.contains("kvalita zbroje")) return true;
            return zvalidujStringCislo(obrana, 1, 100);
        }
        return false;
    }

    /** Ověří platnost velikosti (zda je nějaká vybraná) */
    private boolean jeVelikostValidni() {
        return velikostProperty.isNotNull().get();
    }

    /** Předá obsah skupinyZranitelnostTextField metodě, která ověří platnost
        tj. zda je to text 1 - 200 znaků */
    private boolean jeSkupinyZranitelnostValidni() {
        return jeSkupinyZranitelnostValidni(skupinyZranitelnostProperty.get());
    }

    /** Ověří platnost výpisu skupin zranitelnosti, zda je to text v rozsahu
        1 - 200 znaků */
    private boolean jeSkupinyZranitelnostValidni(String skupinyZranitelnost) {
        System.out.println("SkupinyZranitelnost: " + skupinyZranitelnost);
        return jeStringValidni(skupinyZranitelnost, 1, 200);
    }

    /** Ověří platnost hodnoty pohyblivosti (zda je nějaká vybraná) */
    private boolean jeHodnotaPohyblivostValidni() {
        return hodnotyPohyblivostObjectProperty.isNotNull().get();
    }

    /** Ověří platnost pohyblivosti (zda je nějaká vybraná) */
    private boolean jePohyblivostValidni() {
        return pohyblivostObjectProperty.isNotNull().get();
    }

    /** Ověří platnost hodnoty vytrvalosti (zda je nějaká vybraná) */
    private boolean jeHodnotaVytrvalostValidni() {
        return hodnotyVytrvalostObjectProperty.isNotNull().get();
    }

    /** Ověří platnost vytrvalosti (zda je nějaká vybraná) */
    private boolean jeVytrvalostValidni() {
        return vytrvalostObjectProperty.isNotNull().get();
    }

    /** Ověří platnost základní síly mysli, zda je to číslo v rozsahu 0 - 200 */
    protected boolean jeZaklSilaMysliValidni(String zaklSilaMysli) {
        if (zaklSilaMysli.equals("N/A")
            || (zaklSilaMysli.equals(""))
            || (zaklSilaMysli == null)
                ) return true;
        return zvalidujStringCislo(zaklSilaMysli, 0, 200);
    }

    /** Předá obsah zkusenostiTextField metodě, která ověří platnost
        tj. zda je to číslo 0 - 900 000 */
    private boolean jeZkusenostiValidni() {
        if (zkusenostiProperty.isNotNull().get()) {
            return jeZkusenostiValidni(zkusenostiProperty.get());
        }
        return false;
    }

    /** Ověří platnost zkušenosti, zda je to číslo v rozsahu 0 - 900 000 */
    protected boolean jeZkusenostiValidni(String zkusenosti) {
        return zvalidujStringCislo(zkusenosti, 0, 900000);
    }


//##############################################################################
//== NESTED DATA TYPES =========================================================


}
