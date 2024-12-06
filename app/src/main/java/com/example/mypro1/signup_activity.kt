package com.example.mypro1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class signup_activity : AppCompatActivity() {

    private lateinit var fullnametext:EditText
    private lateinit var emailid:EditText
    private lateinit var password:EditText
    private lateinit var confirmpassword:EditText
    private lateinit var signupbtn:Button
    private lateinit var auth:FirebaseAuth
    private lateinit var database:FirebaseDatabase



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)


        fullnametext=findViewById(R.id.fullname)
        emailid=findViewById(R.id.emailid)
        password=findViewById(R.id.password)
        confirmpassword=findViewById(R.id.confirmpassword)
        signupbtn=findViewById(R.id.signupbutton)
        auth=FirebaseAuth.getInstance()
        database=FirebaseDatabase.getInstance()




        signupbtn.setOnClickListener {
            regitserUser()
        }


    }

    private fun regitserUser() {
        val fullName = fullnametext.text.toString()
        val email = emailid.text.toString()
        val password = confirmpassword.text.toString()

        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener(this){task->
                if(task.isSuccessful){
                    val Users=auth.currentUser
                    val userId=Users?.uid
                    userId?.let {
                        val userRef=database.reference.child("Users").child(fullName)
                        userRef.child("UID").setValue(it)
                        userRef.child("Full Name").setValue(fullName)
                        userRef.child("Email Id").setValue(email)
                        userRef.child("Password").setValue(password)
                    }

                    Toast.makeText(this,"Registration Successfull",Toast.LENGTH_SHORT).show()
                }
            }
    }


}