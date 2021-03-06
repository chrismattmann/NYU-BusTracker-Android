package com.nyubustracker.test;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.view.View;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;

import com.nyubustracker.R;
import com.nyubustracker.activities.MainActivity;
import com.nyubustracker.helpers.BusManager;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
    Activity mActivity;

    TextView startText;
    String startTextCorrect;

    TextView endText;
    String endTextCorrect;

    Button callSafeRideButton;
    String safeRideTextCorrect;

    Button startButton;
    Button endButton;

    Button timeButton;
    TextSwitcher nextTime;
    TextView nextRoute;
    TextView nextBus;

    BusManager busManager;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mActivity = this.getActivity();

        startText = (TextView) mActivity.findViewById(R.id.start);

        endText = (TextView) mActivity.findViewById(R.id.end);

        nextTime = (TextSwitcher) mActivity.findViewById(R.id.next_time);
        nextRoute = (TextView) mActivity.findViewById(R.id.next_route);
        nextBus = (TextView) mActivity.findViewById(R.id.next_bus);

        callSafeRideButton = (Button) mActivity.findViewById(R.id.safe_ride_button);

        startButton = (Button) mActivity.findViewById(R.id.start_stop);
        endButton = (Button) mActivity.findViewById(R.id.end_stop);

        startTextCorrect = mActivity.getString(R.string.start);
        safeRideTextCorrect = mActivity.getString(R.string.call_safe_ride);
        endTextCorrect = mActivity.getString(R.string.end);

        busManager = BusManager.getBusManager();

    }

    public void testPreconditions() {
        assertNotNull(mActivity);
        assertNotNull(startText);
        assertNotNull(endText);
        assertNotNull(callSafeRideButton);
        assertNotNull(nextTime);
        assertNotNull(nextBus);
        assertNotNull(nextRoute);
        assertNotNull(timeButton);
    }

    public void testStartText() {
        assertEquals(startTextCorrect, (String) startText.getText());
    }

    public void testStartText_layout() {
        final View decorView = mActivity.getWindow().getDecorView();
        ViewAsserts.assertOnScreen(decorView, startText);
        assertTrue(View.VISIBLE == startText.getVisibility());
    }

    public void testEndText() {
        assertEquals(endTextCorrect, (String) endText.getText());
    }

    public void testEndText_layout() {
        final View decorView = mActivity.getWindow().getDecorView();
        ViewAsserts.assertOnScreen(decorView, endText);
        assertTrue(View.VISIBLE == endText.getVisibility());
    }

    public void testSafeRideButton_layout() {
        final View decorView = mActivity.getWindow().getDecorView();
        ViewAsserts.assertOnScreen(decorView, callSafeRideButton);
        assertTrue(View.GONE == callSafeRideButton.getVisibility());
    }

    public void testSafeRideButton_text() {
        assertEquals(safeRideTextCorrect, (String) callSafeRideButton.getText());
    }
}
