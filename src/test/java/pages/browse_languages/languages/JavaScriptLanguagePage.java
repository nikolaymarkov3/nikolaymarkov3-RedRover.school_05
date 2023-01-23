package pages.browse_languages.languages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JavaScriptLanguagePage extends LanguagePage<JavaScriptLanguagePage> {

    @FindBy(xpath = "//div[@id='main']//a[contains(text(), 'http://en.wikipedia.org/wiki/Javascript')]")
    private WebElement javaScriptLanguageInfoLink;

    public JavaScriptLanguagePage(WebDriver driver) {
        super(driver);
    }

    public void clickJavaScriptLanguageInfoLink() {
        click(javaScriptLanguageInfoLink);
    }

    protected JavaScriptLanguagePage createLanguagePage() {

        return new JavaScriptLanguagePage(getDriver());
    }
}
