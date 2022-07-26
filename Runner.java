package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        // Path of feature file
        features = "C://Users//Dell//IdeaProjects//My_Cucumber//Features//Google.feature",
        // Path of pakage where the code is stored
        glue = "StepDefinations"
)

public class Runner {
}
