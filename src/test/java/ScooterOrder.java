import org.junit.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertTrue;


@RunWith(Parameterized.class)
public class ScooterOrder {
    static ChromeDriver driver;

    private final int button;
    private final String name;
    private final String lastName;
    private final String address;
    private final String number;
    private final String comment;

    public ScooterOrder(int button, String name, String lastName, String address, String number, String comment) {
        this.button = button;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.number = number;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        return new Object[][] {
                { 1, "Иван", "Иванов", "Москва", "79534420322", "Комментарий гррр"},
                { 2, "Петр", "Петров", "Тула", "79535531223", "Уруру"},
        };
    }

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void orderScooter() {
        HomePageSamokat homePageSamokat = new HomePageSamokat(driver);
        OrderPageSamokat orderPageSamokat = new OrderPageSamokat(driver);

        homePageSamokat.clickOrderButton(button);

        orderPageSamokat.orderScooter(name, lastName, address, number, comment);

        assertTrue("Окно подтверждения заказа не отображается", orderPageSamokat.checkIfConfirmationPopupIsDisplayed());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
