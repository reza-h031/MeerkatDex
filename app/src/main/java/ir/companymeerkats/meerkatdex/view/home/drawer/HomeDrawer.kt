package ir.companymeerkats.meerkatdex.view.home.drawer

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Help
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ir.companymeerkats.meerkatdex.R

@Composable
fun HomeDrawer(
    selectedItem: String = "Home",
    onItemClick: (String) -> Unit = {},
    onClose: () -> Unit = {}
) {

    val colors = MaterialTheme.colorScheme

    ModalDrawerSheet(
        modifier = Modifier
            .fillMaxHeight()
            .width(320.dp),
        drawerContainerColor = colors.surface,
        drawerContentColor = colors.onSurface,
        drawerShape = RoundedCornerShape(
            topEnd = 28.dp,
            bottomEnd = 28.dp
        )
    ) {

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(horizontal = 16.dp)
        ) {

            // ─────────────────────────────
            // Header
            // ─────────────────────────────

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 28.dp,
                        bottom = 24.dp
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {

                // Meerkat Logo
                Image(
                    painter = painterResource(
                        id = R.drawable.meerkat_icon
                    ),
                    contentDescription = "Meerkat Dex",
                    modifier = Modifier
                        .size(64.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )

                Spacer(
                    modifier = Modifier.width(14.dp)
                )

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = "Meerkat Dex",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Your Complete Game Database",
                        style = MaterialTheme.typography.bodySmall,
                        color = colors.onSurfaceVariant
                    )
                }

                IconButton(
                    onClick = onClose
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Close,
                        contentDescription = "Close"
                    )
                }
            }


            // ─────────────────────────────
            // Main Menu
            // ─────────────────────────────

            DrawerItem(
                icon = Icons.Outlined.Home,
                text = "Home",
                selected = selectedItem == "Home",
                onClick = {
                    onItemClick("Home")
                }
            )

            DrawerItem(
                icon = Icons.Outlined.Search,
                text = "Search",
                selected = selectedItem == "Search",
                onClick = {
                    onItemClick("Search")
                }
            )


            DrawerItem(
                icon = Icons.Outlined.Settings,
                text = "Settings",
                selected = selectedItem == "Settings",
                onClick = {
                    onItemClick("Settings")
                }
            )


            Spacer(
                modifier = Modifier.height(16.dp)
            )

            HorizontalDivider(
                color = colors.outlineVariant
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )


            // ─────────────────────────────
            // Secondary Menu
            // ─────────────────────────────

            DrawerItem(
                icon = Icons.Outlined.Help,
                text = "Help & Support",
                selected = selectedItem == "Help & Support",
                onClick = {
                    onItemClick("Help & Support")
                }
            )

            DrawerItem(
                icon = Icons.Outlined.Info,
                text = "About",
                selected = selectedItem == "About",
                onClick = {
                    onItemClick("About")
                }
            )


            // فضای خالی تا پایین
            Spacer(
                modifier = Modifier.weight(1f)
            )


            // ─────────────────────────────
            // Meerkat Dex Card
            // ─────────────────────────────

            MeerkatAccountCard()


            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Text(
                text = "v1.0.0",
                style = MaterialTheme.typography.labelSmall,
                color = colors.onSurfaceVariant,
                modifier = Modifier.padding(
                    start = 4.dp,
                    bottom = 12.dp
                )
            )
        }
    }
}
