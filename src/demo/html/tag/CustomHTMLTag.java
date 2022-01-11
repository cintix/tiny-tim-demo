/*
 */
package demo.html.tag;

import dk.cintix.application.server.web.engine.Instance;
import dk.cintix.application.server.web.tags.Tag;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author cix
 */
public class CustomHTMLTag extends Tag {

    @Override
    public String toHTML(Map<String, Instance> variables) {
        String html = "Time is now <strong>[" + new Date() + "]</strong>";
        return html;
    }

}
