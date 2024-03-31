package cz.cvut.fel.pda.kotlin

import android.annotation.SuppressLint
import android.view.View
import android.widget.EditText
import android.widget.TextView

class OperationClickListener(
    private val enterFirstNumber: EditText,
    private val enterSecondNumber: EditText,
    private val resultTv: TextView
) : View.OnClickListener {

    companion object {
        private const val DIVIDE_BY_ZERO_ERROR = "Cannot divide by zero"
        private const val VALID_NUMBERS_PROMPT = "Please enter valid numbers"
        private const val RESULT_PREFIX = "Result is "
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(v: View?) {
        try {
            val a = enterFirstNumber.text.toString().toDouble()
            val b = enterSecondNumber.text.toString().toDouble()
            val result = when (v?.id) {
                R.id.btn_add -> a + b
                R.id.btn_subtraction -> a - b
                R.id.btn_multiplication -> a * b
                R.id.btn_division -> {
                    if (b == 0.0) {
                        resultTv.text = DIVIDE_BY_ZERO_ERROR
                        return
                    } else {
                        a / b
                    }
                }
                else -> null
            }
            result?.let { resultTv.text = RESULT_PREFIX + it }
        } catch (e: NumberFormatException) {
            resultTv.text = VALID_NUMBERS_PROMPT
        }
    }
}
