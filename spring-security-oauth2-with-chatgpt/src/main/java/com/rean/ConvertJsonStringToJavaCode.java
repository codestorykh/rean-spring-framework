package com.rean;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class ConvertJsonStringToJavaCode {

    public static void main(String[] args) {
        ConvertJsonStringToJavaCode.a();
    }

    public static void a() {
        String jsonString = "{\"name\":\"John\",\"age\":30,\"city\":\"New York\"}";

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            JsonNode root = objectMapper.readTree(jsonString);
            StringBuilder sb = new StringBuilder();
            sb.append("public class GeneratedClass {\n");
            root.fieldNames().forEachRemaining(fieldName -> {
                JsonNode fieldValue = root.get(fieldName);
                String type = getType(fieldValue);
                sb.append("\tprivate " + type + " " + fieldName + ";\n");
            });
            sb.append("}");
            System.out.println(sb.toString());
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    private static String getType(JsonNode fieldValue) {
        switch (fieldValue.getNodeType()) {
            case NUMBER:
                return "int";
            case STRING:
                return "String";
            default:
                return "Object";
        }
    }

}
