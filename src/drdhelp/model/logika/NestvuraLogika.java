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
import drdhelp.model.io.GetData;
import drdhelp.model.io.SetData;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import static drdhelp.model.Nestvura.*;





/*******************************************************************************
 * Instance třídy {@code NestvuraLogika} představují
 *
 * @author  Michal Remišovský
 * @version 0.00.0000 — 2017-01-17
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
    private final StringProperty zivotaschopnostProperty = new SimpleStringProperty();
    private final StringProperty utokProperty = new SimpleStringProperty();
    private final StringProperty obranaProperty = new SimpleStringProperty();
    private final ObjectProperty<String> silaProperty = new SimpleObjectProperty<>();
    private final ObjectProperty<String> obratnostProperty = new SimpleObjectProperty<>();
    private final ObjectProperty<String> odolnostProperty = new SimpleObjectProperty<>();
    private final ObjectProperty<String> inteligenceProperty = new SimpleObjectProperty<>();
    private final ObjectProperty<String> charismaProperty = new SimpleObjectProperty<>();
    private final ObjectProperty<Nestvura.VelikostNestvura> velikostProperty = new SimpleObjectProperty<>();
    private final ObjectProperty<String> bojovnostObjectProperty = new SimpleObjectProperty<>();
    private final ObjectProperty<Nestvura.Zranitelnost> zranitelnostObjectProperty = new SimpleObjectProperty<>();
    private final StringProperty skupinyZranitelnostProperty = new SimpleStringProperty();
    private final ObjectProperty<String> hodnotyPohyblivostObjectProperty = new SimpleObjectProperty<>();
    private final ObjectProperty<Nestvura.Pohyblivost> pohyblivostObjectProperty = new SimpleObjectProperty<>();
    private final ObjectProperty<String> hodnotyVytrvalostObjectProperty = new SimpleObjectProperty<>();
    private final ObjectProperty<Nestvura.Pohyblivost> vytrvalostObjectProperty = new SimpleObjectProperty<>();
    private final ObjectProperty<String> manevrSchopnostProperty = new SimpleObjectProperty<>();
    private final StringProperty zaklSilaMysliProperty = new SimpleStringProperty();
    private final ObjectProperty<String> ochoceniProperty = new SimpleObjectProperty<>();
    private final ObjectProperty<Tvor.Presvedceni> presvedceniObjectProperty = new SimpleObjectProperty<>();
    private final StringProperty pokladyProperty = new SimpleStringProperty();
    private final StringProperty zkusenostiProperty = new SimpleStringProperty();
    private final StringProperty popisProperty = new SimpleStringProperty();

    private final BooleanProperty nazevChybaVisibleProperty = new SimpleBooleanProperty();
    private final BooleanProperty zivotaschopnostChybaVisibleProperty = new SimpleBooleanProperty();
    private final BooleanProperty utokChybaVisibleProperty = new SimpleBooleanProperty();
    private final BooleanProperty obranaChybaVisibleProperty = new SimpleBooleanProperty();
    private final BooleanProperty skupinyZranitelnostChybaVisibleProperty = new SimpleBooleanProperty();
    private final BooleanProperty zaklSilaMysliChybaVisibleProperty = new SimpleBooleanProperty();
    private final BooleanProperty zkusenostiChybaVisibleProperty = new SimpleBooleanProperty();

    private final BooleanProperty valid = new SimpleBooleanProperty(false);


//== VARIABLE INSTANCE ATTRIBUTES ==============================================

    private int poziceKurzoru;
    GetData getData = new GetData();
    SetData setData = new SetData();

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
    public StringProperty zivotaschopnostProperty() {
        return zivotaschopnostProperty;
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
        return jeNazevValidni() && jeZivotaschopnostValidni() && jeUtokValidni()
                && jeObranaValidni() && jeVelikostValidni()
                && jeSkupinyZranitelnostValidni() && jeHodnotaPohyblivostValidni()
                && jePohyblivostValidni() && jeHodnotaVytrvalostValidni()
                && jeVytrvalostValidni() && jeZkusenostiValidni();
    }

    /** Vloží do formuláře upravovanou nestvůru */
    public void naplnFormular() {
        Nestvura nestvura = pridatNeboUpravit();
        if (nestvura != null) {

            Vlastnosti vlastnosti = nestvura.getVlastnosti();
            for (int i = 0; i < 5; i++) {
                System.out.println(vlastnosti.getVlastnost(i));
            }

            nazevProperty.set(nestvura.getNazev());
            zivotaschopnostProperty.set(String.valueOf(nestvura.getZivotaschopnost()));
            utokProperty.set(nestvura.getUtok());
            System.out.println("Obrana nestvůry je : " + nestvura.getObranaString());
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
            pokladyProperty.set(nestvura.getPoklady());
            zkusenostiProperty.set(String.valueOf(nestvura.getZkusenost()));
            popisProperty.set(nestvura.getPoznamka());
        }
    }

    /**
     * Logika tlačítka Vložit. Určí, zda jde o úpravu nebo vloženíé nové nestvůra
     * a zavolá příslušnou metodu, které nestvůru předá.
     */
    public void pridejNestvuru() {
        Integer id = vratIdOdkazu();
        if (id != null) {
            setData.zmenNestvura(nactiZFormulare(id));
        } else {
            setData.vlozNestvura(nactiZFormulare(0));
        }
    }


