package br.ifba.edu.inf011.model.documentos;

import br.ifba.edu.inf011.model.FWDocumentException;
import br.ifba.edu.inf011.model.Operador;


public class DocumentoMemento implements Documento{
     private final Documento estado;

    public DocumentoMemento(Documento original) throws FWDocumentException{
        this.estado = (Documento) original.clonar();
    }


    @Override
    public String getNumero() {
        return estado.getNumero();
    }

    @Override
    public String getConteudo() throws FWDocumentException {
        return estado.getConteudo();
    }

    @Override
    public Operador getProprietario() {
        return (Operador) estado.getProprietario();
    }

    @Override
    public Privacidade getPrivacidade() {
        return estado.getPrivacidade();
    }


    @Override
    public void setConteudo(String c){
        throw new UnsupportedOperationException("Memento imutável");
    }

    @Override
    public void setNumero(String n){
        throw new UnsupportedOperationException("Memento imutável");
    }

    @Override
    public void inicializar(Operador o, Privacidade p){
        throw new UnsupportedOperationException("Memento imutável");
    }

    @Override
    public Documento clonar() throws FWDocumentException{
        return new DocumentoMemento(estado);
    }

 
}
