package com.example.category

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.category.di.CategoriesModule
import com.example.category.di.DaggerCategoryComponent
import com.example.core.ui.BaseFragment
import com.example.core.ui.coreComponent
import com.example.navigation.NavigationCommand
import javax.inject.Inject

class CategoryListFragment() :
    BaseFragment<CategoryViewModel>() {

    @Inject
    lateinit var factory: CategoryViewModel.Factory

    override val viewModel: CategoryViewModel by viewModels(factoryProducer = { factory })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_category_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DaggerCategoryComponent
            .builder()
            .categoriesModule(CategoriesModule())
            .coreComponent(coreComponent())
            .build()
            .inject(this)


        setupObserver()

        val category = view.findViewById<TextView>(R.id.textView)

        category.setOnClickListener {
            Log.d("test", "tete")
           // Navigation.findNavController(it).navigate(R.id.action_category_to_sources)
            findNavController().navigate(CategoryListFragmentDirections.actionCategoryToSources())
        }

    }

    private fun setupObserver() {
        viewModel.category.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            Log.d("category", it.toString())
        })
    }
}