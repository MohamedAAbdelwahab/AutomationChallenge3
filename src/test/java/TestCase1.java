import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCase1 {
    WebDriver driver;
    Utils util=new Utils();
    @BeforeClass
    public void reSetup()
    {
        driver=util.setup();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.tamanna.com/");
    }

    @AfterMethod
    public void cleanUp(){
    }
    @Test(priority = 1)
    public void add_two_items_from_different_categories_to_cart() throws InterruptedException {
        util.waitUntilPageLoad(driver);
        HomePage homePage=new HomePage(driver);
        homePage.getWomenCategory().click();
        util.scrollUntil(driver.findElement(By.cssSelector("a[href='/p/buy-river-island-halter-neck-midi-dress-01G9M7FVG9NP6B1FF0BQS40D8V']")));
        WebElement product1=driver.findElement(By.cssSelector("a[href='/p/buy-river-island-halter-neck-midi-dress-01G9M7FVG9NP6B1FF0BQS40D8V']"));
        product1.click();
        util.waitUntilPageLoad(driver);
        WebElement sizeProduct1=driver.findElement(By.xpath("//button[text()='10']"));
        sizeProduct1.click();
        WebElement Add_to_cart_Btn=driver.findElement(By.xpath("//button[text()='Add to cart']"));
        Add_to_cart_Btn.click();
        util.waitUntilElementIsClickable(driver,Add_to_cart_Btn);
        homePage.getHomeButton().click();
        homePage.getWomenCategory().click();
        util.scrollUntil(driver.findElement(By.cssSelector("a[href='/p/buy-milano-sameeha-tote-01G9H3RKVKDTVC1H3AB6BW0ZEH']")));
        WebElement product2=driver.findElement(By.cssSelector("a[href='/p/buy-milano-sameeha-tote-01G9H3RKVKDTVC1H3AB6BW0ZEH']"));
        Thread.sleep(3000);
        product2.click();
        util.waitUntilPageLoad(driver);
        Add_to_cart_Btn=driver.findElement(By.xpath("//button[text()='Add to cart']"));
        Add_to_cart_Btn.click();
        util.waitUntilElementIsClickable(driver,Add_to_cart_Btn);
        WebElement cart=driver.findElement(By.cssSelector("a[href='/cart']"));
        cart.click();
        util.waitUntilPageLoad(driver);
        WebElement itemsCount=util.findElementByXpathContainsText(driver,"items");
        String itemsCountString=itemsCount.getText();
        Assert.assertEquals(itemsCountString, "2 items");
        WebElement totalPrice=util.findElementByXpathContainsText(driver,"KWD 50.950");
        totalPrice.getText();
        Assert.assertEquals(totalPrice.getText(),"KWD 50.950");
    }
    @Test(priority = 2)
    public void Delete_items() throws InterruptedException {
        CartPage cartPage=new CartPage(driver);
        WebElement deleteBtn=cartPage.getDeleteBtn();
        deleteBtn.click();
        util.waitForElementStaleness(deleteBtn);
        Thread.sleep(1500);
        WebElement itemsCount=util.findElementByXpathContainsText(driver,"item");
        String itemsCountString=itemsCount.getText();
        Assert.assertEquals(itemsCountString, "1 item");
        cartPage.setDeleteBtn(driver);
        deleteBtn=cartPage.getDeleteBtn();
        deleteBtn.click();
        util.waitForElementStaleness(deleteBtn);
        Thread.sleep(1500);
        itemsCount=util.findElementByXpathContainsText(driver,"items");
         itemsCountString=itemsCount.getText();
        Assert.assertEquals(itemsCountString, "0 items");
    }
}
