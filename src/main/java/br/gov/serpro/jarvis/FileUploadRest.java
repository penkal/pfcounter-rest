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
			//return new DocumentReader().parseFile(arquivo);
		}
		List<FuncaoTransacional> funcoes = new ArrayList<FuncaoTransacional>();
		funcoes.add(new FuncaoTransacional("Manter Usuário",
				TipoTransacao.CRUD, 0.8777D));
		funcoes.add(new FuncaoTransacional("Incluir Tipo de Alguma Coisa",
				TipoTransacao.EE, 0.6277D));
		funcoes.add(new FuncaoTransacional("Consultar algo de interassante",
				TipoTransacao.SE, 0.4277D));
		funcoes.add(new FuncaoTransacional("Inutil",
				TipoTransacao.DESCARTE, 0.1255D));
		funcoes.add(new FuncaoTransacional("Manter Usuário",
				TipoTransacao.CRUD, 0.8777D));
		funcoes.add(new FuncaoTransacional("Incluir Tipo de Alguma Coisa",
				TipoTransacao.EE, 0.6277D));
		funcoes.add(new FuncaoTransacional("Consultar algo de interassante",
				TipoTransacao.SE, 0.4277D));
		funcoes.add(new FuncaoTransacional("Inutil",
				TipoTransacao.DESCARTE, 0.1255D));
		funcoes.add(new FuncaoTransacional("Manter Usuário",
				TipoTransacao.CRUD, 0.8777D));
		funcoes.add(new FuncaoTransacional("Incluir Tipo de Alguma Coisa",
				TipoTransacao.EE, 0.6277D));
		funcoes.add(new FuncaoTransacional("Consultar algo de interassante",
				TipoTransacao.SE, 0.4277D));
		funcoes.add(new FuncaoTransacional("Inutil",
				TipoTransacao.DESCARTE, 0.1255D));
		funcoes.add(new FuncaoTransacional("Manter Usuário",
				TipoTransacao.CRUD, 0.8777D));
		funcoes.add(new FuncaoTransacional("Incluir Tipo de Alguma Coisa",
				TipoTransacao.EE, 0.6277D));
		funcoes.add(new FuncaoTransacional("Consultar algo de interassante",
				TipoTransacao.SE, 0.4277D));
		funcoes.add(new FuncaoTransacional("Inutil",
				TipoTransacao.DESCARTE, 0.1255D));
		funcoes.add(new FuncaoTransacional("Manter Usuário",
				TipoTransacao.CRUD, 0.8777D));
		funcoes.add(new FuncaoTransacional("Incluir Tipo de Alguma Coisa",
				TipoTransacao.EE, 0.6277D));
		funcoes.add(new FuncaoTransacional("Consultar algo de interassante",
				TipoTransacao.SE, 0.4277D));
		funcoes.add(new FuncaoTransacional("Inutil",
				TipoTransacao.DESCARTE, 0.1255D));
		funcoes.add(new FuncaoTransacional("Manter Usuário",
				TipoTransacao.CRUD, 0.8777D));
		funcoes.add(new FuncaoTransacional("Incluir Tipo de Alguma Coisa",
				TipoTransacao.EE, 0.6277D));
		funcoes.add(new FuncaoTransacional("Consultar algo de interassante",
				TipoTransacao.SE, 0.4277D));
		funcoes.add(new FuncaoTransacional("Inutil",
				TipoTransacao.DESCARTE, 0.1255D));		
		return funcoes;
//		return new ArrayList<>();
	}
}