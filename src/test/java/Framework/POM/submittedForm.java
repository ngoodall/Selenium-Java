package Framework.POM;

import net.serenitybdd.annotations.At;
import org.openqa.selenium.By;
import net.serenitybdd.core.pages.PageObject;

@At("https://www.selenium.dev/selenium/web/submitted-form.html*")
public class submittedForm extends PageObject {
    public static final By submissionOutputMessage = By.id("message");
}
