package com.ssafy.alcohol.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatGPTRestController {


	@Value("${VITE_CHATGPT_API_KEY}")
    private String API_KEY;

    private static String GPT_URL = "https://api.openai.com/v1/chat/completions";
    private static final int MAX_RETRIES = 5;
    private static final int INITIAL_RETRY_DELAY = 2000;

    @GetMapping("/gpt/{region}/{name}")
    public ResponseEntity<?> getGPT(@PathVariable("region") String region, @PathVariable("name") String name) throws Exception {
        int retryCount = 0;
        int retryDelay = INITIAL_RETRY_DELAY;

        while (retryCount < MAX_RETRIES) {
            try {
                URL url = new URL(GPT_URL);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setRequestProperty("Authorization", "Bearer " + API_KEY);
                connection.setDoInput(true);
                connection.setDoOutput(true);

                JSONObject data = new JSONObject();
                data.put("model", "gpt-3.5-turbo");
                data.put("temperature", 0.7);

                JSONObject message = new JSONObject();
                message.put("role", "user");
                message.put("content", region + " " + name + "과 어울리는 안주 추천해줘. 형식은 (메뉴명) : (설명) 으로 셜명은 한줄평으로 5개 부탁할게");

                JSONArray messages = new JSONArray();
                messages.put(message);

                data.put("messages", messages);

                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
                bw.write(data.toString());
                bw.flush();
                bw.close();

                int responseCode = connection.getResponseCode();

                if (responseCode == 429) {
                    retryCount++;
                    Thread.sleep(retryDelay);
                    retryDelay *= 2; 
                    continue;
                } else if (responseCode != 200) {
                    return new ResponseEntity<>("HTTP error code: " + responseCode, HttpStatus.INTERNAL_SERVER_ERROR);
                }

                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line;

                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }

                return new ResponseEntity<>(sb.toString(), HttpStatus.OK);

            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<>("Failed after multiple retries", HttpStatus.TOO_MANY_REQUESTS);
    }
}
