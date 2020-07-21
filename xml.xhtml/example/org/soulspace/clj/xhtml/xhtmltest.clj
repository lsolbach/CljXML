(ns org.soulspace.clj.xhtml.xhtmltest
  (:require [org.soulspace.clj.xhtml.xhtml-dsl :as x])
  (:use [clojure.data.xml]))

(defn html-page []
  (x/html
    {}
    (x/head {} (x/title {} "Mein Titel"))
    (x/body
      {}
      (x/h1 {} "Hello World")
      (x/p
        {}
        "Dieser Text ist ein Blindtext ohne tiefere Bedeutung.
 Mit diesem Blindtext soll nur etwas Text erzeugt werden,
 sodass in einem Layout nicht nur weiße Flächen erscheinen.
 Außerdem können damit zum Beispiel verschiedene Schriftarten
 präsentiert werden oder die Auswirkungen von verschiedenen
 Satzarten. Damit kann man dann ein Layout besser präsentieren.
 Ich könnte jetzt natürlich noch viel, viel mehr
 Text erzeugen, aber langsam bin ich der Meinung, dass die
 Menge an Text für diese Zwecke völlig ausreichend ist.
 Mittlerweile sind es doch schon mehr als 3-4 Zeilen, selbst
 bei einem etwas breiteren Satzspiegel. So, gut jetzt. Es
 reicht mir nun."))))

(defn print-xml [f]
  (println (emit-str (f))))
