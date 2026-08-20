package Files;

public class Payload {
    public static String addBook(){
        String addPlacePayload ="{\n" +
                "  \"email\": \"GauravKad1234567890@example.com\",\n" +
                "  \"password\": \"secret123\"\n" +
                "}" ;
        return addPlacePayload;
    }

    public static String jsonPayload(){
        return "{\n" +
                "   \"dashboard\":{\n" +
                "      \"purchaseAmount\":910,\n" +
                "      \"website\":\"rahulshettyacademy.com\"\n" +
                "   },\n" +
                "   \"courses\":[\n" +
                "      {\n" +
                "         \"title\":\"Selenium Python\",\n" +
                "         \"price\":50,\n" +
                "         \"copies\":6\n" +
                "      },\n" +
                "      {\n" +
                "         \"title\":\"Cypress\",\n" +
                "         \"price\":40,\n" +
                "         \"copies\":4\n" +
                "      },\n" +
                "      {\n" +
                "         \"title\":\"RPA\",\n" +
                "         \"price\":45,\n" +
                "         \"copies\":10\n" +
                "      }\n" +
                "   ]\n" +
                "}";
    }
}
