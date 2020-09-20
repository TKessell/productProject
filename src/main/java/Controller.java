/*
author: domenic kessell
brief:  controller file for all GUI elements and methods
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JComboBox;


public class Controller {

  @FXML
  private ChoiceBox<String> pType;
  @FXML
  private ChoiceBox<String> pType2;
  @FXML
  private TextField pName;
  @FXML
  private TextField pManu;
  @FXML
  private TextField pName2;
  @FXML
  private TextField pManu2;
  @FXML
  private Button btnAddProduct;
  @FXML
  private ComboBox<String> cmbQuantity;
  @FXML
  private Button btnRecord;

  //connect to database after clicking "Add Product" button
  @FXML
  void addProduct(ActionEvent event) {
    connectToDb();
  }

  @FXML
  public void recordProd(ActionEvent actionEvent) {

  }

  //initialize method sets the combo box range of numbers. it is editable
  public void initialize() {
    cmbQuantity.getSelectionModel().selectFirst();
    cmbQuantity.setEditable(true);
    for (int x = 1; x <= 10; x++) {
      cmbQuantity.getItems().add(Integer.toString(x));
    }
  }

  //connectToDb finds the database, updates contents based upon user input
  public void connectToDb() {

    final String JDBC_DRIVER = "org.h2.Driver";
    final String DB_URL = "jdbc:h2:./resources/productDB";

    final String USER = "";
    final String PASS = "";
    Connection conn = null;
    Statement stmt = null;

    try {
      Class.forName(JDBC_DRIVER);
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      stmt = conn.createStatement();
      String prodType = pType.getValue();
      String prodManu = pManu.getText();
      String prodName = pName.getText();
      String sql = "INSERT INTO Product(type, manufacturer, name) VALUES ( 'AUDIO', 'Apple', 'iPod' );";

      stmt.executeUpdate(sql);

      ResultSet rs = stmt.executeQuery(sql);
      rs.next();

      stmt.close();
      conn.close();

    } catch (ClassNotFoundException e) {
      e.printStackTrace();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}

