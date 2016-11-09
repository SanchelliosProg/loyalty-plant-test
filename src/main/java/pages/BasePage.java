package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by alex on 27.10.16.
 */
public abstract class BasePage {
    protected String titleFragment;
    protected WebDriver driver;
    protected String baseUrl;

    public BasePage(WebDriver driver){
        this.driver = driver;
        setBaseUrl();
    }

    public void openPage(WebDriver driver){
        driver.navigate().to(baseUrl);
    }

    public boolean init() {
        return driver.getTitle().contains(titleFragment);
    }

    protected abstract void setBaseUrl();

    protected void setTitleFragment(String titleFragment) {
        this.titleFragment = titleFragment;
    }

    protected void openPage(){
        this.driver.navigate().to(baseUrl);
    }


    protected void click(By by) {
        WebElement button = driver.findElement(by);
        button.click();
    }

    protected void input(String login, By by) {
        WebElement inputField = driver.findElement(by);
        inputField.sendKeys(login);
    }
}
