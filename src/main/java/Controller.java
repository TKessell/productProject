import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class Controller {

  @FXML
  public void addProduct(ActionEvent actionEvent) {
    System.out.println("Acknowledged");
  }
  public void recordRecord(ActionEvent actionEvent) {
    System.out.println("Recorded");
  }


}