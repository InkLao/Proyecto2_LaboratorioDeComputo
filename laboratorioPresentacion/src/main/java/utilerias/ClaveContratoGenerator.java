/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilerias;

import java.security.SecureRandom;
import java.util.Random;

/**
 *
 * @author eduar
 */
public class ClaveContratoGenerator {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int CLAVE_CONTRATO_LENGTH = 10;
    private static final Random RANDOM = new SecureRandom();

    public static String generate() {
        StringBuilder sb = new StringBuilder(CLAVE_CONTRATO_LENGTH);
        for (int i = 0; i < CLAVE_CONTRATO_LENGTH; i++) {
            sb.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }
}
