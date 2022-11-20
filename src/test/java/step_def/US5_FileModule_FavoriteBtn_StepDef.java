package step_def;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Dashboard;
import pages.Files;
import pages.Login;

public class US5_FileModule_FavoriteBtn_StepDef {

    private final Login login = new Login();
    private final Dashboard dashboard = new Dashboard();
    private final Files files = new Files();

    @When("the user clicks action-icon  from any file on the page")
    public void the_user_clicks_action_icon_from_any_file_on_the_page() {
      files.clickActionBtns();
    }
    @When("user choose the {string} option")
    public void user_choose_the_option(String string) {
      files.addToFavorites();
    }
    @When("user click the {string} sub-module on the left side")
    public void user_click_the_sub_module_on_the_left_side(String string) {

    }
    @Then("Verify the chosen file is listed on the table")
    public void verify_the_chosen_file_is_listed_on_the_table() {

    }

}
