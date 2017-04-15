/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drdhelp;

import drdhelp.model.Odkaz;
import drdhelp.model.logika.PostavaLogika;
import drdhelp.model.logika.PridejLogika;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;



/**
 * FXML Controller class
 *
 * @author Michal Remišovský
 * @version 0.01.0000 — 2017-04-15
 */
public class PridejController implements Initializable {

    @FXML
    private Label nazevLabel;
    @FXML
    private Label seznamPolozekLabel;
    @FXML
    private Label polozkyPostavyLabel;
    @FXML
    private ListView<Odkaz> seznamPolozekListView;
    @FXML
    private ListView<Odkaz> polozkyPostavyListView;
    @FXML
    private Button pridejButton;
    @FXML
    private Button odeberButton;
    @FXML
    private Button odejitButton;
    @FXML
    private Button vlozitButton;

    PridejLogika logika = new PridejLogika();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // texty labelů
        nazevLabel.setText(PostavaLogika.getTextyFormulare().toString());
        seznamPolozekLabel.setText(PostavaLogika.getTextyFormulare().getSeznamPolozek());
        polozkyPostavyLabel.setText(PostavaLogika.getTextyFormulare().getPolozkyPostavy());

        // provázání listView s kolekcemi z PridejLogika
        seznamPolozekListView.setItems(logika.seznamPolozekList());
        polozkyPostavyListView.setItems(logika.polozkyPostavyList());

        // bind vlastnosti disable tlačítek přidej a odeber na nevýběr příslušných
        // listView
        pridejButton.disableProperty().bind(seznamPolozekListView.getSelectionModel().
                selectedItemProperty().isNull());

        odeberButton.disableProperty().bind(polozkyPostavyListView.getSelectionModel().
                selectedItemProperty().isNull());

        // zrušení výběru po opuštění listView
        seznamPolozekListView.focusedProperty().addListener((ObservableValue<? extends
                Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (!newValue) {
                seznamPolozekListView.getSelectionModel().select(null);
            }
        });

        polozkyPostavyListView.focusedProperty().addListener((ObservableValue<? extends
                Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (!newValue) {
                polozkyPostavyListView.getSelectionModel().select(null);
            }
        });
    }

    /** Obsluha tlačítka Přidej položku */
    @FXML
    private void handlePridejPolozku(ActionEvent event) {
        logika.vlozDoPolozkyPostavy(seznamPolozekListView.getSelectionModel()
                .getSelectedItem());
    }

    /** Obsluha tlačítka Odeber položku */
    @FXML
    private void handleOdeberPolozku(ActionEvent event) {
        logika.vlozDoSeznamPolozek(polozkyPostavyListView.getSelectionModel()
                .getSelectedItem());

    }

    /** Obsluha tlačítka Odejít - ukončí aplikaci. */
    @FXML
    private void handleOdejit(ActionEvent event) {
        zavriScenu();
    }

    /** Obsluha tlačítka Vložit. */
    @FXML
    private void handleVlozit(ActionEvent event) {
        logika.vlozPolozkyPostavy();
        zavriScenu();
    }

    /** Zavře okno a obnoví seznam odkazů u seznamListView pomocí metody
        nactiOdkazy(). */
    private void zavriScenu() {
        Stage stage = (Stage) odejitButton.getScene().getWindow();
        stage.close();
    }

}


