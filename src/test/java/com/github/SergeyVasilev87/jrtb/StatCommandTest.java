package com.github.SergeyVasilev87.jrtb;

import com.github.SergeyVasilev87.jrtb.command.Command;
import com.github.SergeyVasilev87.jrtb.command.StatCommand;

import static com.github.SergeyVasilev87.jrtb.command.CommandName.STAT;
import static com.github.SergeyVasilev87.jrtb.command.StatCommand.STAT_MESSAGE;

public class StatCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return STAT.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return String.format(STAT_MESSAGE, 0);
    }

    @Override
    Command getCommand() {
        return new StatCommand(sendBotMessageService, telegramUserService);
    }
}
