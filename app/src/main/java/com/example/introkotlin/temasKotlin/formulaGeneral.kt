package com.example.introkotlin.temasKotlin
import kotlin.math.sqrt

fun main() {
    while (true) {
        println("Ingrese el coeficiente a:")
        val a = readln().toDoubleOrNull()

        if (a == null) {
            println("Error: El coeficiente 'a' debe ser un número válido.")
            continue
        }
        if (a == 0.0){
            println("Error: El coeficiente 'a' no puede ser 0.")
            continue
        }

        println("Ingrese el coeficiente b:")
        val b = readln().toDoubleOrNull()

        if (b == null) {
            println("Error: El coeficiente 'b' debe ser un número válido.")
            continue
        }

        println("Ingrese el coeficiente c:")
        val c = readln().toDoubleOrNull()

        if (c == null) {
            println("Error: El coeficiente 'c' debe ser un número válido.")
            continue
        }

        val discriminante = b * b - 4 * a * c

        if (discriminante < 0) {
            println("La ecuación no tiene soluciones reales. Intente con otros coeficientes.")
            continue
        } else {
            val x1 = (-b + sqrt(discriminante)) / (2 * a)
            val x2 = (-b - sqrt(discriminante)) / (2 * a)

            println("Las soluciones son:")
            println("x1 = $x1")
            println("x2 = $x2")
            break
        }
    }
}