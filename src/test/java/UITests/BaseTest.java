package UITests;

import UITests.pageObjects.ConstructorPage;
import UITests.pageObjects.RegistrationPage;
import UITests.pageObjects.LoginPage;
import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    protected WebDriver driver;
    protected RegistrationPage registrationPage;
    protected LoginPage loginPage;
    protected ConstructorPage constructorPage;
    protected final String URL = "https://stellarburgers.nomoreparties.site/";
    protected final String browser;

    public BaseTest(String browser) {
        this.browser = browser;
    }

    @Step("Настройка WebDriver")
    @Before
    public void setUp() {
        driver = WebDriverFactory.getDriver(browser);
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
        constructorPage = new ConstructorPage(driver);
        System.out.println("Тест запущен в браузере: " + browser);
    }

    @Step("Завершение работы с WebDriver")
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
