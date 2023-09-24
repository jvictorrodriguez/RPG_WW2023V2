package com.ironhack.utils.color;

public enum Decorado {
	NORMAL("0"),
	NEGRITA("1"),
	CURSIVA("3"),
	SUBRAYADO("4");
	
    private final String code;

	Decorado(String code) {
        this.code = code;
    }
    
    @Override
    public String toString() {
        return code;
    }
}
