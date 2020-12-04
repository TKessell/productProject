//author: domenic kessell
//purpose: interface to be implemented by Product class


public interface Item {

  public int getId();

  public void setName(String n);

  public String getName();

  public void setManufacturer(String m);

  public String getManufacturer();
}
