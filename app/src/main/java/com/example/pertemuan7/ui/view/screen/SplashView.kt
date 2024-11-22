package com.example.pertemuan7.ui.view.screen

import android.widget.Button
import android.window.SplashScreenView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.pertemuan7.R

@Composable
fun SplashView(
    onMulaiButton: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.primary)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Logo image
        Image(
            painter = painterResource(R.drawable.logoumy),
            contentDescription = "",
            modifier = Modifier.size(200.dp)
        )
// Start button with updated styles
        Button(
            onClick = {
                onMulaiButton()
            },
            modifier = Modifier
                .fillMaxWidth(0.7f)  // Make button less wide
                .padding(26.dp),  // Adjust padding for better balance
            colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                containerColor = Color.Yellow // Set button color to yellow
            )
        )
        {
            Text(
                text = "Mulai",
                color = Color.DarkGray,  // Set text color to dark gray (abu tua)
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold  // Make text bold
            )
        }
    }
}