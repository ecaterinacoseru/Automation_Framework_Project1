package step_def;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Login;

public class US2_Login_invalidCredentials_StepDef {

    private final Login login = new Login();

    @Given("user on the login page")
    public void user_on_the_login_page() {

    }

    @When("user enter invalid {string} and {string}")
    public void user_enter_invalid_and(String string, String string2) {

    }

    @When("user click the login button")
    public void user_click_the_login_button() {

    }

    @Then("verify {string} message should be displayed")
    public void verify_message_should_be_displayed(String string) {

    }
}