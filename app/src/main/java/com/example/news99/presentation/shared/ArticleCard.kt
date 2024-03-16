package com.example.news99.presentation.shared

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.news99.R
import com.example.news99.domain.model.Article
import com.example.news99.domain.model.Source
import com.example.news99.presentation.Dimens.ArticleCardSize
import com.example.news99.presentation.Dimens.ExtraSmallPadding1
import com.example.news99.presentation.Dimens.ExtraSmallPadding2
import com.example.news99.presentation.Dimens.SmallIconSize
import com.example.news99.ui.theme.News99Theme
import java.text.SimpleDateFormat
import java.util.Locale


@Composable
fun ArticleCard(
    modifier: Modifier = Modifier,
    article: Article,
    onClick: () -> Unit
) {

    val context = LocalContext.current
    Row(modifier = modifier.clickable { onClick() }) {

        AsyncImage(
            model = ImageRequest
                .Builder(context)
                .data(article.urlToImage)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(ArticleCardSize)
                .clip(MaterialTheme.shapes.medium)
        )

        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(horizontal = ExtraSmallPadding1)
                .height(ArticleCardSize)
        ) {

            Text(
                text = article.title,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Row(verticalAlignment = Alignment.CenterVertically) {

                Text(
                    text = article.source.name,
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = colorResource(id =R.color.body)
                )

                Spacer(modifier = Modifier.width(ExtraSmallPadding2))

                Icon(
                    painter = painterResource(id = R.drawable.ic_time),
                    contentDescription = null,
                    modifier = Modifier.size(SmallIconSize),
                    tint =  colorResource(id =R.color.body)
                )

                Spacer(modifier = Modifier.width(ExtraSmallPadding2))

                Text(
                    text = getDate(article.publishedAt),
                    style = MaterialTheme.typography.labelSmall,
                    color = colorResource(id =R.color.body)
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ArticleCardPreview() {
    News99Theme {
        ArticleCard(
            article = Article(
                author = "",
                content = "",
                description = "",
                publishedAt = "2 hours",
                source = Source(id = "", name = "BBC"),
                title = "there once was a boy mad enough to kill people for fun.",
                url = "",
                urlToImage = ""
            )
        ) {
        }
    }
}


private fun getDate(date: String): String {

    val simpleFormatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH)
    val simpleDate = simpleFormatter.parse(date)

    val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)

    return formatter.format(simpleDate)
}