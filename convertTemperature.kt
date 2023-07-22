
fun convertTemperature(celsius: Double): DoubleArray =
    doubleArrayOf(
        toKelvin(celsius),
        toFahrenheit(celsius)
    )

val toFahrenheit = { celsius: Double -> celsius * 1.80 + 32.00 }
val toKelvin = { celsius: Double -> celsius + 273.15 }
