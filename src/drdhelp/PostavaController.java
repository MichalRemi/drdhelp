/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drdhelp;

import drdhelp.model.Odkaz;
import drdhelp.model.SeznamOdkazu;
import drdhelp.model.io.DataOut;
import drdhelp.model.logika.PostavaLogika;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;



/**
 * FXML Controller class
 *
 * @author Michal Remišovský
 * @version 0.01.0000 — 2017-04-15
 */
public class PostavaController implements Initializable {

    // hlavička
    @FXML
    private TextField nazevTextField;
    @FXML
    private TextField rasaTextField;
    @FXML
    private TextField povolaniTextField;
    @FXML
    private ComboBox<Integer> urovenComboBox;
    @FXML
    private TextField zkusenostiTextField;
    @FXML
    private TextField zkusenostiDalsiUrovenTField;
    @FXML
    private TextField zivotyTextField;
    @FXML
    private TextField magyTextField;
    @FXML
    private TextField vyskaTextField;
    @FXML
    private TextField vahaTextField;
    // vlastnosti
    @FXML
    private TextField silaTextField;
    @FXML
    private TextField silaBonusTextField;
    @FXML
    private TextField obratnostTextField;
    @FXML
    private TextField obratnostBonusTextField;
    @FXML
    private TextField odolnostTextField;
    @FXML
    private TextField odolnostbonusTextField;
    @FXML
    private TextField inteligenceTextField;
    @FXML
    private TextField inteligenceBonusTextField;
    @FXML
    private TextField charismaTextField;
    @FXML
    private TextField charismaBonusTextField;
    @FXML
    private TextField pohyblivostTextField;
    @FXML
    private TextField pohyblivostBonusTextField;
    @FXML
    private TextField velikostTextField;
    // výzbroj
    @FXML
    private ListView<Odkaz> zbranTVTListView;
    @FXML
    private Button pridejZbranTVTButton;
    @FXML
    private Button odeberZbranTVTButton;
    @FXML
    private ListView<Odkaz> zbranSAVListView;
    @FXML
    private Button pridejZbranSAVButton;
    @FXML
    private Button odeberZbranSAVButton;
    @FXML
    private ListView<Odkaz> zbrojListView;
    @FXML
    private Button pridejZbrojButton;
    @FXML
    private Button odeberZbrojButton;
    // zvláštní schonnosti, kouzla, výbava, poznámka
    @FXML
    private ListView<Odkaz> zvlListView;
    @FXML
    private Button pridejZvlButton;
    @FXML
    private Button odeberZvlButton;
    @FXML
    private ListView<Odkaz> kouzlaListView;
    @FXML
    private Button pridejKouzloButton;
    @FXML
    private Button odeberKouzloVButton;
    @FXML
    private VBox magyVBox;
    @FXML
    private HBox kouzlaHBox;
    @FXML
    private ListView<Odkaz> vybavaListView;
    @FXML
    private Button pridejVybavaButton;
    @FXML
    private Button odeberVybavaButton;
    @FXML
    private TextArea popisTextArea;

    @FXML
    private Button odejitButton;
    @FXML
    private Button vlozitButton;


    DataOut dataOut = new DataOut();
    SeznamOdkazu seznamOdkazu = new SeznamOdkazu();
    PostavaLogika logika = new PostavaLogika();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // načte se nová nebo upravovaná postava
        logika.naplnFormular();

        // nastavení disable magů a kouzel.
        boolean postavaKouzli = PostavaLogika.getPostavaKouzli();
        magyVBox.setDisable(!postavaKouzli);
        kouzlaListView.setDisable(!postavaKouzli);
        kouzlaHBox.setDisable(!postavaKouzli);

        // bindování disable tlačítek "-"
        odeberZbranTVTButton.disableProperty().bind(zbranTVTListView
                .getSelectionModel().selectedItemProperty().isNull());
        odeberZbranSAVButton.disableProperty().bind(zbranSAVListView
                .getSelectionModel().selectedItemProperty().isNull());
        odeberZbrojButton.disableProperty().bind(zbrojListView
                .getSelectionModel().selectedItemProperty().isNull());
        odeberZvlButton.disableProperty().bind(zvlListView
                .getSelectionModel().selectedItemProperty().isNull());
        if (postavaKouzli) {
            odeberKouzloVButton.disableProperty().bind(kouzlaListView
                    .getSelectionModel().selectedItemProperty().isNull());
        }
        odeberVybavaButton.disableProperty().bind(vybavaListView
                .getSelectionModel().selectedItemProperty().isNull());

