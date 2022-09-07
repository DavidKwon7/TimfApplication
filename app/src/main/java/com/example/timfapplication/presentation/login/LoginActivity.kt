package com.example.timfapplication.presentation.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.activity.viewModels
import com.example.timfapplication.R
import com.example.timfapplication.databinding.ActivityLoginBinding
import com.example.timfapplication.domain.entity.login.RequestLoginModel
import com.example.timfapplication.presentation.MainActivity
import com.example.timfapplication.presentation.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private val vm: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.hide()
        clickToast()

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

    private fun clickToast() {
        kakaoClick()
        searchIdClick()
        searchPwClick()
        signUpClick()
    }

    private fun signUpClick() {
        val tvSighUp = findViewById<TextView>(R.id.tv_sighUp)
        tvSighUp.setOnClickListener {
            toastMsg("회원가입 버튼을 눌렀습니다")
        }
    }

    private fun searchPwClick() {
        val tvSearchPw = findViewById<TextView>(R.id.tv_searchPw)
        tvSearchPw.setOnClickListener {
            toastMsg("비밀번호 찾기를 눌렀습니다")
        }
    }

    private fun searchIdClick() {
        val tvSearchId = findViewById<TextView>(R.id.tv_searchId)
        tvSearchId.setOnClickListener {
            toastMsg("아이디 찾기를 눌렀습니다")
        }
    }

    private fun kakaoClick() {
        val ivKakaoLogin = findViewById<ImageView>(R.id.iv_kakaoLogin)
        ivKakaoLogin.setOnClickListener {
            toastMsg("카카오로그인 버튼을 눌렀습니다")
        }
    }

    private fun toastMsg(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}