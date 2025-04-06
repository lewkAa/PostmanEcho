package ru.netology.test;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

class EchoPostTest {

    @Test
    void EchoPostmanTest() {
        // Given - When - Then
// Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .body("Alex")
                .queryParam("active", true)
                .when()
                .post("/post")
// Проверки
                .then()
                .statusCode(200)
                .body("data", equalTo("Alex"))
                .body("args.active", equalTo("true"))
                .body("url", equalTo("https://postman-echo.com/post?active=true"));

    }
}
