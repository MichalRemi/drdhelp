/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drdhelp;

import drdhelp.model.Nestvura;
import drdhelp.model.SeznamOdkazu;
import drdhelp.model.Tvor;
import drdhelp.model.logika.NestvuraLogika;
import java.net.URL;
import java.util.Arrays;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;



/**
 * FXML Controller class
 *
 * @author Michal Remišovský
 * @version 0.01.0000 — 2017-04-15
 */
public class NestvuraController implements Initializable {

    @FXML
    private TextField nazevTextField;
    @FXML
    private Label nazevChybaLabel;
    @FXML
    private ComboBox<String> zivotaschopnostComboBox;
    @FXML
    private ComboBox<String> konstantaZvtComboBox;
    @FXML
    private TextField utokTextField;
    @FXML
    private Label utokChybaLabel;
    @FXML
    private TextField obranaTextField;
    @FXML
    private Label obranaChybaLabel;
    @FXML
    private ComboBox<String> silaComboBox;
    @FXML
    private ComboBox<String> obratnostComboBox;
    @FXML
    private ComboBox<String> odolnostComboBox;
    @FXML
    private ComboBox<String> inteligenceComboBox;
    @FXML
    private ComboBox<String> charismaComboBox;
    @FXML
    private ComboBox<Nestvura.VelikostNestvura> velikostComboBox;
    @FXML
    private ComboBox<String> bojovnostComboBox;
    @FXML
    private ComboBox<Nestvura.Zranitelnost> zranitelnostComboBox;
    @FXML
    private Button polovinaButton;
    @FXML
    private Button ctvrtinaButton;
    @FXML
    private TextField skupinyZranitelnostTextField;
    @FXML
    private Label skupinyZranitelnostChybaLabel;
    @FXML
    private ComboBox<Nestvura.Pohyblivost> pohyblivostComboBox;
    @FXML
    private ComboBox<String> hodnotyPohyblivostComboBox;
    @FXML
    private ComboBox<Nestvura.Pohyblivost> vytrvalostComboBox;
    @FXML
    private ComboBox<String> hodnotyVytrvalosttComboBox;
    @FXML
    private ComboBox<String> manevrSchopnostComboBox;
    @FXML
    private TextField zaklSilaMysliTextField;
    @FXML
    private Label zaklSilaMysliChybaLabel;
    @FXML
    private ComboBox<Nestvura.Presvedceni> presvedceniComboBox;
    @FXML
    private ComboBox<String> ochoceniComboBox;
    @FXML
    private TextField pokladyTextField;
    @FXML
    private TextField zkusenostiTextField;
    @FXML
    private Label zkusenostiChybaLabel;
    @FXML
    private TextArea popisTextArea;
    @FXML
    private Button odejitButton;
    @FXML
    private Button vlozitButton;

    ObservableList<String> bojovnost = FXCollections.observableArrayList();
    ObservableList<String> hodnoty = FXCollections.observableArrayList();
    ObservableList<String> hodnotyNA = FXCollections.observableArrayList();
    ObservableList<String> hodnotyZvt = FXCollections.observableArrayList();

    NestvuraLogika logika = new NestvuraLogika();
    SeznamOdkazu seznamOdkazu = new SeznamOdkazu();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Při úpravě nestvůry vloží do formuláře upravovanou položku výbavy,
        // při přidání nové ho nechá prázdný. K určení slouží statická proměnná
        // SeznamOdkazu.upravit typu Odkaz, kde je uložený Odkaz na právě
        // upravovanou položku nebo null.
        logika.naplnFormular();

        // naplnění comboboxů
        bojovnost.addAll(Nestvura.bojovnostArray);
        hodnotyZvt.addAll(Nestvura.hodnotyZvtArray);
        hodnoty.addAll(Tvor.hodnotyArray);
        hodnotyNA.addAll(Tvor.hodnotyNAArray);

        zivotaschopnostComboBox.setItems(hodnotyZvt);
        konstantaZvtComboBox.setItems(hodnotyNA);

        silaComboBox.setItems(hodnotyNA);
        obratnostComboBox.setItems(hodnotyNA);
        odolnostComboBox.setItems(hodnotyNA);
        inteligenceComboBox.setItems(hodnotyNA);
        charismaComboBox.setItems(hodnotyNA);
        velikostComboBox.getItems().setAll(Arrays.asList(Nestvura
                                                        .VelikostNestvura.values()));
        bojovnostComboBox.setItems(bojovnost);
        zranitelnostComboBox.getItems().setAll(Arrays.asList(Nestvura
                                                        .Zranitelnost.values()));
        hodnotyPohyblivostComboBox.setItems(hodnoty);
        pohyblivostComboBox.getItems().setAll(Arrays.asList(Nestvura
                                                        .Pohyblivost.values()));
        hodnotyVytrvalosttComboBox.setItems(hodnoty);
        vytrvalostComboBox.getItems().setAll(Arrays.asList(Nestvura
                                                         .Pohyblivost.values()));
        manevrSchopnostComboBox.setItems(hodnotyNA);
        ochoceniComboBox.setItems(hodnotyNA);
        presvedceniComboBox.getItems().setAll(Arrays.asList(Nestvura
                                                         .Presvedceni.values()));

        // Nastanení vlastnosti disable na false u tlačítek polovinaButton a
        // ctvrtinaButton, když bude toto pole editované. Tlačítka slouží
        // k vkládání spec. znaků 1/2 a 1/4 do pole skupinyZranitelnostTextField,
        polovinaButton.disableProperty().bind(
                        skupinyZranitelnostTextField.focusedProperty().not());
        ctvrtinaButton.disableProperty().bind(
                        skupinyZranitelnostTextField.focusedProperty().not());

