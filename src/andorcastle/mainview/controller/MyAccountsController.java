package andorcastle.mainview.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

import static andorcastle.Main.getPrimaryStage;

public class MyAccountsController {
    private boolean isModified = false;

    @FXML
    Button btnExitCancel;

    @FXML
    public void initialize(){
        btnExitCancel.setText(isModified ? "Cancel" : "Exit");
        btnExitCancel.setCancelButton(isModified);
    }

    public void ivProfilPicture_OnMouseClicked(MouseEvent mouseEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open new profile picture");
        fileChooser.showOpenDialog(getPrimaryStage());


    }

    public void btnExitCancel_onAction(ActionEvent actionEvent) {
        if (isModified){
            // Cancel
        }else{
            // Exit
            Platform.exit();
        }
    }
}
