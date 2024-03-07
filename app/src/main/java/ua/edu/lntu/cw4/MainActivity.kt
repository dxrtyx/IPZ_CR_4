package ua.edu.lntu.cw4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import ua.edu.lntu.cw4.affirmations.data.Datasource
import ua.edu.lntu.cw4.affirmations.model.ItemAffirmations
import ua.edu.lntu.cw4.ui.theme.IPZ_CR_4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            IPZ_CR_4Theme {
                NavHost(
                    navController = navController,
                    startDestination = "listscreen"
                ) {
                    composable("listscreen") {
                        AffirmationItemList(affirmationItemList = Datasource().loadAffirmations()) {
                            navController.navigate("itemscreen")
                        }
                    }
                    composable("itemscreen") {
                        ItemScreen(number = 1)
                    }
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//
//                }
            }
        }
    }
}

@Composable
fun AffirmationItemCard(affirmationItem: ItemAffirmations, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Image(
            painter = painterResource(id = affirmationItem.imageResourceId),
            contentDescription = stringResource(id = affirmationItem.stringResourceId),
            modifier = Modifier
                .padding(10.dp)
                .height(100.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(10.dp)),
            contentScale = ContentScale.Crop
        )
        Button(
            onClick = { /* Обробник події кнопки */ },
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .wrapContentSize(align = Alignment.Center)
        ) {
            Text(
                text = "Knopka",
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(align = Alignment.Center)
            )
        }
    }
}

@Composable
fun AffirmationItemList(affirmationItemList: List<ItemAffirmations>) {
    LazyVerticalGrid(columns = GridCells.Fixed(1), userScrollEnabled = true) {
        items(affirmationItemList) {
                affirmationItem -> AffirmationItemCard(
            affirmationItem = affirmationItem,
            modifier = Modifier
                .padding(10.dp)
                )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AffrimationPreview() {
    IPZ_CR_4Theme {
        AffirmationItemList(affirmationItemList = Datasource().loadAffirmations())
    }
}