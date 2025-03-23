package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Input;

import static com.codeborne.selenide.Selenide.$x;

public class ProjectPage extends BasePage {
    private static final SelenideElement CREATE_SUITE = $x("//*[@id='create-suite-button']");
    private static final SelenideElement DELETE_SUITE = $x("//*[@class='VdImN8 HL2YT7']");
    private static final SelenideElement CREATE_TEST_CASE = $x("//*[@id='create-case-button']");
    private static final SelenideElement BUTTON_ADD_TEST_CASE = $x("//*[@class='ihH2PP G1dmaA ecSEF_ eij1r4 m8z14Q']");
    private static final SelenideElement DELETE_TEST_CASE = $x("//*[@type=\"button\" and @aria-label=\"Delete\"]");




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
        String clickButtonXpath = String.format("//*[@class=\"YkyiUm t1vo_q\" and text()= '%s']", nameTestCase);
        SelenideElement clickTestCase = $x(clickButtonXpath);
        new Button().click(clickTestCase);
        new Button().click(DELETE_TEST_CASE);
        new Button().clickButtonDeleteTestCase();
        return this;
    }
}