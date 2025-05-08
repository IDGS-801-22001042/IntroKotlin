package com.example.introkotlin.temasKotlin

fun main(){
    val d:Int
    val e=true
    if(e){
        d=1
    }else{
        d=2
    }
    println(d)
    val numero=if(e) 1 else 2
    println(numero)
    //-----------------------------
    print("Ingrese el sueldo del empleado:")//imprime linea sin hacer salto de línea
    val sueldo= readln().toDouble()//Para recoger valores en variable

    if(sueldo>3000){
        println("Debe pagar impuestos")
    }else{
        println("No debe pagar impuestos")
    }

    //when
    val objeto:Any="Hola"//Any es cualquier tipo de dato"
    when(objeto){
        "1"-> println("Es un uno")
        "Hola"-> println("Es un saludo")
        is String-> println("Es un string")
        else-> println("No se que es")
    }

    //Range
    1..4//1234
    1 downTo 4//4321
    1..10 step 2//13579
    'a'..'g'//abcdeg
    'z' downTo 'a' step 2//zg y ad
}