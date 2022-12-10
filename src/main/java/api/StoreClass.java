package api;

import com.shaft.driver.SHAFT;

public class StoreClass {
    //Variables
    public static final String baseUrl = "https://petstore.swagger.io/v2/";
    SHAFT.API apiDriver;
    SHAFT.CLI driverCLI;

    //Constructor
    public StoreClass(SHAFT.API apiDriver, SHAFT.CLI driverCLI){
        this.apiDriver = apiDriver;
        this.driverCLI = driverCLI;
    }

    //Operations
    public String createStoreOrderRequestBody(){
        var requestBody = driverCLI.file().readFile("src/test/resources/apiTestDataFiles/createStoreOrderRequestBody.json");
        return requestBody;
    }

    public String getStoreOrderId(){
        return apiDriver.getResponseJSONValue("$[?(@.id)].id");
    }
}
