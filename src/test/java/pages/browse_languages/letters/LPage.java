package pages.browse_languages.letters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.browse_languages.languages.LuaLanguagePage;

public class LPage extends LetterPage {

    @FindBy(xpath = "//a[@href and text()= 'LUA']")
    private WebElement luaLink;

    public LPage(WebDriver driver) {
        super(driver);
    }

    public String getLPageURL() {

        return getURL();
    }

    public LuaLanguagePage clickLuaLink() {
        click(luaLink);

        return new LuaLanguagePage(getDriver());
    }
}
