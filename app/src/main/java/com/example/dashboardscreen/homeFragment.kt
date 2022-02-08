package com.example.dashboardscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class homeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_home, container, false)
        //(activity as AppCompatActivity?)!!.supportActionBar!!.title = "Instagram"

        activity?.title = "Instagram"
        view.findViewById<BottomNavigationView>(R.id.topNav).setOnItemSelectedListener {
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

        val rv = view.findViewById<RecyclerView>(R.id.recyclerViewFeeds)

        rv.apply {
            adapter = FeedAdapter(getList() ,  context)
            layoutManager = LinearLayoutManager(context , LinearLayoutManager.VERTICAL , false)
        }
        return view
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
                "https://www.denofgeek.com/wp-content/uploads/2021/05/man-of-steel-henry-cavill-superman.jpg?fit=1920%2C1080",
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