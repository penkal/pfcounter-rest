package br.gov.serpro.jarvis;

import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

@Path("/fileupload") // Your Path or URL to call this service
public class FileUploadRest {


	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadFile(MultipartFormDataInput input)  {
		Map<String, List<InputPart>> uploadForm = input.getFormDataMap();
		return Response.status(200).entity("ufa").build();
	}
}