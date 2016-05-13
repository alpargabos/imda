package com.alpargabos.imda.welcome;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.alpargabos.imda.R;
import com.alpargabos.imda.utils.ActivityUtils;

public class WelcomeActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);

		WelcomeFragment fragment = (WelcomeFragment) getSupportFragmentManager().findFragmentById(R.id.welcome_container);
		if (fragment == null) {
			// Create the fragment
			fragment = WelcomeFragment.newInstance();
			ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), fragment, R.id.welcome_container);
		}
	}
}
