public class Screen implements ScreenSpec {

  private String resolution;
  private int refreshRate;
  private int responseTime;

  public Screen(String resolutionIn, int refreshRateIn, int responseTimeIn) {
    resolution = resolutionIn;
    refreshRate = refreshRateIn;
    responseTime = responseTimeIn;
  }

  public String getResolution() {
    return resolution;
  }

  public int getRefreshRate() {
    return refreshRate;
  }

  public int getResponseTime() {
    return responseTime;
  }

  public String toString() {
    return "\nResolution: " + resolution + "\nRefresh Rate: " + refreshRate
        + "\nResponse Time: "
        + responseTime;
  }
}
