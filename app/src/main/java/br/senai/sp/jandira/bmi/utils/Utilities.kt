package br.senai.sp.jandira.bmi.utils

import java.util.Locale

fun numberConvertToLocale(value: Double): String{
    return String.format(Locale.getDefault(), "%.1f", value)
}

