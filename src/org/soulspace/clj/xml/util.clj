;
;   Copyright (c) Ludger Solbach. All rights reserved.
;   The use and distribution terms for this software are covered by the
;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;   which can be found in the file license.txt at the root of this distribution.
;   By using this software in any fashion, you are agreeing to be bound by
;   the terms of this license.
;   You must not remove this notice, or any other, from this software.
;
(ns org.soulspace.clj.xml.util
  (:use [clojure.data.xml]
        [clojure.java.io])
  (:import [org.xml.sax InputSource]))

(defn string-input-source [s]
  "Converts a string to a sax input source"
  (InputSource. (java.io.StringReader. s)))

; TODO check advantages over emit-str (encoding via opts?)
(defn emit-as-str
  "Emits the Element to String and returns it"
  [e & {:as opts}]
  (let [^java.io.StringWriter sw (java.io.StringWriter.)]
    (emit e sw opts)
    (.toString sw)))

; TODO check advantages over indent-str (encoding via opts?)
(defn indent-as-str
  "Emits the XML and indents the result.  Writes the results to a String and returns it"
  [e & {:as opts}]
  (let [^java.io.StringWriter sw (java.io.StringWriter.)]
    (indent e sw opts)
    (.toString sw)))

