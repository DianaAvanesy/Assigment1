package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.layout.AnchorPane;


import java.net.URL;
import java.util.ResourceBundle;

public class ChartController implements Initializable  {

    @FXML
    private StackedAreaChart<?, ?> stackedAreaChartForEpidemics;

    @FXML
    private AnchorPane chartArea;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
}
