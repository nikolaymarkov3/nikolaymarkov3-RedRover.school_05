package tests.guest_book;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.guest_book.SignGuestbookPage;

public class SignV2Test extends BaseTest {

    @Test
    public void testSignGuestBookVerifyTextInAlertUrlandAcceptAlert() {

        final String expectedURLMessage = "Enter the URL for the link you want to add.";

        openBaseURL()
                .clickGuestbookMenu()
                .clickSignGuestbookSubmenu()
                .clickUrlIcon();

        SignGuestbookPage signGuestbookPage = new SignGuestbookPage(getDriver());

        String actualURLMessage = signGuestbookPage.getAlertText();

        Assert.assertEquals(actualURLMessage, expectedURLMessage);
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

        SignGuestbookPage signGuestbookPage = new SignGuestbookPage(getDriver());

        signGuestbookPage.acceptTwoAlerts(text1, text2);

        String actualMessageText =
                signGuestbookPage
                        .clickSubmitButton()
                        .getMessageText();

        Assert.assertEquals(actualMessageText, expectedMessageText);
    }

    @Test
    public void testMessageAlertText_WhenItalicButtonClicked() {

        final String expectedAlertItalicMessage =
                "Enter the text that you want to make italic.";

        openBaseURL()
                .clickGuestbookMenu()
                .clickSignGuestbookSubmenu()
                .clickItalicIcon();

        SignGuestbookPage signGuestbookPage = new SignGuestbookPage(getDriver());

        String actualItalicAlertMessage = signGuestbookPage.getAlertText();

        Assert.assertEquals(actualItalicAlertMessage, expectedAlertItalicMessage);
    }

    @Test
    public void testItalicTextInMessage() {
        final String text = "Italic text";
        final String expectedItalicMessage = "[i]Italic text[/i]";

        openBaseURL()
                .clickGuestbookMenu()
                .clickSignGuestbookSubmenu()
                .clickItalicIcon();

        SignGuestbookPage signGuestbookPage = new SignGuestbookPage(getDriver());

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

    @Test
    public void testTextInEmailAlertAfterClickEmailIcon() {

        final String expectedEmailMessage =
                "Enter the email address you want to add.";

        openBaseURL()
                .clickGuestbookMenu()
                .clickSignGuestbookSubmenu()
                .clickEmailIcon();

        SignGuestbookPage signGuestbookPage = new SignGuestbookPage(getDriver());

        String actualEmailMessage = signGuestbookPage.getAlertText();

        Assert.assertEquals(actualEmailMessage, expectedEmailMessage);
    }

    @Test
    public void testTextInTextAreaAfterClickSubmitButton() {
        final String text = "guest@gmail.com";
        final String expectedMessageText = "[email]guest@gmail.com[/email]";

        openBaseURL()
                .clickGuestbookMenu()
                .clickSignGuestbookSubmenu()
                .clickEmailIcon();

        SignGuestbookPage signGuestbookPage = new SignGuestbookPage(getDriver());

        signGuestbookPage.acceptAlert(text);
        String actualMessageText =
                signGuestbookPage
                        .clickSubmitButton()
                        .getMessageText();

        Assert.assertEquals(actualMessageText, expectedMessageText);
    }

    @Test
    public void testEmailTextInTextAreaAfterClickSubmitButton()  {
        final String testEmail = "test@test.text";
        final String expectedAlertEmailMessage =
                "Enter the email address you want to add.";
        final String expectedMessageInTextArea = "[email]test@test.text[/email]";

        SignGuestbookPage signGuestbookPage =
                openBaseURL()
                        .clickGuestBookFooterMenu()
                        .clickSignGuestbookSubmenu();

        signGuestbookPage.clickEmailIcon();
        String actualAlertEmailMessage = signGuestbookPage.getAlertText();
        signGuestbookPage.acceptAlert(testEmail);

        String actualMessageInTextArea = signGuestbookPage
                .clickSubmitButton()
                .getMessageText();

        Assert.assertEquals(actualAlertEmailMessage, expectedAlertEmailMessage);
        Assert.assertEquals(actualMessageInTextArea, expectedMessageInTextArea);
    }
}
