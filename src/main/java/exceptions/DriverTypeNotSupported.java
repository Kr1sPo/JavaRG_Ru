package exceptions;

import io.github.bonigarcia.wdm.config.DriverManagerType;

public class DriverTypeNotSupported extends Exception {
  public DriverTypeNotSupported(String browserType) {super (browserType+" is not supported.");}

  public DriverTypeNotSupported(DriverManagerType browserType) {super (browserType+" is not supported.");}
}
