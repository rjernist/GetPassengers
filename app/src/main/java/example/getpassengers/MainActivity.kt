// RJ Sam
// Major Program 1 - Get Passengers
// CS 3013
package example.getpassengers

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var listText: TextView

    private val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == RESULT_OK) {
                val data = result.data
                val count = data?.getStringExtra("COUNT")?.toIntOrNull() ?: 0

                listText.text = "RETURNED PASSENGER LIST:"

                for (i in 1..count) {
                    val passenger = data?.getStringExtra("PASS$i") ?: ""
                    listText.append("\n$passenger")
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listText = findViewById(R.id.show_list)
        val getListButton: Button = findViewById(R.id.get_list_button)

        getListButton.setOnClickListener {
            Log.d("MainActivity", "Button Clicked!")
            val intent = Intent(this, GetPassengers::class.java)
            startForResult.launch(intent)
        }
    }
}

data class Passenger(
    val fName: String,
    val lName: String,
    val phone: String
) {
    override fun toString(): String {
        return "$fName $lName - $phone"
    }
}