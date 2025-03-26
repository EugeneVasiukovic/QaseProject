package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Input {
    String label;
    private String xpath;
    private int index;

    public String inputLocator = "//*[@name='%s']";
    public String formInput = "//*[@id='%s']";

    public Input(String xpath, int index) {
        this.xpath = String.format(xpath, index);
    }

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
    public Input writeFormTcs(String text) {
        $x(xpath).shouldBe(Condition.visible).setValue(text);
        return this;
    }

    public Input clear(){
        SelenideElement element = $x(String.format(inputLocator, label));
        element.click();
        element.clear();
        return this;
    }
}
