package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.constance.Constance
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bind: ActivityMainBinding
    private var launcher: ActivityResultLauncher<Intent>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        launcher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                var buttonState = "b"
                if (result.resultCode == RESULT_OK) {
                    buttonState = result.data?.getStringExtra(Constance.BUTTON_STATE)!!
                    var text1: String = " "
                    //var text2: String = " "
                    if (buttonState == Constance.SIGN_ONE) {
                        text1 = result.data?.getStringExtra(Constance.SIGN_ONE)!!
                        //text2 = result.data?.getStringExtra(Constance.SIGN_TWO)!!
                        bind.tvMessage.text = text1


                    } else if (buttonState == Constance.SIGN_TWO) {
                        text1 = result.data?.getStringExtra(Constance.SIGN_TWO)!!
                        //text2 = result.data?.getStringExtra(Constance.SIGN_ONE)!!
                        bind.tvMessage.text = text1


                    }
                    //val button1 = findViewById<Button>(R.id.button1)
                    //val button2 = findViewById<Button>(R.id.button2)

                    //bind.button1.setOnClickListener(this::OnClick_1)
                    //bind.button2.setOnClickListener(this::OnClick_2)

                    //val message = intent.getStringExtra("key")
                    //bind.tvMessage.text = message
                }
            }


    }
    fun onClick2(view: View) {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra(Constance.BUTTON_STATE, Constance.SIGN_TWO)
        //startActivity(intent)
        launcher?.launch(intent)
    }

    fun onClick1(view: View) {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra(Constance.BUTTON_STATE, Constance.SIGN_ONE)
        //startActivity(intent)
        launcher?.launch(intent)
    }
}