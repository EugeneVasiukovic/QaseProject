package steps;

import io.qameta.allure.Step;
import pages.ProjectListPage;

public class ProjectListSteps {
    ProjectListPage projectListPage;

    public ProjectListSteps() {
        this.projectListPage = new ProjectListPage();
    }

    @Step("Create project")
    public void createProject(String nameProject){
        projectListPage.createProject(nameProject);
    }

    @Step("Open project")
    public void openProject(String nameProject){
        projectListPage.openProject(nameProject);
    }

    @Step("Back to page create project")
    public void backToPageCreateProject(){
        projectListPage.backPageCreateProject();
    }

    @Step("Delete project")
    public void deleteProject(String nameProject){
        projectListPage.deleteProject(nameProject);
    }
}
