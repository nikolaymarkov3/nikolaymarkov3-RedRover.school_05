package pages.browse_languages.languages;

import org.openqa.selenium.WebDriver;

public class KalkulonLanguagePage extends LanguagePage<KalkulonLanguagePage> {

    public KalkulonLanguagePage(WebDriver driver) {
        super(driver);
    }

    protected KalkulonLanguagePage createLanguagePage() {

        return new KalkulonLanguagePage(getDriver());
    }
}
