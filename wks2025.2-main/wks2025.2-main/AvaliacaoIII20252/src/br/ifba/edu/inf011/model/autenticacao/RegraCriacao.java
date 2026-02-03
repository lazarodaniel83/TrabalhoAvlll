package br.ifba.edu.inf011.model.autenticacao;

import br.ifba.edu.inf011.model.documentos.Documento;
import java.time.LocalDate;


public class RegraCriacao implements RegraAutenticacao{

    @Override
    public boolean aceita(Documento doc) {
        return true;    }

    @Override
    public String gerarNumero(Documento doc) {
        return "CRI-" + LocalDate.now().getYear() + "-" + doc.hashCode();    }
    
}
