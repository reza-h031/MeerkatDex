package ir.companymeerkats.meerkatdex.view.search

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun CustomSearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {

    val colors = MaterialTheme.colorScheme

    OutlinedTextField(
        value = query,
        onValueChange = onQueryChange,
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 16.dp),
        placeholder = {
            Text(
                text = "Search games...",
                color = colors.onSurfaceVariant
            )
        },

        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = colors.primary
            )
        },

        singleLine = true,

        shape = RoundedCornerShape(20.dp),

        colors = OutlinedTextFieldDefaults.colors(

            // Normal
            unfocusedContainerColor =
            colors.surfaceVariant.copy(alpha = 0.55f),

            unfocusedBorderColor =
            colors.outlineVariant,

            unfocusedTextColor =
            colors.onSurface,

            // Focused
            focusedContainerColor =
            colors.surfaceVariant.copy(alpha = 0.75f),

            focusedBorderColor =
            colors.primary,

            focusedTextColor =
            colors.onSurface,

            // Cursor
            cursorColor =
            colors.primary,

            // Icon
            focusedLeadingIconColor =
            colors.primary,

            unfocusedLeadingIconColor =
            colors.primary
        ),
    )
}