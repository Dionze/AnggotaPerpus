package com.si.anggotaperpus;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import android.os.*;
import android.graphics.*;
import android.app.ActionBar.LayoutParams;
import android.content.DialogInterface;

public class MainActivity extends Activity implements OnClickListener {
	
	AnggotaActivity anggotaActivity = new AnggotaActivity();
	TableLayout tableLayout;
	Button buttonTambahAnggota;
	ArrayList<Button>buttonEdit 	= new ArrayList<Button>();
	ArrayList<Button>buttonDelete 	= new ArrayList<Button>();
	JSONArray arrayAnggota;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	// Jika SDK Android diatas API Ver.9
		if (android.os.Build.VERSION.SDK_INT > 9) {
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
		.permitAll().build();
		StrictMode.setThreadPolicy(policy);
	}
	// Mendapatkan data widget dari XML Activity melalui ID
		tableLayout 		= (TableLayout) findViewById(R.id.tableAnggota);
		buttonTambahAnggota 	= (Button) findViewById(R.id.buttonTambahAnggota);
		buttonTambahAnggota.setOnClickListener(this);
		
	//Menambah baris untuk tabel
		TableRow barisTabel = new TableRow(this);
		barisTabel.setBackgroundColor(Color.CYAN);
		
	// Menambahkan tampilan teks untuk judul pada tabel
		TextView viewHeaderID 			= new TextView(this);
		TextView viewHeaderUsername 	= new TextView(this);
		TextView viewHeaderNama 		= new TextView(this);
		TextView viewHeaderGender 		= new TextView(this);
		TextView viewHeaderTelepon 		= new TextView(this);
		TextView viewHeaderAlamat 		= new TextView(this);
		TextView viewHeaderEmail 		= new TextView(this);
		TextView viewHeaderPassword 	= new TextView(this);
		TextView viewHeaderAction 		= new TextView(this);
		
		viewHeaderID.setText			("ID");
		viewHeaderUsername.setText		("Username");
		viewHeaderNama.setText			("Nama");
		viewHeaderGender.setText		("Gender");
		viewHeaderTelepon.setText		("Telepon");
		viewHeaderAlamat.setText		("Alamat");
		viewHeaderEmail.setText			("Email");
		viewHeaderPassword.setText		("Password");
		viewHeaderAction.setText		("Action");
		
		viewHeaderID.setPadding				(5, 1, 5, 1);
		viewHeaderUsername.setPadding		(5, 1, 5, 1);
		viewHeaderNama.setPadding			(5, 1, 5, 1);
		viewHeaderGender.setPadding			(5, 1, 5, 1);
		viewHeaderTelepon.setPadding		(5, 1, 5, 1);
		viewHeaderAlamat.setPadding			(5, 1, 5, 1);
		viewHeaderEmail.setPadding			(5, 1, 5, 1);
		viewHeaderPassword.setPadding		(5, 1, 5, 1);
		viewHeaderAction.setPadding			(5, 1, 5, 1);
		
	// Menampilkan tampilan TextView ke dalam tabel
		barisTabel.addView(viewHeaderID);
		barisTabel.addView(viewHeaderUsername);
		barisTabel.addView(viewHeaderNama);
		barisTabel.addView(viewHeaderGender);
		barisTabel.addView(viewHeaderTelepon);
		barisTabel.addView(viewHeaderAlamat);
		barisTabel.addView(viewHeaderEmail);
		barisTabel.addView(viewHeaderPassword);
		barisTabel.addView(viewHeaderAction);
		
