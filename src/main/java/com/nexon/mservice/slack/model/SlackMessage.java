package com.nexon.mservice.slack.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SlackMessage {

    public String text;
    public List<SlackAttachment> attachments;

}