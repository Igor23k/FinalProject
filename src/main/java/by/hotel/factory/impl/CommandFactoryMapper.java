package by.hotel.factory.impl;

import by.hotel.command.ICommand;
import by.hotel.command.impl.*;
import by.hotel.factory.ICommandFactory;

import java.util.HashMap;
import java.util.Map;

public final class CommandFactoryMapper implements ICommandFactory {
    final private static Map<String, ICommand> commands = new HashMap();

    static {
        commands.put("GET_ALL", new GetAllEntities());
        commands.put("ADD", new AddEntity());
        commands.put("REMOVE", new RemoveEntity());
        commands.put("UPDATE", new UpdateEntity());
        commands.put("ADMIN_START",new GetTableNames());
        commands.put("GET_ALL_HEADERS",new GetEntityHeaders());
        commands.put("AUTHORIZATION", new Authorization());
        commands.put("REGISTRATION", new Registration());
    }

    private static class Holder{
        private final static CommandFactoryMapper INSTANCE = new CommandFactoryMapper();
    }

    public static CommandFactoryMapper getInstance(){
        return Holder.INSTANCE;
    }

    public ICommand getCommand(String commandName) {
        return commands.get(commandName.toUpperCase());
    }
}