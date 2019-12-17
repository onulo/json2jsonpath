package com.obit.json2jsonpath.controller;

import com.obit.json2jsonpath.services.JsonPathService;
import java.util.List;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("/")
public class Json2JsonPathController {

    private final JsonPathService jsonPathService;

    @Autowired
    public Json2JsonPathController(JsonPathService jsonPathService) {
        this.jsonPathService = jsonPathService;
    }

    @GetMapping
    public String getMainPage() {
        return "index";
    }

    @PostMapping
    public String postJson(@RequestParam String json, Model model) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            List<String> output = jsonPathService.generateJsonPaths(jsonObject);
            model.addAttribute("output", output);
            model.addAttribute("json", jsonObject.toString(3));
        } catch (Exception e) {
            model.addAttribute("json", json);
            model.addAttribute("error", e.getMessage());
        }
        return "index";
    }
}