	// Menyusun ukuran dari tabel
		tableLayout.addView(barisTabel, new
		TableLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		try {
			
	// Mengubah data dari BiodataActivity yang berupa String menjadi array
		arrayAnggota = new JSONArray(anggotaActivity.tampilAnggota());
		for (int i = 0; i < arrayAnggota.length(); i++) {
		JSONObject jsonChildNode 	= arrayAnggota.getJSONObject(i);
		String username 			= jsonChildNode.optString	("username");
		String nama_anggota 		= jsonChildNode.optString	("nama_anggota");
		String gender 				= jsonChildNode.optString	("gender");
		String no_telp 				= jsonChildNode.optString	("no_telp");
		String alamat 				= jsonChildNode.optString	("alamat");
		String email 				= jsonChildNode.optString	("email");
		String password 			= jsonChildNode.optString	("password");
		String id_anggota 			= jsonChildNode.optString	("id_anggota");
		
		System.out.println("Username : " 	+ username );
		System.out.println("Nama : " 		+ nama_anggota);
		System.out.println("Gender : " 		+ gender);
		System.out.println("Telepon : " 	+ no_telp);
		System.out.println("Alamat : " 		+ alamat);
		System.out.println("Email : " 		+ email);
		System.out.println("Password : " 	+ password);
		System.out.println("ID : " 			+ id_anggota);
		barisTabel = new TableRow(this);
		
	// Memberi warna pada baris tabel
		if (i % 2 == 0) {
		barisTabel.setBackgroundColor(Color.LTGRAY);
		}
		
		TextView viewID = new TextView(this);
		viewID.setText(id_anggota);
		viewID.setPadding(5, 1, 5, 1);
		barisTabel.addView(viewID);
		
		TextView viewUsername = new TextView(this);
		viewUsername.setText(username);
		viewUsername.setPadding(5, 1, 5, 1);
		barisTabel.addView(viewUsername);
		
		TextView viewNama = new TextView(this);
		viewNama.setText(nama_anggota);
		viewNama.setPadding(5, 1, 5, 1);
		barisTabel.addView(viewNama);
		
		TextView viewGender = new TextView(this);
		viewGender.setText(gender);
		viewGender.setPadding(5, 1, 5, 1);
		barisTabel.addView(viewGender);
		
		TextView viewTelepon = new TextView(this);
		viewTelepon.setText(no_telp);
		viewTelepon.setPadding(5, 1, 5, 1);
		barisTabel.addView(viewTelepon);
		
		TextView viewAlamat = new TextView(this);
		viewAlamat.setText(alamat);
		viewAlamat.setPadding(5, 1, 5, 1);
		barisTabel.addView(viewAlamat);
		
		TextView viewEmail = new TextView(this);
		viewEmail.setText(email);
		viewEmail.setPadding(5, 1, 5, 1);
		barisTabel.addView(viewEmail);
		
		TextView viewPassword = new TextView(this);
		viewPassword.setText(password);
		viewPassword.setPadding(5, 1, 5, 1);
		barisTabel.addView(viewPassword);	
		
	// Menambahkan button Edit
		buttonEdit.add(i, new Button(this));
		buttonEdit.get(i).setId(Integer.parseInt(id_anggota));
		buttonEdit.get(i).setTag("Edit");
		buttonEdit.get(i).setText("Edit");
		buttonEdit.get(i).setOnClickListener(this);
		barisTabel.addView(buttonEdit.get(i));
		
	// Menambahkan tombol Delete
		buttonDelete.add(i, new Button(this));
		buttonDelete.get(i).setId(Integer.parseInt(id_anggota));
		buttonDelete.get(i).setTag("Delete");
		buttonDelete.get(i).setText("Delete");
		buttonDelete.get(i).setOnClickListener(this);
		barisTabel.addView(buttonDelete.get(i));
		
		tableLayout.addView(barisTabel, new TableLayout.LayoutParams
				(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		}
	}
	catch (JSONException e) {
		e.printStackTrace();
	}
	}
public void onClick (View view) {
	if (view.getId() == R.id.buttonTambahAnggota) {
		tambahAnggota();
	}else{
		for (int i= 0; i < buttonEdit.size(); i++) {
	// Jika ingin mengedit data pada biodata
		if (view.getId() == buttonEdit.get(i).getId() &&
		view.getTag().toString().trim().equals("Edit")) {
		Toast.makeText(MainActivity.this, "Edit : " + buttonEdit.get(i).getId(),
		Toast.LENGTH_SHORT).show();
		int id_anggota = buttonEdit.get(i).getId();
		getAnggotaByID(id_anggota);
		}
	// Menghapus data di Tabel
		else if (view.getId() == buttonDelete.get(i).getId() &&
		view.getTag().toString().trim().equals("Delete")){
		Toast.makeText(MainActivity.this, "Delete : " +
		buttonDelete.get(i).getId(), Toast.LENGTH_SHORT).show();
		int id_anggota = buttonDelete.get(i).getId();
		deleteAnggota(id_anggota);
		}
		}
	}
}

public void deleteAnggota (int id_anggota) {
	anggotaActivity.deleteAnggota(id_anggota);
		finish();
		startActivity(getIntent());
	}
	// Mendapatkan Biodata melalui ID
public void getAnggotaByID (int id_anggota) {
	String usernameEdit 	= null,
		   nama_anggotaEdit = null, 
		   genderEdit 		= null, 
		   no_telpEdit 		= null, 
		   alamatEdit 		= null, 
		   emailEdit 		= null, 
		   passwordEdit		= null; 
		JSONArray arrayPersonal;
		try {
			arrayPersonal = new JSONArray(anggotaActivity.getAnggotaById(id_anggota));
			for (int i = 0; i < arrayPersonal.length(); i++) {
				JSONObject jsonChildNode = arrayPersonal.getJSONObject(i);
				usernameEdit 	 = jsonChildNode.optString	("username");
				nama_anggotaEdit = jsonChildNode.optString	("nama_anggota");
				genderEdit 		 = jsonChildNode.optString	("gender");
				no_telpEdit      = jsonChildNode.optString	("no_telp");
				alamatEdit 		 = jsonChildNode.optString	("alamat");
				emailEdit 		 = jsonChildNode.optString	("email");
				passwordEdit 	 = jsonChildNode.optString	("password");
			}
		}
		catch (JSONException e) {
			e.printStackTrace();
		}
		LinearLayout layoutInput = new LinearLayout(this);
		layoutInput.setOrientation(LinearLayout.VERTICAL);
		
	// Membuat id tersembunyi pada AlertDialog
		final TextView viewId = new TextView(this);
		viewId.setText(String.valueOf(id_anggota));
		viewId.setTextColor(Color.TRANSPARENT);
		layoutInput.addView(viewId);
		
		final EditText editUsername = new EditText(this);
		editUsername.setText(usernameEdit);
		layoutInput.addView(editUsername);
		
		final EditText editNama = new EditText(this);
		editNama.setText(nama_anggotaEdit);
		layoutInput.addView(editNama);
		
		final EditText editGender = new EditText(this);
		editGender.setText(genderEdit);
		layoutInput.addView(editGender);
		
		final EditText editTelepon = new EditText(this);
		editTelepon.setText(no_telpEdit);
		layoutInput.addView(editTelepon);
		
		final EditText editAlamat = new EditText(this);
		editAlamat.setText(alamatEdit);
		layoutInput.addView(editAlamat);
		
		final EditText editEmail = new EditText(this);
		editEmail.setText(emailEdit);
		layoutInput.addView(editEmail);
		
		final EditText editPassword = new EditText(this);
		editPassword.setText(passwordEdit);
		layoutInput.addView(editPassword);
		
	// Membuat AlertDialog untuk mengubah data di Biodata
		AlertDialog.Builder builderEditAnggota = new AlertDialog.Builder(this);
		
	//builderEditBiodata.setIcon(R.drawable.webse);
		builderEditAnggota.setTitle("Update Anggota");
		builderEditAnggota.setView(layoutInput);
		builderEditAnggota.setPositiveButton("Update", new DialogInterface.OnClickListener()
		{
			
@Override
public void onClick(DialogInterface dialog, int which) {
	String username 	= editUsername.getText().toString();
	String nama_anggota = editNama.getText().toString();
	String gender 		= editGender.getText().toString();
	String no_telp 		= editTelepon.getText().toString();
	String alamat 		= editAlamat.getText().toString();
	String email 		= editEmail.getText().toString();
	String password 	= editPassword.getText().toString();
	
	System.out.println(	"Username : " + username + 
						"Nama : " 	  + nama_anggota +
						"Gender :"    + gender +
						"Telepon : "  + no_telp + 
						"Alamat :"    + alamat +
						"Email : " 	  + email + 
						"Password : " + password);
	String laporan = anggotaActivity.updateAnggota(viewId.getText().toString(),
		editUsername.getText().toString(), 
		editNama.getText().toString(),
		editGender.getText().toString(),
		editTelepon.getText().toString(),
		editAlamat.getText().toString(),
		editEmail.getText().toString(),
		editPassword.getText().toString());
	Toast.makeText(MainActivity.this, laporan, Toast.LENGTH_SHORT).show();
	finish();
	startActivity(getIntent());
	}
	});
		
	// Jika tidak ingin mengubah data pada Biodata
		builderEditAnggota.setNegativeButton("Cancel", new DialogInterface.OnClickListener()
		{
			
@Override
public void onClick(DialogInterface dialog, int which) {
	dialog.cancel();
	}
});
		builderEditAnggota.show();
}
public void tambahAnggota() {
	LinearLayout layoutInput = new LinearLayout(this);
	layoutInput.setOrientation(LinearLayout.VERTICAL);
	
	final EditText editUsername = new EditText(this);
	editUsername.setHint("Username");
	layoutInput.addView(editUsername);
	
	final EditText editNama = new EditText(this);
	editNama.setHint("Nama");
	layoutInput.addView(editNama);
	
	final EditText editGender = new EditText(this);
	editGender.setHint("Gender");
	layoutInput.addView(editGender);
	
	final EditText editTelepon = new EditText(this);
	editTelepon.setHint("Telepon");
	layoutInput.addView(editTelepon);
	
	final EditText editAlamat = new EditText(this);
	editAlamat.setHint("Alamat");
	layoutInput.addView(editAlamat);
	
	final EditText editEmail = new EditText(this);
	editEmail.setHint("Email");
	layoutInput.addView(editEmail);
	
	final EditText editPassword = new EditText(this);
	editPassword.setHint("Password");
	layoutInput.addView(editPassword);
	
// Membuat AlertDialog untuk menambahkan data pada Biodata
	AlertDialog.Builder builderInsertAnggota= new AlertDialog.Builder(this);
	
//builderInsertBiodata.setIcon(R.drawable.webse);
	builderInsertAnggota.setTitle("Insert Anggota");
	builderInsertAnggota.setView(layoutInput);
	builderInsertAnggota.setPositiveButton("Insert", new
	DialogInterface.OnClickListener() {
		
@Override
public void onClick(DialogInterface dialog, int which) {
	String username 	= editUsername.getText().toString();
	String nama_anggota = editNama.getText().toString();
	String gender 		= editGender.getText().toString();
	String no_telp 		= editTelepon.getText().toString();
	String alamat 		= editAlamat.getText().toString();
	String email 		= editEmail.getText().toString();
	String password 	= editPassword.getText().toString();
	
	System.out.println(	"Username : " + username + 
						"Nama : " 	  + nama_anggota +
						"Gender :"    + gender +
						"Telepon : "  + no_telp + 
						"Alamat :"    + alamat +
						"Email : " 	  + email + 
						"Password : " + password);
	
	String laporan = anggotaActivity.insertAnggota(username, 
												   nama_anggota,
												   gender,
												   no_telp,
												   alamat,
												   email,
												   password);
	Toast.makeText(MainActivity.this, laporan, Toast.LENGTH_SHORT).show();
	finish();
	startActivity(getIntent());
	}
});
	builderInsertAnggota.setNegativeButton("Cancel", new
	DialogInterface.OnClickListener() {
	@Override
	public void onClick(DialogInterface dialog, int which) {
	dialog.cancel();
	}
});
	builderInsertAnggota.show();
}
@Override
public boolean onCreateOptionsMenu(Menu menu) {
//Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.main, menu);
	return true;
	}
}
