package com.github.SergeyVasilev87.jrtb;

import com.github.SergeyVasilev87.jrtb.bot.JavaRushTelegramBot;
import com.github.SergeyVasilev87.jrtb.command.Command;
import com.github.SergeyVasilev87.jrtb.repository.TelegramUserRepository;
import com.github.SergeyVasilev87.jrtb.service.SendBotMessageService;
import com.github.SergeyVasilev87.jrtb.service.SendBotMessageServiceImpl;
import com.github.SergeyVasilev87.jrtb.service.TelegramUserService;
import com.github.SergeyVasilev87.jrtb.service.TelegramUserServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

abstract class AbstractCommandTest {

    protected JavaRushTelegramBot javaRushBot = Mockito.mock(JavaRushTelegramBot.class);
    protected SendBotMessageService sendBotMessageService = new SendBotMessageServiceImpl(javaRushBot);
    protected TelegramUserService telegramUserService = Mockito.mock(TelegramUserService.class);

    abstract String getCommandName();
    abstract String getCommandMessage();
    abstract Command getCommand();

    @Test
    public void shouldProperlyExecuteCommand() throws TelegramApiException {
        //given
        Long chatId = 1234567824356L;

        Update update = new Update();
        Message message = Mockito.mock(Message.class);
        Mockito.when(message.getChatId()).thenReturn(chatId);
        Mockito.when(message.getText()).thenReturn(getCommandName());
        update.setMessage(message);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId.toString());
        sendMessage.setText(getCommandMessage());
        sendMessage.enableHtml(true);

        //when
        getCommand().execute(update);

        //then
        Mockito.verify(javaRushBot).execute(sendMessage);
    }
}
