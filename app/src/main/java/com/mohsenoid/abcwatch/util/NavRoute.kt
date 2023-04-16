package com.mohsenoid.abcwatch.util

sealed class NavRoute(val route: String) {

    object SelectorScreen : NavRoute(route = "selector_screen")

    object AlphabetsScreen : NavRoute(route = "alphabets_screen")

    object NumbersScreen : NavRoute(route = "numbers_screen")
}