package com.kartik.thebundle.onboarding

import android.support.v7.app.AppCompatActivity

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.TextView

import com.kartik.thebundle.R
import com.viewpagerindicator.CirclePageIndicator

class OnBoardingActivity : AppCompatActivity() {

    private var mPagerAdapter: PagerAdapter? = null
    private var mViewPager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.on_boarding)

        mPagerAdapter = PagerAdapter(supportFragmentManager)
        mViewPager = findViewById<View>(R.id.container) as ViewPager
        mViewPager!!.adapter = mPagerAdapter
        (findViewById<View>(R.id.indicator) as CirclePageIndicator).setViewPager(mViewPager)
    }


    class FragmentHolder : Fragment() {

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                  savedInstanceState: Bundle?): View? {
            val rootView = inflater.inflate(R.layout.fragment_on_boarding, container, false)
            val textView = rootView.findViewById<View>(R.id.section_label) as TextView
            textView.text = getString(R.string.section_format, arguments!!.getInt(ARG_SECTION_NUMBER))
            return rootView
        }

        companion object {
            private val ARG_SECTION_NUMBER = "section_number"

            /**
             * Returns a new instance of this fragment for the given section
             * number.
             */
            fun newInstance(sectionNumber: Int): FragmentHolder {
                val fragment = FragmentHolder()
                val args = Bundle()
                args.putInt(ARG_SECTION_NUMBER, sectionNumber)
                fragment.arguments = args
                return fragment
            }
        }
    }

    /**
     * A [FragmentPagerAdapter] that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    inner class PagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            return FragmentHolder.newInstance(position + 1)
        }

        override fun getCount(): Int {
            // Show 3 total pages.
            return 3
        }
    }
}