        // nastavení obousměrného bindingu
        Bindings.bindBidirectional(nazevTextField.textProperty(),
                                   logika.nazevProperty());
        Bindings.bindBidirectional(zivotaschopnostComboBox.valueProperty(),
                                   logika.zivotaschopnostProperty());
        Bindings.bindBidirectional(konstantaZvtComboBox.valueProperty(),
                                   logika.konstantaZvtProperty());
        Bindings.bindBidirectional(utokTextField.textProperty(),
                                   logika.utokProperty());
        Bindings.bindBidirectional(obranaTextField.textProperty(),
                                   logika.obranaProperty());
        Bindings.bindBidirectional(silaComboBox.valueProperty(),
                                   logika.silaProperty());
        Bindings.bindBidirectional(obratnostComboBox.valueProperty(),
                                   logika.obratnostProperty());
        Bindings.bindBidirectional(odolnostComboBox.valueProperty(),
                                   logika.odolnostProperty());
        Bindings.bindBidirectional(inteligenceComboBox.valueProperty(),
                                   logika.inteligenceProperty());
        Bindings.bindBidirectional(charismaComboBox.valueProperty(),
                                   logika.charismaProperty());
        Bindings.bindBidirectional(velikostComboBox.valueProperty(),
                                   logika.velikostProperty());
        Bindings.bindBidirectional(bojovnostComboBox.valueProperty(),
                                   logika.bojovnostObjectProperty());
        Bindings.bindBidirectional(zranitelnostComboBox.valueProperty(),
                                   logika.zranitelnostObjectProperty());
        Bindings.bindBidirectional(skupinyZranitelnostTextField.textProperty(),
                                   logika.skupinyZranitelnostProperty());
        Bindings.bindBidirectional(pohyblivostComboBox.valueProperty(),
                                   logika.pohyblivostObjectProperty());
        Bindings.bindBidirectional(hodnotyPohyblivostComboBox.valueProperty(),
                                   logika.hodnotyPohyblivostObjectProperty());
        Bindings.bindBidirectional(vytrvalostComboBox.valueProperty(),
                                   logika.VytrvalostObjectProperty());
        Bindings.bindBidirectional(hodnotyVytrvalosttComboBox.valueProperty(),
                                   logika.hodnotyVytrvalostObjectProperty());
        Bindings.bindBidirectional(manevrSchopnostComboBox.valueProperty(),
                                   logika.manevrSchopnostProperty());
        Bindings.bindBidirectional(zaklSilaMysliTextField.textProperty(),
                                   logika.zaklSilaMysliProperty());
        Bindings.bindBidirectional(ochoceniComboBox.valueProperty(),
                                   logika.ochoceniProperty());
        Bindings.bindBidirectional(presvedceniComboBox.valueProperty(),
                                   logika.presvedceniObjectProperty());
        Bindings.bindBidirectional(pokladyTextField.textProperty(),
                                   logika.pokladyProperty());
        Bindings.bindBidirectional(zkusenostiTextField.textProperty(),
                                   logika.zkusenostiProperty());
        Bindings.bindBidirectional(popisTextArea.textProperty(),
                                   logika.popisProperty());

        Bindings.bindBidirectional(nazevChybaLabel.visibleProperty(),
                                   logika.nazevChybaVisibleProperty());
        Bindings.bindBidirectional(utokChybaLabel.visibleProperty(),
                                   logika.utokChybaVisibleProperty());
        Bindings.bindBidirectional(obranaChybaLabel.visibleProperty(),
                                   logika.obranaChybaVisibleProperty());
        Bindings.bindBidirectional(skupinyZranitelnostChybaLabel.visibleProperty(),
                                   logika.skupinyZranitelnostChybaVisibleProperty());
        Bindings.bindBidirectional(zkusenostiChybaLabel.visibleProperty(),
                                   logika.zkusenostiChybaVisibleProperty());
        Bindings.bindBidirectional(zaklSilaMysliChybaLabel.visibleProperty(),
                                   logika.zaklSilaMysliChybaVisibleProperty());


        // nabindování vlastnosti Disable na validitu formuláře
        vlozitButton.disableProperty().bind(logika.validProperty().not());

    }

    /** Obsluha tlačítka Vložit - aktualizuje údaje a zavře okna Výbava. */
    @FXML
    private void handleVlozit(ActionEvent event) {
        logika.pridejNestvuru();
        zavriScenu();
    }

    /** Obsluha tlačítka Odejít - zavření dialogového okna Výbava. */
    @FXML
    private void handleOdejit(ActionEvent event) {
        zavriScenu();
    }

    /** Zavře okno a obnoví seznam odkazů u seznamListView pomocí metody nactiOdkazy()*/
    private void zavriScenu() {
        Stage stage = (Stage) odejitButton.getScene().getWindow();
        stage.close();
        // seznamOdkazu.nactiOdkazy(TabulkaDB.NESTVURA.getNazev());
    }

    /** Obsluha tlačítka polovina */
    @FXML
    private void handlePolovina(ActionEvent event) {
        skupinyZranitelnostTextField.insertText(logika.getPoziceKurzoru(), "½");
    }

    /** Obsluha tlačítka polovina */
    @FXML
    private void handleCtvrtina(ActionEvent event) {
        skupinyZranitelnostTextField.insertText(logika.getPoziceKurzoru(), "¼");
    }

    @FXML
    private void poziceKurzoruKey(KeyEvent event) {
        logika.setPoziceKurzoru(skupinyZranitelnostTextField
                                            .caretPositionProperty().getValue());
    }

    @FXML
    private void poziceKurzoruMouse(MouseEvent event) {
        logika.setPoziceKurzoru(skupinyZranitelnostTextField
                                            .caretPositionProperty().getValue());
    }


}


