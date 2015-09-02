package com.epam.aircompany.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * The Class DevelopInfo outputs information on the developer on the JSP page.
 *
 * @author Dzmitry Hrushetski
 */
public class DevelopInfo extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3947001124300607176L;
	private static final String DEVELOPER_INFO = "<br><h6>Created by Hrushetski Dzmitry, EPAM Java Web Development Training</h6>";
	
	/* (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()
	 */
	@Override
	public int doStartTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();
			out.write(DEVELOPER_INFO);
		} catch (IOException e) {
			throw new JspException(e.getMessage());
		}
		return SKIP_BODY;
	}

	/* (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.TagSupport#doEndTag()
	 */
	@Override
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}
}
