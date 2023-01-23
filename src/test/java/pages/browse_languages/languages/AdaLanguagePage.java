package pages.browse_languages.languages;

import org.openqa.selenium.WebDriver;

public class AdaLanguagePage extends LanguagePage<AdaLanguagePage> {

    public AdaLanguagePage(WebDriver driver) {
        super(driver);
    }

    protected AdaLanguagePage createLanguagePage() {

        return new AdaLanguagePage(getDriver());
    }
}
