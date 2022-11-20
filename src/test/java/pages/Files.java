package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtils;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

import static utilities.BrowserUtils.waitForVisibility;

public class Files {

    public Files() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

//    @FindBy(xpath = "//*[@id='appmenu']/li[2]")
//    private WebElement filesMdl;

    @FindBy(xpath = "//label[@for='select_all_files']")
    private WebElement selectAllCheckBox;

    @FindAll(@FindBy(xpath = "//tbody[@id='fileList']/tr"))
    private List<WebElement> checkBoxesList;

    @FindAll(@FindBy(xpath = "//a[@data-action='menu']"))
    private List<WebElement> actionBtnMenu;

    @FindBy(xpath = "//a[@data-action='Favorite']")
    private WebElement addToFavoritesBtn;

    @FindBy(xpath = "//a[@class='nav-icon-favorites svg']")
    private WebElement favoritesSubModule;

    @FindAll(@FindBy(xpath = "//tbody[@id='fileList']/tr"))
    private List<WebElement> folderNames;

    public void setSelectAllCheckBox() {
        selectAllCheckBox.click();
    }

    public void verifySelectAllBox() {

        for (WebElement checkBox : checkBoxesList) {
            Assert.assertTrue(checkBox.getAttribute("class").endsWith("selected"));
        }
    }

    public void clickElement(WebElement element){
        waitForVisibility(element, 10);
        element.click();
    }

    public void clickActionBtns(){
        for( WebElement actionBtn : actionBtnMenu){
            actionBtn.click();
            break;
        }
    }

    List<String> clickedFiles = new ArrayList<>();
    public void addToFavorites(){

        for(int i = 0; i < folderNames.size(); i++){
            clickedFiles.add(folderNames.get(i).getText());
            BrowserUtils.waitForClickability(actionBtnMenu.get(i), 15);
            actionBtnMenu.get(i).click();
            BrowserUtils.waitForClickability(addToFavoritesBtn, 15);
        }
    }

}
