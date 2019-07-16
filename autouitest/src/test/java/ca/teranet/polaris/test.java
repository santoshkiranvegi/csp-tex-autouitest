package ca.teranet.polaris;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class test {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new FirefoxDriver();
        driver.get("http://mcs2-service-fabric-qa.eastus.cloudapp.azure.com:8087/login");
        driver.findElement(By.name("username")).sendKeys("iadmin");
        driver.findElement(By.name("password")).sendKeys("rty");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(5000);
        //div[@class='doneDv']//div[@class='actionItem']---status
        List<WebElement> list=driver.findElements(By.xpath("//div[@class='doneDv']//p[@class='taskID']/a"));
        System.out.print(list.size());




    }

}
