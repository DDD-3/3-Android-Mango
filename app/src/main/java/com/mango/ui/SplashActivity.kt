package com.mango.ui

import android.content.Intent
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.mango.R
import com.mango.base.BaseActivity
import com.mango.databinding.ActivitySplashBinding
import com.mango.ui.main.MainActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : BaseActivity<ActivitySplashBinding>(R.layout.activity_splash) {

    override fun initView() {
        lifecycleScope.launch {
            Glide.with(this@SplashActivity)
                .asGif()
                .load(R.drawable.pengpong)
                .override(800)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .into(binding.ivSplash)
            delay(3500)
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
        }
    }
}