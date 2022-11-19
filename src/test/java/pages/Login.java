package pages;

import org.junit.Assert;
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

    @FindBy(xpath = "//input[@id='user']")
    private WebElement inputUsername;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement inputPassword;

    @FindBy(xpath="//input[@id='submit-form']")
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
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    }

    public void loginBtnClick(){
        loginButton.click();
    }

    public void errorMessageVerification(String expectedErrorMessage) {
        Assert.assertEquals(expectedErrorMessage, wrongPasswordMessage.getText().strip());
    }
    
}
