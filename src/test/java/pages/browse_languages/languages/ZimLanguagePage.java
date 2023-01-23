package pages.browse_languages.languages;

import org.openqa.selenium.WebDriver;

public class ZimLanguagePage extends LanguagePage<ZimLanguagePage> {

    public ZimLanguagePage(WebDriver driver) {
        super(driver);
    }

    protected ZimLanguagePage createLanguagePage() {

        return new ZimLanguagePage(getDriver());
    }
}
