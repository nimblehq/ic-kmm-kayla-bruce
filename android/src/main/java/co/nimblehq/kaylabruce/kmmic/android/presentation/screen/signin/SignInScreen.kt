package co.nimblehq.kaylabruce.kmmic.android.presentation.screen.signin

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.nimblehq.kaylabruce.kmmic.android.R
import co.nimblehq.kaylabruce.kmmic.android.presentation.screen.common.SurveyButton
import co.nimblehq.kaylabruce.kmmic.android.presentation.screen.common.SurveyTextField

@Composable
fun SignInScreen() {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.im_background_blur),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )
        Image(
            painter = painterResource(id = R.drawable.ic_logo_white),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.Center)
                .wrapContentHeight()
                .padding(all = 24.dp)
                .offset(x = 0.dp, y = (-229).dp)
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier
                .fillMaxSize()
                .wrapContentHeight()
                .padding(horizontal = 24.dp)
        ) {
            SurveyTextField(
                text = email,
                onTextChanged = { },
                placeholder = "Email",
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            )
            Box {
                SurveyTextField(
                    text = password,
                    onTextChanged = { },
                    placeholder = "Password",
                    visualTransformation = PasswordVisualTransformation(),
                    imeAction = ImeAction.Done,
                    trailingIcon = {
                        Text(
                            text = "Forgot?",
                            color = Color(0x80FFFFFF),
                            modifier = Modifier
                                .wrapContentHeight()
                                .align(Alignment.CenterEnd)
                                .padding(end = 12.dp)
                        )
                    }
                )
            }
            SurveyButton(
                text = "Login",
                onClicked = { },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview
@Composable
fun SignInScreenPreview() {
    SignInScreen()
}
