package Controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class ChartController implements Initializable  {

    @FXML
    private StackedAreaChart<?, ?> stackedAreaChartForEpidemics;

    @FXML
    private AnchorPane chartArea;

    @FXML
    private Button changeSceneButton;

    @FXML
    void changeToListView(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass()
                .getResource("/Views/chart2.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("Views/styles.css");

        Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        Image icon = new Image("/virus.png");
        stage.getIcons().add(icon);
        stage.setTitle("Worst epidemics comparison");
        stage.show();



    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
