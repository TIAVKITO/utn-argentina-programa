package com.utn.app;

public enum EnumResultado {
	GANADOR,
	PERDEDOR,
	EMPATE,
	NADA;

	public static EnumResultado resultadoFinal(String gana1, String empate, String gana2) {
		if ("X".equals(empate)) {
			return EnumResultado.EMPATE;
		} else if ("X".equals(gana1)) {
			return EnumResultado.GANADOR;
		} else if ("X".equals(gana2)) {
			return EnumResultado.PERDEDOR;
		}
		return EnumResultado.NADA;
	}
}