package pages.browse_languages.languages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.browse_languages.BrowseLanguagesSubmenuPage;

import java.util.List;

public abstract class LanguagePage extends BrowseLanguagesSubmenuPage {

    final static String VOTING_PATH = "//div[@id='voting']";
    final static String ADD_COMMENTS_PATH = "//div[@id='addcomments']";

    @FindBy(xpath = VOTING_PATH + "/p[2]/a")
    private List<WebElement> externalLinks;

    @FindBy(xpath = VOTING_PATH + "/h2")
    private List<WebElement> votingHeader;

    @FindBy(xpath = VOTING_PATH + "//a[@title='reddit' and @href]")
    private WebElement redditLink;

    @FindBy(xpath = VOTING_PATH + "//input[@name = 'submitcomment']")
    private WebElement voteButton;

    @FindBy(xpath = VOTING_PATH + "//form")
    private WebElement votingForm;

    @FindBy(xpath = VOTING_PATH + "//form//input[1]")
    private WebElement input1Voting;

    @FindBy(xpath = VOTING_PATH + "//form//input[2]")
    private WebElement input2Voting;

    @FindBy(xpath = VOTING_PATH + "//form//select")
    private WebElement select3Voting;

    @FindBy(xpath = VOTING_PATH + "//form//input[3]")
    private WebElement input4Voting;

    @FindBy(xpath = VOTING_PATH + "//option[5]")
    private WebElement niceCodingRate;

    @FindBy(xpath = "//a[contains(@href,'/download/')]")
    private List<WebElement> downloadSourceLinks;

    @FindBy(xpath = "//a[@href='#addcomment']")
    private List<WebElement> writeCommentLinks;

    @FindBy(xpath = "//div[@id='alternatives']/h2")
    private WebElement alternativeVersionsHeader;

    @FindBy(xpath = "//div[@id='comments']/h2")
    private WebElement commentsHeader;

    @FindBy(xpath = ADD_COMMENTS_PATH + "//a[@href='/submitnewlanguage.html']")
    private WebElement formLink;

    @FindBy(xpath = ADD_COMMENTS_PATH + "/h2")
    private WebElement h2HeaderAddComment;

    @FindBy(xpath = ADD_COMMENTS_PATH + "/p")
    private WebElement infoTextAddComment;

    @FindBy(xpath = ADD_COMMENTS_PATH + "/form/p/strong")
    private List<WebElement> fieldsToFillAddComment;

    public LanguagePage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getExternalLinks() {

        return getListIfVisible(externalLinks);
    }

    public String getVotingFieldText() {

        return getText(niceCodingRate);
    }

    public String getAlternativeVersionsHeader() {

        return getText(alternativeVersionsHeader);
    }

    public String getCommentsHeader() {

        return getText(commentsHeader);
    }

    public List<String> getVotingHeader() {

        return getListText(votingHeader);
    }

    public List<String> getDownloadSourceLinks() {

        return getListText(downloadSourceLinks);
    }

    public List<String> getWriteCommentLinksTexts() {

        return getListText(writeCommentLinks);
    }

    public String getH2HeaderAddCommentText() {

        return getText(h2HeaderAddComment);
    }

    public String getInfoAddCommentText() {

        return getText(infoTextAddComment);
    }

    public List<String> getFieldsToFillAddComment() {

        return getListText(fieldsToFillAddComment);
    }

    public List<WebElement> getWriteCommentLinks() {

        return writeCommentLinks;
    }

    public String getAction() {

        return getAttribute(votingForm, "action");
    }

    public String getMethod() {

        return getAttribute(votingForm, "method");
    }

    public String getInput1Value() {

        return getAttribute(input1Voting, "value");
    }

    public String getInput2Value() {

        return getAttribute(input2Voting, "value");
    }

    public String getSelect3Value() {

        return getAttribute(select3Voting, "value");
    }

    public String getInput4Value() {

        return getAttribute(input4Voting, "value");
    }

    public String getInput1Name() {

        return getAttribute(input1Voting, "name");
    }

    public String getInput2Name() {

        return getAttribute(input2Voting, "name");
    }

    public String getSelect3Name() {

        return getAttribute(select3Voting, "name");
    }

    public String getInput4Name() {

        return getAttribute(input4Voting, "name");
    }

    public void clickRedditLink() {
        click(redditLink);
    }

    public void clickVoteButton() {
        click(voteButton);
    }

    public void clickNiceCodingOption() {
        click(niceCodingRate);
    }

    public void clickWriteComment() {
        click(getWriteCommentLinks().get(0));
    }

    public void clickFormLink() {
        click(formLink);
    }
}
