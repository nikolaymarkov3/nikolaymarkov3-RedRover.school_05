package pages.browse_languages.languages;

import org.openqa.selenium.WebDriver;

public class MagnumLanguagePage extends LanguagePage<MagnumLanguagePage> {

    public MagnumLanguagePage(WebDriver driver) {
        super(driver);
    }

    protected MagnumLanguagePage createLanguagePage() {

        return new MagnumLanguagePage(getDriver());
    }
}
