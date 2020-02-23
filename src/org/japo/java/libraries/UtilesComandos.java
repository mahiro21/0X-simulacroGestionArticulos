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

import org.japo.java.entities.ListaArticulos;
import java.util.Locale;
import java.util.Scanner;
import org.japo.java.entities.Articulos;
import org.japo.java.libraries.UtilesEntrada;

/**
 *
 * @author Mario Merlos Abella - mario.merlos.alum@iescamp.es
 */
public class UtilesComandos {

    public static final Scanner SCN
            = new Scanner(System.in, "ISO-8859-1")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");

    public static int p = 0;

    public static final void comandoAlta() {
        boolean continuar = false;
        do {

            System.out.print("Nombre del articulo ..:");
            String nombre = UtilesEntrada.obtenerString();
            if (!validarNombreUnico(nombre)) {
                System.out.print("Precio del articulo ..:");
                double precio = UtilesEntrada.obtenerDouble();
                ListaArticulos.articulos.add(new Articulos(nombre, precio));
                continuar = true;
            } else {
                System.out.println("Nombre en uso");
            }
        } while (!continuar);
    }

    public static final void comandoBaja() {
        System.out.print("Nombre del articulo ..: ");
        String str = UtilesEntrada.obtenerString();
        for (int i = 0; i < ListaArticulos.articulos.size(); i++) {
            boolean coincide = ListaArticulos.articulos.get(i).getNombre().equals(str);
            if (coincide) {
                int id = i;
                ListaArticulos.articulos.remove(id).getNombre();
            }
        }
    }

    public static final void comandoConsulta() {
        System.out.print("Nombre del articulo ..: ");
        String str = UtilesEntrada.obtenerString();
        for (int i = 0; i < ListaArticulos.articulos.size(); i++) {
            boolean coincide = ListaArticulos.articulos.get(i).getNombre().equals(str);
            if (coincide) {
                int id = i;
                System.out.printf("Nombre del articulo ..: %s%n",
                        ListaArticulos.articulos.get(i).getNombre());
                System.out.printf("Precio del articulo ..: %s%n",
                        ListaArticulos.articulos.get(i).getPrecio());
            }
        }

    }

    public static final void comandoModificacion() {
        System.out.print("Nombre del articulo ..: ");
        String str = UtilesEntrada.obtenerString();
        for (int i = 0; i < ListaArticulos.articulos.size(); i++) {
            boolean coincide = ListaArticulos.articulos.get(i).getNombre().equals(str);
            if (coincide) {
                int id = i;
                System.out.print("Nombre del articulo ..:");
                String nombre = UtilesEntrada.obtenerString();
                System.out.print("Precio del articulo ..:");
                double precio = UtilesEntrada.obtenerDouble();
                ListaArticulos.articulos.get(i).setNombre(nombre);
                ListaArticulos.articulos.get(i).setPrecio(precio);
            }
        }
    }

    public static final void comandoLista() {
        for (int i = 0; i < ListaArticulos.articulos.size(); i++) {
            System.out.printf("Nombre del articulo ..: %s%n",
                    ListaArticulos.articulos.get(i).getNombre());
            System.out.printf("Precio del articulo ..: %s%n",
                    ListaArticulos.articulos.get(i).getPrecio());
            System.out.printf("%n---%n%n");

        }
    }

    public static final boolean validarNombreUnico(String nombre) {
        boolean v = false;
        for (int i = 0; i < ListaArticulos.articulos.size(); i++) {
            v = ListaArticulos.articulos.get(i).getNombre().equals(nombre);
        }
        return v;
    }

}
