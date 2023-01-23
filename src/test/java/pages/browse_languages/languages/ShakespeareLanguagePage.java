package pages.browse_languages.languages;

import org.openqa.selenium.WebDriver;

public class ShakespeareLanguagePage extends LanguagePage<ShakespeareLanguagePage> {

    public ShakespeareLanguagePage(WebDriver driver) {
        super(driver);
    }

    protected ShakespeareLanguagePage createLanguagePage() {

        return new ShakespeareLanguagePage(getDriver());
    }
}
