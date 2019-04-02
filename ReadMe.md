# slack notifier

## 사용법

```java
com.nexon.mservice.slack.SlackNotifier slackNotifier = new com.nexon.mservice.slack.SlackNotifier(<SlackUrl>);
slackNotifier.notify("hello slack?");
```

## 함수종류

- void notify(String text)

```java
slackNotifier.notify("hello slack?");
```

- void notifySimple(SlackColor color, String text, String author, String innerTitle, String innerText)

```java
slackNotifier.notifySimple(
        SlackColor.INFO, 
        "hello slack?", 
        "nexon_man", 
        "slack lib.", 
        "this is slack lib.");
```

- void notifyCustom(String stringOfJson)

```java
slackNotifier.notifyCustom("{\"text\":\"hello slack?\"}")
```

## 색상

- SlackColor.TRACE (gray)
- SlackColor.DEBUG (green)
- SlackColor.INFO (blue)
- SlackColor.WARN (yellow)
- SlackColor.ERROR (orange)
- SlackColor.FATAL (red)
