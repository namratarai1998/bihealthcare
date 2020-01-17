package com.example.healthcare;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.Objects;

public class PatientVisualization extends AppCompatActivity implements View.OnClickListener {
    private Toolbar toolbar;
    private WebView webView;
    private ProgressBar progressBar;
    private SwipeRefreshLayout refreshWebView;

    String url = "https://public.tableau.com/views/GameAddictionByAgeLevelPart1/Dashboard1?:display_count=y&:origin=viz_share_link";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_visualization);
        toolbar = findViewById(R.id.toolbar);
        webView = findViewById(R.id.webView);
        progressBar =  findViewById(R.id.progressBar);
        refreshWebView =  findViewById(R.id.webViewRefresh);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Patient Satisfaction");
        getSupportActionBar().setSubtitle(url);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                finishAfterTransition();
            }
        });
        initWebView();
        webView.loadUrl(url);
        setDesktopMode(webView,true);
        refreshWebView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshWebView.setRefreshing(true);
                webView.reload();
                refreshWebView.setRefreshing(false);
            }
        });
    }
    public void setDesktopMode(WebView webView,boolean enabled) {
        String newUserAgent = webView.getSettings().getUserAgentString();
        if (enabled) {
            try {
                String ua = webView.getSettings().getUserAgentString();
                String androidOSString = webView.getSettings().getUserAgentString().substring(ua.indexOf("("), ua.indexOf(")") + 1);
                newUserAgent = webView.getSettings().getUserAgentString().replace(androidOSString, "(X11; Linux x86_64)");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            newUserAgent = null;
        }

        webView.getSettings().setUserAgentString(newUserAgent);
        webView.getSettings().setUseWideViewPort(enabled);
        webView.getSettings().setLoadWithOverviewMode(enabled);
        webView.reload();
    }
    @SuppressLint("SetJavaScriptEnabled")
    private void initWebView() {
//        String newUA= "Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.9.0.4) Gecko/20100101 Firefox/4.0";
//        webView.getSettings().setUserAgentString(newUA);

        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.setWebChromeClient(new  PatientVisualization.MyWebChromeClient(this));
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar.setVisibility(View.VISIBLE);
            }
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String newURL) {
                webView.loadUrl(newURL);
                url = newURL;
                Objects.requireNonNull(getSupportActionBar()).setSubtitle(newURL);
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                progressBar.setVisibility(View.GONE);
                Toast.makeText(PatientVisualization.this, "Error Loading " + url, Toast.LENGTH_SHORT).show();
            }
        });
        webView.clearCache(true);   /**Clear Cache**/webView.clearHistory(); /**Clear History**/
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setHorizontalScrollBarEnabled(true); /**Set Horizontal Scrolling Enable**/}

    @Override
    public void onClick(View view) {

    }

    private class MyWebChromeClient extends WebChromeClient {
        Context context;

        public MyWebChromeClient(Context context) {
            super();
            this.context = context;
        }
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
