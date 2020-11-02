package Controllers;
import Models.Epidemic;
import Utilities.DBUtility;
import Views.SceneAndStage;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class ChartController implements Initializable  {

    @FXML
    private BarChart<String,Number> epidemicsBarChart;

    @FXML
    private AnchorPane chartArea;

    @FXML
    private Button changeSceneButton;

    /**
     * Changes the scene from chart to the list view(listView.fxml)
     * called when changeSceneButton gets triggered
     * @param event
     * @throws IOException
     */
    @FXML
    void changeToListView(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass()
                .getResource("/Views/listView.fxml"));
        SceneAndStage.setScene(event, root);
    }

    /**
     * Method called to initialize ChartController
     * Populates the BarChart with the data from DB with the help of DBUtility.getAllEpidemics
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc = new BarChart<String,Number>(xAxis,yAxis);
        XYChart.Series series = new XYChart.Series();
        series.setName("Number of Deaths");

        // saves all of the pandemics that the query will return
        ObservableList<Epidemic> epidemicsList = null;
        try {
            epidemicsList = DBUtility.getAllEpidemics("select * from epidemics where DeathTollEstimate >=1000000 order by StartDate ");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        //foreach pandemic adds it to the series
        epidemicsList.forEach(Epidemic -> {
            series.getData().add(new XYChart.Data(Epidemic.getTitle(), Epidemic.getDeathToll()));
        });

        //updates the epidemicsBarChart
        epidemicsBarChart.getData().add(series);
    }

}
