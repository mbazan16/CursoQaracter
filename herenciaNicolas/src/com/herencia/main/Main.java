package com.herencia.main;

import com.herencia.data.Conejo;
import com.herencia.ln.GesConejo;

public class Main {

	public static void main(String[] args) {
		Conejo conejo = new Conejo(true, 1, true, true, true, 1);
		GesConejo service = GesConejo.init(conejo);

	}

}
