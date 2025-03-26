package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Dropdown;
import elements.Input;

import static com.codeborne.selenide.Selenide.$x;

public class ProjectPage extends BasePage {
    private static final SelenideElement CREATE_SUITE = $x("//*[@id='create-suite-button']");
    private static final SelenideElement DELETE_SUITE = $x("//*[@class='VdImN8 HL2YT7']");
    private static final SelenideElement CREATE_TEST_CASE = $x("//*[@id='create-case-button']");
    private static final SelenideElement DELETE_TEST_CASE = $x("//*[@type=\"button\" and @aria-label=\"Delete\"]");
    private static final String INPUT_FORM_CREATE_TEST_CASE = "//*[text()='%s']/ancestor::div[contains(@class, 'form-group')]//div[@class='ProseMirror toastui-editor-contents']";
    private static final String NAME_TEST_SUITE = "//h3[@class='IeCpCv' and text()= '%s']";
    private static final String DELETE_BUTTON = "//a[@class='ZofjAx z7H5tt' and text()= '%s']/following-sibling::div//i[@class='fa fa-ellipsis-h']";
    private static final String NAME_TEST_CASE = "//*[@class=\"OZXFF4\" and text()= '%s']";



    private ProjectPage fillSuiteForm(String nameSuite){
        new Button().click(CREATE_SUITE);
        new Input("title").writeForm(nameSuite);
        new Button().clickButtonForm();
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
        new Button().clickButtonForm();
        return this;
    }

    private ProjectPage fillTestCaseform(String nameTestCase){
        new Button().click(CREATE_TEST_CASE);
        new Input("title").write(nameTestCase);
        new Input(INPUT_FORM_CREATE_TEST_CASE, "Description").writeFormTestCase(nameTestCase);
        new Dropdown()
                .selectDropdownElements("suite")
                .selectDropdownOptions("testSuite123");
        new Dropdown()
                .selectDropdownElements("0-severity")
                .selectDropdownOptions("Minor");
        new Dropdown()
                .selectDropdownElements("0-priority")
                .selectDropdownOptions("High");
        new Dropdown()
                .selectDropdownElements("0-type")
                .selectDropdownOptions("Smoke");
        new Dropdown()
                .selectDropdownElements("0-layer")
                .selectDropdownOptions("E2E");
        new Dropdown()
                .selectDropdownElements("0-is_flaky")
                .selectDropdownOptions("Yes");
        new Input(INPUT_FORM_CREATE_TEST_CASE,"Pre-conditions").writeFormTestCase(nameTestCase);
        new Input(INPUT_FORM_CREATE_TEST_CASE,"Post-conditions").writeFormTestCase(nameTestCase);
        new Button().clickButtonForm();
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
        new Button().clickButtonDeleteTestCase();
        return this;
    }
}