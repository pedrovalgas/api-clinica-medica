package br.com.pedrolucas.api.service;

public class ValidacaoExcpetion extends RuntimeException {
    public ValidacaoExcpetion(String mensagem) {
        super(mensagem);
    }
}
