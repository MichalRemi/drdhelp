/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drdhelp;

import drdhelp.model.Odkaz;
import drdhelp.model.TabulkaDB;
import drdhelp.model.io.DataOut;
import drdhelp.model.logika.NovaPostavaLogika;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



/**
 * FXML Controller class
 *
 * @author Michal Remišovský
 */
public class NovaPostavaController implements Initializable {

    @FXML
    private TextField nazevTextField;
    @FXML
    private Label nazevChybaLabel;
    @FXML
    private ComboBox<Odkaz> rasaComboBox;
    @FXML
    private TextField velikostTextField;
    @FXML
    private TextField rodovaZbranTextField;
    @FXML
    private ComboBox<Odkaz> povolaniComboBox;
    @FXML
    private TextField vyskaTextField;
    @FXML
    private Label vyskaChybaLabel;
    @FXML
    private TextField vahaTextField;
    @FXML
    private Label vahaChybaLabel;
    @FXML
    private ComboBox<Integer> silaComboBox;
    @FXML
    private TextField silaBonusTextField;
    @FXML
    private ComboBox<Integer> obratnostComboBox;
    @FXML
    private TextField obratnostBonusTextField;
    @FXML
    private ComboBox<Integer> odolnostComboBox;
    @FXML
    private TextField odolnostBonusTextField;
    @FXML
    private ComboBox<Integer> inteligenceComboBox;
    @FXML
    private TextField inteligenceBonusTextField;
    @FXML
    private ComboBox<Integer> charismaComboBox;
    @FXML
    private TextField charismaBonusTextField;
    @FXML
    private TextField pohyblivostTextField;
    @FXML
    private TextField pohyblivostBonusTextField;
    @FXML
    private Button odejitButton;
    @FXML
    private Button generujButton;
    @FXML
    private Button pokracujButton;

    ObservableList<Odkaz> rasa = FXCollections.observableArrayList();
    ObservableList<Odkaz> povolani = FXCollections.observableArrayList();


    // načítání dat z databáze
    DataOut getData = new DataOut();

    // logika formuláře
    NovaPostavaLogika logika = new NovaPostavaLogika();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // naplnění ComboBoxů
        ArrayList<Odkaz> rasaArrayList = getData.nactiOdkazy(
                TabulkaDB.RASA.getTabNazev());
        rasa.addAll(rasaArrayList);

        ArrayList<Odkaz> povolaniArrayList = getData.nactiOdkazy(
                TabulkaDB.POVOLANI.getTabNazev());
        povolani.addAll(povolaniArrayList);

        rasaComboBox.setItems(rasa);
        povolaniComboBox.setItems(povolani);

        // nastavení hodnot ComboBoxů vlastností na ObservableListy<Integer>
        silaComboBox.setItems(logika.getSila());
        obratnostComboBox.setItems(logika.getObratnost());
        odolnostComboBox.setItems(logika.getOdolnost());
        inteligenceComboBox.setItems(logika.getInteligence());
        charismaComboBox.setItems(logika.getCharisma());

        // Nabindování Disable vlastností na validitu platného výběru rasy a povolání.
        // Vlastnosti bude možné zvolit nebo generovat pouze tehdy, jsou-li rasa
        // a povolání vybrané. Meze Vlastností jsou dány právě rasou a povoláním.
        silaComboBox.disableProperty().bind(logika.jeVybranaRasaAPovolani().not());
        obratnostComboBox.disableProperty().bind(logika.jeVybranaRasaAPovolani().not());
        odolnostComboBox.disableProperty().bind(logika.jeVybranaRasaAPovolani().not());
        inteligenceComboBox.disableProperty().bind(logika.jeVybranaRasaAPovolani().not());
        charismaComboBox.disableProperty().bind(logika.jeVybranaRasaAPovolani().not());
        generujButton.disableProperty().bind(logika.jeVybranaRasaAPovolani().not());

