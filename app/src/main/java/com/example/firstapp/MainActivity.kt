package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//numbers
        tvone.setOnClickListener { appendonexp("1",true)}
        tvtwo.setOnClickListener { appendonexp("2",true)}
        tvthree.setOnClickListener { appendonexp("3",true)}
        tvfour.setOnClickListener { appendonexp("4",true)}
        tvfive.setOnClickListener { appendonexp("5",true)}
        tvsix.setOnClickListener { appendonexp("6",true)}
        tvseven.setOnClickListener { appendonexp("7",true)}
        tveight.setOnClickListener { appendonexp("8",true)}
        tvnine.setOnClickListener { appendonexp("9",true)}
        tvzero.setOnClickListener { appendonexp("0",true)}
        tvdot.setOnClickListener { appendonexp(".",true)}

    //operators

        tvplus.setOnClickListener { appendonexp("+",false)}
        tvminus.setOnClickListener { appendonexp("-",false)}
        tvmul.setOnClickListener { appendonexp("*",false)}
        tvdiv.setOnClickListener { appendonexp("/",false)}
        tvbrac1.setOnClickListener { appendonexp(")",false)}

        tvbrac2.setOnClickListener { appendonexp("(",false)}

        tvce.setOnClickListener {
            tvexp.text=""
            tvRes.text=""
        }

        tvback.setOnClickListener{
            val string=tvexp.text.toString()
            if(string.isNotEmpty()){
                tvexp.text=string.substring(0,string.length-1)
            }
        }

        tvequal.setOnClickListener{

            try {
                val expr= ExpressionBuilder(tvexp.text.toString()).build()
                val result=expr.evaluate()
                val longres=result.toLong()
                if(result==longres.toDouble()){
                    tvRes.text=longres.toString()
                }else{
                    tvRes.text=longres.toString()
                }
            }catch (e:Exception){

                Log.d("Exception","message :" +e.message)
            }

        }
    }

    fun appendonexp( string: String,canclear:Boolean){
        if(tvRes.text.isNotEmpty()){
        tvexp.text=""
        }

        if(canclear){
            tvRes.text=""
            tvexp.append(string)
        }else{
            tvexp.append(tvRes.text)
            tvexp.append(string)
            tvRes.text=""
        }

    }
}