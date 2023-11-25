import java.util.ArrayList;

public class GrafoDFSNoDirigido {
    private int V;
    private ArrayList<ArrayList<Integer>> grafo;

    public GrafoDFSNoDirigido(int v) {
        V = v;
        grafo = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            grafo.add(new ArrayList<>());
        }
    }

    public void agregarArista(int origen, int destino) {
        grafo.get(origen).add(destino);
        grafo.get(destino).add(origen); // Añadir la arista en ambas direcciones
    }

    public void DFS() {
        boolean[] visitado = new boolean[V];

        for (int u = 0; u < V; u++) {
            if (!visitado[u]) {
                System.out.println("Iniciando DFS desde el vértice " + u);
                DFSVisitar(u, visitado);
            }
        }
    }

    private void DFSVisitar(int u, boolean[] visitado) {
        visitado[u] = true;
        System.out.println("Visitando el vértice " + u);

        for (int v : grafo.get(u)) {
            if (!visitado[v]) {
                DFSVisitar(v, visitado);
            }
        }
    }

    public static void main(String[] args) {
        GrafoDFSNoDirigido grafo = new GrafoDFSNoDirigido(8);
        grafo.agregarArista(0, 1);
        grafo.agregarArista(0, 2);
        grafo.agregarArista(0, 3);
        grafo.agregarArista(0, 7);
        grafo.agregarArista(1, 2);
        grafo.agregarArista(1, 6);
        grafo.agregarArista(1, 3);
        grafo.agregarArista(1, 4);
        grafo.agregarArista(1, 7);
        grafo.agregarArista(2, 5);
        grafo.agregarArista(2, 6);
        grafo.agregarArista(3, 4);
        grafo.agregarArista(5, 6);
        grafo.agregarArista(7, 5);

        System.out.println("Recorrido DFS del grafo no dirigido:");
        grafo.DFS();
    }
}


