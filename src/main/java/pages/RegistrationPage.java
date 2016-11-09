package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Александр on 09.11.2016.
 */
public class RegistrationPage extends BasePage {

    public static int REGISTERED_STATUS = 0;
    public static int INVALID_ENTRY_STATUS = 1;

    private final String ERROR_XPATH = "html/body/p[2]";
    private final String USER_XPATH = "html/body/form/table/tbody/tr[1]/td[2]/input";
    private final String PASSWORD_XPATH = "html/body/form/table/tbody/tr[2]/td[2]/input";
    private final String PASS_CONFIRM_XPATH = "html/body/form/table/tbody/tr[3]/td[2]/input";
    private final String REQUEST_BUTTON_XPATH = "html/body/form/table/tbody/tr[4]/td/input";

    public RegistrationPage(WebDriver driver) {
        super(driver);
        setBaseUrl();
    }

    protected void setBaseUrl() {
        baseUrl = "http://task.loyaltyplant.com/getLoginAndPassword.php";
    }

    public int register(String username,
                         String password,
                         String passwordConfirmation) throws InterruptedException {
        enterUserName(username);
        enterPassword(password);
        enterPasswordConfirmation(passwordConfirmation);
        click(By.xpath(REQUEST_BUTTON_XPATH));
        Thread.sleep(3000);
        try {
            WebElement errorField = driver.findElement(By.xpath(ERROR_XPATH));
            errorField.getText();
            return INVALID_ENTRY_STATUS;
        }catch (NoSuchElementException ex){
            return REGISTERED_STATUS;
        }
    }

    public void enterUserName(String username){
        input(username, By.xpath(USER_XPATH));
    }

    public void enterPassword(String password){
        input(password, By.xpath(PASSWORD_XPATH));
    }

    public void enterPasswordConfirmation(String passwordConfirmation){
        input(passwordConfirmation, By.xpath(PASS_CONFIRM_XPATH));
    }
}
