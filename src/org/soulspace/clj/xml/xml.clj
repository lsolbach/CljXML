(ns org.soulspace.clj.xml.xml
  (:use [clojure.data.xml])
  (:import [org.xml.sax InputSource]))

(defmacro deftag [ns-prefix tag & [attrs]]
  (let [xml-fn-name (symbol tag)] ; (symbol (str ns-prefix "-" tag))
    `(defn ~xml-fn-name [& [attrs# & content#]]
       (element (keyword (str ~ns-prefix ":" ~tag))
                (merge (or ~attrs {}) (or attrs# {}))
                (remove #(or (nil? %) (empty? %)) content#)))))

(defmacro defroottags [ns-prefix ns-uri root-tags]
  `(do ~@(map (fn [tag] `(deftag ~ns-prefix ~tag {(keyword (str "xmlns:" ~ns-prefix)) ~ns-uri})) root-tags)))

(defmacro deftags [ns-prefix tags]
  `(do ~@(map (fn [tag] `(deftag ~ns-prefix ~tag)) tags)))


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
