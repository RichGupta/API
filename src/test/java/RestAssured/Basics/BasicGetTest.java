package RestAssured.Basics;

import org.testng.annotations.Test;
import org.testng.asserts.*;
import org.testng.*;

public class BasicGetTest extends BasicGet
{
    @Test
    public void testCases(){
    	getWeatherDetails();
//        getWeather();
    }
}
