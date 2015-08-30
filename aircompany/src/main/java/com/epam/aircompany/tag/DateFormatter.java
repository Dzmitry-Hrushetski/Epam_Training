/**
 * 
 */
package com.epam.aircompany.tag;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class DateFormatter extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 684712238443673106L;
	private static final String DATE_FORMAT="yyyy-MM-dd";

	private GregorianCalendar calendar;
	
	public void setCalendar(GregorianCalendar calendar) {
		this.calendar = calendar;
	}
	
	@Override
	public int doStartTag() throws JspException {
		try {
			if (calendar != null) {
				JspWriter out = pageContext.getOut();

				SimpleDateFormat formattedDate = new SimpleDateFormat(DATE_FORMAT);
				out.write(formattedDate.format(calendar.getTime()));
			}
		} catch (IOException e) {
			throw new JspException(e.getMessage());
		}
		return SKIP_BODY;
	}

	@Override
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}
}
