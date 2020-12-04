//author: domenic kessell
//purpose: class that implements item interface. displays the name, manufacturer, and type of product to the user


public class Product implements Item {

  private int id = 0;
  private String name;
  private String manufacturer;
  private ItemType type;

/*  public Product() {
    id = 0;
    name = "";
    manufacturer = "";
    type = null;
  }*/

  public Product(String nameIn, String manufacturerIn, ItemType typeIn) {
    setName(nameIn);
    setManufacturer(manufacturerIn);
    setType(typeIn);
  }

  public String toString() {
    return "Name: " + name + "\nManufacturer: " + manufacturer + "\nType: " + getType();
  }

  public void setType(ItemType typeIn) {
    type = typeIn;
  }

  public ItemType getType() {
    return type;
  }

  public void setID(int idIn) {
    id = idIn;
  }

  public int getId() {
    return id;
  }

  public void setName(String n) {
    name = n;
  }

  public String getName() {
    return name;
  }

  public void setManufacturer(String m) {
    manufacturer = m;
  }

  public String getManufacturer() {
    return manufacturer;
  }


}


class Widget extends Product {

  public Widget(String name, String manufacturer, ItemType type) {
    super(name, manufacturer, type);
  }
}
