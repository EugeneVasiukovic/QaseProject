package pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Input;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProjectListPage extends BasePage {
    private static final SelenideElement CREATE_NEW_PROJECT = $x("//*[text()='Create new project']");
    private static final SelenideElement SELECT_DELETE_BUTTON = $x("//*[@data-testid='remove']");
    private static final SelenideElement BUTTON_DELETE_POPUP = $x("//*[@class=\"TWyAWk wTBhSN OqQ8EY v2rESE\"]");
    private static final SelenideElement NAV_MENU_ELEMENT = $(By.linkText("Projects"));

    public ProjectListPage isOpened() {
        CREATE_NEW_PROJECT.shouldBe(Condition.visible);
        return this;
    }
    public ProjectListPage openProject(String nameProject){
        String navigateProject = String.format("//*[@class='cx2QU4' and text()='%s']", nameProject);
        SelenideElement projectNaviate = $x(navigateProject);
        new Button().click(projectNaviate);
        return this;
    }

    private ProjectListPage fillFormCreateProject(String nameProject) {
        new Button().click(CREATE_NEW_PROJECT);
        new Input("project-name").writeForm(nameProject);
        new Button().clickButtonForm();
        return this;
    }

    public ProjectListPage createProject(String nameProject) {
        fillFormCreateProject(nameProject);
        return this;
    }

    public void backPageCreateProject(){
        new Button().click(NAV_MENU_ELEMENT);
    }

    public SelenideElement getProjectElement(String nameProject) {
        return $x(String.format("//*[@id='application-content']/div/table/tbody/tr[td[3]/div/div/a[text()='%s']]", nameProject));
    }

    public ProjectListPage deleteProject(String nameProject) {
        String deleteButtonXPath = String.format(
                "//*[@id='application-content']/div/table/tbody/tr[td[3]/div/div/a[text()='%s']]" +
                "//button[@type='button' and @aria-haspopup='true' and @aria-expanded='false' " +
                "and @aria-label='Open action menu']", nameProject);
        SelenideElement deleteButton = $x(deleteButtonXPath);
        new Button().click(deleteButton);
        new Button().click(SELECT_DELETE_BUTTON);
        new Button().click(BUTTON_DELETE_POPUP);
        return this;
    }
}