package com.PSSA.joshu.utilities;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

public class PasswordEncoder {
	private static final Argon2 argon2 = Argon2Factory.create();

	public static String encodePassword ( String rawPass ) {
		// Iteraciones
		// Coste de memoria
		// Paralelismo
		return argon2.hash( 20, 65536, 1, rawPass.toCharArray() );
	}

	public static boolean matches ( String rawPass, String encodedPassword ) {
		return argon2.verify( encodedPassword, rawPass.toCharArray() );
	}
}
