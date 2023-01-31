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
    private WebElement name;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "comment")
    private WebElement message;

    @FindBy(xpath = "//div[@id='main']/p")
    private WebElement errorMessage;

    @FindBy(xpath = "//a/img[@src='/images/bb/bburl.gif']")
    private WebElement urlIcon;

    @FindBy(xpath = "//a/img[@src='/images/bb/bbitalic.gif']")
    private WebElement italicIcon;

    @FindBy(xpath = "//a/img[@src='/images/bb/bbemail.gif']")
    private WebElement emailIcon;

    @FindBy(xpath = "//a/img[@src='/images/bb/bbbold.gif']")
    private WebElement boldIcon;

    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));

    public FormPage(WebDriver driver) {
        super(driver);
    }

    public WebDriverWait getWait() {

        return wait;
    }

    public void inputName(String text) {
        input(text, name);
    }

    public GenericType inputEmail(String text) {
        input(text, email);

        return createPage();
    }

    public void inputMessage(String text) {
        input(text, message);
    }

    public String getErrorMessageText() {

        return getText(errorMessage);
    }

    public void clickUrlIcon() {
        click(urlIcon);
    }

    public String getUrlIcon() {

        return urlIcon.getAttribute("src");
    }

    public String getAlertText() {
        Alert alert = getWait().until(ExpectedConditions.alertIsPresent());

        return alert.getText();
    }

    public void clickItalicIcon() {
        click(italicIcon);
    }

    public String getItalicIcon() {

        return italicIcon.getAttribute("src");
    }

    public void acceptAlert(String text) {
        Alert alert = getWait().until(ExpectedConditions.alertIsPresent());
        alert.sendKeys(text);
        alert.accept();
    }

    public void acceptTwoAlerts(String text1, String text2) {
        Alert alert = getWait().until(ExpectedConditions.alertIsPresent());
        alert.sendKeys(text1);
        alert.accept();
        alert.sendKeys(text2);
        alert.accept();
    }

    public void clickEmailIcon() {
        click(emailIcon);
    }

    public void clickBoldIcon() {
        click(boldIcon);
    }

    public void dismissAlert() {
        Alert alert = getWait().until(ExpectedConditions.alertIsPresent());
        alert.dismiss();
    }

    public void dismissTwoAlerts() {
        Alert alert = getWait().until(ExpectedConditions.alertIsPresent());
        alert.dismiss();
        alert.dismiss();
    }

    public String getBoldIcon() {

        return boldIcon.getAttribute("src");
    }
    
    public String getEmailIcon() {

        return emailIcon.getAttribute("src");
    }
}
