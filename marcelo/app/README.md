# 📚 Aplicativo Courses - Grade Rolável em Jetpack Compose

Este projeto foi desenvolvido como um exercício prático do curso **Noções Básicas do Android no Compose** (Codelab: Adicionar uma lista rolável e criar uma grade). O objetivo é aplicar os conceitos de **Lazy Grids** para exibir uma lista de temas de cursos de forma eficiente e visualmente organizada.

---

## ✨ Funcionalidades Principais

* **Grade Vertical Rolável (`LazyVerticalGrid`):** Exibe todos os temas em uma grade de duas colunas, otimizada para listas grandes.
* **Componentes Reutilizáveis (`CourseCard`):** Cada tema é representado por um cartão modular que combina imagem, nome do tema e a contagem de cursos.
* **Dados Estruturados:** Utilização de uma `data class Topic` para modelar os dados de cada curso (nome, imagem, contagem).
* **Design Moderno:** Utiliza o sistema Material 3 do Compose, com `Card`s e tipografia customizada (se você implementou a seção de decoração).

---

## 🖼️ Preview do Aplicativo

Abaixo está uma captura de tela da compilação bem-sucedida do aplicativo, mostrando a grade de temas funcionando no dispositivo.

[Screenshot do App Courses](intro_app.png)`.

---

## 💻 Componentes-Chave no Kotlin/Compose

O projeto está dividido nos seguintes elementos:

* **`Topic.kt`:** Contém a `data class Topic` e a lista de dados (`topicsList`).
* **`MainActivity.kt`:** Contém a lógica principal e os componentes:
    * `CoursesGrid`: Responsável por configurar e exibir a `LazyVerticalGrid`.
    * `CourseCard`: O componente que desenha o visual de cada item da lista.

---

## ✅ Desafios Superados

Durante o desenvolvimento, foram resolvidos problemas comuns de projetos Compose, incluindo:

1.  **Compatibilidade de Versões:** Resolução de erros no *classpath* do Gradle.
2.  **Referência de Recursos:** Correção de erros como `Unresolved reference: ic_grain` e `stringResource` através da verificação de imports e da localização correta dos arquivos `drawable`.
3.  **Configuração de Layout:** Ajuste fino do `verticalAlignment` dentro do `Row` para garantir a correta disposição vertical do texto e ícone.
