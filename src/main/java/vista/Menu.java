package vista;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.Cliente;
import utilidades.Utilidad;
import servicio.ArchivoServicio;
import servicio.ClienteServicio;
import servicio.ExportadorCsv;
import servicio.ExportadorTxt;

public class Menu {
	Scanner sc = new Scanner(System.in);
	ClienteServicio clienteServicio = new ClienteServicio(new ArrayList<Cliente>());
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
		boolean todoCorrecto=false;
		while(todoCorrecto== false) {
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
		if(nuevo.getAniosCliente().equals("")||nuevo.getApellidoCliente().equals("")||nuevo.getNombreCliente().equals("")||nuevo.getRunCliente().equals("")) {
			System.out.println("Debe ingresar todos los datos");
		}else {
			lista.agregarCliente(nuevo);
			todoCorrecto=true;
		}
		}
	}

	public void editarCliente(ClienteServicio lista) {
		lista.editarCliente();
	}

	public void importarDatos(ClienteServicio lista) {
		archivoServicio.cargarDatos(fileName1, lista);
	}

	public void exportarDatos(ClienteServicio lista) {
		Scanner sc = new Scanner(System.in);
		
		List<Cliente> nuevaLista = lista.getListaClientes();		
		String opcion = "";
		System.out.println("\n---------Exportar Datos-----------"
				+ "\nSeleccione el formato a exportar: "
				+ "\n1.-Formato csv"
				+ "\n2.-Formato txt"
				+ "\n\nIngrese una opción para exportar:"
				+ "\n----------------------------------");
		opcion = sc.nextLine();
		if (opcion.equals("1")) {
			exportadorCsv.exportar(fileName,nuevaLista);
		}else if(opcion.equals("2")){
			exportadorTxt.exportar(fileName,nuevaLista);
		}else {
			System.out.println("Opción invalida, volviendo al menu principal");
			Utilidad.clear(1);
		}
	}

	public void terminarPrograma() {
		System.out.println("Abandonando el sistema de productos...\n");
		Utilidad.tiempo();
		Utilidad.clear(20);
		System.out.println("Acaba de salir del sistema");
	}

	public void iniciarMenu() {
		Scanner sc = new Scanner(System.in);
		int opcion = -1;
		while (opcion != 6) {
			try {
				System.out.println(menu);
				opcion = Integer.parseInt(sc.nextLine());
		} catch (Exception e) {
			System.out.println("ERROR Opcion no valida, se esperaba un número");
		}
			switch (opcion) {
			case 1:
				listarCliente(clienteServicio);
				break;
			case 2:
				agregarCliente(clienteServicio);
				break;
			case 3:
				editarCliente(clienteServicio);
				break;
			case 4:
				importarDatos(clienteServicio);
				break;
			case 5:
				exportarDatos(clienteServicio);
				break;
			case 6:
				terminarPrograma();
				break;
			default:
				Utilidad.clear(10);
				System.out.println("Error, elija una de las siguientes opciones...");
				break;
			}
		}
	}
}
