package pages.base_abstract;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class FormPage<GenericType> extends MainPage<GenericType> {

    @FindBy(name = "name")
    WebElement name;

    @FindBy(name = "email")
    WebElement email;

    @FindBy(xpath = "//div[@id='main']/p")
    private WebElement errorMessage;

    @FindBy(xpath = "//a/img[@src='/images/bb/bburl.gif']")
    WebElement urlIcon;

    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));

    public FormPage(WebDriver driver) {
        super(driver);
    }

    WebDriverWait getWait() {

        return wait;
    }

    public void inputName(String text) {
        input(text, name);
    }

    public GenericType inputEmail(String text) {
        input(text, email);

        return createPage();
    }

    public String getErrorMessageText() {

        return getText(errorMessage);
    }

    public void clickUrlIcon() {
        click(urlIcon);
    }

    public String getAlertText(Alert alert) {

        return alert.getText();
    }

    public void acceptAlert(Alert alert, String text) {
        alert.sendKeys(text);
        alert.accept();
        alert.accept();
    }

    public void acceptTwoAlerts(String text1, String text2) {
        Alert alert = getWait().until(ExpectedConditions.alertIsPresent());
        alert.sendKeys(text1);
        alert.accept();
        alert.sendKeys(text2);
        alert.accept();
    }
}
