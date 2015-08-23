/**
 * 
 */
package com.epam.web.aircompany.logic;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.epam.web.aircompany.bean.Employee;
import com.epam.web.aircompany.bean.Position;
import com.epam.web.aircompany.dao.IDao;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class EmployeeLogic {
	
	/*public static void prepareCheefJsp(HttpServletRequest request, IDao iDao, Employee employee) {
		
		List<Employee> employeeList = iEmployee.findEmployeeByPositionId(CHEEF);
		List<Position> positionList = iPosition.findAll();
		employee = iEmployee.findEntityByID(employeeList.get(FIRST_EMPLOYEE).getId());
		//request.setAttribute(PARAM_EMPLOYEE_LIST, employeeList);
		//request.setAttribute(PARAM_POSITION_LIST, positionList);
		request.setAttribute(PARAM_EMPLOYEE_ENTITY, employee);
		HttpSession session = request.getSession();
		session.setAttribute(PARAM_EMPLOYEE_LIST, employeeList);
		session.setAttribute(PARAM_POSITION_LIST, positionList);
		
	}*/

}
