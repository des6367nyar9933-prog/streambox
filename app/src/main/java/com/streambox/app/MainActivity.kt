package com.streambox.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.streambox.app.ui.screens.AIAssistantScreen
import com.streambox.app.ui.screens.HomeScreen
import com.streambox.app.ui.screens.LoginScreen
import com.streambox.app.ui.screens.MovieScreen
import com.streambox.app.ui.screens.MusicScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StreamBoxTheme {
                StreamBoxApp()
            }
        }
    }
}

@Composable
fun StreamBoxTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = MaterialTheme.colorScheme,
        content = content
    )
}

@Composable
fun StreamBoxApp() {
    var isLoggedIn by remember { mutableStateOf(false) }
    var selectedTab by remember { mutableIntStateOf(0) }

    if (!isLoggedIn) {
        LoginScreen(onLoginSuccess = { isLoggedIn = true })
    } else {
        StreamBoxMainApp(selectedTab = selectedTab, onTabChange = { selectedTab = it })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StreamBoxMainApp(selectedTab: Int, onTabChange: (Int) -> Unit) {
    val screenTitles = listOf("StreamBox", "Movies", "Music", "AI Assistant")

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = screenTitles[selectedTab],
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.White
                    )
                },
            )
        },
        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.surface
            ) {
                val navItems = listOf(
                    Icons.Default.Home to "Home",
                    Icons.Default.PlayArrow to "Movies",
                    Icons.Default.MusicNote to "Music",
                    Icons.Default.Mic to "AI"
                )

                navItems.forEachIndexed { index, (icon, label) ->
                    NavigationBarItem(
                        selected = selectedTab == index,
                        onClick = { onTabChange(index) },
                        icon = { Icon(icon, contentDescription = label, modifier = Modifier) },
                        label = { Text(label, fontSize = 11.sp) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color(0xFF00d4ff),
                            selectedTextColor = Color(0xFF00d4ff),
                            unselectedIconColor = Color.White,
                            unselectedTextColor = Color.White,
                            indicatorColor = Color.Transparent
                        )
                    )
                }
            }
        }
    ) { innerPadding ->
        when (selectedTab) {
            0 -> HomeScreen()
            1 -> MovieScreen()
            2 -> MusicScreen()
            3 -> AIAssistantScreen()
        }
    }
}
