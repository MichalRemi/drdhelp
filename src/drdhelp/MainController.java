/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drdhelp;

import drdhelp.model.logika.MainLogika;
import drdhelp.model.Odkaz;
import drdhelp.model.SeznamOdkazu;
import drdhelp.model.TabulkaDB;
import drdhelp.model.io.DataIn;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;



/**
 * FXML Controller class
 *
 * @author Michal Remišovský
 * @version 0.01.0000 — 2017-04-15
 */
public class MainController implements Initializable {

    // levé menu aplikace
    @FXML
    private VBox menuVBox;
    @FXML
    private ToggleButton postavaToggleButton;
    @FXML
    private ToggleButton nestvuraToggleButton;
    @FXML
    private ToggleButton zbranTVTToggleButton;
    @FXML
    private ToggleButton zbranSAVToggleButton;
    @FXML
    private ToggleButton zbrojToggleButton;
    @FXML
    private ToggleButton vybavaToggleButton;
    @FXML
    private Button konecButton;

    // tělo aplikace
    @FXML
    private TextField hledejTextField;
    @FXML
    private ListView<Odkaz> seznamListView;
    @FXML
    private Button pridatButton;
    @FXML
    private Button upravitButton;
    @FXML
    private Button smazatButton;
    @FXML
    private TextArea detailTextArea;


    // implementace logiky
    private final MainLogika logika = new MainLogika();

    // logika pro seznam odkazů ve formuláři Main - seznamListView pro snadný
    // přístup z ostatních formulářů
    private final SeznamOdkazu seznamOdkazu = new SeznamOdkazu();

    // skupina tlačítek v menu
    final ToggleGroup menu = new ToggleGroup();

    DataIn dataIn = new DataIn();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // nastavení ToggleGroup
        postavaToggleButton.setToggleGroup(menu);
        nestvuraToggleButton.setToggleGroup(menu);
        zbranTVTToggleButton.setToggleGroup(menu);
        zbranSAVToggleButton.setToggleGroup(menu);
        zbrojToggleButton.setToggleGroup(menu);
        vybavaToggleButton.setToggleGroup(menu);

        // listener: výběr tlačítka z menu -> seznam odkazů do seznamListView
        // a smaže obsah hledejTextField
        menu.selectedToggleProperty().addListener((ObservableValue<
                    ? extends Toggle> ov, Toggle toggle, Toggle newToggle) -> {
            if (newToggle != null) {
                hledejTextField.setText("");
                seznamOdkazu.nactiOdkazy(urciToggleButton());
            }
        });

        // pojmenuje tlačítka podle enum TabulkaDB - slouží ke spárování názvů
        // tlačítek a příslušného názvu tabulky z databáze drddesk_db
        postavaToggleButton.setText(TabulkaDB.POSTAVA.getNazev());
        nestvuraToggleButton.setText(TabulkaDB.NESTVURA.getNazev());
        zbranTVTToggleButton.setText(TabulkaDB.ZBRAN_TVT.getNazev());
        zbranSAVToggleButton.setText(TabulkaDB.ZBRAN_SAV.getNazev());
        zbrojToggleButton.setText(TabulkaDB.ZBROJ.getNazev());
        vybavaToggleButton.setText(TabulkaDB.VYBAVA.getNazev());

        // bindování seznamListView
        seznamListView.setItems(seznamOdkazu.getOdkazy());

        // načtení seznamu odkazů postav při startu aplikace
        seznamOdkazu.nactiOdkazy(postavaToggleButton.getText());

        // listener: položka z seznamListView -> detail do detailTextArea
        seznamListView.getSelectionModel().selectedItemProperty().addListener((
            ObservableValue<? extends Odkaz> ov, Odkaz oldValue, Odkaz newValue) -> {
            String popis = "";
            if (newValue != null) {
                popis = logika.ziskejOdkaz(newValue).getPodrobnyPopis();
            }
            detailTextArea.setText(popis);
        });

        // bindování disable tlačítka Přidat
        pridatButton.disableProperty().bind(menu.selectedToggleProperty().isNull());

