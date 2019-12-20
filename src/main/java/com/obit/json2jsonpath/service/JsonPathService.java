package com.obit.json2jsonpath.service;

import java.util.List;
import org.json.JSONObject;

public interface JsonPathService {

    List<String> generateJsonPaths(JSONObject json);
}
