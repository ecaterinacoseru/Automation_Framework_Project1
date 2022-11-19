package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class Dashboard {

    public Dashboard(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindAll(@FindBy(xpath = "//ul[@id='appmenu']"))
    private List<WebElement> menuList;

    public void moduleClicker(String moduleName) {
        for (WebElement eachMenu : menuList) {
            if (eachMenu.getAttribute("aria-label").strip().equalsIgnoreCase(moduleName)) {
                eachMenu.click();
                break;
            }
        }
    }
}
