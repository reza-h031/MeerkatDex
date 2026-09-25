package ir.companymeerkats.meerkatdex.view.about

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
fun AboutTopBar(
    scrollBehavior: TopAppBarScrollBehavior,
    onBackClick:()-> Unit
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
        Text(
            text = "About Meerkat Dex"
        )
    },

    scrollBehavior = scrollBehavior
    )
}