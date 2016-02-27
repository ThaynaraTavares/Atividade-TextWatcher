package com.example.projetotextwatcher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.protocol.HttpService;
import org.json.JSONArray;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.util.Log;

public class BuscarNomeAsyncTask extends AsyncTask<JSONObject, Void, Response> {

	@Override
	protected void onPreExecute() {
		System.out.println("Iniciando...");
	}

	@Override
	protected Response doInBackground(JSONObject... jsons) {

		Response response = null;

		JSONObject json = jsons[0];
		Log.i("EditTextListener", "doInBackground (JSON):" + json);

		try {

			response = HttpService.sendJSONPostResquest("get-byname", json);

		} catch (IOException e) {

			Log.e("EditTextListener", e.getMessage());
		}

		return response;
	}

	protected void onPostExecute(Response response) {

		String nome = null;
		List<String> name = new ArrayList<String>();
		int i = 0;

		try {

			JSONArray jsonArray = new JSONArray(response.getContentValue());

			while (jsonArray.getString(i) != null) {
				JSONObject jo = new JSONObject(jsonArray.getString(i));
				nome = jo.getString("fullName");
				name.add(nome);
				i++;
			}

		} catch (org.json.JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		MainActivity.Atualizar(name);

	}

}
