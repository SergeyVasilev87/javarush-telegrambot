package com.github.SergeyVasilev87.jrtb;

import com.github.SergeyVasilev87.jrtb.command.Command;
import com.github.SergeyVasilev87.jrtb.command.NoCommand;
import org.junit.jupiter.api.DisplayName;

import static com.github.SergeyVasilev87.jrtb.command.CommandName.NO;
import static com.github.SergeyVasilev87.jrtb.command.NoCommand.NO_MESSAGE;

@DisplayName("Unit-level testing for NoCommand")
public class NoCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return NO.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return NO_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new NoCommand(sendBotMessageService);
    }
}
