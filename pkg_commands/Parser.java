package pkg_commands;

import java.util.StringTokenizer;
import java.util.HashMap;

import pkg_commands.AleaCommand;
import pkg_commands.BackCommand;
import pkg_commands.Command;
import pkg_commands.CommandWord;
import pkg_commands.DropCommand;
import pkg_commands.EatCommand;
import pkg_commands.GoCommand;
import pkg_commands.HelpCommand;
import pkg_commands.ItemsCommand;
import pkg_commands.LoadCommand;
import pkg_commands.LookCommand;
import pkg_commands.QuitCommand;
import pkg_commands.TakeCommand;
import pkg_commands.TestCommand;
import pkg_commands.UnknownCommand;
import pkg_commands.UseCommand;
import pkg_commands.TalkCommand;
//import pkg_commands.CommandWords;
/**
 * This class is part of "World of Zuul". "World of Zuul" is a simple,
 * text based adventure game.
 *
 * This parser takes user input and tries to interpret it as a "Zuul"
 * command. Every time it is called it takes a line as a String and
 * tries to interpret the line as a two word command. It returns the command
 * as an object of class Command.
 *
 * The parser has a set of known command words. It checks user input against
 * the known commands, and if the input is not one of the known commands, it
 * returns a command object that is marked as an unknown command.
 *
 * @author  Michael Kolling and David J. Barnes
 * @version 2.0 (Jan 2003) DB edited (2019) Edited by Pierre-Yves PITIOT (21/04/2020)
 */

public class Parser
{

    private CommandWords aCommandWords;  // holds all valid command words
    private HashMap<CommandWord, Command> aCommands;

    /**
     * Create a new Parser.
     */
    public Parser()
    {
        this.aCommandWords = new CommandWords();
        this.aCommands = new HashMap<CommandWord, Command>();

        this.aCommands.put(CommandWord.GO,new GoCommand());
        this.aCommands.put(CommandWord.UNKNOWN,new UnknownCommand());
        this.aCommands.put(CommandWord.HELP,new HelpCommand());
        this.aCommands.put(CommandWord.QUIT,new QuitCommand());
        this.aCommands.put(CommandWord.LOOK,new LookCommand());
        this.aCommands.put(CommandWord.EAT,new EatCommand());
        this.aCommands.put(CommandWord.BACK,new BackCommand());
        this.aCommands.put(CommandWord.TEST,new TestCommand());
        this.aCommands.put(CommandWord.TAKE,new TakeCommand());
        this.aCommands.put(CommandWord.DROP,new DropCommand());
        this.aCommands.put(CommandWord.ITEMS,new ItemsCommand());
        this.aCommands.put(CommandWord.USE,new UseCommand());
        this.aCommands.put(CommandWord.LOAD,new LoadCommand());
        this.aCommands.put(CommandWord.ALEA,new AleaCommand());
        this.aCommands.put(CommandWord.TALK,new TalkCommand());
    } // Parser()

    /**
     * Get a new command from the user. The command is read by
     * parsing the 'inputLine'.
     */
    public Command getCommand(final String pInputLine)
    {
        String vWord1;
        String vWord2;

        StringTokenizer tokenizer = new StringTokenizer( pInputLine );

        if ( tokenizer.hasMoreTokens() )
            vWord1 = tokenizer.nextToken();      // get first word
        else
            vWord1 = null;

        if ( tokenizer.hasMoreTokens() )
            vWord2 = tokenizer.nextToken();      // get second word
        else
            vWord2 = null;

        // note: we just ignore the rest of the input line.


        Command vCommand = this.aCommands.get(aCommandWords.getCommandWord(vWord1));
        vCommand.setSecondWord(vWord2);
        return vCommand;
    } // getCommand(.)

    /**
     * Returns a String with valid command words.
     */
    public String getCommandString() // was showCommands()
    {
        return this.aCommandWords.getCommandList();
    } // getCommandString()

} // Parser
