import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {


    private WebElement deleteBtn;
    public CartPage(WebDriver driver)
    {

        this.deleteBtn=driver.findElement(By.cssSelector("button[aria-label='Delete']"));
    }

    public WebElement getDeleteBtn() {
        return deleteBtn;
    }
    public void setDeleteBtn(WebDriver driver) {
        this.deleteBtn = driver.findElement(By.cssSelector("button[aria-label='Delete']"));
    }
}
