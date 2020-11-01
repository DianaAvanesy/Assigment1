
//import com.sun.prism.Image;
import Views.SceneAndStage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import static javafx.application.Application.launch;

public class Main extends Application{
    public static void main(String[] args)  {

        launch(args);
        // To create a new record in the database:
        //Models.Epidemic corona =  new Models.Epidemic("corona","test","test","test","test");

        //List all of epidemics from database
        //Utilities.DBUtility.printAllEpidemics();

    }
        @Override
        public void start(Stage stage) throws Exception {
            Parent root = FXMLLoader.load(getClass()
                   .getResource("Views/chartView.fxml"));
            Scene scene = new Scene(root);

            scene.getStylesheets().add("Views/styles.css");
            stage.setScene(scene);
            Image icon = new Image("/virus.png");
            stage.getIcons().add(icon);
            stage.setTitle("Worst epidemics comparison");
            stage.show();



        }



}