import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.JavascriptExecutor;

import static org.junit.Assert.assertTrue;


class OrderPageSamokat {

    private WebDriver driver;

    // Имя
    private By nameInput = By.xpath(".//div[@class='Order_Form__17u6u']/div[@class='Input_InputContainer__3NykH'][1]/input[contains(@class,  'Input_Input__1iN_Z')]");

    // Фамилия
    private By lastnameInput = By.xpath(".//div[@class='Order_Form__17u6u']/div[@class='Input_InputContainer__3NykH'][2]/input[contains(@class,  'Input_Input__1iN_Z')]");

    // Адрес
    private By addressInput = By.xpath(".//div[@class='Order_Form__17u6u']/div[@class='Input_InputContainer__3NykH'][3]/input[contains(@class,  'Input_Input__1iN_Z')]");

    // Станция
    private By stationInput = By.className("select-search__input");

    // Выпадающий список в станции
    private By firstItemInStationInput = By.xpath(".//ul[@class='select-search__options']/li[@data-value='1']");

    // Телефон
    private By phoneInput = By.xpath(".//div[@class='Order_Form__17u6u']/div[@class='Input_InputContainer__3NykH'][4]/input[contains(@class,  'Input_Input__1iN_Z')]");

    // кнопка "Далее"
    private By nextButton = By.cssSelector(".Order_NextButton__1_rCA button");

    // Когда привезти самокат
    private By dateInput = By.cssSelector(".react-datepicker-wrapper input");

    // 1-е отображаемое число в календаре
    private By firstDateInDateInput = By.xpath(".//div[contains(@class, 'react-datepicker__week')][1]/div[contains(@class, 'react-datepicker__day')][1]");

    // Срок аренды
    private By periodInput = By.xpath(".//div[contains(@class, 'Dropdown-root')]");

    // Сутки в выпадающем списке Срока аренды
    private By dayInLeasingList = By.xpath(".//div[text()='сутки']");

    // Чекбокс "Черный"
    private By blackCheckbox = By.id("black");

    // Комментарий
    private By commentInput = By.xpath(".//input[contains(@placeholder, 'Комментарий для курьера')]");

    //Заказать
    private By orderButton = By.xpath(".//button[2][text()='Заказать']");

    // "Да" в модалке подтверждения заказа
    private By  yesButton = By.xpath(".//button[text()='Да']");

    // Всплывающее окно с сообщением об успешном создании заказа
    private By confirmationPopup = By.xpath(".//div[text()='Заказ оформлен']//parent::div[@class='Order_Modal__YZ-d3']");

    // Заголовок (весь текст сверху) во сплывающем окне с сообщением об успешном создании заказа
    public OrderPageSamokat(WebDriver driver) {
        this.driver = driver;
    }

    public void fillNameInput(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }

    public void fillLastnameInput(String lastname) {
        driver.findElement(lastnameInput).sendKeys(lastname);
    }

    public void fillAddress(String address) {
        driver.findElement(addressInput).sendKeys(address);
    }

    public void setStation() {
        driver.findElement(stationInput).click();
        driver.findElement(firstItemInStationInput).click();
    }

    public void fillPhoneInput(String number) {
        driver.findElement(phoneInput).sendKeys(number);
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    public void setDate() {
        driver.findElement(dateInput).click();
        driver.findElement(firstDateInDateInput).click();
    }

    public void setPeriod() {
        driver.findElement(periodInput).click();
        driver.findElement(dayInLeasingList).click();
    }

    public void checkColor() {
        driver.findElement(blackCheckbox).click();
    }

    public void fillCommentInput(String comment) {
        driver.findElement(commentInput).sendKeys(comment);
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void clickYesButton() {
        driver.findElement(yesButton).click();
    }

    public void orderScooter(String name, String lastname, String address, String number, String comment) {
        fillNameInput(name);
        fillLastnameInput(lastname);
        fillAddress(address);
        setStation();
        fillPhoneInput(number);
        clickNextButton();
        setDate();
        setPeriod();
        checkColor();
        fillCommentInput(comment);
        clickOrderButton();
        clickYesButton();
    }

    public boolean checkIfConfirmationPopupIsDisplayed() {
        return driver.findElement(confirmationPopup).isDisplayed();
    }

    // метод ожидания прогрузки данных профиля
    /*
    public void waitForLoadOrderPage() {
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(profileTitle).getText() != null
                && !driver.findElement(profileTitle).getText().isEmpty()
        ));
    }
    */
}


class HomePageSamokat {

    private WebDriver driver;

    //8 элементов списка "Вопросы о важном"
    private By importantQuestion1 = By.id("accordion__heading-0");

    //8 элементов раскрывающегося (ответы) списка "Вопросы о важном"
    private By importantAnswer1 = By.id("accordion__panel-0");

    // верхняя кнопка "Заказать"
    private By topOrderButton = By.cssSelector(".Header_Nav__AGCXC .Button_Button__ra12g");

    // нижняя кнопка "Заказать"
    private By bottomOrderButton = By.cssSelector(".Home_FinishButton__1_cWm .Button_Button__ra12g");

    public HomePageSamokat(WebDriver driver) {
        this.driver = driver;
    }

    public void clickTopOrderButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(topOrderButton));

        driver.findElement(topOrderButton).click();
    }

    public void clickBottomOrderButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(bottomOrderButton));

        driver.findElement(bottomOrderButton).click();
    }

    public void clickOrderButton(int buttonNumber) {
        if (buttonNumber == 1) {
            clickTopOrderButton();
        } else if (buttonNumber == 2) {
            clickBottomOrderButton();
        }
    }

    public void clickOnFAQ() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(importantQuestion1));

        driver.findElement(importantQuestion1).click();
    }

    public boolean checkIfImportantAnswer1IsDisplayed() {
        return driver.findElement(importantAnswer1).isDisplayed();
    }
}


// Класс с автотестом
public class Samokat {
   ChromeDriver driver = new ChromeDriver();

    @Test
    public void checkTextFAQ() {
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomePageSamokat homePageSamokat = new HomePageSamokat(driver);

        homePageSamokat.clickOnFAQ();
        assertTrue("Ответ на вопрос о важном не оторажается", homePageSamokat.checkIfImportantAnswer1IsDisplayed());
    }

    @Test
    public void registration() {
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomePageSamokat homePageSamokat = new HomePageSamokat(driver);
        OrderPageSamokat orderPageSamokat = new OrderPageSamokat(driver);

        homePageSamokat.clickOrderButton(1);

        orderPageSamokat.orderScooter("Иван", "Иванов", "Москва", "79534420322", "Комментарий гррр");

        assertTrue("Окно подтверждения заказа не отображается", orderPageSamokat.checkIfConfirmationPopupIsDisplayed());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}