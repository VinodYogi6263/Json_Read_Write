package com.ss;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ss.entity.User;

@SpringBootApplication
public class JsonApplication {

	public static void main(String[] args) throws IOException, ParseException {
		SpringApplication.run(JsonApplication.class, args);
		try {
			TypeReference<List<User>> typeReference = new TypeReference<List<User>>() {
			};
			InputStream inputStream = new FileInputStream(new File("D:\\Check.json"));
			//FileWriter fileWriter = new FileWriter("D:\\Check.json", false);

			List<User> user = new ObjectMapper().readValue(inputStream, typeReference);
			if (user != null && !user.isEmpty()) {
				List<User> userList = new ArrayList<>();
				user.forEach(obje -> userList
						.add(new User(obje.getId(), obje.getUserId(), obje.getBody(), obje.getTitle())));
				JSONArray array = new JSONArray();
				for (User user1 : userList) {
//					JSONObject jsonObject = new JSONObject();
//					jsonObject.put("id", user1.getId());
//					jsonObject.put("userId", user1.getUserId());
//					jsonObject.put("body", user1.getBody());
//					jsonObject.put("title", user1.getTitle());
//					array.add(jsonObject);
					System.out.println(user1);

				}
				//fileWriter.write(array.toJSONString());

				//fileWriter.close();
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}
}