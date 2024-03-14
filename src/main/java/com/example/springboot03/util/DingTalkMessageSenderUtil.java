package com.example.springboot03.util;

import okhttp3.*;

/**
 * @author yanhao
 * @data 2024/3/13
 */
public class DingTalkMessageSenderUtil {
    public static void sendDingTalkMessage() {

        // String webhookUrl = "https://oapi.dingtalk.com/robot/send?access_token=your-access-token"; // 替换为你的 Webhook URL
        String webhookUrl = "https://oapi.dingtalk.com/robot/send?access_token=fdd6f6d343bbc25570864a249e371b75f0e774543e9ea7f5cd7c817c38bb2532";

        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        String json = "{\n" +
                "  \"msgtype\": \"text\",\n" +
                "  \"text\": {\n" +
                "    \"content\" : \"Hello from Java!\"\n" +
                "  }\n" +
                "}";
        RequestBody body = RequestBody.create(mediaType, json);
        Request request = new Request.Builder()
                .url(webhookUrl)
                .post(body)
                .addHeader("Content-Type", "application/json")
                .build();

        try {
            Response response = client.newCall(request).execute();
            System.out.println("Message sent to DingTalk successfully!");
            System.out.println("Response: " + response.body().string());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to send message to DingTalk: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        sendDingTalkMessage();
    }
}
