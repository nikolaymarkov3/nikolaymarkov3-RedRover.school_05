package pages.browse_languages.languages;

import org.openqa.selenium.WebDriver;

public class JavaLanguagePage extends LanguagePage<JavaLanguagePage> {

    public JavaLanguagePage(WebDriver driver) {
        super(driver);
    }

    protected JavaLanguagePage createLanguagePage() {

        return new JavaLanguagePage(getDriver());
    }
}
