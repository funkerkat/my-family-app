package com.familycode.telegram;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;

public class FamilyAppTelegramBot {

    public static void main(String[] args) {

        String TOKEN = "";
        TelegramBot bot = new TelegramBot(TOKEN);

        bot.setUpdatesListener(updates -> {
            updates.forEach(System.out::println);
            updates.forEach(update -> {
                long chatId = update.message().chat().id();
                String message = update.message().text();
                SendResponse response = bot.execute(new SendMessage(chatId, "echo... " + message));
            });

            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });
    }
}
