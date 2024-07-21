@file:Suppress("MemberVisibilityCanBePrivate", "ReplaceJavaStaticMethodWithKotlinAnalog",
    "DEPRECATION"
)

package com.example.calculatoractivity

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.exp
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    lateinit var tvResult: TextView
    lateinit var tvFormula: TextView
    lateinit var ac: Button
    lateinit var bckspc: Button
    lateinit var brackets: Button
    lateinit var brackets2: Button
    lateinit var divide: Button
    lateinit var sin: Button
    lateinit var cos: Button
    lateinit var tan: Button
    lateinit var log: Button
    lateinit var ln: Button
    lateinit var fact: Button
    lateinit var square: Button
    lateinit var pi: Button
    lateinit var sqrt: Button
    lateinit var inv: Button
    lateinit var neuf: Button
    lateinit var huit:Button
    lateinit var sept: Button
    lateinit var sois: Button
    lateinit var cinq: Button
    lateinit var quatre: Button
    lateinit var trois: Button
    lateinit var deaux: Button
    lateinit var un: Button
    lateinit var zero: Button
    lateinit var decimal:Button
    lateinit var module: Button
    lateinit var equals: Button
    lateinit var multiply:Button
    lateinit var add:Button
    lateinit var minus:Button

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvResult = findViewById(R.id.tvResult)
        tvFormula = findViewById(R.id.tvFormula)
        ac = findViewById(R.id.ac)
        bckspc = findViewById(R.id.bckspc)
        brackets = findViewById(R.id.brackets)
        brackets2 = findViewById(R.id.brackets2)
        sin = findViewById(R.id.sin)
        cos  = findViewById(R.id.cos)
        tan = findViewById(R.id.tan)
        log = findViewById(R.id.log)
        ln = findViewById(R.id.ln)
        fact = findViewById(R.id.fact)
        square = findViewById(R.id.square)
        sqrt = findViewById(R.id.sqrt)
        inv = findViewById(R.id.inv)
        pi = findViewById(R.id.pi)
        neuf = findViewById(R.id.neuf)
        huit = findViewById(R.id.huit)
        sept = findViewById(R.id.sept)
        sois = findViewById(R.id.sois)
        cinq = findViewById(R.id.cinq)
        quatre = findViewById(R.id.quatre)
        trois = findViewById(R.id.trois)
        deaux = findViewById(R.id.deaux)
        un = findViewById(R.id.un)
        zero = findViewById(R.id.zero)
        module = findViewById(R.id.module)
        divide = findViewById(R.id.divide)
        multiply = findViewById(R.id.multiply)
        add = findViewById(R.id.add)
        minus = findViewById(R.id.minus)
        equals = findViewById(R.id.equals)
        decimal = findViewById(R.id.decimal)

        zero.setOnClickListener {
            tvFormula.text = (tvFormula.text.toString() + "0")
        }
        un.setOnClickListener {
            tvFormula.text = (tvFormula.text.toString() + "1")
        }
        deaux.setOnClickListener {
            tvFormula.text = (tvFormula.text.toString() + "2")
        }
        trois.setOnClickListener {
            tvFormula.text = (tvFormula.text.toString() + "3")
        }
        quatre.setOnClickListener {
            tvFormula.text = (tvFormula.text.toString() + "4")
        }
        cinq.setOnClickListener {
            tvFormula.text = (tvFormula.text.toString() + "5")
        }
        sois.setOnClickListener {
            tvFormula.text = (tvFormula.text.toString() + "6")
        }
        sept.setOnClickListener {
            tvFormula.text = (tvFormula.text.toString() + "7")
        }
        huit.setOnClickListener {
            tvFormula.text = (tvFormula.text.toString() + "8")
        }
        neuf.setOnClickListener {
            tvFormula.text = (tvFormula.text.toString() + "9")
        }
        brackets.setOnClickListener {
            tvFormula.text = (tvFormula.text.toString() + "(")
        }
        brackets2.setOnClickListener {
            tvFormula.text = (tvFormula.text.toString() + ")")
        }
        module.setOnClickListener {
            tvFormula.text = (tvFormula.text.toString() + "%")
        }
        sin.setOnClickListener {
            tvFormula.text = (tvFormula.text.toString() + "sin ")
        }
        cos.setOnClickListener {
            tvFormula.text = (tvFormula.text.toString() + "cos ")
        }
        tan.setOnClickListener {
            tvFormula.text = (tvFormula.text.toString() + "tan ")
        }
        ln.setOnClickListener {
            tvFormula.text = (tvFormula.text.toString() + "ln ")
        }
        inv.setOnClickListener {
            tvFormula.text = (tvFormula.text.toString() + "^" + "(-1)")
        }
        add.setOnClickListener {
            tvFormula.text = (tvFormula.text.toString() + "+")
        }
        divide.setOnClickListener {
            tvFormula.text = (tvFormula.text.toString() + "÷")
        }
        log.setOnClickListener {
            tvFormula.text = (tvFormula.text.toString() + "log")
        }
        pi.setOnClickListener {
            tvFormula.text = (tvFormula.text.toString() + "3.142")
            tvResult.text = (pi.text.toString())
        }
        decimal.setOnClickListener {
            tvFormula.text = (tvFormula.text.toString() + ".")
        }
        minus.setOnClickListener {
            val str: String = tvFormula.text.toString()
            if(!str.get(index = str.length - 1).equals("-")){
                tvFormula.text = (tvFormula.text.toString() + "-")
            }
        }
        multiply.setOnClickListener {
            val str:String = tvFormula.text.toString()
            if(!str.get(index = str.length - 1).equals("*")){
                tvFormula.text = (tvFormula.text.toString() + "x")
            }
        }
        sqrt.setOnClickListener {
            if(tvFormula.text.toString().isEmpty()){
                Toast.makeText(this, "Please enter a valid number..", Toast.LENGTH_SHORT).show()
            }else{
                val str:String = tvFormula.text.toString()

                val i = Math.sqrt(str.toDouble())

                val result = i.toString()
                tvFormula.text = result
            }
        }
        equals.setOnClickListener {
            val str: String = tvFormula.text.toString()

            val result: Double = evaluate(str)

            val a = result.toString()
            tvFormula.setText(a)
            tvResult.text = str
        }
        bckspc.setOnClickListener {
            var str: String = tvFormula.text.toString()
            if(str != ""){
                str = str.substring(0, str.length - 1)
                tvFormula.text = str
            }
        }
        ac.setOnClickListener {
            tvFormula.text = ("")
            tvResult.text = ""
        }
        module.setOnClickListener {
            if(tvFormula.text.toString().isEmpty()){
                Toast.makeText(this, "Please enter a valid number..", Toast.LENGTH_SHORT).show()
            }else{
                val n: Double = tvFormula.getText().toString().toDouble()

                val percent = n/100

                tvFormula.text = percent.toString()
                tvResult.text = "$n%"
            }

        }
        square.setOnClickListener {
            if(tvFormula.text.toString().isEmpty()){
                Toast.makeText(this, "Please enter a valid number..", Toast.LENGTH_SHORT).show()
            }else{
                val n: Double = tvFormula.getText().toString().toDouble()

                val square = n*n

                tvFormula.text = square.toString()
                tvResult.text = "$n²"
            }
        }
        fact.setOnClickListener {
            if(tvFormula.text.toString().isEmpty()){
                Toast.makeText(this, "Please enter a valid number..", Toast.LENGTH_SHORT).show()
            }else{
                val m: Int = tvFormula.text.toString().toInt()
                val fact: Int = factorial(m)
                tvFormula.setText(fact.toString())
                tvResult.text = "$m!"
            }
        }
    }

    fun factorial(m: Int): Int {
        return if(m == 1 || m == 0) 1 else m * factorial(m - 1)
    }

    fun evaluate(str: String): Double {
        return object: Any(){
            var position = -1
            var ch = 0

            fun nextChar(){
                ch = if(++position < str.length) str[position].toInt() else -1
            }
            fun eat(charToEat:Int):Boolean{
                while(ch == ' '.toInt()) nextChar()
                if(ch == charToEat){
                    nextChar()
                    return true
                }
                return false
            }
            fun parse():Double{
                nextChar()
                val w = parseExpression()
                if(position < str.length) throw RuntimeException("Unexpected: " + ch.toChar())
                return  w
            }
            fun parseExpression(): Double{
                var w = parseTerm()
                while (true){
                    if(eat('+'.toInt())) w += parseTerm()
                    else if (eat('-'.toInt())) w -= parseTerm()
                    else return w
                }
            }
            fun parseTerm():Double{
                var w = parseFactor()
                while(true){
                    if(eat('x'.toInt())) w *= parseFactor()
                    else if(eat('÷'.toInt())) w /= parseFactor()
                    else return w
                }
            }

            fun parseFactor():Double{

                if(eat('+'.toInt()))
                    return parseFactor()
                if (eat('-'.toInt()))
                    return -parseFactor()

                var w: Double

                var startPos = position

                if(eat('('.toInt())){
                    w = parseExpression()
                    eat(')'.toInt())
                }else if (ch >= '0'.toInt() && ch<= '9'.toInt() || ch == '.'.toInt()) {
                    while (ch >= '0'.toInt() && ch <= '9'.toInt() || ch == '.'.toInt()) nextChar()

                    w = str.substring(startPos, position).toDouble()
                }else if(ch >= 'a'.toInt() && ch <= 'z'.toInt()){
                    while (ch >= 'a'.toInt() && ch <= 'z'.toInt()) nextChar()
                    val func = str.substring(startPos, position)

                    w = parseFactor()

                    w =
                        if (func == "sqrt") Math.sqrt(w)
                    else if (func == "sin")Math.sin(
                        Math.toRadians(w)
                    )else if(func == "cos")Math.cos(
                        Math.toRadians(w)
                    )else if(func == "tan")
                        Math.tan(Math.toRadians(w))
                    else if(func == "log")
                        Math.log10(w)
                    else if (func == "ln")
                        Math.log(w)
                    else throw RuntimeException(
                        "Unknown function: $func!"
                    )
                }else{
                    throw RuntimeException("Unexpected: " + ch.toChar())
                }
                if(eat('^'.toInt())) w = Math.pow(w, parseFactor())
                return w
            }
        }.parse()
    }
}

