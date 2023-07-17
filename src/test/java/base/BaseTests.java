package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.*;

public class BaseTests {
    private static WebDriver driver;
    protected LoginPage loginPage;
    protected InventoryPage inventoryPage;
    protected Navigator navigator;
    protected StepOnePage stepOnePage;
    protected StepTwoPage stepTwoPage;
    protected CheckoutCompletePage checkoutCompletePage;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        this.goToWebsite();
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        navigator = new Navigator(driver);
        stepOnePage = new StepOnePage(driver);
        stepTwoPage = new StepTwoPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);
    }

    @BeforeMethod
    public void goToWebsite() {
        driver.get("https://www.saucedemo.com/");

        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        navigator = new Navigator(driver);
        stepOnePage = new StepOnePage(driver);
        stepTwoPage = new StepTwoPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
