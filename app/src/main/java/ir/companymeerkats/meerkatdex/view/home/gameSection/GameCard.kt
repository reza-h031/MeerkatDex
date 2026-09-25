package ir.companymeerkats.meerkatdex.view.home.gameSection

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.companymeerkats.meerkatdex.model.SimpleGame

@Composable
fun GameCard(
    game: SimpleGame
) {

    Column(
        modifier = Modifier
            .width(128.dp)
            .clip(RoundedCornerShape(14.dp))
            .background(
                MaterialTheme.colorScheme.surface
            )
            .padding(bottom = 10.dp)
    ) {

        Image(
            painter = painterResource(game.imageIcon),
            contentDescription = game.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = 14.dp,
                        topEnd = 14.dp
                    )
                )
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = game.name,
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold,
            maxLines = 1,
            modifier = Modifier.padding(
                horizontal = 8.dp
            )
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            modifier = Modifier.weight(1f)
        ) {

            game.genres
                .take(2)
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

        Spacer(
            modifier = Modifier.height(6.dp)
        )

        Row(
            modifier = Modifier.padding(
                horizontal = 8.dp
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "★",
                color = Color(0xFFFFC107),
                fontSize = 12.sp
            )

            Spacer(
                modifier = Modifier.width(3.dp)
            )

            Text(
                text = game.rating.get(0).rating,
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = 11.sp
            )
        }
        Spacer(
            modifier = Modifier.height(16.dp)
        )
    }
}