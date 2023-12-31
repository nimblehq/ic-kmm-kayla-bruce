package co.nimblehq.kaylabruce.kmmic.android.presentation.screen.signin

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateOffsetAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.nimblehq.kaylabruce.kmmic.android.R
import co.nimblehq.kaylabruce.kmmic.android.constants.Colors
import co.nimblehq.kaylabruce.kmmic.android.presentation.screen.common.SurveyButton
import co.nimblehq.kaylabruce.kmmic.android.presentation.screen.common.SurveyTextField
import kotlinx.coroutines.delay

const val SHOW_LOGIN_DURATION = 700

private val initialLogoOffset: Offset = Offset(0f, 0f)
private val finalLogoOffset = Offset(0f, -230f)

@Composable
fun SignInScreen() {
    var logoOffset by remember { mutableStateOf(initialLogoOffset) }
    var shouldShowLoginForm by remember { mutableStateOf(false) }
    val animateLogoOffset by animateOffsetAsState(
        targetValue = logoOffset,
        animationSpec = tween(durationMillis = SHOW_LOGIN_DURATION),
        label = "",
    )

    LaunchedEffect(Unit) {
        logoOffset = finalLogoOffset
    }

    LaunchedEffect(Unit) {
        delay(SHOW_LOGIN_DURATION.toLong())
        shouldShowLoginForm = true
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize(),
    ) {
        Image(
            painter = painterResource(id = R.drawable.im_background_blur),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize(),
        )

        AnimatedVisibility(visible = true) {
            Image(
                painter = painterResource(id = R.drawable.ic_logo_white),
                contentDescription = null,
                modifier = Modifier
                    .offset(animateLogoOffset.x.dp, animateLogoOffset.y.dp),
            )
        }
    }

    AnimatedVisibility(
        visible = shouldShowLoginForm,
        enter = fadeIn(animationSpec = tween(SHOW_LOGIN_DURATION)),
    ) {
        SignInForm()
    }
}

@Composable
fun SignInForm() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Column(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        modifier = Modifier
            .fillMaxSize()
            .wrapContentHeight()
            .padding(horizontal = 24.dp),
    ) {
        SurveyTextField(
            text = email,
            onTextChange = { email = it },
            placeholder = stringResource(id = R.string.login_email),
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next,
        )
        SurveyTextField(
            text = password,
            onTextChange = { password = it },
            placeholder = stringResource(id = R.string.login_password),
            visualTransformation = PasswordVisualTransformation(),
            imeAction = ImeAction.Done,
            trailingIcon = {
                Text(
                    text = stringResource(id = R.string.login_forgot),
                    color = Colors.White50,
                    modifier = Modifier
                        .padding(all = 16.dp),
                )
            },
        )
        SurveyButton(
            modifier = Modifier
                .fillMaxWidth(),
            text = stringResource(id = R.string.login),
            onClick = {},
        )
    }
}

@Preview
@Composable
fun SignInScreenPreview() {
    SignInScreen()
}
