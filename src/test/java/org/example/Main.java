package org.example;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import Files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Main {
    public static void main(String[] args) {

        //Given - Input details
        //When - Submit API
        //Then - Validation
        RestAssured.baseURI = "https://api.eventhub.rahulshettyacademy.com/api";

        /*
        //Add User

        String response =
                given().header("Content-Type", "application/json")
                        .body(Payload.addBook())
                .when().post("/auth/register")
                .then().log().all().extract().response().asString();
        System.out.println(response);

        //Login USer

        System.out.println("---------------Login Now------------");
        String loginResponse = given().header("Content-Type", "application/json")
                .body(Payload.addBook())
                .when().post("/auth/login")
                .then().log().all().assertThat().statusCode(200).extract().response().asString();


        //Parse JSON i.e response
        JsonPath js = new JsonPath(loginResponse);
        String token = js.getString("success");
        System.out.println(token);

*/
         JsonPath js = new JsonPath(Payload.jsonPayload());
         int noOFCourses = js.get("courses.size()");
         int amt = js.getInt("dashboard.purchaseAmount");

        System.out.println("No of Courses - > " + noOFCourses);
        System.out.println("Amt - > " + amt);

        int sum = 0;
        for(int i = 0; i < noOFCourses; i++) {
//            System.out.println(i + "'th title is -> " +js.get("courses["+i+"].title"));
//            System.out.println(i + "'th title is -> " +js.get("courses["+i+"].price"));
//            System.out.println(i + "'th title is -> " +js.get("courses["+i+"].copies"));
            sum = sum + js.getInt("courses["+i+"].copies");
        }
        System.out.println(sum);
    }

}
