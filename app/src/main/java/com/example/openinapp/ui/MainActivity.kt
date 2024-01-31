package com.example.openinapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.openinapp.R
import com.example.openinapp.repository.DataRepository
import com.example.openinapp.viewModel.MainViewModel
import com.example.openinapp.viewModel.MainViewModelFactory
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repo: DataRepository = DataRepository()
        val mainViewModel: MainViewModel = ViewModelProvider(this, MainViewModelFactory())[MainViewModel::class.java]
        val recView1 = findViewById<RecyclerView>(R.id.recView1)
        val recView2 = findViewById<RecyclerView>(R.id.recView2)
        val lineGraphView: GraphView = findViewById(R.id.idGraphView)

        recView1.adapter = mainViewModel.analyticsAdapter
        recView1.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recView2.adapter = mainViewModel.topLinksAdapter
        recView2.layoutManager = LinearLayoutManager(this)

        // Uncomment the following lines to display the line graph
        lineGraphView.addSeries(mainViewModel.series)
        lineGraphView.viewport.isScalable = true
        lineGraphView.viewport.isScrollable = true

        // Adding animation
        lineGraphView.animate()
    }
}