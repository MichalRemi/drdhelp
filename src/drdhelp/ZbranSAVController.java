/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drdhelp;

import drdhelp.model.SeznamOdkazu;
import drdhelp.model.TabulkaDB;
import drdhelp.model.logika.ZbranSAVLogika;
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
 * @version 0.03.0000 — 2016-12-02
 */
public class ZbranSAVController implements Initializable {

    @FXML
    private TextField nazevTextField;
    @FXML
    private Label nazevChybaLabel;
    @FXML
    private ComboBox<ZbranSAVLogika.Druh> druhComboBox;
    @FXML
    private ComboBox<ZbranSAVLogika.Typ> typComboBox;
    @FXML
    private TextField silaTextField;
    @FXML
    private Label silaChybaLabel;
    @FXML
    private TextField utocnostTextField;
    @FXML
    private Label utocnostChybaLabel;
    @FXML
    private TextField malyDostrelTextField;
    @FXML
    private Label malyDostrelChybaLabel;
    @FXML
    private TextField stredniDostrelTextField;
    @FXML
    private Label stredniDostrelChybaLabel;
    @FXML
    private TextField velkyDostrelTextField;
    @FXML
    private Label velkyDostrelChybaLabel;
    @FXML
    private TextField vahaTextField;
    @FXML
    private Label vahaChybaLabel;
    @FXML
    private TextField zlatakyTextField;
    @FXML
    private Label zlatakyChybaLabel;
    @FXML
    private TextField stribrnakyTextField;
    @FXML
    private Label stribrnakyChybaLabel;
    @FXML
    private TextField medakyTextField;
    @FXML
    private Label medakyChybaLabel;
    @FXML
    private TextArea popisTextArea;
    @FXML
    private Button odejitButton;
    @FXML
    private Button vlozitButton;





    // logika formuláře - třída ZbranSAVLogika
    private final ZbranSAVLogika logika = new ZbranSAVLogika();

    SeznamOdkazu seznamOdkazu = new SeznamOdkazu();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Při úpravě zbraně SaV vloží do formuláře upravovanou položku zabraně SaV,
        // při přidání nové ho nechá prázdný. K určení slouží statická proměnná
        // SeznamOdkazu.upravit typu Odkaz, kde je uložený Odkaz na právě
        // upravovanou položku nebo null.
        logika.naplnFormular();

        // naplnění comboboxů
        druhComboBox.getItems().setAll(Arrays.asList(ZbranSAVLogika.Druh.values()));
        typComboBox.getItems().setAll(Arrays.asList(ZbranSAVLogika.Typ.values()));

        // nastavení obousměrného bindingu
        Bindings.bindBidirectional(nazevTextField.textProperty(), logika.nazevProperty());
        Bindings.bindBidirectional(druhComboBox.valueProperty(), logika.druhObjectProperty());
        Bindings.bindBidirectional(typComboBox.valueProperty(), logika.typObjectProperty());
        Bindings.bindBidirectional(silaTextField.textProperty(), logika.silaProperty());
        Bindings.bindBidirectional(utocnostTextField.textProperty(), logika.utocnostProperty());
        Bindings.bindBidirectional(malyDostrelTextField.textProperty(), logika.malyDostrelProperty());
        Bindings.bindBidirectional(stredniDostrelTextField.textProperty(), logika.stredniDostrelProperty());
        Bindings.bindBidirectional(velkyDostrelTextField.textProperty(), logika.velkyDostrelProperty());
        Bindings.bindBidirectional(vahaTextField.textProperty(), logika.vahaProperty());
        Bindings.bindBidirectional(zlatakyTextField.textProperty(), logika.zlatakyProperty());
        Bindings.bindBidirectional(stribrnakyTextField.textProperty(), logika.stribrnakyProperty());
        Bindings.bindBidirectional(medakyTextField.textProperty(), logika.medakyProperty());
        Bindings.bindBidirectional(popisTextArea.textProperty(), logika.popisProperty());

        Bindings.bindBidirectional(nazevChybaLabel.visibleProperty(), logika.nazevChybaVisibleProperty());
        Bindings.bindBidirectional(silaChybaLabel.visibleProperty(), logika.SilaChybaVisibleProperty());
        Bindings.bindBidirectional(utocnostChybaLabel.visibleProperty(), logika.UtocnostChybaVisibleProperty());
        Bindings.bindBidirectional(malyDostrelChybaLabel.visibleProperty(), logika.MalyDostrelChybaVisibleProperty());
        Bindings.bindBidirectional(stredniDostrelChybaLabel.visibleProperty(), logika.StredniDostrelChybaVisibleProperty());
        Bindings.bindBidirectional(velkyDostrelChybaLabel.visibleProperty(), logika.VelkyDostrelChybaVisibleProperty());
        Bindings.bindBidirectional(vahaChybaLabel.visibleProperty(), logika.vahaChybaVisibleProperty());
        Bindings.bindBidirectional(zlatakyChybaLabel.visibleProperty(), logika.zlatakyChybaVisibleProperty());
        Bindings.bindBidirectional(stribrnakyChybaLabel.visibleProperty(), logika.stribrnakyChybaVisibleProperty());
        Bindings.bindBidirectional(medakyChybaLabel.visibleProperty(), logika.medakyChybaVisibleProperty());

        // nabindování vlastnosti Disable na validitu formuláře
        vlozitButton.disableProperty().bind(logika.validProperty().not());

    }

    /** Obsluha tlačítka Vložit - aktualizuje údaje a zavře okna Výbava. */
    @FXML
    private void handleVlozit(ActionEvent event) {
        logika.pridejZbranSAV();
        zavriScenu();
    }


    /** Obsluha tlačítka Odejít - zavření dialogového okna Zbraň SaV. */
    @FXML
    private void handleOdejit(ActionEvent event) {
        zavriScenu();
    }

    /** Zavře okno a obnoví seznam odkazů u seznamListView pomocí metody nactiOdkazy()*/
    private void zavriScenu() {
        Stage stage = (Stage) odejitButton.getScene().getWindow();
        stage.close();
        seznamOdkazu.nactiOdkazy(TabulkaDB.ZBRAN_SAV.getNazev());
    }






}


