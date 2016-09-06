package com.francis.zhihudaily_android.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author taoc @ Zhihu Inc.
 * @since 09-05-2016
 *
 *
 * 本地数据库的帮助类
 */
public class DatabaseHelper extends SQLiteOpenHelper{

	public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase sqLiteDatabase) {
		sqLiteDatabase.execSQL("create table if not exists LatestPostsid integer primary key,title text not null,type integer not null,img_url text not null,date integer not null");
		sqLiteDatabase.execSQL("create table if not exists Contents(id integer primary key,date integer not null,content text not null)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
		switch (i){
			case 1:

			case 2:
				sqLiteDatabase.execSQL("create table if not exists Contents(id integer primary key,date integer not null,content text not null)");
		}
	}
}
