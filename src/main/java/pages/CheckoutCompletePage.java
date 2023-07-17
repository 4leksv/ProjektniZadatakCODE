package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage {
    private WebDriver driver;
    private By backHomeButton = By.cssSelector("[class='btn btn_primary btn_small']");
    private By transactionSuccess = By.cssSelector("[class='checkout_complete_container']");

    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    public StepTwoPage clickBackHome() {
        driver.findElement(backHomeButton).click();
        return new StepTwoPage(driver);
    }
    public boolean isTransactionComplete() {
        return driver.findElement(transactionSuccess).isDisplayed();
    }
}
