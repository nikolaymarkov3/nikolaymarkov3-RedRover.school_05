package tests.browse_languages.languages;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.languages.EnglishLanguagePage;

public class EnglishLanguageTest extends BaseTest {

    @Test
    public void testEnglishLanguagePageHeader() {
        final String expectedH2Header = "Language English";

        String actualH2Header =
                openBaseURL()
                        .clickBrowseLanguagesFooterMenu()
                        .clickESubmenu()
                        .clickEnglishLanguage()
                        .getH2HeaderText();

        Assert.assertEquals(actualH2Header, expectedH2Header);
    }

    @Test
    public void testFormLink_NavigatesTo_SubmitNewLanguagePage() {
        final String expectedURL = "https://www.99-bottles-of-beer.net/submitnewlanguage.html";

        EnglishLanguagePage englishLanguagePage = openBaseURL()
                .clickBrowseLanguagesFooterMenu()
                .clickESubmenu()
                .clickEnglishLanguage();

        String oldURL2 = englishLanguagePage.clickWriteComment().getURL();

        englishLanguagePage.clickFormLink();

        String actualURL = englishLanguagePage.getURL();

        Assert.assertNotEquals(oldURL2, actualURL);
        Assert.assertEquals(actualURL, expectedURL);
    }
}
