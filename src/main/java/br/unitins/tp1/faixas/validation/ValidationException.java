package br.unitins.tp1.faixas.validation;

public class ValidationException extends RuntimeException {

    private String fildName;

    public ValidationException(String filedName, String message) {
        super(message);
        this.fildName = filedName;
    }

    public String getFildName() {
        return fildName;
    }
    
}
