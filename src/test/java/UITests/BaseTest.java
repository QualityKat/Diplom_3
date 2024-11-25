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




/*
// Основные начальные методы тестирования
// Для вызова тестирования браузеров отдельными командами (как один из вариантов)
// mvn test -Dbrowser=chrome
// mvn test -Dbrowser=yandex
package UITests;

import UITests.pageObjects.ConstructorPage;
import UITests.pageObjects.RegistrationPage;
import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import UITests.pageObjects.LoginPage;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    protected RegistrationPage registrationPage;
    protected LoginPage loginPage;
    protected ConstructorPage constructorPage;
    protected final String URL = "https://stellarburgers.nomoreparties.site/";

    @Step("Настройка WebDriver")
    @Before
    public void setUp() {
        String browser = System.getProperty("browser", "chrome"); // По умолчанию Chrome
        driver = WebDriverFactory.getDriver(browser);
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
        constructorPage = new ConstructorPage(driver);
    }

    @Step("Завершение работы с WebDriver")
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}*/