package com.github.SergeyVasilev87.jrtb;

import com.github.SergeyVasilev87.jrtb.command.Command;
import com.github.SergeyVasilev87.jrtb.command.CommandContainer;
import com.github.SergeyVasilev87.jrtb.command.CommandName;
import com.github.SergeyVasilev87.jrtb.command.UnknownCommand;
import com.github.SergeyVasilev87.jrtb.service.SendBotMessageService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

@DisplayName("Unit-level testing for CommandContainer")
public class CommandContainerTest {

    private CommandContainer commandContainer;

    @BeforeEach
    public void init() {
        SendBotMessageService sendBotMessageService = Mockito.mock(SendBotMessageService.class);
        commandContainer = new CommandContainer(sendBotMessageService);
    }

    @Test
    public void shouldGetAllTheExistingCommands() {
        //when-then
        Arrays.stream(CommandName.values()).forEach(command -> {
            Command commandCheck = commandContainer.retrieveCommand(command.getCommandName());
            Assertions.assertNotEquals(UnknownCommand.class, commandCheck.getClass());
        });
    }

    @Test
    public void shouldReturnUnknownCommand() {
        //given
        String unknownCommand = "/sacdcsdc";

        //when
        Command command = commandContainer.retrieveCommand(unknownCommand);

        //then
        Assertions.assertEquals(UnknownCommand.class, command.getClass());
    }

}
