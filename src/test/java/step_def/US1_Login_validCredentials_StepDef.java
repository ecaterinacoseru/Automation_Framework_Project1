package step_def;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Login;
import utilities.BrowserUtils;
import utilities.Driver;

public class US1_Login_validCredentials_StepDef {


    private final Login login = new Login();

    @Given("user on the login page")
    public void userOnTheLoginPage() {
      login.goLoginPage();
    }

    @When("user use username {string} and passcode {string}")
    public void userUseUsernameAndPasscode(String username, String password) {
        login.login(username,password);
    }
    @When("user click the login button")
    public void user_click_the_login_button() {
        login.loginBtnClick();
    }
    @Then("verify the user should be at the dashboard page")
    public void verify_the_user_should_be_at_the_dashboard_page() {
        BrowserUtils.verifyTitle("Dashboard - Trycloud");
    }


}
