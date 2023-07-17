package pages;

import org.openqa.selenium.*;

public class StepOnePage {
    private WebDriver driver;
    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By postalCodeField = By.id("postal-code");
    private By continueButton = By.cssSelector("[class='submit-button btn btn_primary cart_button btn_action']");

    public StepOnePage(WebDriver driver) {
        this.driver = driver;
    }

    public void setFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }
    public void setLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }
    public void setPostalCode(String postalCode) {
        driver.findElement(postalCodeField).sendKeys(postalCode);
    }
    public CartPage clickContinue() {
        driver.findElement(continueButton).click();
        return new CartPage(driver);
    }
    public boolean isCheckoutSuccessful() {
        try {
            WebElement successMessage = driver.findElement(By.cssSelector("[class='checkout_info_container']"));
            return successMessage.isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
}
