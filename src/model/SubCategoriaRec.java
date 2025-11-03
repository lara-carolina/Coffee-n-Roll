package model;

public enum SubCategoriaRec {
    COM_FRUTAS(CategoriaReceita.DOCES) ,
    COM_CHOCOLATE(CategoriaReceita.DOCES) ,
    FRITOS(CategoriaReceita.SALGADOS) ,
    ASSADOS(CategoriaReceita.SALGADOS) ,
    CAFES(CategoriaReceita.BEBIDAS) ,
    CREMES(CategoriaReceita.BEBIDAS) ;

    private final CategoriaReceita categoria;

    SubCategoriaRec (CategoriaReceita categoria) {
        this.categoria = categoria;
    }

    public CategoriaReceita getCtegoria () {
        return categoria;
    }


}
