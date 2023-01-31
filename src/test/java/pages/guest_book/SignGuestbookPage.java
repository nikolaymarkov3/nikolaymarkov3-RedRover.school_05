package pages.guest_book;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignGuestbookPage extends GuestbookSubmenuPage {

    @FindBy(name = "location")
    private WebElement location;

    @FindBy(name = "comment")
    private WebElement message;

    @FindBy(xpath = "//a/img[@src='/images/bb/bburl.gif']")
    private WebElement urlIcon;

    @FindBy(xpath = "//a/img[@src='/images/bb/bbunderline.gif']")
    private WebElement underlineIcon;

    @FindBy(name = "submit")
    private WebElement submitButton;

    @FindBy(xpath = "//form")
    private WebElement signGuestbookForm;

    @FindBy(xpath = "//form//input[1]")
    private WebElement input1SignGuestbookForm;

    @FindBy(xpath = "//form//input[2]")
    private WebElement input2SignGuestbookForm;

    @FindBy(xpath = "//form//input[3]")
    private WebElement input3SignGuestbookForm;

    @FindBy(xpath = "//form//input[4]")
    private WebElement input4SignGuestbookForm;

    @FindBy(xpath = "//form//input[5]")
    private WebElement input5SignGuestbookForm;

    @FindBy(xpath = "//form//input[6]")
    private WebElement input6SignGuestbookForm;

    public SignGuestbookPage(WebDriver driver) {
        super(driver);
    }

    public SignGuestbookPage clickSubmitButton() {
        click(submitButton);

        return this;
    }

    public String getMessageText() {

        return getText(message);
    }

    public void clickUnderlineIcon() {
        click(underlineIcon);
    }

    public String getAction() {

        return getAttribute(signGuestbookForm, "action");
    }

    public String getMethod() {

        return getAttribute(signGuestbookForm, "method");
    }

    public SignGuestbookPage inputSingGuestbookName(String text) {
        input(text, input1SignGuestbookForm);

        return this;
    }

    public SignGuestbookPage inputSingGuestbookLocation(String text) {
        input(text, input2SignGuestbookForm);

        return this;
    }

    public SignGuestbookPage inputSingGuestbookEmail(String text) {
        input(text, input3SignGuestbookForm);

        return this;
    }

    public SignGuestbookPage inputSingGuestbookHomepage(String text) {
        input(text, input4SignGuestbookForm);

        return this;
    }

    public SignGuestbookPage inputSingGuestbookMessage(String text) {
        input(text, message);

        return this;
    }

    public String getInput6Value() {

        return getAttribute(input6SignGuestbookForm, "value");
    }

    public String getInput1Name() {

        return getAttribute(input1SignGuestbookForm, "name");
    }

    public String getInput2Name() {

        return getAttribute(input2SignGuestbookForm, "name");
    }

    public String getInput3Name() {

        return getAttribute(input3SignGuestbookForm, "name");
    }

    public String getInput4Name() {

        return getAttribute(input4SignGuestbookForm, "name");
    }

    public String getInput5Name() {

        return getAttribute(input5SignGuestbookForm, "name");
    }

    public String getInput6Name() {

        return getAttribute(input6SignGuestbookForm, "name");
    }
}
