/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package presentacion;

import controllers.ActivistaController;
import controllers.ClienteController;
import controllers.ProblemaActivistaController;
import controllers.ProblemaController;
import java.time.LocalDate;
import java.util.List;
import models.Activista;
import models.Cliente;
import models.Problema;
import models.ProblemaActivista;

/**
 *
 * @author jalt2
 */
public class PresentacioActivistas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ClienteController clienteController = new ClienteController();


        boolean agregado = clienteController.agregarCliente(
                "Pedro Gómez",
                "Av. Insurgentes 900, CDMX",
                "555-9999"
        );

        System.out.println("Cliente agregado: " + agregado);



        Cliente c = clienteController.obtenerPorID(1);

        if (c != null) {
            System.out.println("\nCliente encontrado:");
            System.out.println("ID: " + c.getId());
            System.out.println("Nombre: " + c.getNombre());
            System.out.println("Dirección: " + c.getDireccion());
            System.out.println("Teléfonos: " + c.getTelefonos());
        } else {
            System.out.println("Cliente no encontrado.");
        }



        List<Cliente> clientes = clienteController.obtenerTodos();

        if (clientes != null) {
            System.out.println("\nLista de clientes:");
            for (Cliente cli : clientes) {
                System.out.println("-----------------------");
                System.out.println("ID: " + cli.getId());
                System.out.println("Nombre: " + cli.getNombre());
                System.out.println("Dirección: " + cli.getDireccion());
                System.out.println("Teléfonos: " + cli.getTelefonos());
            }
        } else {
            System.out.println("No hay clientes registrados.");
        }



        Cliente actualizar = clienteController.obtenerPorID(1);

        if (actualizar != null) {
            actualizar.setDireccion("Calle Reforma 1200, CDMX");
            actualizar.setTelefonos("555-0000");

            boolean actualizado = clienteController.actualizarCliente(actualizar);
            System.out.println("\nCliente actualizado: " + actualizado);
        }



        boolean clienteEliminado = clienteController.eliminarCliente(10);
        System.out.println("\nCliente eliminado: " + clienteEliminado);
        
        
        ProblemaController controllerProblema = new ProblemaController();


        Problema nuevo = new Problema();
        nuevo.setFch_inicio(LocalDate.of(2026, 2, 15));
        nuevo.setFch_fin(null);
        nuevo.setEstado("pendiente");
        nuevo.setIdCliente(1); // Cliente existente

        boolean insertado = controllerProblema.insertarProblema(nuevo);
        System.out.println("Problema insertado: " + insertado);



        Problema p = controllerProblema.obtenerPorID(1);

        if (p != null) {
            System.out.println("\nProblema encontrado:");
            System.out.println("ID: " + p.getIdProblema());
            System.out.println("Estado: " + p.getEstado());
            System.out.println("Fecha inicio: " + p.getFch_inicio());
            System.out.println("Cliente ID: " + p.getIdCliente());
        } else {
            System.out.println("Problema no encontrado.");
        }



        List<Problema> lista = controllerProblema.obtenerTodos();

        if (lista != null) {
            System.out.println("\nLista de problemas:");
            for (Problema pr : lista) {
                System.out.println("----------------------");
                System.out.println("ID: " + pr.getIdProblema());
                System.out.println("Estado: " + pr.getEstado());
                System.out.println("Fecha inicio: " + pr.getFch_inicio());
                System.out.println("Cliente ID: " + pr.getIdCliente());
            }
        } else {
            System.out.println("No hay problemas registrados.");
        }



        Problema actualizarProblema = controllerProblema.obtenerPorID(1);

        if (actualizar != null) {
            actualizarProblema.setEstado("concluido");
            actualizarProblema.setFch_fin(LocalDate.now());

            boolean actualizado = controllerProblema.actualizarProblema(actualizarProblema);
            System.out.println("\nProblema actualizado: " + actualizado);
        }



        boolean finalizado = controllerProblema.finalizarProblema(3);
        System.out.println("\nProblema finalizado correctamente: " + finalizado);



        boolean problemaEliminado = controllerProblema.eliminarProblema(6);
        System.out.println("\nProblema eliminado: " + problemaEliminado);
        
        
        
        ActivistaController activistaController = new ActivistaController();


        boolean activistaAgregado = activistaController.agregarActivista(
                "Ricardo Silva",
                "ricardo@gmail.com",
                "555-1212"
        );

        System.out.println("Activista agregado: " + activistaAgregado);



        Activista a = activistaController.obtenerPorID(1);

        if (a != null) {
            System.out.println("\nActivista encontrado:");
            System.out.println("ID: " + a.getId());
            System.out.println("Nombre: " + a.getNombre());
            System.out.println("Correo: " + a.getCorreo());
            System.out.println("Teléfono: " + a.getTelefono());
        } else {
            System.out.println("Activista no encontrado.");
        }


        List<Activista> listaActivista = activistaController.obtenerTodos();

        if (lista != null) {
            System.out.println("\nLista de activistas:");
            for (Activista act : listaActivista) {
                System.out.println("-----------------------");
                System.out.println("ID: " + act.getId());
                System.out.println("Nombre: " + act.getNombre());
                System.out.println("Correo: " + act.getCorreo());
                System.out.println("Teléfono: " + act.getTelefono());
            }
        } else {
            System.out.println("No hay activistas registrados.");
        }


        Activista actualizarActivista = activistaController.obtenerPorID(1);

        if (actualizar != null) {
            actualizarActivista.setTelefono("555-0000");
            actualizarActivista.setCorreo("nuevoCorreo@gmail.com");

            boolean actualizado = activistaController.actualizar(actualizarActivista);
            System.out.println("\nActivista actualizado: " + actualizado);
        }

        boolean activistaEliminado = activistaController.eliminar(10);
        System.out.println("\nActivista eliminado: " + activistaEliminado);
        
        
        
        ProblemaActivistaController controllerProblemaActivista = new ProblemaActivistaController();

        boolean asignado = controllerProblemaActivista.asignarActivistaAProblema(1, 2);
        System.out.println("Activista asignado a problema: " + asignado);



        ProblemaActivista relacion = new ProblemaActivista(3, 1);
        boolean problemaActivistaInsertado = controllerProblemaActivista.insertar(relacion);
        System.out.println("Relación insertada: " + problemaActivistaInsertado);



        ProblemaActivista pa = controllerProblemaActivista.obtenerPorID(1, 2);

        if (pa != null) {
            System.out.println("\nRelación encontrada:");
            System.out.println("ID Problema: " + pa.getIdProblema());
            System.out.println("ID Activista: " + pa.getIdActivista());
        } else {
            System.out.println("Relación no encontrada.");
        }


        List<ProblemaActivista> listaProblemaActivista = controllerProblemaActivista.obtenerTodos();

        if (lista != null) {
            System.out.println("\nLista de relaciones:");
            for (ProblemaActivista rel : listaProblemaActivista) {
                System.out.println("-----------------------");
                System.out.println("Problema: " + rel.getIdProblema());
                System.out.println("Activista: " + rel.getIdActivista());
            }
        } else {
            System.out.println("No hay relaciones registradas.");
        }


        boolean relacionEliminada = controllerProblemaActivista.eliminarRelacion(1, 2);
        System.out.println("\nRelación eliminada: " + relacionEliminada);
    
        
    }  
}
