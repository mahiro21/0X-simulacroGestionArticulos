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
package org.japo.java.app;

import java.util.ArrayList;
import org.japo.java.entities.Articulos;
import org.japo.java.libraries.UtilesComandos;
import org.japo.java.libraries.UtilesEntrada;

/**
 *
 * @author Mario Merlos Abella - mario.merlos.alum@iescamp.es
 */
public final class App {

    public final void launchApp() {



        System.out.println("Menú de gestión de artículos");
        System.out.println("============================");
        System.out.println("[A] Alta");
        System.out.println("[B] Baja");
        System.out.println("[C] Consulta");
        System.out.println("[M] Modificación");
        System.out.println("[L] Listado");
        System.out.println("---");
        System.out.println("[S] Salir");

        //boolean de salida del menú
        boolean salir = false;

        do {
            //obtener caracter
            char c = UtilesEntrada.obtenerCaracter();

            //Arreglar caracter en caso de no ser mayus
            char entrada = Character.toUpperCase(c);

            //Tomar la opción según el caracter
            switch (entrada) {
                case 'A':
                    UtilesComandos.comandoAlta();
                    break;
                case 'B':
                    UtilesComandos.comandoBaja();
                    break;
                case 'C':
                    UtilesComandos.comandoConsulta();
                    break;
                case 'M':
                    UtilesComandos.comandoModificacion();
                    break;
                case 'L':
                    UtilesComandos.comandoLista();
                    break;
                case 'S':
                    salir = true;
                    System.out.println("Cerrando sesión");
                    break;
                default:
                    System.out.println("ERROR:¡Opción no válida!");
                    break;
            }

        } while (!salir);
    }

}