        // zrušení výběru po opuštění listView
        zbranTVTListView.focusedProperty().addListener((ObservableValue<? extends
                Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (!newValue) zbranTVTListView.getSelectionModel().select(null);
        });
        zbranSAVListView.focusedProperty().addListener((ObservableValue<? extends
                Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (!newValue) zbranSAVListView.getSelectionModel().select(null);
        });
        zbrojListView.focusedProperty().addListener((ObservableValue<? extends
                Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (!newValue) zbrojListView.getSelectionModel().select(null);
        });
        zvlListView.focusedProperty().addListener((ObservableValue<? extends
                Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (!newValue) zvlListView.getSelectionModel().select(null);
        });
        if (postavaKouzli) {
            kouzlaListView.focusedProperty().addListener((ObservableValue<? extends
                    Boolean> observable, Boolean oldValue, Boolean newValue) -> {
                if (!newValue) kouzlaListView.getSelectionModel().select(null);
            });
        }
        vybavaListView.focusedProperty().addListener((ObservableValue<? extends
                Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (!newValue) vybavaListView.getSelectionModel().select(null);
        });

        // naplnění ComboBoxu - propojení s kolekcí z PostavaLogika
        urovenComboBox.setItems(logika.getUrovenList());

        // provázání listView s kolekcemi z PostavaLogika
        zbranTVTListView.setItems(logika.getZbranTVTList());
        zbranSAVListView.setItems(logika.getZbranSAVList());
        zbrojListView.setItems(logika.getZbrojList());
        zvlListView.setItems(logika.getZvlSchList());
        if (postavaKouzli) kouzlaListView.setItems(logika.getKouzlaList());
        vybavaListView.setItems(logika.getVybavaList());

        // nastavení obousměrného bindingu
        Bindings.bindBidirectional(nazevTextField.textProperty(),
                logika.nazevProperty());

        Bindings.bindBidirectional(rasaTextField.textProperty(),
                logika.rasaProperty());

        Bindings.bindBidirectional(povolaniTextField.textProperty(),
                logika.povolaniProperty());

        Bindings.bindBidirectional(urovenComboBox.valueProperty(),
                logika.urovenProperty());

        Bindings.bindBidirectional(zkusenostiTextField.textProperty(),
                logika.zkusenostiProperty());

        Bindings.bindBidirectional(zkusenostiTextField.styleProperty(),
                logika.zkusenostiStyleProperty());

        Bindings.bindBidirectional(zkusenostiDalsiUrovenTField.textProperty(),
                logika.zkusenostiNaDalsiUrovenProperty());

        Bindings.bindBidirectional(zivotyTextField.textProperty(),
                logika.zivotyProperty());

        Bindings.bindBidirectional(zivotyTextField.styleProperty(),
                logika.zivotyStyleProperty());

        if (postavaKouzli) {
            Bindings.bindBidirectional(magyTextField.textProperty(),
                    logika.magyProperty());

            Bindings.bindBidirectional(magyTextField.styleProperty(),
                    logika.magyStyleProperty());
        }

        Bindings.bindBidirectional(vyskaTextField.textProperty(),
                logika.vyskaProperty());

        Bindings.bindBidirectional(vahaTextField.textProperty(),
                logika.vahaProperty());

        Bindings.bindBidirectional(silaTextField.textProperty(),
                logika.silaProperty());

        Bindings.bindBidirectional(silaBonusTextField.textProperty(),
                logika.silaBonusProperty());

        Bindings.bindBidirectional(obratnostTextField.textProperty(),
                logika.obratnostProperty());

        Bindings.bindBidirectional(obratnostBonusTextField.textProperty(),
                logika.obratnostBonusProperty());

        Bindings.bindBidirectional(odolnostTextField.textProperty(),
                logika.odolnostProperty());

        Bindings.bindBidirectional(odolnostbonusTextField.textProperty(),
                logika.odolnostBonusProperty());

        Bindings.bindBidirectional(inteligenceTextField.textProperty(),
                logika.inteligenceProperty());

        Bindings.bindBidirectional(inteligenceBonusTextField.textProperty(),
                logika.inteligenceBonusProperty());

        Bindings.bindBidirectional(charismaTextField.textProperty(),
                logika.charismaProperty());

        Bindings.bindBidirectional(charismaBonusTextField.textProperty(),
                logika.charismaBonusProperty());

