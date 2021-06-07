package com.ewertonilima.webscraping.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Converter {
	//Metodo para converter para JSON
	public static void converterToJson(Object obj) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			String json = mapper.writeValueAsString(obj);
			System.out.println("Object to JSON: " + json);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
