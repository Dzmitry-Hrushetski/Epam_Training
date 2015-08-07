/**
 * 
 */
package com.epam.web.aircompany.command;

/**
 * @author Dzmitry Hrushetski
 *
 */
public enum CommandEnum {
	NO_COMMAND (new NoCommand());
	
	private ICommand command;
	
	private CommandEnum(ICommand command) {
		this.command = command;
	}
	
	public ICommand getCommand() {
		return command;
	}
}
