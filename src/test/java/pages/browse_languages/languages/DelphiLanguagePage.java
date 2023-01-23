package pages.browse_languages.languages;

import org.openqa.selenium.WebDriver;

public class DelphiLanguagePage extends LanguagePage<DelphiLanguagePage> {

    public DelphiLanguagePage(WebDriver driver) {
        super(driver);
    }

    protected DelphiLanguagePage createLanguagePage() {

        return new DelphiLanguagePage(getDriver());
    }
}
