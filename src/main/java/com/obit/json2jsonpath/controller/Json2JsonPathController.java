package com.obit.json2jsonpath.controller;

import com.obit.json2jsonpath.component.JsonPathResponse;
import com.obit.json2jsonpath.service.JsonPathService;
import java.util.Arrays;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Json2JsonPathController {

    private static final String JSON_2_JSON_PATH_BASE_URL = "/json2jsonPath";

    private final JsonPathService jsonPathService;

    @Autowired
    public Json2JsonPathController(JsonPathService jsonPathService) {
        this.jsonPathService = jsonPathService;
    }

    @CrossOrigin
    @PostMapping(JSON_2_JSON_PATH_BASE_URL)
    public JsonPathResponse generateJsonPaths(@RequestBody String json) {
        try {
            return JsonPathResponse.builder()
                    .jsonPaths(jsonPathService.generateJsonPaths(new JSONObject(json))).build();
        } catch (Exception e) {
            return JsonPathResponse.builder().errors(Arrays.asList(e.getMessage())).build();
        }
    }
}
