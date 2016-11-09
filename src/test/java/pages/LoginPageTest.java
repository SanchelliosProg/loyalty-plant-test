package pages;

import config.TestConfig;
import config.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by Александр on 10.11.2016.
 */
public class LoginPageTest {
    private final String CORRECT_LOGIN = "Log001";
    private final String INVALID_LOGIN = "Log002";
    private final String CORRECT_PASSWORD = "Pass001";
    private final String INVALID_PASSWORD = "Pass002";
    private final String EMPTY = "";

    private LoginPage page;
    private WebDriver driver;

    @BeforeClass
    public void setUp(){
        this.driver = WebDriverFactory.getDriver(TestConfig.CHROME);
        page = new LoginPage(driver);
    }

    @Test
    public void testLogin(){
        page.openPage();
        page.login(CORRECT_LOGIN, CORRECT_PASSWORD);
        //TODO: can't reproduce result
    }

    @Test
    public void testInvalidPassword(){
        page.openPage();
        page.login(CORRECT_LOGIN, INVALID_PASSWORD);
        //TODO: can't reproduce result
    }

    @Test
    public void testEmptyPassword(){
        page.openPage();
        page.login(CORRECT_LOGIN, EMPTY);
        //TODO: can't reproduce result
    }

    @Test
    public void testInvalidLogin(){
        page.openPage();
        page.login(INVALID_LOGIN, CORRECT_PASSWORD);
        //TODO: can't reproduce result
    }

    @Test
    public void testInvalidLoginAndInvalidPassword(){
        page.openPage();
        page.login(INVALID_LOGIN, INVALID_PASSWORD);
    }

    @Test
    public void testInvalidLoginAndEmptyPassword(){
        page.openPage();
        page.login(INVALID_LOGIN, EMPTY);
        //TODO: can't reproduce result
    }

    @Test
    public void testEmptyLogin(){
        page.openPage();
        page.login(EMPTY, CORRECT_PASSWORD);
        //TODO: can't reproduce result
    }

    @Test
    public void testEmptyLoginAndInvalidPassword(){
        page.openPage();
        page.login(EMPTY, INVALID_PASSWORD);
        //TODO: can't reproduce result
    }

    @Test
    public void testEmptyLoginAndEmptyPassword(){
        page.openPage();
        page.login(EMPTY, EMPTY);
        //TODO: can't reproduce result
    }


    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
    }


}