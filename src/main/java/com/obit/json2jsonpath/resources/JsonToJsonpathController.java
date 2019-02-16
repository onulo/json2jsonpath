package com.obit.json2jsonpath.resources;

import com.obit.json2jsonpath.services.Json2JsonPathGenerator;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class JsonToJsonpathController {

    @Autowired
    private Json2JsonPathGenerator jsonPathGenerator;

    @GetMapping("/")
    public String getJsonToString() {
        return "welcome";

    }

    @PostMapping("/")
    public String postJson(@RequestParam String json, Model model) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            List<String> output = jsonPathGenerator.generate(jsonObject);
            model.addAttribute("output", output);
            model.addAttribute("json", jsonObject.toString(3));
        } catch (Exception e) {
            model.addAttribute("json", json);
            model.addAttribute("error", e.getMessage());
        }


        return "welcome";
    }

}
