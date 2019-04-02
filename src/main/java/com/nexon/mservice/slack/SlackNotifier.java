package com.nexon.mservice.slack;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nexon.mservice.slack.define.SlackColor;
import com.nexon.mservice.slack.model.SlackAttachment;
import com.nexon.mservice.slack.model.SlackMessage;
import com.nexon.mservice.slack.util.HttpEntityEncoder;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class SlackNotifier {

    private final String webHookUrl;

    private RestTemplate restTemplate = new RestTemplate();

    private static ObjectMapper objectMapper = new ObjectMapper();

    public SlackNotifier(String webHookUrl) {
        this.webHookUrl = webHookUrl;
    }

    /**
     * 기본 노티
     *
     * */
    public void notify(String text) throws Exception {
        SlackMessage slackMessage = new SlackMessage();
        slackMessage.text = text;
        sendMessage(slackMessage);
    }

    /**
     * 심플 노티
     *
     * */
    public void notifySimple(SlackColor color, String text, String author, String innerTitle, String innerText) throws Exception {
        SlackAttachment attachment = new SlackAttachment();
        attachment.color = color.getMessage();
        attachment.author_name = author;
        attachment.title = innerTitle;
        attachment.text = innerText;
        List<SlackAttachment> attachments = Arrays.asList(attachment);

        SlackMessage slackMessage = new SlackMessage();
        slackMessage.text = text;
        slackMessage.attachments = attachments;

        sendMessage(slackMessage);
    }

    /**
     * 커스텀 노티
     *
     * */
    public void notifyCustom(String stringOfJson) throws Exception {
        try {
            SlackMessage slackMessage = objectMapper.readValue(stringOfJson, new TypeReference<SlackMessage>(){});
            sendMessage(slackMessage);
        } catch (Exception e) {
            throw e;
        }
    }

    private void sendMessage(SlackMessage slackMessage) throws Exception {
        try {
            String stringOfMessage = objectMapper.writeValueAsString(slackMessage);
            restTemplate.postForEntity(webHookUrl, HttpEntityEncoder.encode(stringOfMessage), String.class);
        } catch (Exception e) {
            throw e;
        }
    }

}
