package dev.creator.ai.mcp.mcpclient;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
public class ChatBotController {

    private final ChatClient client;

    public ChatBotController(ChatClient client) {
        this.client = client;
    }

    @PostMapping
    public String chat(@RequestBody String prompt) {
        return client.prompt().user(prompt).call().content();
    }
}
