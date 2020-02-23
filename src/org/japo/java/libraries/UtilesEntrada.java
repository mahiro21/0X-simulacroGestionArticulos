/* 
 * Copyright 2020 Mario Merlos Abella - mario.merlos.alum@iescamp.es.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.libraries;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Mario Merlos Abella - mario.merlos.alum@iescamp.es
 */
public class UtilesEntrada {

    public static final Scanner SCN
            = new Scanner(System.in, "ISO-8859-1")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");

    public static final char obtenerCaracter() {
        char entrada = ' ';

        try {
            System.out.printf("%n---%n%n");
            System.out.print("Elegir opción ..: ");
            entrada = SCN.nextLine().charAt(0);
        } catch (Exception e) {
            System.out.println("ERROR:¡Opción no válida!");
        }
        System.out.printf("%n---%n%n");

        return entrada;
    }

    public static final String obtenerString() {
        String entrada = "";

        try {
            entrada = SCN.nextLine();
        } catch (Exception e) {
            System.out.println("ERROR:¡Opción no válida!");
        }

        return entrada;
    }

    public static final double obtenerDouble() {
        double entrada = 0;

        try {
            entrada = SCN.nextDouble();
        } catch (Exception e) {
            System.out.println("ERROR:¡Opción no válida!");
        } finally {
            SCN.nextLine();
        }

        return entrada;
    }

}
