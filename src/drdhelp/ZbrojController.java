/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drdhelp;

import drdhelp.model.SeznamOdkazu;
import drdhelp.model.TabulkaDB;
import drdhelp.model.logika.ZbrojLogika;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



/**
 * FXML Controller class
 *
 * @author Michal Remišovský
 * @version 0.01.0000 — 2017-04-15
 */
public class ZbrojController implements Initializable {

    @FXML
    private TextField nazevTextField;
    @FXML
    private Label nazevChybaLabel;
    @FXML
    private ComboBox<ZbrojLogika.Typ> druhComboBox;
    @FXML
    private TextField kvalitaTextField;
    @FXML
    private Label kvalitaChybaLabel;
    @FXML
    private TextField vahaATextField;
    @FXML
    private Label vahaAChybaLabel;
    @FXML
    private TextField vahaBTextField;
    @FXML
    private Label vahaBChybaLabel;
    @FXML
    private TextField vahaCTextField;
    @FXML
    private Label vahaCChybaLabel;
    @FXML
    private TextField cenaATextField;
    @FXML
    private Label cenaAChybaLabel;
    @FXML
    private TextField cenaBTextField;
    @FXML
    private Label cenaBChybaLabel;
    @FXML
    private TextField cenaCTextField;
    @FXML
    private Label cenaCChybaLabel;
    @FXML
    private TextArea popisTextArea;
    @FXML
    private Button odejitButton;
    @FXML
    private Button vlozitButton;

    // logika formuláře - třída VybavaLogika
    private final ZbrojLogika logika = new ZbrojLogika();

    SeznamOdkazu seznamOdkazu = new SeznamOdkazu();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Při úpravě výbavy vloží do formuláře upravovanou položku výbavy,
        // při přidání nové ho nechá prázdný.
        // K určení slouží statická proměnná SeznamOdkazu.upravit typu Odkaz, kde
        // je uložený Odkaz na právě upravovanou položku nebo null.
        logika.naplnFormular();

        // naplnění comboboxu
        druhComboBox.getItems().setAll(Arrays.asList(ZbrojLogika.Typ.values()));

        // nastavení obousměrného bindingu
        Bindings.bindBidirectional(nazevTextField.textProperty(), logika
                                                        .nazevProperty());
        Bindings.bindBidirectional(druhComboBox.valueProperty(), logika
                                                        .druhObjectProperty());
        Bindings.bindBidirectional(kvalitaTextField.textProperty(), logika
                                                        .kvalitaProperty());
        Bindings.bindBidirectional(vahaATextField.textProperty(), logika
                                                        .vahaAProperty());
        Bindings.bindBidirectional(vahaBTextField.textProperty(), logika
                                                        .vahaBProperty());
        Bindings.bindBidirectional(vahaCTextField.textProperty(), logika
                                                        .vahaCProperty());
        Bindings.bindBidirectional(cenaATextField.textProperty(), logika
                                                        .cenaAProperty());
        Bindings.bindBidirectional(cenaBTextField.textProperty(), logika
                                                        .cenaBProperty());
        Bindings.bindBidirectional(cenaCTextField.textProperty(), logika
                                                        .cenaCProperty());
        Bindings.bindBidirectional(popisTextArea.textProperty(), logika
                                                        .popisProperty());

        Bindings.bindBidirectional(nazevChybaLabel.visibleProperty(), logika
                                                .nazevChybaVisibleProperty());
        Bindings.bindBidirectional(kvalitaChybaLabel.visibleProperty(), logika
                                                .kvalitaChybaVisibleProperty());
        Bindings.bindBidirectional(vahaAChybaLabel.visibleProperty(), logika
                                                .vahaAChybaVisibleProperty());
        Bindings.bindBidirectional(vahaBChybaLabel.visibleProperty(), logika
                                                .vahaBChybaVisibleProperty());
        Bindings.bindBidirectional(vahaCChybaLabel.visibleProperty(), logika
                                                .vahaCChybaVisibleProperty());
        Bindings.bindBidirectional(cenaAChybaLabel.visibleProperty(), logika
                                                .cenaAChybaVisibleProperty());
        Bindings.bindBidirectional(cenaBChybaLabel.visibleProperty(), logika
                                                .cenaBChybaVisibleProperty());
        Bindings.bindBidirectional(cenaCChybaLabel.visibleProperty(), logika
                                                .cenaCChybaVisibleProperty());

        // nabindování vlastnosti Disable na validitu formuláře
        vlozitButton.disableProperty().bind(logika.validProperty().not());

    }

    /** Obsluha tlačítka Vložit - aktualizuje údaje a zavře okna Výbava. */
    @FXML
    private void handleVlozit(ActionEvent event) {
        logika.pridejZbroj();
        zavriScenu();
    }

    /** Obsluha tlačítka Odejít - zavření dialogového okna Výbava. */
    @FXML
    private void handleOdejit(ActionEvent event) {
        zavriScenu();
    }

    /** Zavře okno a obnoví seznam odkazů u seznamListView pomocí metody
        nactiOdkazy() */
    private void zavriScenu() {
        Stage stage = (Stage) odejitButton.getScene().getWindow();
        stage.close();
        seznamOdkazu.nactiOdkazy(TabulkaDB.ZBROJ.getNazev());
    }

}


