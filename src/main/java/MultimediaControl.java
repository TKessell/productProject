//author: domenic kessell
//purpose: interface to be implemented by AudioPlayer and MoviePlayer classes


public interface MultimediaControl {

  public void play();

  public void stop();

  public void previous();

  public void next();
}
