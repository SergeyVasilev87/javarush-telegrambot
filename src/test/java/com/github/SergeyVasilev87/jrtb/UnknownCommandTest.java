package com.github.SergeyVasilev87.jrtb;

import com.github.SergeyVasilev87.jrtb.command.Command;
import com.github.SergeyVasilev87.jrtb.command.UnknownCommand;
import org.junit.jupiter.api.DisplayName;

import static com.github.SergeyVasilev87.jrtb.command.UnknownCommand.UNKNOWN_MESSAGE;

@DisplayName("Unit-level testing for UnknownCommand")
public class UnknownCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return "cssdcwvf";
    }

    @Override
    String getCommandMessage() {
        return UNKNOWN_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new UnknownCommand(sendBotMessageService);
    }
}
