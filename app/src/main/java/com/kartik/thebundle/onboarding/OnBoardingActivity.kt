package com.kartik.thebundle.onboarding

import android.content.Intent
import android.support.v7.app.AppCompatActivity

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView

import com.kartik.thebundle.R
import com.kartik.thebundle.login.LoginActivity
import com.viewpagerindicator.CirclePageIndicator

class OnBoardingActivity : AppCompatActivity() {

    private lateinit var mPagerAdapter: PagerAdapter
    private lateinit var mViewPager: ViewPager
    private lateinit var mPagerBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.on_boarding)

        mPagerBtn = findViewById<View>(R.id.pager_btn) as Button
        mPagerAdapter = PagerAdapter(supportFragmentManager)
        mViewPager = findViewById<View>(R.id.container) as ViewPager
        mViewPager.adapter = mPagerAdapter
        (findViewById<View>(R.id.indicator) as CirclePageIndicator).setViewPager(mViewPager)
        mViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                if (position == 2) {
                    mPagerBtn.visibility = View.VISIBLE
                    mPagerBtn.text = resources.getText(R.string.on_boarding_lets_go_btn_txt)
                } else {
                    mPagerBtn.visibility = View.GONE
                }
            }

        })
        PreferenceManager.getDefaultSharedPreferences(this).edit().putBoolean("Is_First_launch", false).apply()
        mPagerBtn.setOnClickListener({navigateToLogin()})
    }

    private fun navigateToLogin() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }


    class FragmentHolder : Fragment() {

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                  savedInstanceState: Bundle?): View? {
            val rootView = inflater.inflate(R.layout.fragment_on_boarding, container, false)
            val imageView = rootView.findViewById<View>(R.id.on_boarding_image) as ImageView
            val idwithName = "onboarding_screen" + arguments!!.getInt(ARG_SECTION_NUMBER)
            val actualId = resources.getIdentifier(idwithName, "drawable", activity!!.packageName)
            imageView.setImageDrawable(resources.getDrawable(actualId, null))
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
