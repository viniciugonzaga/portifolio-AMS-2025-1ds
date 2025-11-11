package com.example.myapplication.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.myapplication.R

// A Estrutura de Dados de um Tema
data class Topic(
    @StringRes val nameRes: Int,
    val courseCount: Int,
    @DrawableRes val imageRes: Int
)

// A Lista de Temas
val topicsList = listOf(
    Topic(R.string.architecture, 58, R.drawable.architecture),
    Topic(R.string.crafts, 121, R.drawable.crafts),
    Topic(R.string.business, 78, R.drawable.business),
    Topic(R.string.design, 118, R.drawable.design),
    Topic(R.string.fashion, 92, R.drawable.fashion),
    Topic(R.string.film, 165, R.drawable.film),
    Topic(R.string.gaming, 58, R.drawable.gaming),
    Topic(R.string.photography, 44, R.drawable.photography),
    Topic(R.string.tech, 289, R.drawable.tech)
)