package com.epam.aircompany.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * The Class ServletFilter is a Filter that prohibits direct
 * access to the Servlet and redirects such requests to the index page.
 *
 * @author Dzmitry Hrushetski
 */
public class ServletFilter implements Filter {
	private static final String USER_TYPE = "user_type";
	private static final String INIT_PARAM = "indexPath";
	private String indexPath;

    /**
     * Instantiates a new servlet filter.
     */
    public ServletFilter() {
    }

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		HttpSession session = httpRequest.getSession();
		
		String userType = (String) session.getAttribute(USER_TYPE);
		if(userType == null || userType.isEmpty()) {
			httpResponse.sendRedirect(httpRequest.getContextPath() + indexPath);
			return;
		}
			
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		indexPath = fConfig.getInitParameter(INIT_PARAM);
	}
}
