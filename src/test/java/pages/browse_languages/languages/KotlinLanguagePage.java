package pages.browse_languages.languages;

import org.openqa.selenium.WebDriver;

public class KotlinLanguagePage extends LanguagePage<KotlinLanguagePage> {

    public KotlinLanguagePage(WebDriver driver) {
        super(driver);
    }

    protected KotlinLanguagePage createLanguagePage() {

        return new KotlinLanguagePage(getDriver());
    }
}
