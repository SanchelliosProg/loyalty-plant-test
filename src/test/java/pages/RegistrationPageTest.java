package pages;

import config.TestConfig;
import config.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RegistrationPageTest {
    private final String CORRECT_LOGIN = "Log001";
    private final String CORRECT_PASSWORD = "Pass001";
    private final String INVALID_PASSWORD = "Pass002";
    private final String EMPTY = "";

    private RegistrationPage page;
    private WebDriver driver;

    @BeforeClass
    public void setUp(){
        this.driver = WebDriverFactory.getDriver(TestConfig.CHROME);
        page = new RegistrationPage(driver);
    }

    @Test
    public void testCorrectRegistration() throws InterruptedException {
        page.openPage();
        int result = page.register(CORRECT_LOGIN, CORRECT_PASSWORD, CORRECT_PASSWORD);
        assertEquals(result, RegistrationPage.REGISTERED_STATUS);
    }

    @Test
    public void testInvalidPasswordConfirmation() throws InterruptedException {
        page.openPage();
        int result = page.register(CORRECT_LOGIN, CORRECT_PASSWORD, INVALID_PASSWORD);
        assertEquals(result, RegistrationPage.INVALID_ENTRY_STATUS);
    }

    @Test
    public void testEmptyPasswordConfirmation() throws InterruptedException {
        page.openPage();
        int result = page.register(CORRECT_LOGIN, CORRECT_PASSWORD, EMPTY);
        assertEquals(result, RegistrationPage.INVALID_ENTRY_STATUS);
    }

    @Test
    public void testEmptyLogin() throws InterruptedException {
        page.openPage();
        int result = page.register(EMPTY, CORRECT_PASSWORD, CORRECT_PASSWORD);
        assertEquals(result, RegistrationPage.INVALID_ENTRY_STATUS);
    }

    @Test
    public void testEmptyAll() throws InterruptedException {
        page.openPage();
        int result = page.register(EMPTY, EMPTY, EMPTY);
        assertEquals(result, RegistrationPage.INVALID_ENTRY_STATUS);
    }

    @Test
    public void testEmptyPasswords() throws InterruptedException {
        page.openPage();
        int result = page.register(CORRECT_LOGIN, EMPTY, EMPTY);
        assertEquals(result, RegistrationPage.INVALID_ENTRY_STATUS);
    }

    @Test
    public void testOnlyConfirmation() throws InterruptedException {
        page.openPage();
        int result = page.register(EMPTY, EMPTY, CORRECT_PASSWORD);
        assertEquals(result, RegistrationPage.INVALID_ENTRY_STATUS);
    }


    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
    }

}