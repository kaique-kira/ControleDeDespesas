package br.com.kira.ControleDeDespesas.Exception;

public class ObjNotFoundException extends RuntimeException{

    public ObjNotFoundException(String msg) {
        super(msg);
    }
}