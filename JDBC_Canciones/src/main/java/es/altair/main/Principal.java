package es.altair.main;

import java.util.List;
import java.util.Scanner;

import es.altair.bean.Artista;
import es.altair.bean.Canciones;
import es.altair.bean.Estilo;
import es.altair.dao.ArtistaDAO;
import es.altair.dao.ArtistaDAOImplJDBC;
import es.altair.dao.CancionDAO;
import es.altair.dao.CancionDAOImplJDBC;
import es.altair.dao.EstiloDAO;
import es.altair.dao.EstiloDAOImplJDBC;

public class Principal {

	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		ArtistaDAO aDAO = new ArtistaDAOImplJDBC();
		CancionDAO cDAO = new CancionDAOImplJDBC();
		EstiloDAO eDAO = new EstiloDAOImplJDBC();
		
		int opcionMenu = 0;
		
		do {

			// MENU GRAFICO

			System.out.println("+-------------------------------------+");
			System.out.println("|             JDBC - SMB              |");
			System.out.println("+-------------------------------------+");
			System.out.println("|                                     |");
			System.out.println("| 1. AÑADIR ARTISTA, CANCION Y ESTILO |");
			System.out.println("|                                     |");
			System.out.println("| 2. LISTAR ARTISTAS POR ESTILO       |");
			System.out.println("|                                     |");
			System.out.println("| 3. LISTAR CANCIONES POR ARTISTA     |");
			System.out.println("|                                     |");
			System.out.println("| 4. ACTUALIZAR EDAD ARTISTA          |");
			System.out.println("|                                     |");
			System.out.println("| 5. AÑADIR UN MIN DURACION POR PAIS  |");
			System.out.println("|                                     |");
			System.out.println("| 6. BORRAR LAS CANCIONES POR ARTISTA |");
			System.out.println("|                                     |");
			System.out.println("| 7. LISTAR TODO                      |");
			System.out.println("|                                     |");
			System.out.println("+-------------------------------------+");
			System.out.println("|             0. SALIR                |");
			System.out.println("+-------------------------------------+");
			System.out.println(" 									   ");

			System.out.print("ELIGA LA OPCION: ");
			opcionMenu = sc.nextInt();

			switch (opcionMenu) {

			case 1: // AÑADIR ARTISTA, CANCION Y ESTILO

				String nombreArtista, artistaApellido, artistaPais;
				int artistaEstilo, artistaEdad, opcionSubMenu;

				do {

					System.out.println("+-------------------------------------+");
					System.out.println("|             JDBC - SMB              |");
					System.out.println("+-------------------------------------+");
					System.out.println("|                                     |");
					System.out.println("|        1. AÑADIR ARTISTA            |");
					System.out.println("|                                     |");
					System.out.println("|        2. AÑADIR CANCION            |");
					System.out.println("|                                     |");
					System.out.println("|        3. AÑADIR ESTILO             |");
					System.out.println("|                                     |");
					System.out.println("+-------------------------------------+");
					System.out.println("|    0. VOLVER AL MENU PRINCIPAL      |");
					System.out.println("+-------------------------------------+");
					System.out.println();

					System.out.print("ELIGA LA OPCION: ");
					opcionSubMenu = sc.nextInt();

					switch (opcionSubMenu) {

					case 1:
						System.out.println("+----------------------------------+");
						System.out.println("|        AÑADIR UN ARTISTA         |");
						System.out.println("+----------------------------------+");
						System.out.println();

						System.out.println("NOMBRE:");
						nombreArtista = sc.next().toUpperCase();

						System.out.println("APELLIDOS: ");
						artistaApellido = sc.next().toUpperCase();

						System.out.println("PAIS DE ORIGEN: ");
						artistaPais = sc.next().substring(0, 5).toUpperCase();

						System.out.println("EDAD: ");
						artistaEdad = sc.nextInt();

						
						List<Estilo> estilosArtista = eDAO.ListarTodosEstilos();		
						for (int i = 0; i < estilosArtista.size(); i++) 	
							System.out.println(estilosArtista.get(i));
						
						
						System.out.print("ESCRIBA EL ESTILO AL QUE PERTENECE [ID]: ");
						int artistaEstiloId = sc.nextInt();
						
						if (aDAO.insertarArtista(new Artista(nombreArtista, artistaApellido, artistaEdad, artistaPais,artistaEstiloId))) {
							System.out.println("ARTISTA INSERTADO CORRECTAMENTE");
						} else {
							System.out.println("ERROR, EL ARTISTA NO SE HA INSERTADO");
						}
						break;
				

					case 2:

						System.out.println("+----------------------------------+");
						System.out.println("|        AÑADIR UNA CANCION        |");
						System.out.println("+----------------------------------+");
						System.out.println();

						System.out.print("NOMBRE CANCION: ");
						String nombreCancion = sc.next().toUpperCase();
						
						System.out.print("DURACION CANCION [segundos]: ");
						int duracion = sc.nextInt();
						
						System.out.println("¿ A QUE ARTISTA PERTENECE ?");
						
						List<Artista> artistas = aDAO.listarArtistas();	
						for (int i = 0; i < artistas.size(); i++) {
							
							System.out.println(artistas.get(i));
						}
						
						System.out.print("ESCRIBA EL ID DEL ARTISTA AL QUE PERTENECE " + nombreCancion +" [ID]: ");
						int artistaCancion = sc.nextInt();
						
						System.out.print("ESCRIBA EL AÑO AL QUE PERTENECE " + nombreCancion +": ");
						int anyoPublicacion = sc.nextInt();
						
						List<Estilo> estilos = eDAO.ListarTodosEstilos();
						for (int i = 0; i < estilos.size(); i++) {

							System.out.println(estilos.get(i));
						}
						
						System.out.print("ESCRIBA EL ESTILO AL QUE PERTENECE " + nombreCancion +" [ID]: ");
						int estiloCancion = sc.nextInt();
						
						
						
						if (cDAO.anadirCacion(new Canciones( nombreCancion, anyoPublicacion ,duracion, artistaCancion, estiloCancion))) {
							System.out.println("Canción insertada");
						} else {
							System.out.println("ERROR: no se ha podido insertar la canción");
						}

						break;

					case 3:
							
						System.out.println("+----------------------------------+");
						System.out.println("|         AÑADIR UN ESTILO         |");
						System.out.println("+----------------------------------+");
						System.out.println();

						List<Estilo> estilos1 = eDAO.ListarTodosEstilos();
						
						
						System.out.println("+----------------------------------+");
						System.out.println("|             ESTILOS              |");
						System.out.println("+----------------------------------+");
//						System.out.println();

						for (Estilo estilito : estilos1) {
							System.out.println(estilito);
						}
						
						System.out.print("NOMBRE ESTILO: ");
						String nombreEstilo = sc.next().toUpperCase();
						
						if (eDAO.insertarNuevoEstilo(new Estilo(nombreEstilo))) {
							System.out.println("ESTILO INSERTADO CORRECTAMENTE");
						} else {
							System.out.println("ERROR, EL ESTILO NO SE HA PODIDO INSERTAR");
						}
						
						break;

					case 0:
						break;
						
					}
				} while (opcionSubMenu != 0);
				break;

			case 2: // LISTAR TODOS LOS ARTISTAS DE UN ESTILO DETERMINADO

				List<Estilo> estilo = eDAO.ListarTodosEstilos();
				for (int i = 0; i < estilo.size(); i++) {

					System.out.println(estilo.get(i));
				}

				System.out.println("¿ARTISTAS A MOSTRAR POR ESTILO? [ID]: ");
				int artistasEstiloID = sc.nextInt();

				List<Artista> artistas = aDAO.listarPorEstilo(artistasEstiloID);
				for (int i = 0; i < artistas.size(); i++) {

					System.out.println(artistas.get(i));
				}

				break;

			case 3: // LISTAR TODAS LAS CANCIONES DE UN ARTISTA

				List<Artista> artistaCancion = aDAO.listarArtistas();

				for (Artista artists2 : artistaCancion) {
					System.out.println(artists2);
				}

				System.out.print("¿DE QUE ARTISTA DESEA VER TODAS SUS CANCIONES? [ID]: ");
				int artistasID = sc.nextInt();

				List<Canciones> canciones = cDAO.listarArtistas(artistasID);
				for (int i = 0; i < canciones.size(); i++) {

					System.out.println(canciones.get(i));
				}

				break;

			case 4: // ACTUALIZAR EDAD DE UN ARTISTA

				

				List<Artista> artistaCancionEdad = aDAO.listarArtistas();

				for (Artista artistas2 : artistaCancionEdad) {
					System.out.println(artistas2);
				}

				System.out.print("¿INSERTE UN ARTISTA PARA MODIFICAR SU EDAD? [ID]: ");
				int idArtistaCambiaEdad = sc.nextInt();

				Artista artistaCambiaEdad= aDAO.recibeInformacion(idArtistaCambiaEdad);

				System.out.print("ESCRIBA LA NUEVA EDAD DE " + artistaCambiaEdad.getNombre() + " "
						+ artistaCambiaEdad.getApellidos() + ": ");
				int nuevaEdad = sc.nextInt();

				if (artistaCambiaEdad != null) {

					artistaCambiaEdad.setEdad(nuevaEdad);

					if (aDAO.cambiarEdad(artistaCambiaEdad)) {
						System.out.println("EDAD DE " + artistaCambiaEdad.getNombre() + " "
								+ artistaCambiaEdad.getApellidos() + " ACTUALIZADA");
					} else {
						System.out.println("ERROR, NO SE HA PODIDO ACTUALIZAR LA EDAD DE "
								+ artistaCambiaEdad.getNombre() + " " + artistaCambiaEdad.getApellidos());
					}
				}

				break;

			case 5: 
					

				List<Artista> artistaPais1 = aDAO.listarArtistas();

				for (Artista artistas2 : artistaPais1) {
					System.out.println(artistas2);
				}

				System.out.print("¿A QUE PAIS QUIERES AÑADIR 1 MINUTO MAS A TODAS SUS CANCIONES?: ");
				String paisAnadirMin = sc.next().toUpperCase();

	

					List<String> nombrePais = aDAO.artistaPais(paisAnadirMin);
				
					if (cDAO.actualizarCancionDuracion_Pais(nombrePais)) {

					System.out.println("DURACION DE LAS CANCIONES DE " + paisAnadirMin + " ACTUALIZADAS");
				} else {
					System.out.println("ERROR, NO SE HA PODIDO ACTUALIZAR");
				}

				break;

			case 6: // BORRAR TODAS LAS CANCIONES DE UN DETERMINADO ARTISTA

				List<Artista> eliminarCanciones = aDAO.listarArtistas();

				for (Artista artistas2 : eliminarCanciones) {
					System.out.println(artistas2);
				}

				System.out.print("¿A QUE ARTISTA DESEA BORRAR TODAS SUS CANCIONES? [ID]: ");
				int idArtistaAEliminarCanciones = sc.nextInt();

				if (cDAO.eliminarCancionesArtistas(idArtistaAEliminarCanciones)) {
					System.out.println("SE HAN BORRADO CORRECTAMENTE TODAS LAS CANCIONES");
				} else {
					System.out.println("ERROR, NO SE HAN PODIDO BORRAR LAS CANCIONES");
				}

				break;

			case 7: // MOSTRAR TODO (ARTISTA Y SUS CANCIONES)

			
				
				List<Artista> artista = aDAO.listarArtistas();
				List<Canciones> cancion = cDAO.listarCanciones();
				List<Estilo> estilo32 = eDAO.ListarTodosEstilos();
				
				
				System.out.println("+----------------------------------+");
				System.out.println("|             ESTILOS              |");
				System.out.println("+----------------------------------+");


				for (Estilo estilo2 : estilo32) {
					System.out.println(estilo2);
				}
				
				System.out.println();System.out.println();
				
				System.out.println("+----------------------------------+");
				System.out.println("|             ARTISTAS             |");
				System.out.println("+----------------------------------+");


				for (Artista artistas2 : artista) {
					System.out.println(artistas2);
				}
				
				System.out.println();System.out.println();
				
				System.out.println("+----------------------------------+");
				System.out.println("|            CANCIONES             |");
				System.out.println("+----------------------------------+");

				
				for (Canciones cancion2 : cancion) {
					System.out.println(cancion2);
				}
				
				System.out.println();System.out.println();
				break;

			}
			System.out.println();
			System.out.println("PULSE 0 VOLVER AL MENU PRINCIPAL");
			sc.next();
		} while (opcionMenu != 0);

		sc.close();
		
		

	}

}
