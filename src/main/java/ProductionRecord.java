import java.util.Date;

public class ProductionRecord {

  //statics will stay the same no matter how many objects you create
  //private Product product;
  private static int productionNumber = 0;
  private int productID;
  private String serialNumber;
  private Date dateProduced;

  //setters for class fields
  void setProductionNumber(int prodNumIn) {
    productionNumber = prodNumIn;
  }

  void setProductID(int prodIDIn) {
    productID = prodIDIn;
  }

  void setSerialNumber(String sNumIn) {
    serialNumber = sNumIn;
  }

  void setDateProduced(Date dateIn) {
    dateProduced = dateIn;
  }

  //getters for class fields
  int getProductionNumber() {
    return productionNumber;
  }

  int getProductID() {
    return productID;
  }

  String getSerialNumber() {
    return serialNumber;
  }

  Date getDateProduced() {
    return dateProduced;
  }

 /* //default constructor
  public ProductionRecord(int prodIDInConstruct) {
    productID = prodIDInConstruct;
    productionNumber++;
    serialNumber = "0";
    dateProduced = new Date();
  }*/

  //week 10 constructor
  public ProductionRecord(Product prod, int prodCount) {
    productionNumber++;
    //this.product = prod;
    //productID = prod.getId();
    String sub = prod.getManufacturer().substring(0, 3);
    serialNumber = sub + prod.getType().getCode() + String.format("%05d", productionNumber);
    dateProduced = new Date();
  }

  /*//all fields constructor. Ctr = constructor
  public ProductionRecord(int prodNumInCtr, int prodIDInCtr, String sNumInCtr, Date dateInCtr) {
    productionNumber = prodNumInCtr;
    productID = prodIDInCtr;
    serialNumber = sNumInCtr;
    dateProduced = dateInCtr;
  }*/

  public String toString() {
    return "Prod. Num: " + productionNumber + " Product ID: " + productID + " Serial Num: "
        + serialNumber + " Date: " + dateProduced + "\n";
  }

}

