package pages;

import annotations.UrlPrefix;
import annotations.UrlTemplate;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class BasePage <T>{
  protected WebDriver driver;

  @FindBy(tagName = "h1")
  protected String pageHeader;

  public BasePage(WebDriver driver) {this.driver = driver;}
  private String hostname = System.getProperty("webdriver.base.url");

  public T open(){
    String prefix = getUrlPrefix();
    if(!prefix.startsWith("/")){
      prefix="/" + prefix;
    }
    driver.get(hostname + prefix);
    return (T) this;
  }

  /*
  public T open(String... data){
    String prefix = getUrlPrefix();
    String urlTemplate = getUrlTemplate();

    for (int i=0; i< data.length-1; i++){
      urlTemplate.replace(String.format("{d}", i+1), data[i]);
    }
    if (prefix.isEmpty()) {
      driver.get(hostname + prefix);
    }else{
      driver.get(hostname + prefix + urlTemplate);
    }
    return (T) this;
  }
  */

  public void pageHeaderShouldBeSameAs(String mainPageHeader) {assertThat(mainPageHeader.equals(pageHeader));}

  private String getUrlPrefix(){
    UrlPrefix urlAnnotation = getClass().getAnnotation(UrlPrefix.class);
    if(urlAnnotation !=null){
      return urlAnnotation.value();
    }
    return "";
  }

  private String getUrlTemplate(){
    UrlTemplate urlAnnotation = getClass().getAnnotation(UrlTemplate.class);
    if(urlAnnotation !=null){
      return urlAnnotation.value();
    }
    return "";
  }
}
