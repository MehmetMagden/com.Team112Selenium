package day03_locaters;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_ByName {
    public static void main(String[] args) throws InterruptedException {

        // locate amazon search box by using the name attribute

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");

        WebElement amazonSearchBox= driver.findElement(By.name("field-keywords"));

        amazonSearchBox.sendKeys("Nutella"+ Keys.ENTER);

        Thread.sleep(5000);
        driver.close();

        // if you dont want to you a class just go to the class and
        // press ctrl +A
        // press ctrl + /


    }

}
