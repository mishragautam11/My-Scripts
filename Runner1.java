package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "C:\\Users\\Dell\\IdeaProjects\\My_Cucumber\\Features\\Testing.feature",
        glue= "StepDefinations"

)

public class Runner1 {
}
