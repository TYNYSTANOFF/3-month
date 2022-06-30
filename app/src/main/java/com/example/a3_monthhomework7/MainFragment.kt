package com.example.a3_monthhomework7

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.a3_monthhomework7.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            FragmentMainBinding.inflate(LayoutInflater.from(requireContext()), container, false)
        return binding.root
    }

    @SuppressLint("ShowToast")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = arrayListOf<Animal>()
//        for (i in 1..10){
//            data.add(Animal(name = "Cat", image = R.drawable.ic_ad))
//        }
        data.add(Animal(name = "Собака", image = R.drawable.dog))
        data.add(Animal(name = "Кот", image = R.drawable.cat))
        data.add(Animal(name = "Бык", image = R.drawable.bull))
        data.add(Animal(name = "Орёл", image = R.drawable.eagle))
        data.add(Animal(name = "Горилла", image = R.drawable.gorilla))
        data.add(Animal(name = "Лев", image = R.drawable.lion))
        data.add(Animal(name = "Богомол", image = R.drawable.mantis))
        data.add(Animal(name = "Обезьяна", image = R.drawable.monkey))
        data.add(Animal(name = "Петух", image = R.drawable.rooster))
        data.add(Animal(name = "Акула", image = R.drawable.shark))
        val adapter = AnimalAdapter(data)
        binding.rec.adapter = adapter

        adapter.onLongClick ={ i: Int, s: String ->
            val builder = AlertDialog.Builder(requireContext())
            builder.setTitle("Удалить?")
            builder.setMessage("Тощно уверенсинби дозум? Эркекчеби? ")
            builder.setNegativeButton("Нет",
                DialogInterface.OnClickListener { dialog, which ->
                  dialog.cancel()
                })
            builder.setPositiveButton("Да", DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(requireContext(), "Вы удалили" + data[i], Toast.LENGTH_SHORT).show()
            })
            builder.show()
        }
        }

    }



//    override fun onLongClick(v: View?): Boolean {}
