package tests.browse_languages.languages;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.languages.KotlinLanguagePage;

import java.util.List;

public class KotlinLanguageTest extends BaseTest {

    @Test
    public void testKotlinPageContent() {
        final String expectedH2HeaderLanguageKotlin = "Language Kotlin";
        final String expectedH2HeaderAlternativeVersions = "Alternative Versions";
        final String expectedH2HeaderComments = "Comments";

        final List<String> expectedNamesInTextTable = List.of("Date:", "Author:", "URL:", "Comments:", "Info:", "Score:");
        final List<String> expectedLinksDownload = List.of("Download Source", "Download Source");
        final List<String> expectedLinksAddComment = List.of("Write Comment", "Write Comment");
        final List<String> expectedH2HeaderTextVoting = List.of("Voting", "Category", "Bookmarking");

        KotlinLanguagePage kotlinLanguagePage = new KotlinLanguagePage(getDriver());

        openBaseURL().
                clickBrowseLanguagesMenu().
                clickKSubmenu().
                clickKotlinLanguage();

        String actualH2HeaderLanguageKotlin = kotlinLanguagePage.getH2HeaderText();
        String actualH2HeaderAlternativeVersions = kotlinLanguagePage.getAlternativeVersionsHeader();
        String actualH2HeaderComments = kotlinLanguagePage.getCommentsHeader();

        List<String> actualNamesInTextTable = kotlinLanguagePage.getLanguageInfoFields();
        List<String> actualLinksDownload = kotlinLanguagePage.getDownloadSourceLinks();
        List<String> actualLinksAddComment = kotlinLanguagePage.getWriteCommentLinksTexts();
        List<String> actualH2HeaderTextVoting = kotlinLanguagePage.getVotingHeader();

        Assert.assertEquals(actualH2HeaderLanguageKotlin, expectedH2HeaderLanguageKotlin);
        Assert.assertEquals(actualNamesInTextTable, expectedNamesInTextTable);
        Assert.assertEquals(actualLinksDownload, expectedLinksDownload);
        Assert.assertEquals(actualLinksAddComment, expectedLinksAddComment);
        Assert.assertEquals(actualH2HeaderAlternativeVersions, expectedH2HeaderAlternativeVersions);
        Assert.assertEquals(actualH2HeaderComments, expectedH2HeaderComments);
        Assert.assertEquals(actualH2HeaderTextVoting, expectedH2HeaderTextVoting);
    }

    @Test
    public void testAddCommentInformationAfterClickingWriteCommentButton() {
        final String expectedH2HeaderAddComment = "Add Comment";
        final String expectedInfoTextAddComment = "Please provide a value for the fields Name, Comment and Security Code.\n" +
                "This is a gravatar-friendly website.\n" +
                "E-mail addresses will never be shown.\n" +
                "Enter your e-mail address to use your gravatar.\n" +
                "\n" +
                "Please don't post large portions of code here! Use the form to submit new examples or updates instead!";
        final List<String> expectedFieldsToFillAddComment = List.of("Name:", "eMail:", "URL:", "Security Code:", "Comment:");

        openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickKSubmenu()
                .clickKotlinLanguage();

        KotlinLanguagePage kotlinLanguagePage = new KotlinLanguagePage(getDriver());

        String actualOldH2HeaderAddComment = kotlinLanguagePage.getH2HeaderAddCommentText();

        Assert.assertTrue(actualOldH2HeaderAddComment.isEmpty(), "Add comment is visible");

        kotlinLanguagePage.clickWriteComment();

        String actualH2HeaderAddComment = kotlinLanguagePage.getH2HeaderAddCommentText();
        String actualInfoTextAddComment = kotlinLanguagePage.getInfoAddCommentText();
        List<String> actualFieldsToFillAddComment = kotlinLanguagePage.getFieldsToFillAddComment();

        Assert.assertEquals(actualH2HeaderAddComment, expectedH2HeaderAddComment);
        Assert.assertEquals(actualInfoTextAddComment, expectedInfoTextAddComment);
        Assert.assertEquals(actualFieldsToFillAddComment, expectedFieldsToFillAddComment);
    }

