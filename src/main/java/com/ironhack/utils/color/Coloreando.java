package com.ironhack.utils.color;

public class Coloreando {
	// más combinaciones en https://en.wikipedia.org/wiki/ANSI_escape_code
	public static final Formato ROJO =
		new Formato(Color.ROJO, Decorado.NORMAL, Enfasis.NORMAL);
	public static final Formato VERDE_NEGRITA =
		new Formato(Color.VERDE, Decorado.NEGRITA, Enfasis.NORMAL);
	public static final Formato VERDE =
		new Formato(Color.VERDE, Decorado.NORMAL, Enfasis.NORMAL);
	public static final Formato CIAN_BRILLANTE_SUBRAYADO =
		new Formato(Color.CIAN, Decorado.SUBRAYADO, Enfasis.BRILLANTE);
	public static final Formato FONDO =
		new Formato(Color.AMARILLO, Decorado.NORMAL, Enfasis.FONDO);
	public static final Formato WHITE =
			new Formato(Color.BLANCO, Decorado.NORMAL, Enfasis.NORMAL);



//	public static void main(String[] args) {
//		System.out.print("Coloreando... ");
//		System.out.print(ROJO + "en rojo" + Formato.RESET);
//		System.out.print(VERDE_NEGRITA + "en verde negrita" + Formato.RESET);
//		System.out.print(CIAN_BRILLANTE_SUBRAYADO + "azulito" + Formato.RESET);
//		System.out.print(FONDO + "fondo" + Formato.RESET);
//		System.out.print("normal de nuevo");
//		System.out.println();
//	}

}
