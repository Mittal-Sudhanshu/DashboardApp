    package com.example.openinapp.viewModel

    import android.content.Context
    import android.util.Log
    import androidx.lifecycle.ViewModel
    import com.example.openinapp.R
    import com.example.openinapp.data.adapter.AnalyticsAdapter
    import com.example.openinapp.data.adapter.TopLinksAdapter
    import com.example.openinapp.data.models.APIData
    import com.example.openinapp.data.models.AnalData
    import com.example.openinapp.repository.DataRepository
    import com.jjoe64.graphview.GraphView
    import com.jjoe64.graphview.series.DataPoint
    import com.jjoe64.graphview.series.LineGraphSeries
    import retrofit2.Call
    import retrofit2.Callback
    import retrofit2.Response

    class MainViewModel (private val repository: DataRepository):ViewModel(){
        var topLinksAdapter: TopLinksAdapter = TopLinksAdapter()
        var analyticsAdapter:AnalyticsAdapter= AnalyticsAdapter()
        lateinit var data: APIData
        lateinit var series: LineGraphSeries<DataPoint>
        var analData: ArrayList<AnalData> = ArrayList()

        init {
            series = LineGraphSeries()
            makeAPICall()
        }

    //    setTopLinkAdapter(data:Arra)

        fun setAnalData(){
            var a:AnalData= AnalData(text1 = data.todayClicks.toString(), text2 = "Today's Clicks", image = null)
            var b: AnalData= AnalData(text1 = data.topLocation.toString(),text2="Top Location", image = 4)
            var c: AnalData= AnalData(text1 = data.topSource!!, text2 = "Top Source", image = 5)

            analData.add(a)
            analData.add(b)
            analData.add(c)
            analyticsAdapter.setData(analData)
            analyticsAdapter.notifyDataSetChanged()
        }
        fun setTopLinkData(){
            topLinksAdapter.setData(data.data.topLinks)
            topLinksAdapter.notifyDataSetChanged()
        }
        fun setDataPoints(){
            val dataPoints = mutableListOf<DataPoint>()

            data.data.overallUrlChart.entries.forEachIndexed { index, entry ->
                val x = index.toDouble()
                val y = entry.value.toDouble()
                dataPoints.add(DataPoint(x, y))
            }
            series.resetData(dataPoints.toTypedArray())

            // on below line we are setting color for series.
            series.color = R.color.purple_200
        }

        fun makeAPICall(){
            repository.getData().enqueue(object : Callback<APIData?> {
                override fun onResponse(call: Call<APIData?>, response: Response<APIData?>) {
                    if(response.isSuccessful){
                        data=response.body()!!
                        Log.d("data",data.toString())

                        setAnalData()
                        setTopLinkData()
                        setDataPoints()
                    }
                }

                override fun onFailure(call: Call<APIData?>, t: Throwable) {

                }
            })
        }

    }