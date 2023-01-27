package tests.api;

import base.BaseTest;
import network.CaptureNetworkTraffic;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.languages.ABCLanguagePage;

import java.util.List;

public class API_ABCLanguageTest extends BaseTest {
    final static String LANGUAGE_NAME = "Language ABC";
    final static String ABC_END_POINT = "language-abc-13.html";

    @Test
    public void testAttributes_DefaultValuesABC() {
        ABCLanguagePage abcLanguagePage =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .clickASubmenu()
                        .clickABCLanguage();

        Assert.assertEquals(abcLanguagePage.getURL(), getBaseUrl() + ABC_END_POINT);
        Assert.assertEquals(abcLanguagePage.getH2HeaderText(), LANGUAGE_NAME);
        Assert.assertNotNull(abcLanguagePage.getPageContext());
    }

    @Test
    public void test_API_HTTPRequest_GET_WhenClickABCLanguage() {
        final String expectedMethod = "GET";
        final String expectedEndPoint = "language-abc-13.html";

        List<String> httpRequest = new CaptureNetworkTraffic()
                .setUpDevTool(getDriver())
                .captureHttpRequests(expectedEndPoint, expectedMethod);

        openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickASubmenu()
                .clickABCLanguage();

        Assert.assertEquals(httpRequest.get(0), expectedMethod);
        Assert.assertEquals(httpRequest.get(1), getBaseUrl() + expectedEndPoint);
        Assert.assertEquals(httpRequest.get(2), "Optional.empty");
        Assert.assertEquals(httpRequest.get(3), "Optional.empty");
    }

    @Test(dependsOnMethods = "test_API_HTTPRequest_GET_WhenClickABCLanguage")
    public void test_API_ABCHttpResponse_GET_WhenClickABCLanguage() {
        final String expectedStatusCode = "200";
        final String expectedStatusText = "OK";
        final String expectedEndPoint = "language-abc-13.html";
        final double expectedResponseTimeStandard = 3;

        List<String> httpResponse = new CaptureNetworkTraffic()
                .setUpDevTool(getDriver())
                .captureHttpResponses(expectedEndPoint);

        openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickASubmenu()
                .clickABCLanguage();

        Assert.assertEquals(httpResponse.get(0), expectedStatusCode);
        Assert.assertEquals(httpResponse.get(1), expectedStatusText);
        Assert.assertEquals(httpResponse.get(2), getBaseUrl() + expectedEndPoint);
        Assert.assertTrue(Double.parseDouble(httpResponse.get(3).substring(10, 14)) <= expectedResponseTimeStandard);
    }
}