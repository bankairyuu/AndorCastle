package andorcastle;

import java.io.IOException;

import andorcastle.services.eAndorCastleEnumerations;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage primaryStage;

    @Override public void start(Stage stage) throws IOException {
        eAndorCastleEnumerations.getInstance().setActiveComponent(eAndorCastleEnumerations.components.Main);

        Parent root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
        stage.setTitle("AndorCastle");
        stage.setScene(new Scene(root));
        primaryStage = stage;
        stage.show();
    }

    public static Stage getPrimaryStage(){
        return primaryStage;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
