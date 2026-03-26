package kmp.edu.leafon_kmp.presentation.login

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import leafon_kmp.composeapp.generated.resources.Res
import leafon_kmp.composeapp.generated.resources.hero_login
import leafon_kmp.composeapp.generated.resources.logo
import org.jetbrains.compose.resources.painterResource

private val GreenPrimary = Color(0xFF2E7D32)
private val GreenHover = Color(0xFF4CAF50)
private val GreenHighlight = Color(0xFF8BC34A)
private val BgSecondary = Color(0xFFF5F5F5)
private val TextOnDark = Color(0xFFFFFFFF)
private val TextMuted = Color(0xB3FFFFFF)
private val ErrorRed = Color(0xFFE53935)
private val PlaceholderGray = Color(0xFF9E9E9E)
private val FieldText = Color(0xFF212121)

@Composable
fun LoginScreen(
    state: LoginState,
    onEmailChange: (String) -> Unit = {},
    onPasswordChange: (String) -> Unit = {},
    onLoginClick: () -> Unit = {},
    onCreateAccountClick: () -> Unit = {},
    onForgotPasswordClick: () -> Unit = {}
) {
    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        if (maxWidth > 700.dp) {
            WideLoginLayout(
                state = state,
                onEmailChange = onEmailChange,
                onPasswordChange = onPasswordChange,
                onLoginClick = onLoginClick,
                onCreateAccountClick = onCreateAccountClick,
                onForgotPasswordClick = onForgotPasswordClick
            )
        } else {
            NarrowLoginLayout(
                state = state,
                onEmailChange = onEmailChange,
                onPasswordChange = onPasswordChange,
                onLoginClick = onLoginClick,
                onCreateAccountClick = onCreateAccountClick,
                onForgotPasswordClick = onForgotPasswordClick
            )
        }
    }
}

@Composable
private fun WideLoginLayout(
    state: LoginState,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onLoginClick: () -> Unit,
    onCreateAccountClick: () -> Unit,
    onForgotPasswordClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BgSecondary)
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val width = size.width
            val height = size.height
            val anchor = width * 0.42f

            val path = Path().apply {
                moveTo(anchor, 0f)
                cubicTo(
                    anchor + width * 0.10f, height * 0.28f,
                    anchor - width * 0.06f, height * 0.72f,
                    anchor, height
                )
                lineTo(width, height)
                lineTo(width, 0f)
                close()
            }

            drawPath(path, color = GreenPrimary)
        }

        Row(modifier = Modifier.fillMaxSize()) {
            LeftPanel(
                modifier = Modifier
                    .weight(0.42f)
                    .fillMaxHeight()
                    .padding(24.dp)
            )

            Box(
                modifier = Modifier
                    .weight(0.58f)
                    .fillMaxHeight()
                    .padding(horizontal = 52.dp),
                contentAlignment = Alignment.Center
            ) {
                LoginForm(
                    state = state,
                    onEmailChange = onEmailChange,
                    onPasswordChange = onPasswordChange,
                    onLoginClick = onLoginClick,
                    onCreateAccountClick = onCreateAccountClick,
                    onForgotPasswordClick = onForgotPasswordClick,
                    modifier = Modifier.widthIn(max = 420.dp)
                )
            }
        }
    }
}

@Composable
private fun NarrowLoginLayout(
    state: LoginState,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onLoginClick: () -> Unit,
    onCreateAccountClick: () -> Unit,
    onForgotPasswordClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(GreenPrimary)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 28.dp, vertical = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(Res.drawable.hero_login),
            contentDescription = "Ilustracao de login",
            modifier = Modifier.size(180.dp)
        )

        Spacer(modifier = Modifier.height(28.dp))

        LoginForm(
            state = state,
            onEmailChange = onEmailChange,
            onPasswordChange = onPasswordChange,
            onLoginClick = onLoginClick,
            onCreateAccountClick = onCreateAccountClick,
            onForgotPasswordClick = onForgotPasswordClick,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
private fun LeftPanel(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start
    ) {
        Image(
            painter = painterResource(Res.drawable.logo),
            contentDescription = "Leaf.ON logo",
            modifier = Modifier.size(52.dp)
        )

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(Res.drawable.hero_login),
                    contentDescription = "Ilustracao de login",
                    modifier = Modifier.size(280.dp)
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Leaf.ON",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = GreenPrimary
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Acompanhe o cuidado das suas plantas em qualquer plataforma.",
                    color = Color(0xFF4F4F4F),
                    textAlign = TextAlign.Center,
                    lineHeight = 22.sp,
                    modifier = Modifier.widthIn(max = 320.dp)
                )
            }
        }
    }
}

