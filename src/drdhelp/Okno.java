/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package drdhelp;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;





/*******************************************************************************
 * Instance třídy {@code Okno} představuje vyskakovací okno s volitelným názvem
 * a textem hlášky v okně (parametry) a tlačítkem "OK" ńa ukončení okna.
 *
 * @author  Michal Remišovský
 * @version 0.01.0000 — 2017-04-15
 */
public class Okno extends Stage {

//== CONSTANT CLASS ATTRIBUTES =================================================
//== VARIABLE CLASS ATTRIBUTES =================================================



//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================



//##############################################################################
//== CONSTANT INSTANCE ATTRIBUTES ==============================================
//== VARIABLE INSTANCE ATTRIBUTES ==============================================



//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     *
     */
    public Okno(String nadpisOkna, String text) {
        setTitle(nadpisOkna);
        setWidth(450);
        setHeight(200);
        initStyle(StageStyle.UTILITY);
        initModality(Modality.WINDOW_MODAL);
        setScene(novaScena(text));
        showAndWait();
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================

    private Scene novaScena(String text) {

        VBox box = new VBox();
        box.setAlignment(Pos.CENTER);
        box.setSpacing(20);

        // Label
        Label textLabel = new Label(text);
        textLabel.setTextAlignment(TextAlignment.CENTER);

        // Tlačítko
        Button tlacitko = new Button("OK");
        tlacitko.setMinWidth(50);
        tlacitko.setMinHeight(30);
        tlacitko.setOnAction((ActionEvent e) -> {
            Stage stage = (Stage) tlacitko.getScene().getWindow();
            stage.close();
        });

        box.getChildren().addAll(textLabel, tlacitko);

        return new Scene(box);
    }

//##############################################################################
//== NESTED DATA TYPES =========================================================
}
