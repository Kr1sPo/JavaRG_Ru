package main;

import annotations.Driver;
import components.MainComponent;
import extensions.UIExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

@ExtendWith(UIExtension.class)
public class MainTest {

  @Driver
  private WebDriver driver;

  @Test
  public void clickSmthOnPage()
  {
    //System.out.println("Hello world!");
    new MainPage(driver).open();
    new MainComponent(driver).clickMainElement().pageHeaderShouldBeSameAs("main page header");
  }
}