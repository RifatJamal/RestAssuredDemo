import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class TestGetMethod {

    @Test
    void test01(){

        Response response = get("https://api.agify.io/?name=meelad");
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());
        System.out.println(response.asString());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));
        System.out.println(response.getTime());

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    void test02(){

        given().get("https://api.agify.io/?name=meelad").then().statusCode(200).body("count", equalTo(21));
    }
}
