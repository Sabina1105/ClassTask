package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Main {



            public static void main(String[] args) throws InterruptedException {

                System.setProperty("webdriver.chrome.driver", "/Users/sabinahuseynly/Documents/BrowserDriver/chromedriver");
                WebDriver driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                driver.get("https://www.dice.com/");

                driver.findElement(By.id("typeaheadInput")).sendKeys("SDET");
                driver.findElement(By.id("google-location-search")).sendKeys("Washington DC");
                driver.findElement(By.id("submitSearch-button")).click();

                List<WebElement> elements = driver.findElements(By.xpath("//a[@data-cy='card-title-link']"));

                Assert.assertEquals(20,elements.size());

                for(WebElement element:elements) {
                    Assert.assertTrue(element.getText().contains("SDET"));
                }
                elements.get(elements.size()-1).click();
                Assert.assertTrue(driver.getTitle().contains("SDET"));

                driver.quit();
            }
        }
