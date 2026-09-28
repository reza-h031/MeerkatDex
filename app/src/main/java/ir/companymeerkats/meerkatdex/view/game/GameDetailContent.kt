package ir.companymeerkats.meerkatdex.view.game

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Android
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.DeveloperBoard
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import ir.companymeerkats.meerkatdex.model.Game
import androidx.compose.material.icons.filled.Memory
import androidx.compose.material.icons.filled.NewReleases
import androidx.compose.material.icons.filled.Storage
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.VideogameAsset

@Composable
fun GameDetailContent(
    game: Game,
    modifier: Modifier = Modifier
) {
    var selectedPlatformIndex by rememberSaveable {
        mutableIntStateOf(0)
    }
    val selectedPlatform =
        game.platform.getOrNull(selectedPlatformIndex)

    var descriptionExpanded by rememberSaveable {
        mutableStateOf(false)
    }
    LazyColumn(
        modifier = modifier.fillMaxSize(),
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
                        .aspectRatio(2f)
                        .clip(
                            RoundedCornerShape(18.dp)
                        )
                )
            }
        }

        // Title + Rating
        item {

            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                val iconImage=
                    game.images.firstOrNull { it.type == "icon" }
                iconImage?.let {
                    AsyncImage(
                        model = it.path,
                        contentDescription = game.title,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(72.dp)
                            .clip(
                                RoundedCornerShape(16.dp)
                            )                )
                }
                Column(
                    modifier = Modifier.weight(1f) ){

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
                    lineHeight = MaterialTheme.typography.bodyMedium.lineHeight,
                    maxLines = if (descriptionExpanded) {
                        Int.MAX_VALUE
                    } else {
                        4
                    },
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    text = if (descriptionExpanded) {
                        "Show Less"
                    } else {
                        "Show More"
                    },
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.clickable {
                        descriptionExpanded = !descriptionExpanded
                    }
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
                    icon = Icons.Default.NewReleases,
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

//        Platforms
        item {

            DetailCard(
                title = "Platforms"
            ) {

                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    game.platform.forEachIndexed { index, platform ->

                        PlatformChip(
                            text = platform.name,
                            selected = index == selectedPlatformIndex,
                            onClick = {
                                selectedPlatformIndex = index
                            }
                        )
                    }
                }
            }
        }
        item {

            DetailCard(
                title = "Versions"
            ) {

                selectedPlatform?.let { platform ->

                    Column(
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {

                        Text(
                            text = platform.name,
                            style = MaterialTheme.typography.bodyMedium
                        )

                        Text(
                            text = "Latest Version: ${
                                platform.version ?: "Not available"
                            }",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        platform.releaseDate?.let {
                            Text(
                                text = "Release Date: $it",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }

                        platform.downloadSize?.let {
                            Text(
                                text = "Download Size: $it",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            }
        }
        // Requirements
        item {

            DetailCard(
                title = "Requirements (${selectedPlatform?.name ?: "Platform"})"
            ) {

                val requirement =
                    selectedPlatform?.gameRequirement

                if (requirement != null) {

                    val minimum =
                        requirement.minimumRequirements

                    RequirementRow(
                        title = "RAM",
                        value = minimum.ram,
                        icon = Icons.Default.Memory
                    )

                    RequirementRow(
                        title = "CPU",
                        value = minimum.cpu,
                        icon = Icons.Default.DeveloperBoard
                    )

                    RequirementRow(
                        title = "GPU",
                        value = minimum.gpu,
                        icon = Icons.Default.VideogameAsset
                    )

                    RequirementRow(
                        title = "Storage",
                        value = minimum.storage,
                        icon = Icons.Default.Storage
                    )

                    RequirementRow(
                        title = "System",
                        value = minimum.systemVersion,
                        icon = Icons.Default.Android
                    )

                } else {

                    Text(
                        text = "Requirements are not available for this platform.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }

        item {
            Spacer(
                modifier = Modifier.height(88.dp)
            )
        }
    }
}