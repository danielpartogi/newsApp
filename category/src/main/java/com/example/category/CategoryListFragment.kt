package com.example.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.category.databinding.FragmentCategoryListBinding
import com.example.category.di.CategoriesModule
import com.example.category.di.DaggerCategoryComponent
import com.example.core.ui.BaseFragment
import com.example.core.ui.coreComponent
import javax.inject.Inject


class CategoryListFragment() :
    BaseFragment<CategoryViewModel>() {

    @Inject
    lateinit var factory: CategoryViewModel.Factory

    override val viewModel: CategoryViewModel by viewModels(factoryProducer = { factory })
    private lateinit var binding: FragmentCategoryListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoryListBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DaggerCategoryComponent
            .builder()
            .categoriesModule(CategoriesModule())
            .coreComponent(coreComponent())
            .build()
            .inject(this)

        binding.vm = viewModel
        val adapter = CategoryAdapter(viewModel)
        binding.categoryRv.adapter = adapter

        viewModel.getCategories()


    }

}