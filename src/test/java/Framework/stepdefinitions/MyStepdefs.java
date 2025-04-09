package Framework.stepdefinitions;

import Framework.POM.submittedForm;

import Framework.POM.webForm;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;

import java.io.File;
import java.util.Objects;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MyStepdefs extends UIInteractionSteps { ;

    webForm wF;
    submittedForm sF;

    @Given("I have navigated to {string} website")
    public void navigationStep(String URL) {
        wF.open();
    }

    @When("I enter {string} into {string} field")
    public void enterFieldData(String value, String fieldName) {
        String Xpath = "";
        if(Objects.equals(fieldName, "Textarea")){
            Xpath = "//label[text()='"+fieldName+"\n" + "              ']/textarea";
        } else{
            Xpath = "//label[text()='"+fieldName+"\n" + "              ']/input";
        }
        find(By.xpath(Xpath)).sendKeys(value);
    }

    @Then("The header {string} text is displayed")
    public void AssertingHeader(String headerValue) {
        Serenity.reportThat("Assert that the header is displayed.",
                () -> assertThat(find(sF.submissionOutputMessage).isDisplayed(), is(true))
        );
    }

    @When("I select {string} from the {string} dropdown")
    public void iSelectFromTheDropdown(String arg0, String arg1) {
        if(Objects.equals(arg1, "Dropdown (select)")){
            find(wF.dropDownSelect).click();
            WebElementFacade testing = find(wF.dropDownSelect).then(By.xpath("//option[text()='"+arg0+"']"));
            testing.click();
        } else {
            find(wF.dropDownDatalist).sendKeys(arg0);
            find(wF.dropDownDatalist).then(By.xpath("//option[text()='"+arg0+"']")).click();
        }
    }

    @When("I upload {string} file")
    public void iUploadFile(String arg0) {
        File uploadFile = null;
        switch (arg0){
            case "ImageFile":
                uploadFile = new File("src/test/java/Framework/testFiles/test.bmp");
                break;
            case "TextFile":
                uploadFile = new File("src/test/java/Framework/testFiles/test.txt");
                break;
            case "WordFile":
                uploadFile = new File("src/test/java/Framework/testFiles/test.docx");
                break;
            default:
                uploadFile = new File("src/test/java/Framework/testFiles/test.bmp");
                break;
        }
        find(wF.fileUpload).sendKeys(uploadFile.getAbsolutePath());
    }

    @When("I select the {string} option")
    public void iSelectTheOption(String arg0) {
        if(arg0.contains("checkbox")){
            if(Objects.equals(arg0, "Checked checkbox")){
                find(wF.checkbox1).click();
            } else {
                find(wF.checkbox2).click();
            }
        } else {
            if(Objects.equals(arg0, "Checked checkbox")){
                find(wF.radiobox1).click();
            } else {
                find(wF.radiobox2).click();
            }
        }
    }

    @When("I slide {string} for the example range")
    public void iSlideForTheExampleRange(String arg0) {

    }

    @When("I click the {string} button")
    public void iClickTheButton(String arg0) {
        find(wF.submitButton).click();
    }
}
