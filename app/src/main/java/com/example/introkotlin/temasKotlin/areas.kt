package com.example.introkotlin.temasKotlin

fun main(){
    while (true){
        println("Seleccione la figura a calcular su area")
        println("1-Circulo")
        println("2-Cuadrado")
        println("3-Pentagono")
        println("4-Triangulo")
        println("5-Salir")
        println("")
        val opcion= readln().toInt()
        if (opcion == 1){
            print("Ingrese el radio del circulo:")
            val radio= readln().toDouble()
            val areaCirculo=Math.PI*Math.pow(radio,2.0)
            println("El area del circulo es:" +  areaCirculo)
            println("")
        }else if (opcion == 2){
            print("Ingrese el lado del cuadrado:")
            val lado= readln().toDouble()
            val areaCuadrado=Math.pow(lado,2.0)
            println("El area del cuadrado es:" +  areaCuadrado)
            println("")
        } else if(opcion == 3){
            print("Ingrese el lado del pentagono:")
            val lado= readln().toDouble()
            print("Ingrese el apotema del pentagono:")
            val apotema = readln().toDouble()
            val areaPentagono=(5*lado*apotema)/2
            println("El area del pentagono es:" +  areaPentagono)
            println("")
        }else if(opcion == 4){
            print("Ingrese la base del triangulo:")
            val base= readln().toDouble()
            print("Ingrese la altura del triangulo:")
            val altura = readln().toDouble()
            val areaTriangulo=(base*altura)/2
            println("El area del triangulo es:" +  areaTriangulo)
            println("")
        }else if(opcion==5){
            break
        }
    }
}//(5 * lado * apotema )/2