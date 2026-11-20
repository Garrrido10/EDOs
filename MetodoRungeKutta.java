public class MetodoRungeKutta {

    public static double evaluarFuncion(double x, double y) {
        return x + y;
    }

    public static double solucionExacta(double x) {
        return 2.0 * Math.exp(x) - x - 1.0;
    }

    public static void ejecutarSimulacion(double x0, double y0, double h, double xFinal) {
        int nPasos = (int) Math.round((xFinal - x0) / h);
        double x = x0;
        double y = y0;

        System.out.printf("=== Método de Runge-Kutta 4to Orden (h = %.2f, N = %d) ===%n", h, nPasos);
        System.out.println("n\tx_n\t\ty_n (RK4)\ty_exacta\tError Abs");
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
        double k1 = evaluarFuncion(x, y);
        double k2 = evaluarFuncion(x + 0.5 * h, y + 0.5 * h * k1);
        double k3 = evaluarFuncion(x + 0.5 * h, y + 0.5 * h * k2);
        double k4 = evaluarFuncion(x + h, y + h * k3);

        return y + (h / 6.0) * (k1 + 2.0 * k2 + 2.0 * k3 + k4);
    }

    private static double avanzarX(double x0, int paso, double h) {
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
        double h = 0.1;
        double xFinal = 0.3;

        ejecutarSimulacion(x0, y0, h, xFinal);
    }
}
