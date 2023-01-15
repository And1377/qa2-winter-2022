package stepdefs;

import io.cucumber.java.en.When;

public class FirstStepDefs {
  @When("we are printing welcome text")
    public void print_welcome_text() {
      System.out.println("Hey_Hay! All works fine!");
  }
}
