package com.pms.articleappmvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import com.pms.articleappmvvm.model.Articles
import com.pms.articleappmvvm.ui.theme.ArticleAppMVVMTheme
import com.pms.articleappmvvm.view.ArticleItem
import com.pms.articleappmvvm.viewmodel.ArticleViewModel

class MainActivity : ComponentActivity() {

    private val articleViewModel by viewModels<ArticleViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArticleAppMVVMTheme {
                Column() {
                    AppBar()
                    ArticleList(articleList = articleViewModel.articleList)
                    articleViewModel.getPopularArticles()
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar() {
    Surface() {
        TopAppBar(title = {
            Text(
                text = stringResource(id = R.string.app_bar_text),
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
        },
            modifier = Modifier.background(Color.Black),
            navigationIcon = {
                IconButton(onClick = { /* Handle navigation icon click */ }) {
                    Icon(Icons.Default.Menu, contentDescription = "Navigation")
                }
            },
            actions = {
                IconButton(onClick = { /* Handle action click */ }) {
                    Icon(Icons.Default.Search, contentDescription = "Search")
                }
                IconButton(onClick = { /* Handle action click */ }) {
                    Icon(Icons.Default.MoreVert, contentDescription = "More")
                }
            })
    }

}


@Composable
fun ArticleList(articleList: List<Articles>) {
    LazyColumn {
        itemsIndexed(items = articleList) { index, item ->
            ArticleItem(articles = item)
        }
    }
}
