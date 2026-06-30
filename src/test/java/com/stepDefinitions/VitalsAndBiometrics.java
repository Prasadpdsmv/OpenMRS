package com.stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;
import pages.PatientSummary;
import pages.Vitals_Biometrics;

import java.util.Map;

public class VitalsAndBiometrics {
    LoginPage loginPage=new LoginPage();
    PatientSummary patentSummary=new PatientSummary();
    Vitals_Biometrics vitalsBiometrics=new Vitals_Biometrics();

    @Given("user is on add vitals and biometrics page")
    public void userIsOnAddVitalsAndBiometricsPage() {
        loginPage.enterUsernameAndPassword("Admin", "123qweASD");
        loginPage.clickOnLoginButton();
        loginPage.selectOutPtientLocation();

        patentSummary.seacrPatient("test john");
        patentSummary.clickRecordVitalsAnsBiometris();

    }

    @And("user enters vitals and biometrics")
    public void userEntersVitalsAndBiometrics(DataTable dataTable) {
        Map<String, String> data=dataTable.asMap(String.class, String.class);
        String temparatur=data.get("temparature");
        String sysBP=data.get("sysBP");
        String disBP=data.get("disBP");
        String HeartRate=data.get("HeartRate");
        String Respiration=data.get("Respiration");
        String SP2=data.get("SP2");
        String Notes=data.get("Notes");
        String weight=data.get("weight");
        String height=data.get("height");
        String muac=data.get("muac");

        vitalsBiometrics.enterTemperature(temparatur);
        vitalsBiometrics.enterBloodPressure(sysBP,disBP);
        vitalsBiometrics.enterHeartRate(HeartRate);
        vitalsBiometrics.enterRespirationRate(Respiration);

        vitalsBiometrics.enterOxygenSaturationRate(SP2);
        vitalsBiometrics.enterHeightInut(height);
        vitalsBiometrics.enterWeightInut(weight);
        vitalsBiometrics.clickSaveAndClose();
    }

    @When("user clicks save and close successfull message should appear")
    public void userClicksSaveAndCloseSuccessfullMessageShouldAppear() {
        Assert.assertTrue(vitalsBiometrics.verifySuccessMessage());
    }

    @Then("vitals and biometrics should display on Patient Summary page")
    public void vitalsAndBiometricsShouldDisplayOnPatientSummaryPage() {

    }

    @And("verify deatails from input details.")
    public void verifyDeatailsFromInputDetails() {
    }
}
