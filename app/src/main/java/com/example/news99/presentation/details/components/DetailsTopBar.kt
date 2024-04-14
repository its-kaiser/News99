package com.example.news99.presentation.details.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.news99.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsTopBar(
    onBrowsingClick: () -> Unit,
    onShareClick: () -> Unit,
    onFavouriteClick: () -> Unit,
    onBackClick: () -> Unit,
    scrollBehavior: TopAppBarScrollBehavior
){

    Surface {
        TopAppBar(
            title = {},
            modifier = Modifier
                .fillMaxWidth(),
            navigationIcon = {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null
                    )
                }
            },
            actions = {
                IconButton(onClick = onFavouriteClick) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = null
                    )
                }
                IconButton(onClick = onShareClick) {
                    Icon(
                        imageVector = Icons.Default.Share,
                        contentDescription = null
                    )
                }
                IconButton(onClick = onBrowsingClick) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_network),
                        contentDescription = null
                    )
                }
            },
            scrollBehavior = scrollBehavior
        )
    }
}

