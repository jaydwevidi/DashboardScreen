package com.example.dashboardscreen

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aghajari.zoomhelper.ZoomHelper
import com.example.dashboardscreen.retrofit.datamodels.UserIDToSend
import com.example.dashboardscreen.retrofit.datamodels.ViewFeedResponse
import com.example.dashboardscreen.retrofit.functionality.BuilderInstance
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.lang.Exception


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class homeFragment : Fragment() {

    val TAG = "Jay"
    private lateinit var mView : View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mView=  inflater.inflate(R.layout.fragment_home, container, false)
        //(activity as AppCompatActivity?)!!.supportActionBar!!.title = "Instagram"


        //ZoomHelper.addZoomableView(mView.findViewById<ImageView>(R.id.postImage))


        activity?.title = "Instagram"
        mView.findViewById<BottomNavigationView>(R.id.topNav).setOnItemSelectedListener {
                when(it.itemId){
                    R.id.feed_menu_item -> {
                        Toast.makeText(context, "hello", Toast.LENGTH_SHORT).show()
                        return@setOnItemSelectedListener true
                    }
                R.id.add_feed_menu_item -> {
                    Toast.makeText(context, "hello2", Toast.LENGTH_SHORT).show()
                    return@setOnItemSelectedListener true
                }
                    else -> {
                        Toast.makeText(context, "hello3", Toast.LENGTH_SHORT).show()
                        return@setOnItemSelectedListener true
                    }

                }

        }

        getDList()
        return mView
    }

    private fun setupRecyclerView(context : Context , list : MutableList<tempPostModel> ){
        val rv = mView.findViewById<RecyclerView>(R.id.recyclerViewFeeds)

        rv.apply {
            adapter = FeedAdapter(list ,  context)
            layoutManager = LinearLayoutManager(context , LinearLayoutManager.VERTICAL , false)
        }

    }


    private fun getDList() {
        lifecycleScope.launchWhenCreated {
            val response = try {
                BuilderInstance.builderAPI.addToFeed(
                    UserIDToSend(214)
                )
            }

            catch (e: Exception) {
                Log.d(TAG, "onCreate: login Exception $e  , ${e.message}")
                return@launchWhenCreated
            }

            if(response.isSuccessful){
                val body = response.body()
                Log.d(TAG, "onCreate: response successful ${response.body()}")
                bodyToList(body!!)
            }
            else{
                Log.d(TAG, "onCreate: response unsuccessful")

            }
        }
    }

    fun bodyToList(body : ViewFeedResponse){
        val dList = mutableListOf<tempPostModel>()
        dList.addAll(getList())
        for(i in body.data){
            var image = "https://m.media-amazon.com/images/M/MV5BZWVhYzE0NzgtM2U1Yi00OWM1LWJlZTUtZmNkNWZhM2VkMDczXkEyXkFqcGdeQW1yb3NzZXI@._V1_.jpg"

            try{

                image = i.images[0].image
            }
            catch (e : Exception){}

            val t = tempPostModel(
                i.user_data.full_name ,
                "https://static.wikia.nocookie.net/disney/images/1/13/Gal_Gadot.jpg/revision/latest?cb=20180811005357",
                image ,
                content = i.description
            )
            dList.add(t)
        }
        setupRecyclerView(requireContext() , dList)
    }
    fun getList() : MutableList<tempPostModel>{
        val list = mutableListOf<tempPostModel>()
        list.add(
            tempPostModel(
                "Wonder Diana" ,
                "https://static.wikia.nocookie.net/disney/images/1/13/Gal_Gadot.jpg/revision/latest?cb=20180811005357",
                "https://m.media-amazon.com/images/M/MV5BZWVhYzE0NzgtM2U1Yi00OWM1LWJlZTUtZmNkNWZhM2VkMDczXkEyXkFqcGdeQW1yb3NzZXI@._V1_.jpg",
                "I will Ride for those who cannot Ride for themselves."
            ))

        list.add(
            tempPostModel(
                "Clark Joseph Kent" ,
                "https://i.guim.co.uk/img/media/1af905f750e1dc85eb490a3ec20bf76fb3ac51f7/0_486_2518_1509/master/2518.jpg?width=465&quality=45&auto=format&fit=max&dpr=2&s=1257fe1010592f3e91cf17a80471eefa",
                "https://observer.com/wp-content/uploads/sites/2/2021/05/1_ynJEWSa6ivgFpF0EUP1L_A.jpeg?quality=80&strip",
                "Wishing all of you a very happy Independence Day.\nStay Safe\nStay Super !!"
            ))

        list.add(
            tempPostModel(
                "Bruce Wayne" ,
                "https://pyxis.nymag.com/v1/imgs/abd/266/96205bfceb90512ef4e197a6ceb095a349-robert-pattinson.rvertical.w1200.jpg",
                "https://wegotthiscovered.com/wp-content/uploads/2021/05/the-batman-statue-1.jpg",
                "I'm Batman"
            ))

        list.add(
            tempPostModel(
                "Barry Allen" ,
                "https://media1.popsugar-assets.com/files/thumbor/kRHOD_VRocEvhfhkC5j8WNTQgAY/569x195:2942x2568/fit-in/2048xorig/filters:format_auto-!!-:strip_icc-!!-/2019/12/09/863/n/1922398/fce2eeaf5deea3c3b39189.70140056_/i/Grant-Gustin.jpg",
                "https://wallpapersmug.com/large/da5647/minimal-flash-barry-allen.jpg",
                "Run Barry , Run !!"
            ))


        return list
    }




}