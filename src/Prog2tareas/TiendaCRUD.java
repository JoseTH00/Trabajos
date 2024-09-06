package Prog2tareas;

import java.util.ArrayList;

class ClienteTienda {
    private int Id;
    private String nombreClt, correoClt, numTelClt;

    public ClienteTienda() {
    }

    public ClienteTienda(int id, String nombreClt, String correoClt, String numTelClt) {
        Id = id;
        this.nombreClt = nombreClt;
        this.correoClt = correoClt;
        this.numTelClt = numTelClt;
    }

    public int getId() {
        return Id;
    }

    private void setId(int id) {
        Id = id;
    }

    public String getNombreClt() {
        return nombreClt;
    }

    public void setNombreClt(String nombreClt) {
        this.nombreClt = nombreClt;
    }

    public String getCorreoClt() {
        return correoClt;
    }

    public void setCorreoClt(String correoClt) {
        this.correoClt = correoClt;
    }

    public String getNumTelClt() {
        return numTelClt;
    }

    public void setNumTelClt(String numTelClt) {
        this.numTelClt = numTelClt;
    }

    @Override
    public String toString() {
        return "ClienteTienda{" +
                "Id=" + Id +
                ", nombre del cliente='" + nombreClt + '\'' +
                ", correo del cliente='" + correoClt + '\'' +
                ", numero de telefono del cliente='" + numTelClt + '\'' +
                '}';
    }
}

class Tienda {
    private ArrayList<ClienteTienda> clienteTiendas;

    public Tienda() {
        clienteTiendas = new ArrayList<>();
    }

    public void agregarCliente(ClienteTienda clienteTienda) {
        clienteTiendas.add(clienteTienda);
    }

    public void MostrarClientes() {
        if (clienteTiendas.isEmpty()) {
            System.out.println("No hay clientes");
        } else {
            for (ClienteTienda clienteTienda : clienteTiendas) {
                System.out.println(clienteTienda);
            }
        }
    }

    public ClienteTienda BuscarPorId(int id) {
        for (ClienteTienda clienteTienda : clienteTiendas) {
            if (clienteTienda.getId()==id) {
                return clienteTienda;
            }
        }
        return null;
    }

    public ClienteTienda BuscarPorNombre(String nombre) {
        for (ClienteTienda clienteTienda : clienteTiendas) {
            if (clienteTienda.getNombreClt().equals(nombre)) {
                return clienteTienda;
            }
        }
        return null;
    }

    public ClienteTienda BuscarPorCorreo(String correo) {
        for (ClienteTienda clienteTienda : clienteTiendas) {
            if (clienteTienda.getCorreoClt().equals(correo)) {
                return clienteTienda;
            }
        }
        return null;
    }

    public ClienteTienda BuscarPorNumTel(String numTel) {
        for (ClienteTienda clienteTienda : clienteTiendas) {
            if (clienteTienda.getNumTelClt().equals(numTel)) {
                return clienteTienda;
            }
        }
        return null;
    }

    public ClienteTienda BuscarCliente(String criterio, String valor) {
        switch (criterio.toLowerCase()) {
            case "id":
                try {
                    int id = Integer.parseInt(valor);
                    return BuscarPorId(id);
                } catch (NumberFormatException e) {
                    System.out.println("El valor proporcionado para el ID no es un número válido.");
                    return null;
                }
            case "nombre":
                return BuscarPorNombre(valor);
            case "correo":
                return BuscarPorCorreo(valor);
            case "telefono":
                return BuscarPorNumTel(valor);
            default:
                System.out.println("Criterio de búsqueda no válido. Use 'id', 'nombre', 'correo' o 'telefono'.");
                return null;
        }
    }


    public void modificarCliente(String criterio, String valor, String nuevoNombre, String nuevoCorreo, String nuevoTelefono) {
        ClienteTienda clienteAEditar = BuscarCliente(criterio, valor);

        if (clienteAEditar != null) {

            if (nuevoNombre != null && !nuevoNombre.isEmpty()) {
                clienteAEditar.setNombreClt(nuevoNombre);
            }
            if (nuevoCorreo != null && !nuevoCorreo.isEmpty()) {
                clienteAEditar.setCorreoClt(nuevoCorreo);
            }
            if (nuevoTelefono != null && !nuevoTelefono.isEmpty()) {
                clienteAEditar.setNumTelClt(nuevoTelefono);
            }
            System.out.println("Cliente modificado con éxito.");
        } else {
            System.out.println("Cliente no encontrado para modificar.");
        }
    }


    public void eliminarCliente(String criterio, String valor) {
        ClienteTienda clienteTienda = BuscarCliente(criterio, valor);

        if (clienteTienda != null) {
            clienteTiendas.remove(clienteTienda);
            System.out.println("Cliente eliminado con éxito.");
        } else {
            System.out.println("No se encontró el cliente para eliminar.");
        }
    }
}

class GestionDeClientes {
    public static void main(String[] args) {
        Tienda tienda = new Tienda();

        ClienteTienda cliente1 = new ClienteTienda(1, "Juan Perez", "juan@gmail.com", "123456789");
        ClienteTienda cliente2 = new ClienteTienda(2, "Maria Lopez", "maria@gmail.com", "987654321");

        tienda.agregarCliente(cliente1);
        tienda.agregarCliente(cliente2);

        System.out.println("Lista de clientes:");
        tienda.MostrarClientes();

        System.out.println("\nBuscar cliente por nombre 'Juan Perez':");
        ClienteTienda clienteEncontrado = tienda.BuscarCliente("nombre", "Juan Perez");
        if (clienteEncontrado != null) {
            System.out.println("Cliente encontrado: " + clienteEncontrado);
        } else {
            System.out.println("Cliente no encontrado.");
        }

        System.out.println("\nModificar cliente con nombre 'Juan Perez':");
        tienda.modificarCliente("nombre", "Juan Perez", "Juan Carlos", "juan.carlos@hotmail.com", "111222333");

        System.out.println("\nLista de clientes después de la modificación:");
        tienda.MostrarClientes();

        System.out.println("\nEliminar cliente con ID 1:");
        tienda.eliminarCliente("id","1");

        System.out.println("\nLista de clientes después de la eliminación:");
        tienda.MostrarClientes();
    }
}

