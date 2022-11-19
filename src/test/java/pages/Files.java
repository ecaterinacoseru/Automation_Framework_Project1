package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import static utilities.BrowserUtils.waitForVisibility;

public class Files {

    public Files() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

//    @FindBy(xpath = "//*[@id='appmenu']/li[2]")
//    private WebElement filesMdl;

    @FindBy(xpath = "//label[@for='select_all_files']")
    private WebElement selectAllCheckBox;




    public void clickElement(WebElement element){
        waitForVisibility(element, 10);
        element.click();
    }
}
