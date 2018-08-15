package com.example.kannyf.anjirrapps.activities


import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kannyf.anjirrapps.R
import com.example.kannyf.anjirrapps.adapter.CategoryAdapter
import com.example.kannyf.anjirrapps.model.Category


class CategoryActivity : AppCompatActivity() {

    lateinit var recyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_category)

        recyclerView = findViewById(R.id.categoryRecycler)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        val users = ArrayList<Category>()


        users.add(Category("Komunitas pecinta Binatang", "grup berkumpulnya pecinta hewan grup berkumpulnya pecinta hewangrup berkumpulnya pecinta", R.drawable.retrofit))
        users.add(Category("Aliansi Liverpool Garis Kerad", "Komunitas anti Baper grup berkumpulnya pecinta hewan grup berkumpulnya pecinta hewan grup", R.drawable.kotlin))
        users.add(Category("Komunitas Atheis INDONESIA", "berkumpulnya para atheis grup berkumpulnya pecinta hewan grup berkumpulnya pecinta", R.drawable.firebase))
        users.add(Category("Komunitas Atheis INDONESIA", "berkumpulnya para atheis grup berkumpulnya pecinta hewan grup berkumpulnya pecinta", R.drawable.liverpool))
        users.add(Category("Komunitas Atheis INDONESIA", "berkumpulnya para atheis grup berkumpulnya pecinta hewan grup berkumpulnya pecinta", R.drawable.firebase))
        users.add(Category("Komunitas Atheis INDONESIA", "berkumpulnya para atheis grup berkumpulnya pecinta hewan grup berkumpulnya pecinta ", R.drawable.kotlin))
        users.add(Category("Komunitas Atheis INDONESIA", "berkumpulnya para atheis grup berkumpulnya pecinta hewan grup berkumpulnya pecinta", R.drawable.liverpool))
        users.add(Category("Komunitas Atheis INDONESIA", "berkumpulnya para atheis grup berkumpulnya pecinta hewan grup berkumpulnya pecinta ",R.drawable.retrofit))
        users.add(Category("Komunitas Atheis INDONESIA", "berkumpulnya para atheis grup berkumpulnya pecinta hewan grup berkumpulnya pecinta", R.drawable.retrofit))
        users.add(Category("Komunitas Atheis INDONESIA", "berkumpulnya para atheis grup berkumpulnya pecinta hewan grup berkumpulnya pecinta ", R.drawable.firebase))


        val adapter = CategoryAdapter(users)

        recyclerView.adapter = adapter



    }
}
