package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by alex on 22.10.16.
 */
public class WebDriverFactory {
    private final static int LINUX = 0;
    private final static int WINDOWS_10 = 1;
    private final static String DIR = "./resources/drivers/";

    public static WebDriver getDriver(int id){
        switch (id){
            case TestConfig.CHROME:
                return getChromeDriver();
            case TestConfig.FIREFOX:
                return getFirefoxDriver();
            default:
                throw new IllegalArgumentException();
        }
    }

    private static WebDriver getChromeDriver(){
        String driverName = "webdriver.chrome.driver";

        switch (getSystemName()){
            case WINDOWS_10:
                System.setProperty(driverName, DIR + "windows_10/chromedriver.exe");
                break;
            case LINUX:
                System.setProperty(driverName, DIR + "linux/chromedriver.exe");
                break;
            default:
                break;
        }
        return new ChromeDriver();
    }

    private static WebDriver getFirefoxDriver(){
        String driverName = "webdriver.gecko.driver";
        switch (getSystemName()){
            case WINDOWS_10:
                System.setProperty(driverName,
                        DIR + "windows_10/geckodriver.exe");
                break;
            case LINUX:
                System.setProperty(driverName,
                        DIR + "linux/geckodriver");
                break;
            default:
                break;
        }

        return new FirefoxDriver();
    }

    private static int getSystemName() {
        if(System.getProperty("os.name").equals("Windows 10")){
            return WINDOWS_10;
        }else {
            return LINUX;
        }
    }
}
