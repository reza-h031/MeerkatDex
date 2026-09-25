package ir.companymeerkats.meerkatdex.view.game

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import ir.companymeerkats.meerkatdex.model.Game

@Composable
fun GameDetailContent(
    game: Game
) {

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(
            horizontal = 12.dp,
            vertical = 12.dp
        ),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        // Cover
        item {

            val coverImage =
                game.images.firstOrNull { it.type == "cover" }

            coverImage?.let {

                AsyncImage(
                    model = it.path,
                    contentDescription = game.title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(190.dp)
                        .clip(
                            RoundedCornerShape(18.dp)
                        )
                )
            }
        }

        // Title + Rating
        item {

            Column {

                Text(
                    text = game.title,
                    style = MaterialTheme.typography.headlineSmall
                )

                Spacer(
                    modifier = Modifier.height(6.dp)
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.tertiary,
                        modifier = Modifier.size(18.dp)
                    )

                    Spacer(
                        modifier = Modifier.width(4.dp)
                    )

                    game.ratings.firstOrNull()?.let { rating ->

                        Text(
                            text = rating.rating,
                            style = MaterialTheme.typography.labelLarge
                        )

                        Spacer(
                            modifier = Modifier.width(5.dp)
                        )

                        Text(
                            text = "(${rating.ratingCount})",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }

        // Genres
        item {

            Row(
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {

                game.genre.take(3).forEach { genre ->

                    GameTag(
                        text = genre.name
                    )
                }
            }
        }

        // About Game
        item {

            DetailCard(
                title = "About Game"
            ) {

                Text(
                    text = game.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    lineHeight = MaterialTheme.typography.bodyMedium.lineHeight
                )
            }
        }

        // Information
        item {

            DetailCard(
                title = "Information"
            ) {

                DetailRow(
                    icon = Icons.Default.Person,
                    title = "Developer",
                    value = game.developer.name
                )

                DetailRow(
                    icon = Icons.Default.Business,
                    title = "Publisher",
                    value = game.publisher.name
                )

                DetailRow(
                    icon = Icons.Default.CalendarToday,
                    title = "Release Date",
                    value = game.releaseDate
                )

                DetailRow(
                    icon = Icons.Default.Language,
                    title = "Status",
                    value = game.status
                )
            }
        }

        // Platforms
        item {

            DetailCard(
                title = "Platforms"
            ) {

                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    game.platform.forEach { platform ->

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Text(
                                text = platform.name,
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.weight(1f)
                            )

                            platform.version?.let {

                                Text(
                                    text = it,
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                    }
                }
            }
        }

        // Requirements
        item {

            game.platform
                .firstOrNull { it.gameRequirement != null }
                ?.gameRequirement
                ?.let { requirement ->

                    DetailCard(
                        title = "Requirements"
                    ) {

                        val minimum =
                            requirement.minimumRequirements

                        RequirementRow(
                            title = "RAM",
                            value = minimum.ram
                        )

                        RequirementRow(
                            title = "CPU",
                            value = minimum.cpu
                        )

                        RequirementRow(
                            title = "GPU",
                            value = minimum.gpu
                        )

                        RequirementRow(
                            title = "Storage",
                            value = minimum.storage
                        )

                        RequirementRow(
                            title = "System",
                            value = minimum.systemVersion
                        )
                    }
                }
        }

        item {
            Spacer(
                modifier = Modifier.height(8.dp)
            )
        }
    }
}