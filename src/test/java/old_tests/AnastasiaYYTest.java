package old_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnastasiaYYTest extends BaseTest {

    final static String BASE_URL = "https://www.99-bottles-of-beer.net/";
    final static By SEARCH_LANGUAGES_MENU = By.xpath("//ul[@id = 'menu']/li/a[@href = '/search.html']");
    final static By SEARCH_FOR_FIELD = By.name("search");
    final static By GO_BUTTON = By.name("submitsearch");
    final static By LANGUAGES_NAMES_LIST = By.xpath("//table[@id = 'category']/tbody/tr/td[1]/a");
    final static By H3_HEADER_NAMES = By.xpath("//div[@id='main']/h3");
    final static By START_MENU = By.xpath("//ul[@id = 'menu']//a[text() = 'Start']");
    final static By TOPLISTS_MENU = By.xpath("//ul[@id = 'menu']//a[text() = 'Top Lists']");
    final static By TEAM_SUBMENU = By.cssSelector("#submenu a[href = 'team.html']");
    final static By H2_HEADER_TOP_LISTS = By.xpath("//div[@id = 'main']/h2");
    final static By BROWSE_LANGUAGES_MENU = By.xpath("//ul[@id = 'menu']//a[text() = 'Browse Languages']");
    final static By Y_SUBMENU = By.xpath("//ul[@id = 'submenu']//a[text() = 'Y']");
    final static By Y_LANGUAGES_LIST = By.xpath("//table[@id = 'category']//a[starts-with(text(), 'Y')]");
    final static String LETTER_Y = "y";

    private void openBaseURL(WebDriver driver) {
        driver.get(BASE_URL);
    }

    private WebElement getElement(By by, WebDriver driver) {

        return driver.findElement(by);
    }

    private List<WebElement> getListOfElements(By by, WebDriver driver) {

        return driver.findElements(by);
    }

    private void click(By by, WebDriver driver) {
        getElement(by, driver).click();
    }

    private void input(String text, By by, WebDriver driver) {
        getElement(by, driver).sendKeys(text);
    }

    private String getText(By by, WebDriver driver) {

        return getElement(by, driver).getText();
    }

    private int getListSize(By by, WebDriver driver) {

        return getListOfElements(by, driver).size();
    }

    private int getListSize(List<String> list) {

        return list.size();
    }

    private List<String> getElementsTextLowerCase(By by, WebDriver driver) {
        List<WebElement> elementsList = getListOfElements(by, driver);
        List<String> textList = new ArrayList<>();
        for (WebElement element: elementsList) {
            textList.add(element.getText().toLowerCase());
        }

        return textList;
    }

    private List<String> getElementsText(By by, WebDriver driver) {
        List<WebElement> elementsList = getListOfElements(by, driver);
        List<String> textList = new ArrayList<>();
        for (WebElement element: elementsList) {
            textList.add(element.getText());
        }

        return textList;
    }

    @Test
    public void testSearchForLanguageByName_HappyPath() {

        final String LANGUAGE_NAME = "python";

        openBaseURL(getDriver());
        click(SEARCH_LANGUAGES_MENU, getDriver());
        click(SEARCH_FOR_FIELD, getDriver());
        input(LANGUAGE_NAME, SEARCH_FOR_FIELD, getDriver());
        click(GO_BUTTON, getDriver());

        List<String> languageNames = getElementsTextLowerCase(LANGUAGES_NAMES_LIST, getDriver());

        Assert.assertTrue(languageNames.size() > 0);

        for (String languageName: languageNames) {
            Assert.assertTrue(languageName.contains(LANGUAGE_NAME));
        }
    }

    @Test
    public void testVerifyTextInHeaderH3() {
        List<String> expectedH3headerNames = new ArrayList<>(
                Arrays.asList("Oliver Schade", "Gregor Scheithauer", "Stefan Scheler"));

        openBaseURL(getDriver());
        click(START_MENU, getDriver());
        click(TEAM_SUBMENU, getDriver());

        List<String> actualH3headerNames = getElementsText(H3_HEADER_NAMES, getDriver());

        Assert.assertEquals(actualH3headerNames, expectedH3headerNames);
    }

    @Test
    public void testVerifyH2HeaderText_TopListsMainPage()  {

        final String expectedResult = "Top Rated";

        openBaseURL(getDriver());
        click(TOPLISTS_MENU, getDriver());

        String actualResult = getText(H2_HEADER_TOP_LISTS, getDriver());

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testAllLanguagesOnYPageStartWithLetterY()  {

        openBaseURL(getDriver());
        click(BROWSE_LANGUAGES_MENU, getDriver());
        click(Y_SUBMENU, getDriver());

        List<String> letterYLanguages = getElementsTextLowerCase(Y_LANGUAGES_LIST, getDriver());

        Assert.assertTrue(letterYLanguages.size() > 0);

        for (String languageName: letterYLanguages) {
            Assert.assertTrue(languageName.contains(LETTER_Y));
        }
    }

   @Test
    public void testVerifyNumberOfLanguagesOnPageY()  {
        final int expectedResult = 9;
        int count = 0;

        openBaseURL(getDriver());
        click(BROWSE_LANGUAGES_MENU, getDriver());
        click(Y_SUBMENU, getDriver());

        List<String> letterYLanguages = getElementsTextLowerCase(Y_LANGUAGES_LIST, getDriver());

        for (String languageName: letterYLanguages) {
            if (letterYLanguages.size() > 0 && languageName.contains(LETTER_Y)) {
                count++;
            }
        }

        int actualResult = count;

        Assert.assertEquals(actualResult, expectedResult);
    }
}