package co.nimblehq.kaylabruce.kmmic.android.presentation.screen.splash

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import co.nimblehq.kaylabruce.kmmic.android.R
import kotlinx.coroutines.delay

private const val SHOW_LOGO_DELAY = 1000L
private const val SHOW_LOGO_DURATION = 1500

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun SplashScreen(
    onNavigator: () -> Unit,
) {
    var shouldShowLogo by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        delay(SHOW_LOGO_DELAY)
        shouldShowLogo = true
    }
    LaunchedEffect(Unit) {
        delay(SHOW_LOGO_DELAY + SHOW_LOGO_DURATION)
        onNavigator.invoke()
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.im_background_splash),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )
        AnimatedVisibility(
            visible = shouldShowLogo,
            enter = fadeIn(animationSpec = tween(SHOW_LOGO_DURATION)),
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_logo_white),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
    }
}
