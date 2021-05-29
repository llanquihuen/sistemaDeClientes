package vista;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.Cliente;
import modelo.CategoriaEnum;
import utilidades.Utilidad;
import servicio.ArchivoServicio;
import servicio.ClienteServicio;
import servicio.ExportadorCsv;
import servicio.ExportadorTxt;

public class Menu {
	Scanner sc = new Scanner(System.in);
	ClienteServicio clienteServicio = new ClienteServicio(null);
	ArchivoServicio archivoServicio = new ArchivoServicio();
	ExportadorCsv exportadorCsv = new ExportadorCsv();
	ExportadorTxt exportadorTxt = new ExportadorTxt();
	String fileName = "Clientes";// (para exportar el archivo)
	String fileName1 = "DBClientes.csv";// (para importar el archivo)

	public static String menu = "1. Listar Clientes\n" + "2. Agregar Cliente\n" + "3. Editar Cliente\n"
			+ "4. Cargar Datos\n" + "5. Exportar Datos\n" + "6. Salir\n" + "Ingrese una opción:";

	public void listarCliente(ClienteServicio lista) {
		Utilidad.clear(10);
		System.out.println("Lista de datos de los Clientes: \n");
		lista.retornolistarClientes();
	}

	public void agregarCliente(ClienteServicio lista) {
		Scanner sc = new Scanner(System.in);
		Cliente nuevo = new Cliente();
		System.out.println("-------------Crear Cliente-------------");
		System.out.println("Ingresa RUN del Cliente: ");
		nuevo.setRunCliente(sc.nextLine());
		System.out.println("Ingresa Nombre del Cliente: ");
		nuevo.setNombreCliente(sc.nextLine());
		System.out.println("Ingresa Apellido del Cliente: ");
		nuevo.setApellidoCliente(sc.nextLine());
		System.out.println("Ingresa años como Cliente: ");
		nuevo.setAniosCliente(sc.nextLine());
		System.out.println("--------------------------------------");
		lista.agregarCliente(nuevo);
	}

	public void editarCliente(ClienteServicio lista) {
		lista.editarCliente();

	}

	public void importarDatos(ClienteServicio lista) {
		ArchivoServicio as = new ArchivoServicio();
		System.out.println("Ingresa la ruta en donde se encuentra el archivo DBClientes.csv:");
		String ruta = sc.nextLine();
		as.cargarDatos(ruta, lista);
	}

	public void exportarDatos(ClienteServicio lista) {
		Scanner sc = new Scanner(System.in);
		
		List<Cliente> nuevaLista = lista.getListaClientes();		
		String opcion = "";
		ExportadorTxt expoTxt = new ExportadorTxt();
		ExportadorCsv expoCsv = new ExportadorCsv();
		System.out.println("\n---------Exportar Datos-----------"
				+ "\nSeleccione el formato a exportar: "
				+ "\n1.-Formato csv"
				+ "\n2.-Formato txt"
				+ "\n\nIngrese una opción para exportar:"
				+ "\n----------------------------------");
		opcion = sc.nextLine();
		if (opcion.equals("1")) {
			System.out.println("Ingresa la ruta en donde desea exportar el archivo clientes.csv:");
			String ruta = sc.nextLine();
			expoCsv.exportar(ruta,nuevaLista);
			
		}else if(opcion.equals("2")){
			System.out.println("Ingresa la ruta en donde desea exportar el archivo clientes.txt:");
			String ruta = sc.nextLine();
			expoTxt.exportar(ruta,nuevaLista);
		}else {
			System.out.println("Opción invalida, volviendo al menu principal");

		}
		

		
		
		
	}

	public void terminarPrograma() {
		System.out.println("Abandonando el sistema de productos...\n");
		Utilidad.tiempo();
		Utilidad.clear(20);
		System.out.println("Acaba de salir del sistema");
	}

	public void iniciarMenu() {
		ClienteServicio listaDeClientes = new ClienteServicio(new ArrayList<Cliente>());
//		listaDeClientes.agregarCliente(new Cliente("11.111.111-1", "Juan","Perez", "1 Año", CategoriaEnum.ACTIVO ));
//		listaDeClientes.agregarCliente(new Cliente("22.222.222-2", "Pedro","Soto", "9 Meses", CategoriaEnum.INACTIVO ));

		Scanner sc = new Scanner(System.in);
		String opcion = "";

		while (!opcion.equals("6")) {
			System.out.println(menu);
			opcion = sc.nextLine();
			if (opcion.equals("1")) {
				listarCliente(listaDeClientes);
			} else if (opcion.equals("2")) {
				agregarCliente(listaDeClientes);
			} else if (opcion.equals("3")) {
				editarCliente(listaDeClientes);
			} else if (opcion.equals("4")) {
				importarDatos(listaDeClientes);
			} else if (opcion.equals("5")) {
				exportarDatos(listaDeClientes);
			} else if (opcion.equals("6")) {
				terminarPrograma();
			} else if (!opcion.equals("6")) {
				Utilidad.clear(20);
				System.out.println("Error, elija una de las siguientes opciones...");
			}
		}

	}
}
