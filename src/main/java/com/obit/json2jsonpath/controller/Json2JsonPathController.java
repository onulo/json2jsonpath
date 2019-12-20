package com.obit.json2jsonpath.controller;

import com.obit.json2jsonpath.service.JsonPathService;
import java.util.List;
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
    public List<String> generateJsonPaths(@RequestBody String json) {
        return jsonPathService.generateJsonPaths(new JSONObject(json));
    }
}
