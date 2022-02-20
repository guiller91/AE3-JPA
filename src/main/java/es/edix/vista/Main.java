package es.edix.vista;

import java.util.List;
import java.util.Scanner;

import es.edix.modelo.entidad.Autor;
import es.edix.modelo.entidad.Libreria;
import es.edix.modelo.entidad.Libro;
import es.edix.modelo.persistencia.DaoAutorMySql;
import es.edix.modelo.persistencia.DaoBaseDatosMySql;
import es.edix.modelo.persistencia.DaoLibreriaMySql;
import es.edix.modelo.persistencia.DaoLibroMySql;
import es.edix.modelo.persistencia.interfaz.DaoAutor;
import es.edix.modelo.persistencia.interfaz.DaoBaseDatos;
import es.edix.modelo.persistencia.interfaz.DaoLibreria;
import es.edix.modelo.persistencia.interfaz.DaoLibro;
/**
 * Programa para el control de una bbdd mediante jpa-hibernate
 * @author Guiller
 *
 */
public class Main {

	public static void main(String[] args) {

		DaoAutor daoAutor = new DaoAutorMySql();
		DaoLibreria daoLibreria = new DaoLibreriaMySql();
		DaoLibro daoLibro = new DaoLibroMySql();
		DaoBaseDatos daoBBDD = new DaoBaseDatosMySql();

		try {
			if (daoBBDD.comprobarTablas() > 0) {
				daoBBDD.drop();
				System.out.println("Base de datos preparada para su creación");
			}
			daoBBDD.rellenarTablas();
			
		} catch (Exception e) {
			System.out.println("Error en la creación de la bbdd = " + e.getLocalizedMessage());
			System.exit(1);
		}

		try (Scanner sc = new Scanner(System.in)) {

			boolean continuar = true;
			int num;

			System.out.println("\n--------- GESTION DE LIBRERIAS ---------\n");
			do {
				System.out.println("\nElige un numero del menu:\n"
						+ "1. Mostrar todos los libros dados de alta, con su editorial y su autor\n"
						+ "2. Mostrar todos los autores dados de alta, con sus libros asociados\n"
						+ "3. Mostrar todas las librerías, con solamente sus libros asociados\n"
						+ "4. Mostrar todos los libros dados de alta, y en la librería en la que están\n"
						+ "5. Salir\n");

				num = Integer.parseInt(sc.nextLine());

				switch (num) {
				case 1:
					System.out.println("Conexion abierta: " + daoLibro.abrirConexion());
					List<Libro> libros = daoLibro.list();
					System.out.println("<-----Lista de Libros----->");

					for (Libro libro : libros) {
						System.out.println(libro.toString());
					}
					System.out.println("Conexion cerrada: " + daoLibro.cerrarConexion());
					break;
				case 2:
					System.out.println("Conexion abierta: " + daoAutor.abrirConexion());
					List<Autor> autores = daoAutor.list();
					System.out.println("<-----Lista de Autores----->");
					for (Autor autor : autores) {
						System.out.println("----------- Autor ----------");
						System.out.println(autor.toString());
						System.out.println("---------- Libros escritos ----------");
						for (Libro libro : autor.getLibros()) {
							System.out.println(libro.librosEscritos());
						}

					}
					System.out.println("Conexion cerrada: " + daoAutor.cerrarConexion());
					break;
				case 3:
					System.out.println("Conexion abierta: " + daoLibreria.abrirConexion());
					List<Libreria> librerias = daoLibreria.list();
					System.out.println("<-----Lista de Librerias----->");
					for (Libreria libreria : librerias) {
						System.out.println("----------- Libreria ----------");
						System.out.println("Id " + libreria.getId() + ": " + libreria.getNombre());
						System.out.println("---------- Libros en posesion ----------");
						for (Libro libro : libreria.getLibros()) {
							System.out.println(libro.toString());
						}
					}
					System.out.println("Conexion cerrada: " + daoLibreria.cerrarConexion());

					break;
				case 4:
					System.out.println("Conexion abierta: " + daoLibro.abrirConexion());
					List<Libro> librosLibreria = daoLibro.list();
					System.out.println("<-----Lista de Libros----->");
					for (Libro libro : librosLibreria) {
						System.out.println("----------- Libro ----------");
						System.out.println("Id " + libro.getId() + ": " + libro.getTitulo());
						System.out.println("---------- Librerias ----------");
						for (Libreria libreria : libro.getLibrerias()) {
							System.out.println(libreria.toString());
						}
					}
					System.out.println("Conexion cerrada: " + daoLibro.cerrarConexion());
					break;
				case 5:
					System.out.println("Saliendo de la aplicación....");
					continuar = false;
					break;

				default:
					System.out.println("Introduzca un numero del menu");
				}

			} while (continuar);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
