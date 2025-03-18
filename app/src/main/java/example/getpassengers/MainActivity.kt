// RJ Sam
package example.getpassengers

import android.content.Intent
import android.os.Bundle
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

                // Clear any previous list in the TextView
                listText.text = "RETURNED PASSENGER LIST:"

                // Iterate through the number of passengers and display each one
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