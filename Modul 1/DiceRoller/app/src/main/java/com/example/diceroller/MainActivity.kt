package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

/**
 * Aktivitas ini memungkinkan pengguna untuk melempar dadu dan melihat hasilnya
 * Di layar.
 */
class MainActivity : AppCompatActivity() {

    // Metode ini dipanggil ketika Aktivitas dibuat.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Menemukan tombol di tata letak
        val rollButton: Button = findViewById(R.id.button)

        // Atur click listener pada tombol untuk melempar dadu saat pengguna menekan tombol
        rollButton.setOnClickListener { rollDice() }

        // Lakukan lemparan dadu saat aplikasi dimulai
        rollDice()
    }

    /**
     * Lempar dadu dan perbarui layar dengan hasilnya.
     */
    private fun rollDice() {

        // Buat objek Dadu baru dengan 6 sisi lalu dilempar
        val dice = Dice(6)
        val dice2 = Dice(6)
        val diceRoll = dice.roll()
        val diceRoll2 = dice2.roll()

        // Menemukan ImageView dalam tata letak
        val diceImage: ImageView = findViewById(R.id.imageView)
        val diceImage2: ImageView = findViewById(R.id.imageView2)

        // Menentukan ID sumber drawable mana yang akan digunakan berdasarkan lemparan dadu
        // Dadu ke-1
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // Dadu ke-2
        val drawableResource2 = when (diceRoll2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Perbarui ImageView dengan ID sumber drawable yang benar
        diceImage.setImageResource(drawableResource)
        diceImage2.setImageResource(drawableResource2)

        // Memperbarui deskripsi konten
        diceImage.contentDescription = diceRoll.toString()
        diceImage2.contentDescription = diceRoll2.toString()

        // Mengecek nilai dadu dan menampilkan sebuah teks jika kedua dadu bernilai sama
        if (diceRoll == diceRoll2){
            Toast.makeText(this, "Kedua Dadu Nilainya Sama!", Toast.LENGTH_SHORT).show()
        }
    }
}

/**
 * Dadu dengan jumlah sisi yang telah ditentukan.
 */
class Dice(private val numSides: Int) {

    // Lakukan lemparan dadu acak dan kembalikan hasilnya
    fun roll(): Int {
        return (1..numSides).random()
    }
}