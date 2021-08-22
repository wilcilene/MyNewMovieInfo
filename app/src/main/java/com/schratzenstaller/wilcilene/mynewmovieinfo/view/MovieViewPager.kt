package com.schratzenstaller.wilcilene.mynewmovieinfo.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

//class MovieViewPager(supportFragmentManager: FragmentManager, lifecycle: Lifecycle) :
// RecyclerView.Adapter<RecyclerView.ViewHolder>() {
class MovieViewPager(fragmentManager: FragmentManager, lifecycle: Lifecycle?) :
    FragmentStateAdapter(fragmentManager!!, lifecycle!!) {
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            1 -> return FavoriteFragment()
            else -> return MovieFragment()
        }
    }

    override fun getItemCount(): Int {
        return 2
    }
}
