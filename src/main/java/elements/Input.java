package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class Input {
    String label;

    private static final String INPUT_FORM_CREATE_TEST_CASE = "//*[text()='%s']/ancestor::div[contains(@class, 'form-group')]//div[@class='ProseMirror toastui-editor-contents']";
    public String inputLocator = "//*[@name='%s']";
    public String formInput = "//*[@id='%s']";


    public Input(String label) {
        this.label = label;
    }
    public Input write(String text){
        $x(String.format(inputLocator, label)).shouldBe(Condition.visible).setValue(text);
        return this;
    }

    public Input writeForm(String text){
        $x(String.format(formInput, label)).shouldBe(Condition.visible).setValue(text);
        return this;
    }
    public Input writeFormTestCase(String text) {
        $x(String.format(INPUT_FORM_CREATE_TEST_CASE, label)).shouldBe(Condition.visible).setValue(text);
        return this;
    }

    public Input clear(){
        SelenideElement element = $x(String.format(inputLocator, label));
        element.click();
        element.clear();
        return this;
    }
}
