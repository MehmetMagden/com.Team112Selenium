package day01_driverMethods;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverMethods {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com");

        // lets test url  expected url = "https://www.amazon.com/"

        String expectedUrl = "https://www.amazon.com/";

        String actualUrl = driver.getCurrentUrl();
        System.out.println("actualUrl = " + actualUrl);

        if (actualUrl.equals(expectedUrl)){
            System.out.println("URL test PASSED");
        }else{
            System.out.println("URL test FAILED");
        }

        driver.close();

    }
}
