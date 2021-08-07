package com.github.SergeyVasilev87.jrtb.command;

import com.github.SergeyVasilev87.jrtb.repository.entity.TelegramUser;
import com.github.SergeyVasilev87.jrtb.service.SendBotMessageService;
import com.github.SergeyVasilev87.jrtb.service.TelegramUserService;
import org.springframework.data.util.Optionals;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Optional;

public class StartCommand implements Command {

    private final SendBotMessageService sendBotMessageService;
    private final TelegramUserService telegramUserService;

    public final static String START_MESSAGE = "Привет. Я Javarush Telegram Bot. Я помогу тебе быть в курсе последних " +
            "статей тех авторов, котрые тебе интересны. Я еще маленький и только учусь.";

    public StartCommand(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService) {
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public void execute(Update update) {
        String chatId = update.getMessage().getChatId().toString();

        if (telegramUserService.findByChatId(chatId).isPresent()) {
            TelegramUser telegramUser = telegramUserService.findByChatId(chatId).get();
            telegramUser.setActive(true);
            telegramUserService.save(telegramUser);
        } else {
            TelegramUser telegramUser = new TelegramUser();
            telegramUser.setActive(true);
            telegramUser.setChatId(chatId);
            telegramUserService.save(telegramUser);
        }

        sendBotMessageService.sendMessage(chatId, START_MESSAGE);
    }
}
