package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Button {

    public Button() {
    }

    public void click(SelenideElement selenideElement){
        selenideElement.shouldBe(Condition.visible).click();
    }

}