package br.com.iveso.dasa.action.nota;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.iveso.dasa.action.Action;
import br.com.iveso.dasa.entity.Nota;
import br.com.iveso.dasa.service.NotaService;
import br.com.iveso.dasa.util.EstrategiaExclusaoJSON;

public class CarregarNotasAction extends Action {

	@Override
	public void process() throws Exception {
		NotaService service = serviceFactory.getNotaService();
		List<Nota> notas = service.carregarNotas();
		
		Gson gson = new GsonBuilder()
				.setExclusionStrategies(new EstrategiaExclusaoJSON())
				.setDateFormat("yyyy-MM-dd")
				.create();
		
		getResponse().setContentType("application/json");
		getResponse().getWriter().println(gson.toJson(notas));

	}

}
