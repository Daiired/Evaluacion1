package com.example.evaluacion1

abstract class Empleado(val sueldoBruto: Double) {
    abstract fun calcularLiquido(): Double
}

class EmpleadoHorario(sueldoBruto: Double) : Empleado(sueldoBruto) {
    override fun calcularLiquido(): Double {
        return sueldoBruto * 0.87
    }
}

class EmpleadoRegular(sueldoBruto: Double) : Empleado(sueldoBruto) {
    override fun calcularLiquido(): Double {
        return sueldoBruto * 0.8
    }
}