import configRick.BaseClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.when;

public class TestDimension extends BaseClass {
    static String baseURL = "location";

    @Test
    public void test1() {
        List<String> str=  when()
                .get(baseURL).then().extract().jsonPath().getList("results.dimension",String.class);
        System.out.println(str);
    }
}
