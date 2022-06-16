package oyuga.dev.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
class MainActivity : AppCompatActivity() {

lateinit var btnAdd: Button

lateinit var btnSubtract: Button

lateinit var btnMultiply: Button

lateinit var btnModulus: Button

lateinit var tvResults: TextView

lateinit var etNumber1: EditText

lateinit var etNumber2: EditText




override fun onCreate(savedInstanceState: Bundle?) {

    super.onCreate(savedInstanceState)

    setContentView(R.layout.activity_main)


    btnAdd = findViewById(R.id.btnAdd)

    btnSubtract = findViewById(R.id.btnSubstract)

    btnMultiply = findViewById(R.id.btnMultiply)

    btnModulus = findViewById(R.id.btnModulus)

    etNumber1 = findViewById(R.id.etFirstNumber)

    etNumber2 = findViewById(R.id.etSecondNumber)

    tvResults = findViewById(R.id.tvResults)



    btnAdd.setOnClickListener {

        val inputs = obtainInput()

        addition(inputs!!.number1, inputs!!.number2)

        //check if the  inputs is null first



    }

    btnSubtract.setOnClickListener {

        val inputs = obtainInput()

        subtraction(inputs!!.number1, inputs!!.number2)



    }

    btnMultiply.setOnClickListener {

        val inputs = obtainInput()

        multiplication(inputs!!.number1, inputs!!.number2)


    }


    btnModulus.setOnClickListener {

        val inputs = obtainInput()

        modulus(inputs!!.number1, inputs!!.number2)


    }

}

data class Input(var number1: Int, var number2: Int)


fun obtainInput(): Input?{

    val number1 = etNumber1.text.toString()

    val number2 = etNumber2.text.toString()


    if (number1.isBlank()) {

        etNumber1.error="Number is required"

        return null

    }

    if (number2.isBlank()) {

        etNumber2.error="Number Decimal is required"

        return null

    }

    return Input(number1.toInt(), number2.toInt())

}

fun addition(number1: Int, number2: Int) {

    val add = number1 + number2

    tvResults.text = add.toString()

}


fun subtraction(number1: Int, number2: Int) {

    val subtract = number1 - number2

    tvResults.text = subtract.toString()

}


fun multiplication(number1: Int, number2: Int) {

    val multiply = number1 * number2

    tvResults.text = multiply.toString()

}


fun modulus(number1: Int, number2: Int) {

    val remainder = number1 % number2

    tvResults.text = remainder.toString()

}


}


