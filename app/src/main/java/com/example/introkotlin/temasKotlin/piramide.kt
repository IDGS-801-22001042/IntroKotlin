package com.example.introkotlin.temasKotlin

fun main() {
    var niveles: Int?
    do {
        println("Ingrese el número de niveles para la pirámide:")
        niveles = readln().toIntOrNull()
        if (niveles == null) {
            println("Error: Debe ingresar un número entero.")
            continue
        }
        if (niveles < 0) {
            println("Error: Debe ingresar un número entero positivo")
            continue
        }
        if (niveles != 0) {
            for (i in 1..niveles) {
                val espacios = niveles - i
                for (j in 1..espacios) {
                    print(" ")
                }
                for (k in 1..i) {
                    print("*")
                }
                println()
            }
        }
    } while (niveles != 0)
}