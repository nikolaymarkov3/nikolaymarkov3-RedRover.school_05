package tests.browse_languages.languages;

import TestData.TestData;
import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.languages.BashLanguagePage;

import java.util.List;

public class BashLanguageTest extends BaseTest {

    @Test(priority = 0)
    public void testBashLanguagePageHeader() {
        final String expectedH2Header = "Language BASH";

        String actualH2Header =
                openBaseURL()
                        .clickBrowseLanguagesFooterMenu()
                        .clickBSubmenu()
                        .clickBashLanguage()
                        .getH2HeaderText();

        Assert.assertEquals(actualH2Header, expectedH2Header);
    }

    @Test(priority = 4)
    public void testFrLangFreeFrCoursLink_NavigatesTo_ExternalBashLanguagePage() {
        final String expectedExternalURL = "http://fr.lang.free.fr/cours/";
        final String expectedExternalTitle = "Frédéric Lang - Site Personnel";

        String oldBashLanguagePageURL =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .clickBSubmenu()
                        .clickBashLanguage()
                        .getURL();

        BashLanguagePage bashLanguagePage = new BashLanguagePage(getDriver());

        bashLanguagePage.clickBashLanguageInfoLink();

        Assert.assertNotEquals(oldBashLanguagePageURL, getExternalPageURL());
        Assert.assertEquals(getExternalPageURL(), expectedExternalURL);
        Assert.assertEquals(getExternalPageTitle(), expectedExternalTitle);
    }

    @Test(priority = 3)
    public void testBookmarkActive() {
        final int expectedActiveBookmark = 14;

        int activeBookmark =
                openBaseURL()
                        .clickBrowseLanguagesFooterMenu()
                        .clickBSubmenu()
                        .clickBashLanguage()
                        .getExternalLinks()
                        .size();

        Assert.assertEquals(activeBookmark, expectedActiveBookmark);
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "externalBookmarking")
    public void testBookmarkingTitle(
            int index, String title, String href) {

        BashLanguagePage bashLanguagePage = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickBSubmenu()
                .clickBashLanguage();

        List<WebElement> bookmarkList = bashLanguagePage.getExternalLinks();

        String oldTitle = bashLanguagePage.getTitle();
        String actualTitle = bashLanguagePage.clickMenu(index, bookmarkList).getTitle();

        Assert.assertNotEquals(actualTitle, oldTitle);
        Assert.assertEquals(actualTitle, title);
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "externalBookmarking")
    public void testBookmarkingUrl(
            int index, String title, String href) {

        BashLanguagePage bashLanguagePage = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickBSubmenu()
                .clickBashLanguage();

        List<WebElement> bookmarkList = bashLanguagePage.getExternalLinks();

        String oldURL = bashLanguagePage.getURL();
        String actualBookmarkUrl = bashLanguagePage.clickMenu(index, bookmarkList).getURL();

        Assert.assertNotEquals(actualBookmarkUrl, oldURL);
        Assert.assertTrue(actualBookmarkUrl.contains(href));
    }
}