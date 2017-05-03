package br.gov.serpro.jarvis;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.apache.commons.io.IOUtils;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import app.DocumentReader;
import model.FuncaoTransacional;
import model.TipoTransacao;

@Path("/fileupload") // Your Path or URL to call this service
public class FileUploadRest {

	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public List<FuncaoTransacional> uploadFile(MultipartFormDataInput input) throws Exception {
		Map<String, List<InputPart>> uploadForm = input.getFormDataMap();
		List<InputPart> parts = uploadForm.get("file");
		for (InputPart inputPart : parts) {
			// convert the uploaded file to input stream
			InputStream inputStream = inputPart.getBody(InputStream.class, null);
			byte[] bytes = IOUtils.toByteArray(inputStream);
			String arquivo = new String(bytes, "UTF-8");
			//DESCOMENTAR ABAIXO
			return new DocumentReader().parseFile(arquivo);
		}
		return new ArrayList<>();
	}
}