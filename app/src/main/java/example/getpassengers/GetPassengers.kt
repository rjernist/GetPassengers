// RJ Sam
// Major Program 1 - Get Passengers
// CS 3013
package example.getpassengers

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GetPassengers : AppCompatActivity() {

    private lateinit var firstName: EditText
    private lateinit var lastName: EditText
    private lateinit var phoneNumber: EditText
    private lateinit var addButton: Button
    private lateinit var backButton: Button
    private lateinit var textPut: TextView
    private val passList: MutableList<Passenger> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_passengers)

        firstName = findViewById(R.id.first_name)
        lastName = findViewById(R.id.last_name)
        phoneNumber = findViewById(R.id.phone_number)
        addButton = findViewById(R.id.add_button)
        backButton = findViewById(R.id.back_to_main)
        textPut = findViewById(R.id.accum_list)

        addButton.setOnClickListener {
            val fName = firstName.text.toString().trim()
            val lName = lastName.text.toString().trim()
            val phone = phoneNumber.text.toString().trim()

            if (fName.isEmpty() || lName.isEmpty() || phone.isEmpty()) {
                Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show()
            } else {
                val newPassenger = Passenger(fName, lName, phone)
                passList.add(newPassenger)

                textPut.append("\n${newPassenger.toString()}")

                firstName.text.clear()
                lastName.text.clear()
                phoneNumber.text.clear()
            }
        }

        backButton.setOnClickListener {
            val resultIntent = Intent()
            resultIntent.putExtra("COUNT", passList.size.toString())

            for (i in passList.indices) {
                resultIntent.putExtra("PASS${i + 1}", passList[i].toString())
            }

            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}