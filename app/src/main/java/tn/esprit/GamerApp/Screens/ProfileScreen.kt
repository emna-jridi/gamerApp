package tn.esprit.GamerApp.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddShoppingCart
import androidx.compose.material.icons.filled.BookmarkRemove
import androidx.compose.material.icons.filled.PersonPin
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tn.esprit.GamerApp.R
import tn.esprit.GamerApp.StoreData
import tn.esprit.GamerApp.ui.theme.GamerAppTheme

val gameList3 =listOf(
    StoreData("The Legond of Zelda", "Nintendo Switch " ,
        R.drawable.ze , 45.99),
    StoreData("Red Dead Readmption 2", "PS4 Games" ,
        R.drawable.reddeaad , 70.99),
    StoreData("Grand Theft Auto 5", "PS4 Games" ,
        R.drawable.gta , 30.0),
)
@Composable
fun ProfileScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            Icons.Default.PersonPin, contentDescription = null,
            modifier = Modifier.size(200.dp),
            tint = Color(0xFFE91E63)
        )

        Text(
            "FullName", fontWeight = FontWeight.Bold,
            fontSize = 18.sp, modifier = Modifier.padding(16.dp)
        )
        Text("Email", fontWeight = FontWeight.W300,
            modifier = Modifier.padding(16.dp)
        )

        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFE91E63)
            ),
        ) {
            Text("Edit Profile", color = Color.White)
        }

        Spacer(modifier = Modifier.height(20.dp))
        Divider()
        Text(
            "Bookmarks", fontWeight = FontWeight.Bold,
            fontSize = 18.sp, modifier = Modifier.padding(16.dp)
                .offset((-100).dp, 0.dp)
        )

        gameList3.forEach { cardData ->
            Card(
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(4.dp),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(16.dp)
                ) {
                    Image(
                        painter = painterResource(cardData.imageRes),
                        contentDescription = null,
                        modifier = Modifier
                            .size(150.dp)
                            .padding(6.dp)
                    )
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            cardData.title,
                            fontWeight = FontWeight.W600,
                            color = Color(0xFFE91E63),
                            fontSize = 18.sp,
                            modifier = Modifier.padding(bottom = 9.dp)
                        )
                        Text(
                            cardData.typeConsole,
                            color = Color.Gray,
                            modifier = Modifier.padding(bottom = 9.dp)
                        )
                        Text("${cardData.prix} $",
                            color = Color.Gray
                        )
                    }
                    Icon(
                        Icons.Default.BookmarkRemove,
                        contentDescription = null,
                        tint = Color(0xFFE91E63)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    GamerAppTheme {
        ProfileScreen() // plus besoin de paramètre
    }
}
