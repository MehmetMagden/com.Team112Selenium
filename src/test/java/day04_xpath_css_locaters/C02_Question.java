package day04_xpath_css_locaters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.pagefactory.DefaultElementLocator;

import java.time.Duration;

public class C02_Question {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1- Go to https://the-internet.herokuapp.com/add_remove_elements/
        //2- Press the Add Element button
        //3- Test that the Delete button is visible
        //4- Press the delete key
        //5- Test that the text “Add/Remove Elements“ is visible

        //1- Go to https://the-internet.herokuapp.com/add_remove_elements/
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        //2- Press the Add Element button
        WebElement addButton = driver.findElement(By.xpath("//button[text()='Add Element']"));
        addButton.click();

        //3- Test that the Delete button is visible
        WebElement deleteButton = driver.findElement(By.xpath("//button[text()='Delete']"));

        if (deleteButton.isDisplayed()){
            System.out.println("DeleteButton Test PASSED");
        }else {
            System.out.println("DeleteButton Test FAILED");
        }

        //4- Press the delete key
        deleteButton.click();

        //5- Test that the text “Add/Remove Elements“ is visible
        WebElement addRemoveText = driver.findElement(By.xpath("//h3[text()='Add/Remove Elements']"));

        if (addRemoveText.isDisplayed()){
            System.out.println("Text Test PASSED");
        }else {
            System.out.println("Text Test FAILED");
        }

        driver.close();




    }
}
