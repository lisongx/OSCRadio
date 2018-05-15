# OSCRadio
> The behaviour is not guaranteed in some network settings, while wired internet connection is highly recommended.

SuperCollider Quark to connecting the [OSCHUB](http://oschub.asia/).

## Installation


```
// Connecting the hub
~hub = Server.new(\OSCHub, NetAddr.new("oschub.asia", 57120))
OSCRadio.start(~hub)

```
