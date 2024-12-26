package android.mobile.onbroading.screens

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.mobile.onbroading.R
import androidx.viewpager2.widget.ViewPager2
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class SecondScreen : Fragment() {


    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_second_screen, container, false)
//        val viewPager = requireActivity().findViewById<ViewPager2>(R.id.view_pager)
//
//        val indicator = view.findViewById<DotsIndicator>(R.id.indicator)
//        indicator.attachTo(viewPager)
        return view    }

}