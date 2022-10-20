package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Main {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void startTest() throws InterruptedException {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com"); // amazon sayfasına git

        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")); // arama çubuğuna tikla

        searchBox.sendKeys("nutella");  // arama çubuğuna nutella yazdır

        searchBox.submit();  // nutella yazdıktan sonra entere basıp arama işlemi yap

        WebElement resultTextElement = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]/div"));// bulunan sonuç sayısını yazdır

        System.out.println(resultTextElement.getText()); // console log bas

        driver.close(); // windows u kapat
    }

    @After
    public void endTest() {
        driver.quit();
    }
}