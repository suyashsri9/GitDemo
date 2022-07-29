package resources;

import java.util.ArrayList;
import java.util.List;


import pojo.Location;
import pojo.Places;

public class TestDataBuild {
	
	public Places addPlacePayload(String name, String language, String address)
	{

		
		Places p =new Places();
		p.setAccuracy(50);
		p.setAddress(address);
		p.setLanguage(language);
		p.setPhone_number("9999999999");
		p.setWebsite("https://");
		p.setName(name);
		List<String> myList= new ArrayList<String>();
		myList.add("Shoe park");
		myList.add("shop");
		p.setTypes(myList);
		Location l =new Location();
		l.setLat(91.91);
		l.setLng(-91.81);
		p.setLocation(l);
		return p;
	}
	
	public String deletePlacepayloadd(String place_id)
	{
		return "{\r\n"
				+ "    \"place_id\":\""+place_id+"\"   	 	\r\n"
				+ "}";
	}

}
