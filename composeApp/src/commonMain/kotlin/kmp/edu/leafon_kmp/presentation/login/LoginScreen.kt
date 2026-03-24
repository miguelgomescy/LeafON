package kmp.edu.leafon_kmp.presentation.login

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.text.ClickableText
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(
    state: LoginState,
    onEmailChange: (String) -> Unit = {},
    onPasswordChange: (String) -> Unit = {},
    onLoginClick: () -> Unit = {},
    onCreateAccountClick: () -> Unit = {},
    onForgotPasswordClick: () -> Unit = {}
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
        LeftPanel(
            modifier = Modifier.weight(1f),
            backgroundColor = lightBackground
        )

        RightPanel(
            modifier = Modifier.weight(1f),
            darkGreen = darkGreen,
            darkGreen2 = darkGreen2,
            accentGreen = accentGreen,
            textWhite = textWhite,
            textGray = textGray,
            hintGray = hintGray,
            state = state,
            onEmailChange = onEmailChange,
            onPasswordChange = onPasswordChange,
            onLoginClick = onLoginClick,
            onCreateAccountClick = onCreateAccountClick,
            onForgotPasswordClick = onForgotPasswordClick
        )
    }
}

@Composable
private fun LeftPanel(
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
                        text = "🪴",
                        fontSize = 180.sp
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "Mascote / ilustração aqui",
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
private fun RightPanel(
    modifier: Modifier = Modifier,
    darkGreen: Color,
    darkGreen2: Color,
    accentGreen: Color,
    textWhite: Color,
    textGray: Color,
    hintGray: Color,
    state: LoginState,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onLoginClick: () -> Unit,
    onCreateAccountClick: () -> Unit,
    onForgotPasswordClick: () -> Unit
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
                text = "Que bom te ver aqui de novo!",
                color = textWhite,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 36.sp
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "Entre com seu e-mail e senha para continuar.",
                color = textGray,
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.height(26.dp))

            Text(
                text = "Seu email:",
                color = textWhite,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(8.dp))

            LeafonTextField(
                value = state.email,
                onValueChange = onEmailChange,
                placeholder = "seuemail@mail.com",
                hintGray = hintGray
            )

            Spacer(modifier = Modifier.height(26.dp))

            Text(
                text = "Sua senha:",
                color = textWhite,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(8.dp))

            LeafonPasswordField(
                value = state.password,
                onValueChange = onPasswordChange,
                placeholder = "***************",
                hintGray = hintGray
            )

            Spacer(modifier = Modifier.height(6.dp))

            TextButton(
                onClick = onForgotPasswordClick,
                modifier = Modifier.align(Alignment.Start)
            ) {
                Text(
                    text = "Esqueceu sua senha?",
                    color = textWhite.copy(alpha = 0.9f),
                    fontSize = 14.sp
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = onLoginClick,
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
                    text = "Fazer login",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            val annotatedText = buildAnnotatedString {
                append("Ainda não tem cadastro? ")

                pushStringAnnotation(tag = "register", annotation = "register")
                addStyle(
                    style = SpanStyle(
                        color = Color(0xFF8BFF8B),
                        fontWeight = FontWeight.Bold
                    ),
                    start = length,
                    end = length
                )
                append("Crie sua conta aqui.")
                pop()
            }

            ClickableText(
                text = annotatedText,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = textWhite.copy(alpha = 0.95f)
                ),
                onClick = { offset ->
                    annotatedText
                        .getStringAnnotations("register", offset, offset)
                        .firstOrNull()
                        ?.let { onCreateAccountClick() }
                }
            )
        }
    }
}

@Composable
private fun LeafonTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    hintGray: Color
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
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

@Composable
private fun LeafonPasswordField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    hintGray: Color
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        visualTransformation = PasswordVisualTransformation(),
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
