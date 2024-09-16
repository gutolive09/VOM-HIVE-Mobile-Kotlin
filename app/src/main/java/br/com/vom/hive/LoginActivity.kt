package br.com.vom.hive

import android.content.Intent
import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        window.statusBarColor = getColor(R.color.mainOrange)

        val headerText = findViewById<TextView>(R.id.headerText)
        headerText.text = "Login"


        val forgotPassword = findViewById<TextView>(R.id.forgotPassword)
        val forgotSpannableString = SpannableString(forgotPassword.text)
        forgotSpannableString.setSpan(UnderlineSpan(), 0, forgotSpannableString.length, 0)
        forgotPassword.text = forgotSpannableString

        val register = findViewById<TextView>(R.id.register)
        val registerSpannableString = SpannableString(register.text)
        registerSpannableString.setSpan(UnderlineSpan(), 0, registerSpannableString.length, 0)
        register.text = registerSpannableString
        register.setOnClickListener {
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }

        val backArrow = findViewById<ImageView>(R.id.backArrow)
        backArrow.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val loginButton = findViewById<TextView>(R.id.loginButton)
        loginButton.setOnClickListener {
            Toast.makeText(this, "Logado com sucesso!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}