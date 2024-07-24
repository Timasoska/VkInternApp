package com.example.vkapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.vkapp.ui.screens.HomePage
import com.example.vkapp.ui.theme.VkAppTheme
import com.example.vkapp.ui.viewmodel.ProductViewModel
import com.example.vkapp.ui.viewmodel.ProductViewState

    class MainActivity : ComponentActivity() {
    private val productViewModel: ProductViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VkAppTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    HomePage(productViewModel)
                }
            }
        }
    }
}
