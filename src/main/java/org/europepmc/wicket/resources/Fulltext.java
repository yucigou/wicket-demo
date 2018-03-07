package org.europepmc.wicket.resources;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.apache.wicket.request.resource.AbstractResource;

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

	    resourceResponse.setWriteCallback(new WriteCallback()
	    {
	      @Override
	      public void writeData(Attributes attributes) throws IOException
	      {
	        OutputStream outputStream = attributes.getResponse().getOutputStream();
	        Writer writer = new OutputStreamWriter(outputStream);
	        writer.append("<!DOCTYPE html><html><head><title>Test</title></head><body></body></html>");
	        writer.flush();
	        writer.close();
	      }      
	    });

	    return resourceResponse;
	}
}
