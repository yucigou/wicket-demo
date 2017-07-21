package org.europepmc.wicket.form;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.WebPage;

public class UserFormPage extends WebPage {
    private static final long serialVersionUID = 1L;
    
    public UserFormPage(final PageParameters parameters) {
        super(parameters);
        
        final FeedbackPanel errorFeedbackPanel = new FeedbackPanel("feedback");
        errorFeedbackPanel.setOutputMarkupId(true);
        add(errorFeedbackPanel);

        add(new UserForm("userForm"));        
    }   
}
