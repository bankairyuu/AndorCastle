package andorcastle.myaccounts.controller;

import andorcastle.services.OnlineData;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import static andorcastle.Main.getPrimaryStage;

public class MyAccountsController {
    private boolean isModified = false;

    @FXML
    Button btnExitCancel;

    @FXML
    ImageView ivProfilPicture;

    @FXML
    public void initialize(){
        btnExitCancel.setText(isModified ? "Cancel" : "Exit");
        btnExitCancel.setCancelButton(isModified);
        ivProfilPicture.setImage(OnlineData.getInstance().getImage());
    }

    public void ivProfilPicture_OnMouseClicked(MouseEvent mouseEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open new profile picture");
        File f = fileChooser.showOpenDialog(getPrimaryStage());
        if (f != null){
            OnlineData.getInstance().setImage(new Image(f.toURI().toString()));
            ivProfilPicture.setImage(OnlineData.getInstance().getImage());
        }

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
