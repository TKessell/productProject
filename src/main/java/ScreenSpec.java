//author: domenic kessell
//purpose: interface to be implemented by Screen class


public interface ScreenSpec {

  public String getResolution();

  public int getRefreshRate();

  public int getResponseTime();
}
