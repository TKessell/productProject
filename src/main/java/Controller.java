/*
author: domenic kessell
brief:  controller file for all GUI elements and methods
 */


import java.util.Date;
import java.lang.reflect.Method;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JComboBox;


public class Controller {

  @FXML
  private ChoiceBox<String> pType;
  @FXML
  private TextField pName;
  @FXML
  private TextField pManu;
  @FXML
  private Button btnAddProduct;
  @FXML
  private ComboBox<String> cmbQuantity;
  @FXML
  private ListView<Product> prodMenu;
  @FXML
  private Button btnRecord;
  @FXML
  private TextArea prodTextArea;
  //table columns
  @FXML
  private TableView<Product> tableColumn;
  @FXML
  private TableColumn<?, ?> tableName;
  @FXML
  private TableColumn<?, ?> tableManu;
  @FXML
  private TableColumn<?, ?> tableType;

  private ObservableList<Product> productLine;

  //connect to database after clicking "Add Product" button
  @FXML
  void addProduct(ActionEvent event) {
    connectToDb();
    setupProductLineTable();
    setupProduceListView();
  }

  //Add items to list view in Produce Tab
  private void setupProduceListView(){
    prodMenu.setItems(productLine);
  }

  //Add items to table column in Production Line Tab
  void setupProductLineTable()
  {
    String name = pName.getText();
    String manu = pManu.getText();
    String type = pType.getValue();

    tableName.setCellValueFactory(new PropertyValueFactory("Name"));
    tableManu.setCellValueFactory(new PropertyValueFactory("Manufacturer"));
    tableType.setCellValueFactory(new PropertyValueFactory("Type"));

    Product prodTemp = new Product(name, manu, ItemType.valueOf(type));
    productLine.add(prodTemp);
    tableColumn.setItems(productLine);
  }

  @FXML
  public void recordProd(ActionEvent event) {
    int numProds = Integer.valueOf(cmbQuantity.getSelectionModel().getSelectedItem());
    String name = pName.getText();
    String manu = pManu.getText();
    String type = pType.getValue();
    for (int i = 0; i < numProds; i++) {
      System.out.println("in record prod");
      //Date day = new Date();
      Product temp = new Product(name, manu, ItemType.valueOf(type));
      ProductionRecord record = new ProductionRecord(temp, 1);
      //System.out.println(record.toString());
      prodTextArea.appendText(record.toString());
    }
  }
    //Product prodProduced = prodMenu.getSelectionModel().getSelectedItems();

  //initialize method sets the combo box range of numbers. it is editable
  public void initialize() {
    productLine = FXCollections.observableArrayList();
    cmbQuantity.setEditable(true);
    for (int x = 1; x <= 10; x++) {
      cmbQuantity.getItems().add(Integer.toString(x));
    }
    cmbQuantity.getSelectionModel().selectFirst();
    for(ItemType items : ItemType.values())
      pType.getItems().add(String.valueOf(items));
    //ProductionRecord record = new ProductionRecord(0);
    //prodTextArea.setText(record.toString());
  }

  //connectToDb finds the database, updates contents based upon user input
  public void connectToDb() {
    System.out.println("connected");
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

      String insertSql = "INSERT INTO Product(type, manufacturer, name) VALUES ( ? , ? , ? )";
      PreparedStatement ist = conn.prepareStatement(insertSql);
      ist.setString(1, pType.getValue());
      ist.setString(2, pManu.getText());
      ist.setString(3, pName.getText());
      ist.executeUpdate();

//prints to console all the products in the database after button click.
      String sql = "select * from PRODUCT";
      ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {
        System.out.println(rs.getString(1));
        System.out.println(rs.getString(2));
        System.out.println(rs.getString(3));
        System.out.println(rs.getString(4));
      }

      stmt.executeUpdate(sql);
      stmt.close();
      conn.close();

    } catch (ClassNotFoundException e) {
      e.printStackTrace();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}