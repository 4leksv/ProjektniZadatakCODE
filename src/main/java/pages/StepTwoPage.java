package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StepTwoPage {
    private WebDriver driver;
    private By totalPrice = By.cssSelector("[class='summary_info_label summary_total_label']");
    private By finishButton = By.cssSelector("[class='btn btn_action btn_medium cart_button']");

    public StepTwoPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTotalPrice() {
        return driver.findElement(totalPrice).getText();
    }
    public StepOnePage clickFinish() {
        driver.findElement(finishButton).click();
        return new StepOnePage(driver);
    }
}
