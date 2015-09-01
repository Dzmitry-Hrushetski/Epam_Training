package com.epam.aircompany.command;

/**
 * The Enum CommandEnum commands of application.
 *
 * @author Dzmitry Hrushetski
 */
public enum CommandEnum {
	NO_COMMAND (new NoCommand()),
	LANGUAGE_COMMAND (new LanguageCommand()),
	LOGIN_COMMAND (new LoginCommand()),
	CHEEF_COMMAND (new CheefCommand()),
	LOGOUT_COMMAND (new LogoutCommand()),
	CREATE_EMPLOYEE_COMMAND (new CreateNewEmployeeCommand()),
	ADMIN_COMMAND (new AdminCommand()),
	MANAGER_COMMAND (new ManagerCommand()),
	NEW_ROUTE_COMMAND(new NewRouteCommand());
	
	private ICommand command;
	
	/**
	 * Instantiates a new command enum.
	 *
	 * @param command the command
	 */
	private CommandEnum(ICommand command) {
		this.command = command;
	}
	
	/**
	 * Gets the command.
	 *
	 * @return the command
	 */
	public ICommand getCommand() {
		return command;
	}
}
