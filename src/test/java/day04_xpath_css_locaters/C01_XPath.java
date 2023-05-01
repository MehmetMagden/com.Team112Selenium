package day04_xpath_css_locaters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_XPath {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.driver.chrome","src/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");

       //  locating amazon searchbox by using id att
        WebElement amazonSearchBox = driver.findElement(By.id("twotabsearchtextbox"));
        amazonSearchBox.sendKeys("Nutella");

        // locating amazon searchbox by7 using name att
//        WebElement amazonSearchBox =driver.findElement(By.name("field-keywords"));
//        amazonSearchBox.sendKeys("Java");

        WebElement sellButton= driver.findElement(By.xpath("//a[@data-csa-c-content-id='nav_cs_sell']"));
        sellButton.click();


        Thread.sleep(10000);
        driver.close();


    }

}
