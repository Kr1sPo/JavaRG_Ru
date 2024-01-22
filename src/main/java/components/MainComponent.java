package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;

public class MainComponent extends BaseComponent{
  public MainComponent(WebDriver driver) {super(driver);}

  @FindBy(css = "")
  private WebElement mainElement;

  public MainPage clickMainElement(){
    mainElement.click();
    return new MainPage(driver);
  }
}
