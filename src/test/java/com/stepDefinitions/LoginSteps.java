package com.stepDefinitions;

import pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginSteps  {


    LoginPage loginPage=new LoginPage();
    @Given("user visits login page")
    public void userVisitsLoginPage() {
        String title=loginPage.verifyPageTitle();
        System.out.println("title");
    }

    @And("user clicks on login button")
    public void userClicksOnLoginButton() {
        loginPage.clickOnLoginButton();
    }

    @Then("user should see location select page")
    public void userShouldSeeLocationSelectPage() {
        Assert.assertTrue(loginPage.locationPage());

    }

    @Then(": user should see error message")
    public void userShouldSeeErrorMessage() {
        Assert.assertTrue(loginPage.errorMeassageValidation());
    }

    @When("user entrer {string} and {string}")
    public void userEntrerAnd(String username, String password) {
        loginPage.enterUsernameAndPassword(username,password);
    }
}
