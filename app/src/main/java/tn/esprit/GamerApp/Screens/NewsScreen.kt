package tn.esprit.GamerApp.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tn.esprit.GamerApp.GameCardData
import tn.esprit.GamerApp.R
import tn.esprit.GamerApp.StoreData
import tn.esprit.GamerApp.ui.theme.GamerAppTheme


val gameList = listOf(
    GameCardData("Top 10 Gaming News", "Here's the latest " +
            "news from the gaming world.", R.drawable.top10),
    GameCardData("The Legend of Zelda", "Discover the new" +
            " adventure.", R.drawable.zelda),

)


@Composable
fun CardView(
    cardData: GameCardData, onClick: () -> Unit = {},
    onShowMore: () -> Unit = {}
){

    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        onClick = onClick,
    ){

        Column {
            Image(
                painter = painterResource(id = cardData.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                contentScale = ContentScale.Crop            )
            Text(
                text = cardData.title,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.padding(8.dp)
            )
            Text(
                text = cardData.description,
                fontSize = 14.sp,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
            )

            TextButton(onClick = onShowMore,
                modifier = Modifier.offset(250.dp , 0.dp) ) {
                Text("Show more ", color = Color(0xFFE91E63)
                   )
            }
        }
    }





}
@Composable
fun GameListScreen() {
    LazyColumn {
        items(gameList) { item ->
            CardView(cardData = item)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MyBottomBarPreview() {
    GamerAppTheme {
     GameListScreen()
    }
}