package steps;

import io.qameta.allure.Step;
import pages.ProjectPage;

public class ProjectSteps {
    ProjectPage projectPage;

    public ProjectSteps(){
        this.projectPage = new ProjectPage();
    }

    @Step("Create test suite")
    public void createTestSuite(String nameSuite){
        projectPage.createSuite(nameSuite);
    }

    @Step("Delete test Suite")
    public void deleteTestSuite(String nameSuite){
        projectPage.deleteSuite(nameSuite);
    }

    @Step("Create test case")
    public void createTestCase(String nameTestCase){
        projectPage.createTestCase(nameTestCase);
    }

    @Step("Delete test case")
    public void deleteTestCase(String nameTestCase){
        projectPage.deleteTestCase(nameTestCase);
    }
}
