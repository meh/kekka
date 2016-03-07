package meh.kekka;

import meh.expo.*;

import java.util.Random;

class Kekka : Zygote.IStart, Package.ILoad {
	lateinit private var _secret: String;

	override fun start(param: Zygote.Start.Parameter) {
		_secret = Expo.service(KeyboardService.name, KeyboardService);
	}

	override fun load(param: Package.Load.Parameter) {
		Expo.log("KEKKA/LOAD: ${param.name()}");
	}
}
