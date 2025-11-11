package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed // Usaremos itemsIndexed para animação de entrada
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.data.Topic
import com.example.myapplication.data.topicsList
import com.example.myapplication.ui.theme.AccentColor
import com.example.myapplication.ui.theme.GradientEnd
import com.example.myapplication.ui.theme.GradientStart
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.theme.PrimaryColor
import com.example.myapplication.ui.theme.TextColorSecondary
import androidx.compose.animation.animateContentSize // ⬅️ CORRIGE O ERRO .animateContentSize()
import androidx.compose.ui.res.stringResource
import androidx.compose.animation.animateContentSize // ⬅️ NOVO!

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Adiciona um Scaffold para uma estrutura de app mais completa (com TopAppBar)
                    Scaffold(
                        topBar = { TopAppBarCourses() }
                    ) { paddingValues ->
                        CoursesGrid(topicsList, Modifier.padding(paddingValues))
                    }
                }
            }
        }
    }
}

// ======================================================================
// 0. TopAppBar Decorada
// ======================================================================
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarCourses(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.headlineSmall,
                color = Color.White
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = PrimaryColor // Usando sua PrimaryColor
        ),
        modifier = modifier
    )
}

// ======================================================================
// 1. O COMPONENTE DA GRADE (LazyVerticalGrid) com Animação de Entrada
// ======================================================================
@Composable
fun CoursesGrid(topics: List<Topic>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        // Usamos itemsIndexed para aplicar um atraso na animação de cada item
        itemsIndexed(topics) { index, topic ->
            // Animação para cada cartão ao aparecer
            AnimatedVisibility(
                visible = true, // Visível por padrão, animando a entrada
                enter = fadeIn(animationSpec = tween(durationMillis = 300, delayMillis = index * 50)) +
                        slideInVertically(animationSpec = tween(durationMillis = 300, delayMillis = index * 50)) { it / 2 }
            ) {
                CourseCard(topic)
            }
        }
    }
}

// ======================================================================
// 2. O COMPONENTE DO ITEM (CourseCard) com Decoração e Animação de Clique
// ======================================================================
@Composable
fun CourseCard(topic: Topic, modifier: Modifier = Modifier) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val scale = if (isPressed) 0.95f else 1f // Animação de escala ao pressionar

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable(
                interactionSource = interactionSource,
                indication = null // Remove o ripple padrão se desejar um efeito customizado
            ) {
                // Ação de clique: ex: navegar para detalhes do curso
                println("Clicou em Detalhes do Curso!")
            }
            // Animação de escala ao pressionar
            // .scale(animateFloatAsState(scale, animationSpec = tween(100)).value),
            .animateContentSize() // Anima o redimensionamento do conteúdo
            .clip(RoundedCornerShape(12.dp)), // Cantos arredondados para o cartão
        elevation = CardDefaults.cardElevation(4.dp), // Sombra mais proeminente
        colors = CardDefaults.cardColors(containerColor = Color.Transparent) // Card transparente para mostrar o gradiente
    ) {
        Column(
            // Gradiente de fundo para o cartão
            modifier = Modifier
                .background(Brush.verticalGradient(listOf(GradientStart, GradientEnd)))
                .fillMaxSize()
        ) {
            // Imagem do Tema (com cantos arredondados na parte superior)
            Image(
                painter = painterResource(id = topic.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp) // Altura um pouco maior
                    .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp)),
                contentScale = ContentScale.Crop
            )

            // Conteúdo textual do cartão (Nome, Ícone, Contagem)
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                // Nome do Tema
                Text(
                    text = stringResource(id = topic.nameRes),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis, // Adiciona "..." se o texto for muito longo
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                // Row para o Ícone e a Contagem
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Ícone customizado (usando Icons.Filled.Info para exemplo ou seu ic_grain)
                    Icon(
                        painter = painterResource(id = R.drawable.ic_grain), // Use seu ícone ic_grain aqui
                        contentDescription = null,
                        tint = TextColorSecondary, // Cor mais discreta para o ícone
                        modifier = Modifier.size(20.dp) // Ícone um pouco maior
                    )

                    // Número de Cursos
                    Text(
                        text = "${topic.courseCount}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = TextColorSecondary,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
        }
    }
}


// ======================================================================
// 3. PREVIEW (Para o Android Studio)
// ======================================================================
@Preview(showBackground = true, widthDp = 360)
@Composable
fun CoursesGridPreview() {
    MyApplicationTheme {
        Scaffold(
            topBar = { TopAppBarCourses() }
        ) { paddingValues ->
            CoursesGrid(topicsList.subList(0, 4), Modifier.padding(paddingValues))
        }
    }
}
