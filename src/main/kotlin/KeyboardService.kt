package meh.kekka;

import meh.expo.*;

import android.app.Service;
import android.content.Context;
import android.os.IBinder;

import java.lang.reflect.Field;

object KeyboardService : IKeyboardService.Stub(), SystemService {
	val name = "kekka.keyboard";

	lateinit private var _secret:  String;
	lateinit private var _context: Context;
	lateinit private var _loader:  ClassLoader;

	private var _client: IKeyboardService? = null;

	override fun register(secret: String, context: Context, loader: ClassLoader) {
		_secret  = secret;
		_context = context;
		_loader  = loader;

		Expo.log("KEKKA/SERVICE: registered ${secret}");
	}

	fun client(): IKeyboardService {
		if (_client == null) {
			_client = Expo.service<IKeyboardService>(name);
		}

		return _client!!
	}
}
