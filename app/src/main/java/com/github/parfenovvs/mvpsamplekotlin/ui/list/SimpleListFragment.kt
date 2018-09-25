package com.github.parfenovvs.mvpsamplekotlin.ui.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.parfenovvs.mvpsamplekotlin.R
import com.github.parfenovvs.mvpsamplekotlin.entity.User
import com.github.parfenovvs.mvpsamplekotlin.ui.base.BaseFragment
import com.github.parfenovvs.mvpsamplekotlin.ui.details.SimpleDetailsFragment
import com.github.parfenovvs.mvpsamplekotlin.ui.list.SimpleListFragment.SimpleListAdapter.VH
import kotlinx.android.synthetic.main.fragment_simple_list.recyclerView
import kotlinx.android.synthetic.main.item_simple.view.emailTextView
import kotlinx.android.synthetic.main.item_simple.view.nameTextView

class SimpleListFragment : BaseFragment<SimpleListView, SimpleListPresenter>(), SimpleListView {

  override fun layoutId(): Int {
    return R.layout.fragment_simple_list
  }

  override fun providePresenter(): SimpleListPresenter {
    return SimpleListPresenter()
  }

  override fun showData(items: List<User>) {
    val adapter = SimpleListAdapter(items)
    recyclerView.adapter = adapter
  }

  override fun showDetails() {
    fragmentManager?.beginTransaction()
        ?.replace(R.id.container, SimpleDetailsFragment())
        ?.addToBackStack(null)
        ?.commitAllowingStateLoss()
  }

  inner class SimpleListAdapter(private val items: List<User>) : RecyclerView.Adapter<VH>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): VH {
      return VH(LayoutInflater.from(parent.context).inflate(R.layout.item_simple, parent, false))
    }

    override fun getItemCount(): Int {
      return items.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
      holder.bindTo(items[position])
    }

    inner class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
      fun bindTo(user: User) {
        itemView.nameTextView.text = user.name
        itemView.emailTextView.text = user.email
        itemView.setOnClickListener { presenter?.onItemClick(user) }
      }
    }

  }

}