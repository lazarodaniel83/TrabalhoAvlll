
package br.ifba.edu.inf011.model.autenticacao;

import br.ifba.edu.inf011.model.documentos.Documento;
import java.time.LocalDate;


public class RegraPessoa implements RegraAutenticacao{

    @Override
    public boolean aceita(Documento doc) {
        return doc.getProprietario() != null;    }

    @Override
    public String gerarNumero(Documento doc) {
   return "PES-" + LocalDate.now().getDayOfYear() + "-" +
               doc.getProprietario().hashCode();    }
    
}
