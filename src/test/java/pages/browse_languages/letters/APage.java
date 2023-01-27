package pages.browse_languages.letters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.browse_languages.languages.ABCLanguagePage;
import pages.browse_languages.languages.AdaLanguagePage;

public class APage extends LetterPage {

    @FindBy(xpath = "//a[@href='language-ada-19.html']")
    private WebElement adaLanguage;

    @FindBy(xpath = "//a[@href='language-abc-13.html']")
    private WebElement abcLanguage;

    public APage(WebDriver driver) {
        super(driver);
    }

    public AdaLanguagePage clickAdaLanguage() {
        click(adaLanguage);

        return new AdaLanguagePage(getDriver());
    }

    public ABCLanguagePage clickABCLanguage() {
        click(abcLanguage);

        return new ABCLanguagePage(getDriver());
    }
}