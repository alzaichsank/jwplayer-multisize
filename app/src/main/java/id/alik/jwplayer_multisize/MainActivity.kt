package id.alik.jwplayer_multisize

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import androidx.appcompat.app.AppCompatActivity
import com.longtailvideo.jwplayer.events.FullscreenEvent
import com.longtailvideo.jwplayer.events.listeners.VideoPlayerEvents.OnFullscreenListener
import com.longtailvideo.jwplayer.media.playlists.PlaylistItem
import id.alik.jwplayer_multisize.costume.CallbackScreen
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnFullscreenListener {
    private var mCallbackScreen: CallbackScreen? = null
    private var caseVideo = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        jwplayer.addOnFullscreenListener(this)
        // Event Logging
        mCallbackScreen = findViewById(R.id.callback_screen)
        mCallbackScreen!!.registerListeners(jwplayer)
        initAction()
        onPlayerPlay()

    }

    private fun initAction() {
        rg_size.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId){
                R.id.rb_vcm -> {
                    caseVideo = 0
                    Log.d("checked casevideo 0", "onClick: $caseVideo")
                    onPlayerPlay()
                }
                R.id.rb_vyb -> {
                    caseVideo = 1
                    Log.d("checked casevideo 1", "onClick: $caseVideo")
                    onPlayerPlay()
                }
                R.id.rb_h_for_and_three -> {
                    caseVideo = 2
                    Log.d("checked casevideo 2", "onClick: $caseVideo")
                    onPlayerPlay()
                }
                R.id.rb_h_twenty_one_and_nine -> {
                    caseVideo = 3
                    Log.d("checked casevideo 3", "onClick: $caseVideo")
                    onPlayerPlay()
                }
                R.id.rb_h_sixteen_and_nine -> {
                    caseVideo = 4
                    Log.d("checked casevideo 4", "onClick: $caseVideo")
                    onPlayerPlay()
                }
            }
        }

    }

    private fun onPlayerPlay() {
        when (caseVideo) {
            0 -> {
                val playlistItem = PlaylistItem.Builder()
                    .file("https://content.jwplatform.com/videos/DEo3mNCR-KRDSK1u4.mp4")
                    .title("Vertical Video Mobile Camera ")
                    .description("Vertical Video Mobile Camera")
                    .build()
                jwplayer.load(playlistItem)
                jwplayer.play()
            }
            1 -> {
                val playlistItem = PlaylistItem.Builder()
                    .file("https://content.jwplatform.com/videos/DtyUK4cS-KRDSK1u4.mp4")
                    .title("Vertical Youtube Video Clip")
                    .description("Vertical Youtube Video Clip")
                    .build()
                jwplayer.load(playlistItem)
                jwplayer.play()
            }
            2 -> {
                val playlistItem = PlaylistItem.Builder()
                    .file("https://content.jwplatform.com/videos/FhQBYmLN-Yd9Pisb4.mp4")
                    .title("Horizontal ratio 4:3")
                    .description("Horizontal ratio 4:3")
                    .build()
                jwplayer.load(playlistItem)
                jwplayer.play()
            }
            3 -> {
                val playlistItem = PlaylistItem.Builder()
                    .file("https://content.jwplatform.com/videos/aeIsjyFA-Yd9Pisb4.mp4")
                    .title("Horizontal ratio 21:9")
                    .description("Horizontal ratio 21:9")
                    .build()
                jwplayer.load(playlistItem)
                jwplayer.play()
            }
            4 -> {
                val playlistItem = PlaylistItem.Builder()
                    .file("https://content.jwplatform.com/videos/M21Ck8Bi-KRDSK1u4.mp4")
                    .title("Horizontal ratio 16:9")
                    .description("Horizontal ratio 16:9")
                    .build()
                jwplayer.load(playlistItem)
                jwplayer.play()
            }
        }
        Log.d("checked height", "checked height: ${jwplayer?.height}")
        Log.d("checked width", "checked width: ${jwplayer?.width}")
    }

    override fun onStart() {
        super.onStart()
        jwplayer.onStart()
    }

    override fun onResume() {
        super.onResume()
        jwplayer.onResume()
    }

    override fun onPause() {
        super.onPause()
        jwplayer.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        jwplayer.onDestroy()
    }

    override fun onStop() {
        super.onStop()
        jwplayer.onStop()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        jwplayer.setFullscreen(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE, true)
        super.onConfigurationChanged(newConfig)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            if(jwplayer.fullscreen){
                jwplayer.setFullscreen(false,true)
                return false
            }
        }
        return super.onKeyDown(keyCode, event)
    }

    override fun onFullscreen(fullscreenEvent: FullscreenEvent?) {
        Log.d("checked", "onFullscreen: ")
        val actionBar = supportActionBar
        if (actionBar != null) {
            if (fullscreenEvent!!.fullscreen) {
                actionBar.hide()
            } else {
                actionBar.show()
            }
        }
    }

}