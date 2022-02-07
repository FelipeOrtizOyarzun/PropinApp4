package com.example.propinapp4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.propinapp4.databinding.ActivityMainBinding
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener { calcularPropina() }

//        binding.btnCalcular.setOnClickListener {
//            calcularPropina()
//        }

//        binding.costOfServiceEditText.setOnKeyListener { view, keyCode, _ -> handleKeyEvent(view, keyCode) }
    }

    private fun calcularPropina() {
        // Aca casteamos en lineas distintas por que no es capaz de hacer 2 cast en 1
        val costoString = binding.edtCostoServicio.text.toString()
        val costo = costoString.toDoubleOrNull()
        if(costo == null || costo == 0.0){
            return
        }

        val porcentaje : Double = when (binding.rgCalidad.checkedRadioButtonId) {
            R.id.rb20 -> 0.20
            R.id.rb15 -> 0.15
            else -> 0.10
        }

        var propina : Double = costo * porcentaje
        if (binding.swRedondea.isChecked){
            propina = ceil(propina)
        }
        binding.txtPropina.text = getString(R.string.propina, propina.toString())
    }

//    private fun handleKeyEvent(view: View, keyCode: Int): Boolean {
//        if (keyCode == KeyEvent.KEYCODE_ENTER) {
//            // Hide the keyboard
//            val inputMethodManager =
//                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
//            return true
//        }
//        return false
//    }

}