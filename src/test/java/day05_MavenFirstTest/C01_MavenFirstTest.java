package day05_MavenFirstTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_MavenFirstTest {

    //ClassWork Amazon Search Test
    //
    //1- Go to https://www.amazon.com/
    //2- let's locate the search box
    //3- Let's search with "Samsung headphones"
    //4- Let's print the number of results found
    //5- Let's click the first product
    //6- Let's print all the titles on the page
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup(); If we wanted to use firefoxdriver we could do it easily

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1- Go to https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //2- let's locate the search box
        WebElement amazonSearchBox = driver.findElement(By.id("twotabsearchtextbox"));

        //3- Let's search with "Samsung headphones"
        amazonSearchBox.sendKeys("Samsung headphones"+ Keys.ENTER);

        //4- Let's print the number of results found
        WebElement resultWebElement = driver.findElement(
                By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(resultWebElement.getText());

        //5- Let's click the first product
        WebElement firstProduct = driver.findElement(
                By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]"));
        firstProduct.click();

        //6- Let's print all the  titles on the left side of the page on the previous page
        driver.navigate().back(); // when we click on the product we can not see the titles so we need to go back to previous page

        Thread.sleep(2000);
        List<WebElement> titleList =driver.findElements(By.xpath("//span[@class='a-size-base a-color-base']"));
        Thread.sleep(2000);
        // to reach all elements in the list we will use foreachloop

        for (WebElement each : titleList
             ) {
            System.out.println(each.getText());

        }


        driver.close();












    }


}
