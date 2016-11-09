package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Александр on 09.11.2016.
 */
public class LoginPage extends BasePage {
    private final String LOGIN_SELECTOR = "#email";
    private final String PASSWORD_SELECTOR = "#pass";
    private final String BUTTON_SELECTOR = ".gradbutton.green";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    protected void setBaseUrl() {
        baseUrl = "http://task.loyaltyplant.com";
    }

    public void login(String login, String password){
        openPage();
        input(login, By.cssSelector(LOGIN_SELECTOR));
        input(password, By.cssSelector(PASSWORD_SELECTOR));
        click(By.cssSelector(BUTTON_SELECTOR));
    }
}
