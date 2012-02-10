# cljs-jquery-sparkline

wrap-js wrapper for jquery sparkline plugin for clojurescript

* Inserts sparkline plugin into your webpage if you require the namespace.

* Because it depends on and references dsann/dsann-cljs-jquery it also inserts jquery into your page

* in the right order - you get this for free thanks to clojurescripts require semantics

* That all.

* Does not define any additional api. 

* See examples for usage

## Usage

* clojars [cljs-jquery-sparkline "0.0.1"]

### externs

because this lib requires and inlines jquery.js please include 

please include [:externs "js/externs/jquery.1.7.1.js"] if using advanced mode compilation

hopefully this will not be required in the future


## License

Copyright (C) 2012 Dave Sann

Distributed under the Eclipse Public License, the same as Clojure.

