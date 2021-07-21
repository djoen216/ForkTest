package TestNG;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.Iterator;
import java.util.List;

public class apiForkTest {
	
	private static final String BASE_URL = "https://pokeapi.co/api/v2/";
	private static Response response;
	private static String jsonString;
	private static String type;
	private List<String> normalPokemon;
	private List<String> Pokemon;
	
	@Test
	public void getpokemons() {
		RestAssured.baseURI = BASE_URL;
		response = RestAssured.given().get("/pokemon?limit=30");
		jsonString = response.asString();
		
		List<String> urls = JsonPath.from(jsonString).get("results.url");
		Assert.assertTrue(urls.size()>0);
		
		for (Iterator iterator = urls.iterator(); iterator.hasNext();) {
			String purl = (String) iterator.next();
			response = RestAssured.get(purl);
			jsonString = response.asString();
			Pokemon = JsonPath.from(jsonString).get("types.type.name");
			type = Pokemon.get(0);
			System.out.println(type);
			
			if (type == "normal") {
				normalPokemon.add("test");
				
			}
		}
		
	}
}
