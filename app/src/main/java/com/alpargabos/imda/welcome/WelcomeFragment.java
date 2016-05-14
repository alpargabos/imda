package com.alpargabos.imda.welcome;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.alpargabos.imda.R;

import static android.view.View.GONE;

public class WelcomeFragment extends Fragment {

	@BindView(R.id.welcome_signup_button) Button signupButton;
	@BindView(R.id.welcome_login_button) Button loginButton;
	//	@BindView(R.id.welcome_texts) View textsContainer;

	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.fragment_welcome, container, false);
		ButterKnife.bind(this, root);

		setRetainInstance(true);
		return root;
	}

	public static WelcomeFragment newInstance() {
		return new WelcomeFragment();
	}

	@OnClick(R.id.welcome_login_button)
	void loginClicked() {
		//hide the unrelated views
		//		textsContainer.setVisibility(GONE);
		signupButton.setVisibility(GONE);

		//move up login view

	}

	@OnClick(R.id.welcome_signup_button)
	void signupClicked() {

	}
}
