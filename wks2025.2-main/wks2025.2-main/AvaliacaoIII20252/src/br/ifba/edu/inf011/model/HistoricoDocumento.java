package br.ifba.edu.inf011.model;

import br.ifba.edu.inf011.model.documentos.Documento;
import br.ifba.edu.inf011.model.documentos.DocumentoMemento;
import java.util.ArrayList;
import java.util.List;


public class HistoricoDocumento {
    
    private final Documento doc;

    private List<Documento> undo = new ArrayList<>();
    private List<Documento> redo = new ArrayList<>();

    public HistoricoDocumento(Documento documento){
        this.doc = documento;
    }

    private void snapshot() throws FWDocumentException{
        undo.add(new DocumentoMemento(doc));
        redo.clear();
    }

 
    public void editar(String texto) throws FWDocumentException{
        snapshot();
        doc.setConteudo(texto);
        log("Editar conteúdo");
    }

    public void proteger(Privacidade p) throws FWDocumentException {
        snapshot();
        doc.inicializar(doc.getProprietario(), p);
        log("Proteger documento");
    }

  

    public void macro(Runnable r) throws FWDocumentException{
        snapshot();
        r.run();
        log("Macro executada");
    }

 
    public void desfazer() throws FWDocumentException {

        if(undo.isEmpty()) return;

        redo.add(new DocumentoMemento(doc));

        Documento m = undo.remove(undo.size()-1);

        restaurar(m);

        log("Undo");
    }



    public void refazer() throws FWDocumentException {

        if(redo.isEmpty()) return;

        undo.add(new DocumentoMemento(doc));

        Documento m = redo.remove(redo.size()-1);

        restaurar(m);

        log("Redo");
    }



    public void consolidar(){
        undo.clear();
        redo.clear();
        log("Consolidado");
    }

    private void restaurar(Documento m) throws FWDocumentException {

        doc.setConteudo(m.getConteudo());
        doc.setNumero(m.getNumero());
        doc.inicializar(m.getProprietario(), m.getPrivacidade());
    }

    private void log(String msg){
        System.out.println("[LOG] " + msg);
    }
    
}
