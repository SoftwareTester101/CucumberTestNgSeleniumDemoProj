package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import pageobjects.Form;

public class FormStepDefs {
    private Form form;
    private Faker faker;

    public FormStepDefs() {
        this.form = new Form();
        this.faker = new Faker();
    }

    @Then("I fill last name with {string}")
    public void iFillLastNameWith(String name) {
        String lastName = this.faker.name().lastName();
        System.out.println(lastName);
        this.form.fillLastName(lastName);
    }

    @Then("I fill first name with {string}")
    public void iFillFirstNameWith(String arg0) {
        String firstName = this.faker.name().firstName();
        this.form.fillFirstName(firstName);
    }

    @Then("I fill email with {string}")
    public void iFillEmailWith(String arg0) {
        String email = this.faker.beer().name().toLowerCase().replace(" ", "") + "@gmail.com";
        System.out.println(email);
        this.form.fillEmail(email);
    }

    @Then("I select gender as {string}")
    public void iSelectGenderAs(String value) {
        this.form.selectGender(value);
    }

    @Then("I fill mobile number with {string}")
    public void iFillMobileNumberWith(String arg0) {
        String num = this.faker.number().digits(10);
        this.form.fillMobileNum(num);
    }

    @Then("I fill address with {string}")
    public void iFillAddressWith(String arg0) {
        String address = this.faker.address().fullAddress();
        this.form.fillAddress(address);
    }

    @Then("I fill date of birth with {string}")
    public void iFillDateOfBirthWith(String dateOfBirth) {
        this.form.fillDateOfBirth(dateOfBirth);
    }

    @Then("I fill subjects with {string}")
    public void iFillSubjectsWith(String arg0) {
        String subject = this.faker.programmingLanguage().name();
        this.form.fillSubject(subject);
    }

    @Then("I select hobbies as {string}")
    public void iSelectHobbiesAs(String hobby) {
        this.form.fillHobby(hobby);
    }

    @Then("I select image as {string}")
    public void iSelectImageAs(String path) {
        this.form.selectImg(path);
    }

    @Then("I select state as {string}")
    public void iSelectStateAs(String state) throws InterruptedException {
        this.form.selectState(state);
    }

    @Then("I select city as {string}")
    public void iSelectCityAs(String city) {
        this.form.selectCity(city);
    }

    @Then("I submit the form")
    public void iSubmitTheForm() {
        this.form.clickSubmit();
    }
}
