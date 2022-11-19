package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class Dashboard {

    public Dashboard(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindAll(@FindBy(css = "#appmenu  a"))
    private List<WebElement> menuList;

    public void moduleClicker(String moduleName) {
        for (WebElement eachMenu : menuList) {
            if (eachMenu.getAttribute("aria-label").strip().equalsIgnoreCase(moduleName)) {
                eachMenu.click();
                break;
            }
        }
    }

    public List<String> actualMenuList() {
        List<String> actualMenu = new ArrayList<>();
        for (WebElement eachMenu : menuList) {
            if (!eachMenu.getAttribute("aria-label").strip().isBlank()) {
                actualMenu.add(eachMenu.getAttribute("aria-label").strip());
            }
        }
        return actualMenu;
    }
}
