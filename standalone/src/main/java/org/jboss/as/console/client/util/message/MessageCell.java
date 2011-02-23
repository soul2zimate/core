package org.jboss.as.console.client.util.message;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.Image;
import org.jboss.as.console.client.domain.model.ProfileRecord;

public class MessageCell extends AbstractCell<Message> {

    interface Template extends SafeHtmlTemplates {
        @Template("<div class=\"{0}\" style='text-overflow:ellipsis'>&nbsp;{1}</div>")
        SafeHtml message(String cssClass, String title);
    }

    private static final Template TEMPLATE = GWT.create(Template.class);


    @Override
    public void render(
            Context context,
            Message message,
            SafeHtmlBuilder safeHtmlBuilder)
    {


        ImageResource icon = MessageCenterView.getSeverityIcon(message.getSeverity());
        AbstractImagePrototype prototype = AbstractImagePrototype.create(icon);

        String cssName = (context.getIndex() %2 > 0) ? "message-list-item message-list-item-odd" : "message-list-item";

        safeHtmlBuilder.appendHtmlConstant("<table width='100%' cellpadding=0 cellspacing=0><tr valign='middle'>");
        safeHtmlBuilder.appendHtmlConstant("<td>");
        safeHtmlBuilder.appendHtmlConstant(prototype.getHTML());
        safeHtmlBuilder.appendHtmlConstant("</td><td>");
        safeHtmlBuilder.append(TEMPLATE.message(cssName,message.getConciseMessage()));
        safeHtmlBuilder.appendHtmlConstant("</td></tr></table>");

    }

}

