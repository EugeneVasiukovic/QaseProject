package elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;


public class Dropdown {
    public static final String DROPDOWN_ELEMENTS = "//*[@id='%s']";
    public static final String DROPDOWN_OPTIONS = "//*[text()='%s']";

    public Dropdown selectDropdownElements(String nameDropdownElement) {
        SelenideElement elementDropdown = $x(String.format(DROPDOWN_ELEMENTS, nameDropdownElement));
        elementDropdown.click();
        return this;
    }

    public Dropdown selectDropdownOptions(String nameDropdownOptional) {
        SelenideElement elementDropdown = $x(String.format(DROPDOWN_OPTIONS, nameDropdownOptional));
        elementDropdown.click();
        return this;
    }
}