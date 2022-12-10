package api;

import com.shaft.driver.SHAFT;

public class PetClass {
    //Variables
    public static final String baseUrl = "https://petstore.swagger.io/v2/";
    SHAFT.API apiDriver;
    SHAFT.CLI driverCLI;

    //Constructor
    public PetClass(SHAFT.API apiDriver, SHAFT.CLI driverCLI){
        this.apiDriver = apiDriver;
        this.driverCLI = driverCLI;
    }

    //Operations
    public String createPetRequestBody(){
        var requestBody = driverCLI.file().readFile("src/test/resources/apiTestDataFiles/createPetRequestBody.json");
        return requestBody;
    }

    public String getCreatedPetId(){
       return apiDriver.getResponseJSONValue("$[?(@.id)].id");
    }

}
