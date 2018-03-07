package org.europepmc.wicket.resources;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import org.apache.wicket.request.IRequestParameters;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.cycle.RequestCycle;
import org.apache.wicket.request.resource.AbstractResource;
import org.europepmc.utils.RestUtils;
import org.europepmc.utils.XmlUtils;
import org.w3c.dom.Document;

/**
 * @author Yuci
 *
 */
public class Fulltext extends AbstractResource {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected ResourceResponse newResourceResponse(Attributes attributes) {
		ResourceResponse resourceResponse = new ResourceResponse();
		resourceResponse.setContentType("text/xml");
		resourceResponse.setTextEncoding("utf-8");

		resourceResponse.setWriteCallback(new WriteCallback() {
			@Override
			public void writeData(Attributes attributes) throws IOException {
				final Request request = RequestCycle.get().getRequest();
				final IRequestParameters params = request.getRequestParameters();

				String pmcid = params.getParameterValue("PMCID").toString();

				OutputStream outputStream = attributes.getResponse().getOutputStream();
				Writer writer = new OutputStreamWriter(outputStream);
				String fullText = getFullText(pmcid);
				writer.append(fullText);
				writer.flush();
				writer.close();
			}
		});

		return resourceResponse;
	}
	
	private String getFullText(String pmcid) {
		String requestUrl = "http://beta.europepmc.org/api/articlerender/"+pmcid;		
		String docStr = RestUtils.loadText(requestUrl);
		return docStr;
	}
	
}
