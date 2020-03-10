package com.example.myapplication;
import android.app.Activity;
import android.app.Instrumentation;
import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;

public class Activity3Test {

    @Rule
    public ActivityTestRule<Activity3> activity3Rule = new ActivityTestRule<Activity3>(Activity3.class);
    private Activity3 activity3 = null;
    private Activity4 activity4 = null;
    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(Activity4.class.getName(),null,false);

        @Before
        public void setUp() throws Exception
        {
            activity3 = activity3Rule.getActivity();
        }

        @Test
        public void testActivity()
        {
            View view = activity3.findViewById(R.id.textView6);
            Assert.assertNotNull(view);
            Assert.assertEquals(view,activity3.findViewById(R.id.textView6));
        }

        @Test
        public void testButton()
        {
            Assert.assertNotNull(activity3.findViewById(R.id.button));
            onView(withId(R.id.button)).perform(click());

            Activity activity_4 = getInstrumentation().waitForMonitorWithTimeout(monitor,3000);
            Assert.assertNotNull(activity_4);
            Assert.assertEquals("Activity4",activity_4.getLocalClassName());
            activity_4.finish();
        }

        @After
        public void tearDown() throws Exception
        {
            activity3 = null;
        }

}