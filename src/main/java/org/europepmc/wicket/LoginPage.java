package org.europepmc.wicket;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.WebPage;

public class LoginPage extends WebPage {
	private static final long serialVersionUID = 1L;
	
	public LoginPage(final PageParameters parameters) {
		super(parameters);
		
		final FeedbackPanel errorFeedbackPanel = new FeedbackPanel("feedback");
		errorFeedbackPanel.setOutputMarkupId(true);
		add(errorFeedbackPanel);

		add(new LoginForm("loginForm"));		
    }	
}