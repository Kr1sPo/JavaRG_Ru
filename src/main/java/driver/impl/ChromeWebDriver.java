package driver.impl;

import exceptions.DriverTypeNotSupported;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.util.logging.*;


public class ChromeWebDriver implements IDriver{

  @Override
  public WebDriver newDriver(){
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--no-sandbox");
    chromeOptions.addArguments("--no-first-run");
    chromeOptions.addArguments("--enable-extensions");
    chromeOptions.addArguments("--homepage=about:blank");
    chromeOptions.addArguments("--ignore-certificate-errors");
    if (HEADLESS){
      chromeOptions.addArguments("--headless");
    }

    LoggingPreferences logPrefs = new LoggingPreferences();
    logPrefs.enable(LogType.PERFORMANCE, Level.INFO);

    if (getRemoteUrl()==null){
      try{
        downloadLocalWebDriver(DriverManagerType.CHROME);
      } catch (DriverTypeNotSupported ex) {
        ex.printStackTrace();
      }
      return new ChromeDriver(chromeOptions);
    } else {
      return new RemoteWebDriver(getRemoteUrl(),chromeOptions);
    }
  }
}
