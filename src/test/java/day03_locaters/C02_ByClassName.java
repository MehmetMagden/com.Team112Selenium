package day03_locaters;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_ByClassName {
    public static void main(String[] args) throws InterruptedException {
        // Go to the amazon.com
        // search for nutella
        // print the highest price in the first page

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Go to the https://www.amazon.com
        driver.get("https://www.amazon.com");

        // search for nutella
        WebElement amazonSearchBox = driver.findElement(By.id("twotabsearchtextbox"));
        amazonSearchBox.sendKeys("Nutella"+ Keys.ENTER);

        // print the highest price in the first page

        List<WebElement> priceList =driver.findElements(By.className("a-price-whole"));
        /* By.className
        If you are planing to use a class value, you should be careful because there should not be any space character
        in the value
         */

        // this is a list contains webelements
        System.out.println(priceList);

        // getText() : we can not print a webelement directly so we need to reach text of the each webElement
//        for (WebElement eachElement: priceList  // by using for each loop
//             ) {
//
//            System.out.println(eachElement.getText());
//
//        }

        // getText() : we can not print a webelement directly so we need to reach text of the each webElement
        for (int i = 0; i < priceList.size(); i++) { // by using for i loop
            System.out.println(priceList.get(i).getText());
        }

        // to print the highest value

        String strNumber = "";
        int number =0;
        int higestNumber =0;
        for (int i = 0; i < priceList.size() ; i++) {

           strNumber= priceList.get(i).getText();  // "13"
            number = Integer.parseInt(strNumber);

            if (number>higestNumber){
                higestNumber = number;
            }
        }

        System.out.println(" the Highest Number : "+higestNumber);




        Thread.sleep(1000);
        driver.close();




    }
}
