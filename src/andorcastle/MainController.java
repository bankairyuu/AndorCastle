package andorcastle;

import andorcastle.mainview.controller.MyAccountsController;
import andorcastle.trello.controller.TrelloController;
import andorcastle.wunderlist.controller.WunderlistController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MainController {

    @FXML
    SplitPane spltpMainSplitPane;

    @FXML
    public void initialize(){
        try {
            buildRequesteView();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnRefresh_OnAction(ActionEvent actionEvent) {

    }

    public void btnMain_OnAction(ActionEvent actionEvent) {
        if (!eAndorCastleEnumerations.getInstance().getActiveComponent().equals(eAndorCastleEnumerations.components.Main)){
            eAndorCastleEnumerations.getInstance().setActiveComponent(eAndorCastleEnumerations.components.Main);
            try {
                buildRequesteView();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void btnTrello_OnAction(ActionEvent actionEvent) {
        if (!eAndorCastleEnumerations.getInstance().getActiveComponent().equals(eAndorCastleEnumerations.components.Trello)){
            eAndorCastleEnumerations.getInstance().setActiveComponent(eAndorCastleEnumerations.components.Trello);
            try {
                buildRequesteView();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void btnWunderlist_OnAction(ActionEvent actionEvent) {
        if (!eAndorCastleEnumerations.getInstance().getActiveComponent().equals(eAndorCastleEnumerations.components.Wunderlist)){
            eAndorCastleEnumerations.getInstance().setActiveComponent(eAndorCastleEnumerations.components.Wunderlist);
            try {
                buildRequesteView();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void buildRequesteView() throws IOException {
        spltpMainSplitPane.getItems().clear();
        FXMLLoader loader;
        switch (eAndorCastleEnumerations.getInstance().getActiveComponent()){
            case Main:
                loader = new FXMLLoader(getClass().getResource("mainview/view/MyAccountsView.fxml"));
                BorderPane myaccountspane = loader.load();
                spltpMainSplitPane.getItems().addAll(myaccountspane);
                break;

            case Trello:
                loader = new FXMLLoader(getClass().getResource("trello/view/TrelloView.fxml"));
                SplitPane trellopane = loader.load();
                spltpMainSplitPane.getItems().addAll(trellopane);
                break;

            case Wunderlist:
                loader = new FXMLLoader(getClass().getResource("wunderlist/view/WunderlistView.fxml"));
                Pane wunderlistpane = loader.load();
                spltpMainSplitPane.getItems().addAll(wunderlistpane);
                break;

            default:
                loader = new FXMLLoader(getClass().getResource("mainview/view/MyAccountsView.fxml"));
                BorderPane defpane = loader.load();
                spltpMainSplitPane.getItems().addAll(defpane);
                break;
        }
    }
}
