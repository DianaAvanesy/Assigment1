package Controllers;
import Views.SceneAndStage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;


public class ListController {

    @FXML
    private TableView<?> epidemicsTableView;

    @FXML
    private Button goBackButton;

    @FXML
   void goBackToChart(ActionEvent event) throws IOException {

       Parent root = FXMLLoader.load(getClass()
                .getResource("/Views/chartView.fxml"));

        SceneAndStage.setScene(event, root);

    }




}
