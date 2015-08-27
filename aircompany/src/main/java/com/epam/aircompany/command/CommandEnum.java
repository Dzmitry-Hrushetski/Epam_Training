/**
 * 
 */
package com.epam.aircompany.command;

/**
 * @author Dzmitry Hrushetski
 *
 */
public enum CommandEnum {
	NO_COMMAND (new NoCommand()),
	LANGUAGE_COMMAND (new LanguageCommand()),
	LOGIN_COMMAND (new LoginCommand()),
	CHEEF_COMMAND (new CheefCommand()),
	POSITION_COMMAND (new PositionCommand()),
	LOGOUT_COMMAND (new LogoutCommand()),
	CREATE_EMPLOYEE_COMMAND (new CreateNewEmployeeCommand()),
	ADMIN_COMMAND (new AdminCommand());
	
	private ICommand command;
	
	private CommandEnum(ICommand command) {
		this.command = command;
	}
	
	public ICommand getCommand() {
		return command;
	}
}
