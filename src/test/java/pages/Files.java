package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

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
}
