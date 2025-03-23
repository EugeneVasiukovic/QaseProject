package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Button {
    private static final SelenideElement BUTTON_FORM_CREATE_NEW_PROJECT = $x("//*[@type='submit']");
    private static final SelenideElement BUTTON_FORM_DELETE_TEST_CASE = $x("(//*[@type=\"button\"])[18]");

    public Button() {
    }

    public void click(SelenideElement selenideElement){
        selenideElement.shouldBe(Condition.visible).click();
    }

    public void clickButtonForm(){
        BUTTON_FORM_CREATE_NEW_PROJECT.shouldBe(Condition.visible).click();
    }
    public void clickButtonDeleteTestCase(){
        BUTTON_FORM_DELETE_TEST_CASE.shouldBe(Condition.visible).click();
    }
}
