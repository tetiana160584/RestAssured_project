package steps;

import configuration.BaseClass;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.plugin.event.Result;
import org.junit.Assert;
import org.junit.runner.RunWith;
import page.CertificateFactory;

import javax.naming.spi.DirStateFactory;

public class CertificateSteps extends BaseClass {

    static {
        if (driver == null) {
            BaseClass.create();
        }
    }

    CertificateFactory certificateFactory = new CertificateFactory(driver);

    @Before
    public void openCertificatePage() {
        driver.navigate().to("https://certificate.ithillel.ua/");
    }

    @When("I enter certificate number{string}")
    public void iEnterCertificateNumber(String certificateNumber) {
        certificateFactory.enterNumber(certificateNumber);
    }

    @Then("Verification  certificate {string}")
    public void verificationCertificate(String expected) throws Exception {
        Assert.assertEquals(Boolean.valueOf(expected),certificateFactory.checkCertifCheckForm());
    }

    @When("I enter negative certificate number {}")
    public void iEnterNegativeCertificateNumber(String certNumber) {
        certificateFactory.enterNumber((certNumber));

    }


    @Then("I check {}")
    public void iCheck(String expected) {
        boolean expectedResult=Boolean.parseBoolean(expected);
        boolean actualResult = certificateFactory.checkLinkCertificate();
        Assert.assertEquals(expectedResult, actualResult);
    }
}
















