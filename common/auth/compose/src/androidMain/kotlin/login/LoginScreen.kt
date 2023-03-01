package login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import login.models.LoginEvent
import theme.Theme

@Preview(showSystemUi = false, showBackground = true, backgroundColor = 0xFF050B18)
@Composable
fun LoginScreen() {
    StoredViewModel(factory = { LoginViewModel() }) { viewModel ->
        val state = viewModel.viewStates().observeAsState()
        Column(
            modifier = Modifier
                .padding(30.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier,
                text = "Login Now",
                color = Theme.colors.thirdTextColor,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Text(
                modifier = Modifier
                    .padding(top = 15.dp)
                    .align(CenterHorizontally),
                text = "Welcome back to PlayZone! Enter your email address and your password to enjoy the latest features of PlayZone",
                fontSize = 14.sp,
                color = Theme.colors.hintTextColor,
                textAlign = TextAlign.Center
            )

            TextField(
                modifier = Modifier
                    .padding(top = 50.dp)
                    .fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Theme.colors.textFieldBackground,
                    textColor = Color(0xFF696C75),
                    cursorColor = Theme.colors.highlightTextColor,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                shape = RoundedCornerShape(size = 10.dp),
                placeholder = {
                    Text(
                        text = "Email Address",
                        color = Theme.colors.hintTextColor,
                        fontSize = 16.sp,
                    )
                },
                value = state.value.email,
                onValueChange = { newValue ->
                    viewModel.obtainEvent(LoginEvent.EmailChanged(newValue))
                }
            )

            TextField(
                modifier = Modifier
                    .padding(top = 24.dp)
                    .fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Theme.colors.textFieldBackground,
                    textColor = Color(0xFF696C75),
                    cursorColor = Theme.colors.highlightTextColor,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                shape = RoundedCornerShape(size = 10.dp),
                placeholder = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f),
                            text = "Password",
                            color = Theme.colors.hintTextColor,
                            fontSize = 16.sp,
                        )

                        // todo заменить на изображение
                        Box(
                            modifier = Modifier
                                .background(
                                    color = Theme.colors.hintTextColor,
                                    shape = CircleShape
                                )
                                .size(16.dp)
                        )
                    }
                },
                value = state.value.password,
                onValueChange = { newValue ->
                    viewModel.obtainEvent(LoginEvent.PasswordChanged(newValue))
                }
            )

            Text(
                modifier = Modifier
                    .padding(
                        top = 30.dp,
                        end = 24.dp
                    )
                    .align(End),
                text = "Forgot password",
                color = Theme.colors.highlightTextColor,
                fontSize = 14.sp,
                textDecoration = TextDecoration.Underline,
            )

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Theme.colors.primaryAction
                ),
                shape = RoundedCornerShape(10.dp),
                onClick = {
                }) {
                Text(
                    "Login Now", color = Theme.colors.primaryTextColor,
                    fontSize = 16.sp, fontWeight = FontWeight.Bold
                )
            }
        }
    }

}