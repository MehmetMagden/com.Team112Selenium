package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_DriverMethods {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com");

        driver.manage().window().maximize();

        // to get all html codes of the page
        String pageSource = driver.getPageSource();
        String expectedWord = "accordion";

        System.out.println(pageSource);


        if (pageSource.contains(expectedWord)){
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED");
        }

        driver.close();


    }
}