//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================

//************* logika pro vložení upravované nestvůry do formuláře ************

//    private void nastavHodnotyNA(Nestvura nestvura) {
//        String sila = vyhodnotAVratString(nestvura.getSila());
//        String obratnost = vyhodnotAVratString(nestvura.getObratnost());
//        String odolnost = vyhodnotAVratString(nestvura.getOdolnost()))
//        for (String s : Tvor.HODNOTY_NA)
//
//
//
//            silaProperty.set(vyhodnotAVratString(nestvura.getSila()));
//            obratnostProperty.set(vyhodnotAVratString(nestvura.getObratnost()));
//            odolnostProperty.set(vyhodnotAVratString(nestvura.getOdolnost()));
//            inteligenceProperty.set(vyhodnotAVratString(nestvura.getInteligence()));
//            charismaProperty.set(vyhodnotAVratString(nestvura.getCharisma()));
//    }


    /** Nastaví sílu, pro null */
    private void urciSilu(Nestvura nestvura) {
        String sila = vyhodnotAVratString(nestvura.getSila());
        if (sila != null) silaProperty.set(sila);
        else silaProperty.set(Tvor.HODNOTY_NA[0]);
    }

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
        return vyhodnotAVratString(nestvura.getBojovnost(), BOJOVNOST);
    }

    /**
     * V případě, že je hodnota v nestvura.zranitelnost z enum Zranitelnost,
     * nastaví ji v zranitelnostComboBox, jinak neudělá nic.
     */
    private void nastavZranitelnost(Nestvura nestvura) {
        Zranitelnost zranitelnost = nestvura.urciZranitelnost();
        if (zranitelnost != null) zranitelnostObjectProperty.set(zranitelnost);
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

//******* konec logiky pro vložení upravované nestvůry do formuláře ************


    private void init() {
        // nastaví validitu fornuláře
        validProperty().set(jeFormularValidni());

        // listenery pro název, druh, váhu, zlaťáky, stříbrňáky a zlaťáky
        nazevProperty.addListener((observable, oldValue, newValue) -> {
            nazevChybaVisibleProperty.set(!jeNazevValidni(newValue));
            validProperty().set(jeFormularValidni());
        });

        zivotaschopnostProperty.addListener((observable, oldValue, newValue) -> {
            zivotaschopnostChybaVisibleProperty.set(!jeZivotaschopnostValidni(newValue));
            validProperty().set(jeFormularValidni());
        });

        utokProperty.addListener((observable, oldValue, newValue) -> {
            utokChybaVisibleProperty.set(!jeNazevValidni(newValue));
            validProperty().set(jeFormularValidni());
        });

        obranaProperty.addListener((observable, oldValue, newValue) -> {
            obranaChybaVisibleProperty.set(!jeObranaValidni(newValue));
            validProperty().set(jeFormularValidni());
        });

        velikostProperty.addListener((observable, oldValue, newValue) -> {
            if (newValue != null)
            validProperty().set(jeFormularValidni());
        });

        zranitelnostObjectProperty.addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                // po vybrání zranitelnosti v comboboxu naplní pole výpis
                // skupin(zranitelnost) z enum Zranitelnost.skupinaZranitelnost
                String skupinaZranitelnost = newValue.getSkupinyZranitelnost();
                skupinyZranitelnostProperty.set(skupinaZranitelnost);
            }
        });

        skupinyZranitelnostProperty.addListener((observable, oldValue, newValue) -> {
            skupinyZranitelnostChybaVisibleProperty.set(!jeSkupinyZranitelnostValidni(newValue));
            validProperty().set(jeFormularValidni());
        });

        hodnotyPohyblivostObjectProperty.addListener((observable, oldValue, newValue) -> {
            if (newValue != null)
            validProperty().set(jeFormularValidni());
        });

        pohyblivostObjectProperty.addListener((observable, oldValue, newValue) -> {
            if (newValue != null)
            validProperty().set(jeFormularValidni());
        });

        hodnotyVytrvalostObjectProperty.addListener((observable, oldValue, newValue) -> {
            if (newValue != null)
            validProperty().set(jeFormularValidni());
        });

        vytrvalostObjectProperty.addListener((observable, oldValue, newValue) -> {
            if (newValue != null)
            validProperty().set(jeFormularValidni());
        });

        zaklSilaMysliProperty.addListener((observable, oldValue, newValue) -> {
            zaklSilaMysliChybaVisibleProperty.set(!jeZaklSilaMysliValidni(newValue));
        });

        presvedceniObjectProperty.addListener((observable, oldValue, newValue) -> {
            if (newValue != null)
            validProperty().set(jeFormularValidni());
        });

        zkusenostiProperty.addListener((observable, oldValue, newValue) -> {
            zkusenostiChybaVisibleProperty.set(!jeZkusenostiValidni(newValue));
            validProperty().set(jeFormularValidni());
        });
    }


    /** Načte hodnoty z formuláře a vrátí je v instanci Nestvura */
    private Nestvura nactiZFormulare(int id) {
        String popis = popisProperty.get();
        if (popis == null) popis = "";

        Integer[] hodnotyVlastnosti = {vyhodnotAVratInt(silaProperty.get()),
                                    vyhodnotAVratInt(obratnostProperty.get()),
                                    vyhodnotAVratInt(odolnostProperty.get()),
                                    vyhodnotAVratInt(inteligenceProperty.get()),
                                    vyhodnotAVratInt(charismaProperty.get())};
        Vlastnost pohyblivost = new Vlastnost("Pohyblivost"
                ,vyhodnotAVratInt(hodnotyPohyblivostObjectProperty.get()));
        Vlastnost vytrvalost = new Vlastnost("Vytrvalost"
                ,vyhodnotAVratInt(hodnotyVytrvalostObjectProperty.get()));

        return new Nestvura(id,
                nazevProperty.get(),
                vyhodnotAVratInt(zivotaschopnostProperty.get()),
                utokProperty.get(),
                nactiObranu(),
                hodnotyVlastnosti,
                velikostProperty.get().toString(),
                vyhodnotAVratInt(bojovnostObjectProperty.get()),
                zranitelnostObjectProperty.get().toString(),
                skupinyZranitelnostProperty.get(),
                pohyblivost,
                pohyblivostObjectProperty.get().toString(),
                vytrvalost,
                vytrvalostObjectProperty.get().toString(),
                vyhodnotAVratInt(manevrSchopnostProperty.get()),
                vyhodnotAVratInt(zaklSilaMysliProperty.get()),
                presvedceniObjectProperty.get().toString(),
                pokladyProperty.get(),
                vyhodnotAVratInt(zkusenostiProperty.get()),
                vyhodnotAVratInt(ochoceniProperty.get()),
                popis);
    }

    /**
     * Vrátí obranu z formuláře, u humanoidů je obrana tvořená bonusem
     * za Obratnost + kvalita zbroje, případně ještě + štít. Pro Obr
     * + kvalita zbroje zrátí -1, pro Obr + kvalita zbroje + štít vrátí -2
     */
    private Integer nactiObranu(){
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
            Nestvura nestvura = getData.getNestvura(id);
            return nestvura;
        } else return null;
    }

    /** Předá obsah nazevTextField metodě, která ověří platnost názvu
        (je vložen text od 1 do 50 znaků) */
    private boolean jeNazevValidni() {
        return jeStringValidni(nazevProperty.get(), 1, 50);
    }

    /** předá k validaci hodnotu životaschopnosti z formuláře */
    private boolean jeZivotaschopnostValidni() {
        return jeZivotaschopnostValidni(zivotaschopnostProperty.get());
    }

    /** Ověří platnost životaschopnosti, zda je to číslo v rozsahu 1 - 100 */
    private boolean jeZivotaschopnostValidni(String zivotaschopnost) {
        return zvalidujStringCislo(zivotaschopnost, 1, 100);
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
            return zvalidujStringCislo(obrana, -2, 100) ||
                                           obrana.contains("kvalita zbroje");
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
        if (zaklSilaMysli.equals("N/A")) return true;
        return zvalidujStringCislo(zaklSilaMysli, 0, 200);
    }

    /** Předá obsah zkusenostiTextField metodě, která ověří platnost
        tj. zda je to číslo 0 - 900 000 */
    private boolean jeZkusenostiValidni() {
        return jeZkusenostiValidni(zkusenostiProperty.get());
    }

    /** Ověří platnost zkušenosti, zda je to číslo v rozsahu 0 - 900 000 */
    protected boolean jeZkusenostiValidni(String zkusenosti) {
        return zvalidujStringCislo(zkusenosti, 0, 900000);
    }


//##############################################################################
//== NESTED DATA TYPES =========================================================


}
