# SCC-1017 Métodos Numéricos — Unidad 6: Resolución Numérica de EDOs

Implementación modular en **Java** de los métodos numéricos de **Euler** y **Runge-Kutta de 4to orden (RK4)** para la resolución de Ecuaciones Diferenciales Ordinarias (EDOs) con criterio de paro en número de pasos `N`, comparación contra soluciones analíticas exactas y análisis de error absoluto.

## Datos Académicos
* **Materia:** SCC-1017 Métodos Numéricos
* **Unidad:** Unidad 6 — Resolución Numérica de EDOs
* **Docente:** Víctor Hugo Vásquez Herrera
* **Institución:** Instituto Tecnológico Superior de Xalapa (ITSX) — Ingeniería en Sistemas Computacionales
* **Autor:** Gustavo Ángel Viveros Garrido (`Garrrido10`)

## Estructura del Repositorio

```text
.
├── MetodoEuler.java       # Implementación modular del método de Euler y análisis de h
├── MetodoRungeKutta.java  # Implementación modular del método RK4 (pendientes k1..k4)
└── README.md              # Documentación, compilación y ejecución
```

## Problemas Resueltos

1. **Actividad 1 — Método de Euler:**
   * **EDO:** `y' = x - y`, con `y(0) = 1` en `[0, 0.3]`
   * **Solución exacta:** `y(x) = x - 1 + 2e^(-x)`
   * **Tamaños de paso evaluados:** `h = 0.1`, `h = 0.05`, `h = 0.01`

2. **Actividad 2 — Runge-Kutta de 4to Orden (RK4):**
   * **EDO:** `y' = x + y`, con `y(0) = 1` en `[0, 0.3]`
   * **Solución exacta:** `y(x) = 2e^x - x - 1`
   * **Tamaño de paso base:** `h = 0.1`

## Clonación, Compilación y Ejecución desde Terminal

```bash
# 1. Clonar el repositorio
git clone [https://github.com/Garrrido10/](https://github.com/Garrrido10/)<EDOs>.git
cd <EDOs>

# 2. Compilar las clases Java
javac MetodoEuler.java MetodoRungeKutta.java

# 3. Ejecutar Método de Euler
java MetodoEuler

# 4. Ejecutar Runge-Kutta de 4to orden
java MetodoRungeKutta
```