        Bindings.bindBidirectional(pohyblivostTextField.textProperty(),
                logika.pohyblivostProperty());

        Bindings.bindBidirectional(pohyblivostBonusTextField.textProperty(),
                logika.pohyblivostBonusProperty());

        Bindings.bindBidirectional(velikostTextField.textProperty(),
                logika.velikostProperty());

    }

    /** Obsluha tlačítka Vložit - aktualizuje údaje a zavře okna Postava. */
    @FXML
    private void handleVlozit(ActionEvent event) {
        logika.pridejPostavu();
        zavriScenu();
    }

    /** Obsluha tlačítka Odejít - zavření dialogového okna Postava. */
    @FXML
    private void handleOdejit(ActionEvent event) {
        logika.odejitLogika();
        zavriScenu();
    }

    /** Obsluha tlačítka "+" - přidej zbraň tvt*/
    @FXML
    private void handlePridejZbranTVT(ActionEvent event) {
        logika.nastavPridejZbranTVT();
        otevriOknoPridej();

    }

    /** Obsluha tlačítka "-" - smaž zbraň tvt*/
    @FXML
    private void handleSmazZbranTVT(ActionEvent event) {
        logika.smazZbranTVT(zbranTVTListView.getSelectionModel().getSelectedItem());
    }

    /** Obsluha tlačítka "+" - přidej zbraň sav*/
    @FXML
    private void handlePridejZbranSAV(ActionEvent event) {
        logika.nastavPridejZbranSAV();
        otevriOknoPridej();
    }

    /** Obsluha tlačítka "-" - smaž zbraň sav*/
    @FXML
    private void handleSmazZbranSAV(ActionEvent event) {
        logika.smazZbranSAV(zbranSAVListView.getSelectionModel().getSelectedItem());
    }

    /** Obsluha tlačítka "+" - přidej zbroj*/
    @FXML
    private void handlePridejZbroj(ActionEvent event) {
        logika.nastavPridejZbroj();
        otevriOknoPridej();
    }

    /** Obsluha tlačítka "-" - smaž zbroj*/
    @FXML
    private void handleSmazZbroj(ActionEvent event) {
        logika.smazZbroj(zbrojListView.getSelectionModel().getSelectedItem());
    }

    /** Obsluha tlačítka "+" - přidej zvláštní schopnost*/
    @FXML
    private void handlePridejZvlSchopnost(ActionEvent event) {
        logika.nastavPridejZvlSchopnost();
        otevriOknoPridej();
    }

        /** Obsluha tlačítka "-" - smaž zvláštní schopost*/
    @FXML
    private void handleSmazZvlSchopnost(ActionEvent event) {
        logika.smazZvlSchopnost(zvlListView.getSelectionModel().getSelectedItem());
    }

    /** Obsluha tlačítka "+" - přidej kouzlo*/
    @FXML
    private void handlePridejKouzlo(ActionEvent event) {
        logika.nastavPridejKouzlo();
        otevriOknoPridej();
    }

    /** Obsluha tlačítka "-" - smaž kouzlo*/
    @FXML
    private void handleSmazKouzlo(ActionEvent event) {
        logika.smazKouzlo(kouzlaListView.getSelectionModel().getSelectedItem());
    }

    /** Obsluha tlačítka "+" - přidej výbavu*/
    @FXML
    private void handlePridejVybava(ActionEvent event) {
        logika.nastavPridejVybava();
        otevriOknoPridej();
    }

    /** Obsluha tlačítka "-" - smaž výbavu*/
    @FXML
    private void handleSmazvybavu(ActionEvent event) {
        logika.smazVybava(vybavaListView.getSelectionModel().getSelectedItem());
    }

    /** Zavře okno a obnoví seznam odkazů u seznamListView pomocí metody
        nactiOdkazy(). */
    private void zavriScenu() {
        Stage stage = (Stage) odejitButton.getScene().getWindow();
        stage.close();
        // seznamOdkazu.nactiOdkazy(TabulkaDB.POSTAVA.getNazev());
    }

    private void otevriOknoPridej() {
        Stage stage;
        Parent root;
        stage = new Stage();
        try {
            root = FXMLLoader.load(getClass().getResource("Pridej.fxml"));
            stage.setScene(new Scene(root));
            stage.setTitle("Přidej");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(vlozitButton.getScene().getWindow());
            stage.showAndWait();
            logika.zrusOdkazNaObservableList();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }


}