        // Nabindování Disable vlastnosti výšky a váhy na platný výběr rasy
        vyskaTextField.disableProperty().bind(rasaComboBox.valueProperty().isNull());
        vahaTextField.disableProperty().bind(rasaComboBox.valueProperty().isNull());

        // Nabindování Disable vlastnosti tlačítka Pokračuj na validitu formuláře.
        pokracujButton.disableProperty().bind(logika.validProperty().not());

        // nastavení obousměrného bindingu - text a visible
        Bindings.bindBidirectional(nazevTextField.textProperty(),
                logika.nazevProperty());

        Bindings.bindBidirectional(nazevChybaLabel.visibleProperty(),
                logika.nazevChybaVisibleProperty());

        Bindings.bindBidirectional(rasaComboBox.valueProperty(),
                logika.rasaProperty());

        Bindings.bindBidirectional(velikostTextField.textProperty(),
                logika.velikostProperty());

        Bindings.bindBidirectional(rodovaZbranTextField.textProperty(),
                logika.rodovaZbranProperty());

        Bindings.bindBidirectional(povolaniComboBox.valueProperty(),
                logika.povolaniProperty());

        Bindings.bindBidirectional(vyskaTextField.textProperty(),
                logika.vyskaProperty());

        Bindings.bindBidirectional(vyskaChybaLabel.textProperty(),
                logika.vyskaChybaProperty());

        Bindings.bindBidirectional(vyskaChybaLabel.visibleProperty(),
                logika.vyskaChybaVisibleProperty());

        Bindings.bindBidirectional(vahaTextField.textProperty(),
                logika.vahaProperty());

        Bindings.bindBidirectional(vahaChybaLabel.textProperty(),
                logika.vahaChybaProperty());

        Bindings.bindBidirectional(vahaChybaLabel.visibleProperty(),
                logika.vahaChybaVisibleProperty());

        Bindings.bindBidirectional(silaComboBox.valueProperty(),
                logika.silaProperty());

        Bindings.bindBidirectional(silaBonusTextField.textProperty(),
                logika.silaBonusProperty());

        Bindings.bindBidirectional(obratnostComboBox.valueProperty(),
                logika.obratnostProperty());

        Bindings.bindBidirectional(obratnostBonusTextField.textProperty(),
                logika.obratnostBonusProperty());

        Bindings.bindBidirectional(odolnostComboBox.valueProperty(),
                logika.odolnostProperty());

        Bindings.bindBidirectional(odolnostBonusTextField.textProperty(),
                logika.odolnostBonusProperty());

        Bindings.bindBidirectional(inteligenceComboBox.valueProperty(),
                logika.inteligenceProperty());

        Bindings.bindBidirectional(inteligenceBonusTextField.textProperty(),
                logika.inteligenceBonusProperty());

        Bindings.bindBidirectional(charismaComboBox.valueProperty(),
                logika.charismaProperty());

        Bindings.bindBidirectional(charismaBonusTextField.textProperty(),
                logika.charismaBonusProperty());

        Bindings.bindBidirectional(pohyblivostTextField.textProperty(),
                logika.pohyblivostProperty());

        Bindings.bindBidirectional(pohyblivostBonusTextField.textProperty(),
                logika.pohyblivostBonusProperty());


    }

    /** Obsluha tlačítka Odejít - zavření dialogového okna Nová postava. */
    @FXML
    private void handleOdejit(ActionEvent event) {
        zavriScenu();
    }

    /** Obsluha tlačítka Generuj Vlastnosti. */
    @FXML
    private void handleNahodneVlastnosti (ActionEvent event) {
        logika.nastavNahodneVlastnosti();
    }

    /** Obsluha tlačítka Pokračuj. */
    @FXML
    private void handlePokracuj (ActionEvent event) {
        logika.pokracujLogika();
        zavriScenu();
    }

    /** Zavře okno a obnoví seznam odkazů u seznamListView pomocí metody nactiOdkazy()*/
    private void zavriScenu() {
        Stage stage = (Stage) odejitButton.getScene().getWindow();
        stage.close();
    }





}


