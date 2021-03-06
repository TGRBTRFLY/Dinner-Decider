package adroid.example.dinnerdecider

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    val foodList = arrayListOf("Chinese", "Costa Vida", "Thia", "Pizza", "Mexican")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        decideBtn.setOnClickListener {
            val random = Random()
            val randomFood = random.nextInt(foodList.count())
            selectedFoodTxt.text = foodList[randomFood]
        }

        addChoiceBtn.setOnClickListener {
            val newChoice = addChoiceTxtField.text.toString()
            foodList.add(newChoice)
            addChoiceTxtField.text.clear()
            println(foodList)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
