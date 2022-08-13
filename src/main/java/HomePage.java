import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    private final WebElement womenCategory;
    private final WebElement menCategory;
    private final WebElement kidsCategory;
    private final WebElement beautyCategory;
    private final WebElement homeButton;



    public HomePage(WebDriver driver)
    {
        this.beautyCategory=driver.findElement(By.cssSelector("a[href='/beauty/overview']"));
        this.kidsCategory=driver.findElement(By.cssSelector("a[href='/kids/overview']"));
        this.womenCategory=driver.findElement(By.cssSelector("a[href='/women/overview']"));
        this.menCategory=driver.findElement(By.cssSelector("a[href='/men/overview']"));
        this.homeButton=driver.findElement(By.cssSelector("a[href='/home/overview']"));
    }
    public WebElement getWomenCategory() {
        return womenCategory;
    }

    public WebElement getMenCategory() {
        return menCategory;
    }



    public WebElement getKidsCategory() {
        return kidsCategory;
    }



    public WebElement getBeautyCategory() {
        return beautyCategory;
    }


    public WebElement getHomeButton() {
        return homeButton;
    }
}
