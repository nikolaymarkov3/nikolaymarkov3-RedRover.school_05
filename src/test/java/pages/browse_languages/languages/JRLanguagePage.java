package pages.browse_languages.languages;

import org.openqa.selenium.WebDriver;

public class JRLanguagePage extends LanguagePage<JRLanguagePage> {

    public JRLanguagePage(WebDriver driver) {
        super(driver);
    }

    protected JRLanguagePage createLanguagePage() {

        return new JRLanguagePage(getDriver());
    }
}
