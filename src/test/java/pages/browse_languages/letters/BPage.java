package pages.browse_languages.letters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.browse_languages.languages.BashLanguagePage;

public class BPage extends LetterPage {

    @FindBy(xpath = "//a[@href ='language-bash-98.html']")
    private WebElement bashLanguageLink;

    public BPage(WebDriver driver) {
        super(driver);
    }

    public BashLanguagePage clickBashLanguageLink() {
        click(bashLanguageLink);

        return new BashLanguagePage(getDriver());
    }
}
