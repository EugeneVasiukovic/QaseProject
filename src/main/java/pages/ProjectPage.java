package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Dropdown;
import elements.Input;

import static com.codeborne.selenide.Selenide.$x;

public class ProjectPage extends BasePage {
    private static final SelenideElement CREATE_SUITE = $x("//*[@id='create-suite-button']");
    private static final SelenideElement DELETE_SUITE = $x("//*[@class='VdImN8 HL2YT7']");
    private static final SelenideElement ADD_STEP_BUTTON = $x("//*[@type='button']//*[text()=' Add step']");
    private static final SelenideElement CREATE_TEST_CASE = $x("//*[@id='create-case-button']");
    private static final SelenideElement DELETE_TEST_CASE = $x("//*[@type=\"button\" and @aria-label=\"Delete\"]");
    private static final SelenideElement BUTTON_FORM_CREATE_NEW_PROJECT = $x("//*[@type='submit']");
    private static final SelenideElement BUTTON_FORM_DELETE_TEST_CASE = $x("(//*[@type=\"button\"])[18]");
    private static final SelenideElement STEP_WRITE_INPUT = $x("(//*[@class = 'OwrMko']//*[contains(@class, 'ProseMirror toastui-editor-contents')])[1]");
    private static final String NAME_TEST_SUITE = "//h3[@class='IeCpCv' and text()= '%s']";
    private static final String DELETE_BUTTON = "//a[@class='ZofjAx z7H5tt' and text()= '%s']/following-sibling::div//i[@class='fa fa-ellipsis-h']";
    private static final String NAME_TEST_CASE = "//*[@class=\"OZXFF4\" and text()= '%s']";



    private ProjectPage fillSuiteForm(String nameSuite){
        new Button().click(CREATE_SUITE);
        new Input("title").writeForm(nameSuite);
        new Button().click(BUTTON_FORM_CREATE_NEW_PROJECT);
        return this;
    }

    public ProjectPage createSuite(String nameSuite){
        fillSuiteForm(nameSuite);
        return this;
    }

    public SelenideElement getNameSuite(String nameSuite) {
        return $x(String.format(NAME_TEST_SUITE, nameSuite));
    }

    public ProjectPage deleteSuite(String nameSuite) {
        SelenideElement deleteButton = $x(String.format(DELETE_BUTTON,nameSuite));
        new Button().click(deleteButton);
        new Button().click(DELETE_SUITE);
        new Button().click(BUTTON_FORM_CREATE_NEW_PROJECT);
        return this;
    }

    private ProjectPage fillTestCaseform(String nameTestCase){
        new Button().click(CREATE_TEST_CASE);
        new Input("title").write(nameTestCase);
        new Input( "Description").writeFormTestCase(nameTestCase);
        new Dropdown("Suite").dropdownSelectOption("testSuite123");
        new Dropdown("Severity").dropdownSelectOption("Minor");
        new Dropdown("Priority").dropdownSelectOption("High");
        new Dropdown("Type").dropdownSelectOption("Smoke");
        new Dropdown("Layer").dropdownSelectOption("E2E");
        new Dropdown("Is flaky").dropdownSelectOption("Yes");
        new Input("Pre-conditions").writeFormTestCase(nameTestCase);
        new Input("Post-conditions").writeFormTestCase(nameTestCase);
        new Button().click(ADD_STEP_BUTTON);
        STEP_WRITE_INPUT.setValue(nameTestCase);
        new Button().click(BUTTON_FORM_CREATE_NEW_PROJECT);
        return this;
    }

    public ProjectPage createTestCase(String nameTestCase){
        fillTestCaseform(nameTestCase);
        return this;
    }

    public SelenideElement getNameTestCase(String nameTestCase){
        return $x(String.format(NAME_TEST_CASE, nameTestCase));
    }

    public ProjectPage deleteTestCase(String nameTestCase){
        new Button().click(DELETE_TEST_CASE);
        new Button().click(BUTTON_FORM_DELETE_TEST_CASE);
        return this;
    }
}