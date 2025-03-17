package br.com.fiap.JL_Bank.model;

public class Pix {
    private Long idOrigem;
    private Long idDestino;
    private Double valorPix;

    
    public Pix(Long idOrigem, Long idDestino, Double valorPix) {
        this.idOrigem = idOrigem;
        this.idDestino = idDestino;
        this.valorPix = valorPix;
    }


    public Long getIdOrigem() {
        return idOrigem;
    }


    public Long getIdDestino() {
        return idDestino;
    }


    public Double getValorPix() {
        return valorPix;
    }

    
}
