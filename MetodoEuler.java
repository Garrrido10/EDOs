public class MetodoEuler {

    public static double evaluarFuncion(double x, double y) {
        return x - y;
    }

    public static double solucionExacta(double x) {
        return x - 1.0 + 2.0 * Math.exp(-x);
    }

    public static void ejecutarSimulacion(double x0, double y0, double h, double xFinal) {
        int nPasos = (int) Math.round((xFinal - x0) / h);
        double x = x0;
        double y = y0;

        System.out.printf("=== Método de Euler (h = %.2f, N = %d) ===%n", h, nPasos);
        System.out.println("n\tx_n\t\ty_n (Euler)\ty_exacta\tError Abs");
        System.out.println("------------------------------------------------------------------------");

        imprimirFila(0, x, y);

        for (int i = 0; i < nPasos; i++) {
            y = calcularSiguienteY(x, y, h);
            x = avanzarX(x0, i + 1, h);
            imprimirFila(i + 1, x, y);
        }
        System.out.println();
    }

    public static double calcularSiguienteY(double x, double y, double h) {
        double pendiente = evaluarFuncion(x, y);
        return y + h * pendiente;
    }

    private static double avanzarX(double x0, int paso, double h) {
        // Evita acumulacion de error de punto flotante en x_n
        return Math.round((x0 + paso * h) * 1e6) / 1e6;
    }

    private static void imprimirFila(int n, double x, double y) {
        double yExacta = solucionExacta(x);
        double errorAbs = Math.abs(yExacta - y);
        System.out.printf("%d\t%.4f\t\t%.6f\t%.6f\t%.6e%n", n, x, y, yExacta, errorAbs);
    }

    public static void main(String[] args) {
        double x0 = 0.0;
        double y0 = 1.0;
        double xFinal = 0.3;

        // Ejecucion base requerida (h = 0.1) y refinamientos experimentales (0.05 y 0.01)
        double[] pasosExperimentales = {0.1, 0.05, 0.01};
        for (double h : pasosExperimentales) {
            ejecutarSimulacion(x0, y0, h, xFinal);
        }
    }
}
