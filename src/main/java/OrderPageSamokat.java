import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;


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
}