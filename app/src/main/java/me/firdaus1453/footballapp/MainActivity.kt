package me.firdaus1453.footballapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.ctx
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {


    private var items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        val detail = resources.getStringArray(R.array.club_detail)

        items.clear()
        for (i in name.indices) {
            items.add(
                    Item(
                            name[i],
                            image.getResourceId(i, 0),
                            detail[i]
                    )
            )
        }

        image.recycle()

        club_list.layoutManager = LinearLayoutManager(this)
        club_list.adapter = RecyclerViewAdapter(this, items) {
            startActivity<DetailTeamActivity>("name" to it.name, "image" to it.image, "detail" to it.detail)
        }
    }


}
