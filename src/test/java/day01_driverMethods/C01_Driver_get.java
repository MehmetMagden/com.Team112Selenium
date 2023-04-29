package day01_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_Driver_get {

    public static void main(String[] args) throws InterruptedException {

        // the driver we wish to use in our project
        // at the left side we should write the browser we wish to use
        // at the right side we should write the driver's reference from content root (by right-clicking on it)
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");

        // we have created a driver object
        WebDriver driver = new ChromeDriver();

        // and by using driver object we opened a page
        driver.get("https://www.amazon.com");

        // to wait for a few seconds
        Thread.sleep(5000);

        // to close the driver
        driver.close();

        /*

        We have installeed Selenium jar files and the chrome driver to our project

        and we set the property of the driver at line 13

        line 16 we have created our first driver object

        line 19 by using get() method, we chould be able to reach amazon.com

        line 19 we can delete www. part but we have to enter https:// part to reach the page


         */


    }

}
