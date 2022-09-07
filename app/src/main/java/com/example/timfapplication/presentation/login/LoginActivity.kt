package com.example.timfapplication.presentation.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import com.example.timfapplication.R
import com.example.timfapplication.databinding.ActivityLoginBinding
import com.example.timfapplication.domain.entity.login.RequestLoginModel
import com.example.timfapplication.presentation.MainActivity
import com.example.timfapplication.presentation.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityLoginBinding>({ ActivityLoginBinding.inflate(it) }) {

    private val vm: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.hide()

        val btnLogin = findViewById<Button>(R.id.btn_login)
        btnLogin.setOnClickListener {
            val id = findViewById<EditText>(R.id.et_id).text.toString()
            val pw = findViewById<EditText>(R.id.et_pw).text.toString()

            when {
                id.isEmpty() -> {
                    toastMsg("아이디를 입력해주세요")
                }
                pw.isEmpty() -> {
                    toastMsg("비밀번호를 입력해주세요")
                }
                else -> {
                    val requestLoginModel = RequestLoginModel(
                        userLoginId = id,
                        userLoginPassword = pw
                    )
                    toastMsg("로그인되었습니다")
                    vm.postLogin(requestLoginModel)
                    startActivity(Intent(this, MainActivity::class.java))
                }
            }
        }
    }

    private fun toastMsg(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}