package com.example.projetotextwatcher;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

public class BuscarNomeTextWatcher implements TextWatcher {
	@Override
	public void beforeTextChanged(CharSequence charSequence, int start,
			int count, int after) {
		Log.i("EditTExtListener", "beforeTextChanged: " + charSequence);
	}

	@Override
	public void onTextChanged(CharSequence charSequence, int start, int before,
			int count) {
		Log.i("EditTExtListener", "onTextChanged: " + charSequence);

	}

	public void afterTextChanged1(Editable editable) {
		Log.i("EditTExtListener", "afterTextChanged: " + editable);
	}

	@Override
	public void afterTextChanged(Editable s) {
		// TODO Auto-generated method stub

	}

}
