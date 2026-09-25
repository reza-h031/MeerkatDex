package ir.companymeerkats.meerkatdex.view.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ir.companymeerkats.meerkatdex.model.SimpleGame

@Composable
fun GameCardSearch (
    game: SimpleGame,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    val colors = MaterialTheme.colorScheme

    Row (
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(18.dp))
            .clickable(onClick = onClick)
            .background(colors.surface),
        verticalAlignment = Alignment.CenterVertically)
     {
         Image(
             painter = painterResource(game.imageIcon),
             contentDescription = null,
             contentScale = ContentScale.Crop,
             modifier = Modifier
                 .size(60.dp)
                 .clip(RoundedCornerShape(12.dp))

         )
         Spacer(
             modifier = Modifier.width(10.dp)
         )
         Column(
             modifier = Modifier
                 .padding(
                     top = 12.dp,
                     bottom = 12.dp,
                     end = 12.dp)
         ) {
             Text(
                 text = game.name ,
                 style = MaterialTheme.typography.titleSmall,
                 fontWeight = FontWeight.Bold,
                 maxLines = 1
             )
             Spacer(
                 modifier = Modifier.height(6.dp)
             )
             Row(
                 modifier = Modifier.fillMaxWidth(),
                 verticalAlignment = Alignment.CenterVertically
             ) {

                 game.platform
                     .take(2)
                     .forEach { platform ->

                         Text(
                             text = "${platform.name} • ",
                             style = MaterialTheme.typography.labelSmall,
                             color = colors.onSurfaceVariant,
                             maxLines = 1,
                         )
                     }
             }
             Spacer(
                 modifier = Modifier.height(10.dp)
             )
             Row(
                 horizontalArrangement = Arrangement.spacedBy(5.dp)
             ) {
                 game.genres
                     .take(2)
                     .forEach { genre ->

                         Text(
                             text = genre.name,
                             style = MaterialTheme.typography.labelSmall,
                             color = colors.onSurfaceVariant,
                             modifier = Modifier
                                 .clip(RoundedCornerShape(50))
                                 .background(
                                     colors.primary.copy(alpha = 0.12f)
                                 )
                                 .padding(
                                     horizontal = 8.dp,
                                     vertical = 4.dp
                                 )
                         )
                     }
                 Spacer(
                     modifier=Modifier.weight(1f)
                 )
                 Icon(
                     imageVector = Icons.Default.Star,
                     contentDescription = null,
                     tint = Color(0xFFFFC107),
                     modifier = Modifier.size(16.dp)
                 )

                 Spacer(
                     modifier = Modifier.width(3.dp)
                 )

                 Text(
                     text = game.rating.get(0).rating,
                     style = MaterialTheme.typography.labelSmall,
                     fontWeight = FontWeight.Bold
                 )
             }

         }
     }
}