package tests.guest_book;

import base.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.guest_book.SignGuestbookPage;

import java.time.Duration;

public class SignV2Test extends BaseTest {

    @Test
    public void testSignGuestBookVerifyTextInAlertUrlandAcceptAlert() {

        openBaseURL()
                .clickGuestbookMenu()
                .clickSignGuestbookSubmenu()
                .clickUrlIcon();

        SignGuestbookPage signV2Page = new SignGuestbookPage(getDriver());

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        Assert.assertEquals(signV2Page.getAlertText(alert), "Enter the URL for the link you want to add.");
    }

    @Test
    public void testErrorMessageIfSubmitWithoutCaptcha() {
        final String name = "Guest";
        final String email = "guest@gmail.com";
        final String message = "it is a message";
        final String expectedErrorMessage =
                "Error: Please enter at least a message, your email address and the security code.";

        SignGuestbookPage signGuestbookPage =
                openBaseURL()
                        .clickGuestbookMenu()
                        .clickSignGuestbookSubmenu();
        signGuestbookPage.inputName(name);
        signGuestbookPage.inputMessage(message);
        signGuestbookPage.inputEmail(email);

        String actualErrorMessage = signGuestbookPage
                .clickSubmitButton()
                .getErrorMessageText();

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }

    @Test
    public void testAlertTextIsDisplayedOnMessageFieldAfterClickSubmitButton() {
        final String text1 = "FirstText";
        final String text2 = "SecondText";
        final String expectedMessageText = "[url=FirstText]SecondText[/url]";

        openBaseURL()
                .clickGuestBookFooterMenu()
                .clickSignGuestbookSubmenu()
                .clickUrlIcon();

        SignGuestbookPage signV2Page = new SignGuestbookPage(getDriver());

        signV2Page.acceptTwoAlerts(text1, text2);

        String actualMessageText =
                signV2Page
                        .clickSubmitButton()
                        .getMessageText();

        Assert.assertEquals(actualMessageText, expectedMessageText);
    }

    @Test
    public void testMessageAlertText_WhenItalicButtonClicked() {

        final String message = "Italic text";
        final String expectedAlertItalicMessage =
                "Enter the text that you want to make italic.";

        openBaseURL()
                .clickGuestbookMenu()
                .clickSignGuestbookSubmenu()
                .clickItalicIcon();

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        SignGuestbookPage signGuestbookPage = new SignGuestbookPage(getDriver());
        String actualItalicAlertMessage = signGuestbookPage.getAlertText(alert);

        Assert.assertEquals(actualItalicAlertMessage, expectedAlertItalicMessage);
    }

    @Test
    public void testItalicTextInMessage() {
        final String text = "Italic text";
        final String expectedItalicMessage = "[i]Italic text[/i]";

        SignGuestbookPage signGuestbookPage =
                openBaseURL()
                        .clickGuestbookMenu()
                        .clickSignGuestbookSubmenu();
        signGuestbookPage.clickItalicIcon();
        signGuestbookPage.acceptAlert(text);

        String actualItalicMessage = signGuestbookPage
                .clickSubmitButton()
                .getMessageText();

        Assert.assertEquals(actualItalicMessage, expectedItalicMessage);
    }

    @Test
    public void testItalicTextIcon() {
        final String expectedIcon = "https://www.99-bottles-of-beer.net/images/bb/bbitalic.gif";

        String actualIcon = openBaseURL()
                .clickGuestbookMenu()
                .clickSignGuestbookSubmenu()
                .getItalicIcon();

        Assert.assertEquals(actualIcon, expectedIcon);
    }
}
