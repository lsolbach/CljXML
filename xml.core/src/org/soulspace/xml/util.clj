;
;   Copyright (c) Ludger Solbach. All rights reserved.
;   The use and distribution terms for this software are covered by the
;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;   which can be found in the file license.txt at the root of this distribution.
;   By using this software in any fashion, you are agreeing to be bound by
;   the terms of this license.
;   You must not remove this notice, or any other, from this software.
;
(ns org.soulspace.xml.util
  (:require [clojure.data.xml :as xml]
            [clojure.java.io :as io])
  (:import [org.xml.sax InputSource]))

(def invalid-chars
  #"[^\t\r\n\u0020-\uD7FF\uE000-\uFFFD\uD800\uDC00-\uDBFF\uDFFF]")

(defn invalid-xml-chars?
  "Checks if the xml string 's' contains invalid XML characters."
  [s]
  (re-matches invalid-chars s))

(defn string-input-source
  "Converts a string to a sax input source."
  [s]
  (InputSource. (java.io.StringReader. s)))

; TODO check advantages over emit-str (encoding via opts?)
(defn emit-as-str
  "Emits the Element to String and returns it"
  [e & {:as opts}]
  (let [^java.io.StringWriter sw (java.io.StringWriter.)]
    (xml/emit e sw opts)
    (.toString sw)))

; TODO check advantages over indent-str (encoding via opts?)
(defn indent-as-str
  "Emits the XML and indents the result.  Writes the results to a String and returns it"
  [e & {:as opts}]
  (let [^java.io.StringWriter sw (java.io.StringWriter.)]
    (xml/indent e sw opts)
    (.toString sw)))
