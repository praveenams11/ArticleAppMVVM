package com.pms.articleappmvvm.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil.size.Scale
import com.pms.articleappmvvm.R
import com.pms.articleappmvvm.model.Articles

@Composable
fun ArticleItem(articles: Articles,) {
    val handler = LocalUriHandler.current
    Card(shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(170.dp)
            .padding(8.dp)
            .background(Color.White)
            .clickable {
                handler.openUri(articles.url)
            }
    ) {
        Surface() {
            Row(
                Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                Alignment.CenterVertically

            ) {
                Box(modifier = Modifier.clip(CircleShape)) {
                    Image(
                        painter = rememberImagePainter(
                            data = "https://static01.nyt.com/images/2023/05/28/opinion/25worthen-illo/25worthen-illo-thumbStandard.png",
                            builder = {
                                scale(Scale.FILL)
                                placeholder(R.drawable.ic_launcher_background)
                            }),
                        contentDescription = "image",
                        modifier = Modifier
                            .size(70.dp),
                        contentScale = ContentScale.Crop,
                        )
                }
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxHeight()
                        .weight(0.6f)
                ) {
                    Text(
                        text = articles.title,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier
                            .padding(4.dp)
                    )
                    Text(
                        text = articles.byline,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = androidx.compose.ui.text.TextStyle(
                            color = Color.Gray,
                            fontSize = 16.sp
                        ),
                        modifier = Modifier
                            .padding(4.dp)
                    )

                    Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                        Text(
                            text = articles.section,
                            style = androidx.compose.ui.text.TextStyle(
                                color = Color.Gray,
                                fontSize = 16.sp
                            ),
                            modifier = Modifier
                                .padding(4.dp)
                        )
                        Spacer(modifier = Modifier.width(25.dp))
                        Icon(
                            imageVector = Icons.Filled.DateRange,
                            contentDescription = "Icon",
                            modifier = Modifier
                                .size(28.dp)
                                .padding(4.dp),
                            tint = Color.Gray
                        )
                        Text(
                            text = articles.publishedDate,
                            style = androidx.compose.ui.text.TextStyle(
                                color = Color.Gray,
                                fontSize = 15.sp
                            ),
                            modifier = Modifier
                                .padding(4.dp)
                        )
                    }
                }

                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "Back",
                    tint = Color.Gray,
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(0.1f)

                )
            }
        }
    }
}

