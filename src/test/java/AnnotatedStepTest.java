import org.junit.jupiter.api.Test;

public class AnnotatedStepTest {

    private final static String Repository = "eroshenkoam/allure-example";
    private final static Integer Issue_Number = 68;

    @Test
    public void testGithub() {
    WebSteps steps = new WebSteps();

    steps.openMainPage();
    steps.searchForRepository(Repository);
    steps.goToRepository(Repository);
    steps.openIssueTab();
    steps.shouldSeeIssueWithNumber(Issue_Number);
    }
}
