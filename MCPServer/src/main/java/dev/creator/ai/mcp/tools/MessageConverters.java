package dev.creator.ai.mcp.tools;
//
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.ai.tool.execution.ToolCallResultConverter;
//import org.springframework.stereotype.Service;
//
//import java.lang.reflect.Type;
//
//public class MessageConverters implements ToolCallResultConverter {
//
//    private final ObjectMapper mapper = new ObjectMapper();
//
//    @Override
//    public String convert(Object result, Type returnType) {
//        JsonNode node = mapper.valueToTree(result);
//        System.out.println(node.toPrettyString());
//        return node.toPrettyString();
//    }
//}
