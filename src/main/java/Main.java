//author: domenic kessell
//brief:  driver class for javafx GUI program

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;


public class Main extends Application {

  public static void main(String[] args) {
    launch(args);
  }

     @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

    Scene scene = new Scene(root, 625, 579);

    primaryStage.setTitle("Production Tablet");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
