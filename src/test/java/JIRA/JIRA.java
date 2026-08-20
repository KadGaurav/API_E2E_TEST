package JIRA;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import java.io.File;


public class JIRA {
    static void main(String[] args) {
        RestAssured.baseURI = "https://testpractice.atlassian.net";

        String resp = given().header("Authorization","Basic Z2F1cmF2a2FkMTNAZ21haWwuY29tOkFUQVRUM3hGZkdGMGFVZnZOREo5eEFPVWdWOFFsVlQ4OVpCV1JrT0pycVdtakpVMkRjUmRWS09BcEptemh1V2xXY2hPNl9SeS16MkU2OW1lbDRfT1lPMU04WGVsb18zV1lzSFNkZFJfNEduUjh4cUVCc0Z2ODBVcTBiMjI3a3hHN01feGhYc1ZNaWJBdFJjS25HVlZ5Z2l3UkR2akdyQVJMSGdERnJvdENHZGRoenlJdlVHWURfWT0xQTJCNThFMQ==")
                .header("Content-Type","application/json")
                .body("{\n" +
                        "    \"fields\": {\n" +
                        "       \"project\":\n" +
                        "       {\n" +
                        "          \"key\": \"KAN\"\n" +
                        "       },\n" +
                        "       \"summary\": \"10RestAssured Issue 10\",\n" +
                        "       \"issuetype\": {\n" +
                        "          \"name\": \"Bug\"\n" +
                        "       }\n" +
                        "   }\n" +
                        "}\n")
                .post("/rest/api/3/issue")
                .then().log().all().assertThat().statusCode(201).extract().response().asString();

        JsonPath js = new JsonPath(resp);
        String issueId = js.getString("id");
        System.out.println("Issue ID: " + issueId);

        //attach evidence to Issue
        given().header("X-Atlassian-Token","no-check").pathParam("key",issueId)
                .header("Authorization","Basic Z2F1cmF2a2FkMTNAZ21haWwuY29tOkFUQVRUM3hGZkdGMGFVZnZOREo5eEFPVWdWOFFsVlQ4OVpCV1JrT0pycVdtakpVMkRjUmRWS09BcEptemh1V2xXY2hPNl9SeS16MkU2OW1lbDRfT1lPMU04WGVsb18zV1lzSFNkZFJfNEduUjh4cUVCc0Z2ODBVcTBiMjI3a3hHN01feGhYc1ZNaWJBdFJjS25HVlZ5Z2l3UkR2akdyQVJMSGdERnJvdENHZGRoenlJdlVHWURfWT0xQTJCNThFMQ==")
                .multiPart("file",new File("C:\\Users\\gaura\\Desktop\\img.jpeg"))
                .post("/rest/api/3/issue/{key}/attachments")
                .then().assertThat().statusCode(200).extract().response().asString();
    }
}
