package com.alpargabos.imda.welcome;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.alpargabos.imda.R;

public class WelcomeFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.fragment_welcome, container, false);
		setRetainInstance(true);

		return root;
	}

	public static WelcomeFragment newInstance() {
		return new WelcomeFragment();
	}
}
