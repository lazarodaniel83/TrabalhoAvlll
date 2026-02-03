package br.ifba.edu.inf011.model.autenticacao;

import br.ifba.edu.inf011.model.documentos.Documento;


public interface RegraAutenticacao {
    boolean aceita(Documento doc);
    String gerarNumero(Documento doc);
}
