package ir.companymeerkats.meerkatdex.view.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Games
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Layers
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.material3.TopAppBarDefaults
import ir.companymeerkats.meerkatdex.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(
    onBackClick: () -> Unit,
) {

    val scrollBehavior =
        TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(
                scrollBehavior.nestedScrollConnection
            )
    ) {

        AboutTopBar(
            scrollBehavior,
            onBackClick
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(
                horizontal = 12.dp,
                vertical = 12.dp
            ),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            // ─────────────────────────────────
            // Header
            // ─────────────────────────────────

            item {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = 8.dp,
                            bottom = 8.dp
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Image(
                        painter = painterResource(
                            R.drawable.meerkat_icon
                        ),
                        contentDescription = "Meerkat Dex",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(110.dp)
                            .clip(
                                RoundedCornerShape(50)
                            )
                    )

                    Spacer(
                        modifier = Modifier.height(10.dp)
                    )

                    Text(
                        text = "Meerkat Dex",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(
                        modifier = Modifier.height(4.dp)
                    )

                    Text(
                        text = "Your Complete Game Database",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            // ─────────────────────────────────
            // What is Meerkat Dex?
            // ─────────────────────────────────

            item {

                AboutSectionCard(
                    icon = Icons.Default.Games,
                    title = "What is Meerkat Dex?",
                    description = "Meerkat Dex is a comprehensive game database that helps you discover, explore and learn about games across different platforms."
                )
            }

            // ─────────────────────────────────
            // Our Features
            // ─────────────────────────────────

            item {

                Text(
                    text = "Our Features",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(
                        top = 4.dp,
                        bottom = 2.dp
                    )
                )
            }

            item {

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    )
                ) {

                    Column(
                        modifier = Modifier.padding(
                            vertical = 8.dp
                        )
                    ) {

                        FeatureItem(
                            icon = Icons.Default.Games,
                            title = "Comprehensive Database",
                            description = "Access detailed information about games"
                        )

                        FeatureItem(
                            icon = Icons.Default.Search,
                            title = "Smart Search",
                            description = "Find games quickly with powerful search"
                        )

                        FeatureItem(
                            icon = Icons.Default.Layers,
                            title = "Detailed Game Info",
                            description = "Explore platforms, versions, requirements and more"
                        )
                    }
                }
            }

            // ─────────────────────────────────
            // Supported Platforms
            // ─────────────────────────────────

            item {

                Text(
                    text = "Supported Platforms",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(
                        top = 4.dp,
                        bottom = 2.dp
                    )
                )
            }

            item {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    PlatformChip("Android")
                    PlatformChip("iOS")
                    PlatformChip("Windows")
                }
            }

            item {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    PlatformChip("PlayStation")
                    PlatformChip("Xbox")
                }
            }

            // ─────────────────────────────────
            // Built with Passion
            // ─────────────────────────────────

            item {

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp),
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(
                        containerColor =
                            MaterialTheme.colorScheme.surface
                    )
                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp),
                        horizontalAlignment =
                            Alignment.CenterHorizontally
                    ) {

                        Image(
                            painter = painterResource(
                                R.drawable.meerkat_icon
                            ),
                            contentDescription = null,
                            modifier = Modifier.size(70.dp)
                        )

                        Spacer(
                            modifier = Modifier.height(8.dp)
                        )

                        Text(
                            text = "Built with Passion",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(
                            modifier = Modifier.height(4.dp)
                        )

                        Text(
                            text = "Meerkat Dex is created for game lovers, by game lovers.",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        Spacer(
                            modifier = Modifier.height(8.dp)
                        )

                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.tertiary,
                            modifier = Modifier.size(20.dp)
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
}
@Composable
private fun AboutSectionCard(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    description: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {

        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.Top
        ) {

            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .size(42.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(
                        MaterialTheme.colorScheme.primary.copy(
                            alpha = 0.12f
                        )
                    )
                    .padding(9.dp)
            )

            Spacer(
                modifier = Modifier.size(12.dp)
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier = Modifier.height(6.dp)
                )

                Text(
                    text = description,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    lineHeight = 18.sp
                )
            }
        }
    }
}
@Composable
private fun FeatureItem(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    description: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 12.dp,
                vertical = 10.dp
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .size(42.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(
                    MaterialTheme.colorScheme.primary.copy(
                        alpha = 0.12f
                    )
                )
                .padding(9.dp)
        )

        Spacer(
            modifier = Modifier.width(12.dp)
        )

        Column(
            modifier = Modifier.weight(1f)
        ) {

            Text(
                text = title,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(2.dp)
            )

            Text(
                text = description,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
@Composable
private fun PlatformChip(
    text: String
) {
    Text(
        text = text,
        style = MaterialTheme.typography.labelMedium,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        modifier = Modifier
            .clip(RoundedCornerShape(50))
            .background(
                MaterialTheme.colorScheme.surfaceVariant
            )
            .padding(
                horizontal = 12.dp,
                vertical = 7.dp
            )
    )
}