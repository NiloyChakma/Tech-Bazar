package com.example.techbazar20.Activity

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.techbazar20.Model.ItemsModel
import com.example.techbazar20.R

@Composable
fun ListItems(items:List<ItemsModel>) 
{
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.height(500.dp).padding(start = 8.dp,end=8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(items.size){ row ->
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)){
                RecommendedItem(items,row)
            }

        }
    }
}

@Composable
fun RecommendedItem(items: List<ItemsModel>, pos: Int) 
{
    val context = LocalContext.current
    Column(modifier = Modifier.padding(8.dp).height(225.dp)){
        AsyncImage(model = items[pos].picUrl.firstOrNull(),
            contentDescription = items[pos].title,
            modifier = Modifier.width(175.dp)
                .background(colorResource(R.color.lightGrey),shape = RoundedCornerShape(10.dp))
                    .height(175.dp).padding(8.dp).clickable{}, contentScale = ContentScale.Inside
            )
        Text(text=items[pos].title,
        color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(top = 8.dp))

        Row(modifier = Modifier.padding(top=4.dp).fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
            Row{
                Image(painter = painterResource(id=R.drawable.star),
                    contentDescription = "Rating",
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text=items[pos].rating.toString(),
                    color = Color.Black,
                    fontSize = 15.sp,
                )

            }
            Text(
                text = "$${items[pos].price}",
                color = colorResource(R.color.purple),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}