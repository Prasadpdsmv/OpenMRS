package com.stepDefinitions;

import com.beust.ah.A;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.AddPatient;
import pages.LoginPage;

import java.util.Map;

public class AddPatientTest {
    AddPatient addPatient=new AddPatient();
    @Given("user goes to the add patient page")
    public void userGoesToTheAddPatientPage() {
        LoginPage loginPage = new LoginPage();
        loginPage.enterUsernameAndPassword("admin", "123qweASD");
        loginPage.clickOnLoginButton();
        loginPage.selectOutPtientLocation();
        loginPage.addPatientMenu();
        System.out.println("user reached add patient page");
    }

    @And("user enters patient details")
    public void userEntersPatientDetails(DataTable patientDetails) {
        Map<String, String> data = patientDetails.asMap(String.class, String.class);
        String firstName=data.get("First_Name");
        String familyName=data.get("Family_name");
        String gender=data.get("gender");
        String birthDate=data.get("Birth_Date");
        String address=data.get("adress");
        String phoneNumber=data.get("phoneNumber");

        Assert.assertEquals(addPatient.checkPatientIdentity(), "true");

        String[] birthdate=birthDate.split("-");
        String day=birthdate[0];
        String month=birthdate[1];
        String year=birthdate[2];
        System.out.println(" year splitted in  **"+"day value-"+day+"month value-" +month+"year value-" +year);
        addPatient.enterFirstNameAndFamily(firstName, familyName);
        addPatient.selectGender();
        addPatient.enterBirthDate(day,month,year);
        addPatient.enterAddress(address);
        addPatient.enterPhoneNumber(phoneNumber);
        System.out.println("user entered patient details");


    }

    @When("user clicks on register patient button")
    public void userClicksOnRegisterPatientButton() throws InterruptedException {
        addPatient.clickOnRegisterPatientButton();
        System.out.println("user clicked on register patient button");
    }

    @Then("system adds the patient into the system")
    public void systemAddsThePatientIntoTheSystem() {
        Assert.assertTrue(addPatient.getPatientBannerText());
        System.out.println("patient is added into the system");
    }

    @And("system shows the patient dashboard page")
    public void systemShowsThePatientDashboardPage() {
        Assert.assertTrue(addPatient.getPatientBannerText());
        System.out.println("patient dashboard page is displayed");
    }

    @Then("system shows validation error messages for existing patient details")
    public void systemShowsValidationErrorMessagesForExistingPatientDetails() {
        System.out.println("validation error messages are displayed for existing patient details");
    }

    @Then("system shows validation error messages for missing required fields")
    public void systemShowsValidationErrorMessagesForMissingRequiredFields() {

        Assert.assertTrue(addPatient.errorMessageForMisssingFields());
    }
}
