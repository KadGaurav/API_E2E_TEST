package OAuth;

import POJO.API;
import POJO.GetCourses;
import POJO.Mobile;
import com.sun.net.httpserver.Request;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;

import java.util.List;

import static io.restassured.RestAssured.given;

public class OAuth_Test_Spec {
    static void main(String[] args) {

        new RequestSpecBuilder()
                .setBaseUri("https://rahulshettyacademy.com")
                .addQueryParam("access_token","accessToken")
                .build();

        String resp = given().
                formParam("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com").
                formParam("client_secret","erZOWM9g3UtwNRj340YYaK_W").
                formParam("grant_type","client_credentials").
                formParam("scrope","Trust").
                post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();

        JsonPath js =new JsonPath(resp);
        String accessToken = js.getString("access_token");

         GetCourses resp2 = given().
                queryParam("access_token",accessToken).
                when().log().all().
                get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").as(GetCourses.class);


        String response = given().
                queryParam("access_token",accessToken).
                when().log().all().
                get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").asString();

        System.out.println(response);

         List<API> apis = resp2.getCourses().getApi();
         for (API api : apis) {
             System.out.println(api.getCourseTitle());
         }

         List<Mobile> mob = resp2.getCourses().getMobile();
         for (Mobile mobile : mob) {
             System.out.println(mobile.getPrice());
         }

    }
}
