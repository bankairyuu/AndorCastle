package andorcastle;

import andorcastle.enumerations.eSurface;
import andorcastle.services.OnlineData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.BorderPane;
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
        if (!OnlineData.getInstance().getActiveSurface().equals(eSurface.Main)){
            OnlineData.getInstance().setActiveSurface(eSurface.Main);
            try {
                buildRequesteView();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void btnTrello_OnAction(ActionEvent actionEvent) {
        if (!OnlineData.getInstance().getActiveSurface().equals(eSurface.Trello)){
            OnlineData.getInstance().setActiveSurface(eSurface.Trello);
            try {
                buildRequesteView();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void btnWunderlist_OnAction(ActionEvent actionEvent) {
        if (!OnlineData.getInstance().getActiveSurface().equals(eSurface.Wunderlist)){
            OnlineData.getInstance().setActiveSurface(eSurface.Wunderlist);
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
        switch (OnlineData.getInstance().getActiveSurface()){
            case Main:
                loader = new FXMLLoader(getClass().getResource("myaccounts/view/MyAccountsView.fxml"));
                BorderPane myAccountsPane = loader.load();
                spltpMainSplitPane.getItems().addAll(myAccountsPane);
                break;

            case Trello:
                loader = new FXMLLoader(getClass().getResource("trello/view/TrelloView.fxml"));
                SplitPane trelloPane = loader.load();
                spltpMainSplitPane.getItems().addAll(trelloPane);
                break;

            case Wunderlist:
                loader = new FXMLLoader(getClass().getResource("wunderlist/view/WunderlistView.fxml"));
                Pane wunderlistPane = loader.load();
                spltpMainSplitPane.getItems().addAll(wunderlistPane);
                break;

            default:
                loader = new FXMLLoader(getClass().getResource("myaccounts/view/MyAccountsView.fxml"));
                BorderPane defPane = loader.load();
                spltpMainSplitPane.getItems().addAll(defPane);
                break;
        }
    }
}
