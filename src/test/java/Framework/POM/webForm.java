package Framework.POM;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("https://www.selenium.dev/selenium/web/web-form.html")
public class webForm extends PageObject {
    public static final By submitButton = By.xpath("//button[text()='Submit']");

    public static final By dropDownSelect = By.xpath("//label[text()='Dropdown (select)\n" + "              ']/select");

    public static final By dropDownDatalist = By.xpath("//label[text()='Dropdown (datalist)\n" + "              ']/input");

    public static final By fileUpload = By.xpath("/html/body/main/div/form/div/div[2]/label[3]/input");

    public static final By checkbox1 = By.id("my-check-1");

    public static final By checkbox2 = By.id("my-check-2");

    public static final By radiobox1 = By.id("my-radio-1");

    public static final By radiobox2 = By.id("my-radio-2");
}
