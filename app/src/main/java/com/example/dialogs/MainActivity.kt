package com.example.dialogs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.NumberPicker
import android.widget.Toast
import com.example.dialogs.databinding.ActivityMainBinding
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import java.text.SimpleDateFormat
import java.time.Year
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener, NumberPicker.OnValueChangeListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btn2.setOnClickListener(this)
        binding.btn1.setOnClickListener(this)
        //  number picker
        binding.numberPicker.minValue=0
        binding.numberPicker.maxValue=100

        binding.numberPicker.setOnValueChangedListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn1 -> {
    // Date picker
//MaterialDatePicker.Builder.datePicker().build().show(supportFragmentManager,"DATE PICKER")

                // when component chenge in material date picker to creat object of this way

                val datePickerBuilder = MaterialDatePicker.Builder.datePicker()
                datePickerBuilder.setTitleText("select your dob")

                val datePicker = datePickerBuilder.build()

                datePicker.show(supportFragmentManager, "DATE")
                datePicker.addOnPositiveButtonClickListener {

                    // object of calentder class
//                    val calendar = Calendar.getInstance()
//                    val Day = calendar.get(Calendar.DAY_OF_MONTH)
//                    val month = calendar.get(Calendar.MONTH)
//                    val YEAR = calendar.get(Calendar.YEAR)
//
//
//                    Toast.makeText(this@MainActivity, "$Day/ $month/ $YEAR", Toast.LENGTH_LONG).show()
//

                    // take a date according to user

                    val simpleDateFormat=SimpleDateFormat("dd/MM/YYYY")

                    val selecteddate=simpleDateFormat.format(Date(it))
                    Toast.makeText(this@MainActivity, "You have selected:-$selecteddate", Toast.LENGTH_LONG).show()
//
                }

            }
//   Time picker dialogs  -

            R.id.btn2 ->{
                val timeBuilder=MaterialTimePicker.Builder()
                timeBuilder.setHour(11)
                timeBuilder.setMinute(30)
                timeBuilder.setTimeFormat(TimeFormat.CLOCK_12H)
             val timePicker=   timeBuilder.build()

                //tack a value of time by positev button

                timePicker.addOnPositiveButtonClickListener{

                    Toast.makeText(this@MainActivity,"${timePicker.hour}:${timePicker.minute}",Toast.LENGTH_LONG).show()
                }


                 timePicker.show(supportFragmentManager,"TIME PICKER")

            }

            // number picker

        }
    }

    override fun onValueChange(numPicker: NumberPicker?, previousvalue: Int, nextvalue: Int) {

Toast.makeText(this@MainActivity,"${numPicker?.value}",Toast.LENGTH_LONG).show()
    }
}