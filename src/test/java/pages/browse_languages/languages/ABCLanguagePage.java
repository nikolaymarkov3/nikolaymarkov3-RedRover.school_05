package pages.browse_languages.languages;

import org.openqa.selenium.WebDriver;

public class ABCLanguagePage extends LanguagePage<ABCLanguagePage> {

    public ABCLanguagePage(WebDriver driver) {
        super(driver);
    }

    protected ABCLanguagePage createLanguagePage() {

        return new ABCLanguagePage(getDriver());
    }
}

