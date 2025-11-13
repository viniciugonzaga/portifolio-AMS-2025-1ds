package com.example.app_nota

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {

    // --- Data model ---
    data class User(
        val id: Long? = null,
        val nome: String,
        val sobrenome: String,
        val email: String,
        val senha: String
    )

    // --- Banco de dados SQLite ---
    class DBHelper(context: Context) :
        SQLiteOpenHelper(context, "app.db", null, 2) { // versão 2 p/ recriar tabela

        override fun onCreate(db: SQLiteDatabase) {
            db.execSQL(
                """
                CREATE TABLE users(
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    nome TEXT NOT NULL,
                    sobrenome TEXT NOT NULL,
                    email TEXT NOT NULL,
                    senha TEXT NOT NULL
                )
                """.trimIndent()
            )
        }

        override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
            db.execSQL("DROP TABLE IF EXISTS users")
            onCreate(db)
        }

        fun insertUser(user: User): Long {
            val cv = ContentValues().apply {
                put("nome", user.nome)
                put("sobrenome", user.sobrenome)
                put("email", user.email)
                put("senha", user.senha)
            }
            return writableDatabase.insert("users", null, cv)
        }

        fun updateUser(user: User): Int {
            requireNotNull(user.id) { "ID não pode ser nulo para update" }
            val cv = ContentValues().apply {
                put("nome", user.nome)
                put("sobrenome", user.sobrenome)
                put("email", user.email)
                put("senha", user.senha)
            }
            return writableDatabase.update(
                "users",
                cv,
                "id=?",
                arrayOf(user.id.toString())
            )
        }

        fun deleteUser(id: Long): Int {
            return writableDatabase.delete(
                "users",
                "id=?",
                arrayOf(id.toString())
            )
        }

        fun getAllUsers(): List<User> {
            val list = mutableListOf<User>()
            val c: Cursor = readableDatabase.rawQuery(
                "SELECT id, nome, sobrenome, email, senha FROM users ORDER BY id DESC",
                null
            )
            c.use { cur ->
                val idIdx = cur.getColumnIndexOrThrow("id")
                val nomeIdx = cur.getColumnIndexOrThrow("nome")
                val sobrenomeIdx = cur.getColumnIndexOrThrow("sobrenome")
                val emailIdx = cur.getColumnIndexOrThrow("email")
                val senhaIdx = cur.getColumnIndexOrThrow("senha")
                while (cur.moveToNext()) {
                    list.add(
                        User(
                            id = cur.getLong(idIdx),
                            nome = cur.getString(nomeIdx),
                            sobrenome = cur.getString(sobrenomeIdx),
                            email = cur.getString(emailIdx),
                            senha = cur.getString(senhaIdx)
                        )
                    )
                }
            }
            return list
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = DBHelper(this)

        setContent {
            MaterialTheme(
                colorScheme = lightColorScheme(
                    primary = Color(0xFF90CAF9),      // azul claro
                    background = Color(0xFF121212),   // preto
                    surface = Color(0xFF1E1E1E),      // cinza escuro
                    onPrimary = Color.Black,
                    onBackground = Color.White,
                    onSurface = Color.White
                )
            ) {
                Surface(Modifier.fillMaxSize()) {
                    UserScreen(dbHelper = db)
                }
            }
        }
    }

    // --- UI Compose + CRUD ---
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun UserScreen(dbHelper: DBHelper) {
        var users by remember { mutableStateOf(dbHelper.getAllUsers()) }

        // Estados dos campos
        var nome by remember { mutableStateOf(TextFieldValue("")) }
        var sobrenome by remember { mutableStateOf(TextFieldValue("")) }
        var email by remember { mutableStateOf(TextFieldValue("")) }
        var senha by remember { mutableStateOf(TextFieldValue("")) }

        var editingId by remember { mutableStateOf<Long?>(null) }

        fun clearFields() {
            nome = TextFieldValue("")
            sobrenome = TextFieldValue("")
            email = TextFieldValue("")
            senha = TextFieldValue("")
            editingId = null
        }

        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(if (editingId == null) "Cadastro de Usuários" else "Editando #$editingId")
                    }
                )
            }
        ) { padding ->
            Column(
                Modifier
                    .padding(padding)
                    .padding(16.dp)
                    .fillMaxSize()
            ) {
                OutlinedTextField(
                    value = nome,
                    onValueChange = { nome = it },
                    label = { Text("Nome") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(8.dp))
                OutlinedTextField(
                    value = sobrenome,
                    onValueChange = { sobrenome = it },
                    label = { Text("Sobrenome") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(8.dp))
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(8.dp))
                OutlinedTextField(
                    value = senha,
                    onValueChange = { senha = it },
                    label = { Text("Senha") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(12.dp))

                Row {
                    Button(
                        onClick = {
                            val n = nome.text.trim()
                            val s = sobrenome.text.trim()
                            val e = email.text.trim()
                            val se = senha.text.trim()
                            if (n.isEmpty() || s.isEmpty() || e.isEmpty() || se.isEmpty()) return@Button

                            if (editingId == null) {
                                dbHelper.insertUser(User(nome = n, sobrenome = s, email = e, senha = se))
                            } else {
                                dbHelper.updateUser(
                                    User(id = editingId, nome = n, sobrenome = s, email = e, senha = se)
                                )
                            }
                            users = dbHelper.getAllUsers()
                            clearFields()
                        }
                    ) {
                        Text(if (editingId == null) "Salvar" else "Atualizar")
                    }
                    Spacer(Modifier.width(8.dp))
                    OutlinedButton(onClick = { clearFields() }) {
                        Text("Limpar")
                    }
                }

                Spacer(Modifier.height(16.dp))
                HorizontalDivider()
                Spacer(Modifier.height(8.dp))

                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(bottom = 80.dp)
                ) {
                    items(users, key = { it.id ?: -1 }) { user ->
                        UserItem(
                            user = user,
                            onClick = {
                                editingId = user.id
                                nome = TextFieldValue(user.nome)
                                sobrenome = TextFieldValue(user.sobrenome)
                                email = TextFieldValue(user.email)
                                senha = TextFieldValue(user.senha)
                            },
                            onDelete = { id ->
                                dbHelper.deleteUser(id)
                                users = dbHelper.getAllUsers()
                                if (editingId == id) clearFields()
                            }
                        )
                        Divider()
                    }
                }
            }
        }
    }

    @Composable
    private fun UserItem(
        user: User,
        onClick: () -> Unit,
        onDelete: (Long) -> Unit
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .clickable { onClick() }
        ) {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(
                    text = "${user.nome} ${user.sobrenome}",
                    style = MaterialTheme.typography.titleMedium
                )
                if (user.id != null) {
                    TextButton(onClick = { onDelete(user.id) }) {
                        Text("Excluir")
                    }
                }
            }
            Spacer(Modifier.height(4.dp))
            Text(text = "Email: ${user.email}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Senha: ${user.senha}", style = MaterialTheme.typography.bodySmall)
        }
    }
}
