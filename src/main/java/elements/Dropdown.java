package elements;


import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class Dropdown {
    String label;
    public static final String DROPDOWN_ELEMENTS = "//*[text()='%s']/../div";
    public static final String DROPDOWN_OPTIONS = "//*[text()='%s']";

    public Dropdown(String label) {
        this.label = label;
    }

    public void dropdownSelectOption(String option) {
        $(By.xpath(String.format(DROPDOWN_ELEMENTS, label))).click();
        $x(String.format(DROPDOWN_OPTIONS, option)).click();
    }
}