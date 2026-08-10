package EcomerceAPI;

import POJO.LogInPayload;
import POJO.LogInRespPayload;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class EcommerceE2E {

    static void main(String[] args) {
        RequestSpecification requests = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/")
                .setContentType(ContentType.JSON).build();

        LogInPayload logInReq =  new LogInPayload();
        logInReq.setUserEmail("Practice1234@gmail.com");
        logInReq.setUserPassword("Practice1234@gmail.com");

        RequestSpecification logInCall = given().spec(requests).body(logInReq);

        LogInRespPayload resp = logInCall.when().post("/api/ecom/auth/login").then().statusCode(200).extract().response().as(LogInRespPayload.class);

        System.out.println(resp.getToken());
        System.out.println(resp.getUserId());
        System.out.println(resp.getMessage());
    }
}
