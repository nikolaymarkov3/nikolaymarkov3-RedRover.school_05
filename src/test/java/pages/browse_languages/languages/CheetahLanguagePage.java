package pages.browse_languages.languages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheetahLanguagePage extends LanguagePage<CheetahLanguagePage> {

    @FindBy(xpath = "//a[@href='http://cheetahtemplate.org/']")
    private WebElement cheetahLanguageInfoLink;

    public CheetahLanguagePage(WebDriver driver) {
        super(driver);
    }

    public void clickCheetahLanguageInfoLink() {
        click(cheetahLanguageInfoLink);
    }

    protected CheetahLanguagePage createLanguagePage() {

        return new CheetahLanguagePage(getDriver());
    }
}
