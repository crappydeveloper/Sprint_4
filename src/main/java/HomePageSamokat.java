import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;


class HomePageSamokat {

    private WebDriver driver;

    //8 элементов списка "Вопросы о важном"
    private By importantQuestion1 = By.id("accordion__heading-0");
    private By importantQuestion2 = By.id("accordion__heading-1");
    private By importantQuestion3 = By.id("accordion__heading-2");
    private By importantQuestion4 = By.id("accordion__heading-3");
    private By importantQuestion5 = By.id("accordion__heading-4");
    private By importantQuestion6 = By.id("accordion__heading-5");
    private By importantQuestion7 = By.id("accordion__heading-6");
    private By importantQuestion8 = By.id("accordion__heading-7");

    //8 элементов (ответы) раскрывающегося списка "Вопросы о важном"
    private By importantAnswer1 = By.id("accordion__panel-0");
    private By importantAnswer2 = By.id("accordion__panel-1");
    private By importantAnswer3 = By.id("accordion__panel-2");
    private By importantAnswer4 = By.id("accordion__panel-3");
    private By importantAnswer5 = By.id("accordion__panel-4");
    private By importantAnswer6 = By.id("accordion__panel-5");
    private By importantAnswer7 = By.id("accordion__panel-6");
    private By importantAnswer8 = By.id("accordion__panel-7");

    // верхняя кнопка "Заказать"
    private By topOrderButton = By.cssSelector(".Header_Nav__AGCXC .Button_Button__ra12g");

    // нижняя кнопка "Заказать"
    private By bottomOrderButton = By.cssSelector(".Home_FinishButton__1_cWm .Button_Button__ra12g");

    public HomePageSamokat(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollToElementAndClick(By el) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(el));

        driver.findElement(el).click();
    }

    public void clickFAQButton(int questionNumber) {
        if (questionNumber == 1) {
            scrollToElementAndClick(importantQuestion1);
        } else if (questionNumber == 2) {
            scrollToElementAndClick(importantQuestion2);
        } else if (questionNumber == 3) {
            scrollToElementAndClick(importantQuestion3);
        } else if (questionNumber == 4) {
            scrollToElementAndClick(importantQuestion4);
        } else if (questionNumber == 5) {
            scrollToElementAndClick(importantQuestion5);
        } else if (questionNumber == 6) {
            scrollToElementAndClick(importantQuestion6);
        } else if (questionNumber == 7) {
            scrollToElementAndClick(importantQuestion7);
        } else if (questionNumber == 8) {
            scrollToElementAndClick(importantQuestion8);
        }
    }

    public void clickOrderButton(int buttonNumber) {
        if (buttonNumber == 1 || buttonNumber == 2) {
            scrollToElementAndClick(topOrderButton);
        }
    }

    public String getDisplayedAnswer(int answerNumber) {
        String answerString = "";
        if (answerNumber == 1 && driver.findElement(importantAnswer1).isDisplayed()) {
            answerString += driver.findElement(importantAnswer1).getText();
        } else if (answerNumber == 2 && driver.findElement(importantAnswer2).isDisplayed()) {
            answerString += driver.findElement(importantAnswer2).getText();
        } else if (answerNumber == 3 && driver.findElement(importantAnswer3).isDisplayed()) {
            answerString += driver.findElement(importantAnswer3).getText();
        } else if (answerNumber == 4 && driver.findElement(importantAnswer4).isDisplayed()) {
            answerString += driver.findElement(importantAnswer4).getText();
        } else if (answerNumber == 5 && driver.findElement(importantAnswer5).isDisplayed()) {
            answerString += driver.findElement(importantAnswer5).getText();
        } else if (answerNumber == 6 && driver.findElement(importantAnswer6).isDisplayed()) {
            answerString += driver.findElement(importantAnswer6).getText();
        } else if (answerNumber == 7 && driver.findElement(importantAnswer7).isDisplayed()) {
            answerString += driver.findElement(importantAnswer7).getText();
        } else if (answerNumber == 8 && driver.findElement(importantAnswer8).isDisplayed()) {
            answerString += driver.findElement(importantAnswer8).getText();
        }
        return answerString;
    }
}
