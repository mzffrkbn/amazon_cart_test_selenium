import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage{

    By productNameLocator = By.className("a-truncate-cut");

    public CartPage(WebDriver driver) {
        super(driver);
    }
    public boolean checkIfProductAdded() {
        return getAllProducts().size()>0;
    }
    private List<WebElement> getAllProducts(){
        return findAll(productNameLocator);
    }
}
