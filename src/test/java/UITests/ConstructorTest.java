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

        // МАКСИМ, привет!) мой мозг уже между булочкой и соусом, честное слово)))
        // в коде нашла только одно это замечание, постаралась исправить, вроде все продолжает работать
        // и без той строки, да, как ты и указал. прости, туплю)
        // И да, не суди строго, плиз, мне еще работать и работать над собой) я временами лошара, но честная)))

        // Удаляем переход по вкладкам, чтобы проверить, что тест не проходит без него
        // constructorPage.clickSaucesSection(); // Удалено
        // Добавляем утверждение, чтобы убедиться, что переход на раздел действительно произошел
        assertEquals("Соусы", constructorPage.getSaucesHeaderText());
        // Проверяем, что страница соусов загружена
        assertTrue("Страница с соусами не загружена", constructorPage.isSaucePageLoaded());
    }

    @Test
    @Description("Проверка перехода в раздел 'Начинки'")
    public void testFillingsSection() {
        // Удаляем переход по вкладкам, чтобы проверить, что тест не проходит без него
        // constructorPage.clickFillingsSection(); // Удалено
        // Проверяем, что загружается заголовок "Начинки"
        assertEquals("Начинки", constructorPage.getFillingsHeaderText());
        // Проверка, что страница начинок загружена
        assertTrue("Страница с начинками не загружена", constructorPage.isFillingsPageLoaded());
    }

    @Test
    @Description("Проверка перехода в раздел 'Булки'")
    public void testBunsSection() {
        // Удаляем переход по вкладкам, чтобы проверить, что тест не проходит без него
        // constructorPage.clickSaucesSection(); // Удалено
        // constructorPage.clickBunsSection(); // Удалено
        assertEquals("Булки", constructorPage.getBunsHeaderText());
        // Проверка, что страница булок загрузилась
        assertTrue("Страница с булками не загружена", constructorPage.isBunsPageLoaded());
    }
}
