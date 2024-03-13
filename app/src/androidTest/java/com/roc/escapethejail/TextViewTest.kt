package com.roc.escapethejail
import android.widget.TextView
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
class TextViewTest {
    @get:Rule
    var activityRule: ActivityScenarioRule<core_activity> = ActivityScenarioRule(core_activity::class.java)
    @Test
    fun mainTitleTest() {
        val expectedText = "ESCAPE THE JAIL"
        val scenario = activityRule.scenario
        scenario.onActivity { activity ->
            val textView = activity.findViewById<TextView>(R.id.core_title)
            val actualText = textView.text.toString()
            assertEquals(expectedText, actualText)
        }
    }
    @Test
    fun hereButtonDescTest() {
        val expectedText = "Not registered yet? Register"
        var scenario: ActivityScenario<login_activity>? = null
        scenario = ActivityScenario.launch(login_activity::class.java)
        scenario.onActivity { activity ->
            val textView = activity.findViewById<TextView>(R.id.login_here_button_description)
            val actualText = textView.text.toString()
            assertEquals(expectedText, actualText)
        }
    }
    @Test
    fun testLoginButton() {
        val expectedText = "LOGIN"
        var scenario: ActivityScenario<login_activity>? = null
        scenario = ActivityScenario.launch(login_activity::class.java)
        scenario.onActivity { activity ->
            val btn = activity.findViewById<TextView>(R.id.login_deploy)
            val actualText = btn.text.toString()
            assertEquals(expectedText, actualText)
        }
    }
    @Test
    fun testRegisterButton() {
        val expectedText = "REGISTER"
        var scenario: ActivityScenario<register_activity>? = null
        scenario = ActivityScenario.launch(register_activity::class.java)
        scenario.onActivity { activity ->
            val btn = activity.findViewById<TextView>(R.id.register_deploy)
            val actualText = btn.text.toString()
            assertEquals(expectedText, actualText)
        }
    }


}
