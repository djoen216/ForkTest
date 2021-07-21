package TestNG;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class forkLaunchPage {
	
    WebDriver driver;
    private static String email = "forktesting951@gmail.com";
    private static String password = "Test2419";
    
	@BeforeSuite
    public void setUp() {
    	//setup browser
    	WebDriverManager.chromedriver().setup();
    	driver = new ChromeDriver();
    }
    
    @BeforeTest
    public void goToFork() {
    	driver.get("https://www.thefork.fr/");
     }
      
  
	@AfterTest
    public void tearDown() {
    	driver.quit();
    }
    
    @Test
    public void connect() throws InterruptedException {
    	
    	//click on the connexion butotn
    	driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/div[3]/button/span")).click();
  
    	//enter email
    	driver.findElement(By.id("identification_email")).sendKeys(email);
    	
    	//validate mail 
    	driver.findElement(By.xpath("//*[@id=\"USER_SPACE_FIRST_PANEL\"]/div[2]/div[1]/div/div[3]/form[1]/div[2]/button")).click();
    	
    	//enter password
    	driver.findElement(By.id("password")).sendKeys(password);
    	
    	//validate password
    	driver.findElement(By.xpath("//*[@id=\"USER_SPACE_FIRST_PANEL\"]/div[2]/div[2]/div/div[2]/form/div[2]/button")).click();	
    	
    	//verify tha name of user 
    	String user = driver.findElement(By.xpath("//*[@id=\"USER_SPACE_FIRST_PANEL\"]/div[2]/h1")).getText();
    	Assert.assertEquals(user,"test");
    }
}
