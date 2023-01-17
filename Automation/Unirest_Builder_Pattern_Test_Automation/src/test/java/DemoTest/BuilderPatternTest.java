package DemoTest;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.example.Product;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BuilderPatternTest {

    @Test
    public void postTest() throws UnirestException {
        Product phone =Product.builder()
                .category("Smart Phone")
                .id(generateRandomId())
                .title("I phone a+")
                .brand("Apple")
                .build();
        System.out.println(phone);

        String body = new Gson().toJson(phone);

        //HttpResponse<String> Unirest;
        HttpResponse<String> response
                = Unirest.post("https://dummyjson.com/products/add").body(body)
                .asString();
        String myObj = response.getBody();
        // extract fields from the object
        String msg = myObj.toString();

        System.out.println("Create :" +msg);
        // System.out.println(jsonResponse);
        assertEquals(200, response.getStatus());

    }
    @Test
    public void putTest() throws UnirestException {
        Product phone =Product.builder()
                .category("Ana lock Phone")
                .title("Nokia 1010")
                .brand("Nokia")
                .build();

        String body = new Gson().toJson(phone);

        //HttpResponse<String> Unirest;
        HttpResponse<String> response
                = Unirest.put("https://dummyjson.com/products/1").body(body)
                .asString();
        String myObj = response.getBody();
        // extract fields from the object
        String msg = myObj.toString();

        System.out.println("Update :" +msg);
        // System.out.println(jsonResponse);
        assertEquals(200, response.getStatus());

    }
//    @Test
//    public void getTest() throws UnirestException {
//
//        System.out.println(phone);
//        //HttpResponse<String> Unirest;
//        HttpResponse<JsonNode> response
//                = Unirest.post("https://dummyjson.com/products")
//                .header("accept", "application/json")
//                .asJson();
//        String myObj = response.getBody();
//        // extract fields from the object
//        String msg = myObj.toString();
//
//        System.out.println("Create :" +msg);
//        // System.out.println(jsonResponse);
//        assertEquals(200, response.getStatus());
//
//    }
    public String generateRandomId(){
        return String.valueOf(new Faker().number().digits(4));
    }

}
