package servicio;

import java.util.List;
import java.util.Scanner;

import modelo.CategoriaEnum;
import modelo.Cliente;
import utilidades.Utilidad;

public class ClienteServicio {
	List<Cliente> listaClientes;

	
	public ClienteServicio(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
	public void retornolistarClientes(){
		if (listaClientes.size()>0) {
			for (Cliente cliente : listaClientes) {
				System.out.println(cliente);
			}
			
		}else {
			System.out.println("\n-------------------------\n"
					+ "No hay datos para mostrar.\n"
					+ "-------------------------\n");
		}
	}

	public Cliente agregarCliente(Cliente cliente) {
		this.listaClientes.add(cliente);
		return cliente;
	}
	
	public void editarCliente() {
		Scanner sc = new Scanner(System.in);
		String run, opcion;
		boolean existe = false;
		if (listaClientes.size() > 0) {
			try {
				System.out.println("-------------Editar Cliente-------------"
						+ "\nSeleccione que desea hacer:"
						+ "\n1.-Cambiar el estado del Cliente"
						+ "\n2.-Editar los datos ingresados del Cliente"
						+ "\nIngrese opcion: "
						+"\n----------------------------------------");
				opcion = sc.nextLine();
				if(opcion.equals("1")) {
					System.out.println("Ingrese RUN del Cliente a editar: ");
					run = sc.nextLine();
					for (Cliente cliente : listaClientes) {
						if (cliente.getRunCliente().equals(run)) {
							existe = true;
							System.out.println("-----Actualizando estado del Cliente----\n"
									+ "El estado actual es: "+((cliente.getNombreCategoria()==CategoriaEnum.ACTIVO)?"Activo":"Inactivo")
									+"\n1.-Si desea cambiar el estado del Cliente a Inactivo"
									+"\n2.-Si desea cambiar el estado del Cliente a Activo"
									+"\nIngrese opción: "
									+"\n----------------------------------------\n");
							String opcion2 = sc.nextLine();
								if (opcion2.equals("1")) {
									cliente.setNombreCategoria(CategoriaEnum.INACTIVO);
									System.out.println(cliente);
									System.out.println("Estado del cliente cambiado con éxito");
								}
								else if(opcion2.equals("2")) {
									cliente.setNombreCategoria(CategoriaEnum.ACTIVO);
									System.out.println(cliente);
									System.out.println("Estado del cliente cambiado con éxito");
								}
								else System.out.println("Opcion no valida, regresando al menu principal");
						}
						
					}
				}else if(opcion.equals("2")) {
				System.out.println("Ingrese RUN del Cliente a editar: ");
				run = sc.nextLine();
				for (Cliente cliente : listaClientes) {
					if (cliente.getRunCliente().equals(run)) {
						int num = -1;
						while (num < 1 || num > 4) {
							existe = true;
							try {
								Utilidad.clear(2);
								System.out.println("----Actualizando datos del Cliente-----\n");
								System.out.println("1​.-El RUN del Cliente es: "+ cliente.getRunCliente());
								System.out.println("2​.-El Nombre del Cliente es : ​" + cliente.getNombreCliente());
								System.out.println("3​.-El Apellido del Cliente es :" + cliente.getApellidoCliente());
								System.out.println("4​.-Los años como Cliente son: " + cliente.getAniosCliente());
								System.out.println();
								System.out.println("Ingrese la opción a editar de los datos del producto:");
								num = Integer.parseInt(sc.nextLine());
							} catch (Exception e) {
								System.out.println("ERROR Opcion no valida, se esperaba un número");
							}
							switch (num) {
							case 1:
								System.out.println("Ingresar nuevo RUN del Cliente: ");
								cliente.setRunCliente(sc.nextLine());
								break;
							case 2:
								System.out.println("Ingresar nuevo nombre del Cliente: ");
								cliente.setNombreCliente(sc.nextLine());
								break;
							case 3:
								System.out.println("Ingresar nuevo apellido del Cliente: ");
								cliente.setApellidoCliente(sc.nextLine());
								break;
							case 4:
								System.out.println("Ingresar cantidad de años como cliente: ");
								cliente.setAniosCliente(sc.nextLine());
								break;
							default:
								System.out.println("Ingrese un numero válido");
								break;
							}

						}

						System.out.println(cliente.toString());
						System.out.println("Datos cambiados con éxito");
						Utilidad.clear(1);
					}
				}
			}else {
				existe=true;
				System.out.println("Error opción invalida\nVolviendo al menú principal\n");
			}
			} catch (Exception e2) {
				System.out.println("ERROR Opcion no valida\nse espera un numero valido.\n");
			}
			if (!existe) {
				Utilidad.clear(4);
				System.out.println("-------------------------");
				System.out.println("No se encontró el RUT."
							   + "\nVolviendo al menu principal");
				System.out.println("-------------------------");
			}
		} else {
			Utilidad.clear(4);
			System.out.println("-------------------------");
			System.out.println("No hay datos para editar.");
			System.out.println("-------------------------");
		}
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}
	

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}


	
	
}
