package com.example.input

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// untuk menghilangkan error bisa menggunakan Alt + Enter dua kali
@Preview(showBackground = true)
@Composable
fun LatihanuserInput(modifier: Modifier= Modifier) { // nama fungsinya sama dengan nama file yang dibuat
    var nama by remember { mutableStateOf("")} // buat variablenya diluar Widget tapi masaih didalam fungsi
    var email by remember { mutableStateOf("")}
    var noHp by remember { mutableStateOf("")}
    var alamat by remember { mutableStateOf("")}

    var datanama by remember { mutableStateOf("")} // membuat variable untuk menyimpan data
    var dataemail by remember { mutableStateOf("")}
    var datanoHp by remember { mutableStateOf("")}
    var dataalamat by remember { mutableStateOf("")}

    var jenisK by remember { mutableStateOf("") }
    var dataJenisK by remember { mutableStateOf("")}
    val dataJK = listOf("Laki-laki", "Perempuan")


    Column {
        Column (modifier = Modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                "BIODATA",
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp
            )
            Spacer(modifier = Modifier.padding(20.dp))

            TextField(
                value = nama,
                onValueChange = { nama = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                label = { Text("Nama") }, // kalau ada () -> unit, berarti meminta widget
                placeholder = {
                    Text("Masukkan Nama Anda", color = Color.Gray)
                }
            )


            Row {
                dataJK.forEach { selectedJK ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(selected = jenisK == selectedJK,
                            onClick = {
                                jenisK = selectedJK
                            })
                        Text(selectedJK)
                    }
                }
            }

        TextField(
            value = email,
            onValueChange = {email= it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            label = {Text("Email")}, // kalau ada () -> unit, berarti meminta widget
            placeholder = {
                Text("Masukkan Email Anda")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )


        TextField(
            value = noHp,
            onValueChange = {noHp= it},
            modifier = Modifier
                .fillMaxWidth()
                . padding(5.dp),
            label = {Text("No Hp")}, // kalau ada () -> unit, berarti meminta widget
            placeholder = {
                Text("Masukkan Nomor Handphone Anda")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        TextField(
            value = alamat,
            onValueChange = {alamat= it},
            modifier = Modifier
                .fillMaxWidth()
                . padding(5.dp),
            label = {Text("Alamat")}, // kalau ada () -> unit, berarti meminta widget
            placeholder = {
                Text("Masukkan Alamat Anda")
            }
        )
        Button( onClick = {
            datanama = nama
            dataJenisK = jenisK
            dataemail = email
            datanoHp = noHp
            dataalamat = alamat}, modifier = Modifier.padding(vertical = 10.dp))
        {
            Text("Simpan")

        }

        Card(modifier = Modifier.fillMaxWidth().padding(16.dp)){
            Column {

                TampilanData(
                    judul = "Nama",
                    isinya = datanama
                )

                TampilanData(
                    judul = "Jenis Kelamin",
                    isinya = dataJenisK
                )

                TampilanData(
                    judul = "Email",
                    isinya = dataemail
                )

                TampilanData(
                    judul = "Nomor Hadnphone",
                    isinya = datanoHp
                )

                TampilanData(
                    judul = "Alamat",
                    isinya = dataalamat
                )
            }

            }
        }

    }

}


        @Composable
        fun TampilanData(
            judul:String,
            isinya:String
        ){
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween) {
                Text(judul, modifier = Modifier.weight(0.8f)) // yang Weight itu jarak tulisan kesamping kanan
                Text(":", modifier = Modifier.weight(0.2f))
                Text(isinya,modifier = Modifier.weight(2f))



            }

        }
