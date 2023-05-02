package day05_MavenFirstTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Question {

    //1. Go to http://zero.webappsecurity.com
    //2. Click the Signin button
    //3. Write “ username ” in the Login field
    //4. Write “ password ” in the password field
    //5. Click the Sign in button
    //6. Go to the Pay Bills page
    //7. Type any amount you want to deposit in the amount
    //8. Write “2020-0 9 - 10 ” on the 8th date part
    //9. Click on the Pay button
    //10. “The payment was successfully submitted.” test that the it appears
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1. Go to http://zero.webappsecurity.com
        driver.get("http://zero.webappsecurity.com");

        //2. Click the Signin button
        WebElement signInButton = driver.findElement(By.id("signin_button"));
        signInButton.click();


        //3. Write “username” in the Login field
        WebElement loginTextBox = driver.findElement(By.id("user_login"));
        loginTextBox.sendKeys("username");

        //4. Write “password” in the password field
        //driver.findElement(By.id("user_password")).sendKeys(" password "); // if we want to send the data directly

        WebElement passwordTextBox = driver.findElement(By.id("user_password"));
        passwordTextBox.sendKeys("password");

        //5. Click the Sign in button
        WebElement signInButtonLogin = driver.findElement(By.xpath("//input[@value='Sign in']"));
        signInButtonLogin.click();

        //6. Go to the Pay Bills page
        driver.navigate().back();
        //to go to the payBills page we need to click on online banking link
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();

        //clicking payBilss link
        driver.findElement(By.id("pay_bills_link")).click();

        //7. Type any amount you want to deposit in the amount
        driver.findElement(By.id("sp_amount")).sendKeys("200");

        //8. Write “2020-09-10 ” on the 8th date part
        //2023-05-09
        driver.findElement(By.id("sp_date")).sendKeys("2020-09-10");

        //9. Click on the Pay button
        driver.findElement(By.id("pay_saved_payees")).click();

        //10. “The payment was successfully submitted.” test that it appears
        WebElement text = driver.findElement(By.xpath("//span[text()='The payment was successfully submitted.']"));

        if (text.isDisplayed()){
            System.out.println("Test PASSED");

        }else {
            System.out.println("Test FAILED");
        }

        driver.close();



    }

}
