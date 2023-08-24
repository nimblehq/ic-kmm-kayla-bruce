package co.nimblehq.kaylabruce.kmmic.android.presentation.screen.home.header

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import co.nimblehq.kaylabruce.kmmic.android.presentation.uimodel.HomeHeaderUiModel
import coil.compose.AsyncImage

@Suppress("MagicNumber")
@Composable
fun HomeHeaderView(
    uiModel: HomeHeaderUiModel,
    onProfileImageTap: () -> Unit,
) {
    Column {
       Text(
           text = uiModel.dateText.uppercase(),
           style = MaterialTheme.typography.h5,
           color = Color.White,
           )
        Spacer(
            modifier = Modifier.height(Dp(4F))
            )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = uiModel.todayText,
                style = MaterialTheme.typography.caption,
                color = Color.White,
            )
            AsyncImage(
                model = uiModel.imageUrl,
                contentDescription = null,
                modifier = Modifier
                    .size(Dp(36F))
                    .clip(CircleShape)
                    .clickable { onProfileImageTap() },
            )
        }
    }
}
