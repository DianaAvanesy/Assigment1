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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import static Utilities.DBUtility.getAllEpidemics;


public class ListController implements Initializable {

    @FXML
    private TableView<Epidemic> epidemicsTableView;
    @FXML
    private TableColumn<Epidemic, String> titleColoumn;
    @FXML
    private TableColumn<Epidemic, String> dateRangeColoumn;
    @FXML
    private TableColumn<Epidemic, String> locationColoumn;
    @FXML
    private TableColumn<Epidemic, String> diseaseColoumn;
    @FXML
    private TableColumn<Epidemic, String> deathTollColoumn;

    @FXML
    private Button goBackButton;

    /**
     * Changes the scene from list view to the chart(chartView.fxml)
     * called when goBackButton gets triggered
     * @param event
     * @throws IOException
     */
    @FXML
    void goBackToChart(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass()
                .getResource("/Views/chartView.fxml"));
        SceneAndStage.setScene(event, root);
    }

    /**
     * Method called to initialize ListController
     * Populates the cell values for the table with the data from DB with the help of DBUtility.getAllEpidemics
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        titleColoumn.setCellValueFactory(new PropertyValueFactory<Epidemic, String>("title"));
        dateRangeColoumn.setCellValueFactory(new PropertyValueFactory<Epidemic, String>("dateRange"));
        locationColoumn.setCellValueFactory(new PropertyValueFactory<Epidemic, String>("location"));
        diseaseColoumn.setCellValueFactory(new PropertyValueFactory<Epidemic, String>("disease"));
        deathTollColoumn.setCellValueFactory(new PropertyValueFactory<Epidemic, String>("deathToll"));

       //creates list with epidemics based on the query
        ObservableList<Epidemic> epidemicsList = null;
        try {
            epidemicsList = DBUtility.getAllEpidemics("SELECT * FROM epidemics ");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        //updates the table
        epidemicsTableView.setItems(epidemicsList);
    }

}
