package kmp.edu.leafon_kmp.presentation.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RegisterScreen(
    state: RegisterState,
    onNameChange: (String) -> Unit = {},
    onEmailChange: (String) -> Unit = {},
    onPhoneChange: (String) -> Unit = {},
    onPlantNameChange: (String) -> Unit = {},
    onPasswordChange: (String) -> Unit = {},
    onConfirmPasswordChange: (String) -> Unit = {},
    onRegisterClick: () -> Unit = {},
    onBackToLoginClick: () -> Unit = {}
) {
    val lightBackground = Color(0xFFEAEAEA)
    val darkGreen = Color(0xFF005D0D)
    val darkGreen2 = Color(0xFF0A4E0A)
    val accentGreen = Color(0xFF2F8C38)
    val textWhite = Color.White
    val textGray = Color(0xFFD9D9D9)
    val hintGray = Color(0xFF8D8D8D)

    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(lightBackground)
    ) {
        RegisterLeftPanel(
            modifier = Modifier.weight(1f),
            backgroundColor = lightBackground
        )

        RegisterRightPanel(
            modifier = Modifier.weight(1f),
            darkGreen = darkGreen,
            darkGreen2 = darkGreen2,
            accentGreen = accentGreen,
            textWhite = textWhite,
            textGray = textGray,
            hintGray = hintGray,
            state = state,
            onNameChange = onNameChange,
            onEmailChange = onEmailChange,
            onPhoneChange = onPhoneChange,
            onPlantNameChange = onPlantNameChange,
            onPasswordChange = onPasswordChange,
            onConfirmPasswordChange = onConfirmPasswordChange,
            onRegisterClick = onRegisterClick,
            onBackToLoginClick = onBackToLoginClick
        )
    }
}

@Composable
private fun RegisterLeftPanel(
    modifier: Modifier = Modifier,
    backgroundColor: Color
) {
    Box(
        modifier = modifier
            .fillMaxHeight()
            .background(backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "🌱",
                fontSize = 40.sp,
                modifier = Modifier.padding(top = 8.dp, start = 8.dp)
            )

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "📋",
                        fontSize = 180.sp
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "Ilustração do cadastro aqui",
                        color = Color(0xFF4F4F4F),
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Composable
private fun RegisterRightPanel(
    modifier: Modifier = Modifier,
    darkGreen: Color,
    darkGreen2: Color,
    accentGreen: Color,
    textWhite: Color,
    textGray: Color,
    hintGray: Color,
    state: RegisterState,
    onNameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onPhoneChange: (String) -> Unit,
    onPlantNameChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onConfirmPasswordChange: (String) -> Unit,
    onRegisterClick: () -> Unit,
    onBackToLoginClick: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxHeight()
            .clip(
                RoundedCornerShape(
                    topStart = 180.dp,
                    bottomStart = 180.dp
                )
            )
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(darkGreen, darkGreen2)
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .widthIn(max = 520.dp)
                .padding(horizontal = 48.dp, vertical = 32.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Vamos criar sua conta",
                color = textWhite,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 36.sp
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "Preencha os dados abaixo para começar a usar o app.",
                color = textGray,
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.height(22.dp))

            RegisterTextField(
                value = state.name,
                onValueChange = onNameChange,
                placeholder = "Seu nome completo",
                label = "Seu nome:",
                textWhite = textWhite,
                hintGray = hintGray
            )

            Spacer(modifier = Modifier.height(18.dp))

            RegisterTextField(
                value = state.email,
                onValueChange = onEmailChange,
                placeholder = "seuemail@mail.com",
                label = "Seu email:",
                textWhite = textWhite,
                hintGray = hintGray,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

            Spacer(modifier = Modifier.height(18.dp))

            RegisterTextField(
                value = state.phone,
                onValueChange = onPhoneChange,
                placeholder = "(00) 00000-0000",
                label = "Seu telefone:",
                textWhite = textWhite,
                hintGray = hintGray,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
            )

            Spacer(modifier = Modifier.height(18.dp))

            RegisterTextField(
                value = state.plantName,
                onValueChange = onPlantNameChange,
                placeholder = "Ex: Monstera",
                label = "Nome da planta:",
                textWhite = textWhite,
                hintGray = hintGray
            )

            Spacer(modifier = Modifier.height(18.dp))

            RegisterTextField(
                value = state.password,
                onValueChange = onPasswordChange,
                placeholder = "***************",
                label = "Sua senha:",
                textWhite = textWhite,
                hintGray = hintGray,
                isPassword = true
            )

            Spacer(modifier = Modifier.height(18.dp))

            RegisterTextField(
                value = state.confirmPassword,
                onValueChange = onConfirmPasswordChange,
                placeholder = "***************",
                label = "Confirmar senha:",
                textWhite = textWhite,
                hintGray = hintGray,
                isPassword = true
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = onRegisterClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = accentGreen,
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "Cadastrar",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            TextButton(
                onClick = onBackToLoginClick,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = "Já tenho conta. Voltar para login",
                    color = textWhite.copy(alpha = 0.95f)
                )
            }
        }
    }
}

@Composable
private fun RegisterTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    label: String,
    textWhite: Color,
    hintGray: Color,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    isPassword: Boolean = false
) {
    Text(
        text = label,
        color = textWhite,
        fontSize = 18.sp,
        fontWeight = FontWeight.SemiBold
    )

    Spacer(modifier = Modifier.height(8.dp))

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        keyboardOptions = keyboardOptions,
        visualTransformation = if (isPassword) {
            PasswordVisualTransformation()
        } else {
            androidx.compose.ui.text.input.VisualTransformation.None
        },
        placeholder = {
            Text(
                text = placeholder,
                color = hintGray
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        shape = RoundedCornerShape(16.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color(0xFFF4F4F4),
            unfocusedContainerColor = Color(0xFFF4F4F4),
            focusedBorderColor = Color(0xFFD4D4D4),
            unfocusedBorderColor = Color(0xFFD4D4D4),
            cursorColor = Color.Black
        )
    )
}
