package by.hotel.tag;

import by.hotel.bean.Discount;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * This tag displays the current date according to the locale.
 *
 * @author Igor Kozlov
 *
 */
@SuppressWarnings("serial")
public class GetDateTag extends TagSupport {

    /**
     * Property - locale
     */
    private String locale = "ru";

    /**
     * @param locale -  the locale to be set.
     * Function for set value of locale {@link GetDateTag#locale}
     */
    public void setLocale(String locale) {
        this.locale = locale;
    }

    /**
     * Property - loc
     */
    private Locale loc;

    /**
     * This method prints the current date.
     * @return SKIP_BODY
     * @throws JspException if out write is failed
     *
     */
    @Override
    public int doStartTag() throws JspException {
        if ("ru".equalsIgnoreCase(locale)) {
            loc = new Locale("ru", "RU");
        } else {
            loc = new Locale("en", "EN");
        }
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
        DateFormat dateFormat = DateFormat
                .getDateInstance(DateFormat.MEDIUM, loc);
        String time = "<b> " + dateFormat.format(gc.getTime())
                + " </b>";
        try {
            JspWriter out = pageContext.getOut();
            out.write(time);
        } catch (IOException e) {
            throw new JspException(e.getMessage());
        }
        return SKIP_BODY;
    }

    /**
     * @return EVAL_PAGE
     * @throws JspException a JspException
     *
     */
    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }
}
