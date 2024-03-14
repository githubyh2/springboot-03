package com.example.springboot03.util;


import okhttp3.*;

/**
 * @author yanhao
 * @data 2024/3/13
 * 飞书邮件告警
 */
public class LarkMessageSenderUtil {
    public static void sendLarkMessage() {
        String webhookUrl = "https://open.feishu.cn/open-apis/bot/v2/hook/your-webhook-url"; // 替换为你的 Webhook URL

        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{ \"msg_type\": \"text\", \"content\": { \"text\": \"Hello from Java!\" } }");
        Request request = new Request.Builder()
                .url(webhookUrl)
                .post(body)
                .addHeader("Content-Type", "application/json")
                .build();

        try {
            Response response = client.newCall(request).execute();
            System.out.println("Message sent to Feishu successfully!");
            System.out.println("Response: " + response.body().string());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to send message to Feishu: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        sendLarkMessage();
    }
}
