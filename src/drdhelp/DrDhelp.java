package drdhelp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
// import javafx.stage.StageStyle;

/**
 * Start
 *
 * @author Michal Remišovský
 * @version 0.03.0000 — 2016-12-02
 */
public class DrDhelp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));

        Scene scene = new Scene(root);
        // scene.getStylesheets().add(getClass().getResource("DrDdesk.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("DrDhelp");
        stage.setMinWidth(360);
        stage.setMinHeight(380);
        // stage.initStyle(StageStyle.TRANSPARENT);
        // scene.setFill(null);
        stage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }

}
