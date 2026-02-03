package br.ifba.edu.inf011.model;

import br.ifba.edu.inf011.model.autenticacao.RegraAutenticacao;
import java.time.LocalDate;

import br.ifba.edu.inf011.model.documentos.Documento;
import br.ifba.edu.inf011.model.documentos.Privacidade;
import java.util.ArrayList;
import java.util.List;

public class Autenticador {
	
private List<RegraAutenticacao> regras = new ArrayList<>();

    public void adicionar(RegraAutenticacao r){
        regras.add(r);
    }

    public void autenticar(Documento doc){

        for(RegraAutenticacao r : regras){
            if(r.aceita(doc)){
                doc.setNumero(r.gerarNumero(doc));
                return;
            }
        }

        doc.setNumero("DOC-" + System.currentTimeMillis());
    }

}
