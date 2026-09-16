package ir.companymeerkats.meerkatdex.view.home.drawer

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun DrawerItem(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {

    val colors = MaterialTheme.colorScheme

    NavigationDrawerItem(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 3.dp),

        icon = {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
        },

        label = {
            Text(
                text = text,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = if (selected) {
                    FontWeight.SemiBold
                } else {
                    FontWeight.Normal
                }
            )
        },

        selected = selected,

        onClick = onClick,

        shape = RoundedCornerShape(16.dp),

        colors = NavigationDrawerItemDefaults.colors(
            selectedContainerColor = colors.primary.copy(
                alpha = 0.14f
            ),

            selectedIconColor = colors.primary,

            selectedTextColor = colors.primary,

            unselectedContainerColor = Color.Transparent,

            unselectedIconColor = colors.onSurfaceVariant,

            unselectedTextColor = colors.onSurface
        )
    )
}