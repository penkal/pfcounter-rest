package br.gov.serpro.jarvis;

import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import app.Reclassify;
import app.ReclassifyDTO;
import model.FuncaoTransacional;
import model.TipoTransacao;

@Path("/reclassify") // Your Path or URL to call this service
public class ReclassifyRest {

	@POST
	public List<FuncaoTransacional> reclassificar(String serialized) throws Exception {
		List<FuncaoTransacional> funcoes = new ObjectMapper().readValue(serialized, new TypeReference<List<FuncaoTransacional>>() { });
		Reclassify r = new Reclassify();
		List<ReclassifyDTO> dtos = funcoes.stream().map(f -> convertToDTO(f)).collect(Collectors.toList());
		r.send(dtos);
		return funcoes;
	}

	private ReclassifyDTO convertToDTO(FuncaoTransacional f) {
		return new ReclassifyDTO(f, f.getTipo(), f.getTipo() == TipoTransacao.DESCARTE);
	}
}