package day03_locaters;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03_ByClassNameWithSpace {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://amazon.com");

        WebElement amazonSearchBox = driver.findElement(By.id("twotabsearchtextbox"));
        amazonSearchBox.sendKeys("Nutella"+ Keys.ENTER);


        // when u use classname locater, there should not be any space charater in the value
        // in this value there is a space char so it wont be able to find the webElements
        List<WebElement> listOfAllProducts = driver.findElements(By.className("a-section aok-relative s-image-square-aspect"));

        for (WebElement eachWebElement: listOfAllProducts
             ) {
            System.out.println(eachWebElement.getText());
        }

        driver.close();

    }
}
