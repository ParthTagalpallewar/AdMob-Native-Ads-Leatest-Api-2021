package com.android.nativeads


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.*
import com.google.android.gms.ads.nativead.NativeAd
import com.google.android.gms.ads.nativead.NativeAdOptions


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MobileAds.initialize(this) {


            val adLoader = AdLoader.Builder(this, "ca-app-pub-3940256099942544/2247696110")
                .forNativeAd { ad: NativeAd ->
                    val styles = NativeTemplateStyle.Builder().build()

                    val template = findViewById<TemplateView>(R.id.my_template)
                    template.setStyles(styles)
                    template.setNativeAd(ad)
                }.build()

            adLoader.loadAd(AdRequest.Builder().build())


        }

    }
}