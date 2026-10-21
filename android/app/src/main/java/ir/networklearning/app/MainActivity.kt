package ir.networklearning.app

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/**
 * کلاینت WebView برای دانشنامه جامع شبکه.
 * سرور FastAPI باید روی ویندوز/لینوکس در همان شبکه روشن باشد.
 */
class MainActivity : AppCompatActivity() {

    companion object {
        private const val PREFS = "nla_prefs"
        private const val KEY_SERVER = "server_url"
        private const val DEFAULT_SERVER = "http://192.168.1.10:8000"
    }

    private lateinit var webView: WebView
    private lateinit var setupPanel: LinearLayout
    private lateinit var root: FrameLayout

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        root = FrameLayout(this)
        setContentView(root)

        webView = WebView(this).apply {
            setBackgroundColor(Color.parseColor("#F4F1EA"))
            visibility = View.GONE
        }
        setupWebView(webView)

        setupPanel = buildSetupPanel()
        root.addView(setupPanel, FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.MATCH_PARENT,
            FrameLayout.LayoutParams.MATCH_PARENT
        ))
        root.addView(webView, FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.MATCH_PARENT,
            FrameLayout.LayoutParams.MATCH_PARENT
        ))

        ViewCompat.setOnApplyWindowInsetsListener(root) { v, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom)
            insets
        }

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (webView.visibility == View.VISIBLE && webView.canGoBack()) {
                    webView.goBack()
                } else {
                    isEnabled = false
                    onBackPressedDispatcher.onBackPressed()
                }
            }
        })

        val saved = getSharedPreferences(PREFS, Context.MODE_PRIVATE)
            .getString(KEY_SERVER, DEFAULT_SERVER) ?: DEFAULT_SERVER
        if (saved.isNotBlank() && saved != DEFAULT_SERVER) {
            loadServer(saved)
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setupWebView(wv: WebView) {
        val s = wv.settings
        s.javaScriptEnabled = true
        s.domStorageEnabled = true
        s.databaseEnabled = true
        s.loadWithOverviewMode = true
        s.useWideViewPort = true
        s.builtInZoomControls = true
        s.displayZoomControls = false
        s.mixedContentMode = WebSettings.MIXED_CONTENT_COMPATIBILITY_MODE
        s.cacheMode = WebSettings.LOAD_DEFAULT
        wv.webChromeClient = WebChromeClient()
        wv.webViewClient = object : WebViewClient() {
            override fun onReceivedError(
                view: WebView?,
                request: WebResourceRequest?,
                error: WebResourceError?
            ) {
                if (request?.isForMainFrame == true) {
                    runOnUiThread {
                        Toast.makeText(
                            this@MainActivity,
                            getString(R.string.offline_msg),
                            Toast.LENGTH_LONG
                        ).show()
                        webView.visibility = View.GONE
                        setupPanel.visibility = View.VISIBLE
                    }
                }
            }
        }
    }

    private fun buildSetupPanel(): LinearLayout {
        val pad = (24 * resources.displayMetrics.density).toInt()
        val panel = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(pad, pad * 2, pad, pad)
            setBackgroundColor(Color.parseColor("#F4F1EA"))
        }
        val title = TextView(this).apply {
            text = getString(R.string.app_name)
            textSize = 22f
            setTextColor(Color.parseColor("#2C4A3E"))
            textAlignment = View.TEXT_ALIGNMENT_VIEW_END
        }
        val hint = TextView(this).apply {
            text = getString(R.string.server_hint)
            textSize = 14f
            setTextColor(Color.parseColor("#5A5A5A"))
            setPadding(0, pad / 2, 0, pad / 2)
            textAlignment = View.TEXT_ALIGNMENT_VIEW_END
        }
        val input = EditText(this).apply {
            setText(
                getSharedPreferences(PREFS, Context.MODE_PRIVATE)
                    .getString(KEY_SERVER, DEFAULT_SERVER)
            )
            hint = "http://192.168.1.10:8000"
            textAlignment = View.TEXT_ALIGNMENT_VIEW_END
            setSingleLine()
        }
        val btn = Button(this).apply {
            text = getString(R.string.connect)
            setOnClickListener {
                val url = input.text.toString().trim().trimEnd('/')
                if (url.isEmpty()) {
                    Toast.makeText(this@MainActivity, "آدرس را وارد کن", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                getSharedPreferences(PREFS, Context.MODE_PRIVATE)
                    .edit().putString(KEY_SERVER, url).apply()
                loadServer(url)
            }
        }
        panel.addView(title)
        panel.addView(hint)
        panel.addView(input)
        panel.addView(btn)
        return panel
    }

    private fun loadServer(url: String) {
        setupPanel.visibility = View.GONE
        webView.visibility = View.VISIBLE
        webView.loadUrl(url)
    }
}
