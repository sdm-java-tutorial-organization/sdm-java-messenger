package com.nexon.mservice.slack.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.nio.charset.Charset;

public class HttpEntityEncoder {

    private static HttpHeaders headers = new HttpHeaders();

    static {
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
    }

    public static HttpEntity encode(String message) {
       return new HttpEntity<String>(message, headers);
    }

}
