package com.example.core.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.core.databinding.FragmentBaseWebViewBinding


class BaseWebViewFragment : Fragment() {

    private lateinit var binding: FragmentBaseWebViewBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentBaseWebViewBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val webSettings: WebSettings = binding.webview.settings
        webSettings.javaScriptEnabled = true

        val webViewClient = WebViewClientImpl()
        binding.webview.webViewClient = webViewClient

        val url = BaseWebViewFragmentArgs.fromBundle(requireArguments()).url

        binding.webview.loadUrl(url)

    }

    override fun onResume() {
        super.onResume()
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()
    }

    override fun onStop() {
        super.onStop()
        (requireActivity() as AppCompatActivity).supportActionBar?.show()
    }
}

class WebViewClientImpl() : WebViewClient() {

    override fun shouldOverrideUrlLoading(
        webView: WebView,
        url: String
    ): Boolean {

        return true
    }
}