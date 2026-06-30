package com.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.LoginPage;
import pages.OrdersPage;

public class AddOrders {
    OrdersPage order=new OrdersPage();

    @Given("when user {string} is on oreders")
    public void whenUserIsOnOreders(String patientName) {
        LoginPage loginPage = new LoginPage();
        loginPage.enterUsernameAndPassword("admin", "123qweASD");
        loginPage.clickOnLoginButton();
        loginPage.selectOutPtientLocation();
        loginPage.searchPatient(patientName);

    }
    @And("click on record oredrs")
    public void clickOnRecordOredrs() {
        order.clicKOnOrders();
    }

    @Then("No active visit pop up will be displayed")
    public void noActiveVisitPopUpWillBeDisplayed() {

        Assert.assertTrue(order.clickAddRecordsAndVerifyNoActiveVisit());
    }

    @Then("record lab orders")
    public void recordLabOrders() {
        order.recordLabOrders();
    }
}
