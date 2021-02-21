package uf1_1;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Laura
 */
public class Main {

    public static void main(String[] args) { //Método principal
        //Se declaran las variables necesarias
        Scanner scan = new Scanner(System.in);
        String read;
        String option;
        Coche coche;
        File file = new File("./coches.dat"); //Creamos el objeto File que se corresponde con el archivo "coches.dat"
        boolean eof;
        FileInputStream fichero;     //Clase que lee un flujo de entrada de bytes. Se utiliza junto con la clase ObjectOutputStream
        ObjectInputStream buffer;    //Clase que procesa los datos de entrada. Se utiliza junto con la clase FileOutputStream
        FileOutputStream fos;        //Clase que lee un flujo de salida de bytes. Se utiliza junto con la clase ObjectInputStream
        ObjectOutputStream oos = null;      //Clase que procesa los datos de salida. Se utiliza junto con la clase FileInputStream
        ArrayList<Coche> lista = new ArrayList<>();
        int bufferBytes;
        int id = 0;
        boolean found = false;

        if (file.exists()) {
            try {
                //Se abre el fichero para leerse
                fichero = new FileInputStream(file);
                buffer = new ObjectInputStream(fichero);
                bufferBytes = fichero.available(); //Variable que almacena los bytes que quedan aun por leerse
                if (bufferBytes > 0) {
                    try {
                        lista = (ArrayList<Coche>) buffer.readObject();
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for (Coche i : lista) {
            id = i.getId();
        }
        System.out.println("Bienvenido, seleccione una opción");
        do {
            System.out.println("1.Añadir nuevo coche");
            System.out.println("2.Borrar coche por id");
            System.out.println("3.Consulta coche por id");
            System.out.println("4.Listado de coches");
            System.out.println("5.Exportar coches a archivo de texto");
            System.out.println("6.Terminar el programa");

            option = scan.nextLine();
            if (option.equals("1")) {
                coche = new Coche();
                System.out.println("A continuación se le pediran los datos necesarios \n para añadir un nuevo coche a la Base de Datos");
                id++;
                coche.setId(id);

                System.out.println("Añada la matricula, por favor:");
                read = scan.nextLine();
                coche.setMatricula(read);

                System.out.println("Añada la marca, por favor:");
                read = scan.nextLine();
                coche.setMarca(read);

                System.out.println("Añada el modelo, por favor:");
                read = scan.nextLine();
                coche.setModelo(read);

                System.out.println("Añada el color, por favor:");
                read = scan.nextLine();
                coche.setColor(read);

                System.out.println("¿Desea añadir el coche con las siguientes caracteristicas?:\n" + "Id: " + coche.getId()
                        + "\nMatricula: " + coche.getMatricula() + "\nMarca: " + coche.getMarca() + "\nModelo: " + coche.getModelo()
                        + "\nColor: " + coche.getColor());
                read = scan.nextLine();
                while (!read.equalsIgnoreCase("si") && !read.equalsIgnoreCase("no")) {
                    System.out.println("Por favor, responda si o no");
                    read = scan.nextLine();
                }
                if (read.equalsIgnoreCase("si")) {
                    lista.add(coche);
                    System.out.println("Se ha añadido satisfactoriamente");
                } else {
                    id--;
                    System.out.println("El coche no se ha añadido");
                }
            } else if (option.equals("2")) {
                System.out.println("Por favor, escriba el ID del coche que see eliminar:");
                read = scan.nextLine();
                /*
                    Se recorren todos los objetos coche de la lista hasta encontrar uno en el que los datos introducidos
                    por el usuario sean igual al id de un coche, cuando esto se cumpla, se imprimirá un mensaje de advertencia.
                 */
                for (Coche i : lista) {
                    if (Integer.parseInt(read) == i.getId()) {
                        System.out.println("Se ha encontrado el coche y se va a proceder a eliminar...");
                        lista.remove(i);
                        System.out.println("Se ha eliminado el coche indicado");
                        found = true;
                    }
                }
                if (found == false) {
                    System.out.println("Lo sentimos, el id proporcionado no corresponde con ningun id existente");
                }
                found = false;
            } else if (option.equals("3")) {
                System.out.println("Por favor, escriba el ID del coche que see consultar:");
                read = scan.nextLine();
                /*
                    Se recorren todos los objetos coche de la lista hasta encontrar uno en el que los datos introducidos
                    por el usuario sean igual al id de un coche, cuando esto se cumpla, se imprimirán los datos de dicho coche.
                 */

                for (Coche i : lista) {
                    if (Integer.parseInt(read) == i.getId()) {
                        System.out.println("El coche con el ID " + i.getId() + " tiene:\n Matricula: " + i.getMatricula()
                                + "\nMarca: " + i.getMarca() + "\nModelo: " + i.getModelo() + "\nColor: " + i.getColor());
                        found = true;
                    }
                }
                if (found == false) {
                    System.out.println("Lo sentimos, el coche con el id proporcionado no existe");
                }
                found = false;
            } else if (option.equals("4")) {
                System.out.println("////////////////////////");
                for (Coche i : lista) {
                    System.out.println("El coche con el ID " + i.getId() + " tiene:\nMatricula: " + i.getMatricula()
                            + "\nMarca: " + i.getMarca() + "\nModelo: " + i.getModelo() + "\nColor: " + i.getColor() + "\n////////////////////////");
                }
            } else if (option.equals("5")) {
                try (FileWriter fw = new FileWriter("coches.txt",false);    //Creamos el archivo coches.txt y lo abrimos con la clase FileWriter. Si ya existe un coches.txt,se sobrescribe
                        PrintWriter pw = new PrintWriter(fw);) {            //La clase PrintWriter nos permite escribir sobre el archivo abierto
                    pw.println("////////////////////////");
                    for (Coche i : lista) {
                        pw.println("El coche con el ID " + i.getId() + " tiene:\nMatricula: " + i.getMatricula() + "\nMarca: "
                                + i.getMarca() + "\nModelo: " + i.getModelo() + "\nColor: " + i.getColor() + "\n////////////////////////");
                    }
                    System.out.println("Archivo creado satisfactoriamente");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (!option.equals("6")) {
                System.out.println("Usted ha marcado una opción incorrecta, por favor, marque una opcion valida.");
            }
        } while (!option.equals("6"));
        if (option.equals("6")) {
            try {
                //Se crea el archivo coches.dat (o se sobreescribe en el caso de existir)
                fos = new FileOutputStream("coches.dat", false);
                oos = new ObjectOutputStream(fos);
                oos.writeObject(lista); //Se escribe el ArrayList lista que contiene los objetos coche sobre el archivo indicado
                System.out.println("Lista de coches exportada al archivo coches.dat");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (oos != null) {
                    try {
                        oos.close(); //Se cierra el ObjectOutputStream
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
