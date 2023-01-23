package pages.browse_languages.languages;

import org.openqa.selenium.WebDriver;

public class YabasicLanguagePage extends LanguagePage<YabasicLanguagePage> {

    public YabasicLanguagePage(WebDriver driver) {
        super(driver);
    }

    protected YabasicLanguagePage createLanguagePage() {

        return new YabasicLanguagePage(getDriver());
    }
}
