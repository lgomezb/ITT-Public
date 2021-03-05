package uf2_2;

import bbdd.Database;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;
import objetos.CocheDao;
import objetos.PersonaDao;

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
        Persona p;
        ArrayList<Coche> lista = new ArrayList<>();
        ArrayList<Persona> listaP = new ArrayList<>();
        int id = 0;
        int idp = 0;
        Database bbdd = new Database();
        Connection conexion;
        conexion = bbdd.crearBBDD();
        conexion = bbdd.crearBBDD2();
        CocheDao cd = new CocheDao(conexion);
        PersonaDao pd = new PersonaDao(conexion);
        id = cd.obtenerId();
        idp = pd.obtenerId();
        
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("Bienvenido, seleccione una opción");
        do {
            System.out.println("1.Añadir nuevo coche");
            System.out.println("2.Borrar coche por ID");
            System.out.println("3.Consulta coche por ID");
            System.out.println("4.Listado de coches");
            System.out.println("5.Modificar coche por ID");
            System.out.println("6.Gestion de pasajeros");
            System.out.println("7.Terminar el programa");

            option = scan.nextLine();
            if (option.equals("1")) {
                coche = new Coche();
                System.out.println("A continuación se le pediran los datos necesarios \n "
                        + "para añadir un nuevo coche a la Base de Datos");
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
                    cd.alta(coche);
                    System.out.println("Se ha añadido satisfactoriamente");
                } else {
                    id--;
                    System.out.println("El coche no se ha añadido");
                }

            } else if (option.equals("2")) {
                System.out.println("Por favor, escriba el ID del coche que see eliminar:");
                read = scan.nextLine();
                cd.baja(Integer.parseInt(read));

            } else if (option.equals("3")) {
                Coche obtener = new Coche();
                System.out.println("Por favor, escriba el ID del coche que desee consultar:");
                read = scan.nextLine();
                obtener = cd.obtener(Integer.parseInt(read));
                System.out.println("El coche con el ID " + obtener.getId() + " tiene:\nMatricula: " + obtener.getMatricula()
                        + "\nMarca: " + obtener.getMarca() + "\nModelo: " + obtener.getModelo() + "\nColor: " + obtener.getColor());

            } else if (option.equals("4")) {
                System.out.println("A continuación se van a listar los coches existentes guardados:");
                ArrayList<Coche> listado = new ArrayList<>();
                listado = cd.listar();
                for (Coche i : listado) {
                    System.out.println("El coche con el ID " + i.getId() + " tiene:\nMatricula: " + i.getMatricula()
                            + "\nMarca: " + i.getMarca() + "\nModelo: " + i.getModelo() + "\nColor: " + i.getColor() + "\n////////////////////////");
                }

            } else if (option.equals("5")) {
                Coche obtener = new Coche();
                int aux;
                System.out.println("Por favor, escriba el ID del coche que desee modificar:");
                read = scan.nextLine();
                aux = Integer.parseInt(read);
                obtener = cd.obtener(Integer.parseInt(read));

                System.out.println("¿Quiere modificar la matricula?");
                read = scan.nextLine();
                while (!read.equalsIgnoreCase("si") && !read.equalsIgnoreCase("no")) {
                    System.out.println("Por favor, responda si o no");
                    read = scan.nextLine();
                }
                if (read.equalsIgnoreCase("si")) {
                    System.out.println("Añada la matricula, por favor:");
                    read = scan.nextLine();
                    obtener.setMatricula(read);
                    System.out.println("Se ha modificado satisfactoriamente");
                } else {
                    System.out.println("La matricula no se ha modificado");
                }

                System.out.println("¿Quiere modificar la marca?");
                read = scan.nextLine();
                while (!read.equalsIgnoreCase("si") && !read.equalsIgnoreCase("no")) {
                    System.out.println("Por favor, responda si o no");
                    read = scan.nextLine();
                }
                if (read.equalsIgnoreCase("si")) {
                    System.out.println("Añada la marca, por favor:");
                    read = scan.nextLine();
                    obtener.setMarca(read);
                    System.out.println("Se ha modificado satisfactoriamente");
                } else {
                    System.out.println("La marca no se ha modificado");
                }

                System.out.println("¿Quiere modificar el modelo?");
                read = scan.nextLine();
                while (!read.equalsIgnoreCase("si") && !read.equalsIgnoreCase("no")) {
                    System.out.println("Por favor, responda si o no");
                    read = scan.nextLine();
                }
                if (read.equalsIgnoreCase("si")) {
                    System.out.println("Añada el modelo, por favor:");
                    read = scan.nextLine();
                    obtener.setModelo(read);
                    System.out.println("Se ha modificado satisfactoriamente");
                } else {
                    System.out.println("El modelo no se ha modificado");
                }

                System.out.println("¿Quiere modificar rel color?");
                read = scan.nextLine();
                while (!read.equalsIgnoreCase("si") && !read.equalsIgnoreCase("no")) {
                    System.out.println("Por favor, responda si o no");
                    read = scan.nextLine();
                }
                if (read.equalsIgnoreCase("si")) {
                    System.out.println("Añada el color, por favor:");
                    read = scan.nextLine();
                    obtener.setColor(read);
                    System.out.println("Se ha modificado satisfactoriamente");
                } else {
                    System.out.println("El color no se ha modificado");
                }
                cd.modificar(aux, obtener);
                System.out.println("El coche con el ID " + obtener.getId() + " tiene:\nMatricula: " + obtener.getMatricula()
                        + "\nMarca: " + obtener.getMarca() + "\nModelo: " + obtener.getModelo() + "\nColor: " + obtener.getColor());

            } else if (option.equals("6")) {

                System.out.println("1.Añadir nuevo pasajero");
                System.out.println("2.Borrar pasajero por ID");
                System.out.println("3.Consulta pasajero por ID");
                System.out.println("4.Listar todos los pasajeros");
                System.out.println("5.Añadir pasajero a un coche");
                System.out.println("6.Eliminar pasajero de un coche");
                System.out.println("7.Listar pasajeros de un coche");
                System.out.println("8.Retornar al menu principal");

                option = scan.nextLine();
                if (option.equals("1")) {
                    p = new Persona();
                    System.out.println("A continuación se le pediran los datos necesarios \n para añadir un nuevo pasajero a la Base de Datos");
                    idp++;
                    p.setId(idp);

                    System.out.println("Añada el nombre, por favor:");
                    read = scan.nextLine();
                    p.setNombre(read);

                    System.out.println("Añada la edad, por favor:");
                    read = scan.nextLine();
                    p.setEdad(Integer.parseInt(read));

                    System.out.println("Añada el peso, por favor:");
                    read = scan.nextLine();
                    p.setPeso(Float.parseFloat(read));

                    System.out.println("¿Desea añadir el pasajero con las siguientes caracteristicas?:\n" + "Id: " + p.getId()
                            + "\nNombre: " + p.getNombre() + "\nEdad: " + p.getEdad() + "\nPeso: " + p.getPeso());
                    read = scan.nextLine();
                    while (!read.equalsIgnoreCase("si") && !read.equalsIgnoreCase("no")) {
                        System.out.println("Por favor, responda si o no");
                        read = scan.nextLine();
                    }
                    if (read.equalsIgnoreCase("si")) {
                        listaP.add(p);
                        pd.alta(p);
                        System.out.println("Se ha añadido satisfactoriamente");
                    } else {
                        idp--;
                        System.out.println("El pasajero no se ha añadido");
                    }

                } else if (option.equals("2")) {
                    System.out.println("Por favor, escriba el ID del pasajero que see eliminar:");
                    read = scan.nextLine();
                    pd.baja(Integer.parseInt(read));

                } else if (option.equals("3")) {
                    Persona obtener = new Persona();
                    System.out.println("Por favor, escriba el ID del pasajero que desee consultar:");
                    read = scan.nextLine();
                    obtener = pd.obtener(Integer.parseInt(read));
                    System.out.println("El pasajero con el ID " + obtener.getId() + " tiene:\nNombre: " + obtener.getNombre()
                            + "\nEdad: " + obtener.getEdad() + "\nPeso: " + obtener.getPeso());

                } else if (option.equals("4")) {
                    System.out.println("A continuación se van a listar los coches existentes guardados:");
                    ArrayList<Persona> listadoP = new ArrayList<>();
                    listadoP = pd.listar();
                    for (Persona i : listadoP) {
                        System.out.println("El pasajero con el ID " + i.getId() + " tiene:\nNombre: " + i.getNombre()
                                + "\nEdad: " + i.getEdad() + "\nPeso: " + i.getPeso() + "\n////////////////////////");
                    }
                } else if (option.equals("5")) {
                    int idaux;
                    int fkaux;
                    System.out.println("Introduzca el id del pasajero que desee introducir en un coche:");
                    read = scan.nextLine();
                    idaux = Integer.parseInt(read);
                    System.out.println("Introduzca el ID del coche donde desee introducir al pasajero");
                    read = scan.nextLine();
                    fkaux = Integer.parseInt(read);
                    pd.altaEnCoche(idaux, fkaux);

                } else if (option.equals("6")) {
                    int idaux;
                    System.out.println("Introduzca el id del pasajero que desee eliminar de un coche:");
                    read = scan.nextLine();
                    idaux = Integer.parseInt(read);
                    System.out.println("Introduzca el ID del coche donde desee eliminar al pasajero");
                    read = scan.nextLine();
                    pd.bajaEnCoche(idaux);

                } else if (option.equals("7")) {
                    int fkaux;
                    System.out.println("Introduzca el id del coche cuyos pasajeros desee consultar:");
                    read = scan.nextLine();
                    fkaux = Integer.parseInt(read);
                    pd.listarEnCoche(fkaux);
                    System.out.println("A continuación se van a listar los pasajeros asignados al coche seleccionado:");
                    ArrayList<Persona> listadoP = new ArrayList<>();
                    listadoP = pd.listar();
                    for (Persona i : listadoP) {
                        System.out.println("El pasajero con el ID " + i.getId() + " tiene:\nNombre: " + i.getNombre()
                                + "\nEdad: " + i.getEdad() + "\nPeso: " + i.getPeso() + "\n////////////////////////");
                    }
                } else if (option.equals("8")) {
                    System.out.println("\n ///////////////////////////////////////////////////////////////////////////");
                    System.out.println("Usted ha marcado una opción incorrecta.  Se le va a retornar al menu principal.");
                    System.out.println(" ////////////////////////////////////////////////////////////////////////////\n");
                }

            } else if (!option.equals("7")) {
                System.out.println("Usted ha marcado una opción incorrecta, por favor, marque una opcion valida.");
            }
        } while (!option.equals(
                "7"));
        if (option.equals(
                "7")) {
            System.out.println("Se va a cerrar el programa");
        }
    }

}