@Composable
private fun LoginForm(
    state: LoginState,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onLoginClick: () -> Unit,
    onCreateAccountClick: () -> Unit,
    onForgotPasswordClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Que bom te ver aqui de novo!",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = TextOnDark,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Acesse sua conta para continuar\nmonitorando suas plantas.",
            fontSize = 14.sp,
            color = TextMuted,
            textAlign = TextAlign.Center,
            lineHeight = 20.sp
        )

        Spacer(modifier = Modifier.height(36.dp))

        LeafOnField(
            label = "Seu email:",
            value = state.email,
            onValueChange = onEmailChange,
            placeholder = "seuemail@mail.com",
            keyboardType = KeyboardType.Email
        )

        Spacer(modifier = Modifier.height(18.dp))

        LeafOnField(
            label = "Sua senha:",
            value = state.password,
            onValueChange = onPasswordChange,
            placeholder = "**************",
            keyboardType = KeyboardType.Password,
            isPassword = true
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = "Esqueceu sua senha?",
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold,
                color = TextOnDark,
                modifier = Modifier.clickable { onForgotPasswordClick() }
            )
        }

        Spacer(modifier = Modifier.height(28.dp))

        if (state.error != null) {
            Text(
                text = state.error,
                color = ErrorRed,
                fontSize = 13.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp)
            )
        }

        OutlinedButton(
            onClick = onLoginClick,
            enabled = !state.isLoading,
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp),
            shape = RoundedCornerShape(14.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color.Transparent,
                contentColor = TextOnDark,
                disabledContentColor = TextOnDark.copy(alpha = 0.5f)
            ),
            border = ButtonDefaults.outlinedButtonBorder.copy(
                brush = SolidColor(
                    if (state.isLoading) TextOnDark.copy(alpha = 0.4f) else TextOnDark
                )
            )
        ) {
            if (state.isLoading) {
                CircularProgressIndicator(
                    color = TextOnDark,
                    modifier = Modifier.size(22.dp),
                    strokeWidth = 2.dp
                )
            } else {
                Text(
                    text = "Fazer login",
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    letterSpacing = 0.4.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(22.dp))

        val registerText = buildAnnotatedString {
            withStyle(SpanStyle(color = TextOnDark, fontSize = 14.sp)) {
                append("Ainda nao tem cadastro? ")
            }
            withStyle(
                SpanStyle(
                    color = GreenHighlight,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            ) {
                append("Crie sua conta aqui.")
            }
        }

        Text(
            text = registerText,
            textAlign = TextAlign.Center,
            modifier = Modifier.clickable { onCreateAccountClick() }
        )
    }
}

@Composable
private fun LeafOnField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String = "",
    keyboardType: KeyboardType = KeyboardType.Text,
    isPassword: Boolean = false
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = label,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = GreenHighlight,
            modifier = Modifier.padding(bottom = 6.dp)
        )
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = {
                Text(
                    text = placeholder,
                    color = PlaceholderGray,
                    fontSize = 14.sp
                )
            },
            visualTransformation = if (isPassword) {
                PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            },
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            singleLine = true,
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                disabledContainerColor = Color.White,
                focusedBorderColor = GreenHover,
                unfocusedBorderColor = Color.Transparent,
                focusedTextColor = FieldText,
                unfocusedTextColor = FieldText
            )
        )
    }
}
