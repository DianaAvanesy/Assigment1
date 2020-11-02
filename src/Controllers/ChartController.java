package Controllers;
import Models.Epidemic;
import Utilities.DBUtility;
import Views.SceneAndStage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static Utilities.DBUtility.getAllEpidemics;


public class ChartController implements Initializable  {


    @FXML
    private BarChart<String,Number> epidemicsBarChart;

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

         String austria = "Austria";
          String brazil = "Brazil";
          String france = "France";
          String italy = "Italy";
          String usa = "USA";


        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc =
                new BarChart<String,Number>(xAxis,yAxis);
        bc.setTitle("");
        xAxis.setLabel("");
        yAxis.setLabel("");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("2003");

        ObservableList<Epidemic> epidemicsList = DBUtility.getAllEpidemics();
        epidemicsList.forEach(Epidemic ->{
           series1.getData().add(new XYChart.Data(Epidemic.getTitle(), Epidemic.getDeathToll()));

        });


        Scene scene  = new Scene(bc,800,600);
        epidemicsBarChart.getData().add(series1);











       // final CategoryAxis xAxis = new CategoryAxis();
        //final NumberAxis yAxis = new NumberAxis();
       // final BarChart<String,Number> bc =
         //      new BarChart<String,Number>(xAxis,yAxis);
        //bc.setTitle("Country Summary");
        //xAxis.setLabel("Name");
        //yAxis.setLabel("DeathToll");

        //XYChart.Series series1 = new XYChart.Series();


        //series1.setName("2003");

       // ObservableList<Epidemic> epidemicsList = getAllEpidemics();
       // epidemicsList.forEach(Epidemic ->{
         //   series1.getData().add(new XYChart.Data(Epidemic.getTitle(), Epidemic.getDeathToll()));

        //});


        //series1.getData().add(new XYChart.Data("safasdf", 20));
        // series1.getData().add(new XYChart.Data("safdsaf", 25601.34));
        //series1.getData().add(new XYChart.Data(brazil, 20148.82));
        //series1.getData().add(new XYChart.Data(france, 10000));
        //series1.getData().add(new XYChart.Data(italy, 35407.15));
       //series1.getData().add(new XYChart.Data(usa, 12000));



       //bc.getData().add(series1);
       // epidemicsBarChart.getData().add(series1);





























        //final NumberAxis xAxis = new NumberAxis(200, 2020, 500);
        //final NumberAxis yAxis = new NumberAxis(0, 50000, 10000);
        //final BubbleChart<Number,Number> epidemicsBubbleChart =
         //       new BubbleChart<Number,Number>(xAxis,yAxis);

   //     epidemicsBubbleChart = new BubbleChart<>(xAxis,yAxis);
        //XYChart.Series series = new XYChart.Series();

        //series.getData().add(new XYChart.Data(-100,-100 , 4000));
        //series.getData().add(new XYChart.Data(1899, 1899, 50000));
        //series.getData().add(new XYChart.Data(1300, 1300, 600));
        //series.getData().add(new XYChart.Data(2020, 2020, 80));
        //series.getData().add(new XYChart.Data(2011, 2011, 9000));
        //series.getData().add(new XYChart.Data(1500, 1500, 120));
        //Setting the data to bar chart

        //Setting name to the bubble chart
        //series.setName("work");


    }


}
