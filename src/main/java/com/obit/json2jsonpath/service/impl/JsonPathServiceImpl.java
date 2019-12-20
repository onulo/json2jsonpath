package com.obit.json2jsonpath.service.impl;

import com.obit.json2jsonpath.component.JsonPathGenerator;
import com.obit.json2jsonpath.service.JsonPathService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JsonPathServiceImpl implements JsonPathService {

    @Override
    public List<String> generateJsonPaths(JSONObject json) {
        final List<String> jsonPaths = JsonPathGenerator.from(json).generate();
        log.info("Generating json paths for json object SUCCESSFUL. json object: {}, generated json paths: {}", json, jsonPaths);
        return jsonPaths;
    }
}
