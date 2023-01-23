package pages.browse_languages.languages;

import org.openqa.selenium.WebDriver;

public class YacasLanguagePage extends LanguagePage<YacasLanguagePage> {

    public YacasLanguagePage(WebDriver driver) {
        super(driver);
    }

    protected YacasLanguagePage createLanguagePage() {

        return new YacasLanguagePage(getDriver());
    }
}
