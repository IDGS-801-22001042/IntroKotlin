package com.example.introkotlin.temasKotlin

fun main(){
    /*
    List, MutableList
    Set, MutableSet
    Map, MutableMap
    */

    var readOnlyList:List<String> = listOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sabado", "Domingo")
    println(readOnlyList)
    println("El primer día es: ${readOnlyList[0]}")//Primera posición de arreglo/lista
    println("El primer día es: ${readOnlyList.first()}")//Primer elemento
    println("El numero de días es: ${readOnlyList.count()}")//Numero de caracteres
    println("El numero de días es: ${readOnlyList.size}")//Tamaño
    println("Martes" in readOnlyList)//Tamaño
    var figuras:MutableList<String> = mutableListOf("Circulo", "Cuadrado", "Triángulo")
    println(figuras)
    figuras.add("Pentagono")
    println(figuras)
    figuras.removeAt(0)
    println(figuras)
    figuras.remove("Cuadrado")
    println(figuras)

//-------------------------------------------------------------------------------------------
    val readOnlyFrutas = mapOf("manzana" to 1500, "platano" to 2000, "sandía" to 2500)
    println(readOnlyFrutas)//furta y valor
    println(readOnlyFrutas["manzana"])//solo valor de manzana o corchetes
    println(readOnlyFrutas.keys)//solo nombres str
    println(readOnlyFrutas.values)//solo valores num
}