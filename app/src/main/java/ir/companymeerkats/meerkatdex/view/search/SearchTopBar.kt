package ir.companymeerkats.meerkatdex.view.search

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable

@ExperimentalMaterial3Api
@Composable
fun SearchTopBar(
    scrollBehavior: TopAppBarScrollBehavior
) {

    CenterAlignedTopAppBar(
        title = {
            Text("Search")
        },
        scrollBehavior = scrollBehavior
    )
}