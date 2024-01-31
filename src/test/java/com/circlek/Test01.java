package com.circlek;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Test01 {
    //In my oppinion POP should be used 
    //CODE REVIEW
    @Test
    public void assertTextOnPage(){
        //I believe that an easier approach to creating a WebDriver is the WebDriver Manager library
        System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Move test data like url to the separated class
        driver.get("https://circlek-public.github.io/cki-service-recruitment-task/");

        //assert Remember Me Button
        WebElement rememeberMeLabel = driver.findElement(By.id("remember_me_label"));
        //Move to data class
        assertEquals("Remember Me", rememeberMeLabel.getText());

        //assert Sign In text
        WebElement signInButton = driver.findElement(By.className("login"));
        assertEquals("Sign In", signInButton.getText());
        //Shoud be used driver.quit()
    }

    @Test
    public void checkRememberMeCheckBox(){
        System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Move to data class
        driver.get("https://circlek-public.github.io/cki-service-recruitment-task/");

        //click Remember Me checkbox
        //Change selector for some more simple for example by.id("remember_me")
        WebElement rememberMeCheckBox = driver.findElement(By.xpath("//*[contains(text(), \"Remember Me\")]/../input"));
        rememberMeCheckBox.click();

        //check if clicked
        assertEquals(rememberMeCheckBox.isSelected(), true);
        //Shoud be used driver.quit()
    }
}
