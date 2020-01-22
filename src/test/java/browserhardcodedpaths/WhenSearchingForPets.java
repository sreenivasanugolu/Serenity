package browserhardcodedpaths;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WhenSearchingForPets {

    @Test
    public void should_be_able_to_find_pet_stores(){
       /* System.setProperty("webdriver.gecko.driver" , "src/test/resources/webdriver/windows/geckodriver.exe");
        WebDriver firefox = new FirefoxDriver();*/
        System.setProperty("webdriver.chrome.driver" , "src/test/resources/webdriver/windows/chromedriver.exe");
        WebDriver chrome = new ChromeDriver();
        chrome.get("https://duckduckgo.com");
        chrome.findElement(By.id("search_form_input_homepage")).sendKeys("pet store");
        chrome.findElement(By.id("search_button_homepage")).click();
        chrome.quit();
    }
}
