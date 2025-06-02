package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.appcadastro.ui.theme.AppcadastroTheme
import com.example.appcadastro.ui.theme.Darkblue
import com.example.appcadastro.ui.theme.Lightblue
import com.example.myapplication.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppcadastroTheme {
                appPreview()
            }
        }
    }
}

@Composable
fun ProdutoItem() {
    var nome by remember { mutableStateOf("") }
    var telefone by remember { mutableStateOf("") }
    var curso by remember { mutableStateOf("") }
    var serie by remember { mutableStateOf("") }
    var observacoes by remember { mutableStateOf("") }

    Scaffold(
        bottomBar = {
            Button(
                onClick = { /* ação do botão */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(text = "Cadastrar")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {

            Box(
                modifier = Modifier
                    .height(180.dp)
                    .fillMaxWidth()
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(Darkblue, Lightblue)
                        )
                    )
            ) {
                Image(
                    painter = painterResource(R.drawable.icone_bagulho), // Verifique se está correto
                    contentDescription = "avatar image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .offset(y = 70.dp)
                        .size(150.dp)
                        .clip(CircleShape)
                        .align(Alignment.Center)
                )
            }

            Spacer(Modifier.height(90.dp))

            Text("Cadastre-se", fontSize = 35.sp, fontWeight = FontWeight.Medium)

            Spacer(Modifier.height(25.dp))


            Text("Nome:", fontSize = 25.sp, fontWeight = FontWeight.W400)
            Spacer(Modifier.height(8.dp))
            TextField(
                value = nome,
                onValueChange = { nome = it },
                label = { Text("Digite seu nome completo") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(16.dp))


            Text("Telefone:", fontSize = 25.sp, fontWeight = FontWeight.W400)
            Spacer(Modifier.height(8.dp))
            TextField(
                value = telefone,
                onValueChange = { telefone = it },
                label = { Text("Digite o telefone") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(16.dp))


            Text("Curso:", fontSize = 25.sp, fontWeight = FontWeight.W400)
            Spacer(Modifier.height(8.dp))
            TextField(
                value = curso,
                onValueChange = { curso = it },
                label = { Text("Digite o nome do curso") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(16.dp))


            Text("Série:", fontSize = 25.sp, fontWeight = FontWeight.W400)
            Spacer(Modifier.height(8.dp))
            TextField(
                value = serie,
                onValueChange = { serie = it },
                label = { Text("Digite sua série") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(16.dp))


            Text("Observações:", fontSize = 25.sp, fontWeight = FontWeight.W400)
            Spacer(Modifier.height(8.dp))
            TextField(
                value = observacoes,
                onValueChange = { observacoes = it },
                label = { Text("Digite observações adicionais") },
                maxLines = 4,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
            )

            Spacer(Modifier.height(100.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun appPreview() {
    AppcadastroTheme {
        ProdutoItem()
    }
}