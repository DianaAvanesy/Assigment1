package Views;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Class created to illuminate duplication of the code related to setting the Scene
 */
public class SceneAndStage {

    public static void setScene(ActionEvent event, Parent root) {
        Scene scene = new Scene(root);
        scene.getStylesheets().add("Views/styles.css");
        Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        Image icon = new Image("/virus.png");
        stage.getIcons().add(icon);
        stage.setTitle("Worst epidemics comparison");
        stage.show();
    }





}
