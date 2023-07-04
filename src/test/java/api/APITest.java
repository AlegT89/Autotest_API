package api;


import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class APITest {

    private final static String URL = "https://reqres.in/";

    @Test
    public void checkAvatarAndIdTest(){
        List<UserData> users = given()
                .when()
                .contentType(ContentType.JSON)
                .get(URL + "api/users?page=2")// основные http methods (put, post)
                .then().log().all()
                .extract()
                .body()
                .jsonPath()
                .getList("data", UserData.class);
        for (UserData x : users) {
           Assert.assertTrue(x.getAvatar().contains(x.getId().toString()));

        }

    }

}
