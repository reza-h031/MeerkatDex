package ir.companymeerkats.meerkatdex.view.game

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable

@ExperimentalMaterial3Api
@Composable
fun GameDetailTopBar (
    scrollBehavior: TopAppBarScrollBehavior,
    onBackClick:()-> Unit
){
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
        Text(
            text = "Game Detail"
        )
    },

    scrollBehavior = scrollBehavior
    )
}