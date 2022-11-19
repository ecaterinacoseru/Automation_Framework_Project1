package step_def;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.Dashboard;
import pages.Login;

import java.util.List;
import java.util.stream.Collectors;

public class US3_All_Modules_StepDef {

    public final Login login = new Login();
    public final Dashboard dashboard = new Dashboard();



    @When("the users  log in with valid credentials")
    public void the_users_log_in_with_valid_credentials() {
        login.goLoginPage();
        login.login();
    }
    @Then("Verify the user see the following modules:")
    public void verify_the_user_see_the_following_modules(List<String> menu) {
        dashboard.actualMenuList();
        Assert.assertEquals(menu, dashboard.actualMenuList().stream().limit(menu.size()).collect(Collectors.toList()));
    }
}
