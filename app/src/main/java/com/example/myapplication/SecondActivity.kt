package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.constance.Constance
import com.example.myapplication.databinding.ActivitySecondBinding


class SecondActivity : AppCompatActivity() {
    lateinit var bind: ActivitySecondBinding

    var signState = "s"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        bind = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(bind.root)

        signState = intent.getStringExtra(Constance.BUTTON_STATE)!!
        Log.d("Applog", "Sign State: $signState")
        if (signState == Constance.SIGN_TWO) {
            bind.editTextTextPersonName111.visibility = View.INVISIBLE
            bind.editTextTextPersonName222.visibility = View.VISIBLE

        }

        if (signState == Constance.SIGN_ONE) {
            bind.editTextTextPersonName222.visibility = View.INVISIBLE
            bind.editTextTextPersonName111.visibility = View.VISIBLE

        }



    }

    fun OnClickDone(view: View) {
        if (signState == Constance.SIGN_TWO) {
            val i = Intent()
            i.putExtra(Constance.BUTTON_STATE, Constance.SIGN_ONE)
            i.putExtra(Constance.SIGN_ONE, bind.editTextTextPersonName222.text.toString())
            i.putExtra(Constance.SIGN_TWO, "Вариант 2 не задействован")
            setResult(RESULT_OK, i)
            finish()


        }
        else if (signState == Constance.SIGN_ONE) {
            val i = Intent()
            i.putExtra(Constance.BUTTON_STATE, Constance.SIGN_ONE)
            i.putExtra(Constance.SIGN_ONE, bind.editTextTextPersonName111.text.toString())
            i.putExtra(Constance.SIGN_TWO, "Вариант 2 не задействован")
            setResult(RESULT_OK, i)
            finish()
        }

    }
}

