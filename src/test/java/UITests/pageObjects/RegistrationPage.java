package UITests.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RegistrationPage {
    private WebDriver driver;

    // Локатор для кнопки "Войти в аккаунт"
    @FindBy(xpath = "//button[contains(text(),'Войти')]") // Изменено с "Войти в аккаунт" на "Войти"
    private WebElement loginAccountButton;

    // Локатор для кнопки регистрации
    @FindBy(xpath = "//a[contains(text(),'Зарегистрироваться')]") // Изменено с указания по слоям на более точный локатор по тексту
    private WebElement registerButton;

    // Локатор для поля ввода имени
    @FindBy(name = "name") // Используем атрибут name для большей стабильности
    private WebElement nameInput;

    // Локатор для поля ввода email
    @FindBy(name = "email") // Предполагается, что есть поле с атрибутом name
    private WebElement emailInput;

    // Локатор для поля ввода пароля
    @FindBy(name = "password") // Предполагается, что есть поле с атрибутом name
    private WebElement passwordInput;

    // Локатор для кнопки "Зарегистрироваться"
    @FindBy(xpath = "//button[contains(text(),'Зарегистрироваться')]") // Изменено с указания по слоям на более точный локатор по тексту
    private WebElement registerButtonClick;

    // Локатор для сообщения об ошибке
    @FindBy(xpath = "//div[contains(@class, 'error-message')]") // Используем более точный класс, если возможен
    private WebElement passwordError;

    // Конструктор
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForNameInput() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(nameInput));
    }

    public void waitForEmailInput() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(emailInput)); // Исправлено, чтобы ожидать поле email
    }

    public void waitForPasswordInput() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(passwordInput)); // Исправлено, чтобы ожидать поле password
    }

    public void scrollToRegisterButton() {
        // Используем локатор кнопки регистрации
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", registerButton);
    }

    // Методы для взаимодействия с элементами
    public void clickLoginAccountButton() {
        loginAccountButton.click();
    }

    public void clickRegisterButton() {
        registerButton.click();
    }

    public void enterName(String name) {
        nameInput.sendKeys(name);
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickRegisterButtonClick() {
        registerButtonClick.click(); // Исправлено на registerButtonClick
    }

    public boolean isPasswordErrorDisplayed() {
        return passwordError.isDisplayed();
    }

    public String getPasswordErrorText() {
        return passwordError.getText();
    }
}
