package tests.browse_languages.languages;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.languages.KotlinLanguagePage;
import pages.submit_new_language.SubmitNewLanguagePage;

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

        Assert.assertTrue(actualOldH2HeaderAddComment.isEmpty(), "Add comment is not visible");

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

        SubmitNewLanguagePage submitNewLanguagePage = new SubmitNewLanguagePage(getDriver());

        openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickKSubmenu()
                .clickKotlinLanguage()
                .clickWriteComment();

        KotlinLanguagePage kotlinLanguagePage = new KotlinLanguagePage(getDriver());

        String oldURL = kotlinLanguagePage.getURL();

        kotlinLanguagePage.clickFormLink();

        Assert.assertNotEquals(oldURL, getDriver().getCurrentUrl());

        String actualURL = submitNewLanguagePage.getURL();
        String actualTitle = submitNewLanguagePage.getTitle();

        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
