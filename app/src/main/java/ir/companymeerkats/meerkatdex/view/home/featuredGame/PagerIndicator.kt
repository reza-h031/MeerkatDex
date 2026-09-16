package ir.companymeerkats.meerkatdex.view.home.featuredGame

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.unit.dp

@Composable
fun PagerIndicator(
    pageCount: Int,
    currentPage: Int,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {

        repeat(pageCount) { index ->

            val selected = index == currentPage

            androidx.compose.foundation.layout.Box(
                modifier = Modifier
                    .size(
                        width = if (selected) 24.dp else 7.dp,
                        height = 7.dp
                    )
                    .clip(
                        RoundedCornerShape(50)
                    )
                    .background(
                        if (selected) {
                            MaterialTheme.colorScheme.primary
                        } else {
                            MaterialTheme.colorScheme.onSurfaceVariant.copy(
                                alpha = 0.35f
                            )
                        }
                    )
            )
        }
    }
}