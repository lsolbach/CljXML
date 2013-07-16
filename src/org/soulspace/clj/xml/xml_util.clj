(ns org.soulspace.clj.xml.xml-util
  (:use [clojure.data.xml])
  (:import [org.xml.sax InputSource]))

; TODO check advantages over emit-str (opts?)
(defn emit-as-str
  "Emits the Element to String and returns it"
  [e & {:as opts}]
  (let [^java.io.StringWriter sw (java.io.StringWriter.)]
    (emit e sw opts)
    (.toString sw)))
  
; TODO check advantages over indent-str (opts?)
(defn indent-as-str
  "Emits the XML and indents the result.  Writes the results to a String and returns it"
  [e & {:as opts}]
  (let [^java.io.StringWriter sw (java.io.StringWriter.)]
    (indent e sw opts)
    (.toString sw)))

(defn string-input-source [s]
  "Converts a string to a sax input source"
  (InputSource. (java.io.StringReader. s)))
