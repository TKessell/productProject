//author: domenic kessell
//purpose: class that implements multimediacontrol interface. displays the screen and monitor types to the user


public class MoviePlayer extends Product implements MultimediaControl {

  Screen screen;
  MonitorType monitorType;

  public MoviePlayer(String name, String manufacturer, Screen screenIn,
      MonitorType monitorTypeIn) {
    super(name, manufacturer, ItemType.VISUAL);
    screen = screenIn;
    monitorType = monitorTypeIn;
  }

  public String toString() {
    return super.toString() + "\nScreen: " + screen + "\nMonitor Type: " + monitorType;
  }

  public void play() {
    System.out.println("Playing Movie");
  }

  public void stop() {
    System.out.println("Stopping Movie");
  }

  public void previous() {
    System.out.println("Previous Movie");
  }

  public void next() {
    System.out.println("Next Movie");
  }
}
