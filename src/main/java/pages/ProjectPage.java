package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Input;

import static com.codeborne.selenide.Selenide.$x;

public class ProjectPage extends BasePage {
    private static final SelenideElement CREATE_SUITE = $x("//*[@id='create-suite-button']");
    private static final SelenideElement DELETE_SUITE = $x("//*[@class='VdImN8 HL2YT7']");
    private static final SelenideElement CREATE_TEST_CASE = $x("//*[@id='create-case-button']");
    private static final SelenideElement DELETE_TEST_CASE = $x("//*[@type=\"button\" and @aria-label=\"Delete\"]");
    private static final String INPUT_FORM_CREATE_TEST_CASE ="(//div[@contenteditable='true' and @class='ProseMirror toastui-editor-contents'])[%s]";




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
        return $x(String.format("//h3[@class='IeCpCv' and text()= '%s']", nameSuite));
    }

    public ProjectPage deleteSuite(String nameSuite) {
        String deleteButtonXPath = String.format(
                "//a[@class='ZofjAx z7H5tt' and text()= '%s']" +
                "/following-sibling::div//i[@class='fa fa-ellipsis-h']", nameSuite);
        SelenideElement deleteButton = $x(deleteButtonXPath);
        new Button().click(deleteButton);
        new Button().click(DELETE_SUITE);
        new Button().clickButtonForm();
        return this;
    }

    private ProjectPage fillTestCaseform(String nameTestCase){
        new Button().click(CREATE_TEST_CASE);
        new Input("title").write(nameTestCase);
        new Input(INPUT_FORM_CREATE_TEST_CASE, 1).writeFormTcs(nameTestCase);
        new Input(INPUT_FORM_CREATE_TEST_CASE,2).writeFormTcs(nameTestCase);
        new Input(INPUT_FORM_CREATE_TEST_CASE,3).writeFormTcs(nameTestCase);
        new Button().clickButtonAddSteps();
        new Input(INPUT_FORM_CREATE_TEST_CASE,4).writeFormTcs(nameTestCase);
        new Input(INPUT_FORM_CREATE_TEST_CASE,5).writeFormTcs(nameTestCase);
        new Input(INPUT_FORM_CREATE_TEST_CASE,6).writeFormTcs(nameTestCase);
        new Button().clickButtonForm();
        return this;
    }

    public ProjectPage createTestCase(String nameTestCase){
        fillTestCaseform(nameTestCase);
        return this;
    }

    public SelenideElement getNameTestCase(String nameTestCase){
        return $x(String.format("//*[@class=\"OZXFF4\" and text()= '%s']", nameTestCase));
    }

    public ProjectPage deleteTestCase(String nameTestCase){
        new Button().click(DELETE_TEST_CASE);
        new Button().clickButtonDeleteTestCase();
        return this;
    }
}