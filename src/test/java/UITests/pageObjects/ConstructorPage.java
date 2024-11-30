package UITests.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class ConstructorPage {
    private WebDriver driver;

    // Локатор для раздела "Булки"
    @FindBy(xpath = "//span[text()='Булки']")
    private WebElement bunsSection;

    // Локатор для раздела "Соусы"
    @FindBy(xpath = "//span[text()='Соусы']")
    private WebElement saucesSection;

    // Локатор для раздела "Начинки"
    @FindBy(xpath = "//span[text()='Начинки']")
    private WebElement fillingsSection;

    // Локатор заголовка раздела "Соусы"
    @FindBy(xpath = "//*[@id='root']/div/main/section[1]/div[2]/h2[2]")
    private WebElement saucesHeader;

    // Локатор заголовка раздела "Начинки"
    @FindBy(xpath = "//*[@id='root']/div/main/section[1]/div[2]/h2[3]")
    private WebElement fillingsHeader;

    // Локатор заголовка раздела "Булки"
    @FindBy(xpath = "//*[@id='root']/div/main/section[1]/div[2]/h2[1]")
    private WebElement bunsHeader;

    // Конструктор
    public ConstructorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Методы для взаимодействия с элементами
    public void clickSaucesSection() {
        saucesSection.click();
    }

    public String getSaucesHeaderText() {
        return saucesHeader.getText();
    }

    public void clickFillingsSection() {
        fillingsSection.click();
    }

    public String getFillingsHeaderText() {
        return fillingsHeader.getText();
    }

    public void clickBunsSection() {
        bunsSection.click();
    }

    public String getBunsHeaderText() {
        return bunsHeader.getText();
    }

    // Методы для проверки, что соответствующие страницы загружены
    public boolean isSaucePageLoaded() {
        return saucesHeader.isDisplayed();
    }

    public boolean isFillingsPageLoaded() {
        return fillingsHeader.isDisplayed();
    }

    public boolean isBunsPageLoaded() {
        return bunsHeader.isDisplayed();
    }
}
