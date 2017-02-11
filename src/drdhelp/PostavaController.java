/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drdhelp;

import drdhelp.model.Odkaz;
import drdhelp.model.SeznamOdkazu;
import drdhelp.model.io.GetData;
import drdhelp.model.logika.PostavaLogika;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



/**
 * FXML Controller class
 *
 * @author Michal Remišovský
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


    GetData getData = new GetData();
    SeznamOdkazu seznamOdkazu = new SeznamOdkazu();
    PostavaLogika logika = new PostavaLogika();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // naplnění ComboBoxu - propojení s kolekcí z PostavaLogika
        urovenComboBox.setItems(logika.getUrovenList());

        // provázání listView s kolekcemi z PostavaLogika
        zbranTVTListView.setItems(logika.getZbranTVTList());
        zbranSAVListView.setItems(logika.getZbranSAVList());
        zbrojListView.setItems(logika.getZbrojList());
        zvlListView.setItems(logika.getZvlSchList());
        kouzlaListView.setItems(logika.getKouzlaList());
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

        Bindings.bindBidirectional(zkusenostiDalsiUrovenTField.textProperty(),
                logika.zkusenostiNaDalsiUrovenProperty());

        Bindings.bindBidirectional(zivotyTextField.textProperty(),
                logika.zivotyProperty());

        Bindings.bindBidirectional(magyTextField.textProperty(),
                logika.magyProperty());

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
                logika.odolnostBonusProperty());

        Bindings.bindBidirectional(odolnostbonusTextField.textProperty(),
                logika.odolnostBonusProperty());

        Bindings.bindBidirectional(inteligenceTextField.textProperty(),
                logika.inteligenceBonusProperty());

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

        logika.naplnFormular();




    }

    /** Obsluha tlačítka Vložit - aktualizuje údaje a zavře okna Výbava. */
    @FXML
    private void handleVlozit(ActionEvent event) {
        // logika.pridejNestvuru();
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
        // seznamOdkazu.nactiOdkazy(TabulkaDB.POSTAVA.getNazev());
    }


}


