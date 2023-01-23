package pages.browse_languages.languages;

import org.openqa.selenium.WebDriver;

public class ScalaLanguagePage extends LanguagePage<ScalaLanguagePage> {

    public ScalaLanguagePage(WebDriver driver) {
        super(driver);
    }

    protected ScalaLanguagePage createLanguagePage() {

        return new ScalaLanguagePage(getDriver());
    }
}
