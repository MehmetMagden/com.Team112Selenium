package day04_xpath_css_locaters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Question {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1- create a class
        //2- Go to https://www.amazon.com/
        //3- Make the browser full page
        //4- Refresh the page
        //5- Test if the page title contains the phrase “Spend less”
        //6- Press the Gift Cards tab
        //7- Press the Birthday button
        //8- Click the first product from the Best Seller section
        //9- Select $25 from Gift card details
        //10-Test the product price is $25.00
        //11-Close the page

        //2- Go to https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //3- Make the browser full page
        driver.manage().window().maximize();

        //4- Refresh the page
        driver.navigate().refresh();

        //5- Test if the page title contains the phrase “Spend less”
        String expecpectedResult = "Spend less";
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);  // to see what the title is

        if (actualTitle.contains(expecpectedResult)){
            System.out.println("Title Test PASSED");
        }else {
            System.out.println("Title Test FAILED");
        }

        //6- Press the Gift Cards tab
        WebElement giftCard = driver.findElement(By.xpath("//a[@data-csa-c-slot-id='nav_cs_3']"));
        giftCard.click();

        //7- Press the Birthday button
//        WebElement birthdayButton = driver.findElement(By.xpath("//img[@alt='Birthday']"));
//        birthdayButton.click();
        // if you are planing to click on it only once you can directly click without storing it in a webElement
        // this way it won't be stored in the memory, so it is better to save memory
        driver.findElement(By.xpath("//img[@alt='Birthday']")).click();

        //8- Click the first product from the Best Seller section
        WebElement firstProductOfList = driver.
                findElement(By.xpath("(//div[@class='a-section acs-product-block acs-product-block--default'])[1]"));

        firstProductOfList.click();

        //9- Select $25 from Gift card details
        driver.findElement(By.xpath("//button[@value='25']")).click();

        //10-Test the product price is $25.00
        WebElement priceWebElement = driver.findElement(By.xpath("//span[@class='a-color-price a-text-bold']"));

        String expectedPrice = "$25.00";
        String actualPrice = priceWebElement.getText();

        if (expectedPrice.equals(actualPrice)){
            System.out.println("Price test PASSED");
        }else {
            System.out.println("Price test FAILED");
        }


        //11-Close the page
        driver.close();


    }
}
