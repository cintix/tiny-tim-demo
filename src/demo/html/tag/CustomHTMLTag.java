/*
 */
package demo.html.tag;

import dk.cintix.tinyserver.web.engine.Instance;
import dk.cintix.tinyserver.web.tags.Tag;
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
