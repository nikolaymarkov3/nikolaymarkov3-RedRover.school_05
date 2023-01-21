package tests.guest_book;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.guest_book.SignGuestbookPage;

public class SignGuestbookTest extends BaseTest {

    @Test
    public void testSignGuestBookVerifyTextInAlertUrlAndAcceptAlert() {
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
    public void testMessageAlertText_WhenEmailButtonClicked() {
        final String expectedAlertEmailMessage =
                "Enter the email address you want to add.";

        openBaseURL()
                .clickGuestBookFooterMenu()
                .clickSignGuestbookSubmenu()
                .clickEmailIcon();

        SignGuestbookPage signGuestbookPage = new SignGuestbookPage(getDriver());

        String actualAlertEmailMessage =
                signGuestbookPage
                        .getAlertText();

        Assert.assertEquals(actualAlertEmailMessage, expectedAlertEmailMessage);
    }

    @Test(dependsOnMethods = "testMessageAlertText_WhenEmailButtonClicked")
    public void testEmailTextInTextAreaAfterClickSubmitButton()  {
        final String testEmail = "test@test.test";
        final String expectedMessageInTextArea = "[email]test@test.test[/email]";

        openBaseURL()
                .clickGuestBookFooterMenu()
                .clickSignGuestbookSubmenu()
                .clickEmailIcon();

        SignGuestbookPage signGuestbookPage = new SignGuestbookPage(getDriver());

        signGuestbookPage.acceptAlert(testEmail);

        String actualMessageInTextArea =
                signGuestbookPage
                        .clickSubmitButton()
                        .getMessageText();

        Assert.assertEquals(actualMessageInTextArea, expectedMessageInTextArea);
    }

    @Test
    public void testEmailTextIcon() {
        final String expectedIcon = "https://www.99-bottles-of-beer.net/images/bb/bbemail.gif";

        String actualIcon = openBaseURL()
                .clickGuestBookFooterMenu()
                .clickSignGuestbookSubmenu()
                .getEmailIcon();

        Assert.assertEquals(actualIcon, expectedIcon);
    }

    @Test
    public void testEmailIconAlertWhenClickCancel() {
        final String expectedMessage = "[email]null[/email]";

        openBaseURL()
                .clickGuestBookFooterMenu()
                .clickSignGuestbookSubmenu()
                .clickEmailIcon();

        SignGuestbookPage signGuestbookPage = new SignGuestbookPage(getDriver());

        signGuestbookPage.dismissAlert();

        String actualMessage = signGuestbookPage
                .clickSubmitButton()
                .getMessageText();

        Assert.assertFalse(signGuestbookPage.isAlertPresent(), "alert is present");
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void testAlertTextWhenClickBoldIcon() {
        final String expectedAlertText = "Enter the text that you want to make bold.";

        openBaseURL()
                .clickGuestbookMenu()
                .clickSignGuestbookSubmenu()
                .clickBoldIcon();

        SignGuestbookPage signGuestbookPage = new SignGuestbookPage(getDriver());

        String actualAlertText = signGuestbookPage.getAlertText();

        Assert.assertEquals(actualAlertText, expectedAlertText);
    }

    @Test
    public void  testBoldTextInMessageField() {
        final String boldText = "Bold Text";
        final String expectedBoldMessage = "[b]Bold Text[/b]";

        openBaseURL()
                .clickGuestbookMenu()
                .clickSignGuestbookSubmenu()
                .clickBoldIcon();

        SignGuestbookPage signGuestbookPage = new SignGuestbookPage(getDriver());

        signGuestbookPage.acceptAlert(boldText);

        String actualBoldMessage = signGuestbookPage
                .clickSubmitButton()
                .getMessageText();

        Assert.assertEquals(actualBoldMessage, expectedBoldMessage);
    }

    @Test
    public void testBoldIconAlertWhenClickCancel() {
        final String expectedMessage = "[b]null[/b]";

        openBaseURL()
                .clickGuestbookMenu()
                .clickSignGuestbookSubmenu()
                .clickBoldIcon();

        SignGuestbookPage signGuestbookPage = new SignGuestbookPage(getDriver());

        signGuestbookPage.dismissAlert();

        String actualMessage = signGuestbookPage
                .clickSubmitButton()
                .getMessageText();

        Assert.assertFalse(signGuestbookPage.isAlertPresent());
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void testUnderlineTextMessage() {
        final String expectedText = "underlined test message";
        final String expectedAlertText =
                "Error: Please enter at least a message, your email address and the security code.";

        SignGuestbookPage signGuestbookPage =
                openBaseURL()
                        .clickGuestbookMenu()
                        .clickSignGuestbookSubmenu();

        signGuestbookPage.clickUnderlineIcon();
        signGuestbookPage.acceptAlert(expectedText);
        signGuestbookPage.clickSubmitButton();

        Assert.assertTrue(signGuestbookPage.getMessageText().contentEquals("[u]" + expectedText + "[/u]"));
        Assert.assertTrue(signGuestbookPage.getErrorMessageText().contentEquals(expectedAlertText));
    }

    @Test   
    public void testBoldTextIcon() {
        final String expectedBoldTextIcon = "https://www.99-bottles-of-beer.net/images/bb/bbbold.gif";

        String actualBoldtextIcon =
                openBaseURL()
                        .clickGuestbookMenu()
                        .clickSignGuestbookSubmenu()
                        .getBoldIcon();

        Assert.assertEquals(actualBoldtextIcon, expectedBoldTextIcon);
    }
    
    @Test
     public void testEmailAlertDisappearsAndTextInTextAreaWhenCancelIsClicked() {
        final String expectedMessageInTextArea = "[email]null[/email]";

        openBaseURL()
                .clickGuestbookMenu()
                .clickSignGuestbookSubmenu()
                .clickEmailIcon();

        SignGuestbookPage signGuestbookPage = new SignGuestbookPage(getDriver());

        signGuestbookPage.dismissAlert();

        String actualMessageInTextArea = signGuestbookPage
                .clickSubmitButton()
                .getMessageText();

        Assert.assertFalse(signGuestbookPage.isAlertPresent());
        Assert.assertEquals(actualMessageInTextArea, expectedMessageInTextArea);
    }

    @Test
    public void testAlertText_WhenClickItalicIcon_FromFooterMenu() {
        final String expectedAlertText = "Enter the text that you want to make italic.";

        openBaseURL()
                .clickGuestBookFooterMenu()
                .clickSignGuestbookSubmenu()
                .clickItalicIcon();

        SignGuestbookPage signGuestbookPage = new SignGuestbookPage(getDriver());

        String actualAlertText = signGuestbookPage.getAlertText();

        Assert.assertEquals(actualAlertText, expectedAlertText);
    }

    @Test
    public void testItalicTextInMessage_FromFooterMenu() {
        final String text = "Italic text";
        final String expectedItalicMessage = "[i]Italic text[/i]";

        openBaseURL()
                .clickGuestBookFooterMenu()
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
    public void testUrlIcon() {
        final String expectedUrlIcon = "https://www.99-bottles-of-beer.net/images/bb/bburl.gif";

        String actualUrlIcon = openBaseURL()
                .clickGuestBookFooterMenu()
                .clickSignGuestbookSubmenu()
                .getUrlIcon();

        Assert.assertEquals(actualUrlIcon, expectedUrlIcon);
    }
    
    @Test
    public void testPromptAlertsTexts_WhenClickUrlIcon() {
        final String expectedFirstPromptAlert =
                "Enter the URL for the link you want to add.";
        final String expectedSecondPromptAlert =
                "Enter the web site title";
        final String text = "Text";

        openBaseURL()
                .clickGuestbookMenu()
                .clickSignGuestbookSubmenu()
                .clickUrlIcon();

        SignGuestbookPage signGuestbookPage = new SignGuestbookPage(getDriver());
        
        String actualFirstPromptAlert = signGuestbookPage.getAlertText();

        signGuestbookPage.acceptAlert(text);

        String actualSecondPromptAlert = signGuestbookPage.getAlertText();

        Assert.assertEquals(actualFirstPromptAlert, expectedFirstPromptAlert);
        Assert.assertEquals(actualSecondPromptAlert, expectedSecondPromptAlert);
    }

    @Test
    public void testTextInMessageField_WhenClickSubmitButton() {
        final String urlLink = "URL link";
        final String webSiteTitle = "Web site title";
        final String expectedMessageText = "[url=URL link]Web site title[/url]";

        openBaseURL()
                .clickGuestbookMenu()
                .clickSignGuestbookSubmenu()
                .clickUrlIcon();

        SignGuestbookPage signGuestbookPage = new SignGuestbookPage(getDriver());

        signGuestbookPage.acceptTwoAlerts(urlLink, webSiteTitle);

        String actualMessageText = signGuestbookPage
                .clickSubmitButton()
                .getMessageText();

        Assert.assertEquals(actualMessageText, expectedMessageText);
    }

    @Test
    public void testUrlPromptAlertsDisappear_WhenClickCancelButton() {
        final String expectedPageUrl = "https://www.99-bottles-of-beer.net/signv2.html";

        openBaseURL()
                .clickGuestbookMenu()
                .clickSignGuestbookSubmenu()
                .clickUrlIcon();

        SignGuestbookPage signGuestbookPage = new SignGuestbookPage(getDriver());

        signGuestbookPage.dismissTwoAlerts();

        String actualPageUrl = signGuestbookPage
                .getURL();

        Assert.assertFalse(signGuestbookPage.isAlertPresent());
        Assert.assertEquals(actualPageUrl, expectedPageUrl);
    }
}
