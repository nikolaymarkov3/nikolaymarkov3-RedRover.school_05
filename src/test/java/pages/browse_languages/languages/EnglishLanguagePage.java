package pages.browse_languages.languages;

import org.openqa.selenium.WebDriver;

public class EnglishLanguagePage extends LanguagePage<EnglishLanguagePage> {

    public EnglishLanguagePage(WebDriver driver) {
        super(driver);
    }

    protected EnglishLanguagePage createLanguagePage() {

        return new EnglishLanguagePage(getDriver());
    }
}
