package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_TitleTest {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com");

        String expectedTitle = "Amazon";


        // to get the title of the page
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);

        if (actualTitle.contains(expectedTitle)){
            System.out.println("Title test PASSED");
        }else {
            System.out.println("Title test FAILED");
        }

        Thread.sleep(5000);

        driver.close();





    }

}
