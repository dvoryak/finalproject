package util;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class CurrentData extends TagSupport {
    @Override
    public int doStartTag() throws JspException {
        String lang = (String) pageContext.getSession().getAttribute("lang");
        String date;

        if(lang != null && (lang.equals("ua") || lang.equals("ru"))) {
            DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT,Locale.forLanguageTag("ru"));
            date = "Дата : " + df.format(new Date());
        } else {
            DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT,Locale.forLanguageTag("en"));
            date = "Date : " + df.format(new Date());
        }


        try{
            JspWriter out = pageContext.getOut();
            out.write(date);
        } catch (IOException e) {
            throw new JspException(e.getMessage());
        }
        return SKIP_BODY;
    }

}
