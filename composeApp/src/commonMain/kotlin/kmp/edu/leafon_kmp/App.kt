package kmp.edu.leafon_kmp

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kmp.edu.leafon_kmp.presentation.login.LoginAction
import kmp.edu.leafon_kmp.presentation.login.LoginScreen
import kmp.edu.leafon_kmp.presentation.login.LoginViewModel
import kmp.edu.leafon_kmp.presentation.navigation.AppRoute
import kmp.edu.leafon_kmp.presentation.register.RegisterScreen

@Composable
@Preview
fun App() {
    val navController = rememberNavController()

    MaterialTheme {
        NavHost(
            navController = navController,
            startDestination = AppRoute.Login.route
        ) {
            composable(AppRoute.Login.route) {
                val loginViewModel = remember { LoginViewModel() }

                LoginScreen(
                    state = loginViewModel.state,
                    onEmailChange = {
                        loginViewModel.onAction(LoginAction.OnEmailChange(it))
                    },
                    onPasswordChange = {
                        loginViewModel.onAction(LoginAction.OnPasswordChange(it))
                    },
                    onLoginClick = {
                        loginViewModel.onAction(LoginAction.OnLoginClick)
                    },
                    onCreateAccountClick = {
                        navController.navigate(AppRoute.Register.route)
                    }
                )
            }

            composable(AppRoute.Register.route) {
                RegisterScreen(
                    onBackToLoginClick = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}
