package com.obit.json2jsonpath.component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public final class JsonPathGenerator {

    private static final String PREFIX = "$.";
    private static final String DELIMITER = ".";
    private static final String EQUALS = "=";

    private final JSONObject json;

    private final List<PathElement> pathElements = new ArrayList<>();
    private final List<String> results = new ArrayList<>();

    public static JsonPathGenerator from(JSONObject json) {
        return new JsonPathGenerator(json);
    }

    public List<String> generate() {
        process(json);
        return Collections.unmodifiableList(results);
    }

    private void process(final JSONObject jsonObject) {
        jsonObject.keys().forEachRemaining(jsonElementName -> {

            pathElements.add(new PathElement(jsonElementName));
            final Object jsonElement = jsonObject.get(jsonElementName);

            if (jsonElement instanceof JSONObject) {
                process((JSONObject) jsonElement);
            } else if (isComplexJsonArray(jsonElement)) {
                for (Object arrayElement : (JSONArray) jsonElement) {
                    if (arrayElement instanceof JSONObject) {
                        incrementArrayIndexInPathElement();
                        process((JSONObject) arrayElement);
                    } else {
                        appendFormattedPath(arrayElement.toString());
                    }
                }
            } else {
                appendFormattedPath(jsonElement.toString());
            }
            removeLastElement(pathElements);
        });
    }

    private void incrementArrayIndexInPathElement() {
        Integer arrayIndex = pathElements.get(pathElements.size() - 1).getArrayIndex();
        if (arrayIndex == null) {
            arrayIndex = 0;
        } else {
            arrayIndex++;
        }
        pathElements.get(pathElements.size() - 1).setArrayIndex(arrayIndex);
    }

    private static boolean isComplexJsonArray(Object jsonObject) {
        return (jsonObject instanceof JSONArray) && !((JSONArray) jsonObject).isEmpty() && (((JSONArray) jsonObject)
                .get(0) instanceof JSONObject);
    }

    private static void removeLastElement(List<?> list) {
        list.remove(list.size() - 1);
    }

    private void appendFormattedPath(String value) {
        final StringBuilder formattedPath = new StringBuilder();
        formattedPath.append(PREFIX);

        int pathElementIndex = 0;
        for (PathElement pathElement : pathElements) {
            formattedPath.append(pathElement.getName());

            if (pathElement.getArrayIndex() != null) {
                formattedPath.append("[" + pathElement.getArrayIndex() + "]");
            }

            if (pathElementIndex != (pathElements.size() - 1)) {
                formattedPath.append(DELIMITER);
            }
            pathElementIndex++;
        }
        formattedPath.append(EQUALS);
        formattedPath.append(value);
        results.add(formattedPath.toString());
    }
}
