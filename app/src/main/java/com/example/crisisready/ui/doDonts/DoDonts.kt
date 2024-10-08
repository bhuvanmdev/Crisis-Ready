package com.example.crisisready.ui.doDonts

import android.graphics.drawable.Icon
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowRight
import androidx.compose.material.icons.filled.RadioButtonChecked
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.crisisready.R


val naturalDisasterList = listOf(
    (R.string.earthquake),
    (R.string.flood),
    (R.string.cyclone),
    (R.string.landslide),
    (R.string.tsunami),
    (R.string.heat_wave),
    (R.string.fire),
    (R.string.drought),
    (R.string.thunderstorm),
    (R.string.forest_fire)
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DoDontsScreenTopBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(title = { Text(text = "Do/Dont's" )})
}

@Composable
fun DoDontsScreen(modifier: Modifier = Modifier,onclick: (String) -> Unit) {
    Scaffold(
        topBar = { DoDontsScreenTopBar() }
    ) {
        DoDontsContent(modifier = Modifier.padding(it),onclick)
    }
}
@Composable
fun DoDontsContent(modifier: Modifier = Modifier,onclick: (String) -> Unit) {
    val viewModel = DoDontsViewModel()
    Column(modifier = Modifier.fillMaxWidth()) {
        val selected by viewModel.selected.collectAsState()
            Column(
                modifier = modifier
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
            ) {

                Text(
                    text = "Natural",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(5.dp))
                HorizontalDivider()
                Spacer(modifier = Modifier.height(5.dp))
                naturalDisasterList.forEach() { disaster ->
                    Disaster(
                        name = stringResource(id = disaster),
                        onclick = { onclick(it) }
                    )
                }


            }
        }
}

@Composable
fun Disaster(modifier: Modifier = Modifier, name: String,onclick:(String)->Unit) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onclick(name);Log.d("selected", name) }
        ,
        elevation = CardDefaults.elevatedCardElevation(4.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = name)
            Icon(imageVector = Icons.Filled.ArrowRight, contentDescription = name)
        }
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DoDOntsPreview(modifier: Modifier = Modifier) {
}