package com.nexon.mservice.slack.define;

public enum SlackColor {

    TRACE("#808080"), /*gray*/
    DEBUG("#00FF00"), /*green*/
    INFO("#0000FF"), /*blue*/
    WARN("#FFFF00"), /*yellow*/
    ERROR("#FFA500"), /*orange*/
    FATAL("#FF0000"); /*red*/

    private final String message;

    SlackColor(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}
