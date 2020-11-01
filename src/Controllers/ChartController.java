package Controllers;
import Views.SceneAndStage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class ChartController implements Initializable  {

    @FXML
    private NumberAxis xAxis;

    @FXML
    private NumberAxis yAxis;

    @FXML
    private BubbleChart<?,?> epidemicsBubbleChart ;

    @FXML
    private AnchorPane chartArea;

    @FXML
    private Button changeSceneButton;

    @FXML
    void changeToListView(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass()
                .getResource("/Views/listView.fxml"));
        SceneAndStage.setScene(event, root);

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        final NumberAxis xAxis = new NumberAxis(200, 2020, 500);
        final NumberAxis yAxis = new NumberAxis(0, 50000, 10000);
        //final BubbleChart<Number,Number> epidemicsBubbleChart =
         //       new BubbleChart<Number,Number>(xAxis,yAxis);

        epidemicsBubbleChart = new BubbleChart<>(xAxis,yAxis);
        //XYChart.Series series = new XYChart.Series();

        //series.getData().add(new XYChart.Data(-100,-100 , 4000));
        //series.getData().add(new XYChart.Data(1899, 1899, 50000));
        //series.getData().add(new XYChart.Data(1300, 1300, 600));
        //series.getData().add(new XYChart.Data(2020, 2020, 80));
        //series.getData().add(new XYChart.Data(2011, 2011, 9000));
        //series.getData().add(new XYChart.Data(1500, 1500, 120));
        //Setting the data to bar chart
        //epidemicsBubbleChart.getData().add(series);
        //Setting name to the bubble chart
        //series.setName("work");


    }


}
