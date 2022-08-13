import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import java.time.Duration;
import java.util.Random;

public class Utils {
    WebDriver driver;

    @BeforeClass
    public WebDriver setup()
    {
        String chromeDriver=System.getProperty("user.dir")+"\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriver);
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }
    public void scrollUntil(WebElement element)
    {

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",element);
    }
    public void scrollUntilSelector(Select element ,WebDriver driver)
    {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",element);
    }
    public String randomEmailGenerator() { //copied from https://stackoverflow.com/questions/45841500/generate-random-emails
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        return salt.toString();
    }
    public void waitUntil(WebDriver driver, By element){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));

    }

    public void waitUntilPageLoad(WebDriver driver)
    {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver1 -> String
                .valueOf(((JavascriptExecutor) driver1).executeScript("return document.readyState"))
                .equals("complete"));
    }

    public void HoverOnItemAndSelectSub(WebElement element,By by)
    {
        //Instantiating Actions class
        Actions actions = new Actions(driver);

        actions.moveToElement(element);

        WebElement subMenu = driver.findElement(by);

        actions.moveToElement(subMenu);

        actions.click().build().perform();
    }
    public void setDriver(WebDriver driver)
    {
        this.driver=driver;
    }
    public void waitUntilElementIsClickable(WebDriver driver,WebElement element)
    {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(element));

    }
    public WebElement findElementByXpathContainsText(WebDriver driver,String text)
    {
        return driver.findElement(By.xpath("//*[contains(text(), '"+text+"')]"));
    }
    public void waitForElementStaleness(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until((ExpectedConditions.stalenessOf(element)));
    }

}