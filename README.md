# OSCRadio
> The behaviour is not guaranteed in some network settings, while wired internet connection is highly recommended.

SuperCollider Quark to connecting the [OSCHUB](http://oschub.asia/).

## Installation

Inside your SuperCollider editor, with iterpreter booted, run this line to install the quark:

```
Quarks.install("https://github.com/seansay/OSCRadio.git")
```

## Connect the OSCHub

Create a server and then start passing to the class!

```
// Connecting the hub
~oschub = Server.new(\OSCHub, NetAddr.new("oschub.asia", 57120))
OSCRadio.start(~oschub)

```

Then you should see a chat window, after click the top botton you should be able to send message with other performers.

## Make sound (together)

First you can send you your synthdef to the hub:

```
SynthDef(\sine, {|freq=400, amp=0.2, pan=0, dur=10|
  var env, envgen;
  var sig = SinOsc.ar(freq, mul:amp);
  env = Env.sine(dur:1);
  envgen = EnvGen.kr(env, doneAction: Done.freeSelf, timeScale: dur);
  sig = Pan2.ar(sig, pan);
  Out.ar(0, sig*envgen);
}).doSend(~oschub);

```

Then you just send message to the hub server, and everyone inside the hub will get your sound (including yourself!)

```
~oschub.sendMsg('/s_new', \sine, 2000, 0, 1, \freq, 60.midicps);
```
