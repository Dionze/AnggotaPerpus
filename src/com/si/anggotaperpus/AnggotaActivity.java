package com.si.anggotaperpus;

import com.si.anggotaperpus.KoneksiActivity;

public class AnggotaActivity extends KoneksiActivity {
// sourcecode untuk URL ->URL menggunakan IP address default eclipse
	String URL = "http://192.168.8.101/Perpustakaan/server.php";
	String url = "";
	String response = "";
//menampilkan Buku dari database
public String tampilAnggota() {
	try{
		url = URL + "?operasi_anggota=view";
		System.out.println("URL Tampil Anggota : " + url);
		response = call(url);
	}
		catch(Exception e) {
	}
		return response;
	}
//memasukan biodata baru ke dlama database
public String insertAnggota(String username,
							String nama_anggota,
							String gender,
							String no_telp,
							String alamat,
							String email,
							String password) {
	try{
		url = URL + "?operasi_anggota=insert&username=" 	+ username + 
										   "&nama_anggota=" + nama_anggota + 
										   "&gender=" 		+ gender + 
										   "&no_telp=" 		+ no_telp + 
										   "&alamat=" 		+ alamat + 
										   "&email=" 		+ email + 
										   "&password=" 	+ password;
		System.out.println("URL Insert Anggota : " + url);
		response = call(url);
		}
		catch (Exception e){
		}
		return response;
	}
//melihat biodata berdasarkan ID
public String getAnggotaById (int id_anggota) {
	try{
		url=URL + "?operasi_anggota=get_anggota_by_id&id_anggota=" + id_anggota;
		System.out.println("URL Insert Anggota : " + url);
		response = call(url);
		}
		catch(Exception e) {
		}
		return response;
	}
//mengubah isi biodata
public String updateAnggota(String id_anggota,
							String username,
							String nama_anggota,
							String gender,
							String no_telp,
							String alamat,
							String email,
							String password) {
	try{
		url=URL + "?operasi_anggota=update&id_anggota="		+ id_anggota + 
										 "&username=" 		+ username + 
										 "&nama_anggota=" 	+ nama_anggota + 
										 "&gender=" 		+ gender + 
										 "&no_telp=" 		+ no_telp + 
										 "&alamat=" 		+ alamat + 
										 "&email=" 			+ email + 
										 "&password=" 		+ password;
		System.out.println("URL Update Anggota : " + url);
		response = call(url);
		}
		catch(Exception e){
		}
		return response;
	}
//coding hapus
public String deleteAnggota (int id_anggota) {
	try{
		url = URL + "?operasi_anggota=delete&id_anggota=" + id_anggota;
		System.out.println("URL Hapus Anggota : " + url);
		response = call(url);
		}
		catch(Exception e){
		}
		return response;
	}
}