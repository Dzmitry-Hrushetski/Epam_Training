package com.epam.aircompany.filter;

import java.io.IOException;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.aircompany.constant.ClientType;


/**
 * Servlet Filter implementation class ServletFilter
 */
public class ServletFilter implements Filter {
	private String indexPath;

    /**
     * Default constructor. 
     */
    public ServletFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		ClientType clientType = obtainClientType(httpRequest);
		String action = request.getParameter("action");

		if (badClientRequest(httpRequest, clientType, action)) {
			httpRequest.getSession().invalidate();
			httpResponse.sendRedirect(httpRequest.getContextPath() + indexPath);
			return;
		}

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		indexPath = fConfig.getInitParameter("indexPath");
	}
	
	/* method returns the type (role) of current Client */
	private ClientType obtainClientType(HttpServletRequest request) {
		ClientType clientType=null;
	/*	Member member = (Member) request.getSession().getAttribute("member");

		if (member != null) {
			if (member.isAdmin()) {
				clientType = ClientType.ADMIN;
			} else {
				clientType = ClientType.USER;
			}
		} else {
			clientType = ClientType.GUEST;
		}*/
		return clientType;
	}

	/* method identifies unacceptable Clients requests to controller */
	private boolean badClientRequest(HttpServletRequest req, ClientType type,
			String action) throws ServletException, IOException {
		boolean badRequest = false;
	/*	Set<String> userCommands = ClientCommandType.getUserCommands();
		Set<String> guestCommands = ClientCommandType.getGuestCommands();

		switch (type) {
		case GUEST:
			if (action != null && !guestCommands.contains(action)) {
				badRequest = true;
			}
			break;
		case USER:
			if (action != null && !userCommands.contains(action)) {
				badRequest = true;
			}
			break;
		case ADMIN:
			break;
		default:
			throw new EnumConstantNotPresentException(ClientType.class,
					type.name());
		}*/
		return badRequest;
	}

}
