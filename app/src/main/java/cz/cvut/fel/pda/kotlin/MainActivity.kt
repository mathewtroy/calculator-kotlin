package cz.cvut.fel.pda.kotlin

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val btnAdd: Button by lazy { findViewById(R.id.btn_add) }
    private val btnSubtraction: Button by lazy { findViewById(R.id.btn_subtraction) }
    private val btnMultiplication: Button by lazy { findViewById(R.id.btn_multiplication) }
    private val btnDivision: Button by lazy { findViewById(R.id.btn_division) }
    private val enterFirstNumber: EditText by lazy { findViewById(R.id.enter_first_number) }
    private val enterSecondNumber: EditText by lazy { findViewById(R.id.enter_second_number) }
    private val resultTv: TextView by lazy { findViewById(R.id.result_tv) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val operationClickListener = OperationClickListener(enterFirstNumber, enterSecondNumber, resultTv)
        btnAdd.setOnClickListener(operationClickListener)
        btnSubtraction.setOnClickListener(operationClickListener)
        btnMultiplication.setOnClickListener(operationClickListener)
        btnDivision.setOnClickListener(operationClickListener)
    }

}