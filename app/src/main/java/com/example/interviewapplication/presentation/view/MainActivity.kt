package com.example.interviewapplication.presentation.view

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.interviewapplication.R
import com.example.interviewapplication.domain.convertCurrency
import com.example.interviewapplication.domain.models.CurrencyModel
import com.example.interviewapplication.domain.takeAttitudeByName
import com.example.interviewapplication.domain.takeListOfCutNames
import com.example.interviewapplication.presentation.App
import com.example.interviewapplication.presentation.adapter.CurrencyRecyclerAdapter
import com.example.interviewapplication.presentation.viewmodel.MainViewModel
import javax.inject.Inject

class MainActivity() : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var leftSpinner: Spinner
    private lateinit var rightSpinner: Spinner
    private lateinit var buttonConvert: Button
    private lateinit var rightEditText: EditText
    private lateinit var leftEditText: EditText

    @Inject
    lateinit var viewModel: MainViewModel //todo Dagger не поддерживает внедрение в private-филды
    private lateinit var adapter: CurrencyRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViews()
        resolveDependencies()

        observeLiveData()

        viewModel.loadContent()
    }

    private fun observeLiveData() {
        viewModel.outerLiveData.observe(
            this, {
                if (it.isSuccessful) {
                    adapter.setItems(it.body!!)
                    adapter.notifyDataSetChanged()
                    initSpinners(it.body)
                    initButton(it.body)
                } else {
                    Toast.makeText(this, it.error, Toast.LENGTH_LONG).show()
                }

            }
        )
    }

    private fun resolveDependencies() {
        App.component.inject(this)

        adapter = CurrencyRecyclerAdapter()
        recyclerView.adapter = adapter
    }

    private fun initSpinners(currencyList: List<CurrencyModel>) {
        val spinnerAdapter =
            ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                takeListOfCutNames(currencyList)
            )
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        leftSpinner.adapter = spinnerAdapter
        rightSpinner.adapter = spinnerAdapter

        //Чисто дизайнерская штука, которая реверсит выбранный элемент
        //Сделано для того, чтобы спиннеры были отражены относительно центра
        leftSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                view!!.rotationY = 180F
                view.setPadding(84, 0, 0, 0)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
    }

    private fun findViews() {
        recyclerView = findViewById(R.id.recycler_view)
        leftSpinner = findViewById(R.id.spinner_left)
        rightSpinner = findViewById(R.id.spinner_right)
        buttonConvert = findViewById(R.id.button_convert)
        rightEditText = findViewById(R.id.edit_text_right_currency)
        leftEditText = findViewById(R.id.edit_text_left_currency)
    }

    private fun initButton(currencyList: List<CurrencyModel>) {
        buttonConvert.setOnClickListener {
            val fromCurrencyName: String = leftSpinner.selectedItem.toString()
            val toCurrencyName: String = rightSpinner.selectedItem.toString()
            val attitudeFrom: Double = takeAttitudeByName(currencyList, fromCurrencyName)
            val attitudeTo: Double = takeAttitudeByName(currencyList, toCurrencyName)

            rightEditText.setText(
                convertCurrency(
                    (leftEditText.text).toString().toDouble(),
                    attitudeTo / attitudeFrom
                ).toString().take(9)
            )

        }
    }
}

