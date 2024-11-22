package com.example.pertemuan7.ui.view.screen

import android.widget.Button
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pertemuan7.R
import com.example.pertemuan7.model.Mahasiswa

@Composable
fun MahasiswaFormView(
    onSubmitButton: (MutableList<String>) -> Unit,
    onbackbuttonClicked: () -> Unit
) {
    var nama by remember { mutableStateOf("") }
    var nim by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var listData: MutableList<String> = mutableListOf(nim, nama, email)


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.primary))
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 40.dp, vertical = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(30.dp) // Add space between logo and text
        ) {
            Image(
                painter = painterResource(id = R.drawable.logoumy),
                contentDescription = "",
                modifier = Modifier.size(80.dp)  // Set logo size
            )


            Column {
                Text(
                    text = "Universitas Muhammadiyah Yogyakarta",
                    color = Color.Red, // Change to white for better contrast
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif // Set to serif font
                )


                Text(
                    text = "Unggul dan Islami",
                    color = Color.Red, // Change to white for better contrast
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    fontFamily = FontFamily.Serif // Set to serif font
                )
            }
        }


        Box(
            modifier = Modifier
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(topEnd = 15.dp, topStart = 15.dp)
                )
                .fillMaxSize()
                .padding(top = 40.dp) // Add padding to avoid content being too close to top
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Masukkan Data Kamu",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(vertical = 8.dp) // Add spacing
                )


                Text(
                    text = "Isi Sesuai data yang kamu daftarkan",
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(bottom = 20.dp) // Add spacing below instruction text
                )


                // Input Fields
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp), // Add padding between fields
                    shape = RoundedCornerShape(50.dp),
                    value = nim,
                    onValueChange = { nim = it },
                    label = { Text(text = "Nomor Induk Mahasiswa") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Info,
                            contentDescription = ""
                        )
                    }
                )


                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp), // Add padding between fields
                    shape = RoundedCornerShape(50.dp),
                    value = nama,
                    onValueChange = { nama = it },
                    label = { Text(text = "Masukkan Nama Anda") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Person,
                            contentDescription = ""
                        )
                    }
                )


                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 20.dp), // Add padding between fields
                    shape = RoundedCornerShape(50.dp),
                    value = email,
                    onValueChange = { email = it },
                    label = { Text(text = "Masukkan Email") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Email,
                            contentDescription = ""
                        )
                    }
                )


                // Buttons
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp) // Space between buttons
                ) {
                    Button(
                        onClick = { onbackbuttonClicked() },
                        modifier = Modifier.weight(1f), // Make button size equal
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.primary)
                        ),
                        shape = RoundedCornerShape(50.dp)
                    ) {
                        Text(text = "Kembali", color = Color.White)
                    }


                    Button(
                        onClick = { onSubmitButton(listData) },
                        modifier = Modifier.weight(1f), // Make button size equal
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.primary)
                        ),
                        shape = RoundedCornerShape(50.dp)
                    ) {
                        Text(text = "Simpan", color = Color.White)
                    }
                }
            }
        }
    }
}