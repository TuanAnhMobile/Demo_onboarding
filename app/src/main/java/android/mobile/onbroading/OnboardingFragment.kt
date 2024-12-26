package android.mobile.onbroading

import android.annotation.SuppressLint
import android.content.Intent
import android.mobile.onbroading.screens.AdapterViewPager
import android.mobile.onbroading.screens.FirstScreen
import android.mobile.onbroading.screens.SecondScreen
import android.mobile.onbroading.screens.ThirdScreen
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.viewpager2.widget.ViewPager2
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class OnboardingFragment : Fragment() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_onboarding, container, false)
        val fragmentList = arrayListOf<Fragment>(
            FirstScreen(),
            SecondScreen(),
            ThirdScreen()
        )
        val adapter = AdapterViewPager(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        val viewPager = view.findViewById<ViewPager2>(R.id.view_pager)
        viewPager.adapter = adapter

        val indicator = view.findViewById<DotsIndicator>(R.id.indicator)
        indicator.attachTo(viewPager)

        val next = view.findViewById<AppCompatButton>(R.id.btn_next)
        next.setOnClickListener(){
            val currentItem = viewPager.currentItem

            if (currentItem < fragmentList.size -1){
                viewPager.currentItem = currentItem +1
            } else{
                finishedBoarding()
            }
        }

        return view
    }

    private fun finishedBoarding(){
        val intent = Intent(requireContext(),SurveyActivity::class.java)
        startActivity(intent)
    }

}