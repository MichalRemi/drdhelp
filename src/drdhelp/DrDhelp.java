package drdhelp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Start
 *
 * @author Michal Remišovský
 * @version 0.01.0000 — 2017-04-15
 */
public class DrDhelp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("DrDhelp");
        stage.setMinWidth(360);
        stage.setMinHeight(380);
        stage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }

}
