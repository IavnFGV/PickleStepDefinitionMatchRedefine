package drozda;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.bytebuddy.*;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.dynamic.loading.*;
import net.bytebuddy.implementation.*;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class StepDef {

    @Before
    public void redefineTEstStep() throws ClassNotFoundException {

        Class<?> aClass = Class.forName("cucumber.runner.PickleStepDefinitionMatch");
        ByteBuddyAgent.install();
        new ByteBuddy()
                .redefine(aClass)
                .method(named("removeFrameworkFramesAndAppendStepLocation"))

                .intercept( FixedValue.argument(0))
                .make()
                .load(
                        aClass.getClassLoader(),
                        ClassReloadingStrategy.fromInstalledAgent());
    }

    @Given("^I have (\\d+) cukes in my belly$")
    public void i_have_cukes_in_my_belly(int arg1) throws Exception {
        throw new NullPointerException("test");
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
    }

    @When("^I wait (\\d+) hour$")
    public void i_wait_hour(int arg1) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^my belly should grow$")
    public void my_belly_should_grow() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }


}
