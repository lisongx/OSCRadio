+ SynthDef {

	doSend { |server, completionMsg|
		var bytes = this.asBytes;
		if (bytes.size < (65535 div: 4)) {
			server.sendMsg("/d_recv", bytes, completionMsg)
		} {
			if (server.isLocal) {
				"SynthDef % too big for sending. Retrying via synthdef file".format(name).warn;
				this.writeDefFile(synthDefDir);
				server.sendMsg("/d_load", synthDefDir ++ name ++ ".scsyndef", completionMsg)
			} {
				"SynthDef % too big for sending. May fail for remote server".format(name).warn;
				server.sendMsg("/d_recv", bytes, completionMsg)
			}
		}
	}

}