        // bindování disable tlačítek Upravit a Smazat
        upravitButton.disableProperty().bind(seznamListView.getSelectionModel()
                                            .selectedItemProperty().isNull());
        smazatButton.disableProperty().bind(seznamListView.getSelectionModel()
                                            .selectedItemProperty().isNull());
    }

    public Window getWindow() {
        return konecButton.getScene().getWindow();
    }

    /** Obsluha hledejTextField */
    @FXML
    private void handleHledani(KeyEvent event){
        seznamOdkazu.vyberPodleZacinajicihoRetezce(hledejTextField.getText());
    }

    /** Obsluha tlačítek menu - předá název stisknutého tlačítka. */
    @FXML
    private void handleToggleButton(ActionEvent event) {
        hledejTextField.setText("");
        seznamOdkazu.nactiOdkazy(urciToggleButton());
    }

    /** Obsluha tlačítka Konec - ukončí aplikaci */
    @FXML
    private void handleKonec(ActionEvent event) {
        Platform.exit();
    }

    /** Obsluha tlačítka Přidej */
    @FXML
    private void handlePridej(ActionEvent event) {
        // název zvoleného tlačítka z ToggleGroup menu
        String toggleButton = urciToggleButton();
        // z vybraného Odkazu v seznamListView určí tabulku z databáze drddesk_db
        String tabulka = seznamOdkazu.getTabName(toggleButton);
        // nastavení vyskakovacího okna, "null" zobrazí prázdný formulář
        SeznamOdkazu.setAktualniOdkaz(null);
        // vyskakovací okno pro přidání nové položky
        otevriOkno(tabulka, "Přidat novou položku ");
        // Přidání nové postavy probíhá ve dvou fázích a také ve dvou formulářích.
        // V první fází - do formuláře NovaPostava.fxml vloží uživatel hodnoty,
        // které se už nemění, jako je jméno postavy, vlastnosti, atd.
        // Ve druhé fázi se tato nová postava, pouze částečně zadaná, otevře
        // ve formuláři Postava.fxml, tj. jako při editaci již existující postavy
        // a chybějící údaje může uživatel doplnit.
        if (logika.jeNovaPostava()) {
            otevriOkno(tabulka, "Upravit položku");
        }
        // obnovení seznamu Odkazů v seznamListView po vložení nové položky
        seznamOdkazu.nactiOdkazy(toggleButton);
    }

    /** Obsluha tlačítka Upravit */
    @FXML
    private void handleUpravit(ActionEvent event) {
        // načte zvolený odkaz v seznamlistView
        Odkaz odkaz = getOdkazZeSeznamListView();
        String tabulka = odkaz.getTabulka();
        // nastavení vyskakovacího okna, "odkaz" načte položku do formuláře pro úpravu
        SeznamOdkazu.setAktualniOdkaz(odkaz);
        // vyskakovací okno pro úpravu položky
        otevriOkno(tabulka, "Upravit položku ");
        // název zvoleného tlačítka z ToggleGroup menu
        String toggleButton = urciToggleButton();
        // obnovení seznamu Odkazů v seznamListView po vložení nové položky
        seznamOdkazu.nactiOdkazy(toggleButton);
        // obnovení podrobného popisu upravené položky v detailTextArea
        detailTextArea.setText(logika.ziskejPodrobnyPopis());
    }

    /** Obsluha tlačítka Smazat - smaže položku z databáze drddesk_db dle Odkazu */
    @FXML
    private void handleSmazat(ActionEvent event) {
        dataIn.smazPolozkuDleOdkazu(getOdkazZeSeznamListView());
        // obnovení seznamu Odkazů v seznamListView po smazání položky
        seznamOdkazu.nactiOdkazy(urciToggleButton());
    }

    /** Otevře okno dle předaných parametrů */
    private void otevriOkno(String tabulka, String pridatNeboUpravit) {
        String nazevOkna = pridatNeboUpravit + logika.getNazevZTabulkaDB(tabulka);
        String soubor = logika.getNazevSouboruFxmlPodleOdkazu(tabulka);
        Stage stage;
        Parent root;
        stage = new Stage();

        try {
            root = FXMLLoader.load(getClass().getResource(soubor));
            stage.setScene(new Scene(root));
            stage.setTitle(nazevOkna);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(pridatButton.getScene().getWindow());
            stage.showAndWait();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    /** Vrátí název vybraného tlačítka z ToggleGroup menu */
    private String urciToggleButton(){
        try {
            final ToggleButton tb = (ToggleButton)menu.selectedToggleProperty().get();
            return tb.getText();
        } catch (Exception e) {
            return null;
        }
    }

    /** vrátí Odkaz na vybranou položku seznamListView */
    private Odkaz getOdkazZeSeznamListView() {
        return seznamListView.getSelectionModel().getSelectedItem();
    }


}


