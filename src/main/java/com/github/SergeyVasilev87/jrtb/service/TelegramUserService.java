package com.github.SergeyVasilev87.jrtb.service;

import com.github.SergeyVasilev87.jrtb.repository.entity.TelegramUser;

import java.util.List;
import java.util.Optional;

public interface TelegramUserService {

    void save(TelegramUser telegramUser);

    List<TelegramUser> retrieveAllActiveUser();

    Optional<TelegramUser> findByChatId(String chatId);
}
