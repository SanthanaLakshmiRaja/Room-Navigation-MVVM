package com.example.roomcoromvvmnav.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.roomcoromvvmnav.model.User
import com.example.roomcoromvvmnav.databinding.CustomRowBinding

class ListAdapter:RecyclerView.Adapter<ListAdapter.MyviewHolder> (){

    private var userList :List<User> = ArrayList()
    lateinit var binding: CustomRowBinding
    private lateinit var onClickMaterialCardView: OnClickMaterialCardView
   inner class MyviewHolder(itemview: CustomRowBinding) :RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
       binding=CustomRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyviewHolder(binding)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {

        holder.itemView.apply {

            binding.apply{
                val currentItem=userList[position]
                idTextView.text=currentItem.id.toString()
                firstnameTxt.text=userList[position].firstname
                lastnameTxt.text=currentItem.lastname
                ageTxt.text=currentItem.age.toString()

                rowLayout.setOnClickListener {
                    val action= ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
                    findNavController().navigate(action)

                }

                deleteButton.setOnClickListener {

                    onClickMaterialCardView.onClick(currentItem)
                }




           }

        }



    }
    fun setdata(user:List<User>)
    {
        this.userList=user
        notifyDataSetChanged()
    }


    fun setOnClickMaterialCardView(onClickMaterialCardView: OnClickMaterialCardView) {
        this.onClickMaterialCardView = onClickMaterialCardView
    }

    interface OnClickMaterialCardView {
        fun onClick(user: User)
    }

}