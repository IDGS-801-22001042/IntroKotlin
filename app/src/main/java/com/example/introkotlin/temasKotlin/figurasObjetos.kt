package com.example.introkotlin.temasKotlin

// Nombre del commit 12/05/2025 - Clases
import kotlin.math.PI
import kotlin.math.pow

class CalculadoraCirculo {
    fun calcularArea(radio: Double): Double {
        return PI * radio.pow(2.0)
    }
}

class CalculadoraCuadrado {
    fun calcularArea(lado: Double): Double {
        return lado.pow(2.0)
    }
}

class CalculadoraPentagono {
    fun calcularArea(lado: Double, apotema: Double): Double {
        return (5 * lado * apotema) / 2
    }
}

class CalculadoraTriangulo {
    fun calcularArea(base: Double, altura: Double): Double {
        return (base * altura) / 2
    }
}


fun main() {
    val calcCirculo = CalculadoraCirculo()
    val calcCuadrado = CalculadoraCuadrado()
    val calcPentagono = CalculadoraPentagono()
    val calcTriangulo = CalculadoraTriangulo()

    while (true) {
        println("Seleccione la figura a calcular su area")
        println("1-Circulo")
        println("2-Cuadrado")
        println("3-Pentagono")
        println("4-Triangulo")
        println("5-Salir")
        println("")

        val input = readlnOrNull()
        val opcion = input?.toIntOrNull()

        if (opcion == 1) {
            print("Ingrese el radio del circulo:")
            val radioInput = readlnOrNull()
            val radio = radioInput?.toDoubleOrNull()

            if (radio != null && radio > 0) {
                val areaCirculo = calcCirculo.calcularArea(radio)
                println("El area del circulo es: $areaCirculo")
            } else {
                println("Entrada inválida para el radio.")
            }
            println("")

        } else if (opcion == 2) {
            print("Ingrese el lado del cuadrado:")
            val ladoInput = readlnOrNull()
            val lado = ladoInput?.toDoubleOrNull()

            if (lado != null && lado > 0) {
                val areaCuadrado = calcCuadrado.calcularArea(lado)
                println("El area del cuadrado es: $areaCuadrado")
            } else {
                println("Entrada inválida para el lado.")
            }
            println("")

        } else if (opcion == 3) {
            print("Ingrese el lado del pentagono:")
            val ladoInput = readlnOrNull()
            val lado = ladoInput?.toDoubleOrNull()

            print("Ingrese el apotema del pentagono:")
            val apotemaInput = readlnOrNull()
            val apotema = apotemaInput?.toDoubleOrNull()

            if (lado != null && lado > 0 && apotema != null && apotema > 0) {
                val areaPentagono = calcPentagono.calcularArea(lado, apotema)
                println("El area del pentagono es: $areaPentagono")
            } else {
                println("Entrada inválida para el lado o apotema.")
            }
            println("")

        } else if (opcion == 4) {
            print("Ingrese la base del triangulo:")
            val baseInput = readlnOrNull()
            val base = baseInput?.toDoubleOrNull()

            print("Ingrese la altura del triangulo:")
            val alturaInput = readlnOrNull()
            val altura = alturaInput?.toDoubleOrNull()

            if (base != null && base > 0 && altura != null && altura > 0) {
                val areaTriangulo = calcTriangulo.calcularArea(base, altura)
                println("El area del triangulo es: $areaTriangulo")
            } else {
                println("Entrada inválida para la base o altura.")
            }
            println("")

        } else if (opcion == 5) {
            println("Saliendo...")
            break
        } else {
            println("Opción no válida. Por favor ingrese un número entre 1 y 5.")
            println("")
        }
    }
}