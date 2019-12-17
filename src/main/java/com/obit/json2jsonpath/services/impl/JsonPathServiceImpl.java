package com.obit.json2jsonpath.services.impl;

import com.obit.json2jsonpath.component.JsonPathGenerator;
import com.obit.json2jsonpath.services.JsonPathService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JsonPathServiceImpl implements JsonPathService {

    @Override
    public List<String> generateJsonPaths(JSONObject json) {
        JsonPathGenerator jsonPathGenerator = new JsonPathGenerator(json);
        final List<String> jsonPaths = jsonPathGenerator.generate();
        log.info("Generating json paths for json object SUCCESSFUL. json object: {}, generated json paths: {}", json, jsonPaths);
        return jsonPaths;
    }
}
