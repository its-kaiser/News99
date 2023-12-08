package com.example.news99.presentation.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.LazyPagingItems
import com.example.news99.R
import com.example.news99.domain.model.Article
import com.example.news99.presentation.Dimens.MediumPadding1
import com.example.news99.presentation.navigation.Route
import com.example.news99.presentation.shared.ArticlesList
import com.example.news99.presentation.shared.SearchBar

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun  HomeScreen(
    articles:LazyPagingItems<Article>,
    navigate:(String)->Unit
){
    val titles by remember {
        derivedStateOf {
            if (articles.itemCount>10){
                articles.itemSnapshotList.items
                    .slice(IntRange(start = 0, endInclusive = 9))
                    .joinToString(separator = " \uD83d\uDFE5 "){it.title}
            }else{
                ""
            }
        }
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = MediumPadding1)
        .statusBarsPadding()
    ) {

        Image( 
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription =null,
            modifier= Modifier
                .width(150.dp)
                .height(30.dp)
                .padding(horizontal = MediumPadding1)
        )
        
        Spacer(modifier = Modifier.height(MediumPadding1))
        
        SearchBar(
            text = "",
            readOnly = true,
            onValueChange = {},
            onCLick = {
                      navigate(Route.SearchScreen.route)
            },
            onSearch = { },
            modifier = Modifier.padding(horizontal = MediumPadding1)
        )

        Spacer(modifier = Modifier.height(MediumPadding1))

        Text(
            text = titles,
            fontSize = 12.sp,
            color = colorResource(id = R.color.placeholder),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = MediumPadding1)
                .basicMarquee()
        )

        Spacer(modifier = Modifier.height(MediumPadding1))
        
        ArticlesList(
            articles = articles,
            onClick = {
                navigate(Route.DetailsScreen .route)
            },
            modifier = Modifier.padding(horizontal = MediumPadding1)
        )
    }
}