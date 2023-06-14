import org.junit.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ScooterFAQ {
    static ChromeDriver driver = new ChromeDriver();

    private final int questionNumber;
    private final String answer;

    public ScooterFAQ(int questionNumber, String answer) {
        this.questionNumber = questionNumber;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Object[][] getFAQData() {
        return new Object[][] {
                { 1, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                { 2, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                { 3, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                { 4, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                { 5, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                { 6, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                { 7, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                { 8, "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    @BeforeClass
    public static void setup() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void checkTextIsDisplayedFAQ() {
        HomePageSamokat homePageSamokat = new HomePageSamokat(driver);

        homePageSamokat.clickFAQButton(questionNumber);
        String actual = homePageSamokat.getDisplayedAnswer(questionNumber);

        assertEquals("Не отображается корректный ответ на вопрос номер " + questionNumber, answer, actual);
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }
}