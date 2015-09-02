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

/**
 * The Class PageRedirectFilter is a Filter that prohibits direct
 * access to the JSP pages and redirects such requests to the index page.
 *
 * @author Dzmitry Hrushetski
 */
public class PageRedirectFilter implements Filter {
	private String indexPath;

    /**
     * Instantiates a new page redirect filter.
     */
    public PageRedirectFilter() {
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
		/* redirecting to the index page */
		httpResponse.sendRedirect(httpRequest.getContextPath() + indexPath);
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		indexPath = fConfig.getInitParameter("indexPath");
	}
}
