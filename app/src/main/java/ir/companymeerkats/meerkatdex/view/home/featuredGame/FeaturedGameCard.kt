package ir.companymeerkats.meerkatdex.view.home.featuredGame

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.companymeerkats.meerkatdex.model.SimpleGame

@Composable
fun FeaturedGameCard(
    game: SimpleGame,
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(190.dp)
            .clip(
                RoundedCornerShape(20.dp)
            )
    ) {

        // ─────────────────────────────
        // Game Image
        // ─────────────────────────────

        Image(
            painter = painterResource(
                id = game.imageCover
            ),
            contentDescription = game.name,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )


        // ─────────────────────────────
        // Dark Gradient
        // ─────────────────────────────

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .align(Alignment.BottomCenter)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black.copy(alpha = 0.85f)
                        )
                    )
                )
        )


        // ─────────────────────────────
        // text Featured
        // ─────────────────────────────
        Text(
            text = "Featured",
            color = Color.White,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 12.dp, top = 12.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(MaterialTheme.colorScheme.primary)
                .padding(
                    horizontal = 14.dp,
                    vertical = 3.dp
                )
        )

        // ─────────────────────────────
        // Game Information
        // ─────────────────────────────

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomStart)
                .padding(14.dp)
        ) {

            // Name + Rating
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = game.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier
                        .weight(1f)
                )
            }
            Spacer(
                modifier = Modifier.height(7.dp)
            )


            // Genres and rate
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    modifier = Modifier.weight(1f)
                ) {

                    game.genres
                        .take(3)
                        .forEach { genre ->

                            Text(
                                text = genre.name,
                                style = MaterialTheme.typography.labelSmall,
                                color = Color.White,
                                modifier = Modifier
                                    .clip(
                                        RoundedCornerShape(50)
                                    )
                                    .background(
                                        Color.White.copy(
                                            alpha = 0.18f
                                        )
                                    )
                                    .padding(
                                        horizontal = 8.dp,
                                        vertical = 4.dp
                                    )
                            )
                        }
                }

                Row(
                    modifier = Modifier
                        .padding(end = 4.dp)
                        .clip(
                            RoundedCornerShape(50)
                        )
                        .background(
                            Color.Black.copy(
                                alpha = 0.18f
                            )
                        )
                        .padding(
                            horizontal = 8.dp,
                            vertical = 4.dp
                        )
                ) {

                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null,
                        modifier = Modifier.size(17.dp),
                        tint = Color(0xFFFFC107)
                    )
                    Spacer(
                        modifier = Modifier.width(4.dp)
                    )

                    Text(
                        text = game.rating.get(0).rating,
                        style = MaterialTheme.typography.labelMedium,
                        color = Color.White
                    )
                }
            }
        }
    }
}