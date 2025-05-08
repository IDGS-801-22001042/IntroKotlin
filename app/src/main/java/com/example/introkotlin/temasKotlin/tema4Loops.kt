package com.example.introkotlin.temasKotlin

//for
fun main(){
    for (number in 1..5){
        print(number)
    }
    val nombres= listOf("Jose", "Carlos", "Oscar")
    for (nombree in nombres){
        println(nombree)
    }

    //while do-while
    var x = 0
    while (x < 5){
        println(x)
        x++
    }

    do{
        println(x)
        x++
    }while (x < 5)
}


//Cuatro areas, pide valores de circulo, cuadrado, pentagono y triangulo y opcion 5 salir
//Formula general de cuadraticas
//usando do-while generar un triángulo o piramide de asteriscos