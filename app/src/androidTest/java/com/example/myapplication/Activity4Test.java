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

public class Activity4Test {

    @Rule
    public ActivityTestRule<Activity4> activity4Rule = new ActivityTestRule<Activity4>(Activity4.class);
    private Activity4 activity4 = null;
    private LastActivity lastActivity = null;
    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(LastActivity.class.getName(),null,false);

        @Before
        public void setUp() throws Exception
        {
            activity4 = activity4Rule.getActivity();
        }

        @Test
        public void testActivity()
        {
            View view = activity4.findViewById(R.id.textView6);
            Assert.assertNotNull(view);
            Assert.assertEquals(view,activity4.findViewById(R.id.textView6));
        }

            @Test
            public void testButton()
            {
                Assert.assertNotNull(activity4.findViewById(R.id.button));
                onView(withId(R.id.button)).perform(click());

                Activity activity_last = getInstrumentation().waitForMonitorWithTimeout(monitor,3000);
                Assert.assertNotNull(activity_last);
                Assert.assertEquals("LastActivity",activity_last.getLocalClassName());
                activity_last.finish();
            }


            @After
            public void tearDown() throws Exception
            {
                activity4 = null;
            }

}