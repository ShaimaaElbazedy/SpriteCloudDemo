package api;

import com.shaft.driver.SHAFT;

import com.shaft.validation.Validations;
import io.cucumber.java.ja.但し;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class petEndpointsTest {
    SHAFT.API apiDriver;
    SHAFT.CLI driverCLI;
    PetClass petClass;


    @Test (priority = 1, description = "TC1: Creating a new pet entry")
    public void createPet() {
        apiDriver.post("pet")
                .setRequestBody(petClass.createPetRequestBody())
                .setContentType(ContentType.JSON)
                .setTargetStatusCode(200)
                .perform();
        petClass.getCreatedPetId();
    }
    @Test (priority = 2, description = "TC2: Retrieving the created pet by its id")
    public void getPetById(){
        apiDriver.get("pet/"+ petClass.getCreatedPetId())
                .addHeader("Content-Type","application/json")
                .setTargetStatusCode(200)
                .perform();
        apiDriver.assertThatResponse()
                .extractedJsonValue("$[?(@.id)].id")
                .isEqualTo(petClass.getCreatedPetId()).perform();
    }

    @Test (priority = 3, description = "Deleting the created pet")
    public void deleteExistingPet(){
        apiDriver.delete("pet/"+ petClass.getCreatedPetId())
                .setContentType(ContentType.JSON)
                .setTargetStatusCode(200)
                .perform();
    }
    @Test (priority = 4, description = "TC4: Checking the functionality of retrieving pet by allowed status (available, pending, sold)")
    public void getPetByStatus(){
        apiDriver.get("pet/findByStatus?status=available")
                .addHeader("Content-Type","application/json")
                .perform();
        apiDriver.assertThatResponse()
                .extractedJsonValue("$[?(@.id)].status")
                .isEqualTo("available").
                perform();
    }
    @Test(priority = 5, description = "TC5: Checking behavior when trying to retrieve a Not found pet")
    public void getNotFoundPet(){
        apiDriver.get("pet/12")
                .addHeader("Content-Type","application/json")
                .setTargetStatusCode(404)
                .perform();
        Validations.assertThat()
                .object(apiDriver.getResponseBody()).contains("Pet not found")
                .perform();
        Validations.assertThat()
                .number(apiDriver.getResponseStatusCode())
                .isEqualTo(404)
                .perform();

    }
    @Test(priority = 6, description = "TC6: Checking behavior when trying to retrieve a pet without sending an id")
    public void getPetWithoutId(){
        apiDriver.get("pet/")
                .addHeader("Content-Type","application/json")
                .setTargetStatusCode(405)
                .perform();
        Validations.assertThat()
                .number(apiDriver.getResponseStatusCode())
                .isEqualTo(405)
                .perform();

    }
    @Test (priority = 7, description = "Deleting a non exisiting pet")
    public void deleteNonExistingPet(){
        apiDriver.delete("pet/12")
                .setContentType(ContentType.JSON)
                .setTargetStatusCode(404)
                .perform();
        Validations.assertThat()
                .object(apiDriver.getResponseBody()).contains("")
                .perform();
        Validations.assertThat()
                .number(apiDriver.getResponseStatusCode())
                .isEqualTo(404)
                .perform();

    }


    @BeforeClass
    public void beforeClass(){
        apiDriver = new SHAFT.API("https://petstore.swagger.io/v2/");
        driverCLI = new SHAFT.CLI();
        petClass = new PetClass(apiDriver, driverCLI);

    }
}
