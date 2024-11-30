package UITests;

import io.qameta.allure.Description;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class ConstructorTest extends BaseTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return BrowserParameters.getBrowserData(); // Вызов параметров из внешнего класса
    }

    // Конструктор для передачи параметров в BaseTest
    public ConstructorTest(String browser) {
        super(browser);
    }

    @Test
    @Description("Проверка перехода в раздел 'Соусы'")
    public void testSaucesSection() {
        constructorPage.clickSaucesSection();
        // Добавляем утверждение, чтобы убедиться, что переход на раздел действительно произошел
        assertEquals("Соусы", constructorPage.getSaucesHeaderText());
        // Проверяем, что страница соусов загружена
        assertTrue("Страница с соусами не загружена", constructorPage.isSaucePageLoaded());
    }

    @Test
    @Description("Проверка перехода в раздел 'Начинки'")
    public void testFillingsSection() {
        constructorPage.clickFillingsSection();
        // Проверяем, что загружается заголовок "Начинки"
        assertEquals("Начинки", constructorPage.getFillingsHeaderText());
        // Проверка, что страница начинок загружена
        assertTrue("Страница с начинками не загружена", constructorPage.isFillingsPageLoaded());
    }

    @Test
    @Description("Проверка перехода в раздел 'Булки'")
    public void testBunsSection() {
        constructorPage.clickSaucesSection();
        constructorPage.clickBunsSection();
        assertEquals("Булки", constructorPage.getBunsHeaderText());
        // Проверка, что страница булок загрузилась
        assertTrue("Страница с булками не загружена", constructorPage.isBunsPageLoaded());
    }
}

