package ir.companymeerkats.meerkatdex.view.playlist
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ir.companymeerkats.meerkatdex.R
import ir.companymeerkats.meerkatdex.model.Playlist
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlaylistTopBar(
    onBackClick: () -> Unit,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    playlist: Playlist
) {
    TopAppBar(
        navigationIcon = {
            IconButton(
                onClick = onBackClick
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBackIos,
                    contentDescription = "Back"
                )
            }
        },

        title = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = playlist.name,
                    modifier = Modifier.padding(top=12.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = playlist.description,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        maxLines = 2,
                        fontSize = 12.sp,
                        lineHeight = 14.sp,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 10.dp)
                    )

                    Text(
                        text = "${playlist.number} games",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.secondary,
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .clip(
                                RoundedCornerShape(50)
                            )
                            .background(
                                MaterialTheme.colorScheme.secondary.copy(
                                    alpha = 0.12f
                                )
                            )
                            .padding(
                                horizontal = 8.dp,
                                vertical = 4.dp
                            )
                    )
                }
            }
        },

        scrollBehavior = scrollBehavior
    )
}