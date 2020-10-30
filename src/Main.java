
//import com.sun.prism.Image;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import static javafx.application.Application.launch;

public class Main extends Application{
    public static void main(String[] args)  {

        String test = "2012";
        String test2 = "400";
        System.out.println(test.matches("^([4-8][0-9]{2}|9[0-8][0-9]|99[0-9]|1[0-9]{3}|20[01][0-9]|2020)$"));
        System.out.println(test2.matches("^([4-8][0-9]{2}|9[0-8][0-9]|99[0-9]|1[0-9]{3}|20[01][0-9]|2020)-([4-8][0-9]{2}|9[0-8][0-9]|99[0-9]|1[0-9]{3}|20[01][0-9]|2020)"));


        //launch(args);
        // To create a new record in the database:
        //Models.Epidemic corona =  new Models.Epidemic("corona","test","test","test","test");

        //List all of epidemics from database
        //Utilities.DBUtility.getAllEpidemics();

    }
        @Override
        public void start(Stage stage) throws Exception {
            Parent root = FXMLLoader.load(getClass()
                   .getResource("Views/chartView.fxml"));
           Scene scene = new Scene(root);
            stage.setScene(scene);


            Image icon = new Image("/virus.png");
            stage.getIcons().add(icon);
            stage.setTitle("Worst epidemic comparison");

            stage.show();


        }



}