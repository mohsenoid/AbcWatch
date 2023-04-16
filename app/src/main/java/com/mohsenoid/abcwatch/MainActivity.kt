package com.mohsenoid.abcwatch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.wear.compose.material.*
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.composable
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController
import com.mohsenoid.abcwatch.alphabets.AlphabetsScreen
import com.mohsenoid.abcwatch.alphabets.AlphabetsViewModel
import com.mohsenoid.abcwatch.numbers.NumbersScreen
import com.mohsenoid.abcwatch.numbers.NumbersViewModel
import com.mohsenoid.abcwatch.presentation.SelectorScreen
import com.mohsenoid.abcwatch.theme.AbcWatchTheme
import com.mohsenoid.abcwatch.util.NavRoute
import org.koin.androidx.compose.koinViewModel


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AbcWatchTheme {
                Scaffold(
                    vignette = {
                        Vignette(
                            vignettePosition = VignettePosition.TopAndBottom
                        )
                    },
                    timeText = {
                        TimeText(
                            timeTextStyle = TimeTextDefaults.timeTextStyle(
                                fontSize = 10.sp,
                                color = Color.Gray
                            )
                        )
                    }
                ) {
                    val navController = rememberSwipeDismissableNavController()

                    SwipeDismissableNavHost(
                        navController = navController,
                        startDestination = NavRoute.SelectorScreen.route,
                    ) {
                        composable(
                            route = NavRoute.SelectorScreen.route
                        ) {
                            SelectorScreen(
                                modifier = Modifier.fillMaxSize(),
                                onAbcClicked = { navController.navigate(NavRoute.AlphabetsScreen.route) },
                                on123Clicked = { navController.navigate(NavRoute.NumbersScreen.route) }
                            )
                        }

                        composable(
                            route = NavRoute.AlphabetsScreen.route
                        ) {
                            val viewModel = koinViewModel<AlphabetsViewModel>()
                            val state by viewModel.uiState.collectAsStateWithLifecycle()

                            AlphabetsScreen(
                                state = state,
                                modifier = Modifier.fillMaxSize(),
                                onClicked = viewModel::onClicked,
                            )
                        }

                        composable(
                            route = NavRoute.NumbersScreen.route
                        ) {
                            val viewModel = koinViewModel<NumbersViewModel>()
                            val state by viewModel.uiState.collectAsStateWithLifecycle()

                            NumbersScreen(
                                state = state,
                                modifier = Modifier.fillMaxSize(),
                                onClicked = viewModel::onClicked,
                            )
                        }
                    }
                }
            }
        }
    }
}