package step_def;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Dashboard;
import pages.Files;
import pages.Login;
import utilities.BrowserUtils;
import utilities.Driver;

public class US4_Access_to_files {

    private final Login login = new Login();
    private final Files files = new Files();
    private final Dashboard dashboard = new Dashboard();

    @Given("user on the dashboard page")
    public void user_on_the_dashboard_page() {
        login.goLoginPage();
        login.login();
    }

    @When("the user clicks the {string} module")
    public void the_user_clicks_the_module(String Files) {
        dashboard.moduleClicker(Files);
    }

    @Then("verify the page title is {string}")
    public void verifyThePageTitleIs(String expectedTitle) {
        BrowserUtils.verifyTitle(expectedTitle);
    }

    @When("user click the top-left checkbox of the table")
    public void user_click_the_top_left_checkbox_of_the_table() {
        files.setSelectAllCheckBox();
    }

    @Then("verify all the files are selected")
    public void verify_all_the_files_are_selected() {
        files.verifySelectAllBox();
    }
}
