package pages.browse_languages.languages;

import org.openqa.selenium.WebDriver;

public class GapLanguagePage extends LanguagePage<GapLanguagePage> {

    public GapLanguagePage(WebDriver driver) {
        super(driver);
    }

    protected GapLanguagePage createLanguagePage() {

        return new GapLanguagePage(getDriver());
    }
}
