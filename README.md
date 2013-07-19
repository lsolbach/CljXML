CljXHtmlLibrary
===============
The CljXHtmlLibrary provides a DSL for the programmatic generation of XHtml files.

Documentation
-------------
Example:

```
(ns org.soulspace.clj.xhtml.xhtmltest
  (:require [org.soulspace.clj.xhtml.xhtml-dsl :as x])
  (:use [clojure.data.xml]))

(emit-str
  (x/html {}
    (x/head {} (x/title {} "Mein Titel"))
    (x/body {}
      (x/h1 {} "Hello World")
      (x/p {}
        (str 
          "Dieser Text ist ein Blindtext ohne tiefere Bedeutung. "
          "Mit diesem Blindtext soll nur etwas Text erzeugt werden, sodass in einem Layout nicht nur weiße Flächen erscheinen. "
          "Außerdem können damit zum Beispiel verschiedene Schriftarten präsentiert werden oder die Auswirkungen von verschiedenen Satzarten. "
          "Damit kann man dann ein Layout besser präsentieren. "
          "Ich könnte jetzt natürlich noch viel, viel mehr Text erzeugen. "
          "Aber langsam bin ich der Meinung, dass die Menge an Text für diese Zwecke völlig ausreichend ist. "
          "Mittlerweile sind es doch schon mehr als 3-4 Zeilen, selbst bei einem etwas breiteren Satzspiegel. "
          "So, gut jetzt. Es reicht mir nun. ")))))
```

Running the code above yields the following XHTML (formatted here for better readability).

```
<?xml version=\"1.0\" encoding=\"UTF-8\"?>
<xhtml:html xmlns:xhtml=\"http://www.w3.org/1999/xhtml\">
	<xhtml:head>
		<xhtml:title>Mein Titel</xhtml:title>
	</xhtml:head>
	<xhtml:body>
		<xhtml:h1>Hello World</xhtml:h1>
		<xhtml:p>
			Dieser Text ist ein Blindtext ohne tiefere Bedeutung.
			Mit diesem Blindtext soll nur etwas Text erzeugt werden, sodass in einem Layout nicht nur weiße Flächen erscheinen.
			Außerdem können damit zum Beispiel verschiedene Schriftarten präsentiert werden oder die Auswirkungen von verschiedenen Satzarten.
			Damit kann man dann ein Layout besser präsentieren.
			Ich könnte jetzt natürlich noch viel, viel mehr Text erzeugen.
			Aber langsam bin ich der Meinung, dass die Menge an Text für diese Zwecke völlig ausreichend ist.
			Mittlerweile sind es doch schon mehr als 3-4 Zeilen, selbst bei einem etwas breiteren Satzspiegel.
			So, gut jetzt. Es reicht mir nun.
		</xhtml:p>
	</xhtml:body>
</xhtml:html>
```

Author/Project Lead
-------------------
Ludger Solbach

Copyright
---------
© 2013- Ludger Solbach

License
-------
[Eclipse Public License 1.0] (http://www.eclipse.org/legal/epl-v10.html "EPL 1.0")

Code Repository
---------------
[https://github.com/lsolbach/CljXHtmlLibrary] (https://github.com/lsolbach/CljXHtmlLibrary)

Dependencies
------------
* clojure >= 1.3.0
* clojure.data.xml >= 0.0.6
* CljXmlLibrary >= 0.2.0

History
-------

Version 0.1.0 (17.07.2013)
--------------------------
* initial git import
* initial github import
