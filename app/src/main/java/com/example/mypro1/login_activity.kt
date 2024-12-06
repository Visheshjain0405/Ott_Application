package com.example.mypro1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class login_activity : AppCompatActivity() {

    private lateinit var emaild:EditText
    private lateinit var password:EditText
    private lateinit var login:Button
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val signup:TextView=findViewById(R.id.signuptext)

        emaild=findViewById(R.id.emailid)
        password=findViewById(R.id.password)
        login=findViewById(R.id.loginbutton)
        auth=FirebaseAuth.getInstance()
        
        login.setOnClickListener {

            val emailid=emaild.text.toString()
            val password=password.text.toString()

                auth.signInWithEmailAndPassword(emailid,password).addOnCompleteListener(this){task->
                    if(task.isSuccessful){
                        Toast.makeText(this,"USer Login Success",Toast.LENGTH_SHORT).show()
                        val loginpage=Intent(this,home_activity::class.java)
                        startActivity(loginpage)
                    }
                    else{
                        Toast.makeText(this,"Login Failed",Toast.LENGTH_SHORT).show()
                    }

                }



        }

        signup.setOnClickListener {
            val signupintent=Intent(this,signup_activity::class.java)
            startActivity(signupintent)
        }
    }
}