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
	LOGOUT_COMMAND (new LogoutCommand()),
	CREATE_EMPLOYEE_COMMAND (new CreateNewEmployeeCommand()),
	ADMIN_COMMAND (new AdminCommand()),
	MANAGER_COMMAND (new ManagerCommand()),
	NEW_ROUTE_COMMAND(new NewRouteCommand());
	
	private ICommand command;
	
	private CommandEnum(ICommand command) {
		this.command = command;
	}
	
	public ICommand getCommand() {
		return command;
	}
}
