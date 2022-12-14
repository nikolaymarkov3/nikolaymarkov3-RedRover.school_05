package tests.guest_book;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.guest_book.ReadGuestbookPage;

public class GuestBookV2Test extends BaseTest {
    final static String URL_KEY_VALUE = "guest";

    @Test
    public void testMainNavigationToButtonGuestbook() {
        String expectedResultGuestbookUrl = "https://www.99-bottles-of-beer.net/guestbookv2.html";

        ReadGuestbookPage ReadGuestBookPage = new ReadGuestbookPage(getDriver());

        String actualResultGuestbookUrl = openBaseURL()
                .clickGuestbookMenu()
                .getDriver().getCurrentUrl();

        Assert.assertEquals(actualResultGuestbookUrl, expectedResultGuestbookUrl);
    }

    @Test
    public void test_MainFooterGuestBookv2_AramH20() {
        String guestBoopPageURL = openBaseURL().clickGuestbookMenu().getURL();
        Assert.assertTrue(guestBoopPageURL.contains(URL_KEY_VALUE));
    }
}