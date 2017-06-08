package by.hotel.factory.impl;

import by.hotel.command.ICommand;
import by.hotel.command.impl.*;
import by.hotel.factory.ICommandFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * CommandFactoryMapper.java
 * Class implements methods from interface ICommandFactory.
 * getInstance - method to get command  that implements ICommand interface.
 * @author Igor Kozlov
 * @version 2.0
 */
public final class CommandFactoryMapper implements ICommandFactory {
    /**
     * Field -  field to store commands.
     */
    final private static Map<String, ICommand> commands = new HashMap();

    static {
        commands.put("GET_ALL", new GetAllEntities());
        commands.put("GET_ALL_BY_KEY", new GetAllEntitiesByKey());
        commands.put("ADD", new AddEntity());
        commands.put("REMOVE", new RemoveEntity());
        commands.put("UPDATE", new UpdateEntity());
        commands.put("ADMIN_START",new GetTableNames());
        commands.put("GET_ALL_HEADERS",new GetEntityHeaders());
        commands.put("AUTHORIZATION", new Authorization());
        commands.put("REGISTRATION", new Registration());
        commands.put("CREATE_DOC", new CreateDocument());
    }

    /**
     * Holder.java
     * This internal class is a template Singleton.
     * @author Igor Kozlov
     * @version 1.0
     */
    private static class Holder{
        /**
         * Field - this field need to be singleton of CommandFactoryMapper class.
         */
        private final static CommandFactoryMapper INSTANCE = new CommandFactoryMapper();
    }

    /**
     * Get a singleton object.
     * @return singleton object.
     */
    public static CommandFactoryMapper getInstance(){
        return Holder.INSTANCE;
    }

    /**
     * Get a command by name.
     * @param commandName the operand to get an operation.
     * @return command that implements interface ICommand.
     */
    public ICommand getCommand(String commandName) {
        return commands.get(commandName.toUpperCase());
    }
}