    @Test
    public void testFormLink_NavigatesTo_SubmitNewLanguagePage() {
        final String expectedURL = "https://www.99-bottles-of-beer.net/submitnewlanguage.html";
        final String expectedTitle = "99 Bottles of Beer | Submit new Language";

        openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickKSubmenu()
                .clickKotlinLanguage()
                .clickWriteComment();

        KotlinLanguagePage kotlinLanguagePage = new KotlinLanguagePage(getDriver());

        String oldURL = kotlinLanguagePage.getURL();

        kotlinLanguagePage.clickFormLink();

        String actualURL = kotlinLanguagePage.getURL();
        String actualTitle = kotlinLanguagePage.getTitle();

        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void testGravatarFriendlyLink_NavigatesTo_ExternalPage() {
        final String expectedExternalUrl = "https://en.gravatar.com/";
        final String expectedExternalTitle = "Gravatar - Globally Recognized Avatars";

        KotlinLanguagePage kotlinLanguagePage =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .clickKSubmenu()
                        .clickKotlinLanguage();

        kotlinLanguagePage.clickWriteComment();
        kotlinLanguagePage.clickGravatarFriendlyLink();

        String actualExternalUrl = getExternalPageURL();
        String actualExternalTitle = getExternalPageTitle();

        Assert.assertEquals(actualExternalUrl, expectedExternalUrl);
        Assert.assertEquals(actualExternalTitle, expectedExternalTitle);
    }

    @Test
    public void testRequiredCommentFieldCircledRedAndErrorTextAppearsWhenClickingButtonSubmitComment() {
        final String expectedBorderOfRequiredFieldComment = "1px solid rgb(255, 0, 0)";
        final String expectedErrorMessage = "Error: Error: A comment doesn't make sense without text.";
        final String expectedOldBorder = "1px solid rgb(153, 153, 153)";

        KotlinLanguagePage kotlinLanguagePage =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .clickKSubmenu()
                        .clickKotlinLanguage();

        String actualOldBorder =
                kotlinLanguagePage
                        .clickWriteComment()
                        .getCommentBorder();

        int countErrorMessage =
                kotlinLanguagePage
                        .getListErrorMessages()
                        .size();

        Assert.assertTrue(countErrorMessage == 0, "The element Error message is on the page");
        Assert.assertEquals(actualOldBorder, expectedOldBorder);

        String actualErrorMessage =
                kotlinLanguagePage
                        .clickSubmitCommentButton()
                        .clickWriteComment()
                        .getErrorMessageText();

        String actualBorderOfRequiredFieldComment =
                kotlinLanguagePage
                        .getCommentBorder();

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
        Assert.assertEquals(actualBorderOfRequiredFieldComment, expectedBorderOfRequiredFieldComment);
    }

    @Test
    public void testErrorTextSecurityCodeAppearsWhenClickingButtonSubmitComment() {
        final String name = "test";
        final String email = "test";
        final String url = "test";
        final String captcha = "test";
        final String comment = "test";
        final String expectedOldBorder = "1px solid rgb(153, 153, 153)";
        final String expectedErrorMessage = "Error: Error: Invalid security code.";
        final String expectedBorderOfRequiredFieldComment = "1px solid rgb(255, 0, 0)";

        KotlinLanguagePage kotlinLanguagePage =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .clickKSubmenu()
                        .clickKotlinLanguage();

        String actualOldBorder =
                kotlinLanguagePage
                        .clickWriteComment()
                        .getSecurityCodeBorder();

        int countErrorMessage =
                kotlinLanguagePage
                        .getListErrorMessages()
                        .size();

        Assert.assertTrue(countErrorMessage == 0, "The element Error message is on the page");
        Assert.assertEquals(actualOldBorder, expectedOldBorder);

        kotlinLanguagePage.inputAddCommentfields(name, email, url, captcha, comment);

        String actualErrorMessage =
                kotlinLanguagePage
                        .clickSubmitCommentButton()
                        .clickWriteComment()
                        .getErrorMessageText();

        String actualBorderOfRequiredFieldComment =
                kotlinLanguagePage
                        .getSecurityCodeBorder();

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
        Assert.assertEquals(actualBorderOfRequiredFieldComment, expectedBorderOfRequiredFieldComment);
        Assert.assertNotEquals(actualOldBorder, actualBorderOfRequiredFieldComment);
    }
}
