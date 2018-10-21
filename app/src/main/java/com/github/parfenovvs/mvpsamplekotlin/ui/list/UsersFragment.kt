package com.github.parfenovvs.mvpsamplekotlin.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.parfenovvs.mvpsamplekotlin.R
import com.github.parfenovvs.mvpsamplekotlin.di.UsersComponent
import com.github.parfenovvs.mvpsamplekotlin.entity.User
import com.github.parfenovvs.mvpsamplekotlin.ui.base.BaseFragment
import com.github.parfenovvs.mvpsamplekotlin.ui.details.UserDetailsFragment
import com.github.parfenovvs.mvpsamplekotlin.ui.list.UsersFragment.SimpleListAdapter.VH
import kotlinx.android.synthetic.main.fragment_users.recyclerView
import kotlinx.android.synthetic.main.item_user.view.emailTextView
import kotlinx.android.synthetic.main.item_user.view.nameTextView
import timber.log.Timber


class UsersFragment : BaseFragment<UsersView, UsersPresenter>(), UsersView {
  lateinit var component: UsersComponent

  override fun layoutId(): Int {
    return R.layout.fragment_users
  }

  override fun providePresenter(): UsersPresenter {
    return component.presenter()
  }

  override fun showData(items: List<User>) {
    val adapter = SimpleListAdapter(items)
    recyclerView.adapter = adapter
  }

  override fun showDetails(user: User) {
    val fragment = UserDetailsFragment()
    fragment.component = component
    fragmentManager?.beginTransaction()
        ?.replace(R.id.container, fragment)
        ?.addToBackStack(null)
        ?.commitAllowingStateLoss()
  }

  inner class SimpleListAdapter(private val items: List<User>) : RecyclerView.Adapter<VH>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): VH {
      return VH(LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false))
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