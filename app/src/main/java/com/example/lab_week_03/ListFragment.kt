package com.example.lab_week_03

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        // List of coffee item views
        val coffeeList = listOf(
            view.findViewById<View>(R.id.affogato),
            view.findViewById<View>(R.id.americano),
            view.findViewById<View>(R.id.latte),
            view.findViewById<View>(R.id.espresso),
            view.findViewById<View>(R.id.cappuccino)
        )

        // Set click listener for each coffee item
        coffeeList.forEach { coffee ->
            coffee.setOnClickListener {
                val bundle = Bundle().apply { putInt(COFFEE_ID, coffee.id) }
                it.findNavController().navigate(R.id.coffee_id_action, bundle)
            }
        }
    }

    companion object {
        const val COFFEE_ID = "COFFEE_ID"
    }
}
