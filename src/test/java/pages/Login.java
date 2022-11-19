package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

public class Login {

    public Login(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name="username")
    private WebElement inputUsername;

    @FindBy(name="password")
    private WebElement inputPassword;

    @FindBy(xpath="//button[@type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//p[@class='warning wrongPasswordMsg']")
    private  WebElement wrongPasswordMessage;

    /**
     * This method will accept username and password and login to app
     * @param username
     * @param password
     */
    public void login(String username,String password){
        inputUsername.sendKeys(username);
        inputPassword.sendKeys(password);
    }

    public void login(){
        login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
        BrowserUtils.clickElement(loginButton);
    }

    public void goLoginPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    public void loginBtnClick(){
        BrowserUtils.clickElement(loginButton);
    }
}
