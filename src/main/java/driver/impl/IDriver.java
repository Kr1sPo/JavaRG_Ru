package driver.impl;

import exceptions.DriverTypeNotSupported;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.Config;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public interface IDriver {

  String REMOTE_URL = System.getProperty("webdriver.remote.url");
  boolean HEADLESS = Boolean.parseBoolean(System.getProperty("webdriver.headless"));

  public WebDriver newDriver();

  default URL getRemoteUrl(){
    try{
      return new URL(REMOTE_URL);
    } catch (MalformedURLException ex) {
      ex.printStackTrace();
      return null;
    }
  }

  default void downloadLocalWebDriver(DriverManagerType driverType) throws DriverTypeNotSupported{
    Config wdmConfig;
    String browserVersion = System.getProperty("browser.version","");

    if (!browserVersion.isEmpty()){
      switch (driverType){
        case CHROME:
          wdmConfig = WebDriverManager.chromedriver().config();
          wdmConfig.setAvoidBrowserDetection(false);
          wdmConfig.setChromeDriverVersion(browserVersion);
          break;
        case FIREFOX:
      }
    }
  }
}
