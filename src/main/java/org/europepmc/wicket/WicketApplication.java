package org.europepmc.wicket;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.resource.IResource;
import org.apache.wicket.request.resource.ResourceReference;
import org.europepmc.wicket.form.UserFormPage;
import org.europepmc.wicket.resources.Fulltext;

/**
 * Application object for your web application.
 * If you want to run this application without deploying, run the Start class.
 * 
 * @see org.europepmc.wicket.Start#main(String[])
 */
public class WicketApplication extends WebApplication
{
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage()
	{
		return LoginPage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init()
	{
		super.init();

		mountPage("/home", HomePage.class);
		mountPage("/user", UserFormPage.class);
		
		ResourceReference resourceReference = new ResourceReference("rssProducer") {
			private static final long serialVersionUID = 1L;
			Fulltext rssResource = new Fulltext();

			@Override
			public IResource getResource() {
				return rssResource;
			}
		};
		// http://localhost:8080/wicket-demo/api/articlerender?PMCID=PMC5804726
		mountResource("/api/articlerender", resourceReference);
	}
}
