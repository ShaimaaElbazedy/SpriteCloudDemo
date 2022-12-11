package api;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StoreEndpointsTest {
    SHAFT.API apiDriver;
    SHAFT.CLI driverCLI;
    StoreClass storeClass;
    String id;

    @Test(priority = 1, description = "Creating a store order")
    public void createStoreOrder() {
        apiDriver.post("store/order")
                .setRequestBody(storeClass.createStoreOrderRequestBody())
                .addHeader("accept", "application/json")
                .setContentType(ContentType.JSON)
                .setTargetStatusCode(200)
                .perform();
        Validations.assertThat()
                .number(apiDriver.getResponseStatusCode())
                .isEqualTo(200)
                .perform();
    }
    @Test(priority = 2, description = "Retrieve the created store order by its id")
    public void getStoreOrderById() {
        apiDriver.get("store/order/" + storeClass.getStoreOrderId())
                .addHeader("Content-Type", "application/json")
                .setTargetStatusCode(200)
                .perform();
        Validations.assertThat()
                .object(apiDriver.getResponseBody())
                .contains(storeClass.getStoreOrderId())
                .perform();
    }

    @Test(priority = 3, description = "Deleting the created store order")
    public void deleteStoreOrder(){
        id = storeClass.getStoreOrderId();
        apiDriver.delete("store/order/"+id)
                .addHeader("accept","application/json")
                .setTargetStatusCode(200)
                .perform();
        Validations.assertThat()
                .number(apiDriver.getResponseStatusCode())
                .isEqualTo(200).perform();
        Validations.assertThat()
                .object(apiDriver.getResponseBody())
                .contains(id)
                .perform();

    }

    @Test(priority = 4, description = "Trying to retrieve a not found/recently deleted store order")
    public void getNotFoundStoreOrder(){
        apiDriver.get("store/order/" + id)
                .addHeader("Content-Type","application/json")
                .setTargetStatusCode(404)
                .perform();
        Validations.assertThat()
                .number(apiDriver.getResponseStatusCode())
                .isEqualTo(404)
                .perform();
        Validations.assertThat()
                .object(apiDriver.getResponseBody())
                .contains("Order not found")
                .perform();


    }

    @Test (priority = 5, description = "Trying to delete an already deleted order")
    public void deleteNotFoundStoreOrder(){
        apiDriver.delete("store/order/" +id)
                .addHeader("accept","application/json")
                .setTargetStatusCode(404)
                .perform();
        Validations.assertThat()
                .number(apiDriver.getResponseStatusCode())
                .isEqualTo(404)
                .perform();
        Validations.assertThat()
                .object(apiDriver.getResponseBody())
                .contains("Order Not Found")
                .perform();

    }

    @BeforeClass
    public void beforeClass(){
        apiDriver = new SHAFT.API("https://petstore.swagger.io/v2/");
        driverCLI = new SHAFT.CLI();
        storeClass = new StoreClass(apiDriver, driverCLI);

    }
}
