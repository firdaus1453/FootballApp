package me.firdaus1453.footballapp

import android.content.Context
import android.graphics.Color
import android.media.Image
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_list.view.*
import me.firdaus1453.footballapp.R.id.name
import me.firdaus1453.footballapp.R.id.txtName
import org.jetbrains.anko.*
import java.util.concurrent.locks.Lock

class DetailTeamActivity : AppCompatActivity() {

    private lateinit var txtName: TextView
    private lateinit var txtDetail: TextView
    private lateinit var imgPhoto: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DetailUI().setContentView(this)

        supportActionBar?.title = "Detail Team"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val act = this
        val layout = LinearLayout(act)
        layout.orientation = LinearLayout.VERTICAL

        val name = intent.getStringExtra("name")
        val image = intent.getIntExtra("image", 0)
        val detail = intent.getStringExtra("detail")

        txtName = find(R.id.txtName)
        imgPhoto = find(R.id.img)
        txtDetail = find(R.id.txtDetail)

        Glide.with(this).load(image).into(imgPhoto)
        txtName.text = name.toString()
        txtDetail.text = detail.toString()

    }

    class DetailUI : AnkoComponent<DetailTeamActivity> {
        override fun createView(ui: AnkoContext<DetailTeamActivity>) = with(ui) {
            linearLayout {
                orientation = LinearLayout.VERTICAL
                imageView {
                    id = R.id.img

                }.lparams(width = matchParent,height = dip(50)) {
                    padding = dip(20)
                    margin = dip(15)
                }

                textView {
                    id = R.id.txtName
                    gravity = Gravity.CENTER
                }

                textView {
                    id = R.id.txtDetail
                    gravity = Gravity.CENTER
                }
            }
        }
    }

}
