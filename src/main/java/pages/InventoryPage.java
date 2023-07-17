package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {
    private WebDriver driver;
    private By pageTitle = By.cssSelector("[class='app_logo'");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public ProductPage clickProductByName(String productName) {
        driver.findElement(By.linkText(productName)).click();
        return new ProductPage(driver);
    }
    public String getTitle() {
        return driver.findElement(pageTitle).getText();
    }
}
