package br.ifba.edu.inf011.model.autenticacao;

import br.ifba.edu.inf011.model.documentos.Privacidade;
import br.ifba.edu.inf011.model.documentos.Documento;


public class RegraPrivacidade implements RegraAutenticacao{

    @Override
    public boolean aceita(Documento doc) {
        return doc.getPrivacidade() == Privacidade.SIGILOSO;  
    }

    @Override
    public String gerarNumero(Documento doc) {
        return "SECURE-" + doc.hashCode();    }
    
}
