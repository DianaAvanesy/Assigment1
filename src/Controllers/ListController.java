package Controllers;
import Models.Epidemic;
import Views.SceneAndStage;
import javafx.beans.Observable;
import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static Utilities.DBUtility.getAllEpidemics;


public class ListController implements Initializable {

    // configuring the table
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

    @FXML
   void goBackToChart(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass()
                .getResource("/Views/chartView.fxml"));
        SceneAndStage.setScene(event, root);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        titleColoumn.setCellValueFactory(new PropertyValueFactory<Epidemic, String>("title"));
        dateRangeColoumn.setCellValueFactory(new PropertyValueFactory<Epidemic, String>("dateRange"));
        locationColoumn.setCellValueFactory(new PropertyValueFactory<Epidemic, String>("location"));
        diseaseColoumn.setCellValueFactory(new PropertyValueFactory<Epidemic, String>("disease"));
        deathTollColoumn.setCellValueFactory(new PropertyValueFactory<Epidemic, String>("deathToll"));

        //load data
        epidemicsTableView.setItems(getAllEpidemics());
    }

    public ObservableList<Epidemic> getEpidemicsList(){
        ObservableList<Epidemic> epidemics = FXCollections.observableArrayList();

        epidemics.add(new Epidemic("Title goes here","1432", 7,"Kiev","Coroa",24994));

        return epidemics;
    }






}
