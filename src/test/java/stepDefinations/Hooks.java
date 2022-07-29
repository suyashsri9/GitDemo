package stepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@DeletePlace")
	public void beforeScenario() throws IOException
	{
		StepDefination m = new StepDefination();
		if(StepDefination.place_id == null)
		{
		
		m.add_place_payload_with("shetty", "Spanish", "Agra");
		m.user_calls_with_http_request("AddPlaceAPI", "POST");
		m.verify_palce_id_is_created_maps_to_using("shetty", "getPlcaeAPI");
		}
		
	}

}
