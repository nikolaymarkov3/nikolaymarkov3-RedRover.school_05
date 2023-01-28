package tests.api;

import base.BaseTest;
import network.CaptureNetworkTraffic;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.languages.KalkulonLanguagePage;

import java.util.List;

public class API_KalkulonLanguageTest extends BaseTest {

    final static String LANGUEGE_NAME = "Language Kalkulon";
    final static String KALKULON_END_POINT = "language-kalkulon-740.html";

    @Test
    public void testAttributes_DefaultValues() {

        KalkulonLanguagePage kalkulonLanguagePage =
                openBaseURL()
                        .clickBrowseLanguagesMenu()
                        .clickKSubmenu()
                        .clickKalkulonLanguage();

        Assert.assertEquals(kalkulonLanguagePage.getURL(), getBaseUrl() + KALKULON_END_POINT);
        Assert.assertEquals(kalkulonLanguagePage.getH2HeaderText(), LANGUEGE_NAME);
        Assert.assertNotNull(kalkulonLanguagePage.getPageContext());
    }

    @Test
    public void testAPI_HttpRequest_GET(){

        final String expectedMethod = "GET";

        List<String> httpRequest = new CaptureNetworkTraffic()
                .setUpDevTool(getDriver())
                .captureHttpRequests(KALKULON_END_POINT, "GET");

        openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickKSubmenu()
                .clickKalkulonLanguage();

        Assert.assertEquals(httpRequest.get(0), expectedMethod);
        Assert.assertEquals(httpRequest.get(1), getBaseUrl() + KALKULON_END_POINT);
        Assert.assertEquals(httpRequest.get(2), "Optional.empty");
        Assert.assertEquals(httpRequest.get(3), "Optional.empty");
    }

    @Test(dependsOnMethods = "testAPI_HttpRequest_GET")
    public void testAPI_HttpResponse_GET() {
        final String expectedStatusCode = "200";
        final String expectedStatusText = "OK";
        final double expectedResponseTimeStandard = 3;

        List<String> httpResponse = new CaptureNetworkTraffic()
                .setUpDevTool(getDriver())
                .captureHttpResponses(KALKULON_END_POINT);

        openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickKSubmenu()
                .clickKalkulonLanguage();

        Assert.assertEquals(httpResponse.get(0), expectedStatusCode);
        Assert.assertEquals(httpResponse.get(1), expectedStatusText);
        Assert.assertEquals(httpResponse.get(2), getBaseUrl() + KALKULON_END_POINT);
        Assert.assertTrue(Double.parseDouble(
                httpResponse.get(3).substring(10, 14)) <= expectedResponseTimeStandard);
    }
}
