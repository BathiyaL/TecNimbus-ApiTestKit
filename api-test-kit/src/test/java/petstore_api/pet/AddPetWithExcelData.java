package petstore_api.pet;

import io.github.tecnimbus.apitestkit.actions.RestCaller;
import io.github.tecnimbus.apitestkit.common.RequestMethod;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.ExcelReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddPetWithExcelData {

    @BeforeAll
    static void setup() {
        RestCaller.baseURI = "https://petstore.swagger.io/v2";
    }

    @Test
    void testAddNewPet() {
        // Read request body from Excel file
        String filePath = "src/test/resources/pet_post_request_samples.xlsx";
        String sheetName = "Pet POST Requests";
        int rowNumber = 2;
        int cellNumber = 1;
        String requestBody = ExcelReader.getCellData(filePath, sheetName, rowNumber, cellNumber);

        // Set up RestCaller
        RestCaller.endpoint = "/pet";
        RestCaller.requestMethod = RequestMethod.POST;
        RestCaller.headers.put("Content-Type", "application/json");
        RestCaller.requestBody = requestBody;

        // Send request and assert response
        Response response = RestCaller.send();

        assertEquals(200, response.getStatusCode(), "Expected HTTP status code 200");
    }
}
