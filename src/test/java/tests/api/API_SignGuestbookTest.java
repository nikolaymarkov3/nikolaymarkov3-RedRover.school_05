package tests.api;

import base.BaseTest;
import network.CaptureNetworkTraffic;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.guest_book.SignGuestbookPage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class API_SignGuestbookTest extends BaseTest {

    final static String ACTION = "signv2.html";
    final static String METHOD = "post";
    final static String NAME_INPUT_1 = "name";
    final static String NAME_INPUT_2 = "location";
    final static String NAME_INPUT_3 = "email";
    final static String NAME_INPUT_4 = "homepage";
    final static String NAME_INPUT_5 = "captcha";
    final static String NAME_TEXTAREA = "comment";
    final static String NAME_INPUT_6 = "submit";
    final static String VALUE_INPUT_1 = "Guest";
    final static String VALUE_INPUT_2 = "USA";
    final static String VALUE_INPUT_3 = "guest@gmail.com";
    final static String HTTP = "http://";
    final static String VALUE_INPUT_4 = "lagoldgymnastics.com";
    final static String TEXTAREA_TEXT = "Test message";
    final static String VALUE_INPUT_6 = "Submit";
    final static String PAYLOAD = NAME_INPUT_1 + "=" + VALUE_INPUT_1 + "&" + NAME_INPUT_2 + "=" + VALUE_INPUT_2 + "&"
            + NAME_INPUT_3 + "=" + URLEncoder.encode(VALUE_INPUT_3, StandardCharsets.UTF_8) + "&" + NAME_INPUT_4 + "="
            + URLEncoder.encode(HTTP, StandardCharsets.UTF_8) + URLEncoder.encode(VALUE_INPUT_4, StandardCharsets.UTF_8)
            + "&" + NAME_INPUT_5 + "=" + "&" + NAME_TEXTAREA + "=" + URLEncoder.encode(TEXTAREA_TEXT, StandardCharsets.UTF_8)
            + "&" + NAME_INPUT_6 + "=" + VALUE_INPUT_6;
    final static String PAGE_CONTEXT_BEFORE_REQUEST = "Sign Guestbook\n"
            + "Name:\n\n"
            + "Location: (optional)\n\n"
            + "E-Mail:\n\n"
            + "Homepage (optional):\n\n"
            + "Security Code:\n" + "  " + "\n"
            + "Message::";

    @Test(priority = -5)
    public void testAttribute_DefaultValues() {
        SignGuestbookPage signGuestbookPage =
                openBaseURL()
                        .clickGuestbookLink()
                        .clickSignGuestbookSubmenu();

        Assert.assertEquals(signGuestbookPage.getAction(), getBaseUrl() + ACTION);
        Assert.assertEquals(signGuestbookPage.getMethod(), METHOD);
        Assert.assertEquals(signGuestbookPage.getInput1Name(), NAME_INPUT_1);
        Assert.assertEquals(signGuestbookPage.getInput2Name(), NAME_INPUT_2);
        Assert.assertEquals(signGuestbookPage.getInput3Name(), NAME_INPUT_3);
        Assert.assertEquals(signGuestbookPage.getInput4Name(), NAME_INPUT_4);
        Assert.assertEquals(signGuestbookPage.getInput5Name(), NAME_INPUT_5);
        Assert.assertEquals(signGuestbookPage.getInput6Name(), NAME_INPUT_6);
        Assert.assertEquals(signGuestbookPage.getInput6Value(), VALUE_INPUT_6);
        Assert.assertEquals(signGuestbookPage.getPageContext(), PAGE_CONTEXT_BEFORE_REQUEST);
    }

    @Test(priority = -4)
    public void test_API_HttpRequest_GET() {
        final String expectedMethod = "GET";
        final String expectedEndPoint = ACTION;

        List<String> httpRequest = new CaptureNetworkTraffic()
                .setUpDevTool(getDriver())
                .captureHttpRequests(expectedEndPoint, expectedMethod);

        openBaseURL().clickGuestbookLink().clickSignGuestbookSubmenu();

        Assert.assertEquals(httpRequest.get(0), expectedMethod);
        Assert.assertEquals(httpRequest.get(1), getBaseUrl() + expectedEndPoint);
        Assert.assertEquals(httpRequest.get(2), "Optional.empty");
        Assert.assertEquals(httpRequest.get(3), "Optional.empty");
    }

    @Test(dependsOnMethods = "test_API_HttpRequest_GET")
    public void test_API_HttpResponse_GET() {
        final String expectedStatusCode = "200";
        final String expectedStatusText = "OK";
        final String expectedEndPoint = ACTION;
        final double expectedResponseTimeStandard = 3;

        List<String> httpResponse = new CaptureNetworkTraffic()
                .setUpDevTool(getDriver())
                .captureHttpResponses(expectedEndPoint);

        openBaseURL().clickGuestbookLink().clickSignGuestbookSubmenu();

        Assert.assertEquals(httpResponse.get(0), expectedStatusCode);
        Assert.assertEquals(httpResponse.get(1), expectedStatusText);
        Assert.assertEquals(httpResponse.get(2), getBaseUrl() + expectedEndPoint);
        Assert.assertTrue(
                Double.parseDouble(httpResponse.get(3).substring(10, 14)) <= expectedResponseTimeStandard);
    }

    @Test(priority = -3)
    public void test_API_HttpRequest_POST() {

        List<String> httpRequest = new CaptureNetworkTraffic()
                .setUpDevTool(getDriver())
                .captureHttpRequests(ACTION, METHOD.toUpperCase());

        openBaseURL()
                .clickGuestbookLink()
                .clickSignGuestbookSubmenu()
                .inputSingGuestbookName(VALUE_INPUT_1)
                .inputSingGuestbookLocation(VALUE_INPUT_2)
                .inputSingGuestbookEmail(VALUE_INPUT_3)
                .inputSingGuestbookHomepage(VALUE_INPUT_4)
                .inputSingGuestbookMessage(TEXTAREA_TEXT)
                .clickSubmitButton();

        Assert.assertEquals(httpRequest.get(0).toLowerCase(), METHOD);
        Assert.assertEquals(httpRequest.get(1), getBaseUrl() + ACTION);
        Assert.assertEquals(httpRequest.get(2), "Optional[" + PAYLOAD + "]");
        Assert.assertEquals(httpRequest.get(3), "Optional.empty");
    }

    @Test(dependsOnMethods = "test_API_HttpRequest_POST")
    public void test_API_HttpResponse_POST() {
        final String expectedStatusCode = "200";
        final String expectedStatusText = "OK";
        final String expectedEndPoint = ACTION;
        final double expectedResponseTimeStandard = 3;

        List<String> httpResponse = new CaptureNetworkTraffic()
                .setUpDevTool(getDriver())
                .captureHttpResponses(expectedEndPoint);

        SignGuestbookPage signGuestbookPage =
                openBaseURL()
                        .clickGuestbookLink()
                        .clickSignGuestbookSubmenu()
                        .inputSingGuestbookName(VALUE_INPUT_1)
                        .inputSingGuestbookLocation(VALUE_INPUT_2)
                        .inputSingGuestbookEmail(VALUE_INPUT_3)
                        .inputSingGuestbookHomepage(VALUE_INPUT_4)
                        .inputSingGuestbookMessage(TEXTAREA_TEXT)
                        .clickSubmitButton();

        Assert.assertEquals(httpResponse.get(0), expectedStatusCode);
        Assert.assertEquals(httpResponse.get(1), expectedStatusText);
        Assert.assertEquals(httpResponse.get(2), getBaseUrl() + expectedEndPoint);
        Assert.assertTrue(
                Double.parseDouble(httpResponse.get(3).substring(10, 14)) <= expectedResponseTimeStandard);
        Assert.assertNotEquals(signGuestbookPage.getPageContext(), PAGE_CONTEXT_BEFORE_REQUEST);
    }

    @Test
    public void test_API_AllSignGuestbookImagesAreNotBroken() {
        String imageURL = "";
        int responseCode;
        int actualWorkingImagesCount = 0;
        SignGuestbookPage signGuestbookPage = new SignGuestbookPage(getDriver());

        List<WebElement> imgTags =
                openBaseURL()
                        .clickGuestbookLink()
                        .clickSignGuestbookSubmenu()
                        .getImages();

        final int expectedWorkingImagesCount = imgTags.size();

        for (WebElement image : imgTags) {
            imageURL = image.getAttribute("src");

            if (imageURL != null && !imageURL.isBlank() && !imageURL.isEmpty()) {
                try {
                    HttpURLConnection connection = (HttpURLConnection) (new URL(imageURL).openConnection());
                    connection.connect();

                    responseCode = connection.getResponseCode();

                    if (responseCode < 400 && signGuestbookPage.isImageDisplayed(image)) {
                        actualWorkingImagesCount++;
                    } else {
                        Reporter.log(imageURL + " is broken, responseCode " + responseCode + " OR image not displayed ", true);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        Assert.assertEquals(actualWorkingImagesCount, expectedWorkingImagesCount);
    }
}

